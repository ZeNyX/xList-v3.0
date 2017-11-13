package ua.ivfr.it.lms.controllers;

import ua.ivfr.it.lms.views.IndexView;
import ua.ivfr.it.lms.views.PathHtmlSingleton;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StartServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class StartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.write("<H1>Patch notes</H1>");
            out.println("<button type=\"button\" class=\"btn btn-primary\">Підготовлена</button>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        PathHtmlSingleton pathHTML = PathHtmlSingleton.getInstance();
        if(pathHTML.getPath().equals("")) {
            pathHTML.setPath(getServletContext().getRealPath("/html/"));
        }
        pathHTML.setTop("top.html");
        pathHTML.setMenu("menu.html");
        pathHTML.setBottom("bottom.html");
        System.out.println("Path\t" + pathHTML.getPath());
    }
}
