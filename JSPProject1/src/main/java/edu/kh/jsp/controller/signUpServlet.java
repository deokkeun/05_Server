package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/signUp")
public class signUpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String userPw = req.getParameter("userPw");
		String userPw2 = req.getParameter("userPw2");
		String userName = req.getParameter("userName");

		
		String result = "";
		if(userPw.equals(userPw2)) {
			result = userName + "의 회원가입이 완료되었습니다.";
		} else {
			result = "비밀번호가 일치하지 않습니다!";
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUpResult.jsp");
		req.setAttribute("re", result);
		dispatcher.forward(req, resp);
	
	}
}
