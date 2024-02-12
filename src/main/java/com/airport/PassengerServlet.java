package com.airport;

import DAO.PassengerDao;
import Entities.Flight;
import Entities.Passenger;
import Entities.Ticket;
import Entities.User;
import Service.FlightService;
import Service.PassengerService;
import Service.TicketService;
import Service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@WebServlet(name = "PassengerServlet", urlPatterns = "/PassengerServlet")
public class PassengerServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
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

         FlightService flightService = new FlightService();
        Flight flight = flightService.findEntity(flId);

         Integer userId = Integer.valueOf(request.getParameter("userId"));
         UserService userService= new UserService();
         User user = userService.findEntity(userId);

        Timestamp datesale = new Timestamp(System.currentTimeMillis());

        PassengerDao passengerDao= new PassengerDao();
        PassengerService passengerService = new PassengerService();
        TicketService ticketService = new TicketService();


        List <Passenger> passengers = passengerDao.findbypasport(pasp);

        Boolean isEmpty = passengers.isEmpty();
        if(!isEmpty){
            Passenger passengerP = passengers.get(0);
            request.getSession().setAttribute("b", pasp);
            Ticket ticket = new Ticket(passengerP, flight, seat);
            ticketService.saveEntity(ticket);
            request.getSession().setAttribute("a", passengerP);
            request.getSession().setAttribute("b", ticket);
            response.sendRedirect("pasenger.jsp");

        }else {

            Passenger passenger = new Passenger(user, pasp, name, sname, datesql, phone, email);
            Ticket ticket = new Ticket(passenger, flight, seat);
            passengerService.saveEntity(passenger);
            ticketService.saveEntity(ticket);
            try {
                PrintWriter prWr = new PrintWriter(new BufferedWriter(new FileWriter(new File("D:\\history.txt"), true)));
                prWr .println(ticket.toString());
                prWr .close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            request.getSession().setAttribute("a", passenger);
            request.getSession().setAttribute("b", ticket);
            response.sendRedirect("pasenger.jsp");

        }
    }
}
