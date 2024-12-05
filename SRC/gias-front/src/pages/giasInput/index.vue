<template>
  <div class="contents contents--full">
    <div class="contents__wrap">
      <div class="sub-top">
        <h3>품질평가 입력</h3>
        <div class="sub-top__navi">
          <span class="icon-home navi--home"></span>
          <span>품질평가 입력</span>
          <span>품질평가 상세 입력</span>
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
            <div class="tree-item-title">{{ domain.domainName }}
              <br />
              <span class="summary">
             (총합: {{ calculatedResults.domains[domain.domainCode]?.sum }}, 
              평균: {{ calculatedResults.domains[domain.domainCode]?.average }}, 
              항목 개수: {{ calculatedResults.domains[domain.domainCode]?.count }})
              </span>
            </div>
          </div>
        
          <div v-show="subItemsVisibility[domainIndex]" class="sub-item">
            <div v-for="(principle, principleIndex) in domain.principles" :key="principleIndex">
              <div class="tree-item" @click="toggleSubItemStandard(principleIndex)">
                <div class="tree-item-title">{{ principle.principleCode }} - {{ principle.principleName }}
                  <br />
                  <span class="summary">
                  (총합: {{ calculatedResults.principles[`${domain.domainCode}-${principle.principleCode}`]?.sum }}, 
                  평균: {{ calculatedResults.principles[`${domain.domainCode}-${principle.principleCode}`]?.average }}, 
                  항목 개수: {{ calculatedResults.principles[`${domain.domainCode}-${principle.principleCode}`]?.count }})
                   </span>
                </div>
              </div>

              <div v-show="subItemsVisibilityStandard[principleIndex]" class="sub-sub-item">
                <div v-for="(standard, standardIndex) in principle.standards" :key="standardIndex">
                  <div class="tree-item" @click="toggleSubItemEvaluation(standardIndex)">
                    <div class="tree-item-title">{{ standard.standardCode }} - {{ standard.standardName }}
                      <br />
                      <span class="summary">
                      (총합: {{ calculatedResults.standards[`${domain.domainCode}-${principle.principleCode}-${standard.standardCode}`]?.sum }}, 
                      평균: {{ calculatedResults.standards[`${domain.domainCode}-${principle.principleCode}-${standard.standardCode}`]?.average }}, 
                      항목 개수: {{ calculatedResults.standards[`${domain.domainCode}-${principle.principleCode}-${standard.standardCode}`]?.count }})
                      </span>
                    </div>
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
                        <label for="attach_ex1" >첨부파일:</label>
                        <input 
                            type="file" 
                            :id="`file_${evaluation.evaluationCode}`" 
                            @change="handleFileUpload(evaluation.evaluationCode, $event)" 
                            multiple 
                        />
                        </div>

                         <!-- 업로드된 파일 목록 -->
                      <ul class="attach-list">
                        <li 
                          v-for="(file, fileIndex) in evaluationFiles[evaluation.evaluationCode] || []" 
                          :key="fileIndex"
                        >
                          {{ file.name }}
                          <button type="button" class="icon-x" @click="removeFile(evaluation.evaluationCode, fileIndex)"></button>
                        </li>
                      </ul>


                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>


        
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref, computed, onMounted,onUnmounted,toRaw } from "vue";
import { useStore } from "vuex";
import { insertGias ,updateGias,updateGiasFile } from '@/api/giasinput'
// Vuex 데이터 및 API 호출
const store = useStore();
const checkUserId = computed(() => store.state.temp.userInfo);

// Vuex로부터 데이터 가져오기
const domainList = computed(() => store.state.grid.domainData); // 승인된 품질평가 조회
// 저장된 품질평가 조회
const orgEvlList = computed(() => {
	return store.state.grid.evlOrgData
})


// 초기 데이터 상태 저장
let initialEvaluationContent = {};
let initialEvaluationImprovements = {};
let initialEvaluationScore = {};


const hasData = ref(false);
const isSticky = ref(false);

const handleScroll = () => {
    const stickyThreshold = 150; // 버튼이 고정될 스크롤 위치 (px)
    isSticky.value = window.scrollY > stickyThreshold;
};

// 파일 삭제 로직
// const removeFile2 = (evaluationCode, fileIndex) => {
//   const removedFile = evaluationFiles[evaluationCode].splice(fileIndex, 1)[0];

