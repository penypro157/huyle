package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import spring.web.entity.TinhThanh;

public interface TinhThanhRepository extends MongoRepository<TinhThanh, ObjectId> {
}
