package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/////////////// Connection & Close & Commit & rollback �� ������ ������ �� �ְ� �س���.

public class JDBCTemplate {
	//������ ���·� �������ְڴ�.
	public static Connection getConnection()  {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
		//��ġ�� ����Ŭ ����̹� Ŭ������ �������Ѽ� driver.getconnection�� �긦 ����̹��� �ν��ϰ� ����°�.
		//=>�ڹٿ� ��� ���� ����!

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "big5";
		String pwd = "admin1234";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, id, pwd);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			} 
		return conn ;	
	}
	
	//���� ���¸� close()�ϰڴ�.
	public static void Close(Connection conn) {
		try {
			if(!conn.isClosed() && conn != null) {
			conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Close(Statement stmt) {
		try {
			if(stmt != null) {
			stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Close(ResultSet rs) {
		try {
			if(rs != null) {
			rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
			conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void Rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
			conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
