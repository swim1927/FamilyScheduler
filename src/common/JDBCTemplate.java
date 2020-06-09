package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/////////////// Connection & Close & Commit & rollback 를 유저가 제어할 수 있게 해놓음.

public class JDBCTemplate {
	//연결한 상태로 리턴해주겠다.
	public static Connection getConnection()  {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
		//설치된 오라클 드라이버 클래스를 참조시켜서 driver.getconnection이 얘를 드라이버로 인식하게 만드는것.
		//=>자바와 디비 연결 성공!

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
	
	//연결 상태를 close()하겠다.
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
