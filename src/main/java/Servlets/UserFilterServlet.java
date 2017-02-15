package Servlets;

import Filtration.PartVerificator;
import Service.ProductStorage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserFilterServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductStorage.getInctance().filter(
                PartVerificator.priceBetween(Double.parseDouble(request.getParameter("priceFrom")),
                        Double.parseDouble(request.getParameter("priceTo"))));
        response.sendRedirect(String.format("%s%s", request.getContextPath(), "/"));
    }
}
