<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>statistics_2</title>
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
          <div class="col mt-5 mb-5">
            <table class="table text-center" style="width: 90%">
              <thead>
                <tr class="table-success opacity-75">
                  <th>설문 번호</th>

                  <th colspan="5">답항</th>
                </tr>
              </thead>
              <tbody>
                <tr class="table-light">
                  <th rowspan="3" class="">1</th>
                  <th colspan="5">반려동물에 관심이 있나요?</th>
                </tr>
                <tr>
                  <td>(1) 매우 그렇다</td>
                  <td>(2) 그렇다</td>
                  <td>(3) 그렇지 않다</td>
                  <td>(4) 전혀 그렇지 않다</td>
                </tr>
                <tr>
                  <td>5</td>
                  <td>10</td>
                  <td>2</td>
                  <td>3</td>
                </tr>
                <tr class="table-light">
                  <th rowspan="3" class="">2</th>

                  <th colspan="4">반려동물을 키울 생각이 있나요?</th>
                </tr>
                <tr>
                  <td>(1) 매우 그렇다</td>
                  <td>(2) 그렇다</td>
                  <td>(3) 그렇지 않다</td>
                  <td>(4) 전혀 그렇지 않다</td>
                </tr>
                <tr>
                  <td>8</td>
                  <td>7</td>
                  <td>3</td>
                  <td>2</td>
                </tr>
                <tr class="table-light">
                  <th rowspan="3" class="">3</th>

                  <th colspan="4">유기동물을 입양할 생각이 있나요?</th>
                </tr>
                <tr>
                  <td>(1) 매우 그렇다</td>
                  <td>(2) 그렇다</td>
                  <td>(3) 그렇지 않다</td>
                  <td>(4) 전혀 그렇지 않다</td>
                </tr>
                <tr>
                  <td>4</td>
                  <td>7</td>
                  <td>4</td>
                  <td>5</td>
                </tr>
                <tr class="table-light">
                  <th rowspan="3" class="">4</th>

                  <th colspan="4">반려동물을 키울 환경이 준비되어 있나요?</th>
                </tr>
                <tr>
                  <td>(1) 매우 그렇다</td>
                  <td>(2) 그렇다</td>
                  <td>(3) 그렇지 않다</td>
                  <td>(4) 전혀 그렇지 않다</td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>3</td>
                  <td>6</td>
                  <td>9</td>
                </tr>
                <tr class="table-light">
                  <th rowspan="3" class="">5</th>

                  <th colspan="4">
                    반려동물이 삶의 만족도에 영향을 준다고 생각하시나요?
                  </th>
                </tr>
                <tr>
                  <td>(1) 매우 그렇다</td>
                  <td>(2) 그렇다</td>
                  <td>(3) 그렇지 않다</td>
                  <td>(4) 전혀 그렇지 않다</td>
                </tr>
                <tr>
                  <td>4</td>
                  <td>8</td>
                  <td>3</td>
                  <td>5</td>
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
