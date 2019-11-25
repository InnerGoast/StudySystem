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
 * ��Ϣ��ص�Servlet
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
	  * ����������Ϣ
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
				request.setAttribute("msg", "�����ɹ�");
				request.getRequestDispatcher("/managerServlet").forward(request, response);
			}else{
				request.setAttribute("msg", "����ʧ��");
				request.getRequestDispatcher("/managerServlet").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "Ҫ��������Ϣ������Ϊ��,�����·���");
			request.getRequestDispatcher("/managerServlet").forward(request, response);
		}
		
	}

	/***
	  * ����idɾ����Ϣ��Ϣ
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
				  //��ѯ
				  notice =noticeService.getNoticeById(nid);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(notice!=null && notice.getPublishStatus()==0){
				//ɾ��
				int count=0;
				try {
					count=noticeService.deleteNoticeById(nid);
				} catch (SQLException e) {
					// TODO: handle exception
				}
				if(count>0){
					request.getRequestDispatcher("/managerServlet").forward(request, response);
				}else{
					request.setAttribute("msg", "ɾ��ʧ��");
					request.getRequestDispatcher("/managerServlet").forward(request, response);
				}
			}else{
				//���ش�����Ϣ
				request.setAttribute("msg", "��Ҫɾ�������ݲ����ڻ������ѷ���������");
				request.getRequestDispatcher("/managerServlet").forward(request, response);
			}
 		}else{
 			request.setAttribute("msg", "��Ҫɾ�������ݲ����ڣ�����");
 			request.getRequestDispatcher("/managerServlet").forward(request, response);
 		}
		
	}

	/***
      * ����id��ѯ��Ϣ����
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
			request.setAttribute("msg", "��Ҫ��ѯ����Ϣ�����ڣ�����");
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		}
		
	}

}
