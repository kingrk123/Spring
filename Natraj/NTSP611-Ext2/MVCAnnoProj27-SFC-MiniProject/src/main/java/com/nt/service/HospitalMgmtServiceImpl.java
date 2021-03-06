package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.bo.PatientDetailsBO;
import com.nt.dao.PatientDAO;
import com.nt.dto.PatientDetailsDTO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class HospitalMgmtServiceImpl implements HospitalMgmtService {
	@Autowired
	private  PatientDAO  dao;

	
	@Override
	public List<PatientDetailsDTO> fetchAllPatients() {
		List<PatientDetailsBO> listBO=null;
		List<PatientDetailsDTO> listDTO=new ArrayList();
		//use DAO
		listBO=dao.getAllPatients();
		//convert listBO to listDTO
		listBO.forEach(bo->{
			PatientDetailsDTO dto=new PatientDetailsDTO();
			BeanUtils.copyProperties(bo,dto);
			dto.setSrNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}

	@Override
	public PatientDetailsDTO fetchPatientById(int id) {
		PatientDetailsDTO dto=null;
		PatientDetailsBO bo=null;
		//use DAO
		bo=dao.getPatientById(id);
		//convert bo to dto
		dto=new PatientDetailsDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}

	@Override
	public String modifyPatientById(PatientDetailsDTO dto) {
		int count=0;
		PatientDetailsBO bo=null;
		//convert dto to bo
		bo=new PatientDetailsBO();
		BeanUtils.copyProperties(dto,bo);
		System.out.println(dto.getPid()+"   "+bo.getPid());
		//use DAO
		count=dao.updatePatientById(bo);
		return (count==0)?"Patient Details not updated":"Patient Details upated";
	}

	@Override
	public String removePatientById(int pid) {
		int count=0;
		//use DAO
		count=dao.deletePatientById(pid);
		if(count==0)
		   return "Patient not found to Delete";
		else
			return "Patient  Deleted";
		
	}

}
