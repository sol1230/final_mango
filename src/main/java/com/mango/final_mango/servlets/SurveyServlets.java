package com.mango.final_mango.servlets;

import com.mango.final_mango.dao.SurveyWithDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(urlPatterns = "/survey/surveyServelts")
public class SurveyServlets extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    // DB 불러오기
    SurveyWithDB surveyWithDB = new SurveyWithDB();

    ArrayList<HashMap> question_list = null;
    HashMap<String, Object> question = null;
    ArrayList<HashMap> answers_list = null;
    HashMap<String, Object> answers = null;

    try {
      question_list = surveyWithDB.getQuestion();
      answers_list = surveyWithDB.getAnswer();
      // 질문 출력 확인용
      for (int i = 0; i < question_list.size(); i++) {
        question = question_list.get(i);
        System.out.println(question.get("QUESTION_LIST"));
        for (int j = 0; j < answers_list.size(); j++) {
          answers = answers_list.get(j);
          System.out.println(answers.get("ANSWER_LIST"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    request.setAttribute("question_list", question_list);
    request.setAttribute("answers_list", answers_list);
    // jsp로 작동하도록 방향 트는 url 인스턴스화(=printWriter 대체용)
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(
      "/jsp/survey.jsp"
    );
    // forward하면서 request, response 모두 넘겨주는
    requestDispatcher.forward(request, response);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.doGet(req, resp);
  }
}
