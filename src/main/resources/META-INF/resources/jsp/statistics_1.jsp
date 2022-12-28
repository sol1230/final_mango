<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>statistics_1</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="../../../static/css/font.css" />
  </head>
  <body class="bg-light">
    <div class="container pb-5">
      <%@ include file="header.jsp" %>

      <main class="mt-5 p-1">
        <div class="row" style="margin-top: 8%">
          <div class="ms-2 me-5" style="width: 8rem">
            <button
              class="btn btn-success opacity-75 mb-2"
              style="width: 6.5rem; height: 4rem"
              onclick="location.href='./statistics_1.html'"
            >
              설문자별 답변 결과
            </button>
            <button
              class="btn btn-success opacity-75"
              style="width: rem; height: 4rem"
              onclick="location.href='./statistics_2.html'"
            >
              질문별 총 답변수
            </button>
          </div>
          <div class="col mt-5">
            <table class="table text-center" style="width: 90%">
              <thead>
                <tr class="table-success opacity-75">
                  <th>설문자 명</th>
                  <th>설문 문항 1</th>
                  <th>설문 문항 2</th>
                  <th>설문 문항 3</th>
                  <th>설문 문항 4</th>
                  <th>설문 문항 5</th>
                </tr>
              </thead>
              <tbody>
                <tr class="table-light">
                  <td>유재석</td>
                  <td>(3) 그렇지 않다</td>
                  <td>(2) 그렇다</td>
                  <td>(4) 전혀 그렇지 않다</td>
                  <td>(1) 매우 그렇다</td>
                  <td>(3) 그렇지 않다</td>
                </tr>
                <tr>
                  <td>김종국</td>
                  <td>(1) 매우 그렇다</td>
                  <td>(2) 그렇다</td>
                  <td>(3) 그렇지 않다</td>
                  <td>(4) 전혀 그렇지 않다</td>
                  <td>(1) 매우 그렇다</td>
                </tr>
                <tr class="table-light">
                  <td>손예진</td>
                  <td>(2) 그렇다</td>
                  <td>(1) 매우 그렇다</td>
                  <td>(4) 전혀 그렇지 않다</td>
                  <td>(3) 그렇지 않다</td>
                  <td>(2) 그렇다</td>
                </tr>
                <tr>
                  <td>KH</td>
                  <td>(4) 전혀 그렇지 않다</td>
                  <td>(3) 그렇지 않다</td>
                  <td>(1) 매우 그렇다</td>
                  <td>(2) 그렇다</td>
                  <td>(4) 전혀 그렇지 않다</td>
                </tr>
              </tbody>
            </table>
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
