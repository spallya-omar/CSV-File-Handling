package com.spallya.handler;

import java.sql.*;
import java.util.ArrayList;

import com.spallya.model.Flat;

public class JdbcHandler {
	public static Connection getConnection() throws Exception {
		String driver = "your-databse-driver";
		String url = "your-database-url";
		String username = "your-username";
		String password = "your-password";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

	public void csvFileDataInsertionIntoDatabase(ArrayList<Flat> flatsList) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			System.out.println("Connection to database is successfully established.");
			String sql = "insert into property(PR_ID,PR_STREET,PR_CITY,PR_ZIP,PR_STATE,PR_BEDS,PR_BATHS,"
					+ "PR_SQ_FEET,PR_TYPE,PR_LATITUDE,PR_LONGITUDE) values(PR_SEQ.nextval,?,?,?,?,?,?,?" + ",?,?,?)";
			pstmt = conn.prepareStatement(sql);

			for (Flat flatObj : flatsList) {
				pstmt.setString(1, flatObj.getStreet());
				pstmt.setString(2, flatObj.getCity());
				pstmt.setInt(3, flatObj.getZip());
				pstmt.setString(4, flatObj.getState());
				pstmt.setInt(5, flatObj.getBeds());
				pstmt.setInt(6, flatObj.getBaths());
				pstmt.setInt(7, flatObj.getSqFeet());
				pstmt.setString(8, flatObj.getType());
				pstmt.setFloat(9, flatObj.getLatitude());
				pstmt.setFloat(10, flatObj.getLongitude());
				pstmt.executeUpdate();
			}
			System.out.println("Data is successfully added to database.");

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			pstmt.close();
			conn.close();
			System.out.println("Transaction completed successfully and connection is closed. Thank You.");
		}
	}

}
