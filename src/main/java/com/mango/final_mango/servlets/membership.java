package com.mango.final_mango.servlets;

import java.io.IOException;
import java.util.HashMap;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/join/membership")
public class membership extends HttpServlet{
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String,Object> userData = new HashMap<>();

        userData.put("USER_ID", request.getParameter("USER_id"));
        userData.put("PASSWORD", request.getParameter("PASSWORD"));
        userData.put("NAME", request.getParameter("NAME"));
        userData.put("BIRTH_DATE", request.getParameter("BIRTH_DATE"));
        userData.put("PHONE", request.getParameter("PHONE"));


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/membership.jsp");
        requestDispatcher.forward(request, response);
    }

}