<template>
<!--컨텐츠-->
<div class="contents">
	<div class="contents__wrap">

		<!--페이지 상단-->
		<div class="sub-top">
			<h3>공지 수정</h3>
			<div class="sub-top__navi">
				<span class="icon-home navi--home"></span>
				<span>공지 수정</span>
			</div>
		</div>

		<!--공지 등록-->
		<div class="board-write spacing--xs">
			<table class="table table--break">
				<colgroup>
					<col style="width:20%;">
					<col style="width:auto;">
				</colgroup>
				<tr v-if ="checkUserId.privilege == 'sAdmin'" >
					<th>대상기관</th>
					<td>
						<div>
							<select v-model="searchOrg">
								<option value="">전체</option>
								<option v-for="(org, index1) of orgDataList" :key="index1" :value="org.organizationCode">{{org.organizationName}}</option>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input 
							type="text" 
							placeholder="내용을 입력해 주세요" 
							v-model="pageData.noticeTitle" 
							:readonly="checkUserId.privilege !== 'sAdmin'"
						>
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea 
							placeholder="내용을 입력해주세요" 
							v-model="pageData.noticeContent" 
							:readonly="checkUserId.privilege !== 'sAdmin'"
						></textarea>
					</td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td colspan="2">
						<input type="file" class="attach-btn" id="attach_ex1" @change="selectFile">
						<img
							class="doc-background"
							v-if="noticeInfo.file && isImageFile(noticeInfo.file.fileNm)"
							:src="noticeInfo.filePreview"
						/>
						<img
							class="doc-background"
							v-else-if="pageData.noticeFile != '' && pageData.noticeFile != null && isImageFile(pageData.noticeFile)"
							:src="`http://192.168.0.37:8081${pageData.noticeFile}`"
						/>

						<div>
							<label for="attach_ex1" class="btn btn--sm btn--secondary" v-if ="checkUserId.privilege == 'sAdmin'" >파일첨부</label>
							<ul class="attach-list">
								<li>
									<span v-if ="noticeInfo.file">{{ noticeInfo.file.fileNm }}</span>
									<span v-else-if = "pageData?.noticeFile != '' && pageData.noticeFile != null ">{{ pageData?.noticeFileName}}</span>
									<button type="button" class="icon-x" v-if="noticeInfo.file && checkUserId.privilege == 'sAdmin'" @click="selectIconX"></button>
									<button type="button" class="icon-x" v-else-if = "pageData.noticeFile != '' && pageData.noticeFile != null && checkUserId.privilege == 'sAdmin'" @click="selectIconX"></button>
								</li>
							</ul>
						</div>
					</td>
				</tr>
				<tr v-if = "pageData.noticeFile != '' && pageData.noticeFile != null ">
					<th>파일 다운로드</th>
					<td>
						<label for="attach_ex2" class="btn btn--sm btn--secondary" @click="downloadFile(pageData?.noticeFile, pageData?.noticeFileName)">파일 다운로드</label>
					</td>
				</tr>
			</table>
		</div>
		<div class="btns btns--center spacing--xs">
			<button type="button" @click="goBack()" class="btn btn--sm btn--basic icon-x">닫기</button>
			<button type="button" @click="goUpdate" class="btn btn--sm btn--primary icon-check"v-if ="checkUserId.privilege == 'sAdmin'" >수정</button>
		</div>


	</div>
</div>
</template>
   
<script setup>
import { useStore } from 'vuex'
import { ref, computed, onMounted, onUnmounted } from 'vue'
//import Pagination from '@/components/common/grid/pagination'
import noticeJson from '@/models/gridInfo/notice.json'
import { useRouter,useRoute } from 'vue-router'
import * as Utils from '@/common/util/util'
import { updateNotice } from '@/api/notice'
import axios from 'axios';

const router = useRouter()
const route = useRoute()
const store = useStore()
const searchOrg = ref('') // 초기값을 빈 문자열로 설정
const noticeInfo = store.state.notice.noticeInfo
const checkUserId = computed(() => store.state.temp.userInfo )
// 데이터 상세
const pageData = computed(() => {
	return store.state.notice.noticeViewData
})
const orgDataList = computed(() => {
	return store.state.grid.orgData
})

const goBack = () => {
	router.push({ name: 'noticeList' })
}

const checkField = () => {
	//alert("수정하는 유저 : " + checkUserId.value.userId)

	if (Utils.isEmpty(pageData.value.noticeTitle)) { 
		alert("제목을 입력해 주세요.")
		return false
	}
	if (Utils.isEmpty(pageData.value.noticeContent)) {
		alert("내용을 입력해 주세요.")
		return false
	}
	if (Utils.isEmpty(checkUserId.value.memberCode)) {
		alert("유저 ID를 가져오는데 실패했습니다.")
		return false
	}        
	return true
}

