package example.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.dao.AdminUnitDao;
import example.domain.AdminUnit;

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
	
	
	//TODO see vajalik kui realiseerda värskenda
	@RequestMapping(value = "//alluvusraport", method = RequestMethod.POST)
	public String uuenda(ModelMap model) {
		
		return "alluvusraport";

	}

}