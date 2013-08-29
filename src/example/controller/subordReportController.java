package example.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import example.dao.AdminUnitDao;
import example.domain.AdminUnit;
import example.domain.Person;

@Controller

public class subordReportController {
	
	@Resource
    private AdminUnitDao adminUnitDao;
	
	//TODO see kuvab hetkel kõik
	@RequestMapping("/alluvusraport")
	public String alluvusraport(ModelMap model) {
        List<AdminUnit> adminUnits = adminUnitDao.findAll();

        model.addAttribute("adminUnits", adminUnits);

		return "alluvusraport";

	}
	
	@RequestMapping("/deleteAdminUnit")
	public String deleteAdminUnit(@RequestParam("id") Long adminUnitsId) {
		adminUnitDao.delete(adminUnitsId);
		
        return "redirect:alluvusraport";
	}
	
	@RequestMapping("/editAdminUnit")
	public String editAdminUnit(@RequestParam("id") Long adminUnitsId, ModelMap model) {
		adminUnitDao.delete(adminUnitsId);
		
		AdminUnit adminUnit = adminUnitDao.load(adminUnitsId);

        model.addAttribute("adminUnit", adminUnit);
        //see lisab listi//addFormData(model);
		
        return "yksuseredakt";
        
	}
	
	
	
	//TODO see vajalik kui realiseerda värskenda
	@RequestMapping(value = "/alluvusraport", method = RequestMethod.POST)
	public String uuenda(ModelMap model) {
		
		return "alluvusraport";

	}

}