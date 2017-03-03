package databaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public class PageDBConnectionTest {

	public static void main(String[] args) throws SQLException {
		Connection conn=DBConnection.getConnection();
		int curpage=3;
		int pagesize=5;
		Object[] obj=new Object[2];
		obj[0]=(curpage-1)*pagesize;
		obj[1]=(curpage*pagesize);
		QueryRunner runner=new QueryRunner(true);
		//String sql="select * from(select emp.*,rownum rn from emp)"+
		//		" abc where abc.rn>? and abc.rn<=?";
		String sql="select * from (select ROWNUM rn,emp.* FROM emp) WHERE rn>=? and rn<=?";
	
		conn.setAutoCommit(false);
		List<EMP> empl=runner.query(conn, sql,new ResultSetHandler<List<EMP>>(){
			@Override
			public List<EMP> handle(ResultSet rs) throws SQLException{
				List<EMP> emps=new ArrayList<EMP>();
				while(rs.next()){
					EMP emp=new EMP();
					emp.setEmpno(rs.getInt("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString(rs.getString("job")));
					emps.add(emp);
				}
				return emps;
			}
		},obj);
		conn.commit();
		for(EMP emp:empl){
			System.out.println(emp.getEmpno()+"\t"+emp.getEname()+"\t"+emp.getJob());
		}
		
	}

}
