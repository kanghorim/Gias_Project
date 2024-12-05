<template>
  <div class="contents contents--full">
    <div class="contents__wrap">
      <div class="sub-top">
        <h3>{{orgName}}의 품질평가 관리</h3>
        <div class="sub-top__navi">
          <span class="icon-home navi--home"></span>
          <span>기관관리 관리</span>
          <span>{{orgName}} 품질평가 상세 관리</span>
        </div>
      </div>

      <div class="container">
        <button 
          ref="saveButton"
          class="save-button"
          :class="{ 'sticky-button': isSticky }"
          v-if="hasData"
          @click="saveData(hasData)">
          {{ hasData === 'insert' ? '저장' : '수정' }}
        </button>
        <!-- 트리 구조 렌더링 -->
        <div v-for="(domain, domainIndex) in transformedDomains" :key="domainIndex">
          <div class="tree-item" @click="toggleSubItem(domainIndex)">
            <div class="tree-item-title">{{ domain.domainName }}</div>
          </div>

          <div v-show="subItemsVisibility[domainIndex]" class="sub-item">
            <div v-for="(principle, principleIndex) in domain.principles" :key="principleIndex">
              <div class="tree-item" @click="toggleSubItemStandard(principleIndex)">
                <div class="tree-item-title">{{ principle.principleCode }} - {{ principle.principleName }}</div>
              </div>

              <div v-show="subItemsVisibilityStandard[principleIndex]" class="sub-sub-item">
                <div v-for="(standard, standardIndex) in principle.standards" :key="standardIndex">
                  <div class="tree-item" @click="toggleSubItemEvaluation(standardIndex)">
                    <div class="tree-item-title">{{ standard.standardCode }} - {{ standard.standardName }}</div>
                  </div>

                  <div v-show="evaluationVisibility[standardIndex]" class="evaluation-item">
                    <div 
                      v-for="(evaluation, evalKey) in standard.evaluations" 
                      :key="evaluation.evaluationCode" 
                      class="tree-item-eval"
                    >
                      <div class="tree-item-title">{{ evaluation.evaluationCode }} - {{ evaluation.evaluationName }}</div>

                      <!-- 평가내용 입력 -->
                      <div class="input-group">
                        <label>현황:</label>
                        <textarea 
                          :placeholder="`현황을 입력해주세요`"
                          v-model="evaluationContent[evaluation.evaluationCode]" 
                          class="large-textarea"
                        ></textarea>
                      </div>

                      <div class="input-group">
                        <label>개선사항:</label>
                        <textarea 
                          :placeholder="`개선사항을 입력해주세요`"
                          v-model="evaluationImprovements[evaluation.evaluationCode]" 
                          class="large-textarea"
                        ></textarea>
                      </div>


                      <!-- 점수 선택 라디오 버튼 -->
                        <div class="input-group">
                            <label>점수:</label>
                            <td>
                                <ul class="checkboxes--horizontal">
                                <li>
                                    <input 
                                    type="radio" 
                                    :name="`score_${evaluation.evaluationCode}`" 
                                    :id="`score_1_${evaluation.evaluationCode}`" 
                                    value="1" 
                                    v-model="evaluationScore[evaluation.evaluationCode]"
                                    />
                                    <label :for="`score_1_${evaluation.evaluationCode}`">1(미충족)</label>
                                </li>
                                <li>
                                    <input 
                                    type="radio" 
                                    :name="`score_${evaluation.evaluationCode}`" 
                                    :id="`score_3_${evaluation.evaluationCode}`" 
                                    value="3" 
                                    v-model="evaluationScore[evaluation.evaluationCode]"
                                    />
                                    <label :for="`score_3_${evaluation.evaluationCode}`">3(부분충족)</label>
                                </li>
                                <li>
                                    <input 
                                    type="radio" 
                                    :name="`score_${evaluation.evaluationCode}`" 
                                    :id="`score_5_${evaluation.evaluationCode}`" 
                                    value="5" 
                                    v-model="evaluationScore[evaluation.evaluationCode]"
                                    />
                                    <label :for="`score_5_${evaluation.evaluationCode}`">5(충족)</label>
                                </li>
                                </ul>
                            </td>
                        </div>

                        <!-- 첨부파일 업로드 -->
                        <div class="input-group">
                        <label>첨부파일:</label>
                        <input 
                            type="file" 
                            :id="`file_${evaluation.evaluationCode}`" 
                            @change="handleFileUpload(evaluation.evaluationCode, $event)" 
                        />
                        </div>

                         <!-- 업로드된 파일 목록 -->
                      <ul>
                        <li 
                          v-for="(file, fileIndex) in evaluationFiles[evaluation.evaluationCode] || []" 
                          :key="fileIndex"
                        >
                          {{ file.name }}
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!-- 파일 일괄 다운로드 버튼 -->
        <div class="download-section">
          <button class="download-button" @click="downloadAllFilesDirectly">첨부파일 일괄 다운로드</button>
        </div>
        <div class="Excel-section">
          <button class="Excel-button" @click="downloadExcel">엑셀 다운로드</button>
        </div>
        
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref, computed, onMounted } from "vue";
import { useStore } from "vuex";
import { useRouter,useRoute } from 'vue-router'
import { insertGias ,updateGias } from '@/api/giasinput'
import axios from 'axios';
import * as XLSX from "xlsx";

