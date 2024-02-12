<%--
  Created by IntelliJ IDEA.
  User: fando
  Date: 08.05.2023
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entities.User"  %>
<%@ page import="DAO.PassengerDao" %>
<%@ page import="java.util.*" %>
<%  User auth = (User )request.getSession().getAttribute("auth");
    if (auth!=null){
        request.setAttribute("auth", auth);
    }

    UserService userService = new UserService();
    List<User> users= userService.findAllEntities();
    PassengerDao passengerDao1 = new PassengerDao();
    Map<User,Integer> map2=new HashMap<>();
    for(User user:users){
        List<Passenger> passengers=passengerDao1.passengerByUser(user.getId());
        if(!user.getRole().equals("admin"))
            map2.put(user,passengers.size());
    }
    List<String> list=new ArrayList<>();
    for(int i=0;i<10;i++) {
        if (!map2.isEmpty()) {
            Map.Entry<User, Integer> val = Collections.max(map2.entrySet(),
                    (Map.Entry<User, Integer> e1, Map.Entry<User, Integer> e2) ->
                            e1.getValue().compareTo(e2.getValue()));
            User user=val.getKey();
            String record=user.getLogin();
            list.add(record);
            map2.remove(val.getKey());
        }
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


    <title>Airport</title>

</head>

<body>
<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


<%@include file="adminnav.jsp"%>

<script src="https://kit.fontawesome.com/e9cc1b736b.js" crossorigin="anonymous"></script>
<section class="about">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2 class="text-center text-uppercase color1 mb-5">
                    Активные пользователи
                </h2>
            </div>
        </div>
        <div class="row">

            <div class="col-xl-4 col-md-6 col-sm-12">
                <div class="itd_circle"><i class="fa-solid fa-person"></i></i>
                </div>
                <%int i =0;
                    if(list.size()>i){%>
                <h5 class="text-center"><%=list.get(i)%></h5>
                <%
                    }
                %>
                <div class="line"></div>
            </div>

            <div class="col-xl-4 col-md-6 col-sm-12">
                <div class="itd_circle"><i class="fa-solid fa-person-dress"></i></div>
                <%i=1;
                    if(list.size()>i){%>
                <h5 class="text-center"><%=list.get(i)%></h5>
                <%
                    }
                %>
                <div class="line"></div>
            </div>
            <div class="col-xl-4 col-md-6 col-sm-12">
                <div class="itd_circle"><i class="fa-solid fa-person"></i></div>
                <%i=2;
                    if(list.size()>i){%>
                <h5 class="text-center"><%=list.get(i)%></h5>
                <%
                    }
                %>
                <div class="line"></div>
            </div>
            <div class="col-xl-4 col-md-6 col-sm-12">
                <div class="itd_circle"><i class="fa-solid fa-person-dress"></i></div>
                <%i=3;
                    if(list.size()>i){%>
                <h5 class="text-center"><%=list.get(i)%></h5>
                <%
                    }
                %>
                <div class="line"></div>
            </div>
            <div class="col-xl-4 col-md-6 col-sm-12">
                <div class="itd_circle"><i class="fa-solid fa-person"></i></div>
                <%i=4;
                    if(list.size()>i){%>
                <h5 class="text-center"><%=list.get(i)%></h5>
                <%
                    }
                %>
                <div class="line"></div>
            </div>
            <div class="col-xl-4 col-md-6 col-sm-12">
                <div class="itd_circle"><i class="fa-solid fa-person-dress"></i></div>
                <%i=5;
                    if(list.size()>i){%>
                <h5 class="text-center"><%=list.get(i)%></h5>
                <%
                    }
                %>
                <div class="line"></div>
            </div> <div class="col-xl-4 col-md-6 col-sm-12">
        </div>

        </div>
    </div>


</section>

</body>
</html>
