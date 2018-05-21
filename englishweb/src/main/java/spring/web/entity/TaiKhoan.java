package spring.web.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Document
public class TaiKhoan {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String email;
    @Field("matkhau")
    private String password;
    private String password_salt;
    @Field("maxacthucmail")
    private String maXacThucMail;
    @Field("trangthai")
    private TrangThai trangThai;
    @Field("thoigiantao")
    private Date thoiGianTao;

    public TaiKhoan(ObjectId id, String email, String password, String password_salt, String maXacThucMail, TrangThai trangThai, Date thoiGianTao) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.password_salt = password_salt;
        this.maXacThucMail = maXacThucMail;
        this.trangThai = trangThai;
        this.thoiGianTao = thoiGianTao;
    }

    public TaiKhoan() {

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_salt() {
        return password_salt;
    }

    public void setPassword_salt(String password_salt) {
        this.password_salt = password_salt;
    }

    public String getMaXacThucMail() {
        return maXacThucMail;
    }

    public void setMaXacThucMail(String maXacThucMail) {
        this.maXacThucMail = maXacThucMail;
    }

    public TrangThai getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(TrangThai trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }
}
