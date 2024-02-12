package com.airport;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import java.lang.Object;
import java.awt.Desktop;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "GetFile", value = "/GetFile")
public class GetFile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String pasp =request.getParameter("pasp");
        String dest =request.getParameter("dest");
        String ddate =request.getParameter("ddate");
        String pl =request.getParameter("pl");
        String pr =request.getParameter("pr");
        String seat =request.getParameter("seat");

       // List<String> lines = Arrays.asList(pasp,dest,ddate,pl,pr,seat );
        String line = pasp+" "+dest+" "+ddate+" "+pl+" "+pr+" "+seat;

        try {
            // Возьмите файл
            File f = new File("D:\\example.txt");
            //Создайте новый файл
            // Убедитесь, что он не существует
            if (f.createNewFile()) {
                System.out.println("File created");
            }
            else {
                System.out.println("File already exists");
            }

            Path pathToFile = Paths.get("D:\\example.txt"); // Получаем путь до файла

// Записываем строку в файл
// Указываем путь, строку, стандарт кодирования символов и
// опции записи в файл
            Files.writeString(pathToFile, line, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            Desktop desktop = Desktop.getDesktop();
                desktop.open(f);
            System.out.println("Successfully written data to the file");
        }
        catch (Exception e) {
            System.err.println(e);
        }

        response.sendRedirect("main.jsp");

    }
}
