package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("dfmService")
public class DownloadFilesMgmtServiceImpl implements DownloadFilesMgmtService {

	@Override
	public List<String> getAllFiles(String uploadStore) {
		File fileStore=null;
		File files[]=null;
		List<String> listOfFiles=null;
		//Locate Upload Store using java.io.File class object
		fileStore=new File(uploadStore);
		listOfFiles=new ArrayList();
		if(fileStore.exists()) {
			files=fileStore.listFiles();
			for(File f:files) {
				if(!f.isDirectory()) {
					listOfFiles.add(f.getName());
				}//if
			}//for
		}//if
		return listOfFiles;
	}//method
}//class
