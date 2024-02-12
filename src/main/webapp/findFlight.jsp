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

            <form class="form-horizontal" action="FindFlights" method="post">
                <span class="heading">Поиск Рейса</span>

                <div class="input-group mb-3">
                    <input type="number"   maxlength="30" class="form-control" placeholder="цена от" aria-label="price" name="priceot" >

                    <input type="number"    maxlength="30" class="form-control" placeholder="цена до" aria-label="price"  name="pricedo" >
                </div>


                <div class="input-group mb-3">
                    <input type="text"  minlength="2" maxlength="15" class="form-control" placeholder="направление" aria-label="destination" name="destination" >

                </div>
                <span class="heading">дата отправления</span>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon2">год</span>
                    <input type="number" min="1960" max="2024"    class="form-control" placeholder="YYYY" aria-label="DATE" name="dyear" >
                    <span class="input-group-text" id="basic-addon3">месяц</span>
                    <input type="number"  min="01" max="12"   class="form-control" placeholder="MM" aria-label="DATE" name="dmonth" >
                    <span class="input-group-text" id="basic-addon4">день</span>
                    <input type="number" min="1" max="31"    class="form-control" placeholder="DD" aria-label="DATE" name="dday" >
                </div>




                <button type="submit" class="btn btn-primary">Искать</button>

            </form>

        </div>


    </div><!-- /.row -->

</div><!-- /.container -->



</body>
</html>
