package spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.web.entity.HinhAnh;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.service.BaiDangService;
import spring.web.service.HoSoTaiKhoanService;

import java.util.List;

@Controller
public class PhotoController {
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;
    @Autowired
    BaiDangService baiDangService;
    @RequestMapping(value = "/hinhanh",method = RequestMethod.GET)
    public String getHinhAnh(@RequestParam("email")String email,Model model){
        HoSoTaiKhoan hoSoTaiKhoan = hoSoTaiKhoanService.getHoSoTaiKhoanByEmail(email);
        List<HinhAnh> hinhAnhList= null;
        long soluongbaidang=0;
        long soluonghinhanh=0;
        try{
            soluonghinhanh= baiDangService.getSoLuongBaiDang(email);
    hinhAnhList=hoSoTaiKhoan.getDsHinhAnh();
    soluongbaidang=hoSoTaiKhoan.getDsHinhAnh().size();
model.addAttribute("images",hinhAnhList);
model.addAttribute("soluongbaidang",soluongbaidang);
            model.addAttribute("soluonghinhanh",soluonghinhanh);
return "gallery";
        }catch (Exception e){


        }
    return "404";
    }

}
