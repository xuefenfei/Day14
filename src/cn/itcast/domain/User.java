package cn.itcast.domain;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {

	private int id;
	private String username;
	private String password;
	private String nickname;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// 将用户与session存储到Map中.

		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();

		Map<User, HttpSession> map = (Map<User, HttpSession>) context
				.getAttribute("map");

		map.put(this, session);

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// 1.从map删除
		HttpSession session = event.getSession();
		ServletContext context = session.getServletContext();

		Map<User, HttpSession> map = (Map<User, HttpSession>) context
				.getAttribute("map");

		map.remove(this);

		// 2.销毁session

		session.invalidate();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
