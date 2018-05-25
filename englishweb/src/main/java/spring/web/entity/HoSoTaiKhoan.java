package spring.web.entity;

import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class HoSoTaiKhoan {
    @Id
    private ObjectId id;
    @Field("tenhienthi")
    private String tenHienThi;
    @Indexed(unique = true)
    @Field("email")
    private String email;
    @Field("ho")
    private String ho;
    @Field("ten")
    private String ten;
    @Field("ngaysinh")
    private Date ngaySinh;
    @Field("sodienthoai")
    private String sodienthoai;
    @Field("gioitinh")
    private Boolean gioiTinh;
    @Field("anhdaidien")
    private HinhAnh anhDaiDien;
    @Field("anhbia")
    private HinhAnh anhBia;
    @Field("banbe")
    private ArrayList<BanBe> dsBanBe;
    @Field("hinhanh")
    private ArrayList<HinhAnh> dsHinhAnh;
    @Field("noisong")
    private NoiSong noiSong;
    public HoSoTaiKhoan() {

    }

    public HoSoTaiKhoan(ObjectId id, String tenHienThi, String email, String ho, String ten, Date ngaySinh, String sodienthoai,Boolean gioiTinh, HinhAnh anhDaiDien, HinhAnh anhBia, ArrayList<BanBe> dsBanBe, ArrayList<HinhAnh> dsHinhAnh,NoiSong noiSong) {
        this.id = id;
        this.tenHienThi = tenHienThi;
        this.email = email;
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.anhDaiDien = anhDaiDien;
        this.anhBia = anhBia;
        this.dsBanBe = dsBanBe;
        this.dsHinhAnh = dsHinhAnh;
        this.noiSong=noiSong;
        this.sodienthoai=sodienthoai;
        this.ngaySinh= ngaySinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTenHienThi() {
        return tenHienThi;
    }

    public void setTenHienThi(String tenHienThi) {
        this.tenHienThi = tenHienThi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public HinhAnh getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(HinhAnh anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public HinhAnh getAnhBia() {
        return anhBia;
    }

    public void setAnhBia(HinhAnh anhBia) {
        this.anhBia = anhBia;
    }

    public ArrayList<BanBe> getDsBanBe() {
        return dsBanBe;
    }

    public void setDsBanBe(ArrayList<BanBe> dsBanBe) {
        this.dsBanBe = dsBanBe;
    }

    public ArrayList<HinhAnh> getDsHinhAnh() {
        return dsHinhAnh;
    }

    public void setDsHinhAnh(ArrayList<HinhAnh> dsHinhAnh) {
        this.dsHinhAnh = dsHinhAnh;
    }

    public NoiSong getNoiSong() {
        return noiSong;
    }

    public void setNoiSong(NoiSong noiSong) {
        this.noiSong = noiSong;
    }
}
