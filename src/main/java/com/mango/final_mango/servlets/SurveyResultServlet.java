package com.mango.final_mango.servlets;

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

@WebServlet(urlPatterns = "/survey/surveyResultServlets")
public class SurveyResultServlet extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    //DB
    SurveyResultWithDB surveyResultWithDB = new SurveyResultWithDB();
    SurveyWithDB surveyWithDB = new SurveyWithDB();

    PrintWriter printWriter = response.getWriter();

    ArrayList<HashMap> question_list = null;
    HashMap<String, Object> question = null;
    ArrayList<HashMap> answers_list = null;
    HashMap<String, Object> answers = null;

    // user_id 넣기
    HttpSession httpSession = request.getSession(false);

    String user_id = "U1";
    user_id = (String) httpSession.getAttribute("user_id");

    try {
      boolean checkSurvey = surveyResultWithDB.checkUser(user_id);
      String userName = surveyResultWithDB.getUserName(user_id);
      if (checkSurvey) { // 설문 완료시
        question_list = surveyWithDB.getQuestion();
        answers_list = surveyWithDB.getAnswer();

        //출력 확인
        for (int i = 0; i < question_list.size(); i++) {
          question = question_list.get(i);
          System.out.println(question.get("QUESTION_LIST"));
          for (int j = 0; j < answers_list.size(); j++) {
            answers = answers_list.get(j);
            System.out.println(answers.get("ANSWER_LIST"));
          }
        }

        request.setAttribute("question_list", question_list);
        request.setAttribute("answers_list", answers_list);
        request.setAttribute("user_id", user_id);
        request.setAttribute("userName", userName);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(
          "/jsp/survey_result.jsp"
        );
        requestDispatcher.forward(request, response);
      } else { // survey 미완료 시
        printWriter.println(
          "<script>alert('설문을 제출해주세요.'); history.back();</script>"
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
