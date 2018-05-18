package com.example.zlcookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CookieDemoServlet")
public class CookieDemoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie cookie1 = new Cookie("name", "eric");
		Cookie cookie2 = new Cookie("email", "2234@qq.com");
		/*Create a cookie that expires 1 days from now, valid across the entire site:*/
		
//		该Cookie失效时间，单位秒。如果为正数，则该Cookie在expiry秒之后失效。如果为负数，该Cookie为临时Cookie，关闭浏览器即失效，浏览器也不会以任何形式保存该Cookie。
//		如果为0，表示删除该Cookie。默认为–1
		cookie1.setMaxAge(24*60*60);  
		//删除
		cookie1.setMaxAge(0);
		

		cookie1.setPath("/day11");
		cookie2.setPath("/day12");


		response.addCookie(cookie1);
		response.addCookie(cookie2);

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String name = c.getName();
				String value = c.getValue();
				System.out.println(name + "=" + value);
			}
		} else {
			System.out.println("û�н��ܵ�cookie");
		}
	}

}
