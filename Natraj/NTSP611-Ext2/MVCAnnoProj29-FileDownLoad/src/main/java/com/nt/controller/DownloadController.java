package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.service.DownloadFilesMgmtService;

@Controller
public class DownloadController {
	@Autowired
	private DownloadFilesMgmtService service;
	
	@RequestMapping("/home.htm")
	public String  showHomePage() {
		return "welcome";
	}
	
	
	@RequestMapping("/list_files.htm")
	public   String listFiles(Map<String,Object> map,HttpServletRequest req) {
		List<String> listOfFiles=null;
		ServletContext sc=null;
		String uploadStore=null;
		//get ServletContext object
		sc=req.getServletContext();
		//read context param value
		uploadStore=sc.getInitParameter("UPLOAD_STORE");
		//use Service
		listOfFiles=service.getAllFiles(uploadStore);
		//keep all files as model attribute
		map.put("filesList",listOfFiles);
		//return lvn
		return "download_files";
		
	}
	
	@RequestMapping("/download.htm")
	public  String downloadFiles(@RequestParam("fname")String fileName,
			                                                  HttpServletRequest req,
			                                                  HttpServletResponse res)throws Exception {
		ServletContext sc=null;
		String uploadStore=null;
		File file=null;
		InputStream is=null;
		OutputStream os=null;
	   //get ServletContext object
		sc=req.getServletContext();
		//get Upload files location
		uploadStore=sc.getInitParameter("UPLOAD_STORE");
		//create File object locating file to be downloaded
		file=new File(uploadStore+"/"+fileName);
		//get the length of the file and make it as leght of response 
		res.setContentLengthLong(file.length());
		//get File MIME type and make it as response MIME file
		res.setContentType(sc.getMimeType(uploadStore+"/"+fileName));
		//create InputStream pointing file
		is=new FileInputStream(file);
		//create Output stream pointing to response object
		os=res.getOutputStream();
		//Give instruction to browser to make the recived output as downloadable file
		res.setHeader("Content-Disposition","attachment;fileName="+fileName);
		//copy content from file to respons object
		IOUtils.copy(is, os);
		//close/flush stream
		is.close();
		os.close();
		return null;
	}

}
