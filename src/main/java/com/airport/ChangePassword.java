package com.airport;
import DAO.*;
import Entities.*;
import Service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChangePassword", urlPatterns = "/ChangePassword")
public class ChangePassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

       String p1= request.getParameter("p1");
       String p2= request.getParameter("p2");
       Integer userId= Integer.valueOf(request.getParameter("userId"));


       UserDao userDao=new UserDao();
       UserService userService= new UserService();
       User user= userService.findEntity(userId);




       if(user.getPassword().equals(p1)) {
           if (p1.equals(p2)) {
               request.getSession().setAttribute("error", "это старый пароль");
               response.sendRedirect("userpage.jsp");
           } else {
               List<User> users2 = userDao.userloginpass(user.getLogin(), p1);
               User us = users2.get(0);
               us.setPassword(p2);
               userService.updateEntity(us);
               request.getSession().setAttribute("error", "пароль изменен");
               response.sendRedirect("userpage.jsp");
           }
       }else {
           request.getSession().setAttribute("error", "это не ваш пароль");
           response.sendRedirect("userpage.jsp");

       }



    }
}
