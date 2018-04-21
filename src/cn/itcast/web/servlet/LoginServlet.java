package cn.itcast.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.domain.User;
import cn.itcast.util.DataSourceUtil;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.得到用户名与密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 2.查找数据库中是否有指定的username与password

		try {
			QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());
			User user = runner.query(
					"select * from t_user where username=? and password=?",
					new BeanHandler<User>(User.class), username, password);

			// 3.判断user是否为空
			if (user == null) {
				request.setAttribute("error", "用户名或密码错误");
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			} else {

		request.getSession().invalidate(); // 解决了在同一个浏览器上登录两次.

				// 4.从ServletContext中取出map
			Map<User, HttpSession> map = (Map<User, HttpSession>) this
						.getServletContext().getAttribute("map");

				// 解决在不同浏览器登录同一个用户

				HttpSession s = map.get(user);

				if (s != null) {
					s.invalidate();
				}
			
				

				// 5.登录成功，将用户信息存储到session。
				request.getSession().setAttribute("user", user);

				response.sendRedirect("/day14/list.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
