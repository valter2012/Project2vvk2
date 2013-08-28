package example.controller;

//import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;


@Controller

public class typeEditorController {
	

	@RequestMapping("/liigiredakt")
	public String index(ModelMap model) {

		//model.addAttribute("message", "mingi teade");
		return "liigiredakt";

	}

}