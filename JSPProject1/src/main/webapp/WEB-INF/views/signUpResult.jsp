<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String userName = request.getParameter("userName");
	String email = request.getParameter("email");
	String[] hobby = request.getParameterValues("hobby");
	String re = (String)request.getAttribute("re");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 가입 결과</title>
</head>
<body>

    <ul>
        <li>아이디 : <%= userId %></li>
        <li>비밀번호 : <%= userPw %></li>
        <li>이름 : <%= userName %></li>
        <li>이메일 : <%= email %></li>
        <li>취미 : <% for(String h : hobby) { %>
        			<%= h %>
        			<% } %>
        </li>
    </ul>
	<h2><%= re %></h2>
    
</body>
</html>