<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${param.department}</title>

    <style>
        table {
            border-collapse: collapse;
            text-align: center;
            border: none;
        }

        .title {
            background-color: black; 
            color: white;
        }
        .bg {
            background-color: rgba(0, 0, 0, 0.2);
        }
        .content > td:nth-child(5) {
            text-align: left;
        }
        

    </style>
</head>
<body>
	<h1>[${department}] 학과 검색 결과</h1>
    <table>
    	<thead>
	        <tr class="title">
	            <th>순서</th>
	            <th>학번</th>
	            <th>이름</th>
	            <th>학과</th>
	            <th>주소</th>
	        </tr>
    	</thead>
    	<tbody>
        <c:forEach var="student" items="${stdList}" varStatus="vs">
            <c:choose>
                <c:when test="${vs.count % 2 == 0}">
                    <tr class="bg content">            
                        <td>${vs.count}</td>
                        <td>${student.studentNo}</td>
                        <td>${student.studentName}</td>
                        <td>${student.departmentName}</td>
                        <td>${student.studentAddress}</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr class="content">            
                        <td>${vs.count}</td>
                        <td>${student.studentNo}</td>
                        <td>${student.studentName}</td>
                        <td>${student.departmentName}</td>
                        <td>${student.studentAddress}</td>
                    </tr>
                </c:otherwise>
	        </c:choose>
          </c:forEach>
    	</tbody>
            
    </table>
</body>
</html>