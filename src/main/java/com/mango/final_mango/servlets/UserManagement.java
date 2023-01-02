package com.mango.final_mango.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mango.final_mango.dao.UserWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/userManagement")
public class UserManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_uid = request.getParameter("USER_ID");
        String keyWord = request.getParameter("keyWord");
        String keyField = request.getParameter("keyField");
        String userDelete = request.getParameter("userDelete");

        UserWithDB userWithDB = new UserWithDB();
        ArrayList<HashMap> user_list = null;
        ArrayList<HashMap> user_delete_list = null;

        try {
            user_list = userWithDB.getUser(user_uid, keyWord, keyField);
            user_delete_list = userWithDB.getUserDelete(userDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("user_list", user_list);
        request.setAttribute("user_delete_list", user_delete_list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/user_management.jsp");
        requestDispatcher.forward(request, response);
    }
}
