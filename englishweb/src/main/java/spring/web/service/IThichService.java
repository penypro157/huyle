package spring.web.service;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import spring.web.entity.Thich;

public interface IThichService {
    boolean checkLiked(String email, ObjectId maBaiDang);
    boolean addLikeByEmailAndMaBaiDang(String email,ObjectId maBaiDang);
    boolean deleteLikedByEmailAndMaBaiDang(String email,ObjectId maBaiDang);


}
