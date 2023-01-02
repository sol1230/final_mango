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

    ArrayList<HashMap> statistics_list = null;
    HashMap<String, Object> statistics = null;

    try {
      statistics_list = surveyResultWithDB.getStatistics2();

      // 확인용
      for (int j = 0; j < statistics_list.size(); j++) {
        statistics = statistics_list.get(j);
        System.out.println(statistics.get("E1"));
        System.out.println(statistics.get("E2"));
        System.out.println(statistics.get("E3"));
        System.out.println(statistics.get("E4"));
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
