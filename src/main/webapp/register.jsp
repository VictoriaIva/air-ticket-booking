
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entities.User"  %>
<%  User auth = (User )request.getSession().getAttribute("auth");
  if (auth!=null){
    request.setAttribute("auth", auth);
  }

%>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

  <link rel="stylesheet" href="css/stylelogin.css">

  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>
<body>
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>






<div class="container">
  <div class="row">

    <div class="col-md-offset-3 col-md-6">
      <form class="form-horizontal" action="RegisterServlet" method="post">

        <span class="heading">РЕГИСТРАЦИЯ</span>
        <div class="form-group">
          <input type="text" class="form-control" id="inputLogin" placeholder="Login" name="login">
          <i class="fa fa-user"></i>
        </div>
        <div class="form-group help">
          <input type="password" class="form-control" minlength="4" maxlength="6" id="inputPassword" placeholder="Password" name="pass">
          <i class="fa fa-lock"></i>
          <a href="#" class="fa fa-question-circle"></a>
        </div>
        <font color="red">${errorMessage}</font>
        <button type="submit" class="btn btn-default">Зарегистрироваться</button>
        <a href="LoginServlet" class="btn btn-default">Авторизация</a>

      </form>



    </div>

  </div><!-- /.row -->
</div><!-- /.container -->




</body>
</html>
