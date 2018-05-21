package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Date;

@Document
public class HoiThoai {
    @Id
    private ObjectId id;
    @Field("thanhvien")
    @DBRef
    private ArrayList<HoSoTaiKhoan> thanhVien;
    @Field("thoigiantao")
    private Date thoiGian;

    public HoiThoai(ObjectId id, ArrayList<HoSoTaiKhoan> thanhVien, Date thoiGian) {
        this.id = id;
        this.thanhVien = thanhVien;
        this.thoiGian = thoiGian;
    }

    public HoiThoai() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ArrayList<HoSoTaiKhoan> getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(ArrayList<HoSoTaiKhoan> thanhVien) {
        this.thanhVien = thanhVien;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        this.thoiGian = thoiGian;
    }
}
