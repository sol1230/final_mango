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

@WebServlet(urlPatterns = "/result/statistics2Servlets")
public class Statistics2Servlet extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    //DB
    SurveyResultWithDB surveyResultWithDB = new SurveyResultWithDB();

    ArrayList<HashMap> question_list = null;
    HashMap<String, Object> question = null;
    ArrayList<HashMap> statistics_list = null;
    HashMap<String, Object> statistics = null;

    try {
      question_list = surveyResultWithDB.getQuestion();
      statistics_list = surveyResultWithDB.getStatistics2();

      // 확인용
      for (int j = 0; j < question_list.size(); j++) {
        question = question_list.get(j);
        System.out.println(question.get("QUESTION_LIST"));

        for (int i = 0; i < statistics_list.size(); i++) {
          statistics = statistics_list.get(i);
          System.out.println(statistics.get("ANSWER_LIST"));
          System.out.println(statistics.get("nums"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    request.setAttribute("statistics_list", statistics_list);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher(
      "/jsp/statistics_2.jsp"
    );
    requestDispatcher.forward(request, response);
  }
}