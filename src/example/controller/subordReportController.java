package example.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import example.dao.AdminUnitDao;
import example.dao.AdminUnitTypeDao;
import example.domain.AdminUnit;
import example.domain.AdminUnitType;

@Controller

public class subordReportController {
	
	@Resource
    private AdminUnitDao adminUnitDao;
    @Resource
    private AdminUnitTypeDao adminUnitTypeDao;
	
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
	public String editAdminUnit(@RequestParam("id") Long adminUnitId, ModelMap model) {
		
		AdminUnit adminUnit = adminUnitDao.load(adminUnitId);

        model.addAttribute("adminUnit", adminUnit);

		AdminUnitType adminUnitType = adminUnitTypeDao.load(adminUnit.getType_id());

		model.addAttribute("adminUnitType", adminUnitType);

        addFormData(model);
		
        return "yksuseredakt";
        
	}
	
    private void addFormData(ModelMap model) {
    	
    	List<AdminUnitType> adminUnitTypesList = adminUnitTypeDao.findAll();
    	LinkedHashMap<Long, String> adminUnitTypesMap = new LinkedHashMap<Long, String>();
 
        Iterator<AdminUnitType> iterator = adminUnitTypesList.iterator();
        while (iterator.hasNext()) {
        	AdminUnitType tempAdminUnitType = iterator.next();
        	adminUnitTypesMap.put(tempAdminUnitType.getId(), tempAdminUnitType.getNimetus());
    	
        }
        
        List<AdminUnit> adminUnitsList = adminUnitDao.findAll();
    	LinkedHashMap<Long, String> adminUnitsMap = new LinkedHashMap<Long, String>();
 
        Iterator<AdminUnit> iterator1 = adminUnitsList.iterator();
        while (iterator.hasNext()) {
        	AdminUnit temp = iterator1.next();
        	adminUnitsMap.put(temp.getId(), temp.getNimetus());
    	
        }

        model.addAttribute("adminUnitTypes", adminUnitTypesMap);
        model.addAttribute("adminUnits", adminUnitsMap);
    }
	
	
	
	//TODO see vajalik kui realiseerda värskenda
	@RequestMapping(value = "/alluvusraport", method = RequestMethod.POST)
	public String uuenda(ModelMap model) {
		
		return "alluvusraport";

	}

}