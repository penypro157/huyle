package spring.web.entity;

import org.bson.types.ObjectId;
import org.hibernate.annotations.Cascade;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class BaiDang {
    @Id
    private ObjectId id;
    @Field("nguoidang")
    @DBRef(lazy = false)
    private HoSoTaiKhoan hoSoTaiKhoan;
    @Field("noidung")
    private String noiDung;
    @Field("hinhanh")
    private ArrayList<HinhAnh> dsHinhAnh;
    @Field("chiase")
    @DBRef
    private ObjectId chiaSe;
    @Field("thoigian")
    private Date thoiGian;
    @Field("luotthich")
    private long luotThich;
    @Field("luotbinhluan")
    private long luotBinhLuan;
    @Field("luotchiase")
    private long luotChiaSe;
    @Field("dsthich")
    @DBRef
    private List<Thich> dsThich;
    @Field("dsbinhluan")
    @DBRef
    private List<BinhLuan> dsBinhLuan;
    @Field("dschiase")
    @DBRef
    private List<ChiaSe> dsChiaSe;

    public BaiDang() {
    }

    public BaiDang(ObjectId id, HoSoTaiKhoan hoSoTaiKhoan, String noiDung, ArrayList<HinhAnh> dsHinhAnh, ObjectId chiaSe, Date thoiGian, long luotThich, long luotBinhLuan, long luotChiaSe, List<Thich> dsThich, List<BinhLuan> dsBinhLuan, List<ChiaSe> dsChiaSe) {
        this.id = id;
        this.hoSoTaiKhoan = hoSoTaiKhoan;
        this.noiDung = noiDung;
        this.dsHinhAnh = dsHinhAnh;
        this.chiaSe = chiaSe;
        this.thoiGian = thoiGian;
        this.luotThich = luotThich;
        this.luotBinhLuan = luotBinhLuan;
        this.luotChiaSe = luotChiaSe;
        this.dsThich = dsThich;
        this.dsBinhLuan = dsBinhLuan;
        this.dsChiaSe = dsChiaSe;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public HoSoTaiKhoan getHoSoTaiKhoan() {
        return hoSoTaiKhoan;
    }

    public void setHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan) {
        this.hoSoTaiKhoan = hoSoTaiKhoan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public ArrayList<HinhAnh> getDsHinhAnh() {
        return dsHinhAnh;
    }

    public void setDsHinhAnh(ArrayList<HinhAnh> dsHinhAnh) {
        this.dsHinhAnh = dsHinhAnh;
    }

    public ObjectId getChiaSe() {
        return chiaSe;
    }

    public void setChiaSe(ObjectId chiaSe) {
        this.chiaSe = chiaSe;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public long getLuotThich() {
        return luotThich;
    }

    public void setLuotThich(long luotThich) {
        this.luotThich = luotThich;
    }

    public long getLuotBinhLuan() {
        return luotBinhLuan;
    }

    public void setLuotBinhLuan(long luotBinhLuan) {
        this.luotBinhLuan = luotBinhLuan;
    }

    public long getLuotChiaSe() {
        return luotChiaSe;
    }

    public void setLuotChiaSe(long luotChiaSe) {
        this.luotChiaSe = luotChiaSe;
    }

    public List<Thich> getDsThich() {
        return dsThich;
    }

    public void setDsThich(List<Thich> dsThich) {
        this.dsThich = dsThich;
    }

    public List<BinhLuan> getDsBinhLuan() {
        return dsBinhLuan;
    }

    public void setDsBinhLuan(List<BinhLuan> dsBinhLuan) {
        this.dsBinhLuan = dsBinhLuan;
    }

    public List<ChiaSe> getDsChiaSe() {
        return dsChiaSe;
    }

    public void setDsChiaSe(List<ChiaSe> dsChiaSe) {
        this.dsChiaSe = dsChiaSe;
    }
}
