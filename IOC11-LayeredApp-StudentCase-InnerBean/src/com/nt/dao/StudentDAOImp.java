package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImp implements StudentDAO {
	private static final String INSERT_STUDENT_QUERY = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";
	
	private DataSource ds;
	public StudentDAOImp(DataSource ds) {
		System.out.println("StudentDAOImp.StudentDAOImp()");
		this.ds=ds;
	}

	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con =null;
		PreparedStatement ps =null;
		System.out.println(bo);
		int count = 0;
		//get pooled obj Jdbc obj from jdbc con pool
		con =ds.getConnection();
		//create PreparedStatement Object
		ps = con.prepareStatement(INSERT_STUDENT_QUERY);
		//set Values to Query param
		ps.setInt(1,bo.getSno());
		ps.setString(2, bo.getSname());
		ps.setInt(3, bo.getTotal());
		ps.setInt(4, bo.getAvg());
		ps.setString(5, bo.getResult());
		//execute the query
		System.out.println("StudentDAOImp.insert()");
		count = ps.executeUpdate();
		ps.close();
		con.close();
		return count;
	}//method
}//class
