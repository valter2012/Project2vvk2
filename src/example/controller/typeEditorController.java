package example.controller;

//import javax.servlet.http.HttpSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMethod;

import example.dao.AdminUnitTypeDao;
import example.domain.AdminUnitType;


@Controller

public class typeEditorController {
	
    @Resource
    private AdminUnitTypeDao adminUnitTypeDao;

	@RequestMapping("/liigiredakt")
	public String index(ModelMap model) {

		model.addAttribute("message", "test teade");
		return "liigiredakt";

	}
	
    @RequestMapping(value = "/liigiredakt", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute("adminUnit") AdminUnitType adminUnitType, ModelMap model) {

    	adminUnitType.setAlates(new Date());
    	try {
    		Date toDate = new SimpleDateFormat("yyyy/MM/dd").parse("9999/12/24");
    		adminUnitType.setKuni(toDate);
    	} catch (ParseException e) {
			e.printStackTrace();
		}
    	adminUnitType.setAvaja("system"); // see võiks tulla sessionist
    	adminUnitType.setAvatud(new Date());
    	
    	adminUnitTypeDao.store(adminUnitType);
    	model.addAttribute("message", "Admin üksus salvestatud:");
       
    	return "redirect:liigistrukt"; 
    }

}