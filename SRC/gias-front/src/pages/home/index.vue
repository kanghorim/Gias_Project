<template>
	<!--컨텐츠-->
	<div class="contents contents--full">
		<div class="contents__wrap">

			<!--페이지 상단-->
			<div class="sub-top">
				<h3>공지 관리</h3>
				<div class="sub-top__navi">
					<span class="icon-home navi--home"></span>
					<span>공지 관리</span>
				</div>
			</div>

			<!--검색박스-->
			<div class="searchbox spacing--xs">
				<div class="searchbox__box">
					<div class="searchbox__frame">
						<div v-if ="checkUserId.privilege == 'sAdmin'" >
							<select v-model="searchOrg">
								<option value="all">전체</option>
								<option v-for="(org, index1) of orgDataList" :key="index1" :value="org.organizationCode">{{org.organizationName}}</option>
							</select>
						</div>
						<div>
							<select v-model="searchCode">
								<option value="all">전체</option>
								<option value="title">제목</option>
								<option value="content">내용</option>
							</select>
						</div>
						<div class="searchbox__input">
							<div class="input-btn">
								<input type="text" placeholder="내용을 입력해주세요" v-model="searchText" @keyup.enter="gridLoad">
								<button type="button" @click="gridLoad" class="btn btn--primary btn--icon icon-search"></button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!--목록 checkUserId  -->
			<div class="btns btns--right spacing--sm" v-if ="checkUserId.privilege == 'sAdmin'">
				<button type="button" class="btn btn--sm btn--secondary icon-check" @click="deleteNoticeInfo()" >공지 삭제</button>
				<button type="button" @click="$router.push('/notice-register')" class="btn btn--sm btn--primary icon-check">공지 등록</button>
			</div>
			<div class="table__wrap spacing--xxxs">
				<table class="table table--split" style="min-width:768px;">
					<tr>
						<th v-if ="checkUserId.privilege == 'sAdmin'" >
							<input type="checkbox" id="check_all" @change="toggleAll(isAllChecked)" v-model="isAllChecked">
							<label for="check_all"></label>
						</th>
						<th>No</th>
						<th>제목</th>
						<th>대상기관</th>
						<th>작성자</th>
						<th>등록일자</th>
					</tr>
					<tr v-for="(vo, index) of noticeList" :key="index">
						<td v-if ="checkUserId.privilege == 'sAdmin'" >
							<input type="checkbox" :id="'check_' + index" v-model="checkedItems[index]">
							<label :for="'check_' + index"></label>
						</td>
						<td>{{vo.no}}</td>
						<td @click="goDetail(vo.noticeCode)" :style="{ cursor: 'pointer' }" >{{vo.noticeTitle}}</td>
						<td  v-if="vo.organizationName != null">{{vo.organizationName}}</td>
						<td  v-if="vo.organizationName == null">전체</td>
						<td>{{vo.memberName}}</td>
						<td>{{vo.updateAt}}</td>
					</tr>
				</table>
			</div>

			<!--페이징-->
			<Pagination v-if="noticeJson.pagination" :gridInfo="noticeJson" @getGridData="getGridData" />
		</div>
	</div>
</template>
   
<script setup>
import { useStore } from 'vuex'
import { ref, computed, onMounted, onUnmounted ,watch} from 'vue'
import noticeJson from '@/models/gridInfo/notice.json'
import Pagination from '@/components/common/grid/pagination.vue'
import { useRouter } from 'vue-router'
import { deleteNotice } from '@/api/notice'
const store = useStore()
const router = useRouter()
	
const searchText = ref('')
const searchCode = ref('all')
const searchOrg = ref('all')
const checkUserId = computed(() => store.state.temp.userInfo )
const noticeList = computed(() => {
	return store.state.grid.gridData
})

const searchParam = computed(() => {
	return store.state.temp.searchParam 
})

const orgDataList = computed(() => {
	return store.state.grid.orgData
})

// 페이징 클릭시 로컬스토리지에 저장
const goPage = () => {
	console.log("searchParam.value.pageNo : " + searchParam.value.pageNo)
	// localStorage.setItem('searPageNo', searchParam.value.pageNo);
};
const getGridData = async () => {

	if(checkUserId.value.privilege != 'sAdmin'){
		let param = {
			pageNo : searchParam.value.pageNo,
			countPerRecord : searchParam.value.countPerRecord,
			search : searchText.value,
			typeCd : searchCode.value,
			organizationCode :checkUserId.value.organizationCode,
			userGrade : 'user'
		}
		await store.dispatch('grid/fetchNotice', param)
	}else{
		let param = {
			pageNo : searchParam.value.pageNo,
			countPerRecord : searchParam.value.countPerRecord,
			search : searchText.value,
			typeCd : searchCode.value,
			organizationCode :searchOrg.value,
			userGrade : 'sAdmin'
		}
		await store.dispatch('grid/fetchNotice', param)
	}

}

const getComboData = async () => {
	await store.dispatch('grid/fetchOrg')
}


const gridLoad = () => {
	store.commit('temp/setSearchParam', {key : 'pageNo', value : 1})
	store.commit('temp/setSearchParam', {key : 'searchCode', value:searchCode.value})
	store.commit('temp/setSearchParam', {key : 'searchText', value:searchText.value})
	getGridData()
}

const goDetail = (noticeCode) => {
	router.push({
		name :'noticeView',
		query : {
			noticeCode : noticeCode
		}
	})
	console.log(noticeCode)
}

const checkedItems = ref(noticeList.value.map(() => false));

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

const deleteNoticeInfo = async () => {
    // 체크된 항목들의 vo.no를 객체 배열로 저장
    const selectedNotices = noticeList.value
        .filter((notice, index) => checkedItems.value[index])
        .map((selectedNotice) => ({ noticeCode: selectedNotice.noticeCode }));

    // 배열에 저장된 객체 배열을 콘솔에 출력
    console.log('Selected Notice Objects:', selectedNotices);

    if (selectedNotices.length < 1) {
        alert("선택된 공지가 없습니다.");
        return false;
    }

    // 여기서 deleteNotice API 호출
    if (confirm("정말 삭제하시겠습니까?")) {
        let rtn = await deleteNotice(selectedNotices); // 객체 배열을 그대로 전달
        console.log("선택된 공지사항 목록:", selectedNotices);
        
        if (rtn.result == 'ok') {
            alert(rtn.resultMsg);
            gridLoad();
            // 삭제 후 체크박스 전부 해제
            for (let i = 0; i < checkedItems.value.length; i++) {
                checkedItems.value[i] = false; 
            }
        } else { 
            alert(rtn.resultMsg);
        }
    }
};

const getPositionData  = async () => { 
	let param = {
	}
	await store.dispatch('grid/fetchOrg', param)
}

onMounted(async () => {
	await getComboData()
	console.log("맴버 코드 확인" ,checkUserId.value.memberCode)
	searchCode.value = searchParam.value.searchCode || 'all'
	searchText.value = searchParam.value.searchText
	await getGridData()
		// 글쓰기, 수정하기 이벤트리스너 체크 
	console.log("로그인한 사람의 권한" + checkUserId.value.privilege)
		
})

onUnmounted(() => {
	//store.commit('temp/clearSearchParam')
	// 페이지 닫힐 때 해당 리스너 삭제
	
}) 

</script>

<style></style>