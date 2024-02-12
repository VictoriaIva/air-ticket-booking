package admin.flight;
import DAO.*;
import Entities.*;
import Service.*;
import Service.FlightService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddFlight", urlPatterns = "/AddFlight")
public class AddFlight extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        PlaneService planeService=new PlaneService();
        FlightService flightService= new FlightService();
        List<Flight> flights = flightService.findAllEntities();
        List<String> flNnumbers= new ArrayList<>();
        for (Flight f:flights) {
            flNnumbers.add(f.getFlightNumber());
        }

        if (flNnumbers.contains(flightNumber)){

            request.getSession().setAttribute("error", "error");
            response.sendRedirect("adminAddFlight.jsp");
        }else{

            Flight flight=new Flight(flightNumber,planeService.findEntity(planeID),destination,ddate,adate,price);
            flightService.saveEntity(flight);
            response.sendRedirect("adminAddFlight.jsp");

        }




    }
}
