package example.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

//import example.dao.AdminUnitDao;
import example.domain.InsertTestData;

@Controller
public class insertTestDataController {
	
	@Resource
    //private AdminUnitDao adminUnitDao;
	private InsertTestData insertTestData;
	
	@RequestMapping(value = "/prooviAndmed")
    public String showForm(ModelMap model) {

		insertTestData.insertTestAdminUnits();

        return "index";
    }
	

}
