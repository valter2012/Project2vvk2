package example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import example.dao.PersonDao;
import example.domain.Person;

@Controller
public class PersonController {

    @Resource
    private PersonDao personDao;

    // et logimist vähemaks saada kirjutage log4j.properties failis viimasel read DEBUG
    // asemele nt. ERROR
    // samas vigade korral on logimine vägagi abiks

    @RequestMapping(value = "/list")
    public String personList(ModelMap model) {
        List<Person> persons = personDao.findAll();

        model.addAttribute("persons", persons);

        return "list";
    }

    @RequestMapping(value = "/form")
    public String showForm(ModelMap model) {

        addFormData(model);

        return "form";
    }

    private void addFormData(ModelMap model) {

        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(1, "Laps");
        map.put(2, "Täiskasvanu");
        map.put(3, "Pensionär");
        FormData formData = new FormData();
        formData.setAgeGroups(map);

        model.addAttribute("formData", formData);
    }

    @RequestMapping(value = "/delete")
    public String deletePerson(@RequestParam("id") Long personId) {
        personDao.delete(personId);

        return "redirect:list";
    }

    @RequestMapping(value = "/edit")
    public String editPerson(@RequestParam("id") Long personId, ModelMap model) {
        Person person = personDao.load(personId);

        model.addAttribute("person", person);
        addFormData(model);

        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute("person") Person person, ModelMap model) {

        List<String> errors = getValidationErrors(person);
        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            addFormData(model);
            return "form";
        }

        personDao.store(person);

        return "redirect:list";
    }

    @RequestMapping(value = "/counter")
    public String counter(HttpSession session) {

        Integer i = (Integer) session.getAttribute("counter");
        if (i == null) i = 0;

        session.setAttribute("counter", ++i);

        return "counter";
    }

    // kuupäev parameetrina näide
    @RequestMapping(value = "/bind") // /bind?date=2012-12-12
    public String bind(@RequestParam("date") @DateTimeFormat(iso = ISO.DATE) Date date,
                       ModelMap model) {

        model.addAttribute("out", date);

        return "out";
    }

    private List<String> getValidationErrors(Person person) {
        List<String> errors = new ArrayList<String>();
        if ("".equals(person.getFirstName())) {
            errors.add("Sisesta eesnimi!");
        }
        if ("".equals(person.getName())) {
            errors.add("Sisesta perekonnanimi!");
        }

        return errors;
    }

}