package example.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import example.dao.AdminUnitTypeDao;
import example.domain.AdminUnit;
import example.domain.AdminUnitType;

@Controller

public class typeStructController {
	
	@Resource
    private AdminUnitTypeDao adminUnitTypeDao;
	
	@RequestMapping("/liigistrukt")
	public String index(ModelMap model) {
		List<AdminUnitType> adminUnitTypes = adminUnitTypeDao.findAll();

        model.addAttribute("adminUnitTypes", adminUnitTypes);
		
		return "liigistrukt";

	}
	
	@RequestMapping("/deleteAdminUnitType")
	public String deleteAdminUnitType(@RequestParam("id") Long adminUnitTypsId) {
		adminUnitTypeDao.delete(adminUnitTypsId);
		
        return "redirect:liigistrukt";
	}
	
	@RequestMapping("/editAdminUnitType")
	public String editAdminUnitType(@RequestParam("id") Long adminUnitTypsId, ModelMap model) {
		adminUnitTypeDao.delete(adminUnitTypsId);
		
		AdminUnitType adminUnitType = adminUnitTypeDao.load(adminUnitTypsId);

        model.addAttribute("adminUnit", adminUnitType);
        //see lisab listi//addFormData(model);
		
        return "liigiredakt";
        
	}

}