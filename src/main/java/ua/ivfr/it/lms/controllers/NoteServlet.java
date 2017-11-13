package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.views.IndexView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Створює, відображає і видаліє замітку
 */
@WebServlet(name = "NoteServlet", value = {"/note/*"})
public class NoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        switch (request.getPathInfo()) {
            case "/list-notes":
                out.write("<H1>List Note!</H1>");
                out.println("<button type=\"button\" class=\"btn btn-primary\">Підготовлена</button>");
                break;
            case "/view-note":
                out.write("<H1>Hello Note!</H1>");
                out.println("<button type=\"button\" class=\"btn btn-primary\">Підготовлена</button>");
                break;
        }
    }
}
