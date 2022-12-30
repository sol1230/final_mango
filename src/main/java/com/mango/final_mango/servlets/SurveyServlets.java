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

@WebServlet(urlPatterns = "/survey/SurveyServlets")
public class SurveyServlets extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    // input type
    // response.setContentType("text/html;charset=UTF-8");
    String questions_uid = request.getParameter("QUESTION_UID");

    // biz with DB and Class
    SurveyWithDB surveyWithDB = new SurveyWithDB();

    HashMap<String, Object> question = null;
    ArrayList<HashMap> answers = null;

    // display
    try {
      question = surveyWithDB.getQuestion(questions_uid);
      answers = surveyWithDB.getAnswer(questions_uid);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // output with html
    request.setAttribute("question", question);
    request.setAttribute("answers", answers);

    // jsp
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(
      "/jsp/survey.jsp"
    );
    requestDispatcher.forward(request, response);
  }
}
