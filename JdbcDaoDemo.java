package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcDaoDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentDao dao = new StudentDao();
		Student s1 = dao.getStudent(5);
		System.out.println(s1.sname);
		
	}
}

class StudentDao{
	public Student getStudent(int rollno) throws ClassNotFoundException, SQLException {
		Student s = new Student();
		s.rollno = rollno;
		
		String url = "jdbc:mysql://localhost/student_manage";
		String uName = "root";
		String passWord = "";
		String query = "select sName from studentnew where rollNo="+rollno;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uName, passWord);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name = rs.getString(1);
		s.sname = name;
		
		
		return s;
	}
}

class Student{
	int rollno;
	String sname;
}