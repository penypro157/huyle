package spring.web.entity;

import com.mysema.query.annotations.QueryEntity;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@QueryEntity
@Document
public class ConversationEntity {
    @Id private ObjectId conversationId;
    private ArrayList<HoSoTaiKhoan> userEntities;

    public ConversationEntity( ArrayList<HoSoTaiKhoan> userEntities) {
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

    public ArrayList<HoSoTaiKhoan> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(ArrayList<HoSoTaiKhoan> userEntities) {
        this.userEntities = userEntities;
    }
}
