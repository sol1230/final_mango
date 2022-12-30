<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Survey</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="/css/font.css" />
  </head>

  <body class="bg-light">
  <% 
    HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question");
  %>
    <div class="container pb-5">
      <%@ include file="header.jsp" %>

      <main class="mt-5 p-1">
        <div class="row" style="margin-top: 8%">
        <%-- 설문버튼 --%>
          <div class="ms-2" style="width: 8rem">
            <form action="/survey/SurveyServlets">
            <a
              href="#modalTarget02"
              class="btn btn-success opacity-75 mb-2 text-middle p-3"
              style="width: 6.5rem; height: 4rem"
              data-bs-toggle="modal"
              >설문 조사</a
            >
            <a href="/jsp/survey_result.jsp"
              class="btn btn-success opacity-75"
              style="width: rem; height: 4rem"
            >
              설문 결과 조회
            </a>
          </div>

          <%-- survey --%>
          <div class="mt-3">
          <%= question.get("QUESTION_LIST")%>
          </div>
          <div>
             <%
                ArrayList<HashMap> answers =null;
                answers = (ArrayList<HashMap>) request.getAttribute("answers");
              %>
          <% 
              for (int i = 0; i < answers.size(); i++){ 
                 HashMap<String,Object> answers_list = answers.get(i);
          %>
          <div> (<%= i + 1 %>) <%= answers_list.get("ANSWER") %> </div>
          <% } %>
          </div>

          <div class="ms-5 d-flex justify-content-center">
          <a href="/survey/SurveyResultServlet" class="btn btn-success opacity-75">설문 제출</a>
            </form>
          
          </div>
        </div>
      </main>
    </div>
    <hr />
    <%@ include file="footer.jsp" %>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>

</html>
