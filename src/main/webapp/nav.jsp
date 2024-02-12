<meta charset="UTF-8" />
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
<nav class="navbar navbar-expand-lg bg-body-tertiary "  style="background-color: #e3f2fd;" >
    <div class="container-fluid">
        <a class="navbar-brand" href="main.jsp">Главная</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <% if(auth!=null){ %>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="userpage.jsp">Моя страница</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="AllFlights">Все рейсы</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="findFlight.jsp">Поиск рейса</a>
                </li>

                <%
                    }
                %>


            </ul>

            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle dropdown-menu-right" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> <i class="fa-regular fa-user"></i>  </a>
                    <ul class="dropdown-menu dropdown-menu-end">



                        <% if(auth!=null){ %>
                        <li><a class="dropdown-item" href="LogoutServlet">выйти</a></li>

                        <% }else{ %>

                        <li><a class="dropdown-item" href="register.jsp">регистрация</a></li>
                        <li><a class="dropdown-item" href="login2.jsp">авторизация</a></li>
                        <li><hr class="dropdown-divider"></li>

                        <%
                            }
                        %>
                    </ul>

                </li>

                <% if(auth!=null){ %>
                <li class="nav-item">
                    <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#staticBackdrop">  <i class="fa-solid fa-cart-shopping"></i></a>
                </li>

                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog modal-xl">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Мои билеты</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                            </div>
                            <div class="modal-body">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">пассажир</th>
                                        <th scope="col">паспорт</th>
                                        <th scope="col">направление</th>
                                        <th scope="col">дата отправления</th>
                                        <th scope="col">авиалиния</th>
                                        <th scope="col">модель самолета</th>
                                        <th scope="col">цена</th>
                                        <th scope="col">место</th>
                                        <th scope="col">    </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%
                                        for  (Ticket t:ticketsNav) {
                                            %>
                                    <tr>
                                        <td> <a href="#" data-toggle="tooltip" title="  <%=t.getPassenger().getEmail()%>  +375<%=t.getPassenger().getPhoneNumber()%>"><%=t.getPassenger().getName()%>  <%=t.getPassenger().getSurname()%></a></td>
                                        <td><%=t.getPassenger().getPassport()%></td>
                                        <td><%=t.getFlight().getDestination()%></td>
                                        <td><%=t.getFlight().getDepartureDate()%></td>
                                        <td><%=t.getFlight().getPlane().getAirline()%></td>
                                        <td><%=t.getFlight().getPlane().getPlaneModel()%></td>
                                        <td><%=t.getFlight().getFlightPrice()%></td>
                                        <td><%=t.getSeatNumber()%></td>

                                        <form method="post">
                                        <td> <button  class="btn btn-danger" type="submit"  formaction="DeleteTicket?ticketId=<%=t.getId()%>" name="delete" >Удалить</button></td>
                                            <td> <button  class="btn btn-primary" type="submit"  formaction="GetFile?pasp=<%=t.getPassenger().getPassport()%>&dest=<%=t.getFlight().getDestination()%>&ddate=<%=t.getFlight().getDepartureDate()%>&airl=<%=t.getFlight().getPlane().getAirline()%>&pl=<%=t.getFlight().getPlane().getPlaneModel()%>&pr=<%=t.getFlight().getFlightPrice()%>&seat=<%=t.getSeatNumber()%>" name="file" >Получить файл</button></td>
                                        </form>

                                    </tr>

                                    <% } %>
                                    </tbody>
                                </table>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">закрыть</button>

                            </div>
                        </div>
                    </div>
                </div>

                <%
                    }
                %>

            </ul>

        </div>
    </div>
</nav>
<script>
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });
</script>


