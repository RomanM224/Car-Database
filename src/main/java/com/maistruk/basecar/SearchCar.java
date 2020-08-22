package com.maistruk.basecar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchCar
 */
public class SearchCar extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Processes proces = new Processes();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId =(String) request.getParameter("userId");
        request.setAttribute("userId", userId);
        System.out.println(userId);
        
        
        if (request.getParameter("searchCar") != null) {
            ArrayList<Car> arrayCar = proces.loadCar(userId);
            ArrayList<Car> searchArray = new ArrayList<Car>();

            String name = request.getParameter("carSearch");
            name = stringToLowCase(name);
            for (Car c : arrayCar) {

                if (stringToLowCase(c.getCarName()).equals(stringToLowCase(name))) {
                    searchArray.add(c);
                }
            }
            request.setAttribute("array1", searchArray);
        }
        request.getRequestDispatcher("/SearchCar.jsp").forward(request, response);

    }


    public String stringToLowCase(String carName) {
        char[] carNameChars = carName.toCharArray();
        for (int i = 0; i < carNameChars.length; i++) {
            carNameChars[i] = Character.toLowerCase(carNameChars[i]);
        }
        return String.valueOf(carNameChars);
    }
}
