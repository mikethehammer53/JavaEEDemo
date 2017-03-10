package dbProcess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import classes.Emp;
import connect.DBCon;

public class UpdateSQL {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Emp emp=new Emp();
		System.out.println("请输入员工编号");
		emp.setEmpno(Integer.parseInt(input.nextLine()));
		System.out.println("请输入员工姓名");
		emp.setEname(input.nextLine());
		String sql="update emp set ename=? where empno=?";
		Connection con=DBCon.getConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement pstat=con.prepareStatement(sql);
			pstat.setInt(2, emp.getEmpno());
			pstat.setString(1, emp.getEname());
			int row=pstat.executeUpdate();
			con.commit();
			if(row==1){
				System.out.println("修改成功");
			}
			else{
				System.out.println("修改失败");
			}
			input.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
