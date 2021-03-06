package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document
public class ChiaSe {
    @Id
    private ObjectId id;
    @Field("taikhoan")
    @DBRef(lazy = true)
    private HoSoTaiKhoan taiKhoan;
    @Field("thoigian")
    private Date thoiGian;
    @Field("mabaidang")
    @DBRef(lazy = true)
    private BaiDang maBaiDang;

    public ChiaSe(ObjectId id, HoSoTaiKhoan taiKhoan, Date thoiGian, BaiDang maBaiDang) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.thoiGian = thoiGian;
        this.maBaiDang = maBaiDang;
    }

    public ChiaSe() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public HoSoTaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(HoSoTaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
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
