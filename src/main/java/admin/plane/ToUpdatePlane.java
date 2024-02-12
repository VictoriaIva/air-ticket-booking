package admin.plane;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ToUpdatePlane", value = "/ToUpdatePlane")
public class ToUpdatePlane extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer planeId = Integer.valueOf(request.getParameter("id"));
        request.getSession().setAttribute("planeId", planeId);
        response.sendRedirect("adminUpdatePlane.jsp");
    }
}
