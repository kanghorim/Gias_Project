<template>
<!--헤더-->
<div class="header">
	<div class="header__top">
		<h1 class="logo">
			<a href="#">
				<img class="logo--base" src="@/assets/common/Artner Consulting_logo_ai [변환됨].png" alt="SuBPay" @click="goMenu('noticeList')">
				<img class="logo--sm" src="@/assets/common/Artner Consulting_logo_ai [변환됨].png" alt="SuBPay" @click="goMenu('noticeList')" >
				<img class="logo--symbol" src="@/assets/common/Artner Consulting_logo_ai [변환됨].png" alt="SuBPay" @click="goMenu('noticeList')">
			</a>
		</h1>
		<div class="login-info">
			<div class="login-info__initial"> 
				<span></span>
			</div>
			<div class="login-info__detail">
				<p class="login-info__name"><em>{{checkUserId.memberName}}님</em> <span>환영합니다.</span></p>
				<div class="login-info__btns">
					<a href="#" class="login-info__setting">설정</a>
					<router-link to="/login" v-if="checkUserId.memberCode != ''" @click="logOut">로그아웃</router-link>
				</div>
			</div>
		</div>
	</div>
	<button type="button" class="btn__menu btn__gnb"><span></span></button>
	<div class="gnb">
		<p class="gnb__tit">MENU</p>
		<ul class="gnb__menu">
			<li :class="{ 'on': isGiasRoute }">
				<button type="button" class="icon-alert"><span>품질평가</span></button>
				<ul>
					<li :class="{ 'on': isGiasInputRoute }">
						<a @click="goMenu('giasInput')" src="">품질평가 입력</a>
					</li>
					<li :class="{ 'on': isGiasStatsRoute }"> 
						<a @click="goMenu('giasStats')" src="">품질평가 결과</a>
					</li>
					<!-- <li> 
						<a @click="goMenu('tempList')" src="">임시메뉴</a>
					</li> -->
				</ul>
			</li>
			<li v-if="checkUserId.privilege == 'sAdmin'" :class="{ 'on': isNoticeRoute }">
				<button type="button" class="icon-document-check" @click="goMenu('noticeList')"><span>공지 관리</span></button>
			</li>
			<li v-if="checkUserId.privilege != 'sAdmin'" :class="{ 'on': isNoticeRoute }">
				<button type="button" class="icon-document-check" @click="goMenu('noticeList')"><span>공지</span></button>
			</li>
			<li v-if="checkUserId.privilege == 'sAdmin'" :class="{ 'on': isOrgRoute }">
				<button type="button" class="icon-layout" @click="goMenu('organization')"><span>기관 관리</span></button>
			</li>
			<li v-if="checkUserId.privilege == 'sAdmin'"  :class="{ 'on': isAdminRoute }">
				<button type="button" class="icon-person" @click="goMenu('admin')" ><span>평가원 관리</span></button>
			</li>
		</ul>
		<button type="button" class="icon-left-circle btn__collapse"><span>메뉴접기</span></button>
	</div>
	<div class="gnb__bg"></div>
</div>
</template>

<script setup>
import { useStore } from 'vuex'
import { computed,onMounted,ref  } from 'vue'
import { useRouter, useRoute } from 'vue-router'
import { getCurrentInstance } from "vue";
const route = useRoute();
const router = useRouter()
const store = useStore()
const checkUserId = computed(() => store.state.temp.userInfo )

const goMenu = (name) => {
  if (route.name === name && name === "giasInput") {
	router.go(0);
  } else {
    router.push({ name })
  }
}

const isGiasRoute = computed(() => 
		route.name === 'giasInput' ||
		route.name === 'giasStats' 
);

const isGiasInputRoute = computed(() => 
		route.name === 'giasInput' 
);

const isGiasStatsRoute = computed(() => 
		route.name === 'giasStats' 
);

const isAdminRoute = computed(() => 
		route.name === 'admin' ||
		route.name === 'adminView'
);

const isNoticeRoute = computed(() => 
		route.name === 'noticeList' ||
		route.name === 'register' || 
		route.name === 'noticeView'||
		route.name === 'Home'
);

const isOrgRoute = computed(() => 
		route.name === 'organization' ||
		route.name === 'organizationView'||
		route.name === 'organizationGiasStats'
);

const logOut = async () => {
	store.commit('temp/clearUserInfo')
	store.commit('grid/clearSearchParam')
}

onMounted(() => {
    
});
</script>

