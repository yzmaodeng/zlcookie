package com.example.zlcookie;

import java.io.IOException;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class TestServlet extends HttpServlet {  
  
    @Override  
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        // TODO Auto-generated method stub  
        resp.getWriter().print("hello word");  
        resp.getWriter().flush();  
        resp.getWriter().close();  
    }  
  
    @Override  
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        // TODO Auto-generated method stub  
        this.doGet(req, resp);  
    }  
  
}  
