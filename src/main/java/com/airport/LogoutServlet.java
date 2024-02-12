package com.airport;

import DAO.EmployeeDao ;
import DAO.ServiceDao ;
import DAO.UserDao ;
import Entities.Employee ;
import Entities.Service ;
import Entities.User ;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.persistence.*;
@WebServlet(name = "LogoutServlet", urlPatterns = "/LogoutServlet")
public class LogoutServlet  extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig) {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {


        try (PrintWriter out =response.getWriter()){
            if(request.getSession().getAttribute("auth")!=null){
                request.getSession().removeAttribute("auth");
                response.sendRedirect("login2.jsp");
            }else{
                response.sendRedirect("adminmain.jsp");
            }

        }
    }






}
