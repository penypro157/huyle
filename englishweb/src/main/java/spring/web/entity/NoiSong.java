package spring.web.entity;

public class NoiSong {
    private String tentinhthanh;
    private String matinhthanh;
    private QuanHuyen quanhuyen;

    public NoiSong(String tentinhthanh, String matinhthanh, QuanHuyen quanhuyen) {
        this.tentinhthanh = tentinhthanh;
        this.matinhthanh = matinhthanh;
        this.quanhuyen = quanhuyen;
    }

    public NoiSong() {
    }

    public String getTentinhthanh() {
        return tentinhthanh;
    }

    public void setTentinhthanh(String tentinhthanh) {
        this.tentinhthanh = tentinhthanh;
    }

    public String getMatinhthanh() {
        return matinhthanh;
    }

    public void setMatinhthanh(String matinhthanh) {
        this.matinhthanh = matinhthanh;
    }

    public QuanHuyen getQuanhuyen() {
        return quanhuyen;
    }

    public void setQuanhuyen(QuanHuyen quanhuyen) {
        this.quanhuyen = quanhuyen;
    }
}
