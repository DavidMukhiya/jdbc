package com.jdbc;
import java.sql.*;

//1. import
//2. load and register the driver --> com.mysql.jdbc.driver
//3. Create Connection --> Connection
//4. Create a statement --> Statement
//5. execute the query
//6. process the results
//7. close

public class DemoClass {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/student_manage";
		String uname = "root";
		String password = "";
		//String query = "SELECT `userID`, `userName` FROM `student` WHERE userID=3";
		String query = "SELECT `userID`, `userName` FROM `student`";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, password);
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
		
		String name = rs.getString(2);
		String id = rs.getString(1);
		System.out.println("id:"+id+" "+"name:"+name);
		};
		st.close();
		con.close();
		
	}
}