// Vuex 데이터 및 API 호출
const store = useStore();
const route = useRoute()
const checkUserId = computed(() => store.state.temp.userInfo);

// Vuex로부터 데이터 가져오기
const domainList = computed(() => store.state.grid.domainData); // 승인된 품질평가 조회
// 저장된 품질평가 조회
const orgEvlList = computed(() => {
	return store.state.grid.evlOrgData
})

const hasData = ref(false);
const isSticky = ref(false);

const handleScroll = () => {
    const stickyThreshold = 150; // 버튼이 고정될 스크롤 위치 (px)
    isSticky.value = window.scrollY > stickyThreshold;
};

const saveData = async (check) => {
    const result = [];

    transformedDomains.value.forEach((domain) => {
        domain.principles.forEach((principle) => {
            principle.standards.forEach((standard) => {
                standard.evaluations.forEach((evaluation) => {
                    const code = evaluation.evaluationCode;
                    const entry = {
                        organizationCode: orgCode.value,
                        evaluationCode: code,
                        evaluationScore: evaluationScore[code] || null,
                        evaluationCurrent: evaluationContent[code] || null,
                        evaluationImp: evaluationImprovements[code] || null,
                    };
                    result.push(entry);
                });
            });
        });
    });

    if(check == 'insert'){
        if (confirm("저장하시겠습니까?")) {
            const params = new FormData();
            params.append("data", JSON.stringify(result)); // JSON 데이터를 문자열로 변환

            try {
                // API 호출
                const rtn = await insertGias(params);

                if (rtn.result === "ok") {
                    alert(rtn.resultMsg);
                    window.location.reload();
                } else {
                    alert(rtn.resultMsg);
                }
            } catch (error) {
                console.error("저장 중 오류 발생:", error);
                alert("저장 중 오류가 발생했습니다.");
            }
        }
    }else{
        //수정이지만 일단 싹 날린다
        const params = new FormData();
        params.append("data", JSON.stringify(result)); // JSON 데이터를 문자열로 변환
        params.append("checkString", 'Admin'); // JSON 데이터를 문자열로 변환
        const rtn = await updateGias(params);
        if (rtn.result === "ok") {
            alert("품질평가 수정에 성공했습니다.");
            window.location.reload();
        } else {
            alert(rtn.resultMsg);
        }
        
    }
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

const handleFileUpload = (evaluationCode, event) => {
    const files = Array.from(event.target.files);
    if (!evaluationFiles[evaluationCode]) {
        evaluationFiles[evaluationCode] = [];
    }
    evaluationFiles[evaluationCode].push(...files);
    console.log(`파일 업로드: ${files.map(f => f.name).join(", ")} (평가 코드: ${evaluationCode})`);
};

// 트리 변환된 데이터
const transformedDomains = computed(() => transformToTreeStructure(domainList.value));

// 토글 상태
const subItemsVisibility = reactive({});
const subItemsVisibilityStandard = reactive({});
const evaluationVisibility = reactive({});

// 평가 데이터 상태
const evaluationContent = reactive({});
const evaluationImprovements = reactive({});
const evaluationScore = reactive({});
const evaluationFiles = reactive({});

//파일 관리 상태
const existingFiles = reactive({}); // 존재하는 파일


// 토글 함수
const toggleSubItem = (domainIndex) => {
  subItemsVisibility[domainIndex] = !subItemsVisibility[domainIndex];
};
const toggleSubItemStandard = (principleIndex) => {
  subItemsVisibilityStandard[principleIndex] = !subItemsVisibilityStandard[principleIndex];
};
const toggleSubItemEvaluation = (standardIndex) => {
  evaluationVisibility[standardIndex] = !evaluationVisibility[standardIndex];
};


// 사용자게에 승인된 품질평가 조회
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

  if (Array.isArray(orgEvlList.value)) {
  orgEvlList.value.forEach((savedEvl) => {
    const code = savedEvl.evaluationCode;
    if (code) {
      // 기존 파일 로드
      const filePaths = [
        savedEvl.evaluationFile1,
        savedEvl.evaluationFile2,
        savedEvl.evaluationFile3,
        savedEvl.evaluationFile4,
        savedEvl.evaluationFile5,
        savedEvl.evaluationFile6,
        savedEvl.evaluationFile7,
      ].filter(Boolean);

      existingFiles[code] = filePaths.map((path) => ({
        name: path.split("/").pop(),
        path: path,
      }));

      evaluationFiles[code] = [...existingFiles[code]]; // 초기 렌더링용
    }
  });
  }
};
//기관관리 팝업창에서 받아오는 기관 이름
let orgName = ref('')
let orgCode = ref('')

