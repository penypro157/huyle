package spring.web.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.web.repo.CountryRepo;
import spring.web.repo.LanguageRepo;
import spring.web.repo.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class RegisterController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LanguageRepo languageRepo;
    @Autowired
    CountryRepo countryRepo;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") UserEntity userEntity, Model model, HttpServletRequest request){
        String language=request.getParameter("language");
        String country=request.getParameter("country");
        LanguageEntity languageEntity= languageRepo.findByName(language);
        CountryEntity countryEntity= countryRepo.findByName(country);
        ArrayList<CountryEntity> countryEntities= new ArrayList<>();
        ArrayList<LanguageEntity> languageEntities= new ArrayList<>();
        countryEntities.add(countryEntity);
        languageEntities.add(languageEntity);
        userEntity.setCountryEntity(countryEntities);
        userEntity.setLanguageEntities(languageEntities);
        userEntity.setRoles(2);
       try{
          if (userRepository.save(userEntity)!=null){
            model.addAttribute("thanhcong","Dang ky thanh cong tai khoan "+userEntity.getEmail());
            return "login";

          }
       }
       catch (Exception e){
        model.addAttribute("thongbao","Dang ky tai khoan khong thanh cong");

       }

        return "login";

    }
}
