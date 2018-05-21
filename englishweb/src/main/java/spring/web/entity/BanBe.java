package spring.web.entity;

import com.sun.jmx.snmp.Timestamp;
import org.bson.types.ObjectId;

import java.util.Date;
public class BanBe {
    private String tenHienThi;
    private HinhAnh anhDaiDien;
    private Date thoiGianHoatDong;
    private ObjectId maHoSoTaiKhoan;

    public BanBe(String tenHienThi, HinhAnh anhDaiDien, Date thoiGianHoatDong, ObjectId maHoSoTaiKhoan) {
        this.tenHienThi = tenHienThi;
        this.anhDaiDien = anhDaiDien;
        this.thoiGianHoatDong = thoiGianHoatDong;
        this.maHoSoTaiKhoan = maHoSoTaiKhoan;
    }

    public String getTenHienThi() {
        return tenHienThi;
    }

    public void setTenHienThi(String tenHienThi) {
        this.tenHienThi = tenHienThi;
    }

    public HinhAnh getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(HinhAnh anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public Date getThoiGianHoatDong() {
        return thoiGianHoatDong;
    }

    public void setThoiGianHoatDong(Date thoiGianHoatDong) {
        this.thoiGianHoatDong = thoiGianHoatDong;
    }

    public ObjectId getMaHoSoTaiKhoan() {
        return maHoSoTaiKhoan;
    }

    public void setMaHoSoTaiKhoan(ObjectId maHoSoTaiKhoan) {
        this.maHoSoTaiKhoan = maHoSoTaiKhoan;
    }
}

