package process;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteSQL {

	public static void main(String[] args) {
		Connection con=null;
		Scanner input=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL",
					"SCOTT","123456");
			con.setAutoCommit(false);
			String sql="delete emp where empno=?";
			PreparedStatement pstat=con.prepareStatement(sql);
			System.out.println("请输入需要删除的员工编号");
			pstat.setInt(1, input.nextInt());
			int row=pstat.executeUpdate();
			if(row==1){
				System.out.println("删除成功");
			}
			else{
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			try {
				con.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			if(con!=null){
				try {
					con.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
