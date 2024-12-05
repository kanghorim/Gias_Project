package com.loglog.api.commons.modules.service.notice;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.loglog.api.commons.beans.NoticeBean;
import com.loglog.api.commons.beans.PagingBean;

public interface NoticeService {
	
	/** 공지사항 조회 */
	public List<NoticeBean> selectNotice(NoticeBean noticeBean)throws Exception;
	
	/** 공지사항 상세조회*/
	public NoticeBean selectNoticeView(NoticeBean noticeBean)throws Exception;
	
	/** 공지사항 수정*/
	public int updateNotice(NoticeBean noticeBean,MultipartFile noticeInputFile)throws Exception;
	
	/** 공지사항 저장*/
	public int insertNotice(NoticeBean noticeBean,MultipartFile noticeInputFile)throws Exception;
	
	/** 공지사항 삭제*/
	public int deleteNotice(NoticeBean noticeBean)throws Exception;
	
	/** 공지화면 조회 */
	public List<NoticeBean> selectNoticeList(NoticeBean noticeBean , PagingBean pagingBean)throws Exception;
		  
	/** 공지화면 조회 갯수 확인*/
	public int selectNoticeCount(NoticeBean noticeBean , PagingBean pagingBean)throws Exception;
}
