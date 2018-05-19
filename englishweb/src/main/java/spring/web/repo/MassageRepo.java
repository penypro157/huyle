package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spring.web.entity.ConversationEntity;
import spring.web.entity.MessageEntity;

import java.util.ArrayList;
@Repository
public interface MassageRepo extends MongoRepository<MessageEntity,ObjectId> {
    ArrayList<MessageEntity> findAllByConversationEntityOrderByCreatedDay(ConversationEntity conversationEntity);


}
