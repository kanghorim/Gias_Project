import {
  getNoticeList
} from "@/api/grid";
import {getOrgList,getOrgVueList} from '@/api/org'
import { getMemberApprove,getGiasPrinciple,getGiasStandard,getGiasEvaluation,getGiasEvlList,getGiasAllData,getAdminGiasEvlList } from '@/api/giasinput'
import {getMemberVueList} from '@/api/user'
import noticeJson from '@/models/gridInfo/notice.json'
import domainJson from '@/models/gridInfo/domain.json'
import principleJson from '@/models/gridInfo/principle.json'
import standardJson from '@/models/gridInfo/standard.json'
import evaluationJson from '@/models/gridInfo/evaluation.json'
import orgJson from '@/models/gridInfo/org.json'
import memberJson from '@/models/gridInfo/member.json'
import evlorgJson from '@/models/gridInfo/evlorg.json'
export default {
  namespaced: true,
  state: {
    gridData: [],
    selectData: [],
    domainData: [],
    principleData: [],
    standardData: [],
    evaluationData: [],
    evlOrgData : [],
    orgData : [],
    pagination: {
      pageNo: 1,
      countPerRecord : 10,
    },
  },
  mutations: {
    setGridData(state, payload) {
      state.gridData.push(payload);
    },
    clearGridData(state) {
      state.gridData.length = 0;
    },

    setOrgData(state, payload) {
      state.orgData.push(payload);
    },
    clearOrgData(state) {
      state.orgData.length = 0;
    },

    setEvlOrgData(state, payload) {
      state.evlOrgData.push(payload);
    },
    clearEvlOrgData(state) {
      state.evlOrgData.length = 0;
    },

    setSelectData(state, payload) {
      state.selectData.push(payload);
    },
    clearSelectData(state) {
      state.selectData.length = 0;
    },

    setDomainData(state, payload) {
      state.domainData.push(payload);
    },
    clearDomainData(state) {
      state.domainData.length = 0;
    },

    setPrincipleData(state, payload) {
      state.principleData.push(payload);
    },
    clearPrincipleData(state) {
      state.principleData.length = 0;
    },

    setStandardData(state, payload) {
      state.standardData.push(payload);
    },
    clearStandardData(state) {
      state.standardData.length = 0;
    },

    setEvaluationData(state, payload) {
      state.evaluationData.push(payload);
    },
    clearEvaluationData(state) {
      state.evaluationData.length = 0;
    },

    setPagination(state, payload) {
      state.pagination = payload;
    },
    clearPagination(state) {
      state.pagination = {
        pageNo: 1,
      };
    },
  },
  actions: {
    async fetchNotice({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearGridData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getNoticeList(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of noticeJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setGridData", dataObj);
      }

      commit("setPagination", rtn?.pagingBean);
    },
    async fetchOrg({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearOrgData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getOrgList(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of orgJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setOrgData", dataObj);
      }

      commit("setPagination", rtn?.pagingBean);
    },
    async fetchOrgVue({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearOrgData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getOrgVueList(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of orgJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setOrgData", dataObj);
      }

      commit("setPagination", rtn?.pagingBean);
    },
    async fetchUserVue({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearOrgData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getMemberVueList(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of memberJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setOrgData", dataObj);
      }

      commit("setPagination", rtn?.pagingBean);
    }, 
    async fetchEvlOrg({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearEvlOrgData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getGiasEvlList(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of evlorgJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setEvlOrgData", dataObj);
      }

      commit("setPagination", rtn?.pagingBean);
    },
    async fetchAdminEvlOrg({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearEvlOrgData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getAdminGiasEvlList(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of evlorgJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setEvlOrgData", dataObj);
      }

      commit("setPagination", rtn?.pagingBean);
    },
    async fetchDomain({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearDomainData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getMemberApprove(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of domainJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setDomainData", dataObj);
      }

      //commit("setPagination", rtn?.pagingBean);
    },

    async fetchGiasAllData({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearDomainData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getGiasAllData(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of domainJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setDomainData", dataObj);
      }

      //commit("setPagination", rtn?.pagingBean);
    },

    async fetchPrinciple({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearPrincipleData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getGiasPrinciple(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of principleJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setPrincipleData", dataObj);
      }

      //commit("setPagination", rtn?.pagingBean);
    },

    async fetchStandard({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearStandardData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getGiasStandard(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of standardJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setStandardData", dataObj);
      }

      //commit("setPagination", rtn?.pagingBean);
    },

    async fetchEvaluation({ state, commit }, payload) {
      //console.log("11111 공지사항 호출1111");
      commit("clearEvaluationData");
      commit('clearPagination');

      let rtn = {};
      rtn = await getGiasEvaluation(payload);

      for (const vo of rtn?.data) {
        let dataObj = {};
        for (const info of evaluationJson.cell) {
          dataObj[`${info.key}`] = vo[`${info.key}`];
        }
        commit("setEvaluationData", dataObj);
      }

      //commit("setPagination", rtn?.pagingBean);
    },
  },

};    