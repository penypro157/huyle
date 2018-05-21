package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document
public class TinhThanh {
    @Id
    private ObjectId id;
    @Field("matinhthanh")
    @Indexed(unique = true)
    private String maTinhThanh;
    @Field("tentinhthanh")
    private String tenTinhThanh;
    @Field("quanhuyen")
    private ArrayList<QuanHuyen> dsQuanHuyen;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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

    public ArrayList<QuanHuyen> getDsQuanHuyen() {
        return dsQuanHuyen;
    }

    public void setDsQuanHuyen(ArrayList<QuanHuyen> dsQuanHuyen) {
        this.dsQuanHuyen = dsQuanHuyen;
    }
}
