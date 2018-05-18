package com.example.zlcookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/zlServlet")
public class ZLServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String curTime=format.format(new Date());
		Cookie[] cookies=request.getCookies();
		String lastTime=null;
		if(cookies!=null){
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("lastTime")){
					lastTime=cookie.getValue();
					response.getWriter().write("@@@@@"+lastTime+"@@@@@"+curTime);
					cookie.setValue(curTime);
					cookie.setMaxAge(1*30*24*60*60);
					response.addCookie(cookie);
					break;
				}
			}
		}
		
		if(cookies==null || lastTime==null){
			response.getWriter().write("�����״η��ʱ���վ����ǰʱ��Ϊ��"+curTime);
			Cookie cookie=new Cookie("lastTime",curTime);
			cookie.setMaxAge(1*30*24*60*60);
			response.addCookie(cookie);
		}
	}

}
