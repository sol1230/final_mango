package com.mango.final_mango.servlets;

import java.io.IOException;

import com.mango.final_mango.dao.UserWithDB_test22222;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/admin/userModifyServlet")
public class AdminUserModifyServlets_test22222 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String user_id = request.getParameter("user_id");
       String name = request.getParameter("name");
       String birth_date = request.getParameter("birth_date");
       String phone = request.getParameter("phone");

       UserWithDB_test22222 userWithDB = new UserWithDB_test22222();

       userWithDB.modifyUserInfo(user_id, name, birth_date, phone);
       RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/userList");
       requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
