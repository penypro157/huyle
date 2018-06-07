package spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.service.HoSoTaiKhoanService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;
    @RequestMapping(value = "timkiemthanhvien",method = RequestMethod.GET)
    public String searchMember(Model model, @RequestParam("muctimkiem") String muctimkiem, @RequestParam("noidung") String noidung){
        List<HoSoTaiKhoan> hoSoTaiKhoans = new ArrayList<>();
        try{
            if(muctimkiem.equals("email")){
                HoSoTaiKhoan hoSoTaiKhoan =null;
                hoSoTaiKhoan=hoSoTaiKhoanService.getHoSoTaiKhoanByEmail(noidung);
                if(hoSoTaiKhoan!=null)
                hoSoTaiKhoans.add(hoSoTaiKhoan);

            };
            if(muctimkiem.equals("tenhienthi")){
                hoSoTaiKhoans=hoSoTaiKhoanService.getHoSoTaiKhoanByTenHienThiLike(noidung);
            }

        }
        catch (Exception e){

        }
        model.addAttribute("result",hoSoTaiKhoans);
        model.addAttribute("soluong",hoSoTaiKhoans.size());
        return "resultsearch";
    }
}
