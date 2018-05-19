package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import spring.web.entity.ConversationEntity;
import spring.web.entity.UserEntity;

import java.util.ArrayList;

public interface ConversationRepo extends MongoRepository<ConversationEntity,ObjectId> {
    @Query("{ 'name' : ?0 }")
    ConversationEntity findByConversationId(ObjectId id);
    ConversationEntity findAllByUserEntities(ArrayList<String> userEntities);
}
