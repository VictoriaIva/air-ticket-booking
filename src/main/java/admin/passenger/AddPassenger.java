package admin.passenger;

import DAO.PassengerDao;
import Entities.Passenger;
import Entities.User;
import Service.PassengerService;
import Service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddPassenger", value = "/AddPassenger")
public class AddPassenger extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userID = Integer.valueOf(request.getParameter("userID"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        String year =request.getParameter("year");
        String month =request.getParameter("month");
        String day = request.getParameter("day");

        String date = year+"-"+month+"-"+day;
        Date datesql=Date.valueOf(date);

        UserService userService = new UserService();

        String passport=request.getParameter("passport");
        String phoneNumber=request.getParameter("phoneNumber");
        String email=request.getParameter("email");

        PassengerService passengerService = new PassengerService();
        PassengerDao passengerDao = new PassengerDao();
        List<Passenger> passengers=passengerService.findAllEntities();
        List<String> passports = new ArrayList<>();
        for (Passenger p:passengers) {
            passports.add(p.getPassport());

        }

        if(!passports.contains(passport)){
            Passenger passenger=new Passenger(userService.findEntity(userID),passport,name,surname,datesql,phoneNumber,email);
            passengerService.saveEntity(passenger);
            response.sendRedirect("/Airport_war_exploded/Passengers");
        }else{
            request.getSession().setAttribute("error", passport);
            response.sendRedirect("adminAddPassengers.jsp");
        }


    }
}
