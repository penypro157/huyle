package spring.web.controller;

import org.bson.types.ObjectId;
import org.dom4j.util.AttributeHelper;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.web.entity.*;
import spring.web.repo.*;
import sun.plugin2.message.Conversation;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.System;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class homeController {
@Autowired UserRepository userRepository;
@Autowired
    CountryRepo countryRepo;
@Autowired
    LanguageRepo languageRepo;
@Autowired
    ConversationRepo conversationRepo;
@Autowired
MassageRepo messageRepo;
    @RequestMapping("/room")
    public String homePage(Model model,  HttpServletRequest request ){
        HttpSession session= request.getSession();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        UserEntity userEntity= userRepository.findByEmail(email);

        session.setAttribute("id",email);

        ArrayList<CountryEntity> countryEntities= new ArrayList<>();
        ArrayList<LanguageEntity> languageEntities= new ArrayList<>();
        ArrayList<UserEntity> userEntities=userEntity.getContactList();
        languageEntities= (ArrayList<LanguageEntity>) languageRepo.findAll();
        countryEntities= (ArrayList<CountryEntity>) countryRepo.findAll();

        model.addAttribute("countries",countryEntities);
        model.addAttribute("languages",languageEntities);
        model.addAttribute("user",userEntity);
        model.addAttribute("conntactList",userEntities);

//        MessageEntity messageEntity= new MessageEntity();
//        messageEntity.setUserEntity(userEntity1);
//
//        System.out.println(conversationRepo.findOne(new ObjectId("5aa2015eec5ab386d22bface")).toString());
//        ConversationEntity conversationEntity1  =conversationRepo.findOne(new ObjectId("5aa2015eec5ab386d22bface"));
//        messageEntity.setConversationEntity(conversationEntity1);
//        messageEntity.setContent("Huy le dep trai");
//
//
//
////        UserEntity userEntity1= new UserEntity("huancao","huanoaz@gmail.com","34613736", new Date(), new Date(),null,null,countryEntity);
//        messageRepo.save(messageEntity);
////       userRepository.save(userEntity);
//        ArrayList<ConversationEntity> conversationEntities= new ArrayList<>();
//
//        ArrayList<LanguageEntity> languageEntities = new ArrayList<>();
//        CountryEntity countryEntity= countryRepo.findOne(new ObjectId("5aa1e539929ea23dfc455b29"));
//        LanguageEntity languageEntity1= languageRepo.findOne(new ObjectId("5a9c10726ec1f94734636255"));
//        LanguageEntity languageEntity2= languageRepo.findOne(new ObjectId("5a9fb40eec5a6eb641229065"));
//        languageEntities.add(languageEntity1);
//        languageEntities.add(languageEntity2);
//        userEntity1.setLanguageEntities(languageEntities);
//        ConversationEntity conversationEntity= conversationRepo.findOne(new ObjectId("5aa1f93fec5a017735c73fbf"));
//        conversationEntities.add(conversationEntity);
//        userEntity1.setConversationEntities(conversationEntities);
//        MessageEntity messageEntity = new MessageEntity(conversationEntity,userEntity1,"anh yeu em rat nhieu", new Date());
//        messageRepo.save(messageEntity);
//        userEntity1.setRoles(3);
//        userEntity2.setRoles(3);

        return "room";
    }
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public void updateStatus(){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        UserEntity userEntity=userRepository.findByEmail(email);
        userEntity.setTimeUpdate(new Date());
        userRepository.save(userEntity);

    }
    @RequestMapping(value = "/chatroom")
    public String chatroom(){
            return "chatroom";

    }
}
