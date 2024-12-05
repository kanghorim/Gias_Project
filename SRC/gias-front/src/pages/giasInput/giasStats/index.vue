<template>
  <div class="contents contents--full">
    <div class="contents__wrap">
      <div class="sub-top">
        <h3>품질평가 결과</h3>
        <div class="sub-top__navi">
          <span class="icon-home navi--home"></span>
          <span>품질평가 결과</span>
        </div>
      </div>

      <div class="container">
        <!-- 통계 테이블 -->
        <table class="stats-table">
          <thead>
            <tr>
              <th class="header-domain">Domain</th>
              <th>Principle</th>
              <th>Standard</th>
              <th>세부평가코드</th>
              <th>세부평가사항</th>
              <th class="header-score" >세부평가점수</th>
              <th class="header-standard">Standard 평균<br />(5점척도)</th>
              <th class="header-principle">Principle 평균<br />(5점척도)</th>
              <th class="header-domain-average">Domain 평균<br />(Standard 기반 100점척도)</th>
            </tr>
          </thead>
          <tbody>
            <!-- 도메인별 반복 -->
            <template v-for="(domain, domainIndex) in transformedDomains" :key="domainIndex">
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
                        {{
                          calculateStandardAverage(standard.evaluations) || "평가중"
                        }}
                      </td>
                      <!-- Principle 평균 -->
                      <td v-if="standardIndex === 0 && evalIndex === 0" :rowspan="getPrincipleRowspan(principle)">
                        {{
                          calculatePrincipleAverage(principle.standards) || "평가중"
                        }}
                      </td>
                      <!-- Domain 평균 -->
                      <td v-if="principleIndex === 0 && standardIndex === 0 && evalIndex === 0" :rowspan="getDomainRowspan(domain)">
                        {{
                          calculateDomainAverage(domain.principles) || "평가중"
                        }}
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
import { computed, onMounted } from "vue";
import { useStore } from "vuex";

const store = useStore();

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

// 트리 데이터 생성
const transformedDomains = computed(() => transformToTreeStructure(domainList.value));

// rowspan 계산
const getDomainRowspan = (domain) => {
  return domain.principles.reduce((total, principle) => {
    return total + principle.standards.reduce((count, standard) => count + standard.evaluations.length, 0);
  }, 0);
};

const getPrincipleRowspan = (principle) => {
  return principle.standards.reduce((count, standard) => count + standard.evaluations.length, 0);
};

// 텍스트에 <br> 삽입하는 함수
const formatName = (name) => {
  if (!name) return "";
  return name.replace(/\(/g, "<br>("); // '(' 이전에 <br> 추가
};

// 데이터 조회
const getGridData = async () => {
  let param = {
    memberCode: checkUserId.value.memberCode,
  };
  await store.dispatch("grid/fetchDomain", param);
};

const getEvlData = async () => {
  let param = {
    memberCode: checkUserId.value.memberCode,
  };
  await store.dispatch("grid/fetchEvlOrg", param);
};

onMounted(async () => {
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

/* Domain 컬럼 헤더 색상 */
.header-domain {
  background-color: #004080;
  text-align: center;
  vertical-align: middle;
}

/* Score 컬럼 헤더 색상 */
.header-score {
  background-color: #008080;
  text-align: center;
  vertical-align: middle;
}

/* Standard 컬럼 헤더 색상 */
.header-standard {
  background-color: #808000;
  text-align: center;
  vertical-align: middle;
}

/* Principle 컬럼 헤더 색상 */
.header-principle {
  background-color: #800080;
  text-align: center;
  vertical-align: middle;
}

/* Domain 평균 컬럼 헤더 색상 */
.header-domain-average {
  background-color: #800000;
  text-align: center;
  vertical-align: middle;
}

</style>
