<template>
<!--컨텐츠-->
	<div class="contents contents--full">
		<div class="contents__wrap">

			<!--페이지 상단-->
			<div class="sub-top">
				<h3>평가원 관리</h3>
				<div class="sub-top__navi">
					<span class="icon-home navi--home"></span>
					<span>평가원 관리</span>
				</div>
			</div>

			<!--검색박스-->
			<div class="searchbox spacing--xs">
				<div class="searchbox__box">
					<div class="searchbox__frame">
						<div>
							<select v-model="searchCode">
								<option value="all">전체</option>
								<option value="oName">기관명</option>
								<option value="mName">이름</option>
							</select>
						</div>
						<div>
							<select v-model="searchState">
								<option value="all">전체</option>
								<option value="state1">활성화</option>
								<option value="state0">비활성화</option>
							</select>
						</div>
						<div class="searchbox__input">
							<div class="input-btn">
								<input type="text" placeholder="내용을 입력해주세요 " v-model="searchText" @keyup.enter="gridLoad">
								<button type="button" @click="gridLoad" class="btn btn--primary btn--icon icon-search"></button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!--목록-->
			<div class="btns btns--right spacing--sm">
				<button type="button" class="btn btn--sm btn--primary icon-bin" @click="deleteOrgInfo()">계정 삭제</button>
				<!-- <button type="button" class="btn btn--sm btn--primary icon-check">그룹 만들기</button> -->
			</div>
			<div class="table__wrap spacing--xxxs">
				<table class="table table--split" style="min-width:768px;">
					<tr>
						<th>
							<input type="checkbox" id="check_all" @change="toggleAll(isAllChecked)" v-model="isAllChecked">
							<label for="check_all"></label>
						</th>
						<th>No</th>
						<th>아이디</th>
						<th>이름</th>
						<th>기관</th>
						<th>신청일(수정일)</th>
						<th>상태</th>
						<th>관리</th>
						<th>평가권한 배분</th>
						<th>비밀번호 초기화</th>
					</tr>
					<!-- <tr>
						<td>
							<input type="checkbox" id="check_2" checked>
							<label for="check_2"></label>
						</td>
						<td>10</td>
						<td>a02332</td>
						<td>홍길동</td>
						<td>Superadmin</td>
						<td>IT 기획팀</td>
						<td>2023-12-18 15:57</td>
						<td><em class="text--alert">비활성</em></td>
						<td>관리자</td>
						<td><button type="button" class="btn btn--primary btn--outline btn--xs">활성화</button></td>
						<td>01010101010</td>
						<td><button type="button" class="btn btn--basic btn--outline btn--xs">초기화</button></td>
					</tr>
					<tr>
						<td>
							<input type="checkbox" id="check_3" checked>
							<label for="check_3"></label>
						</td>
						<td>9</td>
						<td>a02332</td>
						<td>홍길동</td>
						<td>Superadmin</td>
						<td>IT 기획팀</td>
						<td>2023-12-18 15:57</td>
						<td><em class="text--complete">활성</em></td>
						<td>관리자</td>
						<td><button type="button" class="btn btn--alert btn--outline btn--xs">비활성화</button></td>
						<td>01010101010</td>
						<td><button type="button" class="btn btn--basic btn--outline btn--xs">초기화</button></td>
					</tr> -->
					<tr v-for="(vo, index) of memberList" :key="index" >
						<td>
							<input type="checkbox" :id="'check_' + index" v-model="checkedItems[index]">
							<label :for="'check_' + index"></label>
						</td>
						<td>{{vo.no}}</td>
						<td>{{vo.id}}</td>
						<td>{{vo.memberName}}</td>
						<td>{{vo.organizationName}}</td>
						<td>{{vo.updateAt}}</td>
						<td v-if="vo.state == 0"><em class="text--alert">비활성</em></td>
						<td v-if="vo.state == 1"><em class="text--complete">활성</em></td>
						<td v-if="vo.state == 0"><button type="button" class="btn btn--primary btn--outline btn--xs" @click="changeStatus(vo.memberCode, vo.state)" >활성화</button></td>
						<td v-if="vo.state == 1"><button type="button" class="btn btn--alert btn--outline btn--xs" @click="changeStatus(vo.memberCode, vo.state)" >비활성화</button></td>
						<td v-if="vo.approvedStandard == '1'"><button type="button" class="btn btn--primary btn--outline btn--xs" @click="openApprovedStandard(vo.memberCode,vo.organizationCode)">배분완료</button></td>
						<td v-if="vo.approvedStandard == '0'"><button type="button" class="btn btn--tertiary btn--outline btn--xs" @click="openApprovedStandard(vo.memberCode,vo.organizationCode)">미배분</button></td>
						<td><button type="button" class="btn btn--basic btn--outline btn--xs" @click="passwordInit(vo.memberCode)">초기화</button></td>
					</tr>
					
				</table>
			</div>

			<!--페이징-->
		<Pagination v-if="memberJson.pagination" :gridInfo="memberJson" @getGridData="getGridData" @click="goPage()" />
		</div>
	</div>
</template>
   
