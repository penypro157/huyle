package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import spring.web.entity.BaiDang;

import java.util.ArrayList;

public interface BaiDangRepository extends MongoRepository<BaiDang, ObjectId> {
    BaiDang findById(ObjectId id);
    boolean deleteById(ObjectId id);

}
