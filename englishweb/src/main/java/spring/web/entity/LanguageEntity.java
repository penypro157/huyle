package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Document
public class LanguageEntity {
    @Id private ObjectId languageId;
    private String name;

    public LanguageEntity( String name) {
        this.name = name;
    }

    public LanguageEntity(){
    }

    public ObjectId getCountryId() {
        return languageId;
    }

    public void setCountryId(ObjectId countryId) {
        this.languageId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
