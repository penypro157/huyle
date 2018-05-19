package spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.web.entity.CountryEntity;
import spring.web.entity.LanguageEntity;
import spring.web.entity.UserEntity;
import spring.web.repo.CountryRepo;
import spring.web.repo.LanguageRepo;

import java.util.ArrayList;

@Controller
public class LoginController {
    @Autowired
    CountryRepo countryRepo;
    @Autowired
    LanguageRepo languageRepo;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        ArrayList<LanguageEntity> languageEntities= (ArrayList<LanguageEntity>) languageRepo.findAll();
        ArrayList<CountryEntity> countryEntities = (ArrayList<CountryEntity>) countryRepo.findAll();
        model.addAttribute("user",new UserEntity());
        model.addAttribute( "languages", languageEntities);
        model.addAttribute("countries", countryEntities);
        return "login";
    }
}
