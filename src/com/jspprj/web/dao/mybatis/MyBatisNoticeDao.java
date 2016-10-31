package com.jspprj.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jspprj.web.dao.NoticeDao;
import com.jspprj.web.entities.Notice;
import com.jspprj.web.model.NoticeModel;

public class MyBatisNoticeDao implements NoticeDao{
	
	SqlSessionFactory ssf;
	   
	   public MyBatisNoticeDao(){
	      ssf = JspSessionFactoryBuilder.getSqlSqlsessionFactory();
	   }

	   @Override
	   public Notice get(String code){
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      return noticeDao.get(code);
	   }

	   @Override
	   public List<NoticeModel> getList(int page, String field, String query){
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      return noticeDao.getList(page, field, query);
	   }

	   @Override
	   public List<NoticeModel> getList(int page){
	      
	      return getList(page, "TITLE", "");
	   }

	   @Override
	   public List<NoticeModel> getList(){
	      
	      return getList(1, "TITLE", "");
	   }

	   @Override
	   public int insert(Notice notice){
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      int result = noticeDao.insert(notice);
	      
	      session.commit();
	      session.close();
	      return result;
	   }

	   @Override
	   public int update(Notice notice){
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      int result = noticeDao.update(notice);
	      
	      session.commit();
	      session.close();
	      return result;
	   }

	   @Override
	   public int delete(String code){
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      int result = noticeDao.delete(code);
	      
	      session.commit();
	      session.close();
	      return result;
	   }

	   @Override
	   public int getCount(String field, String query) {
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      int count = noticeDao.getCount(field, query);
	      
	      session.close();
	      return count;
	   }

	   @Override
	   public String getLastCode() {
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      String code = noticeDao.getLastCode();
	   
	      session.close();
	      return code;
	   }

	   @Override
	   public Notice getPrev(String code) {
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      Notice notice = noticeDao.getPrev(code);
	      
	      session.close();
	      return notice;
	   }

	   @Override
	   public Notice getNext(String code) {
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      Notice notice = noticeDao.getNext(code);
	      
	      session.close();
	      return notice;
	   }

	   @Override
	   public int hitUp(String code) {
	      SqlSession session = ssf.openSession();
	      NoticeDao noticeDao = session.getMapper(NoticeDao.class);
	      
	      int result = noticeDao.hitUp(code);
	      
	      session.commit();
	      session.close();
	      
	      return result;
	   }

}
