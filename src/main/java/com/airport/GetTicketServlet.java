package com.airport;

import DAO.*;
import Entities.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpSession;

import static java.lang.System.out;

@WebServlet(name = "GetTicketServlet", urlPatterns = "/GetTicketServlet")
public class GetTicketServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.valueOf(request.getParameter("id"));

        FlightDao flightDao=new FlightDao();
        Flight flight= (Flight) flightDao.findById(id);

        request.getSession().setAttribute("flight", flight);
        request.getRequestDispatcher("pasenger.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {





       /* String name = request.getParameter("name");
        String sname = request.getParameter("sname");

        String year =request.getParameter("year");
        String month =request.getParameter("month");
        String day = request.getParameter("day");

        String date = year+"-"+month+"-"+day;
        Date datesql=Date.valueOf(date);


        String pasp=request.getParameter("pasp");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String seat = request.getParameter("seat");


        Integer flId = Integer.valueOf(request.getParameter("id"));

        Integer userId = Integer.valueOf(request.getParameter("userId"));

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        PassengerDao passengerDao= new PassengerDao();
        Passenger passenger=new Passenger(userId,pasp,name,sname,datesql,phone,email);

        Ticket ticket=new Ticket(flId,passenger.getId(),seat,timestamp);
        TicketDao ticketDao=new TicketDao();




        //response.sendRedirect("adminmain.jsp");
        request.getSession().setAttribute("passenger", passenger);
        request.getSession().setAttribute("ticket", ticket);
        request.getRequestDispatcher("pasenger.jsp").forward(request, response);*/








    }
}
