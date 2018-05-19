package spring.web.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import spring.web.entity.ConversationEntity;
import spring.web.entity.MessageEntity;
import spring.web.entity.UserEntity;
import spring.web.repo.ConversationRepo;
import spring.web.repo.MassageRepo;
import spring.web.repo.UserRepository;

import java.util.ArrayList;
import java.util.Date;

@Controller


public class MessengerController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ConversationRepo conversationRepo;
    @Autowired
    MassageRepo messageRepo;
    @RequestMapping(value = "message",method = RequestMethod.GET)
    public  @ResponseBody
    ArrayList<MessageEntity> getAllMassageById(@RequestParam("email") String emailMember){

        ArrayList<MessageEntity> messageEntities= new ArrayList<>();
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        UserEntity userEntity=userRepository.findByEmail(email);
        UserEntity member= userRepository.findByEmail(emailMember);
        ArrayList<UserEntity> members= new ArrayList<>();
        members.add(userEntity);
        members.add(member);
        ArrayList<ConversationEntity> conversationEntityArrayList= userEntity.getConversationEntities();
//        ConversationEntity con= getConversation(conversationEntityArrayList, member, userEntity);
//        for(int i=0;i<conversationEntities.size();i++){
//            try{ conversationEntity=conversationEntities.get(i).getConversationId(); }
//         catch (Exception e){
//             System.out.println("can't find");
//         }
//         }
//        messageEntities=messageRepo.findAllByConversationEntityOrderByCreatedDay();

        return  messageEntities;
    }


    @RequestMapping(value = "/send")
    public @ResponseBody MessageEntity getMessage(@RequestParam("email") String email_member, @RequestBody String content){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        UserEntity userEntity= userRepository.findByEmail(email);
        ArrayList<UserEntity> members= new ArrayList<>();
        UserEntity member= userRepository.findByEmail(email_member);
        ArrayList<ConversationEntity> conversationEntity= userEntity.getConversationEntities();
        if(checkConversation(conversationEntity,member)==null) {
            ConversationEntity newConversation= new ConversationEntity();

            members.add(userEntity);
            members.add(member);
            newConversation.setUserEntities(members);
            conversationRepo.save(newConversation);

        }
        MessageEntity messageEntity= new MessageEntity();
        messageEntity.setContent(content);
        messageEntity.setCreatedDay(new Date());
        messageEntity.setStatus(false);
        messageEntity.setUserEntity(userEntity);

        return  messageRepo.save(messageEntity);



    }
    public ConversationEntity checkConversation(ArrayList<ConversationEntity> conversationEntities, UserEntity member){

        for (ConversationEntity con: conversationEntities
             ) {
            if(con.getUserEntities().get(0).equals(member)||con.getUserEntities().get(1).equals(
                    member
            )) return con;
                break;
            
        }
        return null;

    }

}
