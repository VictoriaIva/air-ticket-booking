package com.airport;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import DAO.FlightDao;
import DAO.PassengerDao;
import DAO.TicketDao;
import DAO.UserDao ;

import Entities.*;
import Factory.OwnSessionFactory;
import Service.FlightService;
import Service.PassengerService;
import Service.TicketService;
import Service.UserService;
import Service.PlaneService;
import Service.EmployeeService;
import Service.ServiceService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "helloServlet", urlPatterns = "/helloServlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {



        String[] checkedRows = request.getParameterValues("inlineRadioOptions");

        if (checkedRows==null){
            request.getSession().setAttribute("otvet","noooooool");
        }else{
            request.getSession().setAttribute("otvet", checkedRows);
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

       /* EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.findAllEntities();
        System.out.println(employees);

        FlightService flightService = new FlightService();
        List<Flight> flights = flightService.findAllEntities();
        System.out.println(flights);

        PassengerService passengerService = new PassengerService();
        List<Passenger> passengers=passengerService.findAllEntities();
        System.out.println(passengers);

        PlaneService planeService = new PlaneService();
        List<Plane> planes = planeService.findAllEntities();
        System.out.println(planes);



        TicketService ticketService = new TicketService();
        List<Ticket> tickets = ticketService.findAllEntities();
        System.out.println(tickets);

        UserService userService = new UserService();
        List<User> users= userService.findAllEntities();
        System.out.println(users);


        TicketDao ticketDao = new TicketDao();
        List<Ticket> ticketss = ticketDao.ticketsbyflID(13);


        PrintWriter out = response.getWriter();
        out.println("<html><body>");


        out.println("<h1>" + message + "</h1>");


        out.println("</body></html>");*/
    }

}