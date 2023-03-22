package edu.kh.jsp.student.model.service;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.vo.Student;

public class StudentService{
	
	private StudentDAO dao = new StudentDAO();

	public List<Student> selectAll() throws Exception{
		// Connection 생성
		Connection conn = getConnection();
		
		// DAO 메서드 호출 후 결과 반환 받기
		List<Student> stdList = dao.selectAll(conn);
		
		// 트랜잭션 처리(DML인 경우에만 진행)
		
		// Conncetion 객체 반환
		close(conn);
		
		return stdList;
	}

	/** 특정 학과 검색
	 * @param departmentName 
	 * @return
	 */
	public List<Student> selectDepartment(String department) throws Exception{
		Connection conn = getConnection();
		
		List<Student> stdList = dao.selectDepartment(conn, department);
		
		close(conn);
		
		return stdList;
	}

}
