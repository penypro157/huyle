package spring.web.service;

import org.bson.types.ObjectId;
import spring.web.entity.HinhAnh;
import spring.web.entity.HoSoTaiKhoan;

public interface IHoSoTaiKhoanService {
    HoSoTaiKhoan getHoSoTaiKhoanById(ObjectId id);
    HoSoTaiKhoan getHoSoTaiKhoanByEmail(String email);
    boolean updateHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan);
    boolean deleteHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan);
    boolean setAnhDaiDien(HinhAnh hinhAnh);
    boolean setAnhBia(HinhAnh hinhAnh);
    boolean deleteHoSoTaiKhoanByEmail(String email);
    boolean deleteHoSoTaiKhoanById(ObjectId id);
    boolean addHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan);
}
