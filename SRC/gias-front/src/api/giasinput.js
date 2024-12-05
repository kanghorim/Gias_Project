import { post,put,get } from './axios'

//안씀
export const getGiasDomain = async (params) => {
    const { status, data } = await get("/gias/selectGiasDomainAjax", params)

    if (status === 200 || status === 201) {
        return data
    }
}


export const getGiasPrinciple = async (params) => {
    const { status, data } = await get("/gias/selectGiasPrincipleAjax", params)

    if (status === 200 || status === 201) {
        return data
    }
}

export const getGiasStandard = async (params) => {
    const { status, data } = await get("/gias/selectGiasStandardAjax", params);

    if (status === 200 || status === 201) {
        return data;
    }
};

export const getGiasEvaluation = async (params) => {
    const { status, data } = await get("/gias/selectGiasEvaluationAjax", params);
  
    if (status === 200 || status === 201) {
      return data;
    }
};

export const insertGias = async (params) => {
    const { status, data } = await post("/gias/insertGias", params,true);
  
    if (status === 200 || status === 201) {
      return data;
    }
};

export const updateGias = async (params) => {
    const { status, data } = await post("/gias/updateGias", params,true);
  
    if (status === 200 || status === 201) {
      return data;
    }
};

export const updateGiasFile = async (params) => {
    const { status, data } = await post("/gias/updateGiasFile", params,true);
  
    if (status === 200 || status === 201) {
      return data;
    }
};

export const getGiasEvlList = async (params) => {
    const { status, data } = await get("/gias/evlOrgList", params);

    if (status === 200 || status === 201) {
        return data;
    }
};

export const getAdminGiasEvlList = async (params) => {
    const { status, data } = await get("/gias/adminEvlOrgList", params);

    if (status === 200 || status === 201) {
        return data;
    }
};

export const getMemberApprove = async (params) => {
    const { status, data } = await get("/gias/memberApprove", params)

    if (status === 200 || status === 201) {
        return data
    }
}

export const getGiasAllData = async (params) => {
    const { status, data } = await get("/gias/giasAllData", params)

    if (status === 200 || status === 201) {
        return data
    }
}