<script setup>
import { useStore } from 'vuex'
import { ref, computed, onMounted, onUnmounted ,watch } from 'vue'
import Pagination from '@/components/common/grid/pagination'
import memberJson from '@/models/gridInfo/member.json'
import { useRouter } from 'vue-router'
import { updateMemberState,deleteMember,userPwInit } from '@/api/user'

const store = useStore()
const router = useRouter()
	
const searchText = ref('')
const searchCode = ref('all')
const searchState = ref('all')
const checkUserId = computed(() => store.state.temp.userInfo )

const searchParam = computed(() => {
	return store.state.temp.searchParam 
})

const memberList = computed(() => {
	return store.state.grid.orgData
})

const checkedItems = ref(memberList.value.map(() => false));

const isAllChecked = ref(false)

//const isAllChecked = ref(localStorage.getItem('isAllChecked') === 'true');

const toggleAll = (isAllChecked) => {
	for (let i = 0; i < 11; i++) {
		checkedItems.value[i] = isAllChecked; 
	}
};
watch(checkedItems, (newVal) => {
	if (newVal.every(Boolean) !== isAllChecked.value) {
	// 개별 체크박스 상태가 변경될 때 로직
	}
});

const changeStatus = async (memberCode,state) =>{
	if(state == 1){
		if (confirm("비활성화 처리하시겠습니까? ")) {
			let param = {
				memberCode : memberCode,
			}
			let rtn = await updateMemberState(param)
			
			if (rtn?.result == 'ok') {
				alert(rtn.resultMsg)
				gridLoad();
			} else { 
				alert(rtn.resultMsg)
			}
		}
	}else if(state == 0){
		if (confirm("활성화 처리하시겠습니까? ")) {
			let param = {
				memberCode : memberCode,
			}
			let rtn = await updateMemberState(param)
			
			if (rtn?.result == 'ok') {
				alert(rtn.resultMsg)
				gridLoad();
			} else { 
				alert(rtn.resultMsg)
			}
		}
	}

}

const deleteOrgInfo = async () => {
    // 체크된 항목들의 vo.no를 객체 배열로 저장
    const selectedOrgs = memberList.value
        .filter((notice, index) => checkedItems.value[index])
        .map((selectedMember) => ({ memberCode: selectedMember.memberCode }));

    // 배열에 저장된 객체 배열을 콘솔에 출력
    console.log('Selected Notice Objects:', selectedOrgs);

    if (selectedOrgs.length < 1) {
        alert("선택된 평가원이 없습니다.");
        return false;
    }

    //여기서 deleteNotice API 호출
    if (confirm("정말 삭제하시겠습니까?")) {
        let rtn = await deleteMember(selectedOrgs); // 객체 배열을 그대로 전달
        console.log("선택된 평가원 목록:", selectedOrgs);
        
        if (rtn.result == 'ok') {
            alert(rtn.resultMsg);
            gridLoad();
            // 삭제 후 체크박스 전부 해제
            for (let i = 0; i < checkedItems.value.length; i++) {
                checkedItems.value[i] = false; 
            }
			isAllChecked.value = false
        } else { 
            alert(rtn.resultMsg);
        }
    }
};

const passwordInit = async (code) => {
    
    console.log('선택한 맴버 코드', code);

    //여기서 deleteNotice API 호출
    if (confirm("정말 비밀번호 초기화 하시겠습니까?")) {
		let param = {
			memberCode : code,
		}
        let rtn = await userPwInit(param); // 객체 배열을 그대로 전달
        
        if (rtn.result == 'ok') {
            alert(rtn.resultMsg);
            gridLoad();
            // 삭제 후 체크박스 전부 해제
        } else { 
            alert(rtn.resultMsg);
        }
    }
};

//관리자 상세페이지 팝업
const openApprovedStandard = (memberCode,organizationCode) => {
	//console.log("상세 클릭", organizationCode)
	store.commit('member/setMember', memberCode)
	//store.commit('member/setMember', organizationCode)
    store.commit('temp/setIsApprovedStandard')
}

const gridLoad = () => {
	store.commit('temp/setSearchParam', {key : 'pageNo', value : 1})
	store.commit('temp/setSearchParam', {key : 'searchCode', value:searchCode.value})
	store.commit('temp/setSearchParam', {key : 'searchText', value:searchText.value})
	getGridData()
}

const getGridData = async () => {
	let param = {
		pageNo : searchParam.value.pageNo,
		countPerRecord : searchParam.value.countPerRecord,
		search : searchText.value,
		typeCd : searchCode.value,
		searchKind : searchState.value
	}
	console.log()
	await store.dispatch('grid/fetchUserVue', param)
}

const goPage = () => {
	console.log("searchParam.value.pageNo : " + searchParam.value.pageNo)
	// localStorage.setItem('searPageNo', searchParam.value.pageNo);
};

onMounted(async () => {
	store.commit('temp/clearSearchParam')
	getGridData()
})

onUnmounted(() => {
	store.commit('temp/clearSearchParam')
	// 페이지 닫힐 때 해당 리스너 삭제
}) 

</script>

<style></style>