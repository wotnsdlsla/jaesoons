package com.jspprj.web.dao.controller.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspprj.web.dao.NoticeDao;
import com.jspprj.web.dao.NoticeFileDao;
import com.jspprj.web.dao.mybatis.MyBatisNoticeDao;
import com.jspprj.web.dao.mybatis.MyBatisNoticeFileDao;
import com.jspprj.web.entities.Notice;
import com.jspprj.web.entities.NoticeFile;

@WebServlet("/customer/notice-delete")
public class NoticeDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String _code = request.getParameter("code");
		
		NoticeFileDao noticeFileDao = new MyBatisNoticeFileDao();
		NoticeDao noticeDao= new MyBatisNoticeDao();
		
		Notice notice;
		List<NoticeFile> noticeFiles;
		
				
		notice = noticeDao.get(_code);
		noticeFiles = noticeFileDao.getList(_code);
		
		request.setAttribute("n", notice);
		request.setAttribute("files", noticeFiles);
		
		
		request.getRequestDispatcher("/WEB-INF/views/customer/notice-detail.jsp");
	}
}
