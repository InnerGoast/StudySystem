package com.seehope.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seehope.po.Notice;
import com.seehope.po.utils.PageBean;
import com.seehope.service.INoticeService;
import com.seehope.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class NoticePageServlet
 */
public class NoticePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private INoticeService noticeService =new NoticeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //获取数据
		 String thisPage=request.getParameter("thisPage");
		 Integer pageSize=1;
		 //过滤数据
		 if(!"".equals(thisPage) && null!=thisPage){
			 pageSize =Integer.parseInt(thisPage);
		 }
		 //封装参数
		 PageBean<Notice> pageBean =new PageBean<Notice>();
		 pageBean.setThisPage(pageSize);
		 pageBean.setPageNum(5);
		 try {
			 pageBean =noticeService.getNoticesByPage(pageBean);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		 request.setAttribute("pageBean", pageBean);
		 request.getRequestDispatcher("/WEB-INF/admin/notice1.jsp").forward(request, response);
		 
	}

}
