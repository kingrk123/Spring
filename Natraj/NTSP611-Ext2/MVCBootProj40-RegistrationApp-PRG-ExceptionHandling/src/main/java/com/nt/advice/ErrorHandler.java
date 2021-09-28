package com.nt.advice;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(DataAccessException.class)
	public  String  handleDBProblems() {
		return "show_sql_problem";
	}
	
	@ExceptionHandler(Exception.class)
	public  String  handleAllProblems() {
		return "show_problem";
	}

}
