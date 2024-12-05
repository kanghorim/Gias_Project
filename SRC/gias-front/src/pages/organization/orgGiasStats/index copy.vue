<template>
  <div class="contents contents--full">
    <div class="contents__wrap">
      <div class="sub-top">
        <h3>{{ orgName }}의 품질평가 결과</h3>
        <div class="sub-top__navi">
          <span class="icon-home navi--home"></span>
          <span>{{ orgName }}의 품질평가 결과</span>
        </div>
      </div>

      <div class="container">
        <div class="excel-download-container">
          <button @click="downloadExcel" class="excel-download-btn">엑셀 다운로드</button>
        </div>
        <!-- 요약 테이블 -->
        <table class="summary-table">
          <thead>
            <tr>
              <th rowspan="2" @click="resetFilter">품질평가 총점</th>
              <template v-for="(domain, index) in transformedDomains" :key="`header-${index}`">
                <th @click="filterByDomain(domain.domainCode)">
                  {{ domain.domainName.split('(')[0] }}
                  <br />({{ domain.domainName.match(/\((.*?)\)/)?.[1] || '' }})
                </th>
              </template>
            </tr>
          </thead>
          <tbody>
            <tr>
              <!-- 품질평가 총점 -->
              <td :class="getScoreClass(calculateTotalAverage())">
                {{ calculateTotalAverage() || "평가중" }}
              </td>
              <!-- 각 도메인 점수 -->
              <template v-for="(domain, index) in transformedDomains" :key="`score-${index}`">
                <td :class="getScoreClass(calculateDomainAverage(domain.principles))">
                  {{ calculateDomainAverage(domain.principles) || "평가중" }}
                </td>
              </template>
            </tr>
          </tbody>
        </table>

        <br />

        <!-- 통계 테이블 -->
        <table class="stats-table">
          <thead>
            <tr>
              <th>Domain</th>
              <th>Principle</th>
              <th>Standard</th>
              <th>세부평가코드</th>
              <th>세부평가사항</th>
              <th>세부평가점수</th>
              <th>Standard 평균<br />(5점척도)</th>
              <th>Principle 평균<br />(5점척도)</th>
              <th>Domain 평균<br />(Standard 기반 100점척도)</th>
            </tr>
          </thead>
          <tbody>
            <template v-for="(domain, domainIndex) in filteredDomains" :key="domainIndex">
              <template v-for="(principle, principleIndex) in domain.principles" :key="principleIndex">
                <template v-for="(standard, standardIndex) in principle.standards" :key="standardIndex">
                  <template v-for="(evaluation, evalIndex) in standard.evaluations" :key="evalIndex">
                    <tr>
                      <!-- Domain -->
                      <td v-if="principleIndex === 0 && standardIndex === 0 && evalIndex === 0" 
                          :rowspan="getDomainRowspan(domain)" 
                          v-html="formatName(domain.domainName)">
                      </td>
                      <!-- Principle -->
                      <td v-if="standardIndex === 0 && evalIndex === 0" 
                          :rowspan="getPrincipleRowspan(principle)" 
                          v-html="formatName(principle.principleName)">
                      </td>
                      <!-- Standard -->
                      <td v-if="evalIndex === 0" 
                          :rowspan="standard.evaluations.length" 
                          v-html="formatName(standard.standardName)">
                      </td>
                      <!-- Evaluation -->
                      <td>{{ evaluation.evaluationCode }}</td>
                      <td>{{ evaluation.evaluationName }}</td>
                      <td>{{ evaluationScores[evaluation.evaluationCode] || "평가중" }}</td>
                      <!-- Standard 평균 -->
                      <td v-if="evalIndex === 0" :rowspan="standard.evaluations.length">
                        {{ calculateStandardAverage(standard.evaluations) || "평가중" }}
                      </td>
                      <!-- Principle 평균 -->
                      <td v-if="standardIndex === 0 && evalIndex === 0" :rowspan="getPrincipleRowspan(principle)">
                        {{ calculatePrincipleAverage(principle.standards) || "평가중" }}
                      </td>
                      <!-- Domain 평균 -->
                      <td v-if="principleIndex === 0 && standardIndex === 0 && evalIndex === 0" :rowspan="getDomainRowspan(domain)">
                        {{ calculateDomainAverage(domain.principles) || "평가중" }}
                      </td>
                    </tr>
                  </template>
                </template>
              </template>
            </template>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>


