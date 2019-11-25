package com.seehope.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seehope.po.Notice;
import com.seehope.service.INoticeService;
import com.seehope.service.impl.NoticeServiceImpl;

/**
 * 消息相关的Servlet
 */
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private INoticeService noticeService =new NoticeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
         
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String method=request.getParameter("method");
		  if("findNoticeById".equals(method)){
			  findNoticeById(request,response);
		  }
		  if("deleteNotice".equals(method)){
			  deleteNotice(request,response);
		  }
		  if("publish".equals(method)){
			  publishNotice(request,response);
		  }
		  
	}
	 /***
	  * 批量发布消息
	  * @param request
	  * @param response
	 * @throws IOException 
	 * @throws ServletException 
	  */
	 private void publishNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 String ids =request.getParameter("ids");
		if(!"".equals(ids) && null!=ids){
			int count=0;
			try {
				count=noticeService.publish(ids);
			} catch (SQLException e) {
				// TODO: handle exception
			}
			if(count>0){
				request.setAttribute("msg", "发布成功");
				request.getRequestDispatcher("/managerServlet").forward(request, response);
			}else{
				request.setAttribute("msg", "发布失败");
				request.getRequestDispatcher("/managerServlet").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "要发布的消息不允许为空,请重新发布");
			request.getRequestDispatcher("/managerServlet").forward(request, response);
		}
		
	}

	/***
	  * 根据id删除消息信息
	  * @param request
	  * @param response
	 * @throws IOException 
	 * @throws ServletException 
	  */
     private void deleteNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    	 String  id=request.getParameter("id");
 		if(!"".equals(id) && null!=id){
 			 Integer nid=Integer.parseInt(id);
 			Notice notice=null;
			  try {
				  //查询
				  notice =noticeService.getNoticeById(nid);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(notice!=null && notice.getPublishStatus()==0){
				//删除
				int count=0;
				try {
					count=noticeService.deleteNoticeById(nid);
				} catch (SQLException e) {
					// TODO: handle exception
				}
				if(count>0){
					request.getRequestDispatcher("/managerServlet").forward(request, response);
				}else{
					request.setAttribute("msg", "删除失败");
					request.getRequestDispatcher("/managerServlet").forward(request, response);
				}
			}else{
				//返回错误信息
				request.setAttribute("msg", "您要删除的数据不存在或者是已发布，请检查");
				request.getRequestDispatcher("/managerServlet").forward(request, response);
			}
 		}else{
 			request.setAttribute("msg", "您要删除的数据不存在，请检查");
 			request.getRequestDispatcher("/managerServlet").forward(request, response);
 		}
		
	}

	/***
      * 根据id查询消息详情
      * @param request
      * @param response
     * @throws IOException 
     * @throws ServletException 
      */
	private void findNoticeById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String  id=request.getParameter("id");
		if(!"".equals(id) && null!=id){
			Notice notice=null;
			  try {
				  notice =noticeService.getNoticeById(Integer.parseInt(id));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 request.setAttribute("notice", notice);
			 request.getRequestDispatcher("/city_info.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "您要查询的消息不存在，请检查");
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
		
	}

}
