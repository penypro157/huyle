package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import spring.web.entity.LanguageEntity;

public interface LanguageRepo extends MongoRepository<LanguageEntity,ObjectId>{
    LanguageEntity findByLanguageId(ObjectId id);
    LanguageEntity findByName(String name);
}
