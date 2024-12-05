package com.loglog.api.controller.notice;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.loglog.api.commons.beans.NoticeBean;
import com.loglog.api.commons.beans.PagingBean;
import com.loglog.api.commons.constants.Constants;
import com.loglog.api.commons.modules.service.notice.NoticeService;


@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	
	/**아래부터 리메이크 api 목록들 
	   * @throws Exception */
	@RequestMapping(value="/notice/vueList", method = RequestMethod.GET) // 원본 = /list 
	@ResponseBody
	public Map<String, Object> getNoticeList(NoticeBean noticeBean,PagingBean pagingBean, HttpServletRequest request) throws Exception{
		Map<String, Object> map = new HashMap<>();
		
		String result = Constants.FAIL;
		map.put("result", result);
		int totalCount = noticeService.selectNoticeCount(noticeBean,pagingBean);
		// 페이징 계산 , 가져올 데이터 시작위치 끝위치 계산
	    pagingBean.calcPage(totalCount);
		try {
			List<NoticeBean> resultList = noticeService.selectNoticeList(noticeBean,pagingBean);
			if(resultList != null) {
				result = Constants.OK;
				map.put("pagingBean", pagingBean);
				map.put("data", resultList);
				map.put("result", result);
				map.put("resultMsg","공지사항 조회에 성공했습니다.");
			}else {
				map.put("result", result);
				map.put("resultMsg","공지사항 조회에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", result);
			map.put("resultMsg","그룹매핑에 실패");
		}
		return map;
	}
	
	@RequestMapping(value="/notice/selectNoticeView", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> selectNoticeView(NoticeBean noticeBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "공지사항 상세조회에 실패했습니다.");
		try {
			NoticeBean resultList = noticeService.selectNoticeView(noticeBean);
			if(noticeBean != null) {
				map.put("data", resultList);
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "공지사항 상세조회에 성공했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value="/notice/edit", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> noticeUpdate(NoticeBean noticeBean, 
			@RequestPart(value="", required=false) MultipartFile noticeInputFile,
			HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "공지사항 수정에 실패했습니다.");
		int resultCnt = 0; 
		try {
			resultCnt = noticeService.updateNotice(noticeBean,noticeInputFile);
			if(resultCnt >0) {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "공지사항 수정에 성공했습니다.");
			}else {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "공지사항 수정에 실패했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value="/notice/write", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> noticeInsert(NoticeBean noticeBean, 
			@RequestPart(value="", required=false) MultipartFile noticeInputFile,
			HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "공지사항 저장에 실패했습니다.");
		int resultCnt = 0; 
		try {
			//System.out.println("여기는 통과 하나?" + noticeBean.getNoticeFileName());
			resultCnt = noticeService.insertNotice(noticeBean,noticeInputFile); 
			if(resultCnt >0) {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "공지사항 저장에 성공했습니다.");
			}else {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "공지사항 저장에 실패했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
	
	
	@RequestMapping(value="/notice/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> noticeDelete(@RequestBody List<NoticeBean> noticeBean, HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<>();
		int resultDeleteCnt = 0;
		map.put(Constants.RESULT, Constants.FAIL);
		map.put(Constants.RESULT_MSG, "공지사항 삭제에 실패했습니다.");
		try {
			for (NoticeBean noticeCode : noticeBean) {
		        resultDeleteCnt += noticeService.deleteNotice(noticeCode);
		     }
			
			if(resultDeleteCnt > 0) {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "공지사항 삭제에 성공했습니다.");
			}else {
				map.put(Constants.RESULT, Constants.OK);
				map.put(Constants.RESULT_MSG, "공지사항 삭제에 실패했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			map.put(Constants.RESULT, Constants.FAIL);
			map.put(Constants.RESULT_MSG, "오류가 발생했습니다.");
		}
		return map;
	}
}
