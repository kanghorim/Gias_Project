//import { getUserDetail } from '@/api/member'
export default {
    namespaced: true, 
    state: {
        policy1 : '',
        policy2 : '',
        member : {
            id : '',
            password : '',
            passwordChk: '',
            name : '',
            userEmail : '',
            userHp : '',
            userArea : '',
            phone1 : '',
            phone2 : '',
            phone3 : '',
            gender : '',
            mailYn : '',
            msgYn : '',
            infoYn : '',
            userLevel : 1,
            privilege : '',
            dept : '',
            memberCode : '',
            organizationCode : ""
        },
        userInfo: {}
    },
    mutations: {
        setPolicy1(state, payload){
            state.policy1 = payload
        },
        setPolicy2(state, payload){
            state.policy2 = payload
        },
        setMember(state, payload){
            state.member = payload
        },
        setUserInfo(state, payload){
            state.userInfo = payload
            state.member.userId = payload.userId
        },
        clearPolicy1(state){
            state.policy1 = ''
        },
        clearPolicy2(state){
            state.policy2 = ''
        },
        clearMember(state){
            state.member = {
                id : '',
                password : '',
                passwordChk: '',
                name : '',
                userEmail : '',
                userHp : '',
                userArea : '',
                phone1 : '',
                phone2 : '',
                phone3 : '',
                gender : '',
                mailYn : '',
                msgYn : '',
                infoYn : '',
                userLevel : 1,
                privilege : '',
                dept : '',
                memberCode : '',
                organizationCode : ""
            }
        },
        cleanUserInfo(state) {
            state.userInfo = {}
        },
        //임시 테스트 확인 작업
        updateMember(state, payload) {
            const type = payload.type
            state.member[type] = payload.value
        },
    },
    actions: {
        /**async fatchUserInfo({ state,commit }, payload){
            commit('clearMember')
            let rtn = {}
            rtn = await getUserDetail(payload)
            console.log(rtn)
            commit('setUserInfo', rtn?.detail)
        },*/
    }
}