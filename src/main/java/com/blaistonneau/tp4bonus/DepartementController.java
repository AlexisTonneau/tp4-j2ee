package com.blaistonneau.tp4bonus;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/departement")
public class DepartementController extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse response) throws ServletException, IOException {
        Queries queries = new Queries();
        PrintWriter out = response.getWriter();
        out.println("<h1>Display Departements with J2EE from Marie & Alexis !</h1>");
        queries.displayDepartment().forEach(str -> out.println("<h3>"+str+"</h3>"));
    }

}
