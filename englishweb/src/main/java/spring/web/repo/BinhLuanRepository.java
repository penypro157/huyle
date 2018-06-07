package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import spring.web.entity.BinhLuan;

public interface BinhLuanRepository extends MongoRepository<BinhLuan, ObjectId> {

}
