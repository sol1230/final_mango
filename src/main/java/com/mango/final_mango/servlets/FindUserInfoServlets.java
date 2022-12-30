package com.mango.final_mango.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import com.mango.final_mango.dao.LoginWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// /login/loginServlets?user_id=U1&password=1234
@WebServlet(urlPatterns = "/find/findUserInfoServlets")
public class FindUserInfoServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 한글 처리
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter printWriter = response.getWriter();

        // input type
        String find_id = request.getParameter("find_id");
        String phone0 = request.getParameter("phone0");
        String phone1 = request.getParameter("phone1");
        String phone2 = request.getParameter("phone2");
        String id = request.getParameter("id");
        String find_name = request.getParameter("find_name");

        // DB 불러오기
        LoginWithDB loginWithDB = new LoginWithDB();
        HashMap<String, Object> findID = null;
        HashMap<String, Object> findPassword = null;
        HashMap<String, Object> findID_name = null;
        try {
            findID = loginWithDB.findID(find_id, phone0, phone1, phone2);
            findPassword = loginWithDB.findPassword(id, find_name);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String msg;
        // 정보가 있으면 
        if(findID != null){
            request.setAttribute("findID", findID);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/findUserResult.jsp");
            requestDispatcher.forward(request, response);
        } else if(findPassword != null){
            request.setAttribute("findPassword", findPassword);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/findUserResult.jsp");
            requestDispatcher.forward(request, response);
        } else {
            // msg로 찾기 실패 보여주기(비밀번호 찾기 위치와 맞추기 위해 alert)
            // msg = "정보가 존재하지 않습니다.";
            // request.setAttribute("msg", msg);
            // RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/find_users.jsp");
            // requestDispatcher.forward(request, response);
            printWriter.println("<script type='text/javascript'>");
            printWriter.println("alert('정보가 존재하지 않습니다.')");
            // 전 페이지로 돌아가게 해주는
            printWriter.println("history.back();");
            printWriter.println("</script>");
            printWriter.flush();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
