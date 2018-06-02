package spring.web.service;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import spring.web.entity.TaiKhoan;


public interface ITaiKhoanService {
    TaiKhoan getTaiKhoanByEmail(String email);
    boolean updateTaiKhoan(TaiKhoan taiKhoan);
    boolean addTaiKhoan(TaiKhoan taiKhoan);
    boolean deleteTaiKhoan(TaiKhoan taiKhoan);
    boolean updateTaiKhoan(Query query, Update update);
    boolean exist(Query query);

}
