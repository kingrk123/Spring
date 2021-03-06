package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.ItemDetailsBO;
import com.nt.dao.ItemDetailsDAO;
import com.nt.dto.ItemDetailsDTO;

@Service("itemService")
public class MenuItemMgmtServiceImpl implements MenuItemMgmtService {
    @Autowired
	private ItemDetailsDAO dao;

	
	@Override
	public String registerMenuItem(ItemDetailsDTO dto) {
		int count=0;
		ItemDetailsBO bo=null;
		//convert  dto  to bo
		bo=new ItemDetailsBO();
		BeanUtils.copyProperties(dto, bo);
		//use dao
		count=dao.insert(bo);
		//process the result
		if(count==0)
			return "Adding item to MenuList is failed";
		else
			return "Adding item to MenuList is succeded";
	}

}
