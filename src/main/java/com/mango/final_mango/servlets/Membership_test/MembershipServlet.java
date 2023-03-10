package com.mango.final_mango.servlets.Membership_test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/join/membershipServlet")
public class MembershipServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 한글 처리
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        
        String user_id = request.getParameter("id-memeber");
        String name = request.getParameter("name-member");
        String birth_date = request.getParameter("birth-member");
        String password = request.getParameter("password-memeber");
        String password_check = request.getParameter("password-check");
        String phone = request.getParameter("phone0") + "-" + request.getParameter("phone1") + "-" + request.getParameter("phone2");

        MembershipWithDB membershipWithDB = new MembershipWithDB();
        MembershipBean membershipBean = new MembershipBean();

        String msg = "비밀번호가 일치하지 않습니다.";

        if(!membershipWithDB.idCheck(user_id)){
            // 이미 만들어진 아이디면
            printWriter.println("<script>alert('이미 사용 중인 아이디입니다.'); history.back();</script>");
        } else {
            if(!password.equals(password_check)){
                request.setAttribute("msg", msg);
                request.setAttribute("password", password);
                request.setAttribute("password_check", password_check);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/signup_form.jsp");
                requestDispatcher.forward(request, response);
            } else {
                membershipBean.setUSER_ID(user_id);
                membershipBean.setNAME(name);
                membershipBean.setBIRTH_DATE(birth_date);
                membershipBean.setPASSWORD(password);
                membershipBean.setPHONE(phone);
                membershipWithDB.insertMember(membershipBean);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/signup_done.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
