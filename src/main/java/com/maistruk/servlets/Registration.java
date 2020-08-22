package com.maistruk.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maistruk.basecar.User;
import com.maistruk.basecar.Processes;

public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Processes process = new Processes();
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        boolean check = true;
        
        if (request.getParameter("registrationButton") != null) {

            User user = new User();

            String login = request.getParameter("regLogin");
            if (login == null || login.trim().isEmpty()) {
                messages.put("regLogin", "Enter loing");
                check = false;
            } else {
                user.setLogin(login);
            }

            String password = request.getParameter("regPassword");
            if (password == null || password.trim().isEmpty()) {
                messages.put("regPassword", "Enter password");
                check = false;
            } else {
                user.setPassword(password);
            }

            String name = request.getParameter("regName");
            if (name == null || name.trim().isEmpty()) {
                messages.put("regName", "Entter name");
                check = false;
            } else {
                user.setName(name);
            }

            String surname = request.getParameter("regSurname");
            if (surname == null || surname.trim().isEmpty()) {
                messages.put("regSurname", "Enter surname");
                check = false;
            } else {
                user.setSurname(surname);
            }

            String year = request.getParameter("regYear");
            if (year == null || year.trim().isEmpty()) {
                messages.put("regYear", "Enter year");
                check = false;
            } else {
                user.setDate(year);
            }

            String email = request.getParameter("regEmail");
            if (email == null || email.trim().isEmpty()) {
                messages.put("regEmail", "Enter email");
                check = false;
            } else {
                user.setLogin(login);
            }
            
            if(check) {
            process.saveUser(user);
            System.out.println(user);
            request.setAttribute("registration", "Registration Complete");
            request.getRequestDispatcher("/Registration.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher("/Registration.jsp").forward(request, response);
            }

        }

        if (request.getParameter("logInButton") != null) {
            ArrayList<User> userList = process.loadUser();
            User user = null;
            System.out.println(userList);
            String login = request.getParameter("enterLogin");
            String password = request.getParameter("enterPassword");
            boolean checkLogin = false;
            boolean checkPassword = false;
            for (User u : userList) {
                if (login.equals(u.getLogin())) {
                    checkLogin = true;
                }
                if (password.equals(u.getPassword())) {
                    checkPassword = true;
                }
                if (checkLogin && checkPassword) {
                    user = u;
                    checkLogin = false;
                    checkPassword = false;
                }

            }
            if (user != null) {
                request.setAttribute("userId", user.getId());
                
                request.getRequestDispatcher("/ShowCar.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/Registration.jsp").forward(request, response);

            }

        }
    }

}
