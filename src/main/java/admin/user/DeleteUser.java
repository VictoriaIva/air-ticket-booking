package admin.user;

import DAO.FlightDao;
import DAO.PassengerDao;
import DAO.PlaneDao;
import Entities.Flight;
import Entities.Passenger;
import Entities.Plane;
import Entities.User;
import Service.FlightService;
import Service.PassengerService;
import Service.PlaneService;
import Service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteUser", value = "/DeleteUser")
public class DeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.valueOf(request.getParameter("id"));

        UserService userService = new UserService();
        List<User> users= userService.findAllEntities();
        User user = userService.findEntity(userId);
        PassengerDao passengerDao=new PassengerDao();
        PassengerService passengerService=new PassengerService();
        List<Passenger> passengers =passengerDao.passengerByUser(userId);

        if (!passengers.isEmpty()){
            for (Passenger p:passengers) {
                passengerService.deleteEntity(p);
            }
        }

        userService.deleteEntity(user);
        response.sendRedirect("/Airport_war_exploded/Users");
    }
}
