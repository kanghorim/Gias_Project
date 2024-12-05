package com.loglog.api.commons.modules.service.notice;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.loglog.api.commons.beans.NoticeBean;
import com.loglog.api.commons.beans.PagingBean;
import com.loglog.api.commons.daos.NoticeDao;


@Service
public class NoticeServiceImpl implements NoticeService {

	@Value("${repository.path}")
	private String RESPOSITORY_PATH;
	// 보드 이미지 폴더 경로
	@Value("${upload.notice.path}")
	private String UPLOAD_NOTICE_PATH;
	
	@Autowired
	private NoticeDao noticeDao;
	
	/** 공지사항 조회 */
	public List<NoticeBean> selectNotice(NoticeBean noticeBean)throws Exception{
		List<NoticeBean> noticeList = noticeDao.selectNotice(noticeBean);
	        
		for (NoticeBean bean : noticeList) {
	        String updateAt = bean.getUpdateAt();
	        if (updateAt != null) {
	            // updateAt을 문자열로 변환한 후 앞의 10자리만 잘라서 사용
	            String formattedDate = updateAt.toString().substring(0, 10);
	            bean.setUpdateAt(formattedDate);
	        }
	    }
	        
	  return noticeList;
	}
	
	/** 공지사항 상세조회*/
	public NoticeBean selectNoticeView(NoticeBean noticeBean)throws Exception{
		return noticeDao.selectNoticeView(noticeBean);
	}
	
	/** 공지사항 수정*/
	public int updateNotice(NoticeBean noticeBean,MultipartFile noticeInputFile)throws Exception{
		//수정할떄 대상기관을 전체로 수정하면 참조키 오류가 생긴다. 그래서 null으로 중간에 수정한다.
		 if ("".equals(noticeBean.getOrganizationCode())) {
		        noticeBean.setOrganizationCode(null);
		}
		int resultCnt = 0;
		if(noticeInputFile != null && !noticeInputFile.isEmpty()) {
			// 파일이 있으면 제목과 타이틀만 우선 저장한다.
			resultCnt = noticeDao.updateNotice(noticeBean);
			if(resultCnt > 0) {
				String root = RESPOSITORY_PATH + UPLOAD_NOTICE_PATH + noticeBean.getNoticeCode();
				// 디렉터리 생성
			    File directory = new File(root);
			    if (!directory.exists()) {
			        directory.mkdirs();
			    }
			    String savedFilePath = null;
			    String relativeFilePath = null; // 상대 경로
			    String originalFilename = noticeInputFile.getOriginalFilename();
			    System.out.println("공지사항 파일 이름: " + originalFilename);
			    noticeBean.setNoticeFileName(originalFilename);
			    savedFilePath = root + "/" + originalFilename;
			    relativeFilePath = UPLOAD_NOTICE_PATH + noticeBean.getNoticeCode() + "/" + originalFilename;
			    
			    File destFile = new File(savedFilePath);
			    noticeInputFile.transferTo(destFile);
			    
			    noticeBean.setNoticeFile(relativeFilePath);
			    System.out.println("파일 저장 절대경로: " + savedFilePath);
		        System.out.println("파일 저장 상대경로: " + relativeFilePath);
		        resultCnt = noticeDao.insertNoticeFile(noticeBean);
			}
		}else {
			// 공지사항 수정에 보내는 파일이 없을때 Maintenance코드가 보내지지 않으면 파일을 초기화
			resultCnt = noticeDao.updateNotice(noticeBean);
			String mainFile = noticeBean.getCheckFile();
			
			if(mainFile.equals("Maintenance")) {
				System.out.println("기존 파일 유지함" + mainFile);
			}else {
				System.out.println("기존 파일 삭제만함");
				resultCnt = noticeDao.insertNoticeFile(noticeBean); // null값을 삽입
			}
		}
		 
	    return resultCnt;
	}
	
