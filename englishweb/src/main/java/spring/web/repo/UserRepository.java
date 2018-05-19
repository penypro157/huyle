package spring.web.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.web.entity.ConversationEntity;
import spring.web.entity.CountryEntity;
import spring.web.entity.LanguageEntity;
import spring.web.entity.UserEntity;

import java.util.ArrayList;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,ObjectId> {
     UserEntity findByEmail(String email);

     ArrayList<UserEntity> findTop10ByUsernameLike(String username);
     ArrayList<UserEntity> findTop20ByLanguageEntitiesAndCountryEntityOrderByTimeUpdate(LanguageEntity languageEntity, CountryEntity countryEntity);
     ArrayList<UserEntity> findByLanguageEntities(LanguageEntity languageEntity);
     ArrayList<UserEntity> findByCountryEntity(CountryEntity countryEntity);
     ArrayList<UserEntity> findByUsername(String username);
//     @Query("select u.conversationEntities from UserEntity ")
//     UserEntity readByEmail(String email);

}

