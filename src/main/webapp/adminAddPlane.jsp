<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entities.User"  %>
<%@ page import="Entities.Plane"  %>
<%@ page import="DAO.TicketDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entities.Ticket" %>
<%@ page import="java.util.Set" %>
<%@ page import="Service.*" %>
<%  User auth = (User )request.getSession().getAttribute("auth");
    if (auth!=null){
        request.setAttribute("auth", auth);


    }
    PlaneService planeService = new PlaneService();
    List<Plane> planes = planeService.findAllEntities();
    List<Integer> planeid = new ArrayList<>();
    for (Plane p: planes) {
        planeid.add(p.getId());
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




<%@include file="adminnav.jsp"%>

<h5 class="flightId">${b}</h5>
<h5 class="flightId">${a}</h5>

<div class="container mx-auto">

    <div class="row">

        <div class="col-md-offset-3 col-md-6 mx-auto ">

            <form class="form-horizontal" action="AddPlane" method="post">


                <div class="input-group mb-3">
                    <input type="text"  minlength="2" maxlength="30" class="form-control" placeholder="sideNumber" aria-label="sideNumber" name="sideNumber" required>

                </div>
                <div class="input-group mb-3">
                    <input type="number" min="1" minlength="2" maxlength="9" class="form-control" placeholder="seatsNumber" aria-label="seatsNumber" name="seatsNumber" required>
                </div>

                <div class="input-group mb-3">
                    <input type="text"  minlength="2" maxlength="30" class="form-control" placeholder="airline" aria-label="airline" name="airline" required>
                </div>

                <div class="input-group mb-3">
                    <input type="text"  minlength="2" maxlength="30" class="form-control" placeholder="planeModel" aria-label="planeModel" name="planeModel" required>
                </div>

                <h5 class="flightId">${error}</h5>
                <button type="submit" class="btn btn-primary">Подтвердить</button>

            </form>

        </div>


    </div><!-- /.row -->

</div><!-- /.container -->



</body>

</html>