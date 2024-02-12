<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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




<%@include file="adminnav.jsp"%>
<br>
<div class="container mx-auto">
    <form action="Users" method="POST">

        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="byrole">
            <label class="form-check-label" for="inlineRadio1">byrole</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="byisBlocked">
            <label class="form-check-label" for="inlineRadio2">byisBlocked</label>
        </div>

        <input class="btn btn-outline-success btn-sm" type="submit" value="сортировать"/>
    </form>
</div>



<div class="container mx-auto">
    <div class="row">
        <form method="post">
            <button class="btn btn-primary" type="submit" formaction="adminAddUser.jsp" name="edit" >Добавить</button>
            <br>
            <br>
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">login</th>
                    <th scope="col">password</th>
                    <th scope="col">role</th>
                    <th scope="col">isBlocked</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${Users}" var="user">
                    <tr>
                        <td>${user.getId()} </td>
                        <td>${user.getLogin()}</td>
                        <td> ${user.getPassword()}</td>
                        <td> ${user.getRole()}</td>
                        <td> ${user.getIsBlocked()}</td>

                        <td>
                            <button onclick="myFunction()"  class="btn btn-primary" type="submit" formaction="DeleteUser?id=${user.getId()}" name="delete" >Удалить</button>
                            <button class="btn btn-primary" type="submit" formaction="ToUpdateUser?id=${user.getId()}" name="edit" >Отредактировать</button>

                        </td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </div>
</div>
<script>
    function myFunction() {
        alert("пассажиры также будут удалены");
    }
</script>

</body>
</html>
