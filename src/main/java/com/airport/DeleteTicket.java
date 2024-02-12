package com.airport;
import DAO.*;
import Entities.*;
import Service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteTicket", urlPatterns = "/DeleteTicket")
public class DeleteTicket extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {



    }


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        Integer ticketId = Integer.valueOf(request.getParameter("ticketId"));
        TicketService ticketService = new TicketService();
        PassengerService passengerService=new PassengerService();
        Ticket ticket=ticketService.findEntity(ticketId);
        Passenger passenger=ticket.getPassenger();
        ticketService.deleteEntity(ticket);
        passengerService.deleteEntity(passenger);
        response.sendRedirect("adminmain.jsp");


    }


}