const isImageFile = (fileName) => {
    const imageExtensions = ['png', 'jpg', 'jpeg', 'gif', 'bmp', 'webp'];
    const extension = fileName?.split('.').pop()?.toLowerCase(); // 확장자 추출
    return imageExtensions.includes(extension); // 확장자가 이미지인지 확인
};


const selectIconX = (() => {
	console.log("x버튼 누름" + noticeInfo.file)
	noticeInfo.file = ''
	const fileInput = document.getElementById('attach_ex1');
	fileInput.value = '';
  
  if (pageData.value) {
      pageData.value.noticeFile = '';
      pageData.value.noticeFileName = '';
	}
})

//파일선택
const selectFile = (e) => {
	var input = e.target.files[0]
	var flag = false
	console.log("여기서 걸리는건가?" , noticeInfo.filePreview)
	if (input != null) {
		if (Utils.isNotEmpty(noticeInfo.file) && noticeInfo.file.fileNm === input.name) {
			flag = true
		}

		if (!flag) {
			var fileObject = {
				file: input,
				fileNm: input.name,
				preview: window.URL.createObjectURL(input),
				type: e.target.id
			}
			//이미지 프리뷰
			if(fileObject.type === 'attach_ex1'){
				noticeInfo.filePreview = fileObject.preview
				console.log("이미지 이름 : " + noticeInfo.filePreview)
				noticeInfo.file = fileObject
			if (pageData.value) {
				pageData.value.imageUrl = '';
			}
				
			}
		} else {
			alert('이미 선택한 파일입니다.')
			return
		}
	} else {
		console.log("여기서 걸리는건가?")
		return
	}
}

// 파일을 다운받는 함수
const downloadFile = async (fileUrl, fileName) => {
  try {
    const response = await axios({
		url: fileUrl,
		method: 'GET',
		responseType: 'blob', // 중요: 서버로부터의 응답을 Blob 객체로 받습니다.
    });

    // Blob 데이터를 다운로드용 링크로 생성
    const url = window.URL.createObjectURL(new Blob([response.data]));
	console.log("url : " + url)
    const link = document.createElement('a');
    link.href = url;
    link.setAttribute('download', fileName); // download폴더 안에 fileName이란 이름으로 파일 다운
    document.body.appendChild(link);
    link.click();

    // 정리
    document.body.removeChild(link);
    window.URL.revokeObjectURL(url);
  } catch (error) {
    console.error('다운로드 중 에러 발생:', error);
  }
};


const getComboData = async () => {
	await store.dispatch('grid/fetchOrg')
}

const goUpdate = async () => {
	if (!checkField()) { return false }

	if (confirm("수정하시겠습니까?")) {
		const params = new FormData()
		params.append("noticeCode", pageData.value.noticeCode)
		params.append("noticeTitle", pageData.value.noticeTitle)
		params.append("noticeContent", pageData.value.noticeContent)
		params.append("memberCode", checkUserId.value.memberCode)
		params.append("organizationCode", searchOrg.value)
		
		// 파일을 수정할것이다.
		if(noticeInfo.file.file != null){
			//console.log("파일이 있습니다.")
			params.append("noticeInputFile", noticeInfo.file.file)
			params.append("checkFile", '')
		}
		if(pageData.value.noticeFile == ''){ // 기존의 공지사항의 파일을 삭제한다.
			params.append("checkFile", '')
		}else{ // 현상유지한다.
			params.append("checkFile", 'Maintenance')
		}
		const resultVo = await updateNotice(params)
		
		if (resultVo?.result == 'ok') {
			router.push({ name: 'noticeList' })
			alert(resultVo.resultMsg)
			store.commit('notice/clearNoticeInfo')
		} else {
			//alert("실패")
			alert(resultVo.resultMsg)
			store.commit('notice/clearNoticeInfo')
		}
	}
}

onMounted(async () => {
	await store.dispatch('notice/fetchNoticeView', { noticeCode: route.query?.noticeCode })
	store.commit('notice/clearNoticeInfo')	
	await getComboData()
	
	// onMounted 안에서 pageData의 값을 searchOrg에 할당
	searchOrg.value = pageData.value.organizationCode || ''
	console.log("기관코드확인 : " + searchOrg.value)
	console.log("로그인한 사람의 권한" + checkUserId.value.privilege)
})

onUnmounted(() => {
	// 페이지 닫힐 때 해당 리스너 삭제
	store.commit('notice/clearNoticeInfo')
}) 

</script>

<style></style>