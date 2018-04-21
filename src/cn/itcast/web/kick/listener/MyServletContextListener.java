package cn.itcast.web.kick.listener;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import cn.itcast.domain.User;

public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		Map<User, HttpSession> map = Collections
				.synchronizedMap(new HashMap<User, HttpSession>());
		ServletContext context = sce.getServletContext();

		context.setAttribute("map", map);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		
	}
	
	

}
