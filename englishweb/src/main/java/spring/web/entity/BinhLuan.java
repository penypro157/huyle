package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;

@Document
public class BinhLuan {
    @Id
    private ObjectId id;
    @Field("noidung")
    private String noiDung;
    @Field("taikhoan")
    @DBRef
    private HoSoTaiKhoan taikhoan;
    @Field("thoigian")
    private Date thoiGian;
    @Field("mabaidang")
    @DBRef
    private BaiDang maBaiDang;

    public BinhLuan(ObjectId id, String noiDung, HoSoTaiKhoan taikhoan, Date thoiGian, BaiDang maBaiDang) {
        this.id = id;
        this.noiDung = noiDung;
        this.taikhoan = taikhoan;
        this.thoiGian = thoiGian;
        this.maBaiDang = maBaiDang;
    }

    public BinhLuan() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public HoSoTaiKhoan getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(HoSoTaiKhoan taikhoan) {
        this.taikhoan = taikhoan;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }

    public BaiDang getMaBaiDang() {
        return maBaiDang;
    }

    public void setMaBaiDang(BaiDang maBaiDang) {
        this.maBaiDang = maBaiDang;
    }
}
