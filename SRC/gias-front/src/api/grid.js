import { get, post } from './axios'

// 단순한 그리드 출력하는 api를 나열
export const getNoticeList = async (params) => {
    const { status, data } = await get("/notice/vueList", params)

    if (status === 200 || status === 201) {
        return data
    }
}


