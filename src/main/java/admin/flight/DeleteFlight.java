package admin.flight;

import Entities.Service;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import DAO.*;
import Entities.*;
import Service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteFlight", value = "/DeleteFlight")
public class DeleteFlight extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer flightId = Integer.valueOf(request.getParameter("id"));


        TicketService ticketService = new TicketService();
        TicketDao ticketDao = new TicketDao();
        ServiceService serviceService=new ServiceService();
        ServiceDao serviceDao=new ServiceDao();
        FlightService flightService=new FlightService();
        Flight flight = flightService.findEntity(flightId);
        List<Ticket> tickets = ticketDao.ticketsbyflID(flightId);
        List<Service> services= serviceDao.servicesbyflID(flightId);
        if(!tickets.isEmpty()) {
            for (Ticket t : tickets) {
                ticketService.deleteEntity(t);
            }
        }
        if(!services.isEmpty()) {
            for (Service s : services) {
                serviceDao.delete(s);
            }

        }


        flightService.deleteEntity(flight);

        response.sendRedirect("/Airport_war_exploded/Flights");
    }
}
