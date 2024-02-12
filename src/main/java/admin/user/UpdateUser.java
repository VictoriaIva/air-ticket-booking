package admin.user;

import Entities.User;
import Service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateUser", value = "/UpdateUser")
public class UpdateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userID = Integer.valueOf(request.getParameter("id"));
        String login=request.getParameter("login");
        String password=request.getParameter("password");
        String role=request.getParameter("role");
        Byte isBlocked= Byte.valueOf(request.getParameter("isBlocked"));

        UserService userService = new UserService();
        User user=userService.findEntity(userID);
        List<User> users= userService.findAllEntities();
        List<String>logins = new ArrayList<>();

        if(user.getLogin().equals(login)){
            user.setPassword(password);
            user.setRole(role);
            user.setIsBlocked(isBlocked);
            userService.updateEntity(user);

            response.sendRedirect("/Airport_war_exploded/Users");
        }else{
            if( logins.contains(login)){
                request.getSession().setAttribute("error", login);
                response.sendRedirect("adminUpdateUser.jsp");
            }else{
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(role);
                user.setIsBlocked(isBlocked);
                userService.updateEntity(user);

                response.sendRedirect("/Airport_war_exploded/Users");
            }
        }

    }
}
