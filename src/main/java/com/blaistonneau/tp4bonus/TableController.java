package com.blaistonneau.tp4bonus;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tables")
public class TableController extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse response) throws ServletException, IOException {
        Queries queries = new Queries();
        PrintWriter out = response.getWriter();
        out.println("<h1>Display Database Table with J2EE from Marie & Alexis !</h1>");
        out.println("<style>table, th, td {border: 1px solid black;border-collapse: collapse; } </style>");
        out.println("<table>");
        queries.displayTable(httpServletRequest.getParameter("table") != null ? httpServletRequest.getParameter("table") : "emp").forEach(emp -> {
            out.println("<tr>");
            emp.forEach(entry -> {
                out.println("<td>");
                out.println(entry != null ? entry.toString() : "");
                out.println("</td>");
            });
            out.println("</tr>");
        });

        out.println("</table>");


    }
}
