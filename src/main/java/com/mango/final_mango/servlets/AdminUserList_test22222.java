package com.mango.final_mango.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mango.final_mango.dao.UserWithDB_test22222;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/admin/userList")
public class AdminUserList_test22222 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_uid = request.getParameter("USER_ID");
        String keyWord = request.getParameter("keyWord");
        String keyField = request.getParameter("keyField");

        UserWithDB_test22222 userWithDB = new UserWithDB_test22222();

        ArrayList<HashMap> user_list = null;

        try {
            user_list = userWithDB.getUser(user_uid, keyWord, keyField);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("user_list", user_list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/user_management_test22222.jsp");
        requestDispatcher.forward(request, response);
    }
}
