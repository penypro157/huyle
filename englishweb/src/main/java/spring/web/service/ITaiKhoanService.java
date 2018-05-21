package spring.web.service;

import org.bson.types.ObjectId;
import spring.web.entity.TaiKhoan;

public interface ITaiKhoanService {
    TaiKhoan getTaiKhoanById(ObjectId id);
    TaiKhoan getTaiKhoanByEmail(String email);
    boolean updateTaiKhoan(TaiKhoan taiKhoan);
    boolean addTaiKhoan(TaiKhoan taiKhoan);
    boolean deleteTaiKhoan(TaiKhoan taiKhoan);
}
