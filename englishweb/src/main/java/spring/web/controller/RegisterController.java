package spring.web.controller;

import com.mongodb.Bytes;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;
import spring.web.beans.Mail;
import spring.web.beans.SendMail;
import spring.web.beans.VerifyMail;
import spring.web.entity.*;
import spring.web.repo.CountryRepo;

import spring.web.repo.LanguageRepo;
import spring.web.repo.TaiKhoanRepo;
import spring.web.service.HoSoTaiKhoanService;
import spring.web.service.TaiKhoanService;


import javax.servlet.http.HttpServletRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class RegisterController {
    @Autowired
    TaiKhoanService taiKhoanService;
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") TaiKhoan taiKhoan, Model model, HttpServletRequest request) {
        SendMail sendMail = new SendMail();
        HoSoTaiKhoan hoSoTaiKhoan= new HoSoTaiKhoan();
        String verifyCode = sendMail.generateRandomString(30);
        Mail mail = new VerifyMail(taiKhoan.getEmail(), verifyCode);
        if (taiKhoanService.getTaiKhoanByEmail(taiKhoan.getEmail()) != null) {
            model.addAttribute("result", false);
            return "register";
        }
        if (sendMail.sendMail(mail)) {
            TrangThai trangThai = new TrangThai(1, false, false);
            taiKhoan.setTrangThai(trangThai);
            taiKhoan.setMaXacThucMail(verifyCode);
            taiKhoan.setThoiGianTao(new Date());
            String MD5Hash = DigestUtils.md5Hex(taiKhoan.getPassword());
            taiKhoan.setPassword(MD5Hash);
            taiKhoanService.addTaiKhoan(taiKhoan);
            hoSoTaiKhoan.setEmail(taiKhoan.getEmail());
            hoSoTaiKhoan.setTenHienThi(getNameFromEmail(taiKhoan.getEmail()));
            hoSoTaiKhoan.setAnhDaiDien(new HinhAnh("tempory.png",new Date(),0));
            hoSoTaiKhoanService.addHoSoTaiKhoan(hoSoTaiKhoan);
            model.addAttribute("notice", "Đăng ký thành công, hãy đăng nhập để sử dụng!");
            return "login";
        }
        model.addAttribute("notice", "Đăng ký không thành công, xin vui lòng thử lại.");
        return "register";
    }
    public String getNameFromEmail(String email){
        int position=0;
        StringBuilder string= new StringBuilder(email);
        for(int i=0;i<email.length();i++){
            char s=email.charAt(i);
            if(Character.toString(s).equals("@")){
                position=i;
            }

        }
        return string.substring(0,position);
    }
    @RequestMapping(value = "/active")
    public String activeAccount(@RequestParam("code") String code) {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("maxacthucmail").is(code));
            Update update = new Update();
            update.set("maxacthucmail", null);
            update.set("trangthai.active",true);
            update.set("trangthai.verified",true);
            taiKhoanService.updateTaiKhoan(query, update);
            return "login";
        } catch (Exception e) {
        }


        return "404";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new TaiKhoan());
        return "register";
    }
}
