package ravi.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ravi.model.BeerExpert;

/**
 * Created by raviagrawal on 29/01/17.
 */
@WebServlet(name = "BeerSelectServlet")
public class BeerSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("message from doPost method....*************************....");
        String color = request.getParameter("color");
        BeerExpert beerExpert = new BeerExpert();
        List result = beerExpert.getBrands(color);

        request.setAttribute("styles", result);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void init() throws ServletException {
        //db init code goes here
        System.out.println("message from init method....*************************....");
    }

}
