package spring.web.entity;

import java.util.ArrayList;

public class QuanHuyen {

    private String tenquanhuyen;


    public QuanHuyen(String tenquanhuyen) {
        this.tenquanhuyen = tenquanhuyen;
    }

    public QuanHuyen() {
    }

    public String getTenquanhuyen() {
        return tenquanhuyen;
    }

    public void setTenquanhuyen(String tenquanhuyen) {
        this.tenquanhuyen = tenquanhuyen;
    }

}
