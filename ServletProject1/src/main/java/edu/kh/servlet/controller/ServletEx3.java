package edu.kh.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/signUp")
public class ServletEx3 extends HttpServlet {
	
	// doPOST() : POST 방식 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//POST 방식은 문자 데이터가 깨질 위험이 있음.
		// 왜? 브라우저, 서버간의 문자 인코딩 차이 때문에!
		
		// 해결 방법 :  요청 정보에 담긴 데이터의 문자 인코딩을 UTF-8로 변경
		req.setCharacterEncoding("UTF-8");
		
		// 파라미터 얻어와 변수에 저장
		String inputId = req.getParameter("inputId");
		String[] inputPw = req.getParameterValues("inputPw");
		String inputEmail = req.getParameter("inputEmail");
		String agree = req.getParameter("agree");
		
		// 응답 데이터 문서 형식, 문자 인코딩 지정
		resp.setContentType("text/html; charset=UTF-8");
	
		// 응답용 스크림 얻어오기
		PrintWriter out = resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head> <title> 회원 가입 결과 </title> </head>");
		out.println("<body>");
		
		if(inputPw[0].equals(inputPw[1])) {
			// 정상 가입한 경우에 대한 화면
			
			// user01님 환영합니다.
			// 이메일 수신 동의 여부 : O / X
			// 동의 O 인 경우 
			// 수신할 이메일 : user01@test.com
			
			out.printf("<h3>%s님 환영합니다.</h3>", inputId);
			
			// checkbox는 별도의 value가 없을 때
			// 체크 X : null
			// 체크 O : "on"
			
			if(agree != null) {
				out.println("<h3>이메일 동의 수신 여부 : O</h3>");
				out.printf("<h3>수신할 이메일 : %s</h3>", inputEmail);
			} else {
				out.println("<h3>이메일 동의 수신 여부 : X</h3>");
			}
		} else {
			out.println("<h1 style='color:red;'>비밀번호가 일치하지 않습니다.</h1>");
		}
		
		
		out.println("</body>");
		out.println("</html>");
	}	
}
