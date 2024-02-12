package com.airport;
import DAO.*;
import Entities.*;
import Service.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpSession;

import static java.lang.System.out;

@WebServlet(name = "AllFlights", urlPatterns = "/AllFlights")
public class AllFlights extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        FlightService flightService = new FlightService();
        List<Flight> flights = flightService.findAllEntities();
        request.getSession().setAttribute("Flights", flights);
        request.getRequestDispatcher("allflights.jsp").forward(request, response);

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
        request.getRequestDispatcher("allflights.jsp").forward(request, response);



    }
}
