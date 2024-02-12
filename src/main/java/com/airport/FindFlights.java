package com.airport;

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
import java.util.stream.Collectors;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpSession;

import static java.lang.System.out;
@WebServlet(name = "FindFlights", urlPatterns = "/FindFlights")
public class FindFlights extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String dest = request.getParameter("destination");

        String p11 = request.getParameter("priceot");
        String p22 = request.getParameter("pricedo");


        String yd = request.getParameter("dyear");
        String md = request.getParameter("dmonth");
        String dd = request.getParameter("dday");





        FlightService flightService = new FlightService();
        List<Flight> flights = flightService.findAllEntities();

       if (!p11.isEmpty() && !p22.isEmpty()) {
            Double p1 = Double.valueOf(p11);
            Double p2 = Double.valueOf(p22);
        if(!yd.isEmpty() && !md.isEmpty() && !dd.isEmpty()) {
            Date date1 = Date.valueOf(yd + "-" + md + "-" + dd);

            if (!dest.isEmpty() && !yd.isEmpty() && !md.isEmpty() && !dd.isEmpty() && p1 != 0 && p2 != 0) {
                List<Flight> flights2 = flights
                        .stream()
                        .filter(flight -> (flight.getDestination().equals(dest)))
                        .filter(flight -> (flight.getFlightPrice() <= p2))
                        .filter(flight -> (flight.getFlightPrice() >= p1))
                        .filter(flight -> (flight.getDepartureDate().equals(date1)))
                        .collect((Collectors.toList()));

                request.getSession().setAttribute("Flights", flights2);
                request.getRequestDispatcher("allflights.jsp").forward(request, response);
            }
            if (dest.isEmpty() && !yd.isEmpty() && !md.isEmpty() && !dd.isEmpty() && p1 != 0 && p2 != 0) {
                List<Flight> flights2 = flights
                        .stream()
                        .filter(flight -> (flight.getFlightPrice() <= p2))
                        .filter(flight -> (flight.getFlightPrice() >= p1))
                        .filter(flight -> (flight.getDepartureDate().equals(date1)))
                        .collect((Collectors.toList()));

                request.getSession().setAttribute("Flights", flights2);
                request.getRequestDispatcher("allflights.jsp").forward(request, response);
            }
        }
        if (!dest.isEmpty() && yd.isEmpty() && md.isEmpty() && dd.isEmpty() && p1 != 0 && p2 != 0) {
            List<Flight> flights2 = flights
                    .stream()
                    .filter(flight -> (flight.getDestination().equals(dest)))
                    .filter(flight -> (flight.getFlightPrice() <= p2))
                    .filter(flight -> (flight.getFlightPrice() >= p1))
                    .collect((Collectors.toList()));

            request.getSession().setAttribute("Flights", flights2);
            request.getRequestDispatcher("allflights.jsp").forward(request, response);
        }

            if ( dest.isEmpty() && yd.isEmpty() && md.isEmpty() && dd.isEmpty() && p1 != 0 && p2 != 0) {
                List<Flight> flights2 = flights
                        .stream()
                        .filter(flight -> (flight.getFlightPrice() <= p2))
                        .filter(flight -> (flight.getFlightPrice() >= p1))
                        .collect((Collectors.toList()));

                request.getSession().setAttribute("Flights", flights2);
                request.getRequestDispatcher("allflights.jsp").forward(request, response);
            }
    }

        if( !dest.isEmpty()) {
            List<Flight> flights2 = flights
                    .stream()
                    .filter(flight -> (flight.getDestination().equals(dest)))
                    .collect((Collectors.toList()));

            request.getSession().setAttribute("Flights", flights2);
            request.getRequestDispatcher("allflights.jsp").forward(request, response);
        }
        if(!yd.isEmpty() && !md.isEmpty() && !dd.isEmpty()) {
            Date date1 = Date.valueOf(yd + "-" + md + "-" + dd);

            if (!yd.isEmpty() && !md.isEmpty() && !dd.isEmpty()) {
                List<Flight> flights2 = flights
                        .stream()
                        .filter(flight -> (flight.getDepartureDate().equals(date1)))
                        .collect((Collectors.toList()));

                request.getSession().setAttribute("Flights", flights2);
                request.getRequestDispatcher("allflights.jsp").forward(request, response);
            }

            if (!dest.isEmpty() && !yd.isEmpty() && !md.isEmpty() && !dd.isEmpty()) {
                List<Flight> flights2 = flights
                        .stream()
                        .filter(flight -> (flight.getDestination().equals(dest)))
                        .filter(flight -> (flight.getDepartureDate().equals(date1)))
                        .collect((Collectors.toList()));

                request.getSession().setAttribute("Flights", flights2);
                request.getRequestDispatcher("allflights.jsp").forward(request, response);
            }
        }



    }
}