<script setup>
import { reactive, ref, computed, onMounted } from "vue";
import { useStore } from "vuex";
import { useRouter,useRoute } from 'vue-router'
import * as XLSX from "xlsx";
const store = useStore();
const route = useRoute()
// 필터링 상태
const selectedDomainCode = ref(null);

// 도메인 데이터 가져오기
const domainList = computed(() => store.state.grid.domainData);
const orgEvlList = computed(() => store.state.grid.evlOrgData);
const checkUserId = computed(() => store.state.temp.userInfo);

// 평가 점수 매핑
const evaluationScores = computed(() => {
  const scores = {};
  orgEvlList.value.forEach((item) => {
    if (item.evaluationCode && item.evaluationScore) {
      scores[item.evaluationCode] = item.evaluationScore;
    }
  });
  return scores;
});

// 필터링된 도메인 데이터
const filteredDomains = computed(() => {
  if (!selectedDomainCode.value) {
    return transformedDomains.value; // 필터가 없을 때 전체 데이터 반환
  }
  return transformedDomains.value.filter(
    (domain) => domain.domainCode === selectedDomainCode.value
  );
});

// 도메인 필터링 함수
const filterByDomain = (domainCode) => {
  selectedDomainCode.value = domainCode;
};

// 필터 초기화 함수
const resetFilter = () => {
  selectedDomainCode.value = null;
};


// 트리 구조 변환 함수
const transformToTreeStructure = (data) => {
  const groupedData = {};

  data.forEach((item) => {
    if (!groupedData[item.domainCode]) {
      groupedData[item.domainCode] = {
        domainCode: item.domainCode,
        domainName: item.domainName,
        principles: {},
      };
    }
    const domain = groupedData[item.domainCode];

    if (!domain.principles[item.principleCode]) {
      domain.principles[item.principleCode] = {
        principleCode: item.principleCode,
        principleName: item.principleName,
        standards: {},
      };
    }
    const principle = domain.principles[item.principleCode];

    if (!principle.standards[item.standardCode]) {
      principle.standards[item.standardCode] = {
        standardCode: item.standardCode,
        standardName: item.standardName,
        evaluations: [],
      };
    }
    const standard = principle.standards[item.standardCode];

    standard.evaluations.push({
      evaluationCode: item.evaluationCode,
      evaluationName: item.evaluationName,
    });
  });

  return Object.values(groupedData).map((domain) => ({
    ...domain,
    principles: Object.values(domain.principles).map((principle) => ({
      ...principle,
      standards: Object.values(principle.standards),
    })),
  }));
};

// Standard 평균 계산 함수
const calculateStandardAverage = (evaluations) => {
  const scores = evaluations.map(
    (evaluation) => parseFloat(evaluationScores.value[evaluation.evaluationCode]) || 0
  );
  const totalScore = scores.reduce((sum, score) => sum + score, 0);
  const count = scores.filter((score) => score > 0).length;
  return count > 0 ? (totalScore / count).toFixed(2) : null;
};

// Principle 평균 계산 함수
const calculatePrincipleAverage = (standards) => {
  const standardAverages = standards.map((standard) =>
    calculateStandardAverage(standard.evaluations)
  );
  const totalAverage = standardAverages.reduce((sum, avg) => sum + parseFloat(avg || 0), 0);
  const count = standardAverages.filter((avg) => avg !== null).length;
  return count > 0 ? (totalAverage / count).toFixed(2) : null;
};

