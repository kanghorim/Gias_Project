<template>
  <div class="popup popup--md active">
    <div class="popup__wrap">
      <div class="popup__box">
        <div class="popup__head">
          <div class="popup__title">
            <p>품질평가 확인</p>
          </div>
          <button type="button" class="popup__close icon-only icon-x" @click="popupClose"></button>
        </div>


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



        <div class="popup__btns">
          <button type="button" class="btn btn--sm btn--basic icon-check" @click="popupClose">닫기</button>
          <button
            ref="saveButton"
          class="btn btn--sm btn--primary icon-check"
          v-if="hasData"
          @click="saveData(hasData)">
          {{ hasData === 'insert' ? '저장' : '수정' }}
          </button>
        </div>
      </div>
      <div class="popup__bg"></div>
    </div>
  </div>
</template>

<script setup>
import { reactive, ref, computed, onMounted } from "vue";
import { useStore } from "vuex";
import { insertGias ,updateGias } from '@/api/giasinput'
// Vuex 데이터 및 API 호출
const store = useStore();
const checkUserId = computed(() => store.state.temp.userInfo);

// Vuex로부터 데이터 가져오기
const domainList = computed(() => store.state.grid.domainData); // 승인된 품질평가 조회
// 저장된 품질평가 조회
const orgEvlList = computed(() => {
	return store.state.grid.orgData
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
                        memberCode: checkUserId.value.memberCode,
                        organizationCode: checkUserId.value.organizationCode,
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
        let param = {
            memberCode : checkUserId.value.memberCode
        }
        let rtn = await updateGias(param);
        if (rtn.result == 'ok') { // 전부 날리는데 성공했으면 기존의 데이터를 그대로 다시 저장
            const params = new FormData();
            params.append("data", JSON.stringify(result)); // JSON 데이터를 문자열로 변환
            const rtn = await insertGias(params);
            if (rtn.result === "ok") {
                alert("품질평가 수정에 성공했습니다.");
                window.location.reload();
            } else {
                alert(rtn.resultMsg);
            }
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
    memberCode: checkUserId.value.memberCode,
  };
  await store.dispatch("grid/fetchEvlOrg", param);
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
      console.log(`[${index + 1}] 항목 데이터:`, savedEvl); // 각 항목의 전체 구조 출력

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

const popupClose = () => {
  store.commit("temp/setIsGiasStatus");
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

</style>