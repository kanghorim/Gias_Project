<template>
<div class="login">
        <div class="login__wrap">
            <div class="login__box login__box--join">
                <P class="login__title">평가원 수정</P>
                <div class="login__inputs">
                    <!--로그인 인풋-->
                    <div class="input-box__wrap input-box__wrap--double">
                        <div class="input-box">
                            <label>아이디</label>
                            <input type="text" v-model="state.id">
                        </div>
                        <div class="input-box">
                            <label>이름</label>
                            <input type="text" v-model="state.name">
                        </div>
                        <div class="input-box">
                            <label>비밀번호</label>
                            <input type="password" v-model="state.password">
                        </div>
                        <div class="input-box">
                            <label>비밀번호 확인</label>
                            <input type="password" v-model="state.passwordConfirm">
                        </div>
                        <div class="input-box">
                            <label>부서명</label>
                            <input type="text" v-model="state.dept">
                        </div>
                        <div class="input-box">
                            <label>권한</label>
                            <select style="width: 100%" v-model="state.privilege" @change="onChange()" >
							    <option value="N">권한을 선택해주세요</option>
                                <option value="sAdmin">최고 관리자</option>
							    <option value="admin">슈퍼 관리자</option>
                                <option value="user">일반 관리자</option>
						    </select>
                        </div>
						<div class="input-box">
                            <label>기관</label>
                            <select style="width: 100%" v-model="state.organizationCode" @change="onChange()" >
							    <option value="A">기관을 선택해주세요</option>
                                <option value="A00004">국민연금기관</option>
							    <option value="A00005">기술보증기관</option>
                                <option value="A00006">신용보증기금</option>
						    </select>
                        </div>
						 <div class="input-box">
                            <label>핸드폰번호</label>
                            <input type="text" v-model="state.phonNumber">
                        </div>
                        <button type="button" class="btn btn--primary btn--full" @click="goJoin">관리자 등록</button>
                    </div>

                    <!--로그인 옵션-->
                    <!-- <div class="login__option">
                        <a class="login__option--left" @click="goMenu('user')" src="">로그인하기</a>
                    </div> -->

                </div>
            </div>
            <!-- <p class="login__help">
                <span>로그인 문의</span>
                <a href="tel:1588-3740">1588-3740</a>
            </p> -->
        </div>
    </div>
</template>
   
<script setup>
import { onMounted, reactive } from 'vue'
import { useStore } from 'vuex'
import { useRouter } from 'vue-router'
import * as Utils from '@/common/util/util'
import { userJoin } from '@/api/user'

const store = useStore()
const router = useRouter()

const onChange = () => {
  // 선택된 값에 대한 작업을 수행합니다.

};

const state = reactive({
    id: '',
    password: '',
    passwordConfirm : '',
    name : '',
    dept : '',
    privilege : 'N',
	organizationCode : 'A',
	phonNumber : '',
});

const formatPhoneNumber = (number) => {
    // 숫자가 11자리인지 확인
    const plainNumber = number.replace(/[^0-9]/g, ''); // 숫자만 추출
    if (plainNumber.length !== 11) {
        alert("핸드폰 번호는 숫자 11자리여야 합니다.");
        return null;
    }

    // 010-1234-1234 형식으로 변환
    return plainNumber.replace(/(\d{3})(\d{4})(\d{4})/, '$1-$2-$3');
};


const checkField = () => {

    if (Utils.isEmpty(state.id)) {
		alert("아이디를 입력해주세요")
		return false
	}

	if (Utils.isEmpty(state.password)) {
		alert("비밀번호를 입력해주세요")
		return false
	}
	if (Utils.isEmpty(state.passwordConfirm)) {
		alert("비밀번호 확인창을 확인해주세요")
		return false
	}
	if (Utils.isEmpty(state.name)) {
		alert("이름을 입력해주세요")
		return false
	}      
    if (Utils.isEmpty(state.dept)) {
		alert("부서를 입력해주세요")
		return false
	}
	if (state.privilege == "N") {
		alert("권한을 설정해주세요")
		return false
	}
   
    if (state.password != state.passwordConfirm) {
		alert("비밀번호와 비밀번호 확인 값이 다릅니다.")
		return false
	}

	if (state.organizationCode == "A") {
		alert("기관을 선택해주세요")
		return false
	}
	if (Utils.isEmpty(state.phonNumber)) {
		alert("핸드폰 번호를 입력해주세요")
		return false
	}
	return true
}

const goJoin = async () => {
	if (!checkField()) { return false }

	const formattedPhone = formatPhoneNumber(state.phonNumber);
    if (!formattedPhone) {
        return false; // 번호가 유효하지 않으면 함수 종료
    }
	if (confirm("등록하시겠습니까?")) {

        let param = {
            id: state.id,
            memberPassword: state.password,
            memberName : state.name,
            dept : state.dept,
			organizationCode : state.organizationCode,
            privilege : state.privilege,
			phonNumber : state.phonNumber
		}
		console.log("폰번호 입력 : " , formattedPhone)

		const resultVo = await userJoin(param)
		
		console.log("결과" + resultVo)
		if (resultVo?.result == 'ok') {
			alert(resultVo.resultMsg)
			router.push({ name: 'login' })
		} else {
			//alert("실패")
			alert(resultVo.resultMsg)
		}
	}
}
</script>

<style></style>