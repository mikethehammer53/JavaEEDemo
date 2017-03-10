package dbProcess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes.Emp;
import connect.DBCon;

public class EmpDao {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入姓名");
		String name=input.nextLine();		
		List<Emp> list=new ArrayList<Emp>();
		String sql="";
		StringBuffer buffer=new StringBuffer();
		buffer.append("select * from emp where ename='");
		buffer.append(name);
		buffer.append("'");
		sql=buffer.toString();
		Connection con=null;
		try{
			con=DBCon.getConnection();
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			while(rs.next()){
				Emp emp=new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				//emp.setDepno(rs.getInt("deptno"));
				list.add(emp);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			list=null;
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
		//return list;
	}
}
