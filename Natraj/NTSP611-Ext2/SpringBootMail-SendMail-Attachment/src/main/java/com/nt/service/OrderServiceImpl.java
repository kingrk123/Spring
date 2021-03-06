package com.nt.service;

import java.util.Arrays;
import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private JavaMailSender sender;

	@Override
	public String generateBill(String[] items, float[] prices,String customerEmail) {
		float billAmt=0.0f;
		String msg=null;
		for(float price:prices) {
			billAmt=billAmt+price;
		}
		msg=Arrays.deepToString(items)+" having Prices"+Arrays.toString(prices)+" bill Amount ::"+billAmt;
		triggerMail(msg,"billDetails with Greeting Card",customerEmail);
		return msg;
	}
	
	private void   triggerMail(String body,String subject,String toAddrs) {
		 MimeMessage  message=null;
			MimeMessageHelper helper=null;
			try {
			message=sender.createMimeMessage();
			helper=new MimeMessageHelper(message,true);
			helper.setTo(toAddrs);
			helper.setSentDate(new Date());
			helper.setSubject(subject);
			helper.setText(body );
			helper.addAttachment("logo.png",new ClassPathResource("realheart.jpg"));
			sender.send(message);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}//triggerMail
}//class