//   if (existingFiles[evaluationCode]?.some((file) => file.name === removedFile.name)) {
//     // 삭제된 파일을 `deletedFiles`로 이동
//     if (!deletedFiles[evaluationCode]) deletedFiles[evaluationCode] = [];
//     deletedFiles[evaluationCode].push(removedFile);
//   } else {
//     // 새로 추가된 파일 중 삭제
//     newFiles[evaluationCode] = newFiles[evaluationCode].filter((file) => file.name !== removedFile.name);
//   }
// };
// 파일 삭제 로직
const removeFile = (evaluationCode, fileIndex) => {
  const removedFile = evaluationFiles[evaluationCode].splice(fileIndex, 1)[0];

  // 삭제된 파일을 `deletedFiles`로 이동
  if (existingFiles[evaluationCode]?.some((file) => file.name === removedFile.name)) {
    if (!deletedFiles[evaluationCode]) deletedFiles[evaluationCode] = [];
    deletedFiles[evaluationCode].push(removedFile);
    // 기존 파일 배열에서 삭제
    existingFiles[evaluationCode] = existingFiles[evaluationCode].filter(
      (file) => file.name !== removedFile.name
    );
  } else {
    // 새로 추가된 파일 중 삭제
    newFiles[evaluationCode] = newFiles[evaluationCode].filter(
      (file) => file.name !== removedFile.name
    );
  }
};

// 파일 추가 로직
// const handleFileUpload2 = (evaluationCode, event) => {
//   const files = Array.from(event.target.files);

//   if (!evaluationFiles[evaluationCode]) evaluationFiles[evaluationCode] = [];
//   if (!newFiles[evaluationCode]) newFiles[evaluationCode] = [];

//   files.forEach((file) => {
//     evaluationFiles[evaluationCode].push(file);
//     newFiles[evaluationCode].push(file); // 새로 추가된 파일
//   });
// };

const handleFileUpload = (evaluationCode, event) => {
  const files = Array.from(event.target.files); // 다중 파일 배열화

  if (!evaluationFiles[evaluationCode]) evaluationFiles[evaluationCode] = [];
  if (!newFiles[evaluationCode]) newFiles[evaluationCode] = [];

  files.forEach((file) => {
    evaluationFiles[evaluationCode].push(file);
    newFiles[evaluationCode].push(file); // 새로 추가된 파일
  });
};


const prepareKeepFiles = () => {
  const keepFiles = {};

  // 기존 파일 중 삭제되지 않은 파일만 유지
  for (const evaluationCode in existingFiles) {
    keepFiles[evaluationCode] = existingFiles[evaluationCode]
      .filter(
        (file) => !deletedFiles[evaluationCode]?.some((deleted) => deleted.name === file.name)
      )
      .map((file) => file.path); // 경로만 추출
  }

  return keepFiles;
}

const calculateSumsAndAverages = (data) => {
  const results = {
    domains: {}, // 도메인별 결과
    principles: {}, // 원칙별 결과
    standards: {}, // 표준별 결과
  };

  data.forEach((domain) => {
    let domainSum = 0;
    let domainCount = 0;

    domain.principles.forEach((principle) => {
      let principleSum = 0;
      let principleCount = 0;

      principle.standards.forEach((standard) => {
        let standardSum = 0;
        let standardCount = 0;

        standard.evaluations.forEach((evaluation) => {
          const score = parseFloat(evaluationScore[evaluation.evaluationCode] || 0);
          if (!isNaN(score)) {
            standardSum += score;
            standardCount++;
          }
        });

        // 표준별 총합, 평균, 개수 저장
        const standardId = `${domain.domainCode}-${principle.principleCode}-${standard.standardCode}`;
        results.standards[standardId] = {
          name: standard.standardName,
          sum: standardSum,
          count: standardCount,
          average: standardCount > 0 ? (standardSum / standardCount).toFixed(2) : 0,
        };

        principleSum += standardSum;
        principleCount += standardCount;
      });

      // 원칙별 총합, 평균, 개수 저장
      const principleId = `${domain.domainCode}-${principle.principleCode}`;
      results.principles[principleId] = {
        name: principle.principleName,
        sum: principleSum,
        count: principleCount,
        average: principleCount > 0 ? (principleSum / principleCount).toFixed(2) : 0,
      };

      domainSum += principleSum;
      domainCount += principleCount;
    });

    // 도메인별 총합, 평균, 개수 저장
    results.domains[domain.domainCode] = {
      name: domain.domainName,
      sum: domainSum,
      count: domainCount,
      average: domainCount > 0 ? (domainSum / domainCount).toFixed(2) : 0,
    };
  });

  return results;
};

// 계산 결과 가져오기
const calculatedResults = computed(() => calculateSumsAndAverages(transformedDomains.value));


