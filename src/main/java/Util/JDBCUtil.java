package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection()
	{
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3306/n18_webqldetainckh?useUnicode=yes&characterEncoding=UTF-8";
			String username = "root";
			String password = "duyna2101";
			
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Successfully!");
		}
		catch (SQLException e){
			System.out.print("Connection error...");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection cnn)
	{
		try {
			if (cnn!=null)
			{
				cnn.close();
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
