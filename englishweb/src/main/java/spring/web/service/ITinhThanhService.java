package spring.web.service;

import org.springframework.stereotype.Service;
import spring.web.entity.NoiSong;
import spring.web.entity.QuanHuyen;
import spring.web.entity.TinhThanh;

import java.util.ArrayList;
import java.util.List;


public interface ITinhThanhService {
    List<TinhThanh> getAllTinhThanh();
    List<QuanHuyen> getQuanHuyenByTenTinhThanh(String tentinhthanh);
    boolean updateNoiSong(String email, NoiSong noiSong);
}
