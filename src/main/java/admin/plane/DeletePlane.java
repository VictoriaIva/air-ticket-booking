package admin.plane;

import DAO.FlightDao;
import DAO.PlaneDao;
import Entities.Flight;
import Entities.Plane;
import Service.FlightService;
import Service.PlaneService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeletePlane", value = "/DeletePlane")
public class DeletePlane extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Integer planeId = Integer.valueOf(request.getParameter("id"));

        PlaneService planeService=new PlaneService();
        PlaneDao planeDao=new PlaneDao();
        Plane plane=planeService.findEntity(planeId);
        FlightDao flightDao=new FlightDao();
        FlightService flightService=new FlightService();
        List<Flight> flights =flightDao.FlightsbyPlID(planeId);

       if (!flights.isEmpty()){
            for (Flight f:flights) {
                flightService.deleteEntity(f);
            }
        }

        planeService.deleteEntity(plane);
        response.sendRedirect("/Airport_war_exploded/Planes");
    }
}
