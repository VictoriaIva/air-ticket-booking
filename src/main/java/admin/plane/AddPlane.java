package admin.plane;

import Service.PlaneService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import Entities.*;
import Service.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddPlane", value = "/AddPlane")
public class AddPlane extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sideNumber= request.getParameter("sideNumber");
        Integer seatsNumber= Integer.valueOf(request.getParameter("seatsNumber"));
        String airline= request.getParameter("airline");
        String planeModel=request.getParameter("planeModel");

        PlaneService planeService=new PlaneService();
        List<Plane> planes = planeService.findAllEntities();
        List<String> sidenumbers=new ArrayList<>();

        for (Plane p:planes ) {
            sidenumbers.add(p.getSideNumber());
        }

        if(!sidenumbers.contains(sideNumber)){
            Plane plane= new Plane(sideNumber,seatsNumber,airline,planeModel);
            planeService.saveEntity(plane);
            response.sendRedirect("/Airport_war_exploded/Planes");
        }else{
            request.getSession().setAttribute("error", "sideNumber");
            response.sendRedirect("adminAddPlane.jsp");
        }



    }
}