// Domain 평균 계산 함수 (100점 척도)
// const calculateDomainAverage = (principles) => {
//   const principleAverages = principles.map((principle) =>
//     calculatePrincipleAverage(principle.standards)
//   );
//   const totalAverage = principleAverages.reduce((sum, avg) => sum + parseFloat(avg || 0), 0);
//   const count = principleAverages.filter((avg) => avg !== null).length;
//   const averageOnFive = count > 0 ? totalAverage / count : null;
//   return averageOnFive ? (averageOnFive * 20).toFixed(2) : null; // 100점 척도로 변환
// };

// Domain 평균 계산 함수 (100점 척도, Standard 기반)
const calculateDomainAverage = (principles) => {
  const standardAverages = principles.flatMap((principle) =>
    principle.standards.map((standard) => calculateStandardAverage(standard.evaluations))
  );

  const totalAverage = standardAverages.reduce((sum, avg) => sum + parseFloat(avg || 0), 0);
  const count = standardAverages.filter((avg) => avg !== null).length;
  const averageOnFive = count > 0 ? totalAverage / count : null;

  return averageOnFive ? (averageOnFive * 20).toFixed(2) : null; // 100점 척도로 변환
};

// 총 평균 계산 함수
const calculateTotalAverage = () => {
  const domainAverages = transformedDomains.value.map((domain) =>
    calculateDomainAverage(domain.principles)
  );
  const totalAverage = domainAverages.reduce((sum, avg) => sum + parseFloat(avg || 0), 0);
  const count = domainAverages.filter((avg) => avg !== null).length;
  return count > 0 ? (totalAverage / count).toFixed(2) : "평가중";
};

// 트리 데이터 생성
const transformedDomains = computed(() => transformToTreeStructure(domainList.value));

// rowspan 계산
const getDomainRowspan = (domain) => {
  return domain.principles.reduce((total, principle) => {
    return total + principle.standards.reduce((count, standard) => count + standard.evaluations.length, 0);
  }, 0);
};

//-> 이 코드는 html표 자체를 엑셀화 시킴 현재는 안씀
// const downloadExcel = () => {
//   // 테이블 데이터를 엑셀 파일로 변환
//   const table = document.querySelector(".stats-table"); // 통계 테이블 선택
//   const worksheet = XLSX.utils.table_to_sheet(table);

//   // 특정 컬럼 (예: 세부평가코드) 데이터를 텍스트로 강제 지정
//   const targetColumn = "D"; // 세부평가코드가 위치한 컬럼 (Excel 기준)

//   console.log("D열 데이터 확인:");
//   Object.keys(worksheet).forEach((cell) => {
//     if (cell.startsWith(targetColumn) && !cell.startsWith("D1")) { // 헤더 제외
//       const cellValue = worksheet[cell].v;
//       console.log(`셀: ${cell}, 값: ${cellValue}`);
//       if (typeof cellValue === "string" || typeof cellValue === "number") {
//         worksheet[cell].t = "s"; // 텍스트 형식 강제 지정
//       }
//     }
//   });

//   // 워크북 생성
//   const workbook = XLSX.utils.book_new();
//   XLSX.utils.book_append_sheet(workbook, worksheet, "Sheet1");

//   // 엑셀 파일 생성
//   const excelFile = XLSX.write(workbook, { bookType: "xlsx", type: "array" });

//   // 파일 다운로드
//   const blob = new Blob([excelFile], { type: "application/octet-stream" });
//   const url = URL.createObjectURL(blob);
//   const a = document.createElement("a");
//   a.href = url;
//   a.download = orgName.value + "의통계_테이블.xlsx";
//   document.body.appendChild(a);
//   a.click();
//   document.body.removeChild(a);
// };

