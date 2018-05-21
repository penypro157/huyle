package spring.web.entity;

public class NoiSong {
    private String tenTinhThanh;
    private String tenQuanHuyen;

    public NoiSong(String tenTinhThanh, String tenQuanHuyen) {
        this.tenTinhThanh = tenTinhThanh;
        this.tenQuanHuyen = tenQuanHuyen;
    }

    public NoiSong() {
    }

    public String getTenTinhThanh() {
        return tenTinhThanh;
    }

    public void setTenTinhThanh(String tenTinhThanh) {
        this.tenTinhThanh = tenTinhThanh;
    }

    public String getTenQuanHuyen() {
        return tenQuanHuyen;
    }

    public void setTenQuanHuyen(String tenQuanHuyen) {
        this.tenQuanHuyen = tenQuanHuyen;
    }
}
