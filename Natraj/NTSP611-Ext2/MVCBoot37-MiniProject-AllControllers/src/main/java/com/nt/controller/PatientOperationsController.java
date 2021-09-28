package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.PatientDetailsCommand;
import com.nt.dto.PatientDetailsDTO;
import com.nt.service.HospitalMgmtService;

@Controller
public class PatientOperationsController  {
	@Autowired
	private HospitalMgmtService service;
	
	
	@RequestMapping("/home.htm")
	public   String showHomePage() {
		return "welcome";
	}
	
	@RequestMapping("/list_patients.htm")
	public String listPatients(Map<String,Object> map) {
		List<PatientDetailsDTO> listDTO=null;
		//use service
		listDTO=service.fetchAllPatients();
		//create model attribute
		map.put("listDTO",listDTO);
		//return MAV object
		return "list_patients";
	}
	
	@GetMapping("/patient_edit.htm")
	public String showEditForm(@ModelAttribute("patientCmd") PatientDetailsCommand cmd,HttpServletRequest req) {
		PatientDetailsDTO dto=null;
		//get DTO object having dynamic values
		dto=service.fetchPatientById(Integer.parseInt(req.getParameter("id")));
		//copy DTO obj to Cmd object
		BeanUtils.copyProperties(dto,cmd);
		//return form page lvn
		return "edit_patient";
	}
	
	
		@PostMapping("/patient_edit.htm")
		public String processEditForm(Map<String,Object> map,
				                                                     @ModelAttribute("patientCmd") PatientDetailsCommand cmd,
				                                                     BindingResult errors) {
			PatientDetailsDTO dto=null;
			String resultMsg=null;
			List<PatientDetailsDTO> listDTO=null;
			//convert cmd to dto
			dto=new PatientDetailsDTO();
			BeanUtils.copyProperties(cmd,dto);
			System.out.println(cmd.getPid()+"   "+cmd.getPname()+" "+dto.getPid());
			//use Service
			resultMsg=service.modifyPatientById(dto);
			listDTO=service.fetchAllPatients();
			//create and return MAV object
			map.put("listDTO",listDTO);
			map.put("resultMsg",resultMsg);
			return "list_patients";
		}
		
		@RequestMapping("/patient_delete.htm")
		public String deletePatient(Map<String,Object> map,HttpServletRequest req) {
			String resultMsg=null;
			List<PatientDetailsDTO> listDTO=null;
			System.out.println("DeletePatientController.handleRequestInternal()");
			//use service
			resultMsg=service.removePatientById(Integer.parseInt(req.getParameter("id")));
			listDTO=service.fetchAllPatients();
			//return MAV
			map.put("resultMsg",resultMsg);
			map.put("listDTO",listDTO);
			return "list_patients";
		}
}