onMounted(async () => {
    orgName.value = route.query?.organizationName || ''; 
    orgCode.value = route.query?.organizationCode || ''; 
    await getGridData();
    const gridDataAvailable = domainList.value && domainList.value.length > 0;

    await getEvlData();
    const evlDataAvailable = orgEvlList.value && orgEvlList.value.length > 0;

    // 버튼 표시 로직 설정
    if (!gridDataAvailable && !evlDataAvailable) {
        alert("저장할 항목 또는 수정할 항목이 없습니다.");
        hasData.value = false; // 버튼 숨김
    } else if (gridDataAvailable && !evlDataAvailable) {
        hasData.value = "insert"; // "저장" 버튼
    } else if (gridDataAvailable && evlDataAvailable) {
        hasData.value = "update"; // "수정" 버튼
    } else {
        hasData.value = false; // 버튼 숨김
    }

    if (Array.isArray(orgEvlList.value)) {
      orgEvlList.value.forEach((savedEvl, index) => {
      //console.log(`[${index + 1}] 항목 데이터:`, savedEvl); // 각 항목의 전체 구조 출력

      const code = savedEvl.evaluationCode; // evaluationCode 확인
      if (code) {
          // 데이터 매핑
          evaluationContent[code] = savedEvl.evaluationCurrent || "";
          evaluationImprovements[code] = savedEvl.evaluationImp || "";
          evaluationScore[code] = savedEvl.evaluationScore || "";
      }
      });
    } 

    console.log("hasData 상태:", hasData.value); // 디버깅용
    window.addEventListener("scroll", handleScroll);
});

const downloadAllFilesDirectly = async () => {
 try {
    const timestamp = new Date().toISOString().replace(/[-:.]/g, "").slice(0, 14); // YYYYMMDDHHMMSS
    const fileName = `${orgName.value}_품질평가_파일_${timestamp}.zip`;

    // API 호출
    const response = await axios.get(`/gias/download-all-files`, {
      params: { organizationCode: orgCode.value },
      responseType: 'blob', // ZIP 파일 다운로드
    });

    if (response.status === 200) {
      const url = window.URL.createObjectURL(new Blob([response.data]));
      const link = document.createElement('a');
      link.href = url;
      link.setAttribute('download', fileName);
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);

      alert('ZIP 파일 다운로드가 완료되었습니다.');
    } else {
      console.error('ZIP 파일 다운로드 실패: 서버 응답이 올바르지 않습니다.', response);
      alert('ZIP 파일 다운로드에 실패했습니다.');
    }
  } catch (error) {
    console.error('ZIP 파일 다운로드 중 오류 발생:', error);
    alert('ZIP 파일 다운로드 중 오류가 발생했습니다. 관리자에게 문의하세요.');
  }
};

const exportToJSON = () => {
  const jsonData = [];

  transformedDomains.value.forEach((domain) => {
    domain.principles.forEach((principle) => {
      principle.standards.forEach((standard) => {
        standard.evaluations.forEach((evaluation) => {
          const evaluationCode = evaluation.evaluationCode;
          const evaluationName = evaluation.evaluationName;

          // 첨부파일 리스트 가져오기
          const attachments = (evaluationFiles[evaluationCode] || []).map((file) => file.name);
          const attachmentList = attachments.length > 0 ? attachments.join(", ") : "첨부파일 없음";

          // JSON 객체 생성
          const entry = {
            평가코드: evaluationCode,
            평가항목명: evaluationName,
            현재평가내용: evaluationContent[evaluationCode] || null,
            개선내용: evaluationImprovements[evaluationCode] || null,
            첨부파일: attachmentList, // 첨부파일 리스트 추가
            평가점수: evaluationScore[evaluationCode] || null, // 평가점수를 가장 마지막에 배치
          };

          jsonData.push(entry);
        });
      });
    });
  });

  console.log("생성된 JSON 데이터:", jsonData);
  return jsonData;
};


