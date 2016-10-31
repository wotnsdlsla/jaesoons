package com.jspprj.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.jspprj.web.entities.Notice;
import com.jspprj.web.model.NoticeModel;

public interface NoticeDao {
	Notice get(String code) ;//데이터베이스에 있는 데이터를 객체화시켜 받아 사용할 것이기 때문에 
	List<NoticeModel> getList(int page, String field, String query) ;
	List<NoticeModel> getList(int page);
	List<NoticeModel> getList() ;
	int getCount(String field, String query);
	
	int update(Notice notice);
	int delete(String code) ;
	int insert(Notice notice);
	
	/*이전 다음글*/
	Notice getPrev(String code);
	Notice getNext(String code);
	int hitUp(String code);
	String getLastCode();
	
	
}