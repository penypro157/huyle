package spring.web.service;

import org.bson.types.ObjectId;
import spring.web.entity.BinhLuan;

import java.util.List;

public interface IBinhLuanService {
    BinhLuan addBinhLuan(BinhLuan binhLuan);
    BinhLuan addBinhLuanByNoiDungAndMaBaiDang(String email, String noidung, ObjectId maBaiDang);
    List<BinhLuan> getAllBinhLuanByMaBaiDang(ObjectId mabaidang);

}
