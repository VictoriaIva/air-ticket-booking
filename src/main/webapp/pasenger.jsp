<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entities.User"  %>
<%@ page import="Entities.Flight"  %>
<%@ page import="DAO.TicketDao" %>
<%@ page import="java.util.List" %>
<%@ page import="Service.FlightService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entities.Ticket" %>
<%@ page import="java.util.Set" %>
<%  User auth = (User )request.getSession().getAttribute("auth");
    if (auth!=null){
        request.setAttribute("auth", auth);


    }
    Flight flight = (Flight) request.getSession().getAttribute("flight");
    Integer flightId = flight.getId();
    FlightService flightService = new FlightService();

    int seatsnum= flight.getPlane().getSeatsNumber();

    TicketDao ticketDao= new TicketDao();
    List <Integer> takedseats= new ArrayList<>();
    List<Ticket> tickets= ticketDao.ticketsbyflID(flightId);
    for (Ticket t: tickets) {
        takedseats.add(Integer.parseInt(t.getSeatNumber()));
    }

    List<Integer> planeseats=new ArrayList<>();
    for(int i=1; i<=seatsnum; i++){
        planeseats.add(i);
    }

    planeseats.removeAll(takedseats);

%>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://kit.fontawesome.com/e9cc1b736b.js" crossorigin="anonymous"></script>




    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fontello.css">
    <link rel="stylesheet" href="css/style.css">


    <title>SITE</title>
</head>

<body>
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>




<%@include file="nav.jsp"%>




<div class="container mx-auto">



    <div class="row">

        <div class="col-md-offset-3 col-md-6 mx-auto ">

            <form class="form-horizontal" action="PassengerServlet?id=<%=flightId%>&userId=<%=auth.getId()%>" method="post">
                <span class="heading">Пассажир</span>

                <div class="input-group mb-3">
                    <input type="text" value="вика" minlength="2" maxlength="30" class="form-control" placeholder="имя" aria-label="Username" name="name" required>

                    <input type="text"  value="ивановская" minlength="2" maxlength="30" class="form-control" placeholder="фамилия" aria-label="Surname"  name="sname" required>
                </div>
                <span class="heading">Date of brth</span>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon2">год</span>
                    <input type="number" min="1960" max="2023"  value="2003"  class="form-control" placeholder="YYYY" aria-label="DATE" name="year" required>
                    <span class="input-group-text" id="basic-addon3">месяц</span>
                    <input type="number"  min="01" max="12" value="08"  class="form-control" placeholder="MM" aria-label="DATE" name="month" required>
                    <span class="input-group-text" id="basic-addon4">день</span>
                    <input type="number" min="1" max="31"  value="11"  class="form-control" placeholder="DD" aria-label="DATE" name="day" required>
                </div>

                <div class="input-group mb-3">
                    <input type="text" value="KB1234567" minlength="9" maxlength="9" class="form-control" placeholder="паспорт" aria-label="pasport" name="pasp" required>

                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon1">+375</span>
                    <input type="text" value="123456789" minlength="9" maxlength="9" class="form-control" placeholder="телефон" aria-label="phone" name="phone" required>
                </div>

                <div class="input-group mb-3">
                    <input type="text" value="hello@gmai.com" minlength="2" maxlength="30" class="form-control" placeholder="email" aria-label="@" name="email" required>
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">место</label>
                    </div>
                    <select class="form-select" id="inputGroupSelect01" name="seat">

                        <%
                            if (seatsnum!=0){
                                for(int i=0; i<planeseats.size(); i++){
                        %>
                        <option value="<%=planeseats.get(i)%>"><%=planeseats.get(i)%></option>
                        <%
                                }
                            }

                        %>
                    </select>

                </div>

                <button type="submit" class="btn btn-primary">Подтвердить</button>

            </form>

        </div>


    </div><!-- /.row -->

</div><!-- /.container -->



</body>

</html>
