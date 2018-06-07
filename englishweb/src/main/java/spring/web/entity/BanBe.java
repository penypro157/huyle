package spring.web.entity;

import com.sun.jmx.snmp.Timestamp;
import org.bson.types.ObjectId;

import java.util.Date;
public class BanBe {
    private String tenHienThi;
    private HinhAnh anhDaiDien;
    private Date thoiGianHoatDong;
    private ObjectId maHoSoTaiKhoan;
    private TrangThaiBanBe trangThaiBanBe;
    private Date thoigian;

    public BanBe(String tenHienThi, HinhAnh anhDaiDien, Date thoiGianHoatDong, ObjectId maHoSoTaiKhoan, TrangThaiBanBe trangThaiBanBe, Date thoiGian) {
        this.tenHienThi = tenHienThi;
        this.anhDaiDien = anhDaiDien;
        this.thoiGianHoatDong = thoiGianHoatDong;
        this.maHoSoTaiKhoan = maHoSoTaiKhoan;
        this.trangThaiBanBe = trangThaiBanBe;
        this.thoigian=thoiGian;
    }

    public BanBe() {
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
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

    public TrangThaiBanBe getTrangThaiBanBe() {
        return trangThaiBanBe;
    }

    public void setTrangThaiBanBe(TrangThaiBanBe trangThaiBanBe) {
        this.trangThaiBanBe = trangThaiBanBe;
    }
}

