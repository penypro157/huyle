package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import spring.web.entity.HoSoTaiKhoan;
@Repository
public interface HoSoTaiKhoanRepository extends MongoRepository<HoSoTaiKhoan, ObjectId> {
    HoSoTaiKhoan findByEmail(String email);
    HoSoTaiKhoan findById(ObjectId id);
    boolean deleteByEmail(String email);
    boolean deleteById(ObjectId id);


}
