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

@WebServlet(urlPatterns = "/userSearch")
public class UserSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyWord = request.getParameter("keyWord");
        String keyField = request.getParameter("keyField");
        UserWithDB userWithDB = new UserWithDB();
 
        ArrayList<HashMap> search_list = null;

        try {

            search_list = userWithDB.getUserSearch(keyWord, keyField);
        } catch (SQLException e) {
            e.printStackTrace();
        }



        request.setAttribute("search_list", search_list);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/user_search.jsp");
        requestDispatcher.forward(request, response);
    }
}
