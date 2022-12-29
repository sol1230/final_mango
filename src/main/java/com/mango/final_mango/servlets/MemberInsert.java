package com.mango.final_mango.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



public class MemberInsert extends HttpServlet {
    private static final long serialVersionUID = 1L;
 

    public MemberInsert() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1) 인코딩 작업  (post 방식이고 한글값 넘어올때)
        request.setCharacterEncoding("UTF-8");

        // 2) 요청시 전달값 뽑아서 변수 및 객체에 기록
        String USER_ID = request.getParameter("USER_ID");
        String PASSWORD = request.getParameter("PASSWORD");
        String NAME = request.getParameter("NAME");
        String PHONE = request.getParameter("PHONE");
        String BIRTH_DATE = request.getParameter("BIRTH_DATE");

        Member m = new Member(USER_ID, PASSWORD, NAME, PHONE, BIRTH_DATE);

        int result = new MemberService().insertMember(m);

        // 4) 처리 결과를 가지고 사용자가 보게될 응답뷰 지정 후 포워딩 또는 url재요청
		if(result > 0) {
			
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원가입이 되었습니다.");
			
			// 성공 => /jsp url재요청 => index페이지
			response.sendRedirect(request.getContextPath());
			
		}else {
			// 실패 => 에러문구가 보여지는 에러페이지
			request.setAttribute("errorMsg", "회원가입 실패했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
    }
    
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
                doGet(request, response);
    
    }

}
