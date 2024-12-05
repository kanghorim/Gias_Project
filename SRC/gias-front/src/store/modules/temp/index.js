import { getMainData } from '@/api/auth'
//import { delCookie } from '@/util/util'
import router from '@/router'

export default {
    namespaced: true, 
    state: {
        isAdmin: false,
        isApply: false,
        isLogin: false,
        isMain : false,
        isApprovedStandard : false,
        isDistributionStatus : false,
        isGiasStatus : false,
        isPassWordUpdate : false,
        isMsgDetailPopup : false,
        searchParam : {
            pageNo : 1,
            pageSize : 10,
            countPerRecord : 10,
            searchText : ''
        },
        searchParamForApply : {
            pageNo : 1,
            search : ''
        },
        userInfo : {
            memberCode : '',
            memberName : '',
            organizationCode : '',
            privilege : ""
        },
        main : {}
    },
    mutations: {
        setIsAdmin(state, payload) {
            state.isAdmin = payload
        },
        setIsApply(state, payload) {
            state.isApply = payload
        },
        setIsLogin(state, payload) {
            state.isLogin = payload
        },
        setIsMain(state, payload){
            state.isMain = payload
        },
        setIsApprovedStandard(state) {
            state.isApprovedStandard = !state.isApprovedStandard
        },
        setIsDistributionStatus(state) {
            state.isDistributionStatus = !state.isDistributionStatus
        },
        setIsGiasStatus(state) {
            state.isGiasStatus = !state.isGiasStatus
        },
        setIsPassWordUpdate(state) {
            state.isPassWordUpdate = !state.isPassWordUpdate
        },
        setIsMsgDetailPopup(state) {
            state.isMsgDetailPopup = !state.isMsgDetailPopup
        },
        setIsChipFalse(state) {
            state.isChip = false
        },
        setSearchParam(state, payload) {
            state.searchParam[payload.key] = payload.value
        },
        setUserInfo(state, payload) {
            state.userInfo[payload.key] = payload.value
        },
        setMainData(state, payload) {
            state.main = payload
        },
        clearSearchParam (state) {
            state.searchParam = {}
            state.searchParam.pageNo = 1
            state.searchParam.search = ''
        },
        clearUserInfo(state) {
            state.userInfo = {
                userId : '',
                userName : '',
                userLevel : 0,
                authToken : ''
            }
        },       
        clearMainData(state) {
            state.main = {}
        },
        setSearchParamForApply(state, payload) {
            state.searchParamForApply[payload.key] = payload.value
        },
        clearSearchParamForApply (state) {
            state.searchParamForApply.pageNo = 1
            state.searchParamForApply.search = ''
        },
    },
    actions : {
        async fetchMainData ({state, commit}, payload) {
            commit('clearMainData')
            let rtn = {}
            rtn = await getMainData(payload)
            commit('setMainData', rtn)
        },
        async clearSessionOut ({state, commit}) {
            //delCookie("sessionId")
            commit('setIsLogin', false)
            commit('setIsAdmin', false)
            commit('clearUserInfo')
			router.push({name:'Home'})
        },
    }, 
    clearTemp(state) {
        state.isApprovedStandard = false
        state.isDistributionStatus = false
        state.isGiasStatus = false
        state.isPassWordUpdate = false
        state.isMsgDetailPopup = false
    }

}