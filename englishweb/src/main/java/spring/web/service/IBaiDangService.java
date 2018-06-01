package spring.web.service;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import spring.web.entity.BaiDang;

import java.util.ArrayList;

public interface IBaiDangService {
    BaiDang addBaiDang(BaiDang baiDang);
    boolean updateBaiDang(Query query, Update update);
    boolean deleteBaiDangById(ObjectId id);
    boolean deleteBaiDang(Query query);
    BaiDang getBaiDangById(ObjectId id);
    ArrayList<BaiDang> getBaiDangByNguoiDang(ObjectId id);
    ArrayList<BaiDang> getBaiDangByEmail(String email);

}
