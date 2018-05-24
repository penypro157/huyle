package spring.web.controller;

import com.sun.net.httpserver.HttpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.web.beans.IAuthentication;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.service.HoSoTaiKhoanService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    IAuthentication authentication;
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(Model model) {
        HoSoTaiKhoan hoSoTaiKhoan = null;
        String email = authentication.getAuthentication().getName();
        if (email != null)
            try {
                Query query = new Query();
                query.addCriteria(Criteria.where("email").is(email));
                query.fields().exclude("banbe");
                query.fields().exclude("hinhanh");
                hoSoTaiKhoan = hoSoTaiKhoanService.getHoSoTaiKhoan(query);
                System.out.println(hoSoTaiKhoan.getGioiTinh());
                model.addAttribute("hosotaikhoan", hoSoTaiKhoan);
                return "profile";

            } catch (Exception e) {
            }


        return "404";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public @ResponseBody
    boolean saveProfile(@RequestBody HoSoTaiKhoan hoSoTaiKhoan) {
        String email = authentication.getAuthentication().getName();
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        Update update = getUpdate(hoSoTaiKhoan);
        System.out.println(update.getUpdateObject().toString());
        try {
            hoSoTaiKhoanService.updateHoSoTaiKhoan(query, update);

            return true;
        } catch (Exception e) {

        }

        return false;
    }

    public Update getUpdate(HoSoTaiKhoan hoSoTaiKhoan) {
        Update update = new Update();
        try {
            update.set("email", hoSoTaiKhoan.getEmail());
            update.set("tenhienthi", hoSoTaiKhoan.getTenHienThi());
            update.set("ten", hoSoTaiKhoan.getTen());
            update.set("ho", hoSoTaiKhoan.getHo());
            update.set("sodienthoai", hoSoTaiKhoan.getSodienthoai());
            update.set("gioitinh", hoSoTaiKhoan.getGioiTinh());
            return update;
        } catch (Exception e) {
        }


        return update;
    }

}
