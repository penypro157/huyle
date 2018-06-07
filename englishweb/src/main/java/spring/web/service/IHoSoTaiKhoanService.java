package spring.web.service;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import spring.web.entity.BanBe;
import spring.web.entity.HinhAnh;
import spring.web.entity.HoSoTaiKhoan;

import java.util.List;


public interface IHoSoTaiKhoanService {

    HoSoTaiKhoan getHoSoTaiKhoanById(ObjectId id);
    List<HoSoTaiKhoan> getHoSoTaiKhoanByTenHienThiLike(String tenhienthi);
    HoSoTaiKhoan getHoSoTaiKhoanByEmail(String email);
    HoSoTaiKhoan getHoSoTaiKhoan(Query query);
    boolean updateHoSoTaiKhoan(Query query, Update update);
    boolean addBanBe(HoSoTaiKhoan sender, HoSoTaiKhoan reciver);
    boolean updateHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan);
    boolean deleteHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan);
    boolean setAnhDaiDien(HinhAnh hinhAnh);
    boolean setAnhBia(HinhAnh hinhAnh);
    boolean deleteHoSoTaiKhoanByEmail(String email);
    boolean deleteHoSoTaiKhoanById(ObjectId id);
    boolean addHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan);
    ObjectId getObjectIdByEmail(String email);
}
