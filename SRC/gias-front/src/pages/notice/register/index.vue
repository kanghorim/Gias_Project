<template>
<!--컨텐츠-->
<div class="contents">
	<div class="contents__wrap">

		<!--페이지 상단-->
		<div class="sub-top">
			<h3>공지 등록</h3>
			<div class="sub-top__navi">
				<span class="icon-home navi--home"></span>
				<span>공지 관리</span>
			</div>
		</div>

		<!--공지 등록-->
		<div class="board-write spacing--xs">
			<table class="table table--break">
				<colgroup>
					<col style="width:20%;">
					<col style="width:auto;">
				</colgroup>
				<tr>
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
					<td><input type="text" v-model="insertTitle" placeholder="내용을 입력해 주세요"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea placeholder="내용을 입력해주세요" v-model="insertContent" ></textarea>
					</td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td colspan="2" >
						<input type="file" class="attach-btn" id="attach_ex1" @input="selectFile">
						<img class="doc-background" v-if="noticeInfo.file" :src = "noticeInfo.filePreview">
						<!-- <img src = "http://localhost:8099/resources/assets/images/esubAdmin/local/notice/74.png" /> -->
						<div>
							<label for="attach_ex1" class="btn btn--sm btn--secondary">파일첨부</label>
							<ul class="attach-list">
								<li>
									<span v-if="noticeInfo.file">{{ noticeInfo.file.fileNm }}</span>
									<button type="button" class="icon-x" v-if="noticeInfo.file" @click="selectIconX"></button>
								</li>
							</ul>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="btns btns--center spacing--xs">
			<button type="button" @click="goBack()" class="btn btn--sm btn--basic icon-x">닫기</button>
			<button type="button" @click="goSave()" class="btn btn--sm btn--primary icon-check" v-if ="checkUserId.privilege == 'sAdmin'"> 등록</button>
		</div>


	</div>
</div>
</template>
   
<script setup>
import { useStore } from 'vuex'
import { ref, computed, onMounted, onUnmounted } from 'vue'
//import Pagination from '@/components/common/grid/pagination'
import noticeJson from '@/models/gridInfo/notice.json'
import { useRouter } from 'vue-router'
import { insertNotice } from '@/api/notice'
import * as Utils from '@/common/util/util'
const store = useStore()
const router = useRouter()

const insertTitle = ref('')
const insertContent = ref('')
const checkUserId = computed(() => store.state.temp.userInfo )
const noticeInfo = store.state.notice.noticeInfo

const orgDataList = computed(() => {
	return store.state.grid.orgData
})

const searchOrg = ref('') // 초기값을 빈 문자열로 설정
const checkField = () => {
	//alert("수정하는 유저 : " + checkUserId.value.userId)

	if (insertTitle.value == '') {
		alert("제목을 입력해 주세요.")
		return false
	}
	if (insertContent.value == '') {
		alert("내용을 입력해 주세요.")
		return false
	}
	if (Utils.isEmpty(checkUserId.value.memberCode)) {
		alert("유저 ID를 가져오는데 실패했습니다.")
		return false
	}        
	return true
}

const goSave = async () => {
	if (!checkField()) { return false }

	if (confirm("저장하시겠습니까?")) {
		const params = new FormData()
		params.append("noticeTitle", insertTitle.value)
		params.append("noticeContent", insertContent.value)
		params.append("memberCode", checkUserId.value.memberCode)
		params.append("organizationCode", searchOrg.value)
		//params.append("userId", '')
		if(noticeInfo.file.file != null){
			//console.log("파일이 있습니다.")
			params.append("noticeInputFile", noticeInfo.file.file)
		}
		
		const resultVo = await insertNotice(params)
		
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

const goBack = () => {
	router.push({ name: 'noticeList' })
}

 //파일 선택
const selectFile = (e) => {
	var input = e.target.files[0]
	var flag = false

	console.log("파일선택 호출")
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
				//console.log("원본 이미지 이름 : " + fileObject.preview)
				noticeInfo.file = fileObject
			}
		} else {
			alert('이미 선택한 파일입니다.')
			return
		}
	} else {
		return
	}
}
const selectIconX = (() => {
	//console.log("x버튼 누름" + noticeInfo.file)
	noticeInfo.file = ''
	//noticeInfo.file.fileNm = ''
	const fileInput = document.getElementById('attach_ex1');
	fileInput.value = '';
	
})
const getComboData = async () => {
	await store.dispatch('grid/fetchOrg')
}

onMounted(async () => {
	await getComboData()	
})

onUnmounted(() => {
	//store.commit('temp/clearSearchParam')
	// 페이지 닫힐 때 해당 리스너 삭제
	
}) 

</script>

<style></style>