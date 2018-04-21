package cn.itcast.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.User;

public class KickServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id=request.getParameter("id");
		Map<User, HttpSession> map = (Map<User, HttpSession>) this
				.getServletContext().getAttribute("map");
		User user = new User();
		user.setId(Integer.parseInt(id));
		HttpSession session = map.get(user);

		session.removeAttribute("user");// user中的valueUnbound方法会被执行

		// 跳转到list.jsp

		response.sendRedirect("/day14/list.jsp");

	}

}
