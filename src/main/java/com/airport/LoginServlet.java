package com.airport;

import DAO.EmployeeDao ;
import DAO.ServiceDao ;
import DAO.UserDao ;
import Entities.Employee ;
import Entities.Service ;
import Entities.User ;
import  Entities.Flight;
import  Service.FlightService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import jakarta.persistence.*;

@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {


       response.sendRedirect("login2.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("pass");

        User user=new User(login,password);
        UserDao userDao=new UserDao();

            List<User> users= userDao.userloginpass(login,password);

            boolean isEmpty = users.isEmpty();
            if(!isEmpty){

                User us = users.get(0);
                if(us.getIsBlocked()!=1){
                    if(us.getRole().equals("admin")){
                    //request.getSession().setAttribute("auth",users);
                    request.getSession().setAttribute("auth", us);
                    request.getSession().setAttribute("userId", us.getId());
                    response.sendRedirect("adminmain.jsp");
                    }else{
                        request.getSession().setAttribute("auth", us);
                        request.getSession().setAttribute("userId", us.getId());
                        response.sendRedirect("main.jsp");

                    }
                }else{
                    response.sendRedirect("login2.jsp");
                    request.getSession().setAttribute("errorMessage", "вы заблокированы");
                }

            }else{
                response.sendRedirect("login2.jsp");
                request.getSession().setAttribute("errorMessage", "ошибка");
            }






    }
}
