package admin.passenger;

import DAO.PassengerDao;
import Entities.Passenger;
import Service.PassengerService;
import Service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdatePassenger", value = "/UpdatePassenger")
public class UpdatePassenger extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer passengerID = Integer.valueOf(request.getParameter("id"));
        Integer userID= Integer.valueOf(request.getParameter("userID"));
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
        Passenger passenger=passengerService.findEntity(passengerID);
        PassengerDao passengerDao = new PassengerDao();
        List<Passenger> passengers=passengerService.findAllEntities();
        List<String> passports = new ArrayList<>();
        for (Passenger p:passengers) {
            passports.add(p.getPassport());
        }

        if(passenger.getPassport().equals(passport)){
            passenger.setUser(userService.findEntity(userID));
            passenger.setName(name);
            passenger.setSurname(surname);
            passenger.setDateOfBirth(datesql);
            passenger.setPhoneNumber(phoneNumber);
            passenger.setEmail(email);
            passengerService.updateEntity(passenger);

            response.sendRedirect("/Airport_war_exploded/Passengers");
        }else{
            if( passports.contains(passport)){
                request.getSession().setAttribute("error", passport);
                response.sendRedirect("adminUpdatePassenger.jsp");
            }else{
                passenger.setUser(userService.findEntity(userID));
                passenger.setPassport(passport);
                passenger.setName(name);
                passenger.setSurname(surname);
                passenger.setDateOfBirth(datesql);
                passenger.setPhoneNumber(phoneNumber);
                passenger.setEmail(email);
                passengerService.updateEntity(passenger);

                response.sendRedirect("/Airport_war_exploded/Passengers");
            }
        }
    }
}
