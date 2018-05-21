package spring.web.entity;

public class QuanHuyen {
    private String maQuanHuyen;
    private String tenQuanHuyen;

    public QuanHuyen(String maQuanHuyen, String tenQuanHuyen) {
        this.maQuanHuyen = maQuanHuyen;
        this.tenQuanHuyen = tenQuanHuyen;
    }

    public QuanHuyen() {
    }

    public String getMaQuanHuyen() {
        return maQuanHuyen;
    }

    public void setMaQuanHuyen(String maQuanHuyen) {
        this.maQuanHuyen = maQuanHuyen;
    }

    public String getTenQuanHuyen() {
        return tenQuanHuyen;
    }

    public void setTenQuanHuyen(String tenQuanHuyen) {
        this.tenQuanHuyen = tenQuanHuyen;
    }
}
