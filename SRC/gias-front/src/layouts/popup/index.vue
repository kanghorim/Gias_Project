<template>
  <div class="popup popup--md active">
    <div class="popup__wrap">
      <div class="popup__box">
        <div class="popup__head">
          <div class="popup__title">
            <p>평가권한 배분</p>
          </div>
          <button type="button" class="popup__close icon-only icon-x" @click="popupClose"></button>
        </div>
        <div class="popup__body">
          <div class="standards-list">
            <!-- 항목 클릭으로 다중 선택 -->
            <div
              v-for="(vo, index) in standardsList"
              :key="index"
              :class="['standard-item', { 'selected': selectedStandards.includes(vo.standardCode) }]"
              @click="toggleSelection(vo.standardCode)"
            >
              <p class="standard-code-name">
                {{ vo.standardCode }} {{ vo.standardName }}
              </p>
            </div>
          </div>
        </div>
        <div class="popup__btns">
          <button type="button" class="btn btn--sm btn--basic icon-check" @click="popupClose">닫기</button>
          <button
            type="button"
            class="btn btn--sm btn--primary icon-check"
            @click="registerStandards"
            :disabled="selectedStandards.length === 0"
          >
            등록
          </button>
        </div>
      </div>
      <div class="popup__bg"></div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from "vue";
import { useStore } from "vuex";
import { ApprovedStandardList,
ApprovedStandardUpdate,
checkUpdateApprovedStandardBeFor,
updateApprovedStandardBeFor } from '@/api/user'

const store = useStore();
// 선택된 항목의 standardCode 배열
const selectedStandards = ref([]);

// 스토어에서 데이터 매핑
const standardsList = computed(() => store.state.grid.standardData || []);

const selectedMember = computed(() => store.state.member.member  || [] )

// 항목 클릭 시 선택/해제
const toggleSelection = (standardCode) => {
  if (selectedStandards.value.includes(standardCode)) {
    // 이미 선택된 항목이면 제거
    selectedStandards.value = selectedStandards.value.filter((code) => code !== standardCode);
  } else {
    // 선택되지 않은 항목이면 추가
    selectedStandards.value.push(standardCode);
  }
};

// 등록 버튼 클릭 시 호출
const registerStandards = async() => {
  	console.log("선택된 항목들:", selectedStandards.value); // 선택된 코드 배열 콘솔에 출력
	const sortedStandards = [...selectedStandards.value].sort((a, b) => {
        // 문자열로 정렬하되 숫자 순서에 맞게 비교
        if (a < b) return -1;
        if (a > b) return 1;
        return 0;
    });

	let param = {
		memberCode : selectedMember.value,
		approvedStandardList : sortedStandards
	}
  let rtn = await checkUpdateApprovedStandardBeFor(param);

  if(rtn.result == "ok"){ // 이미 저장할 데이터가 있음
    if(confirm(rtn.resultMsg)){ // 예 누름
      let rtn2 = await updateApprovedStandardBeFor(param); // 삭제할 데이터 삭제함
      if(rtn2.result == "ok"){
        let rtn3 = await ApprovedStandardUpdate(param); // 삭제한 다음에 업데이트함
        if(rtn3.result == "ok"){
          alert(rtn3.resultMsg)
          popupClose()
        }else{
          alert(rtn3.resultMsg)
        }
      }else{ // 삭제할 데이터가 없으면
        alert("삭제할 데이터 없음")
      }
    }else{
      alert("작업을 취소 하셨습니다.")
    }
  }else{
    let rtn3 = await ApprovedStandardUpdate(param);
      if(rtn3.result == "ok"){
        alert(rtn3.resultMsg)
        popupClose()
      }else{
        alert(rtn3.resultMsg)
      }
  }

  
};

// 데이터 초기화 (API 호출로 대체 가능)
const getGridData = async () => {
  await store.dispatch("grid/fetchStandard");
};

onMounted(async() => {
	console.log("부모창에서 받은 팝업 데이터 : " + selectedMember.value)
	await getGridData();
	
	const params = { memberCode: String(selectedMember.value) }; // 객체로 전달
    let rtn = await ApprovedStandardList(params);

	if (rtn.result == 'ok') {
        console.log(rtn.data)
    } else { 
        alert(rtn.resultMsg);
    }

	// 클릭한 팝업에 평가원의 승인된 항목이 있다면 클릭한 취급으로 변경
	if (rtn.data) {
    	selectedStandards.value = rtn.data; // API에서 받은 데이터를 선택된 상태로 설정
  	}

});

const popupClose = () => {
  store.commit("temp/setIsApprovedStandard");
};
</script>

<style scoped>
.standards-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin: 10px 0;
}

.standard-item {
  background: #f5f5f5;
  border: 1px solid #ddd;
  border-radius: 5px;
  padding: 15px;
  text-align: center;
  font-size: 14px;
  font-weight: bold;
  cursor: pointer;
  transition: background 0.3s, border 0.3s;
}

.standard-item:hover {
  background: #e9e9e9;
  border-color: #bbb;
}

.standard-item.selected {
  background: #d1ecf1;
  border-color: #17a2b8;
  color: #0c5460;
}

.standard-code-name {
  margin: 0;
  padding: 0;
}

.popup__btns .btn:disabled {
  background: #ddd;
  color: #aaa;
  cursor: not-allowed;
}
</style>
