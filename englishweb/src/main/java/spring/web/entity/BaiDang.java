package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

@Document
public class BaiDang {
    @Id
    private ObjectId id;
    @DBRef
    private ObjectId nguoiDang;
    private String noiDung;
    private ArrayList<HinhAnh> dsHinhAnh;
    @DBRef
    private ObjectId chiaSe;
    private Date thoiGian;
    private long luotThich;
    private long luotBinhLuan;
    protected long luotChiaSe;

    public BaiDang(ObjectId id, ObjectId nguoiDang, String noiDung, ArrayList<HinhAnh> dsHinhAnh, ObjectId chiaSe, Date thoiGian, long luotThich, long luotBinhLuan, long luotChiaSe) {
        this.id = id;
        this.nguoiDang = nguoiDang;
        this.noiDung = noiDung;
        this.dsHinhAnh = dsHinhAnh;
        this.chiaSe = chiaSe;
        this.thoiGian = thoiGian;
        this.luotThich = luotThich;
        this.luotBinhLuan = luotBinhLuan;
        this.luotChiaSe = luotChiaSe;
    }

    public BaiDang() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getNguoiDang() {
        return nguoiDang;
    }

    public void setNguoiDang(ObjectId nguoiDang) {
        this.nguoiDang = nguoiDang;
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
}
