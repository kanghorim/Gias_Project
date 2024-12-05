import { post,put,del } from './axios'

// 공지사항의 CRUD를 나열
export const insertNotice = async (params) => {
    const { status, data } = await post("/notice/write", params,true);
  
    if (status === 200 || status === 201) {
      return data;
    }
};

export const updateNotice = async (params) => {
  const { status, data } = await post("/notice/edit", params,true);

  if (status === 200 || status === 201) {
    return data;
  }
};

export const deleteNotice = async (params) => {
  const { status, data } = await del("/notice/delete", params);

  if (status === 200 || status === 201) {
    return data;
  }
};