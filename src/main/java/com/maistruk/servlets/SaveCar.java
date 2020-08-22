package com.maistruk.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maistruk.basecar.*;
import com.maistruk.basecar.Processes;

public class SaveCar extends HttpServlet {
    Processes process = new Processes();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String DOUBLE_PATTERN = "[0-9]+(\\.){0,1}[0-9]*";
        final String INTEGER_PATTERN = "\\d+";
        String userId =(String) request.getParameter("userId");
        request.setAttribute("userId", userId);
        System.out.println(userId);
        
        if (request.getParameter("saveCar") != null) {
            Car car = new Car();
            boolean check = true;
            boolean checkInputYear;
            Map<String, String> messages = new HashMap<String, String>();
            request.setAttribute("messages1", messages);

            String carName = request.getParameter("carName");
            if (carName == null || carName.trim().isEmpty()) {
                messages.put("carName", "Enter car name");
                check = false;
            } else {
                car.setCarName(carName);
            }

            String carModel = request.getParameter("carModel");
            if (carModel == null || carModel.trim().isEmpty()) {
                messages.put("carModel", "Enter car model");
                check = false;
            } else {
                car.setCarModel(carModel);
            }

            String carEngine = request.getParameter("carEngine");
            if (carEngine == null || carEngine.trim().isEmpty() || !Pattern.matches(DOUBLE_PATTERN, carEngine)) {
                messages.put("carEngine", "Enter car engine");
                check = false;
            } else {
                car.setCarEngine(Double.parseDouble(carEngine));
            }

            String carYear = request.getParameter("carYear");
            checkInputYear = checkInput(carYear);
            if (carYear == null || carEngine.trim().isEmpty() || !Pattern.matches(INTEGER_PATTERN, carYear)) {
                messages.put("carYear", "Enter car year");
                check = false;
            } else {
                car.setCarYear(Integer.parseInt(carYear));
            }

            if (check) {
                request.setAttribute("label", "CAR SAVED");
                 process.saveCar(car, userId);

            }
        }

        request.getRequestDispatcher("/SaveCar.jsp").forward(request, response);
    }

    public boolean checkInput(String number) {
        boolean check = false;
        char[] charsArray = number.toCharArray();
        for (char c : charsArray) {
            if (!Character.isDigit(c)) {
                check = true;
            }
        }
        return check;
    }

}
