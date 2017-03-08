package process;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes.Emp;
import connect.DBCon;

public class UserCheck {

	public static boolean check(String name) {
		boolean flag=false;
		//List<Emp> list=new ArrayList<Emp>();
		String sql="";
		StringBuffer buffer=new StringBuffer();
		buffer.append("select * from users where name='");
		buffer.append(name);
		buffer.append("'");
		sql=buffer.toString();
		Connection con=null;
		try{
			con=DBCon.getConnection();
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			if(rs.next()){
				flag=true;
			}
			else{
				flag=false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			//list=null;
		}
		finally{
			if(con!=null){
				try{
					con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		
		
		return flag;
	}

}
