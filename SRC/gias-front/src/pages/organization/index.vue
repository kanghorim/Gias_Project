<template>
<!--컨텐츠-->
	<div class="contents contents--full">
		<div class="contents__wrap">

			<!--페이지 상단-->
			<div class="sub-top">
				<h3>기관 관리</h3>
				<div class="sub-top__navi">
					<span class="icon-home navi--home"></span>
					<span>기관 관리</span>
				</div>
			</div>

			<!--검색박스-->
			<div class="searchbox spacing--xs">
				<div class="searchbox__box">
					<div class="searchbox__frame">
						<div>
							<select v-model="searchCode">
								<option value="all">전체</option>
								<option value="state1">활성</option>
								<option value="state0">비활성</option>
							</select>
						</div>
						<div class="searchbox__input">
							<div class="input-btn">
								<input type="text" placeholder="기관명을 입력해주세요" v-model="searchText" @keyup.enter="gridLoad">
								<button type="button" @click="gridLoad" class="btn btn--primary btn--icon icon-search"></button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!--목록-->
			<div class="btns btns--right spacing--sm">
				<button type="button" class="btn btn--sm btn--primary icon-bin" @click="deleteOrgInfo()">기관 삭제</button>
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
						<th>기관코드</th>
						<th>기관명</th>
						<th>배분현황</th>
						<th>품질평가 현황</th>
						<th>품질평가 통계</th>
						<th>신청일</th>
						<th>상태</th>
						<th>승인자</th>
						<th>관리</th>
					</tr>
					<!-- <tr>
						<td>
							<input type="checkbox" id="check_2" checked>
							<label for="check_3"></label>
						</td>
						<td>10</td>
						<td>a02332</td>
						<td>비활성기관</td>
						<td>2023-12-18 15:57</td>
						<td><em class="text--alert">비활성</em></td>
						<td>관리자</td>
						<td><button type="button" class="btn btn--primary btn--outline btn--xs">활성화</button></td>
					</tr>
					<tr>
						<td>
							<input type="checkbox" id="check_2" checked>
							<label for="check_2"></label>
						</td>
						<td>10</td>
						<td>a02332</td>
						<td>활성기관</td>
						<td>2023-12-18 15:57</td>
						<td><em class="text--complete">활성</em></td>
						<td>관리자</td>
						<td><button type="button" class="btn btn--alert btn--outline btn--xs">비활성화</button></td>
					</tr> -->
					<tr v-for="(vo, index) of orgList" :key="index" >
						<td>
							<input type="checkbox" :id="'check_' + index" v-model="checkedItems[index]">
							<label :for="'check_' + index"></label>
						</td>
						<td>{{vo.no}}</td>
						<td>{{vo.organizationCode}}</td>
						<td>{{vo.organizationName}}</td>
						<td v-if ="vo.approverCount == '52'" @click="openDistributionStatus(vo.organizationCode)" :style="{ cursor: 'pointer' }"><em class="text--complete">배분 완료</em></td> 
						<td v-if ="vo.approverCount != '52'" @click="openDistributionStatus(vo.organizationCode)" :style="{ cursor: 'pointer' }"><em class="text--alert">배분 미완료</em></td>
						<td @click="goDetail(vo.organizationCode,vo.organizationName)">{{vo.giasState}}</td>
						<td @click="goStatus(vo.organizationCode,vo.organizationName)"><button type="button" class="btn btn--primary btn--outline btn--xs">통계보기</button></td>
						<td>{{vo.joinDate}}</td>
						<td v-if="vo.state == 0"><em class="text--alert">비활성</em></td>
						<td v-if="vo.state == 1"><em class="text--complete">활성</em></td>
						<td>{{vo.memberName}}</td>
						<td v-if="vo.state == 0"><button type="button" class="btn btn--primary btn--outline btn--xs" @click="changeStatus(vo.organizationCode, vo.state)" >활성화</button></td>
						<td v-if="vo.state == 1"><button type="button" class="btn btn--alert btn--outline btn--xs" @click="changeStatus(vo.organizationCode, vo.state)" >비활성화</button></td>
					</tr>
				</table>
			</div>

			<!--페이징-->
		<Pagination v-if="orgJson.pagination" :gridInfo="orgJson" @getGridData="getGridData" @click="goPage()" />
		</div>
	</div>
</template>
   
<script setup>
import { useStore } from 'vuex'
import { ref, computed, onMounted, onUnmounted ,watch} from 'vue'
import orgJson from '@/models/gridInfo/org.json'
import Pagination from '@/components/common/grid/pagination.vue'
import { useRouter } from 'vue-router'
import { updateOrgState,deleteOrg } from '@/api/org'

const store = useStore()
const router = useRouter()
	
const searchText = ref('')
const searchCode = ref('all')
const searchOrg = ref('all')
const checkUserId = computed(() => store.state.temp.userInfo )


const orgList = computed(() => {
	return store.state.grid.orgData
})

const searchParam = computed(() => {
	return store.state.temp.searchParam 
})

const checkedItems = ref(orgList.value.map(() => false));

const isAllChecked = ref(false)

//const isAllChecked = ref(localStorage.getItem('isAllChecked') === 'true');
// 팝업창
const openDistributionStatus = (organizationCode) => {
	console.log("기관코드 확인 : ",organizationCode)
	store.commit('member/setMember', organizationCode)
    store.commit('temp/setIsDistributionStatus')
}

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

const goPage = () => {
	console.log("searchParam.value.pageNo : " + searchParam.value.pageNo)
	// localStorage.setItem('searPageNo', searchParam.value.pageNo);
};

const goDetail = (orgCode,orgName) => {
	router.push({
		name :'organizationView',
		query : {
			organizationCode : orgCode,
			organizationName : orgName
		}
	})
}

const goStatus = (orgCode,orgName) => {
	router.push({
		name :'organizationGiasStats',
		query : {
			organizationCode : orgCode,
			organizationName : orgName
		}
	})
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
		typeCd : searchCode.value
	}
	console.log()
	await store.dispatch('grid/fetchOrgVue', param)
}

const changeStatus = async (organizationCode,state) =>{
	if(state == 1){
		if (confirm("비활성화 처리하시겠습니까? ")) {
			let param = {
				organizationCode : organizationCode,
			}
			let rtn = await updateOrgState(param)
			
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
				organizationCode : organizationCode,
			}
			let rtn = await updateOrgState(param)
			
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
    const selectedOrgs = orgList.value
        .filter((notice, index) => checkedItems.value[index])
        .map((selectedNotice) => ({ organizationCode: selectedNotice.organizationCode }));

    // 배열에 저장된 객체 배열을 콘솔에 출력
    console.log('Selected Notice Objects:', selectedOrgs);

    if (selectedOrgs.length < 1) {
        alert("선택된 공지가 없습니다.");
        return false;
    }

    //여기서 deleteNotice API 호출
    if (confirm("정말 삭제하시겠습니까?")) {
        let rtn = await deleteOrg(selectedOrgs); // 객체 배열을 그대로 전달
        console.log("선택된 공지사항 목록:", selectedOrgs);
        
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

onMounted(async () => {
	console.log("맴버 코드 확인" ,checkUserId.value.memberCode)
	// searchCode.value = searchParam.value.searchCode || 'all'
	// searchText.value = searchParam.value.searchText
	await getGridData()
})

onUnmounted(() => {
	//store.commit('temp/clearSearchParam')
	// 페이지 닫힐 때 해당 리스너 삭제
	
}) 

</script>

<style></style>