package com.jdbc;

import java.sql.*;


public class UpdateClass {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/student_manage";
		String uName = "root";
		String passWord = "";
		String query = "insert into student values (?, ?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(url, uName, passWord);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, 6);
		st.setString(2, "Mahesh");
		int count = st.executeUpdate();
		
		System.out.println(count+"row/s affected");
		st.close();
		con.close();
		
		
		
		
	}
}
