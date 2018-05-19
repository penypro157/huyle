package spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.web.entity.UserEntity;
import spring.web.repo.UserRepository;

import java.util.List;

@Controller
public class UserStatusController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/checkonline")
    public @ResponseBody
    List<UserEntity> getUserEntity(){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        UserEntity userEntity= userRepository.findByEmail(email);
        List<UserEntity> userEntityList= userEntity.getContactList();
    ;
        return userEntityList;

    }
    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public @ResponseBody  UserEntity getUser(@RequestParam("email") String email){
        UserEntity userEntity= userRepository.findByEmail(email);
        return userEntity;

    }
}
