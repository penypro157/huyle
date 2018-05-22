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
import spring.web.service.TaiKhoanService;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class RegisterController {
    @Autowired
    TaiKhoanService taiKhoanService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") TaiKhoan taiKhoan, Model model, HttpServletRequest request) {
        SendMail sendMail = new SendMail();
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
            String MD5Hash = DigestUtils.md5Hex(taiKhoan.getPassword());
            taiKhoan.setPassword(MD5Hash);
            taiKhoanService.addTaiKhoan(taiKhoan);
            model.addAttribute("notice", "Đăng ký thành công, hãy đăng nhập để sử dụng!");
            return "login";
        }
        model.addAttribute("notice", "Đăng ký không thành công, xin vui lòng thử lại.");
        return "register";
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
