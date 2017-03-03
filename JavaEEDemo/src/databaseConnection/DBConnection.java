package databaseConnection;

import java.sql.Connection;
import java.sql.SQLException;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnection {
	private final static String DRIVER="oracle.jdbc.OracleDriver";
	private final static String URL="jdbc:oracle:thin:@localhost:1521:ORCL";
	private final static String USER="scott";
	private final static String PWD="123456";
	private final static ComboPooledDataSource CDS=new ComboPooledDataSource();
	private static ThreadLocal<Connection> local=new ThreadLocal<Connection>();
	static{
		try{
			CDS.setDriverClass(DRIVER);
			CDS.setUser(USER);
			CDS.setJdbcUrl(URL);
			CDS.setPassword(PWD);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}
	private DBConnection(){
		
	}
	public static Connection getConnection(){
		if(local.get()==null){
			try{
				local.set(CDS.getConnection());
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return local.get();
	}


}
