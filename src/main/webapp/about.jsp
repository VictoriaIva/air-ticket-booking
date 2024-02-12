<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Entities.User"  %>
<%@ page import="Entities.Plane"  %>
<%@ page import="DAO.TicketDao" %>
<%@ page import="Entities.Ticket" %>
<%@ page import="Service.*" %>
<%@ page import="java.util.*" %>
<%
  FlightService flightService = new FlightService();
  TicketDao ticketDao=new TicketDao();
  List<Flight> flights = flightService.findAllEntities();
  Map<Flight,Integer> map=new HashMap<>();
  for(Flight f:flights){
    List<Ticket> tickets1 = ticketDao.ticketsbyflID(f.getId());
    map.put(f,tickets1.size());
  }
  List<String> list = new ArrayList<>();
  for(int i=0;i<10;i++) {
    if (!map.isEmpty()) {
      Map.Entry<Flight, Integer> val = Collections.max(map.entrySet(),
              (Map.Entry<Flight, Integer> e1, Map.Entry<Flight, Integer> e2) ->
                      e1.getValue().compareTo(e2.getValue()));
      Flight f=val.getKey();
      String record=f.getFlightNumber()+" "+f.getDestination();
      list.add(record);
      map.remove(val.getKey());
    }
  }
  %>
<script src="https://kit.fontawesome.com/e9cc1b736b.js" crossorigin="anonymous"></script>
<section class="about">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <h2 class="text-center text-uppercase color1 mb-5">
          Популярные направления
        </h2>
      </div>
    </div>
    <div class="row">

      <div class="col-xl-4 col-md-6 col-sm-12">
        <div class="itd_circle"><i class="fa-solid fa-plane"></i></i>
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
        <div class="itd_circle"><i class="fa-solid fa-globe"></i></div>
        <%i=1;
          if(list.size()>i){%>
        <h5 class="text-center"><%=list.get(i)%></h5>
        <%
          }
        %>
        <div class="line"></div>
      </div>
      <div class="col-xl-4 col-md-6 col-sm-12">
        <div class="itd_circle"><i class="fa-solid fa-city"></i></div>
        <%i=2;
          if(list.size()>i){%>
        <h5 class="text-center"><%=list.get(i)%></h5>
        <%
          }
        %>
        <div class="line"></div>
      </div>
      <div class="col-xl-4 col-md-6 col-sm-12">
        <div class="itd_circle"><i class="fa-solid fa-earth-americas"></i></div>
        <%i=3;
          if(list.size()>i){%>
        <h5 class="text-center"><%=list.get(i)%></h5>
        <%
          }
        %>
        <div class="line"></div>
      </div>
      <div class="col-xl-4 col-md-6 col-sm-12">
        <div class="itd_circle"><i class="fa-solid fa-landmark"></i></div>
        <%i=4;
          if(list.size()>i){%>
        <h5 class="text-center"><%=list.get(i)%></h5>
        <%
          }
        %>
        <div class="line"></div>
      </div>
      <div class="col-xl-4 col-md-6 col-sm-12">
        <div class="itd_circle"><i class="fa-brands fa-fly"></i></div>
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
