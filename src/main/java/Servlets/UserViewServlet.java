package Servlets;

import Entity.PartCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserViewServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("storage", PartCache.inctance().getProducts());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/UserView.jsp");
        dispatcher.forward(request, response);
    }
}
