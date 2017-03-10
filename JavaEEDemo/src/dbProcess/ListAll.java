package dbProcess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes.Emp;
import classes.User;
import connect.DBCon;

public class ListAll {

	public static void main(String[] args) {
//		Scanner input=new Scanner(System.in);
//		String name=input.nextLine();		
		List<User> list=new ArrayList<User>();
		String sql="";
		StringBuffer buffer=new StringBuffer();
		buffer.append("select * from users");
//		buffer.append(name);
//		buffer.append("'");
		sql=buffer.toString();
		Connection con=null;
		try{
			con=DBCon.getConnection();
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				User user=new User();
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				list.add(user);
				String pwd=user.getPassword();
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			list=null;
		}
		finally{
			for(User u:list){
				System.out.println(u.toString());
				System.out.println();
			}
			if(con!=null){
				try{
					con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		}
		//return list;
	}
}

