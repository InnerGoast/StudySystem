package com.seehope.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seehope.dao.ITypeDao;
import com.seehope.dao.impl.TypeDaoImpl;
import com.seehope.po.Notice;
import com.seehope.po.Type;
import com.seehope.service.INoticeService;
import com.seehope.service.ITypeService;
import com.seehope.service.impl.NoticeServiceImpl;
import com.seehope.service.impl.TypeServiceImpl;

/**
 * Servlet implementation class addOrUpdateNoticeServlet
 */
public class addOrUpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ITypeService typeService =new TypeServiceImpl();
    private INoticeService noticeService =new NoticeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOrUpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //通过id判断该请求是新增还是修改
		String id=request.getParameter("id");
		ArrayList<Type> types =null;  
		try {
			types=typeService.getTypes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("types", types);
		if(!"".equals(id) && null!=id){
			//表示修改
			Integer  nid=Integer.parseInt(id);
			Notice notice=null;
			try {
				notice=noticeService.getNoticeById(nid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(notice.getPublishStatus()==1){
				request.setAttribute("msg", "已发布的消息不允许修改");
				request.getRequestDispatcher("/managerServlet").forward(request, response);
			}else{
				request.setAttribute("notice", notice);
				request.getRequestDispatcher("/WEB-INF/admin/addNotice.jsp").forward(request, response);
			}
			
		}else{
			request.getRequestDispatcher("/WEB-INF/admin/addNotice.jsp").forward(request, response);
		}
		
	}

}
