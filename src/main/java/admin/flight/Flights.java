package admin.flight;

import Entities.Flight;
import Service.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Flights", urlPatterns = "/Flights")
public class Flights extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        FlightService flightService = new FlightService();
        List<Flight> flights = flightService.findAllEntities();
        request.getSession().setAttribute("Flights", flights);
        request.getRequestDispatcher("adminflights.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        String[] checkedRows = request.getParameterValues("inlineRadioOptions");
        String byprice="byprice";
        String bydest = "bydest";

        FlightService flightService = new FlightService();
        List<Flight> flights = flightService.findAllEntities();
        //boolean found = Arrays.asList(checkedRows).contains(byprice);

        if (checkedRows!=null) {
            if (checkedRows[0].equals(byprice)) {
                request.getSession().setAttribute("otvet", byprice);
                flights.sort((o1, o2) -> (o1.getFlightPrice()).compareTo(o2.getFlightPrice()));
                request.getSession().setAttribute("Flights", flights);
            } else {
                request.getSession().setAttribute("otvet", bydest);
                flights.sort((o1, o2) -> o1.getDestination().compareTo(o2.getDestination()));
                request.getSession().setAttribute("Flights", flights);
            }
        }
        request.getRequestDispatcher("adminflights.jsp").forward(request, response);
    }
}
