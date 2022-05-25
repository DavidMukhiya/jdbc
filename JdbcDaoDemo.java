package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcDaoDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentDao dao = new StudentDao();
		dao.connect();
		Student s1 = dao.getStudent(5);
		System.out.println(s1.sname);
		Student s2 = new Student();
		s2.rollno = 2;
		s2.sname = "Nishant";
		
		dao.addStudent(s2);
		
	}
}

class StudentDao{
	
	Connection con = null;
	
	public void connect() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost/student_manage";
		String uName = "root";
		String passWord = "";
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, uName, passWord);
	}
	public Student getStudent(int rollno) throws ClassNotFoundException, SQLException {
		Student s = new Student();
		s.rollno = rollno;
		
		String query = "select sName from studentnew where rollNo="+rollno;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		String name = rs.getString(1);
		s.sname = name;
		
		
		return s;
	}
	
	public void addStudent(Student s) throws SQLException {
		String query = "insert into studentnew values (?,?)";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, s.rollno);
		pst.setString(2, s.sname);
		pst.executeUpdate();
	}
}

class Student{
	int rollno;
	String sname;
}