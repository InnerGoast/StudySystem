package com.seehope.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seehope.po.Notice;
import com.seehope.service.INoticeService;
import com.seehope.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class managerServlet
 */
public class managerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private INoticeService noticeService =new NoticeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public managerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thisPage=request.getParameter("thisPage");
		Integer pageSize=1;
		if(!"".equals(thisPage) && null!=thisPage){
			pageSize =Integer.parseInt(thisPage);
		}
		//每页显示数
		Integer pageNum=5;
		ArrayList<Notice> notices=null;
		//数据库查询总条数
		Integer totalCount=null;
		//总页数
		Integer totalPage=null;
		try {
			notices=noticeService.findPublishNotices(null,pageSize,pageNum);
			totalCount =noticeService.getTotalCount();
			//计算总页面
			if(totalCount>0){
				totalPage =totalCount%pageNum>0?(totalCount/pageNum)+1:(totalCount/pageNum);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("thisPage",pageSize);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("notices", notices);
		request.getRequestDispatcher("/WEB-INF/admin/notice.jsp").forward(request, response);
	}

}
