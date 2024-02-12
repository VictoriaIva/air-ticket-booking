package admin.flight;

import Entities.Flight;
import Service.FlightService;
import Service.PlaneService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdateFlight", value = "/UpdateFlight")
public class UpdateFlight extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer flightId = Integer.valueOf(request.getParameter("id"));
        String flightNumber= request.getParameter("flightNumber");
        Integer planeID= Integer.valueOf(request.getParameter("planeID"));
        String destination= request.getParameter("destination");
        String dyear =request.getParameter("dyear");
        String dmonth =request.getParameter("dmonth");
        String dday = request.getParameter("dday");

        String date1 = dyear+"-"+dmonth+"-"+dday;
        Date ddate=Date.valueOf(date1);

        String ayear =request.getParameter("ayear");
        String amonth =request.getParameter("amonth");
        String aday = request.getParameter("aday");

        String date2 = dyear+"-"+dmonth+"-"+dday;
        Date adate=Date.valueOf(date2);

        Double price= Double.valueOf(request.getParameter("price"));

        FlightService flightService=new FlightService();
        Flight flight = flightService.findEntity(flightId);
        PlaneService planeService=new PlaneService();

        List<Flight> flights = flightService.findAllEntities();
        List<String> flNnumbers= new ArrayList<>();
        for (Flight f:flights) {
            flNnumbers.add(f.getFlightNumber());
        }

        if(flight.getFlightNumber().equals(flightNumber)){

            flight.setPlane(planeService.findEntity(planeID));
            flight.setDestination(destination);
            flight.setDepartureDate(ddate);
            flight.setArrivalDate(adate);
            flight.setFlightPrice(price);
            flightService.updateEntity(flight);
            response.sendRedirect("/Airport_war_exploded/Flights");

        }else{
            if (flNnumbers.contains(flightNumber)){
                request.getSession().setAttribute("error", "error");
                response.sendRedirect("adminUpdateFlight.jsp");
            }else{
                flight.setFlightNumber(flightNumber);
                flight.setPlane(planeService.findEntity(planeID));
                flight.setDestination(destination);
                flight.setDepartureDate(ddate);
                flight.setArrivalDate(adate);
                flight.setFlightPrice(price);
                flightService.updateEntity(flight);
                response.sendRedirect("/Airport_war_exploded/Flights");

            }
        }


    }
}
