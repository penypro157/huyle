package spring.web.service;

import org.bson.types.ObjectId;
import spring.web.entity.BaiDang;

import java.util.ArrayList;

public interface IBaiDangService {
    boolean addBaiDang(BaiDang baiDang);
    boolean deleteBaiDang(BaiDang baiDang);
    boolean updateBaiDang(BaiDang baiDang);
    boolean deleteBaiDangById(ObjectId id);
    BaiDang getBaiDangById(ObjectId id);
    ArrayList<BaiDang> getBaiDangByNguoiDang(ObjectId id);
    ArrayList<BaiDang> getBaiDangByEmail(String email);

}
