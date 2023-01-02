package com.mango.final_mango.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.mango.final_mango.dao.LoginWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
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
        String checkbox = request.getParameter("checkbox");

        System.out.println(checkbox);
        System.out.println(user_id);
        System.out.println(password);

        // DB 불러오기
        LoginWithDB loginWithDB = new LoginWithDB();

        // Session
        HttpSession httpSession = null;
        
        String msg;
        String path = null;
        try {
            if(loginWithDB.checkLoginDB(user_id, password)){            
                httpSession = request.getSession(false);
                if(httpSession == null){
                    // 세션 저장
                    httpSession = request.getSession();
                    httpSession.setAttribute("user_id", user_id);
                    httpSession.setAttribute("password", password);
                } else {
                    // else인 경우도 추가해주기
                    httpSession = request.getSession();
                    httpSession.setAttribute("user_id", user_id);
                    httpSession.setAttribute("password", password);
                }
                path = "/jsp/a_main.jsp";

            }else{
                if(httpSession == null){
                    // msg로 로그인 실패 띄우기(설문시작 버튼 누르면 msg도 같이 나옴..)
                    // httpSession = request.getSession();
                    // msg = "로그인 정보가 일치하지 않습니다.";
                    // httpSession.setAttribute("msg", msg);
                    
                    // alert창으로 띄우기(jsp에서는 어떻게?-->msg)
                    printWriter.println("<script>alert('로그인 정보가 일치하지 않습니다.'); history.back();</script>");
                    // 전 페이지로 돌아가게 해주는 (아이디 저장 체크 작동 의미 없음)
                    printWriter.flush();
                }
                // path = "/jsp/login.jsp";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