	/** 공지사항 저장 */
	public int insertNotice(NoticeBean noticeBean, MultipartFile noticeInputFile) throws Exception {
		int resultCnt = 0;
		// 공지사항 저장에 파일이 들어온다면
		if(noticeInputFile != null && !noticeInputFile.isEmpty()) {
			// 파일이 있으면 제목과 타이틀만 우선 저장한다.
			resultCnt = noticeDao.insertNotice(noticeBean);
			if(resultCnt > 0) {
				String root = RESPOSITORY_PATH + UPLOAD_NOTICE_PATH + noticeBean.getNoticeCode();
				// 디렉터리 생성
			    File directory = new File(root);
			    if (!directory.exists()) {
			        directory.mkdirs();
			    }
			    String savedFilePath = null;
			    String relativeFilePath = null; // 상대 경로
			    String originalFilename = noticeInputFile.getOriginalFilename();
			    System.out.println("공지사항 파일 이름: " + originalFilename);
			    noticeBean.setNoticeFileName(originalFilename);
			    savedFilePath = root + "/" + originalFilename;
			    relativeFilePath = UPLOAD_NOTICE_PATH + noticeBean.getNoticeCode() + "/" + originalFilename;
			    
			    File destFile = new File(savedFilePath);
			    noticeInputFile.transferTo(destFile);
			    
			    noticeBean.setNoticeFile(relativeFilePath);
			    System.out.println("파일 저장 절대경로: " + savedFilePath);
		        System.out.println("파일 저장 상대경로: " + relativeFilePath);
		        resultCnt = noticeDao.insertNoticeFile(noticeBean);
			}
		}else {
			// 공지사항 저장에 파일이 없으면 그냥 저장
			resultCnt = noticeDao.insertNotice(noticeBean);
		}
	    return resultCnt;
	}

	
	/** 공지화면 조회 갯수 확인*/
	public int selectNoticeCount(NoticeBean noticeBean , PagingBean pagingBean)throws Exception{
		Map<String, Object> parameter = new HashMap<String, Object>();
    	parameter.put("pageNo", pagingBean.getPageNo());
		parameter.put("startRow", pagingBean.getStartRow());
		parameter.put("countPerRecord", pagingBean.getCountPerRecord());
		parameter.put("typeCd",noticeBean.getTypeCd());
		parameter.put("search", noticeBean.getSearch());
		parameter.put("organizationCode",noticeBean.getOrganizationCode());
		parameter.put("userGrade",noticeBean.getUserGrade());
		return noticeDao.selectNoticeCount(parameter);
	}
	
	/** 공지화면 조회 */
	public List<NoticeBean> selectNoticeList(NoticeBean noticeBean , PagingBean pagingBean)throws Exception{
		Map<String, Object> parameter = new HashMap<String, Object>();
    	parameter.put("pageNo", pagingBean.getPageNo());
		parameter.put("startRow", pagingBean.getStartRow());
		parameter.put("countPerRecord", pagingBean.getCountPerRecord());
		parameter.put("typeCd",pagingBean.getTypeCd());
		parameter.put("search", pagingBean.getSearch());
		parameter.put("organizationCode",noticeBean.getOrganizationCode());
		parameter.put("userGrade",noticeBean.getUserGrade());
		List<NoticeBean> noticeList = noticeDao.selectNoticeList(parameter);
        
		for (NoticeBean bean : noticeList) {
	        String updateAt = bean.getUpdateAt();
	        if (updateAt != null) {
	            // updateAt을 문자열로 변환한 후 앞의 10자리만 잘라서 사용
	            String formattedDate = updateAt.toString().substring(0, 10);
	            bean.setUpdateAt(formattedDate);
	        }
	    }
		
		return noticeList;
	}

	@Override
	public int deleteNotice(NoticeBean noticeBean) throws Exception {
		return noticeDao.deleteNotice(noticeBean);
	}
}
