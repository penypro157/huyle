package spring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.web.entity.*;
import spring.web.repo.CountryRepo;

import spring.web.repo.LanguageRepo;
import spring.web.repo.TaiKhoanRepo;
import spring.web.service.TaiKhoanService;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class RegisterController {
    @Autowired
    TaiKhoanService taiKhoanService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") TaiKhoan taiKhoan, Model model, HttpServletRequest request) {
        if (taiKhoanService.getTaiKhoanByEmail(taiKhoan.getEmail()) != null) {
            model.addAttribute("result", false);
            return "register";
        }
        TrangThai trangThai= new TrangThai(1,true,false);
        taiKhoan.setTrangThai(trangThai);
        if(taiKhoanService.addTaiKhoan(taiKhoan))
        return "login";
        model.addAttribute("notice","Dang ky khong thanh cong, xin moi nguoi dung thu lai");
        return "register";

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new TaiKhoan());
        return "register";
    }
}
