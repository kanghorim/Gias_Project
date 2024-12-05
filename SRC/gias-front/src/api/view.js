import { get } from './axios'

export const getNoticeView = async (params) => {
    const { status, data } = await get("/notice/selectNoticeView", params)

    if (status === 200 || status === 201) {
        return data
    }
}

