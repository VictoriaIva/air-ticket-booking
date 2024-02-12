package admin.passenger;

import DAO.PassengerDao;
import DAO.TicketDao;
import Entities.Passenger;
import Entities.Ticket;
import Entities.User;
import Service.PassengerService;
import Service.TicketService;
import Service.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeletePassenger", value = "/DeletePassenger")
public class DeletePassenger extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer passengerId = Integer.valueOf(request.getParameter("id"));

        PassengerService passengerService = new PassengerService();
        PassengerDao passengerDao = new PassengerDao();
        List<Passenger> passengers=passengerService.findAllEntities();
        Passenger passenger=passengerService.findEntity(passengerId);

        TicketService ticketService = new TicketService();
        TicketDao ticketDao=new TicketDao();
        List<Ticket> tickets = ticketDao.ticketsbyPasID(passengerId);

        if (!tickets.isEmpty()){
            for (Ticket t:tickets) {
                ticketService.deleteEntity(t);
            }
        }

        passengerService.deleteEntity(passenger);
        response.sendRedirect("/Airport_war_exploded/Passengers");
    }
}
