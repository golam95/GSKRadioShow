package com.radio.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	public Connection setConnection(Connection conn1) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
          conn1 = DriverManager.getConnection("jdbc:mysql://localhost/show", "root", "");
         } catch (SQLException e) {
			System.err.println("SQl Exception");
			e.printStackTrace();
        }
       return conn1;

	}

}
