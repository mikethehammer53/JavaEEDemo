package dbProcess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classes.User;
import connect.DBCon;

public class UserCheck {

	public  boolean existcheck(String name) {
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
	
	public  boolean pwdcheck(String name,String password) {
		boolean flag=false;
		String pwd="";
		//List<Emp> list=new ArrayList<Emp>();
		String sql="";
		StringBuffer buffer=new StringBuffer();
		buffer.append("select password from users where name='");
		buffer.append(name);
		buffer.append("'");
		sql=buffer.toString();
		Connection con=null;
		try{
			con=DBCon.getConnection();
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			if(rs.next()){
				User user=new User();
				user.setPassword(rs.getString("password"));
				pwd=user.getPassword();
				if(pwd.equals(password)){
					return true;
				}
				else{
					return false;
				}
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
