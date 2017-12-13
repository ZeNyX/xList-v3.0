package xlist.controller;

import xlist.dao.UserDaoImpl;
import xlist.models.User;
import xlist.view.IndexView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet",  urlPatterns = {"user/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();


        String email = request.getParameter("registerEmailLogin");
        String password = request.getParameter("registerLoginPassword");
        String name = request.getParameter("inputName");


        HttpSession session = request.getSession();
        UserDaoImpl userDao = new UserDaoImpl();

        User user = userDao.findUserByEmail(email);
        //якщо емейл є в БД, змінна user буде посилатись на об'єкт класу User, інакше дорівнюватиме null
        if(user != null) {
            //записав об'єкт користувача в сесію, щоб перевіряти в інших сервлетах чи зареєстрований користувач
            out.write("<H1>З таким мейлом вже існує</H1>");
        } if(user==null) {
            userDao.creatUser(email,password,name);
            user=userDao.findUserByEmail(email);
            //записав об'єкт користувача в сесію, щоб перевіряти в інших сервлетах чи зареєстрований користувач
            session.setAttribute("user", user);
            out.write("<div class=\"panel panel-default\">\n" +
                    "  <!-- Default panel contents -->\n" +
                    "  <div class=\"panel-heading\">Заголовок панелі</div>\n" +
                    "\n" +
                    "  <!-- Table -->\n" +
                    "  <table class=\"table\">\n" +
                    "    <tr>\n" +
                    "    <th>Firstname</th>\n" +
                    "    <th>Lastname</th> \n" +
                    "    <th>Age</th>\n" +
                    "  </tr>\n" +
                    "  </table>\n" +
                    "</div>");
            response.sendRedirect("/note/");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        IndexView indexView = new IndexView();
        HttpSession session = request.getSession();
        indexView.outContentIndexPage(out, session);




    }
}
