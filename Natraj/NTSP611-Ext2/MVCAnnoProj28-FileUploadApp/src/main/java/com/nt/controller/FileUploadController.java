package com.nt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.FileUploadCommand;

@Controller
public class FileUploadController {
	
	/*@GetMapping("/upload.htm")
	public  String  showForm(@ModelAttribute("uplCmd") FileUploadCommand cmd) {
		return "file_upload_form";
	}*/
	
	@GetMapping("/upload.htm")
	public  String  showForm(Map<String,Object> map) {
		FileUploadCommand cmd=null;
		cmd=new FileUploadCommand();
		map.put("uplCmd",cmd);
		return "file_upload_form";
	}
	
	@PostMapping("/upload.htm")
	public  String  uploadFiles(Map<String,Object> map, HttpServletRequest req,
			                                           @ModelAttribute("uplCmd") FileUploadCommand cmd  )throws Exception{
		ServletContext sc=null;
		String  UPLOAD_PATH=null;
		File file=null;
		String fileName1=null,fileName2=null;
		InputStream is1=null,is2=null;
		OutputStream os1=null,os2=null;
		//read Context Param value for Location to store the files
		sc=req.getServletContext();
		UPLOAD_PATH=sc.getInitParameter("UPLOAD_STORE");
		file=new File(UPLOAD_PATH);
		if(!file.exists())
			   file.mkdir();
		//get Uploaded file names
		fileName1=cmd.getFile1().getOriginalFilename();
		fileName2=cmd.getFile2().getOriginalFilename();
		//create InputStreams representing uploaded files content
		is1=cmd.getFile1().getInputStream();
		is2=cmd.getFile2().getInputStream();
		//create OuputStreams pointing to dest files..
		os1=new FileOutputStream(UPLOAD_PATH+"/"+fileName1);
		os2=new FileOutputStream(UPLOAD_PATH+"/"+fileName2);
		//copy uploaded files content to  Destination files
		IOUtils.copy(is1,os1);
		IOUtils.copy(is2,os2);
		//close streams
		is1.close();
		is2.close();
		os1.close();
		os2.close();
		//keep uploaded file names as model Attributes
		map.put("fileName1",fileName1);
		map.put("fileName2",fileName2);
		//return lvn of result page
		 return "upload_success";
	}

}
