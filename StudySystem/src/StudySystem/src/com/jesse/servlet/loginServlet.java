package com.seehope.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seehope.po.User;
import com.seehope.service.IUserService;
import com.seehope.service.impl.UserServiceImpl;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userService =new UserServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name =request.getParameter("username");
		 String password =request.getParameter("password");
		 if(!"".equals(name) && null!=name && !"".equals(password) && null!=password){
			  User user= (User) request.getSession().getAttribute("user");
			  if(user!=null){
				  if(user.getName().equals(name) && user.getPassword().equals(password)){
					  request.getRequestDispatcher("/WEB-INF/admin/manager.jsp").forward(request, response);
				  }else{
					  User loginUser=null;
					  try {
							loginUser = userService.login(name,password);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 if(loginUser!=null){
							 request.getSession().setAttribute("user", loginUser);
							 request.getRequestDispatcher("/WEB-INF/admin/manager.jsp").forward(request, response);
						 }else{
							 request.setAttribute("msg", "用户名或者密码错误");
							 request.getRequestDispatcher("/login.jsp").forward(request, response);
						 }
				  }
			  }else{
				  User loginUser=null;
					try {
						loginUser = userService.login(name,password);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 if(loginUser!=null){
						 request.getSession().setAttribute("user", loginUser);
						 request.getRequestDispatcher("/WEB-INF/admin/manager.jsp").forward(request, response);
					 }else{
						 request.setAttribute("msg", "用户名或者密码错误");
						 request.getRequestDispatcher("/login.jsp").forward(request, response);
					 }
			  }
		 }else{
			 request.setAttribute("msg", "用户名或者密码不允许为空");
			 request.getRequestDispatcher("/login.jsp").forward(request, response);
		 }
	}

}
