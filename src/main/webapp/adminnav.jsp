<%--
  Created by IntelliJ IDEA.
  User: fando
  Date: 08.05.2023
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Service.PassengerService" %>
<%@ page import="DAO.PassengerDao" %>
<%@ page import="Entities.Passenger" %>
<%@ page import="java.util.List" %>
<%@ page import="Service.TicketService" %>
<%@ page import="DAO.TicketDao" %>
<%@ page import="Entities.Ticket" %>
<%@ page import="Service.UserService" %>
<%@ page import="DAO.FlightDao" %>
<%@ page import="Service.FlightService" %>
<%@ page import="Entities.Flight" %>
<%@ page import="java.util.ArrayList" %><%

    PassengerDao passengerDao = new PassengerDao();
    TicketDao ticketDaoNav=new TicketDao();


    List<Passenger> pass = passengerDao.passengerByUser(auth.getId());

    List<Ticket> ticketsNav = new ArrayList<>();
    for (Passenger p : pass) {
        List<Ticket> t = ticketDaoNav.ticketsbyPasID(p.getId());
        ticketsNav.addAll(t);
    }


%>


<html lang="en">
<nav class="navbar navbar-expand-lg bg-body-tertiary"  style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <a class="navbar-brand" href="adminmain.jsp">Главная</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item">
                    <a class="nav-link" href="Flights">Рейсы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Users">Пользователи</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Passengers">Пассажиры</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Planes">Самолеты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Tickets">Билеты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AdminPDF">Отчет</a>
                </li>


            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="LogoutServlet">Выход</a>
                </li>
            </ul>

        </div>
    </div>
</nav>

