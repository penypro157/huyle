package spring.web.service;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import spring.web.entity.BaiDang;
import spring.web.entity.HoSoTaiKhoan;

import java.util.ArrayList;
import java.util.List;

public interface IBaiDangService {
    BaiDang addBaiDang(BaiDang baiDang);
    boolean updateBaiDang(BaiDang baiDang);
    boolean deleteBaiDangById(ObjectId id);
    boolean deleteBaiDang(Query query);
    BaiDang getBaiDangById(ObjectId id);
    BaiDang getSpecifyElementFromBaiDang(ObjectId maBaiDang, String nameField);
    ArrayList<BaiDang> getBaiDangByNguoiDang(ObjectId id);
    List<BaiDang> getBaiDangByEmail(String email);
    void addLikeCount(ObjectId maBaiDang, int quantity);
    void updateDSThich(ObjectId maBaiDang, HoSoTaiKhoan hoSoTaiKhoan);

}