const downloadExcel = () => {
  try {
    // 트리 구조 데이터를 JSON으로 변환
    const jsonData = exportToJSON();

    // JSON 데이터를 Excel 시트로 변환
    const worksheet = XLSX.utils.json_to_sheet(jsonData);
    const workbook = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(workbook, worksheet, "Sheet1");

    // 엑셀 파일 생성 및 다운로드
    const excelBuffer = XLSX.write(workbook, { bookType: "xlsx", type: "array" });
    const blob = new Blob([excelBuffer], { type: "application/octet-stream" });

    const link = document.createElement("a");
    link.href = window.URL.createObjectURL(blob);
    link.download = `${orgName.value}_품질평가.xlsx`;
    link.click();

    alert("엑셀 파일 다운로드가 완료되었습니다.");
  } catch (error) {
    console.error("엑셀 다운로드 오류:", error);
    alert("엑셀 다운로드 중 오류가 발생했습니다.");
  }
};



</script>


<style>
    .container {
        max-width: 100%;
        margin: 0 auto;
        position: relative;
    }

    .save-button {
         position: absolute;
        top: 10px;
        right: 10px;
        background-color: #2e7d32;
        color: white;
        padding: 8px 16px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 14px;
        font-weight: bold;
    }

    .sticky-button {
        position: fixed;
        top: 10px;
        right: 10px;
        z-index: 1000;
    }
    .tree-item {
        margin: 5px 0;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        background-color: #f8f8f8;
        cursor: pointer;
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 50px;
        box-sizing: border-box;
        font-size: 16px;
        font-weight: bold;
        word-break: break-word;
        text-align: center;
    }

    .tree-item-title {
        width: 100%;
        text-align: center;
        font-weight: normal;
        font-size: 16px;
        word-break: break-word;
    }

    .sub-item {
        margin-left: 20px;
        padding: 8px;
        background-color: #e0e0e0;
        border: 1px solid #bcbcbc;
        border-radius: 5px;
    }

    .sub-sub-item {
        margin-left: 40px;
        padding: 8px;
        background-color: #d3d3d3;
        border: 1px solid #a9a9a9;
        border-radius: 5px;
    }

    .evaluation-item {
        margin-left: 60px;
        padding: 8px;
        background-color: #f0f0f0;
        border: 1px solid #cccccc;
        border-radius: 5px;
    }

    .tree-item-eval {
        margin: 5px 0;
        padding: 8px;
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
        font-size: 14px;
        color: #333;
    }

    .input-group {
        display: flex;
        align-items: center;
        margin: 5px 0;
    }

    .input-group label {
        width: 80px;
        font-weight: bold;
    }

    .input-group input {
        flex: 1;
        padding: 5px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 14px;
    }

     .offline-button {
        margin-top: 20px; /* 적절한 위치에 추가 */
        background-color: #3e8ed0;
    }
    .input-group input[type="file"] {
    border: 1px solid #ccc;
    padding: 5px;
    border-radius: 5px;
    font-size: 14px;
    }
  .large-textarea {
    width: 100%; /* 가로 크기를 100%로 설정 */
    height: 160px; /* 세로 크기를 기존의 3배로 설정 */
    padding: 8px; /* 적절한 패딩 추가 */
    border: 1px solid #ccc; /* 기존 스타일과 일치하도록 경계선 설정 */
    border-radius: 5px;
    font-size: 14px; /* 적당한 폰트 크기 */
    resize: vertical; /* 사용자가 세로 크기를 조정할 수 있도록 허용 */
  }
  .download-section {
  text-align: center;
  margin-top: 20px;
  }

  .download-button {
    background-color: #007bff;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    font-weight: bold;
  }

  .download-button:hover {
    background-color: #0056b3;
  }

  .Excel-section {
  text-align: center;
  margin-top: 20px;
  }

  .Excel-button {
    background-color: #9DD84B;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    font-size: 16px;
    cursor: pointer;
    font-weight: bold;
  }

  .Excel-button:hover {
    background-color: #9DD84B;
  }
</style>
