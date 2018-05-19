package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Document
public class CountryEntity {
@Id private ObjectId countryId;
private String name;

    public CountryEntity( String name) {
        this.name = name;
    }

    public CountryEntity(){
    }

    public ObjectId getCountryId() {
        return countryId;
    }

    public void setCountryId(ObjectId countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
