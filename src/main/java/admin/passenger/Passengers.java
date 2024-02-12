package admin.passenger;

import DAO.PassengerDao;
import Entities.Passenger;
import Entities.Plane;
import Entities.User;
import Service.PassengerService;
import Service.PlaneService;
import Service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Passengers", value = "/Passengers")
public class Passengers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PassengerService passengerService = new PassengerService();
        PassengerDao passengerDao = new PassengerDao();
        List<Passenger> passengers=passengerService.findAllEntities();
        request.getSession().setAttribute("Passengers", passengers);
        request.getRequestDispatcher("adminPassengers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String[] checkedRows = request.getParameterValues("inlineRadioOptions");

        String byname="byname";

        PassengerService passengerService = new PassengerService();
        PassengerDao passengerDao = new PassengerDao();
        List<Passenger> passengers=passengerService.findAllEntities();
        if (checkedRows!=null) {
            if (checkedRows[0].equals(byname)) {
                request.getSession().setAttribute("otvet", byname);
                passengers.sort(((o1, o2) -> (o1.getName().compareTo(o2.getName()))));
                request.getSession().setAttribute("Passengers", passengers);
            }
        }

        request.getRequestDispatcher("adminPassengers.jsp").forward(request, response);
    }
}
