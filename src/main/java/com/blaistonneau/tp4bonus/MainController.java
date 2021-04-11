package com.blaistonneau.tp4bonus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Welcome to J2EE implementation of TP3 !</h1>");
        out.println("<h3>Made by Marie BLAIS & Alexis TONNEAU</h3>");
        out.println("<a href='tables'>Display a table</a><br/>");
        out.println("<a href='departement'>Display first exercice with departements</a>");
        out.println("</body></html>");
    }
}
