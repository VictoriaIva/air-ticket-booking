
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entities.User"  %>
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

<section class="mh-100" style="background-color: #eee;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center ">
            <div class="col-md-12 col-xl-4">

                <div class="card" style="border-radius: 15px;">
                    <div class="card-body text-center">
                        <div class="mt-3 mb-4">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava2-bg.webp"
                                 class="rounded-circle img-fluid" style="width: 100px;" />
                        </div>
                        <h4 class="mb-2"><%=auth.getLogin()%></h4>
                        <br>
                        <br>
                        <form class="form-horizontal" action="ChangePassword?userId=<%=auth.getId()%>" method="post">
                            <div class="form-group">
                                <label for="exampleInputPassword1">старый пароль</label>
                        <input type="password" class="form-control" minlength="4" maxlength="6" id="exampleInputPassword1" placeholder="Password" name="p1" required>
                            </div>
                                <br>
                            <div class="form-group">
                                <label for="exampleInputPassword1">новый пароль</label>
                        <input type="password" class="form-control" minlength="4" maxlength="6" id="exampleInputPassword2" placeholder="Password" name="p2" required>
                            </div>
                            <h5 class="flightId">${error}</h5>
                                <button  type="submit" class="btn btn-primary">сменить</button>
                        </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</section>



</body>
</html>
