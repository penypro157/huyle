package spring.web.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.service.HoSoTaiKhoanService;

@Controller
public class AddFriendController {
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;

    @RequestMapping(value = "/addfriend", method = RequestMethod.GET)
    public boolean addFriend(@RequestParam("mahosotaikhoan") ObjectId id) {
        HoSoTaiKhoan hoSoTaiKhoan = hoSoTaiKhoanService.getHoSoTaiKhoanById(id);
        try {

//            if (hoSoTaiKhoanService.addBanBe(hoSoTaiKhoan,)) return true;
        } catch (Exception e) {
        }
        return false;

    }
}
