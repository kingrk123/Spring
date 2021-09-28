package com.nt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.command.UserCommand;

@Component("validator")
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(UserCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCommand cmd=null;
		//type casting
		cmd=(UserCommand)target;
		//server side form validation logic(Programatic)
		if(cmd.getUser()==null || cmd.getUser().length()==0 || cmd.getUser().equals("")) {
			errors.rejectValue("user","login.user.required");
		}
		else if(cmd.getUser().length()<4 || cmd.getUser().length()>10) {
			errors.rejectValue("user","login.user.range");
		}
		
		if(cmd.getPwd()==null || cmd.getPwd().length()==0 || cmd.getPwd().equals("")) {
			errors.rejectValue("pwd","login.pwd.required");
		}
		else if(cmd.getPwd().length()<4 ) {
			errors.rejectValue("pwd","login.pwd.minlength");
		}
		
		
		
		
	}

}
