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

@WebServlet(urlPatterns = "/admin/userManagementServlet")
public class AdminUserManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("user_id");
        // 회원 삭제용 name
        String name = request.getParameter("name");
        // 회원 수정용 회원정보 가져오기
        String modify_name = request.getParameter("user_name");
        String birth_date = request.getParameter("birth_date");
        String phone = request.getParameter("phone");

        UserWithDB userWithDB = new UserWithDB();

        ArrayList<HashMap> question_list = null;
        ArrayList<HashMap> surveyor_answerList = null;
        HashMap<String, Object> userWithUid = null;

        try {
            question_list = userWithDB.getQuestion();
            surveyor_answerList = userWithDB.getSurveyorAnswer(user_id);
            userWithUid = userWithDB.getUserWithUid(user_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String msg = "설문을 제출하지 않은 회원입니다.";

        // output with html
        // jsp 입장에서 데이터 받는, 서블릿에서 데이터 넘겨주는
        if("delete".equals(name)){
            // admin이 선택한 회원 삭제
            userWithDB.deleteUserInfo(user_id);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/userList");
            requestDispatcher.forward(request, response);
        } else if("modify".equals(name)){
            request.setAttribute("user_id", user_id);
            request.setAttribute("modify_name", modify_name);
            request.setAttribute("birth_date", birth_date);
            request.setAttribute("phone", phone);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/admin_userInfoModify.jsp");
            requestDispatcher.forward(request, response);
        } else {
            // admin이 회원의 설문 완료 결과 user_id를 통해 보기
            if(surveyor_answerList.size() != 0){
                request.setAttribute("question_list", question_list);
                request.setAttribute("surveyor_answerList", surveyor_answerList);
                request.setAttribute("user_id", user_id);
                request.setAttribute("userWithUid", userWithUid);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/admin_user_surveyResultCheck.jsp");
                requestDispatcher.forward(request, response);
            } else {
                request.setAttribute("msg", msg);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/admin_user_surveyResultCheck.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
