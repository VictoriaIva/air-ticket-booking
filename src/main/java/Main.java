import DAO.FlightDao;
import DAO.PassengerDao;
import DAO.TicketDao;
import DAO.UserDao ;
import  DAO.TicketDao;
import Entities.*;
import Factory.OwnSessionFactory;
import Service.FlightService;
import Service.PassengerService;
import Service.TicketService;
import Service.UserService;
import Service.PlaneService;
import Service.EmployeeService;
import Service.ServiceService;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Date;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.*;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;




public class Main {
    public static void main(String[] args) throws ParseException, IOException {


      /*
       EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.findAllEntities();
        System.out.println(employees);

        FlightService flightService = new FlightService();
        List<Flight> flights = flightService.findAllEntities();
        System.out.println(flights);



        PlaneService planeService = new PlaneService();
        List<Plane> planes = planeService.findAllEntities();
        System.out.println(planes);

*/
        PassengerService passengerService = new PassengerService();
        PassengerDao passengerDao = new PassengerDao();

        //System.out.println(passengers);

        TicketService ticketService = new TicketService();
        TicketDao ticketDao=new TicketDao();
        List<Ticket> tickets = ticketService.findAllEntities();
       // System.out.println(tickets);

        UserService userService = new UserService();
        List<User> users= userService.findAllEntities();
      //  System.out.println(users);

        FlightDao flightDao= new FlightDao();
        FlightService flightService = new FlightService();
        List<Flight> flights = flightService.findAllEntities();



        List<Flight> flights2 = flights
                .stream()
                .filter(flight -> (flight.getFlightPrice() <= 500))
                .filter(flight -> (flight.getFlightPrice() >= 100))
                .collect((Collectors.toList()));
 System.out.println(flights2);
/*
        User user= userService.findEntity(3);
        List<Passenger> pass =  passengerDao.passengerByUser(user.getId());


        List<Ticket> tii = new ArrayList<>();
        for (Passenger p:pass) {

            List<Ticket> ti =ticketDao.ticketsbyPasID(p.getId());
            tii.addAll(ti);
        }
        System.out.println(tii);


*/

    }


}
