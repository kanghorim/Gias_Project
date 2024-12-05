package com.loglog.api.commons.daos;

import java.util.List;
import java.util.Map;

import com.loglog.api.commons.beans.NoticeBean;

/**
 * 사용자 DAO
 * 
 * @author SJG
 */
public interface NoticeDao {
	
	/** 공지사항 관리 리스트 */
	public List<NoticeBean> selectNotice(NoticeBean noticeBean);
	
	/** 공지사항 상세조회*/
	public NoticeBean selectNoticeView(NoticeBean noticeBean);
	
	/** 공지사항 수정*/
	public int updateNotice(NoticeBean noticeBean);
	
	/** 공지사항 저장*/
	public int insertNotice(NoticeBean noticeBean);
	
	/**공지사항 파일저장*/
	public int insertNoticeFile(NoticeBean noticeBean);
	
	/** 공지사항 저장*/
	public int deleteNotice(NoticeBean noticeBean);
	
	/** 공지화면 조회 갯수 확인*/
	public int selectNoticeCount(Map<String,Object> parameter);
	
	/** 공지화면 조회 */
	public List<NoticeBean> selectNoticeList(Map<String,Object> parameter);
	
	/** 공지사항에 이미 저장된 파일이 있는지 확인한다.*/
	public int checkNoticeFile(NoticeBean noticeBean);
}