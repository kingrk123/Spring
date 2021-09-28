package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImp implements StudentDAO {
	private static final String INSERT_STUDENT_QUERY = "INSERT INTO STUDENT1 VALUES(SNO_SEQ1,?,?,?,?)";
	private DataSource ds ;
	public StudentDAOImp(DataSource ds) {
		this.ds=ds;
	}
	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps =null;
		int count=0;
		//connection from pool
		con=ds.getConnection();
		//create JDBC Prepared statement Object
		ps=con.prepareStatement(INSERT_STUDENT_QUERY);
		ps.setString(1, bo.getSname());
		ps.setInt(2, bo.getTotal());
		ps.setInt(3, bo.getAvg());
		ps.setString(4, bo.getResult());
		count =ps.executeUpdate();
		//close
		ps.close();
		con.close();
		return count;	
	}
}