// -> 이 코드는 api를 호출한 데이터를 기반으로 엑셀화 시킴
const downloadExcel = () => {
  // 1. 통계 테이블 데이터 준비
  const worksheetData1 = [];
  const merges = []; // 병합 정보를 저장

  // 헤더 정의
  const headers = [
    "Domain",
    "Principle",
    "Standard",
    "세부평가코드",
    "세부평가사항",
    "세부평가점수",
    "Standard 평균 (5점척도)",
    "Principle 평균 (5점척도)",
    "Domain 평균 (100점척도)",
  ];
  worksheetData1.push(headers);

  // 데이터 생성
  let currentRow = 1;
  transformedDomains.value.forEach((domain) => {
    const domainStartRow = currentRow;
    domain.principles.forEach((principle) => {
      const principleStartRow = currentRow;
      principle.standards.forEach((standard) => {
        const standardStartRow = currentRow;
        standard.evaluations.forEach((evaluation) => {
          const evaluationScore =
            evaluationScores.value[evaluation.evaluationCode] || "평가중";
          const row = [
            domain.domainName,
            principle.principleName,
            standard.standardName,
            evaluation.evaluationCode,
            evaluation.evaluationName,
            evaluationScore,
            calculateStandardAverage(standard.evaluations) || "평가중",
            calculatePrincipleAverage(principle.standards) || "평가중",
            calculateDomainAverage(domain.principles) || "평가중",
          ];
          worksheetData1.push(row);
          currentRow++;
        });

        if (standard.evaluations.length > 1) {
          merges.push({
            s: { r: standardStartRow, c: 2 },
            e: { r: currentRow - 1, c: 2 },
          });
          merges.push({
            s: { r: standardStartRow, c: 6 },
            e: { r: currentRow - 1, c: 6 },
          });
        }
      });

      if (currentRow - principleStartRow > 1) {
        merges.push({
          s: { r: principleStartRow, c: 1 },
          e: { r: currentRow - 1, c: 1 },
        });
        merges.push({
          s: { r: principleStartRow, c: 7 },
          e: { r: currentRow - 1, c: 7 },
        });
      }
    });

    if (currentRow - domainStartRow > 1) {
      merges.push({
        s: { r: domainStartRow, c: 0 },
        e: { r: currentRow - 1, c: 0 },
      });
      merges.push({
        s: { r: domainStartRow, c: 8 },
        e: { r: currentRow - 1, c: 8 },
      });
    }
  });

  // 2. 통계 워크시트 생성
  const worksheet1 = XLSX.utils.aoa_to_sheet(worksheetData1);
  worksheet1["!merges"] = merges;

  // 3. 요약 테이블 데이터 준비
  const worksheetData2 = [];
  const summaryHeaders = ["Category", "Score"];
  worksheetData2.push(summaryHeaders);

  // 요약 데이터 생성
  worksheetData2.push(["품질평가 총점", calculateTotalAverage() || "평가중"]);
  transformedDomains.value.forEach((domain) => {
    worksheetData2.push([
      domain.domainName,
      calculateDomainAverage(domain.principles) || "평가중",
    ]);
  });

  // 4. 요약 워크시트 생성
  const worksheet2 = XLSX.utils.aoa_to_sheet(worksheetData2);

  // 5. 워크북 생성 및 워크시트 추가
  const workbook = XLSX.utils.book_new();
  XLSX.utils.book_append_sheet(workbook, worksheet1, "통계_테이블");
  XLSX.utils.book_append_sheet(workbook, worksheet2, "요약_테이블");

  // 6. 엑셀 파일 생성 및 다운로드
  const excelFile = XLSX.write(workbook, { bookType: "xlsx", type: "array" });
  const blob = new Blob([excelFile], { type: "application/octet-stream" });
  const url = URL.createObjectURL(blob);
  const a = document.createElement("a");
  a.href = url;
  a.download = orgName.value + "_통계_요약_테이블.xlsx";
  document.body.appendChild(a);
  a.click();
  document.body.removeChild(a);
};





const getPrincipleRowspan = (principle) => {
  return principle.standards.reduce((count, standard) => count + standard.evaluations.length, 0);
};

