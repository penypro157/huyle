package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Thich {
    @Id
    private ObjectId id;
    @Field("taikhoan")
    @DBRef
    private HoSoTaiKhoan taiKhoan;
    @Field("baidang")
    @DBRef
    private BaiDang maBaiDang;

    public Thich(ObjectId id, HoSoTaiKhoan taiKhoan, BaiDang maBaiDang) {
        this.id = id;
        this.taiKhoan = taiKhoan;
        this.maBaiDang = maBaiDang;
    }

    public Thich() {
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

    public BaiDang getMaBaiDang() {
        return maBaiDang;
    }

    public void setMaBaiDang(BaiDang maBaiDang) {
        this.maBaiDang = maBaiDang;
    }
}
