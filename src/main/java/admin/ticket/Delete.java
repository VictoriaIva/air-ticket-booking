package admin.ticket;

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

@WebServlet(name = "Delete", value = "/Delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer ticketId = Integer.valueOf(request.getParameter("id"));

        TicketService ticketService = new TicketService();
        TicketDao ticketDao=new TicketDao();
        List<Ticket> tickets = ticketService.findAllEntities();
        Ticket ticket=ticketService.findEntity(ticketId);
        ticketService.deleteEntity(ticket);

        response.sendRedirect("/Airport_war_exploded/Tickets");
    }
}
