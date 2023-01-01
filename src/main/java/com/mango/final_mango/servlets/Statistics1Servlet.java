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

@WebServlet(urlPatterns = "/result/statistics1Servlets")
public class Statistics1Servlet extends HttpServlet {

  @Override
  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");

    // DB
    SurveyResultWithDB surveyResultWithDB = new SurveyResultWithDB();

    ArrayList<HashMap> userName_list = null;
    HashMap<String, Object> userName = null;
    ArrayList<HashMap> statistics1_list = null;
    HashMap<String, Object> statistics1 = null;

    try {
      userName_list = surveyResultWithDB.getSurveyorName();
      statistics1_list = surveyResultWithDB.getStatistics1_2();

      // 확인용
      for (int i = 0; i < userName_list.size(); i++) {
        userName = userName_list.get(i);
        System.out.println(userName.get("NAME"));
        for (int j = 0; j < statistics1_list.size(); j++) {
          statistics1 = statistics1_list.get(j);
          System.out.println(statistics1.get("U1"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    request.setAttribute("userName_list", userName_list);
    request.setAttribute("statistics1_list", statistics1_list);

    RequestDispatcher requestDispatcher = request.getRequestDispatcher(
      "/jsp/statistics_1.jsp"
    );
    requestDispatcher.forward(request, response);
  }
}
