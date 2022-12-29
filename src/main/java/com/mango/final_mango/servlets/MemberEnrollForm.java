package com.mango.final_mango.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/enrollForm.me")
public class MemberEnrollForm extends HttpServlet{
    private static final long serialVersionUID = 1L;


public MemberEnrollForm() {
    super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // 응답페이지 (회원가입 페이지)
    RequestDispatcher view = request.getRequestDispatcher("views/memeber/memberEnrollForm.jsp");
    view.forward(request,response);
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
}

}