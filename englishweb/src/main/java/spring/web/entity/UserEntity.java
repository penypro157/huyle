package spring.web.entity;

import org.bson.types.ObjectId;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class UserEntity {
    @Id
    private ObjectId id;
    private String username;
    @Indexed(unique = true)
    private String email;
    private String password;
    private Boolean online;
    private Date timeUpdate;
    private Date created;
    @DBRef
    private ArrayList<UserEntity> contactList;
    @DBRef
    private ArrayList<LanguageEntity> languageEntities;
    @Field("country")
    @DBRef
    private ArrayList<CountryEntity> countryEntity;
    @DBRef
    private ArrayList<ConversationEntity> conversationEntities;
    private Integer roles;

    public UserEntity() {

    }

    public UserEntity( String username, String email, String password,Boolean online, Date timeUpdate, Date created, ArrayList<UserEntity>  contactList, ArrayList<LanguageEntity> languageEntities, ArrayList<CountryEntity> countryEntity) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.timeUpdate = timeUpdate;
        this.created = created;
        this.contactList = contactList;
        this.languageEntities = languageEntities;
        this.countryEntity = countryEntity;
        this.online=online;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Integer getRoles() {
        return roles;
    }

    public void setRoles(Integer roles) {
        this.roles = roles;
    }

    public Date getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(Date timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ArrayList<UserEntity> getContactList() {
        return contactList;
    }

    public void setContactList(ArrayList<UserEntity> contactList) {
        this.contactList = contactList;
    }

    public ArrayList<LanguageEntity> getLanguageEntities() {
        return languageEntities;
    }

    public void setLanguageEntities(ArrayList<LanguageEntity> languageEntities) {
        this.languageEntities = languageEntities;
    }

    public ArrayList<CountryEntity> getCountryEntity() {
        return countryEntity;
    }

    public void setCountryEntity(ArrayList<CountryEntity> countryEntity) {
        this.countryEntity = countryEntity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<ConversationEntity> getConversationEntities() {
        return conversationEntities;
    }

    public void setConversationEntities(ArrayList<ConversationEntity> conversationEntities) {
        this.conversationEntities = conversationEntities;
    }
}
