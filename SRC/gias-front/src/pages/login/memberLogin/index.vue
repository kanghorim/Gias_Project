<template>
  <div class="login-page">
    <div class="login-header">
      <img src="@/assets/common/artner_consulting_logo_transparent.png" alt="아트너 컨설팅 로고" class="logo" />
      <h1>
        <span>
          <span class="highlight-green">G</span>lobal 
          <span class="highlight-blue">I</span>nternal 
          <span class="highlight-green">A</span>udit 
          <span class="highlight-blue">S</span>tandard
        </span>
        <br />
        <span class="subtitle">Quality Assurance Assessment Platform</span>
      </h1>
    </div>
    <div class="login-box">
      <p class="login-title">LOGIN</p>
      <div class="input-box">
        <label>아이디</label>
        <input type="text" placeholder="아이디를 입력해주세요" v-model="state.id" />
      </div>
      <div class="input-box">
        <label>비밀번호</label>
        <input type="password" placeholder="비밀번호를 입력해주세요" v-model="state.password" @keyup.enter="goLogin" />
      </div>
      <button type="button" class="login-button" @click="goLogin">로그인</button>
      <button type="button" class="register-button" @click="goJoin">평가원 등록</button>
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

<style scoped>
.login-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  background-color: #f4f4f4;
}

.login-header {
  text-align: center;
  margin-bottom: 30px;
}

.logo {
  max-width: 150px;
  margin-bottom: 20px;
}

h1 {
  font-size: 28px;
  font-weight: bold;
  line-height: 1.4;
}

.highlight-green {
  color: #2e7d32; /* 초록색 */
}

.highlight-blue {
  color: #007bff; /* 파란색 */
}

.subtitle {
  font-size: 16px;
  font-weight: normal;
  color: #555;
}

.login-box {
  width: 100%;
  max-width: 400px;
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

.login-title {
  font-size: 20px;
  font-weight: bold;
  text-align: center;
  margin-bottom: 20px;
}

.input-box {
  margin-bottom: 15px;
}

.input-box label {
  display: block;
  font-size: 14px;
  font-weight: bold;
  margin-bottom: 5px;
}

.input-box input {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 14px;
}

.login-button {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: #fff;
  font-size: 16px;
  font-weight: bold;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.login-button:hover {
  background-color: #0056b3;
}
.register-button {
  width: 100%;
  padding: 10px;
  margin-top: 10px; /* 로그인 버튼과 간격 추가 */
  background-color: #28a745; /* 녹색 */
  color: #fff;
  font-size: 16px;
  font-weight: bold;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.register-button:hover {
  background-color: #218838;
}
</style>
