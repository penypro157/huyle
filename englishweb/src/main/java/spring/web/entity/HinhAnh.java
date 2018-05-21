package spring.web.entity;

import java.util.Date;

public class HinhAnh {
    private String duongDan;
    private Date ngayUpload;
    private long dungLuong;

    public HinhAnh(String duongDan, Date ngayUpload, long dungLuong) {
        this.duongDan = duongDan;
        this.ngayUpload = ngayUpload;
        this.dungLuong = dungLuong;
    }

    public HinhAnh() {
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }

    public Date getNgayUpload() {
        return ngayUpload;
    }

    public void setNgayUpload(Date ngayUpload) {
        this.ngayUpload = ngayUpload;
    }

    public long getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(long dungLuong) {
        this.dungLuong = dungLuong;
    }
}
