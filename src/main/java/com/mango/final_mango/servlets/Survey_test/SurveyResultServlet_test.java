package com.mango.final_mango.servlets.Survey_test;

import com.mango.final_mango.dao.SurveyResultWithDB;
import com.mango.final_mango.dao.SurveyWithDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(urlPatterns = "/survey/surveyResultServletsTest")
public class SurveyResultServlet_test extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    // 라디오 체크한 데이터 값 가져오기
    String Q1 = request.getParameter("Q1");
    String Q2 = request.getParameter("Q2");
    String Q3 = request.getParameter("Q3");
    String Q4 = request.getParameter("Q4");
    String Q5 = request.getParameter("Q5");

    // 세션 아이디 가져오기
    HttpSession httpSession = request.getSession();
    String user_id = (String) httpSession.getAttribute("user_id");
    
    //DB
    SurveyResultWithDB surveyResultWithDB = new SurveyResultWithDB();

    PrintWriter printWriter = response.getWriter();

    ArrayList<HashMap> question_list = null;
    ArrayList<HashMap> answers_list = null;
    String userName = null;

    // user_id 넣기
    // HttpSession httpSession = request.getSession(false);

    // String user_id = "U1";
    // user_id = (String) httpSession.getAttribute("user_id");

    // 설문 완료했는지 check
    try {
      boolean checkSurvey = surveyResultWithDB.checkUser(user_id);
      if (checkSurvey == true) { // 설문 완료시
        question_list = surveyResultWithDB.getQuestion();
        answers_list = surveyResultWithDB.getAnswer(user_id);
        userName = surveyResultWithDB.getUserName(user_id);

        request.setAttribute("question_list", question_list);
        request.setAttribute("answers_list", answers_list);
        request.setAttribute("user_id", user_id);
        request.setAttribute("userName", userName);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(
          "/jsp/survey_result.jsp"
        );
        requestDispatcher.forward(request, response);
      } else { // survey 미완료 시
        System.out.println("실패");
        if(Q1!=null){
            question_list = surveyResultWithDB.getQuestion();
            userName = surveyResultWithDB.getUserName(user_id);
            surveyResultWithDB.insertAnswer(user_id, Q1, Q2, Q3, Q4, Q5);
            answers_list = surveyResultWithDB.getAnswer(user_id);

            request.setAttribute("question_list", question_list);
            request.setAttribute("answers_list", answers_list);
            request.setAttribute("user_id", user_id);
            request.setAttribute("userName", userName);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/survey_result.jsp");
              requestDispatcher.forward(request, response);
        } else {
            printWriter.println("<script>alert('설문을 제출해주세요.'); history.back();</script>");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doGet(req, resp);
  }
}
