<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Survey</title>
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
          <div class="ms-2" style="width: 8rem">
            <a
              href="#modalTarget02"
              class="btn btn-success opacity-75 mb-2 text-middle p-3"
              style="width: 6.5rem; height: 4rem"
              data-bs-toggle="modal"
              >설문 조사</a
            >
            <button
              class="btn btn-success opacity-75"
              style="width: rem; height: 4rem"
              onclick="location.href='./survey_result.html'"
            >
              설문 결과 조회
            </button>
          </div>
          <div class="col d-flex justify-content-center">
            <table class="table text-center table-striped" style="width: 90%">
              <tbody>
                <tr>
                  <th style="width: 7%">설문1</th>
                  <th class="text-center" colspan="4">
                    반려동물에 관심이 있나요?
                  </th>
                </tr>
                <tr>
                  <td>답</td>
                  <td>
                    <input
                      type="radio"
                      name="answer1"
                      value="1"
                      id="answer1_id_1"
                    />
                    <label for="answer1_id_1">(1) 매우 그렇다</label>
                  </td>
                  <td>
                    <input
                      type="radio"
                      name="answer1"
                      value="2"
                      id="answer1_id_2"
                    />
                    <label for="id_2">(2) 그렇다</label>
                  </td>
                  <td>
                    <input
                      type="radio"
                      name="answer1"
                      value="3"
                      id="answer1_id_3"
                    />
                    <label for="answer1_id_3">(3) 그렇지 않다</label>
                  </td>
                  <td>
                    <input
                      type="radio"
                      name="answer1"
                      value="4"
                      id="answer1_id_4"
                    />
                    <label for="answer1_id_4">(4) 전혀 그렇지 않다</label>
                  </td>
                </tr>
                <tr>
                  <th>설문2</th>
                  <th colspan="4">반려동물을 키울 생각이 있나요?</th>
                </tr>
                <tr>
                  <td>답</td>
                  <td>
                    <input
                      type="radio"
                      name="answer2"
                      value="1"
                      id="answer2_id_1"
                    />
                    <label for="answer2_id_1">(1) 매우 그렇다</label>
                  </td>
                  <td>
                    <input
                      type="radio"
                      name="answer2"
                      value="2"
                      id="answer2_id_2"
                    />
                    <label for="answer2_id_2">(2) 그렇다</label>
                  </td>
                  <td>
                    <input
                      type="radio"
                      name="answer2"
                      value="3"
                      id="answer2_id_3"
                    />
                    <label for="answer2_id_3">(3) 그렇지 않다</label>
                  </td>
                  <td>
                    <input
                      type="radio"
                      name="answer2"
                      value="4"
                      id="answer2_id_4"
                    />
                    <label for="answer2_id_4">(4) 전혀 그렇지 않다</label>
                  </td>
                </tr>
                <tr>
                  <th>설문3</th>
                  <th colspan="4">유기동물을 입양할 생각이 있나요?</th>
                </tr>
                <tr>
                  <td>답</td>
                  <td>
                    <input
                      type="radio"
                      name="answer3"
                      value="1"
                      id="answer3_id_1"
                    />
                    <label for="answer3_id_1">(1) 매우 그렇다</label>
                  </td>
                  <td>
                    <input
                      type="radio"
                      name="answer3"
                      value="2"
                      id="answer3_id_2"
                    />
                    <label for="answer3_id_2">(2) 그렇다</label>
                  </td>
                  <td style="width: 30%">
                    <input
                      type="radio"
                      name="answer3"
                      value="3"
                      id="answer3_id_3"
                    />
                    <label for="answer3_id_3">(3) 그렇지 않다</label>
                  </td>
                  <td style="width: 30%">
                    <input
                      type="radio"
                      name="answer3"
                      value="4"
                      id="answer3_id_4"
                    />
                    <label for="answer3_id_4">(4) 전혀 그렇지 않다</label>
                  </td>
                </tr>
                <tr>
                  <th>설문4</th>
                  <th colspan="4">반려동물을 키울 환경이 준비되어 있나요?</th>
                </tr>
                <tr>
                  <td>답</td>

                  <td>
                    <input
                      type="radio"
                      name="answer4"
                      value="1"
                      id="answer4_id_1"
                    />
                    <label for="answer4_id_1">(1) 매우 그렇다</label>
                  </td>
                  <td>
                    <input
                      type="radio"
                      name="answer4"
                      value="2"
                      id="answer4_id_2"
                    />
                    <label for="answer4_id_2">(2) 그렇다</label>
                  </td>
                  <td style="width: 30%">
                    <input
                      type="radio"
                      name="answer4"
                      value="3"
                      id="answer4_id_3"
                    />
                    <label for="answer4_id_3">(3) 그렇지 않다</label>
                  </td>
                  <td style="width: 30%">
                    <input
                      type="radio"
                      name="answer4"
                      value="4"
                      id="answer4_id_4"
                    />
                    <label for="answer4_id_4">(4) 전혀 그렇지 않다</label>
                  </td>
                </tr>
                <tr>
                  <th>설문5</th>
                  <th colspan="4">
                    반려동물이 삶의 만족도에 영향을 준다고 생각하시나요?
                  </th>
                </tr>
                <tr>
                  <td>답</td>

                  <td>
                    <input
                      type="radio"
                      name="answer5"
                      value="1"
                      id="answer5_id_1"
                    />
                    <label for="answer5_id_1">(1) 매우 그렇다</label>
                  </td>
                  <td>
                    <input
                      type="radio"
                      name="answer5"
                      value="2"
                      id="answer5_id_2"
                    />
                    <label for="answer5_id_2">(2) 그렇다</label>
                  </td>
                  <td style="width: 30%">
                    <input
                      type="radio"
                      name="answer5"
                      value="3"
                      id="answer5_id_3"
                    />
                    <label for="answer5_id_3">(3) 그렇지 않다</label>
                  </td>
                  <td style="width: 30%">
                    <input
                      type="radio"
                      name="answer5"
                      value="4"
                      id="answer5_id_4"
                    />
                    <label for="answer5_id_4">(4) 전혀 그렇지 않다</label>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="ms-5 d-flex justify-content-center">
            <button
              type="submit"
              class="btn btn-success opacity-75"
              onclick="location.href='./survey_result.html'"
            >
              설문 제출
            </button>
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
