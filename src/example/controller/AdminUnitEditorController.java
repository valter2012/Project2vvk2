package example.controller;

//import javax.servlet.http.HttpSession;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMethod;

import example.dao.AdminUnitDao;
import example.dao.AdminUnitSubordDao;
import example.dao.AdminUnitTypeDao;
import example.domain.AdminUnit;
import example.domain.AdminUnitSubord;
import example.domain.AdminUnitType;
import example.domain.Person;


@Controller

public class AdminUnitEditorController {
	
    @Resource
    private AdminUnitDao adminUnitDao;
    @Resource
    private AdminUnitTypeDao adminUnitTypeDao;
//    @Resource
//    private AdminUnitSubordDao adminUnitSubordDao;

	@RequestMapping("/yksuseredakt")
	public String unitEditor(ModelMap model) {
	
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
        while (iterator1.hasNext()) {
        	AdminUnit temp = iterator1.next();
        	adminUnitsMap.put(temp.getId(), temp.getNimetus());
    	
        }

        model.addAttribute("adminUnitTypes", adminUnitTypesMap);
        model.addAttribute("adminUnits", adminUnitsMap);
        
    }
	
    @RequestMapping(value = "/yksuseredakt", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute("adminUnit") AdminUnit adminUnit,
    		@ModelAttribute("adminUnitTypeSelect") Long adminUnitTypeId,
    						ModelMap model) {
    	
		List<String> errors = getValidationErrors(adminUnit);
		if (!errors.isEmpty()) {
		    model.addAttribute("errors", errors);
		    addFormData(model);
		    return "yksuseredakt";
		}
		
		adminUnit.setType_id(adminUnitTypeId); // see tuleb hiljem vormilt
		
		adminUnit.setAlates(new Date());
		try {
			Date toDate = new SimpleDateFormat("yyyy/MM/dd").parse("9999/12/24");
			adminUnit.setKuni(toDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		adminUnit.setAvaja("system"); // see võiks tulla sessionist
		adminUnit.setAvatud(new Date());
		//adminUnit.setMuudetud(new Date());
		//adminUnit.setMuutja("system"); // see võiks tulla sessionist
		//adminUnit.setSuletud(suletud);
		//adminUnit.setSulgeja("system"); // see võiks tulla sessionist
		
		adminUnitDao.store(adminUnit);

    	return "redirect:alluvusraport"; // näitame parem kogu loetelu peale lisamist
    }
    
//    @RequestMapping(value = "/addSub", method = RequestMethod.POST)
//    public String addSub(@RequestParam("headUnitId") Long headUnitId, 
//    		@RequestParam("subUnitId") Long subUnitId,
//    		ModelMap model) {
//		
//		AdminUnitSubord adminUnitSubord = new AdminUnitSubord();
//		adminUnitSubord.setHead_id(headUnitId);
//		adminUnitSubord.setSub_id(subUnitId);
//		adminUnitSubordDao.store(adminUnitSubord);
//
//    	return "yksuseredakt/"; // näitame parem kogu loetelu peale lisamist
//    }
    
    private List<String> getValidationErrors(AdminUnit adminUnit) {
        List<String> errors = new ArrayList<String>();
        if ("".equals(adminUnit.getKommentaar())) {
            errors.add("Sisesta kommentaar!");
        }
        if ("".equals(adminUnit.getKood())) {
            errors.add("Sisesta kood!");
        }
        if ("".equals(adminUnit.getNimetus())) {
            errors.add("Sisesta nimetus!");
        }
        return errors;
    }

}