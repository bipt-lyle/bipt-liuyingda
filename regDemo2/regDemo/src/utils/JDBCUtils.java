package utils;
import java.sql.*;

public class JDBCUtils 
{
	private static String userName = null;
	private static String passWord = null;
	private static String url = null;
	private static String driverName = null;
	private static Connection conn = null;
	private static JDBCUtils instance = null;
	private JDBCUtils() {
		
	}
	
	public static JDBCUtils getInstance() {
		return instance;
	}
	
	
	static {
		driverName = "com.mysql.cj.jdbc.Driver";
		userName = "root";
		url = "jdbc:mysql://127.0.0.1:3306/register?useSSL=false&serverTimezone=UTC";
		passWord = "19990106Aa";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		instance = new JDBCUtils();
	}
	


	public void closeResource(ResultSet rSet, Connection conn, Statement pst) {
		if (rSet != null) {
			try {
				rSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (pst != null) {
					try {
						pst.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}

	}
	
	public Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection(url, userName, passWord);
		return conn;
	}
	
	
	
}
