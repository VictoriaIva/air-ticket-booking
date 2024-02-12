package admin.user;

import Entities.Plane;
import Entities.User;
import Service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddUser", value = "/AddUser")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login=request.getParameter("login");
        String password=request.getParameter("password");
        String role=request.getParameter("role");
        Byte isBlocked= Byte.valueOf(request.getParameter("isBlocked"));

        UserService userService = new UserService();
        List<User> users= userService.findAllEntities();
        List<String>logins = new ArrayList<>();

        for (User u:users ) {
            logins.add(u.getLogin());
        }
        if(!logins.contains(login)){
            User user=new User(login,password,role,isBlocked);
            userService.saveEntity(user);
            response.sendRedirect("/Airport_war_exploded/Users");
        }else{
            request.getSession().setAttribute("error", login);
            response.sendRedirect("adminAddUser.jsp");
        }

    }
}
