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
  Integer flightId = (Integer) request.getSession().getAttribute("flightId");
  FlightService flightService=new FlightService();
  Flight flight=flightService.findEntity(flightId);
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

      <form class="form-horizontal" action="UpdateFlight?id=<%=flight.getId()%>" method="post">


        <div class="input-group mb-3">
          <input type="text"  minlength="2" maxlength="30" class="form-control" placeholder="flightNumber" aria-label="flightNumber" name="flightNumber" value="<%=flight.getFlightNumber()%>" required>

        </div>
        <span class="heading">planeID</span>
        <div class="input-group mb-3">
          <div class="input-group-prepend">
            <label class="input-group-text"   for="inputGroupSelect01" >planeID</label>
          </div>
          <select class="form-select" id="inputGroupSelect01"  name="planeID">
            <%
              if (!planeid.isEmpty()){
                for(int i=0; i<planeid.size(); i++){
            %>
            <option value="<%=planeid.get(i)%>"><%=planeid.get(i)%></option>
            <%
                }
              }

            %>
          </select>
        </div>
        <div class="input-group mb-3">
          <input type="text"  minlength="2" maxlength="30" class="form-control" placeholder="destination" aria-label="destination" value="<%=flight.getDestination()%>" name="destination" required>
        </div>
        <span class="heading">departureDate</span>
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon2">year</span>
          <input type="number" min="2023" max="2023"   value="2023"  class="form-control" placeholder="YYYY" aria-label="DATE"   name="dyear" required>
          <span class="input-group-text" id="basic-addon3">month</span>
          <input type="number"  min="01" max="12"  class="form-control" placeholder="MM" aria-label="DATE" name="dmonth" required>
          <span class="input-group-text" id="basic-addon4">day</span>
          <input type="number" min="1" max="31"    class="form-control" placeholder="DD" aria-label="DATE" name="dday" required>
        </div>
        <span class="heading">arrivalDate</span>
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon5">year</span>
          <input type="number" min="2023" max="2023"  value="2023"  class="form-control" placeholder="YYYY" aria-label="DATE" name="ayear" required>
          <span class="input-group-text" id="basic-addon6">month</span>
          <input type="number"  min="01" max="12"   class="form-control" placeholder="MM" aria-label="DATE" name="amonth" required>
          <span class="input-group-text" id="basic-addon7">day</span>
          <input type="number" min="1" max="31"    class="form-control" placeholder="DD" aria-label="DATE" name="aday" required>
        </div>

        <div class="input-group mb-3">
          <input type="number" min="1" minlength="2" maxlength="9" value="<%=flight.getFlightPrice()%>" class="form-control" placeholder="price" aria-label="price" name="price" required>
        </div>
        <h5 class="flightId">${error}</h5>
        <button type="submit" class="btn btn-primary">Подтвердить</button>

      </form>

    </div>


  </div><!-- /.row -->

</div><!-- /.container -->



</body>

</html>

