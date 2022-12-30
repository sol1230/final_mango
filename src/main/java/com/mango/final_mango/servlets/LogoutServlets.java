package com.mango.final_mango.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login/logoutServlets")
public class LogoutServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //logout
        // Session

        HttpSession httpSession = request.getSession();
        // 세션 무효화
        httpSession.invalidate();

        response.sendRedirect("/jsp/a_main.jsp");

        // String path = "/jsp/a_main.jsp";
        // dispatcher에 변수를 넘김
        // RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        // requestDispatcher.forward(request, response);
    }
}
