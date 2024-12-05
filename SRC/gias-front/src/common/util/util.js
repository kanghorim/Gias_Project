// import axios from 'axios'
// import Cookies from 'js-cookie'

/**
 * 공용다운로드 유틸
 * @author
 * @param 
 * 
 * */
export const downloadUtil = (path, filename) => {
    const downUrl = process.env.VUE_APP_API_URL + "/notice/downloadFile?path=" + path + "&fileName=" + filename;
    window.open(downUrl);
}

/**
 * 공용업로드 유틸
 * @author
 * @param 
 * 
 * */
export const uploadUtil = () => {
    return ""
}

/**
 * 쿠키정보 가져오기
 */
export const getCookie = (cookie) => {
    const cookieItems = cookie.split(';')

    const obj = {};
    cookieItems.forEach((item) => {
        const element = item.split('=')
        const key = element[0].trim()
        const value = decodeURIComponent(element[1])
        obj[key] = value
    })
    return obj;
}

/**
 * 쿠키정보 세팅
 */
// export const setCookie = (name, value, expire) => {

//     Cookies.set(name, value)

//    var date = new Date()
//    date.setTime(date.getTime() + expire*24*60*60*1000)
//    document.cookie = name + '=' + value + ';expires=' + date.toUTCString() + ';path=/'
// }

/**
 * 쿠키삭제
 */
export const delCookie = (name) => {
    document.cookie = name + '=; expires=Thu, 01 Jan 1999 00:00:10 GMT;'
}

/*
*  null 값 체크
*/
export const isNotEmpty = (_str) => {
  var obj = String(_str);
  if (
    obj === null ||
    obj === undefined ||
    obj === "null" ||
    obj === "undefined" ||
    obj === "" ||
    obj === "{}"
  )
    return false;
  else return true;
};

export const isEmpty = (_str) => {
  return !isNotEmpty(_str);
};
