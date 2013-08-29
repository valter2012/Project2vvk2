package example.controller;

//import javax.servlet.http.HttpSession;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMethod;

import example.dao.AdminUnitDao;
import example.domain.AdminUnit;

@Controller

public class AdminUnitEditorController {
	
    @Resource
    private AdminUnitDao adminUnitDao;

	@RequestMapping("/yksuseredakt")
	public String index(ModelMap model) {

		addFormData(model);
		return "yksuseredakt";

	}
	
	// TODO see on hardcoded tüübid teen hiljem ringi, et loeb baasist
    private void addFormData(ModelMap model) {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(1, "Maakond");
        map.put(2, "Vald");
        map.put(3, "Linn");
        map.put(4, "Küla");
        map.put(5, "Linnaosa");
        FormData formData = new FormData();
        formData.setAgeGroups(map);

        model.addAttribute("formData", formData);
    }
	
    @RequestMapping(value = "/yksuseredakt", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute("adminUnit") AdminUnit adminUnit, ModelMap model) {

    	
    	
//        List<String> errors = getValidationErrors(person);
//        if (!errors.isEmpty()) {
//            model.addAttribute("errors", errors);
//            addFormData(model);
//            return "form";
//        }
    	
    	// kirjutan siia need puuduvad testimiseks//
    	adminUnit.setAlates(new Date());
    	try {
    		Date toDate = new SimpleDateFormat("yyyy/MM/dd").parse("9999/12/24");
    		adminUnit.setKuni(toDate);
    	} catch (ParseException e) {
			e.printStackTrace();
		}
    	adminUnit.setAvaja("system"); // see võiks tulla sessionist
    	adminUnit.setAvatud(new Date());
    	//adminUnit.setMuudetud(muudetud);
    	//adminUnit.setMuutja("system"); // see võiks tulla sessionist
    	//adminUnit.setSuletud(suletud);
    	//adminUnit.setSulgeja("system"); // see võiks tulla sessionist
    	adminUnit.setType_id(1L); // see tuleb hiljem vormilt
    	
    	adminUnitDao.store(adminUnit);
    	model.addAttribute("message", "Admin üksus salvestatud:");
        
        //return "yksuseredakt";
        //return "redirect:yksuseredakt"; // läheb tühjale tagasi
    	return "redirect:alluvusraport"; // näitame parem kogu loetelu peale lisamist
    }

}