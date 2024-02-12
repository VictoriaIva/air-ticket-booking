package admin.user;

import Entities.*;
import Service.PlaneService;
import Service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        UserService userService=new UserService();
        List<User> users=userService.findAllEntities();
        request.getSession().setAttribute("Users", users);
        request.getRequestDispatcher("adminUsers.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] checkedRows = request.getParameterValues("inlineRadioOptions");

        String byrole="byrole";
        String byisBlocked ="byisBlocked";
        UserService userService=new UserService();
        List<User> users=userService.findAllEntities();
        if (checkedRows!=null) {
            if (checkedRows[0].equals(byrole)) {
                request.getSession().setAttribute("otvet", byrole);
                users.sort(((o1, o2) -> (o1.getRole().compareTo(o2.getRole()))));
                request.getSession().setAttribute("Users", users);
            }else{
                request.getSession().setAttribute("byisBlocked", byisBlocked);
                users.sort((o1, o2) -> (o1.getIsBlocked().compareTo(o2.getIsBlocked())));
                request.getSession().setAttribute("Users", users);
            }
        }

        request.getRequestDispatcher("adminUsers.jsp").forward(request, response);
    }
}
