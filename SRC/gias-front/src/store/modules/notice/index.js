import { getNoticeView } from "@/api/view";

export default {
  namespaced: true,
  state: {
    noticeInfo: {
        noticeCode : "",
        noticeTitle : "",
        noticeContent : "",
        memberCode : "admin",
        updateAt : "",
        no : "",
        memberName : "", 
        file : "",
        filePreview : "",
        imgeName : "",
        fileNm : "",
        
    },
    noticeViewData: {},
  },
  mutations: {
    setNoticeInfo(state, payload) {
      state.noticeInfo = {
        noticeCode : payload.noticeCode || "",
        noticeTitle : payload.noticeTitle ||  "",
        noticeContent : payload.noticeContent ||  "",
        memberCode : payload.memberCode ||  "",
        updateAt : payload.updateAt ||  "",
        no : payload.no ||  "",
        memberName : payload.memberName ||  "", 
        file : payload.file ||  "",
        filePreview : payload.file || "",
        imgeName : payload.imgeName || "",
        fileNm : payload.fileNm || "",
      };
    },
    clearNoticeInfo(state) {
      state.noticeInfo = {
        noticeCode : "",
        noticeTitle : "",
        noticeContent : "",
        memberCode : "",
        updateAt : "",
        no : "",
        memberName : "", 
        file : "",
        filePreview : "",
        imgeName : "",
        fileNm : "",
      };
    },
    setNoticeViewData(state, payload) {
      state.noticeViewData = payload;
    },
    clearNoticeViewData(state) {
      state.noticeViewData = {};
    },
  },
  actions: {
    async fetchNoticeView({ commit }, payload) {
      commit("clearNoticeViewData");
      let rtn = {};
      rtn = await getNoticeView(payload);

      commit("setNoticeViewData", rtn?.data);
    },
  },
};
