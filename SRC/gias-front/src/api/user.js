import { post,put,del,get,get2 } from './axios'

// 관리자관리 CRUD를 나열
export const userLogin = async (params) => {
    const { status, data } = await post("/user/login", params);
  
    if (status === 200 || status === 201) {
      return data;
    }
};

export const userJoin = async (params) => {
    const { status, data } = await post("/user/join", params)

    if (status === 200 || status === 201) {
        return data
    }
}

export const getMemberVueList = async (params) => {
    const { status, data } = await get("/user/userList", params);
  
    if (status === 200 || status === 201) {
      return data;
    }
};

export const updateMemberState = async (params) => {
  const { status, data } = await post("/user/updateState", params);

  if (status === 200 || status === 201) {
    return data;
  }
};

export const deleteMember = async (params) => {
  const { status, data } = await del("/user/delete", params);

  if (status === 200 || status === 201) {
    return data;
  }
};

export const userPwInit = async (params) => {
  const { status, data } = await post("/user/pwInit", params);

  if (status === 200 || status === 201) {
    return data;
  }
};

export const ApprovedStandardList = async (params) => {
  const { status, data } = await post("/user/userApprovedStandard", params);
  if (status === 200 || status === 201) {
    return data;
  }
};

export const ApprovedStandardUpdate = async (params) => {
  const { status, data } = await post("/user/updateApprovedStandard", params);
  if (status === 200 || status === 201) {
    return data;
  }
};

export const checkUpdateApprovedStandardBeFor = async (params) => {
  const { status, data } = await post("/user/checkUpdateApprovedStandardBeFor", params);
  if (status === 200 || status === 201) {
    return data;
  }
};

export const updateApprovedStandardBeFor = async (params) => {
  const { status, data } = await post("/user/updateApprovedStandardBeFor", params);
  if (status === 200 || status === 201) {
    return data;
  }
};