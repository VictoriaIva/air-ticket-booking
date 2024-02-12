package com.airport;

import DAO.TicketDao;
import Entities.Flight;
import Entities.Ticket;
import Service.FlightService;
import Service.TicketService;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.awt.*;
import java.util.List;

@WebServlet(name = "AdminPDF", value = "/AdminPDF")
public class AdminPDF extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TicketService ticketService = new TicketService();
        TicketDao ticketDao=new TicketDao();
        FlightService flightService=new FlightService();

        List<Flight> flights =flightService.findAllEntities();






        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File("D:\\otchet.pdf")));
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

//открыть
        document.open();


            for (Flight f:flights) {
                List<Ticket> tickets = ticketDao.ticketsbyflID(f.getId());
                tickets.sort((o1, o2) -> (o1.getSaleDate().compareTo(o2.getSaleDate())));
                String fl = String.valueOf(f);
                Paragraph p2 = new Paragraph();
                p2.add(fl);
                p2.setAlignment(Element.ALIGN_CENTER);
                try {
                    document.add(p2);
                } catch (DocumentException e) {
                    throw new RuntimeException(e);
                }

                for (int i = 0; i < tickets.size(); i++) {
                    Paragraph p = new Paragraph();
                    String s = String.valueOf(tickets.get(i));
                    p.add(s);
                    p.setAlignment(Element.ALIGN_CENTER);

                    try {
                        document.add(p);
                    } catch (DocumentException e) {
                        throw new RuntimeException(e);
                    }
                }
                String o = " ";
                Paragraph p3 = new Paragraph();
                p3.add(o);
                p3.setAlignment(Element.ALIGN_CENTER);
                try {
                    document.add(p3);
                    document.add(p3);
                } catch (DocumentException e) {
                    throw new RuntimeException(e);
                }

            }


        document.close();
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File("D:\\otchet.pdf"));



        response.sendRedirect("adminmain.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
