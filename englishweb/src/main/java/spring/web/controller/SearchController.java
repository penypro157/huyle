package spring.web.controller;

import com.sun.deploy.net.HttpResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.web.entity.CountryEntity;
import spring.web.entity.LanguageEntity;
import spring.web.entity.UserEntity;
import spring.web.repo.CountryRepo;
import spring.web.repo.LanguageRepo;
import spring.web.repo.UserRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LanguageRepo languageRepo;
    @Autowired
    CountryRepo countryRepo;

    @RequestMapping(value = "/username", method = RequestMethod.PUT)
    public @ResponseBody
    ArrayList<UserEntity> getUserByName(@RequestBody String username) {
        ArrayList<UserEntity> userEntity = userRepository.findTop10ByUsernameLike(username);
        return userEntity;
    }

    @RequestMapping(value = "/condition", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<UserEntity> getUserByCondition(@RequestParam("language") ObjectId language, @RequestParam("country") ObjectId country) {
        LanguageEntity languageEntity = languageRepo.findByLanguageId(language);
        CountryEntity countryEntity = countryRepo.findByCountryId(country);
        ArrayList<UserEntity> userEntity = new ArrayList<>();

            userEntity = userRepository.findTop20ByLanguageEntitiesAndCountryEntityOrderByTimeUpdate(languageEntity, countryEntity);
        return userEntity;
    }
//    public @ResponseBody  ArrayList<UserEntity> getUser(@RequestBody ArrayList conditons){
//
//        return userEntity;
//    }
}
