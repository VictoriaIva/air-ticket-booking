package admin.flight;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ToUpdateFlight", value = "/ToUpdateFlight")
public class ToUpdateFlight extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer flightId = Integer.valueOf(request.getParameter("flightid"));
        request.getSession().setAttribute("flightId", flightId);
        response.sendRedirect("adminUpdateFlight.jsp");
    }
}
