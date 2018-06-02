package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import spring.web.entity.Thich;

public interface ThichRepository extends MongoRepository<Thich,ObjectId> {
}