// 텍스트에 <br> 삽입하는 함수
const formatName = (name) => {
  if (!name) return "";
  return name.replace(/\(/g, "<br>("); // '(' 이전에 <br> 추가
};

// 요약 그리드 점수별로 배경색 바꾸기
const getScoreClass = (score) => {
  if (!score || score === "평가중") return "score-pending";
  if (score >= 80) return "score-excellent";
  if (score >= 60) return "score-satisfactory";
  if (score >= 40) return "score-needs-improvement";
  if (score >= 20) return "score-weak";
  return "score-very-weak";
};

// 데이터 조회
const getGridData = async () => {
  let param = {
    memberCode: checkUserId.value.memberCode,
  };
  await store.dispatch("grid/fetchGiasAllData", param);
};

const getEvlData = async () => {
  let param = {
    organizationCode: orgCode.value,
  };
  await store.dispatch("grid/fetchAdminEvlOrg", param);
};

let orgName = ref('')
let orgCode = ref('')

onMounted(async () => {
  orgName.value = route.query?.organizationName || ''; 
  orgCode.value = route.query?.organizationCode || ''; 

  //console.log("기관이름" + orgName.value )
  await getGridData();
  await getEvlData();
});
</script>

<style>
.stats-table {
  width: 100%;
  border-collapse: collapse;
  text-align: left;
}

.stats-table th{
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center; /* 셀 텍스트 수평 중앙 정렬 */
  vertical-align: middle; /* 셀 텍스트 수직 중앙 정렬 */
  line-height: 1.6; /* 줄 간격 조정 */
}
.stats-table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: center; /* 셀 텍스트 수평 중앙 정렬 */
  vertical-align: middle; /* 셀 텍스트 수직 중앙 정렬 */
  line-height: 1.4;
}

.stats-table th {
  background-color: #f4f4f4;
  font-weight: bold;
  text-align: center;
  vertical-align: middle;
}

.stats-table td {
  vertical-align: top;
}

/* 요약 테이블 스타일 */

.summary-table {
  width: 100%;
  border-collapse: collapse;
  text-align: center;
  margin: 20px 0;
}

.summary-table th, .summary-table td {
  border: 1px solid #000;
  padding: 10px;
}

.summary-table .highlight {
  background-color: #00a651;
  color: #fff;
  font-weight: bold;
}


/* 점수에 따른 배경색 */
.score-excellent {
  background-color: #00a651; /* 매우 충족 - 초록 */
  color: white;
}

.score-satisfactory {
  background-color: #92d050; /* 충족 - 연두 */
  color: black;
}

.score-needs-improvement {
  background-color: #ffff00; /* 개선여지 - 노랑 */
  color: black;
}

.score-weak {
  background-color: #ffc000; /* 취약 - 주황 */
  color: black;
}

.score-very-weak {
  background-color: #ff0000; /* 매우 취약 - 빨강 */
  color: white;
}

.score-pending {
  background-color: #eaeaea; /* 평가중 - 회색 */
  color: black;
}

/**  통계 데이터의 헤더가 따라옴*/
.stats-table thead th {
  position: sticky; /* 스크롤에 따라 고정 */
  top: 0; /* 화면 상단부터의 거리 */
  z-index: 2; /* 겹치는 요소 위에 표시되도록 설정 */
  background-color: #f4f4f4; /* 배경색 (헤더가 읽기 쉽게) */
  text-align: center; /* 텍스트 가운데 정렬 */
  border-bottom: 2px solid #ddd; /* 헤더 하단 선 */
  padding: 8px;
  font-weight: bold;
  line-height: 1.6;
}

.excel-download-container {
  position: fixed; /* 고정 위치 설정 */
  top: 20px; /* 화면 상단에서 20px */
  right: 20px; /* 화면 오른쪽에서 20px */
  z-index: 1000; /* 다른 요소 위에 표시되도록 설정 */
}

.excel-download-btn {
  background-color: #007bff; /* 파란색 버튼 */
  color: white; /* 텍스트 색상 */
  border: none;
  border-radius: 5px;
  padding: 10px 15px;
  font-size: 14px;
  font-weight: bold;
  cursor: pointer;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  transition: background-color 0.2s;
}

.excel-download-btn:hover {
  background-color: #0056b3; /* 호버 시 색상 */
}


</style>



