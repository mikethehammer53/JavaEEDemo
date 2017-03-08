package connect;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	static{
		Properties prop=System.getProperties();
		InputStream is=DBCon.class.getResourceAsStream("jdbc.properties");
		try {
			//prop.load(is);
			DRIVER="oracle.jdbc.driver.OracleDriver";
			URL="jdbc:oracle:thin:@localhost:1521:ORCL";
			USER="SCOTT";
			PASSWORD="123456";
			
			//DRIVER=prop.getProperty("oracle.driver");
			//URL=prop.getProperty("oracle.url");
			//USER=prop.getProperty("oracle.user.scott");
			//PASSWORD=prop.getProperty("oracle.password");
		} 
		
		finally{
			if(is!=null){
				try {
					is.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private DBCon(){
		try {
			Class.forName(DRIVER);
			con=DriverManager.getConnection(URL,USER,"123456");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		new DBCon();
		return con;
	}
	private static Connection con;
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
}

