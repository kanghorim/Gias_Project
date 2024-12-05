import { post,put,del,get } from './axios'

// 공지사항의 CRUD를 나열

//기관관리 메인페이지 조회
export const getOrgVueList = async (params) => {
    const { status, data } = await get("/org/vueList", params);
  
    if (status === 200 || status === 201) {
      return data;
    }
};

// 기관관리 콤보박스 조회
export const getOrgList = async (params) => {
  const { status, data } = await get("/org/selectOrgList", params)

  if (status === 200 || status === 201) {
      return data
  }
};

export const updateOrgState = async (params) => {
  const { status, data } = await post("/org/updateState", params);

  if (status === 200 || status === 201) {
    return data;
  }
};

export const deleteOrg = async (params) => {
  const { status, data } = await del("/org/delete", params);

  if (status === 200 || status === 201) {
    return data;
  }
};

export const orgApprovedStandard = async (params) => {
  const { status, data } = await post("/org/orgApprovedStandard", params);
  if (status === 200 || status === 201) {
    return data;
  }
};
