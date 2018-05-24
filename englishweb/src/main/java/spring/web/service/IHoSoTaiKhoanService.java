package spring.web.service;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import spring.web.entity.HinhAnh;
import spring.web.entity.HoSoTaiKhoan;


public interface IHoSoTaiKhoanService {
    HoSoTaiKhoan getHoSoTaiKhoanById(ObjectId id);
    HoSoTaiKhoan getHoSoTaiKhoanByEmail(String email);
    HoSoTaiKhoan getHoSoTaiKhoan(Query query);
    boolean updateHoSoTaiKhoan(Query query, Update update);
    boolean updateHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan);
    boolean deleteHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan);
    boolean setAnhDaiDien(HinhAnh hinhAnh);
    boolean setAnhBia(HinhAnh hinhAnh);
    boolean deleteHoSoTaiKhoanByEmail(String email);
    boolean deleteHoSoTaiKhoanById(ObjectId id);
    boolean addHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan);
}
