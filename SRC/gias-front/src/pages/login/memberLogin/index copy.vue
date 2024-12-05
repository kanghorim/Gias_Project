<template>
    <div class="login">
        <div class="login__wrap">
            <img class="login__logo" src="@/assets/common/artner_consulting_logo_transparent.png" alt="애니스소프트">
            <div class="login__box">
                <p class="login__title">LOGIN</p>
                <div class="login__inputs">

                    <!-- 로그인 인풋 -->
                    <div class="input-box__wrap">
                        <div class="input-box">
                            <label>아이디</label>
                            <input type="text" v-model="state.id">
                        </div>
                        <div class="input-box">
                            <label>비밀번호</label>
                            <input type="password" v-model="state.password" @keyup.enter="goLogin">
                        </div>
                        <button type="button" class="btn btn--primary btn--full" @click="goLogin">로그인</button>
                    </div>

                    <!-- 로그인 옵션 -->
                    <div class="login__option">
                        <!-- <a class="login__option--left" href="#">아이디/비밀번호 찾기</a> -->
                        <a class="login__option--right" @click="goJoin">평가원 등록</a>
                    </div>

                </div>
            </div>
            <p class="login__help">
                <span>로그인 문의</span>
                <a href="tel:000-0000-0000">000-0000-0000</a>
            </p>
        </div>
    </div>
</template>
   
<script setup>
import { useStore } from 'vuex'
import { ref, computed, onMounted, onUnmounted ,reactive } from 'vue'
import { useRouter } from 'vue-router'
import * as Utils from '@/common/util/util'
import { userLogin } from '@/api/user'

const store = useStore()
const router = useRouter()
	
const state = reactive({
    id: '',
    password: '',
});

const noticeList = computed(() => {
		return store.state.grid.gridData
})

const searchParam = computed(() => {
	return store.state.grid.pagination
})

const goJoin = async () => {
	router.push({ name: 'join' })
}

const checkField = () => {

    if (Utils.isEmpty(state.id)) {
		alert("아이디를 입력해주세요")
		return false
	}

	if (Utils.isEmpty(state.password)) {
		alert("비밀번호를 입력해주세요")
		return false
	}
	return true
}

const goLogin = async () => {
    if (!checkField()) { return false }
    
    let param = {
        id: state.id,
        memberPassword: state.password
    }

    const resultVo = await userLogin(param)
    
    console.log("결과" + resultVo)
    if (resultVo?.result == 'ok') {
        alert(resultVo.resultMsg)
        //console.log("맴버 코드" ,resultVo.data.memberCode)
        store.commit('temp/setUserInfo', {key : 'memberCode', value: resultVo.data.memberCode})
        store.commit('temp/setUserInfo', {key : 'memberName', value: resultVo.data.memberName})
        store.commit('temp/setUserInfo', {key : 'organizationCode', value: resultVo.data.organizationCode})
        store.commit('temp/setUserInfo', {key : 'privilege', value: resultVo.data.privilege})
        router.push({ name: 'noticeList' })
    } else {
        //alert("실패")
        alert(resultVo.resultMsg)
    }

}
onMounted(async () => {
    document.body.classList.add("body");
})

onUnmounted(() => {
    document.body.classList.remove("body");
}) 

</script>

<style>
	/* 콤보박스 스타일 */
	.input-box select {
		width: 100%; /* 입력창과 동일한 너비 */
		padding: 8px; /* 입력창과 동일한 패딩 */
		border: 1px solid #ccc;
		border-radius: 5px;
		font-size: 16px;
	}
   .login {
        display: table;
        width: 100%;
        height: 100vh;
        padding: 3rem 0;
        background-color: #f5f5f5;
    }

</style>