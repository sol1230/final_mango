package com.mango.final_mango.servlets;

import com.mango.final_mango.dao.SurveyResultWithDB;
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

@WebServlet(urlPatterns = "/survey/UserResult")
public class test_surveyresult extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    // String user_id = request.getParameter("user_id");
    String user_id = "U1";

    SurveyResultWithDB surveyResultWithDB = new SurveyResultWithDB();

    ArrayList<HashMap> question_list = null;
    ArrayList<HashMap> answers_list = null;
    HashMap<String, Object> userName = null;

    try {
      question_list = surveyResultWithDB.getQuestion();
      answers_list = surveyResultWithDB.getAnswer(user_id);
      userName = surveyResultWithDB.getUserName(user_id);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    String msg = "설문을 제출해주세요.";

    // output with html
    if (answers_list.size() != 0) {
      request.setAttribute("question_list", question_list);
      request.setAttribute("answers_list", answers_list);
      request.setAttribute("user_id", user_id);
      request.setAttribute("userName", userName);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher(
        "/jsp/survey_result.jsp"
      );
      requestDispatcher.forward(request, response);
    } else {
      request.setAttribute("msg", msg);
      // RequestDispatcher requestDispatcher = request.getRequestDispatcher("survey_result.jsp");
      // requestDispatcher.forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    this.doGet(req, resp);
  }
}
