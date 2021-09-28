package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;

public class BooksItemProcessor implements ItemProcessor<String, String> {

	@Override
	public String process(String item) throws Exception {
		System.out.println("BooksItemProcessor.process(-)");
		
		if(item.equalsIgnoreCase("CRJ"))
			return  item+" by HS";
		else if(item.equalsIgnoreCase("TIJ"))
			  return item+"by BE";
		else if(item.equalsIgnoreCase("EJ"))
			   return item+" by JB";
		else if(item.equalsIgnoreCase("ESJ"))
			   return item+" by Xyz";
		else
			 return item+" by unknown";
		
	}

}
