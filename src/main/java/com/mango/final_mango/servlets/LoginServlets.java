package com.mango.final_mango.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.mango.final_mango.dao.LoginWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /login/loginServlets?user_id=U1&password=1234
@WebServlet(urlPatterns = "/login/loginServlets")
public class LoginServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 한글 처리
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        // input type
        String user_id = request.getParameter("user_id");
        String password = request.getParameter("password");

        // DB 불러오기
        LoginWithDB loginWithDB = new LoginWithDB();

        // Session
        HttpSession httpSession = null;
        
        try {
            if(loginWithDB.checkLoginDB(user_id, password)){
                httpSession = request.getSession();
                httpSession.setAttribute("user_id", user_id);
                httpSession.setAttribute("password", password);
                response.sendRedirect("/jsp/a_main.jsp");
                // path = "/jsp/a_main.jsp";

            }else{
                // alert창을 띄우기(jsp에서는 어떻게?)
                printWriter.println("<script type='text/javascript'>");
                printWriter.println("alert('로그인 정보가 일치하지 않습니다.')");
                // 전 페이지로 돌아가게 해주는
                printWriter.println("history.back();");
                printWriter.println("</script>");
                printWriter.flush();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // dispatcher에 변수를 넘김
        // RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        // requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
