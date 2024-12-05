import { get } from './axios'
import { post } from './axios'

export const getOutInfPersonAjax = async (params) => {
    const { status, data } = await post("/pvt/common/getOutInfPersonAjax", params)

    if (status === 200 || status === 201) {
       return data
    }
}
