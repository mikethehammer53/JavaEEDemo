package process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import classes.User;
import connect.DBCon;

public class InsertSQL {

	public static void manuallyInsert(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Scanner input=new Scanner(System.in);
		System.out.println("请输用户信息");
		User user=new User();
		System.out.println("请输入用户姓名");
		user.setName(input.nextLine());;
		System.out.println("请输入用户密码");
		user.setPassword(input.nextLine());
		System.out.println("请输入用户邮箱");
		user.setEmail(input.nextLine());
		String sql="insert into users(name,password,email)"
				+ " values (?,?,?)";
		Connection con=DBCon.getConnection();
		try {
			PreparedStatement pstat=con.prepareStatement(sql);
			pstat.setString(1, user.getName());
			pstat.setString(2, user.getPassword());
			pstat.setString(3, user.getEmail());
			int row=pstat.executeUpdate();
			if(row==1){
				System.out.println("插入成功");
			}
			else{
				System.out.println("插入失败");
			}
			con.close();
			input.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int insert(String name,String password,String email){
		int row=0;
		Scanner input=new Scanner(System.in);
		User user=new User();
		user.setName(name);;
		user.setPassword(password);
		user.setEmail(email);
		String sql="insert into users(name,password,email)"
				+ " values (?,?,?)";
		Connection con=DBCon.getConnection();
		try {
			PreparedStatement pstat=con.prepareStatement(sql);
			pstat.setString(1, user.getName());
			pstat.setString(2, user.getPassword());
			pstat.setString(3, user.getEmail());
			row=pstat.executeUpdate();
			if(row==1){
				System.out.println("插入成功");
			}
			else{
				System.out.println("插入失败");
			}
			con.close();
			input.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

}
