package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class subordReportController {
	
	@RequestMapping("/alluvusraport")
	public String index(ModelMap model) {
		
		return "alluvusraport";

	}

}