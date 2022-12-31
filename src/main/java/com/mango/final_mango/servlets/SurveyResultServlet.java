package com.mango.final_mango.servlets;

import com.mango.final_mango.dao.SurveyResultWithDB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
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
    // HttpSession httpSession = request.getSession();
    //DB
    SurveyResultWithDB surveyResultWithDB = new SurveyResultWithDB();

    ArrayList<HashMap> userSurvey = null;
    ArrayList<HashMap> question_list = null;
    String userName = "";

    try {
      userSurvey = surveyResultWithDB.getmySurvey();
      question_list = surveyResultWithDB.getQuestion();
      userName = surveyResultWithDB.getUserName();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    request.setAttribute("userSurvey", userSurvey);
    request.setAttribute("question_list", question_list);
    request.setAttribute("userName", userName);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher(
      "/jsp/survey_result.jsp"
    );
    // forward하면서 request, response 모두 넘겨주는
    requestDispatcher.forward(request, response);
  }
}
