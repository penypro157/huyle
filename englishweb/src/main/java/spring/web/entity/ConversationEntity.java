package spring.web.entity;

import com.mysema.query.annotations.QueryEntity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import java.util.ArrayList;
@QueryEntity
@Document
public class ConversationEntity {
    @Id private ObjectId conversationId;
    private ArrayList<UserEntity> userEntities;

    public ConversationEntity( ArrayList<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public ConversationEntity(){
    }
    public ObjectId getConversationId() {
        return conversationId;
    }

    public void setConversationId(ObjectId conversationId) {
        this.conversationId = conversationId;
    }

    public ArrayList<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(ArrayList<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
