<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entities.User"  %>
<%@ page import="Entities.Flight"  %>
<%@ page import="DAO.FlightDao" %>
<%@ page import="java.util.List" %>
<%@ page import="jakarta.persistence.EntityNotFoundException" %>
<%@ page import="jakarta.persistence.NoResultException" %>
<%@ page import="Service.FlightService" %>
<%@ page import="Service.UserService" %>
<%  User auth = (User )request.getSession().getAttribute("auth");
    if (auth!=null){
        request.setAttribute("auth", auth);
    }

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

<br>
<form action="AllFlights" method="POST">

<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="byprice">
    <label class="form-check-label" for="inlineRadio1">по цене</label>
</div>
<div class="form-check form-check-inline">
    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="bydest">
    <label class="form-check-label" for="inlineRadio2">по направлению</label>
</div>

    <input class="btn btn-outline-success btn-sm" type="submit" value="сортировать"/>
</form>


<div class="container">
    <div class="card-header my-3">Все рейсы</div>

    <div class="row">

            <c:forEach items="${Flights}" var="flight">
                    <div class="col-md-3">

            <div class="card mb-3" style="max-width: 540px;">
                <div class="row g-0">
                    <div class="col-md-8">
                        <div class="card-body">

                            <span class="heading"  style="color:#484747" >направление:</span>
                            <h4 class="destination">${flight.getDestination()}</h4>
                            <span class="heading"  style="color:#484747" >дата отправления:</span>
                            <h6 class="departureDate">${flight.getDepartureDate()}</h6>
                            <span class="heading" style="color:#484747" >дата прибытия:</span>
                            <h6 class="arrivalDate">${flight.getArrivalDate()}</h6>
                            <span class="heading" style="color:#484747">стоимость:</span>
                            <h6 class="price">${flight.getFlightPrice()}</h6>

                                        <div class="mt-3 d-flex justify-content-between">
                                            <a href="GetTicketServlet?id=${flight.getId()}" class="btn btn-primary">Забронировать</a>
                                        </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
            </c:forEach>





    </div>


</div>



</body>
</html>
