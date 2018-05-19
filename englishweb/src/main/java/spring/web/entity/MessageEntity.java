package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Document
public class    MessageEntity {
    @Id private ObjectId messageId;
    @DBRef
    private ConversationEntity conversationEntity;
    @DBRef
    private UserEntity userEntity;
    private String content;
    private boolean status;
    private Date createdDay;
    public MessageEntity(ConversationEntity conversationEntity, UserEntity userEntity, String content, boolean status, Date createdDay) {
        this.conversationEntity = conversationEntity;
        this.userEntity = userEntity;
        this.content = content;
        this.status= status;
        this.createdDay = createdDay;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ObjectId getMessageId() {
        return messageId;
    }

    public void setMessageId(ObjectId messageId) {
        this.messageId = messageId;
    }

    public MessageEntity() {
    }

    public ConversationEntity getConversationEntity() {
        return conversationEntity;
    }

    public void setConversationEntity(ConversationEntity conversationEntity) {
        this.conversationEntity = conversationEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
    }
}
