package admin.plane;

import Service.PlaneService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import Entities.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UpdatePlane", value = "/UpdatePlane")
public class UpdatePlane extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer planeID = Integer.valueOf(request.getParameter("id"));
        String sideNumber =request.getParameter("sideNumber");
        Integer seatsNumber= Integer.valueOf(request.getParameter("seatsNumber"));
        String airline=request.getParameter("airline");
        String planeModel=request.getParameter("planeModel");

        PlaneService planeService=new PlaneService();
        Plane plane=planeService.findEntity(planeID);
        List<Plane> planes = planeService.findAllEntities();
        List<String> sidenumbers = new ArrayList<>();
        for (Plane p: planes) {
            sidenumbers.add(p.getSideNumber());
        }

        if(plane.getSideNumber().equals(sideNumber)){
            plane.setSeatsNumber(seatsNumber);
            plane.setAirline(airline);
            plane.setPlaneModel(planeModel);
            planeService.updateEntity(plane);
            response.sendRedirect("/Airport_war_exploded/Planes");
        }else{
            if( sidenumbers.contains(sideNumber)){
                request.getSession().setAttribute("error", "error");
                response.sendRedirect("adminUpdatePlane.jsp");
            }else{
                plane.setSideNumber(sideNumber);
                plane.setSeatsNumber(seatsNumber);
                plane.setAirline(airline);
                plane.setPlaneModel(planeModel);
                planeService.updateEntity(plane);
                response.sendRedirect("/Airport_war_exploded/Planes");
            }
        }

    }
}
