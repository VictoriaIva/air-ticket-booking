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
import java.util.List;
import jakarta.persistence.*;

@WebServlet(name = "RegisterServlet", urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) {
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
       String login = request.getParameter("login");
        String password = request.getParameter("pass");
        boolean error = true;

       // String name=request.getParameter("name");
        // String surname=request.getParameter("surname");
Byte isb = 0;
        User user = new User(login, password,"user",isb);
        //Employee employee=new Employee(name, surname);


        UserDao userDao=new UserDao();

        //EmployeeDao employeeDao =new EmployeeDao();


        List<User> users= userDao.userloginpass(login,password);
        List<User> userlog =userDao.userlogin(login);
        boolean isEmpty = users.isEmpty();
        boolean isEmptylog = userlog.isEmpty();
        if(isEmpty && isEmptylog){
            userDao.save(user);
            response.sendRedirect("login2.jsp");

        }else{
            response.sendRedirect("register.jsp");
            request.getSession().setAttribute("errorMessage", "ошибка");
        }




    }
}


