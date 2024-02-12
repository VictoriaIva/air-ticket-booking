package admin.plane;

import Entities.*;
import Service.FlightService;
import Service.PlaneService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Planes", value = "/Planes")
public class Planes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PlaneService planeService=new PlaneService();
        List<Plane> planes=planeService.findAllEntities();
        request.getSession().setAttribute("Planes", planes);
        request.getRequestDispatcher("adminPlanes.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] checkedRows = request.getParameterValues("inlineRadioOptions");

        String byairline="byairline";
        String byplanemodel ="byplanemodel";
        PlaneService planeService=new PlaneService();
        List<Plane> planes=planeService.findAllEntities();
        if (checkedRows!=null) {
            if (checkedRows[0].equals(byairline)) {
                request.getSession().setAttribute("otvet", byairline);
                planes.sort(((o1, o2) -> (o1.getAirline().compareTo(o2.getAirline()))));
                request.getSession().setAttribute("Planes", planes);
            }else{
                request.getSession().setAttribute("otvet", byplanemodel);
                planes.sort((o1, o2) -> (o1.getPlaneModel().compareTo(o2.getPlaneModel())));
                request.getSession().setAttribute("Planes", planes);
            }
        }

        request.getRequestDispatcher("adminPlanes.jsp").forward(request, response);




    }





}
