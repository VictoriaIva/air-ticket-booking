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

@WebServlet(name = "Tickets", value = "/Tickets")
public class Tickets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TicketService ticketService = new TicketService();
        TicketDao ticketDao=new TicketDao();
        List<Ticket> tickets = ticketService.findAllEntities();
        request.getSession().setAttribute("Tickets", tickets);
        request.getRequestDispatcher("adminTickets.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] checkedRows = request.getParameterValues("inlineRadioOptions");

        String byflightID="byflightID";
        TicketService ticketService = new TicketService();

        List<Ticket> tickets = ticketService.findAllEntities();

        if (checkedRows!=null) {
            if (checkedRows[0].equals(byflightID)) {
                request.getSession().setAttribute("otvet", byflightID);
                tickets.sort((o1, o2) -> (Integer.valueOf(o1.getFlight().getId()).compareTo(Integer.valueOf(o2.getFlight().getId()))));
                request.getSession().setAttribute("Tickets", tickets);

            }
        }

        request.getRequestDispatcher("adminTickets.jsp").forward(request, response);
    }
}
