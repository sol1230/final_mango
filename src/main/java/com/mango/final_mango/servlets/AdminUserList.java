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

@WebServlet(urlPatterns = "/admin/userList")
public class AdminUserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_uid = request.getParameter("USER_ID");
        String keyWord = request.getParameter("keyWord");
        String keyField = request.getParameter("keyField");

        UserWithDB userWithDB = new UserWithDB();

        ArrayList<HashMap> user_list = null;
        String user_id = request.getParameter("user_id");
        String name = request.getParameter("name");
        String birth_date = request.getParameter("birth_date");
        String phone = request.getParameter("phone");
 
        userWithDB.modifyUserInfo(user_id, name, birth_date, phone);

        try {
            user_list = userWithDB.getUser(user_uid, keyWord, keyField);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("user_list", user_list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/user_management.jsp");
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
