package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import spring.web.entity.CountryEntity;

public interface CountryRepo extends MongoRepository<CountryEntity,ObjectId> {
    CountryEntity findByCountryId(ObjectId id);
    CountryEntity findByName(String name);
}