// Save Data 로직 수정
const saveData = async (check) => {
  const result = [];
  const formData = new FormData();

  let isFileLimitExceeded = false;

  transformedDomains.value.forEach((domain) => {
    domain.principles.forEach((principle) => {
      principle.standards.forEach((standard) => {
        standard.evaluations.forEach((evaluation) => {
          const code = evaluation.evaluationCode;

          // 기존 데이터
          const entry = {
            memberCode: checkUserId.value.memberCode,
            organizationCode: checkUserId.value.organizationCode,
            evaluationCode: code,
            evaluationScore: evaluationScore[code] || null,
            evaluationCurrent: evaluationContent[code] || null,
            evaluationImp: evaluationImprovements[code] || null,
          };

          result.push(entry);

          // 파일 개수 확인
          const existingFileCount = existingFiles[code]?.length || 0;
          const newFileCount = newFiles[code]?.length || 0;
          const totalFileCount = existingFileCount + newFileCount;

          if (totalFileCount > 7) {
            isFileLimitExceeded = true;
          }

          // 새로 추가된 파일
          if (newFiles[code]) {
            newFiles[code].forEach((file) => {
              formData.append(`files[${code}][]`, file);
            });
          }
        });
      });
    });
  });

  // 파일 제한 초과 시 경고 및 실행 중단
  if (isFileLimitExceeded) {
    alert("첨부파일은 평가 코드당 최대 7개까지만 가능합니다.");
    return;
  }

  // 유지할 파일
  const keepFiles = prepareKeepFiles();
  formData.append("keepFiles", JSON.stringify(keepFiles));
  
  formData.append("data", JSON.stringify(result));

  // 서버로 데이터 전송
  try {
    if (check === "insert") {
      if (confirm("저장 하시겠습니까?")) {
        const response = await insertGias(formData);
        if (response.result === "ok") {
          alert("저장에 성공했습니다.");
          window.location.reload();
        } else {
          alert("저장에 실패했습니다.");
        }
      }
    } else {
       if (confirm("수정 하시겠습니까?")) {
        formData.append("checkString", "Member");
        formData.append("memberCode", checkUserId.value.memberCode);
        const response = await updateGias(formData);
        if (response.result === "ok") {
          // alert("수정에 성공했습니다.");
          // window.location.reload();
          formData.append("organizationCode", checkUserId.value.organizationCode);
          const rtn = await updateGiasFile(formData);
          if(rtn.result === "ok"){
            alert("수정에 성공했습니다.");
            window.location.reload();
          }else{
            alert("파일 수정에 실패했습니다.");
          }
        } else {
          alert("수정에 실패했습니다.");
        }
       }
    }
  } catch (error) {
    console.error("저장 중 오류 발생:", error);
    alert("오류가 발생했습니다.");
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
const newFiles = reactive({}); // 새로운 파일
const deletedFiles = reactive({}); // 삭제할 파일


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
  await store.dispatch("grid/fetchDomain", param);
};

const getEvlData = async () => {
  let param = {
    memberCode: checkUserId.value.memberCode,
  };
  await store.dispatch("grid/fetchEvlOrg", param);

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


onMounted(async () => {
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

     // 초기 데이터를 깊은 복사로 저장
    initialEvaluationContent = JSON.parse(JSON.stringify(toRaw(evaluationContent)));
    initialEvaluationImprovements = JSON.parse(JSON.stringify(toRaw(evaluationImprovements)));
    initialEvaluationScore = JSON.parse(JSON.stringify(toRaw(evaluationScore)));

});

onUnmounted(() => {
	// 페이지 닫힐 때 해당 리스너 삭제
  const isContentChanged = JSON.stringify(toRaw(evaluationContent)) !== JSON.stringify(initialEvaluationContent);
  const isImprovementsChanged = JSON.stringify(toRaw(evaluationImprovements)) !== JSON.stringify(initialEvaluationImprovements);
  const isScoreChanged = JSON.stringify(toRaw(evaluationScore)) !== JSON.stringify(initialEvaluationScore);

  if (isContentChanged || isImprovementsChanged || isScoreChanged) {
      saveData(hasData.value); // 데이터가 변경된 경우만 저장
  } 
}) 


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

    .tree-item-title22 {
        width: 100%;
        text-align: center;
        font-weight: normal;
        font-size: 16px;
        word-break: break-word;
    }

    .tree-item-title {
      font-weight: bold;
      margin-bottom: 5px;
    }

    .summary {
      font-size: 0.9em;
      color: gray;
      margin-top: 3px;
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

</style>
