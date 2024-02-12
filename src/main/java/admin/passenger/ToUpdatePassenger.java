package admin.passenger;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ToUpdatePassenger", value = "/ToUpdatePassenger")
public class ToUpdatePassenger extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer passengerId = Integer.valueOf(request.getParameter("id"));
        request.getSession().setAttribute("passengerId", passengerId);
        response.sendRedirect("adminUpdatePassenger.jsp");
    }
}
