package com.seehope.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seehope.po.Notice;
import com.seehope.po.Type;
import com.seehope.po.User;
import com.seehope.service.INoticeService;
import com.seehope.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class doAddOrUpdateNoticeServlet
 */
public class doAddOrUpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private INoticeService noticeService =new NoticeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAddOrUpdateNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8");  
		 //获取参数
		  String typeId =request.getParameter("typeId");
		  String title =request.getParameter("title");
		  String content =request.getParameter("content");
		  String id =request.getParameter("id");
		  if(!"".equals(typeId) && null!=typeId && !"".equals(title) && null!=title && !"".equals(content) && null!=content ){
			     Notice notice =new Notice();
			     Type type =new Type();
			     type.setId(Integer.parseInt(typeId));
			     notice.setType(type);
			     notice.setTitle(title);
			     notice.setContent(content);
			     notice.setCreateDate(new Date());
			     User user= (User) request.getSession().getAttribute("user");
			     if(user!=null)
			       notice.setUser(user);
			     notice.setPublishStatus(0);
			     int count=0;
			    if(!"".equals(id) && null!=id){
			    	notice.setId(Integer.parseInt(id));
			    	//修改操作
			    	try {
						count=noticeService.update(notice);
					} catch (SQLException e) {
						// TODO: handle exception
					}
			    	if(count>0){
				    	 request.getRequestDispatcher("/managerServlet").forward(request, response);
				    }else{
				    	 request.setAttribute("msg", "修改失败，请重新修改，或者给钱");
						 request.getRequestDispatcher("addOrUpdateNoticeServlet?id="+id).forward(request, response);
				    }
			    }else{
			    	//新增操作
					try {
						count = noticeService.add(notice);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 if(count>0){
				    	 request.getRequestDispatcher("/managerServlet").forward(request, response);
				    }else{
				    	 request.setAttribute("msg", "添加失败，请重新添加，或者给钱");
						 request.getRequestDispatcher("/WEB-INF/admin/addNotice.jsp").forward(request, response);
				    }
			    }
			   
			    
			     
		  }else{
			  request.setAttribute("msg", "您输入的内容为空,请重新输入");
			  request.getRequestDispatcher("/WEB-INF/admin/addNotice.jsp").forward(request, response);
		  }
	}

}
