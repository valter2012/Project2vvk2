package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class typeStructController {
	
	@RequestMapping("/liigistrukt")
	public String index(ModelMap model) {
		
		return "liigistrukt";

	}

}