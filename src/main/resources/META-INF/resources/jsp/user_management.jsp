<%@ page contentType="text/html;charset=UTF-8" language="java" %> 
<%@ page import="java.util.HashMap, java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="/css/font.css" />
  </head>
  <body class="bg-light">
    <div class="container pb-5">
      <%@ include file="header.jsp" %>

      <main class="mt-5 p-1">
        <div class="mt-5">
          <form action="/userManagement">
            <select name="keyField" id="">
              <option value="NAME">이름</option>
              <option value="BIRTH_DATE">생년월일</option>
              <option value="PHONE">전화번호</option>
            </select>
            <input type="text" name="keyWord" id="">
            <button type="submit" class="btn btn-success opacity-75">검색</button>
          </form>
          <table class="table text-center mt-5" style="width: 90%">
            <thead>
              <tr class="table-success opacity-75">
                <th>User ID</th>
                <th>이름</th>
                <th>생년월일</th>
                <th>전화번호</th>
                <th>삭제</th>
              </tr>
            </thead>
            <tbody>
                <% 
                    ArrayList<HashMap> user_list = null; 
                    user_list = (ArrayList<HashMap>) request.getAttribute("user_list");
                %>
                <%
                    for(int i = 0; i < user_list.size(); i++){
                        HashMap<String, Object> user = user_list.get(i);
                    
                %>
              <form action="">
                <tr>
                  <td><%= user.get("USER_ID") %></td>
                  <td><%= user.get("NAME") %></td> 
                  <td><%= user.get("BIRTH_DATE") %></td>
                  <td><%= user.get("PHONE") %></td>
                  <td><button class="btn btn-success">삭제</button></td>
                </tr>
              </form>
              <% } %>
            </tbody>
          </table>
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
