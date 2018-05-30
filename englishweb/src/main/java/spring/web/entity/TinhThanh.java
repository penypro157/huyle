package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection = "tinhthanh")
public class TinhThanh {
    @Id
    private ObjectId _id;
    @Field("matinhthanh")
    private String maTinhThanh;
    @Field("tentinhthanh")
    private String tenTinhThanh;
    @Field("quanhuyen")
    private ArrayList<QuanHuyen> QuanHuyen;

    public TinhThanh(ObjectId _id, String id, String maTinhThanh, String tenTinhThanh, ArrayList<QuanHuyen> QuanHuyen) {
        this._id = _id;
        this.maTinhThanh = maTinhThanh;
        this.tenTinhThanh = tenTinhThanh;
        this.QuanHuyen = QuanHuyen;
    }

    public TinhThanh() {
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getMaTinhThanh() {
        return maTinhThanh;
    }

    public void setMaTinhThanh(String maTinhThanh) {
        this.maTinhThanh = maTinhThanh;
    }

    public String getTenTinhThanh() {
        return tenTinhThanh;
    }

    public void setTenTinhThanh(String tenTinhThanh) {
        this.tenTinhThanh = tenTinhThanh;
    }

    public ArrayList<QuanHuyen> getQuanHuyen() {
        return QuanHuyen;
    }

    public void setQuanHuyen(ArrayList<QuanHuyen> QuanHuyen) {
        this.QuanHuyen = QuanHuyen;
    }
}
