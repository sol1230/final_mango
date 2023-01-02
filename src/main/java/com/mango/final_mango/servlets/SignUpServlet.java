package com.mango.final_mango.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import com.mango.final_mango.dao.SignUpDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/SignUpServlet")
public class SignUpServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String,Object> userData = new HashMap<>();

        userData.put("USER_ID", request.getParameter("USER_ID"));
        userData.put("PASSWORD", request.getParameter("PASSWORD"));
        userData.put("NAME", request.getParameter("NAME"));
        userData.put("BIRTH_DATE", request.getParameter("BIRTH_DATE"));
        userData.put("PHONE", request.getParameter("PHONE"));
        
        try {
            SignUpDB.setUserData(userData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/signup_submit.jsp");
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }
}
