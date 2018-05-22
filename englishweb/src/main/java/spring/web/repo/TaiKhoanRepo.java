package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.web.entity.CountryEntity;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.entity.LanguageEntity;
import spring.web.entity.TaiKhoan;

import java.util.ArrayList;
import java.util.stream.Stream;

@Repository
public interface TaiKhoanRepo extends MongoRepository<TaiKhoan,ObjectId> {
    TaiKhoan findByEmail(String email);
    TaiKhoan findById(ObjectId id);
    @Query(value = "{'email': ?0}",count = true,fields = "{'email' : 1, 'password' :0}")
    String findEmail(String email);



}

