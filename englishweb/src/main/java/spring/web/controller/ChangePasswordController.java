package spring.web.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.web.beans.IAuthentication;
import spring.web.service.TaiKhoanService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ChangePasswordController {
    @Autowired
    IAuthentication authentication;
    @Autowired
    TaiKhoanService taiKhoanService;

    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request, Model model, HttpServletResponse response) {
        String email = authentication.getAuthentication().getName();
        String matKhauCu = request.getParameter("matkhaucu");
        String matKhauMoi = request.getParameter("matkhaumoi");
        try {
            if (checkOldPassword(email, matKhauCu)) {
                if (changePassword(email, matKhauMoi)) {
                    new SecurityContextLogoutHandler().logout(request, response, authentication.getAuthentication());
                    model.addAttribute("notice", "Đổi mật khẩu thành công, đăng nhập lại để sử dụng");
                    return "login";
                }

            }

        } catch (Exception e) {

        }

        return "404";
    }

    public boolean checkOldPassword(String email, String oldPassword) {
        String MD5Hash = DigestUtils.md5Hex(oldPassword);
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email).and("matkhau").is(MD5Hash));
        try {
            return taiKhoanService.exist(query);

        } catch (Exception e) {

        }
        return false;


    }

    public boolean changePassword(String email, String newPassword) {
        String Md5Hash = DigestUtils.md5Hex(newPassword);
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        Update update = new Update();
        update.set("matkhau", Md5Hash);
        try {
            return taiKhoanService.updateTaiKhoan(query, update);

        } catch (Exception e) {


        }
        return false;


    }


}
