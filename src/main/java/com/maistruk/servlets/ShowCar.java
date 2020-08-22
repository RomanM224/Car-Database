package com.maistruk.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maistruk.basecar.*;
import com.maistruk.basecar.Processes;

public class ShowCar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Processes process = new Processes();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId =(String) request.getParameter("userId");
        request.setAttribute("userId", userId);
        System.out.println(userId);
        


        if (request.getParameter("button1") != null ) {
            ArrayList<Car> arrayCar = process.loadCar(userId);
            request.setAttribute("array", arrayCar);
        } else if (request.getParameter("button2") != null) {
            ArrayList<Car> arrayCar = process.loadCar(userId);
            Collections.sort(arrayCar, new NameCompare());
            request.setAttribute("array", arrayCar);
        } else if (request.getParameter("button3") != null) {
            ArrayList<Car> arrayCar = process.loadCar(userId);
            Collections.sort(arrayCar, new YearCompare());
            request.setAttribute("array", arrayCar);
        }
        
        request.getRequestDispatcher("/ShowCar.jsp").forward(request, response);
        System.out.println("asda");
    }

}
