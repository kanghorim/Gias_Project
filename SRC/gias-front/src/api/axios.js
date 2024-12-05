import axios from 'axios'
import Cookies from 'js-cookie';

const config = {
  baseURL: process.env.VUE_APP_API_URL,
  headers: {
    'Content-Type': 'application/json; charset=utf-8'
  },
  timeout: (parseInt(process.env.VUE_APP_TIME_OUT_SEC) || 10) * 1000
}


axios.interceptors.request.use(
  (config) => {
    // 특정 쿠키 값을 가져와서 헤더에 추가
    const myCookieValue = Cookies.get('sessionId');
    if (myCookieValue) {
      config.headers['Authorization'] = `${myCookieValue}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

const genDefaultOptions = () => Object.assign({}, config)

const networkError = false

export const get = async (url, params = {}, isDelete) => {
  
    if (Object.keys(params).length > 0) {
      url += '?'
      for (const key in params) {
        if (params[key] !== undefined) url += `${key}=${params[key]}&`
      }
    }
  
    const options = genDefaultOptions()
    options.method = !isDelete ? 'get' : 'delete'
    options.url = options.baseURL + url

    try {
      return await axios(options)
      
    } catch (error) {
      return networkError
    }
  }
  
  export const get2 = async (url, params = {}, isDelete) => {
    if (Object.keys(params).length > 0) {
        url += '?';
        for (const key in params) {
            if (params[key] !== undefined) {
                const value = typeof params[key] === 'object' ? JSON.stringify(params[key]) : params[key];
                url += `${key}=${encodeURIComponent(value)}&`;
            }
        }
        console.log(`Generated URL: ${url}`); // 디버깅 로그 추가
    }

    const options = genDefaultOptions();
    options.method = !isDelete ? 'get' : 'delete';
    options.url = options.baseURL + url;

    try {
        return await axios(options);
    } catch (error) {
        console.error('API 호출 실패:', error); // 에러 로그 추가
        return networkError;
    }
};



  /**
   * @async
   * @function post
   * @description axios post
   * @param {String} url 
   * @param {Object} params
   * @example post('users', { userId: 'userId' })
   * @return {Object} response data
   */
  
  export const post = async (url, params = {}, isFileUpload) => {
    const options = genDefaultOptions()
    options.headers = !isFileUpload ? 
      {'Content-Type': 'application/json; charset=utf-8'} :
      {'Content-Type' : 'multipart/form-data'}
    options.method = 'post'
    options.url = options.baseURL + url
    options.data = params
  
    try {
      return await axios(options)
    } catch (error) {
      console.error(error)
      return networkError
    }
  }
  
  /**
   * @async
   * @function put
   * @description axios put
   * @param {String} url 
   * @param {Object} params
   * @example put('users', { userId: 'userId' })
   * @return {Object} response data
   */
  
  export const put = async (url, params = {}) => {
    
    const options = genDefaultOptions()
    options.method = 'put'
    options.url = options.baseURL + url
    options.data = params
  
    try {
      return await axios(options)
  
    } catch (error) {
      console.error(error)
      return networkError
    }
  }

    
  /**
   * @async
   * @function del
   * @description axios put
   * @param {String} url 
   * @param {Object} params
   * @example put('users', { userId: 'userId' })
   * @return {Object} response data
   */
  
  export const del = async (url, params = {}) => {
    
    const options = genDefaultOptions()
    options.method = 'delete'
    options.url = options.baseURL + url
    options.data = params
  
    try {
      return await axios(options)
  
    } catch (error) {
      console.error(error)
      return networkError
    }
  }
