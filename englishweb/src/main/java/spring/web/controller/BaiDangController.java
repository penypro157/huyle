package spring.web.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.web.beans.IAuthentication;
import spring.web.entity.BaiDang;
import spring.web.entity.BinhLuan;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.service.BaiDangService;
import spring.web.service.IBinhLuanService;
import spring.web.service.HoSoTaiKhoanService;
import spring.web.service.ThichService;

import java.util.List;

@Controller
public class BaiDangController {
    @Autowired
    IAuthentication authentication;
    @Autowired
    BaiDangService baiDangService;
    @Autowired
    ThichService thichService;
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;
    @Autowired
    IBinhLuanService binhLuanService;

    @RequestMapping(value = "/thich", method = RequestMethod.GET)
    public @ResponseBody
    boolean thichBaiDang(@RequestParam("mabaidang") ObjectId mabaidang) {
        String email = authentication.getAuthentication().getName();
        if (thichService.checkLiked(email, mabaidang)) {
            boThich(email, mabaidang);
            return false;
        } else thich(email, mabaidang);

        return true;
    }

    public synchronized void thich(String email, ObjectId maBaiDang) {
        thichService.addLikeByEmailAndMaBaiDang(email, maBaiDang);
        baiDangService.addLikeCount(maBaiDang, 1);
//        HoSoTaiKhoan hoSoTaiKhoan = hoSoTaiKhoanService.getHoSoTaiKhoanByEmail(email);
//        baiDangService.updateDSThich(maBaiDang, hoSoTaiKhoan);
    }

    public synchronized void boThich(String email, ObjectId maBaiDang) {
        thichService.deleteLikedByEmailAndMaBaiDang(email, maBaiDang);
//        baiDangService.deleteNguoiDangFromDsThich(hoSoTaiKhoanService.getObjectIdByEmail(email), maBaiDang);
        baiDangService.addLikeCount(maBaiDang, -1);
    }

    @RequestMapping(value = "/getbaidang", method = RequestMethod.GET)
    public @ResponseBody
    List<BaiDang> getBaiDang(@RequestParam("email") String email) {
        List<BaiDang> baiDangList = null;
        if (email.equals("")) {
            email = authentication.getAuthentication().getName();
        }
        try {
            baiDangList = baiDangService.getBaiDangByEmail(email);
            return baiDangList;
        } catch (Exception e) {


        }
        return baiDangList;
    }

    @RequestMapping(value = "/luotthich", method = RequestMethod.GET)
    public @ResponseBody
    long getLuotThich(@RequestParam("mabaidang") ObjectId maBaiDang) {
        long luotThich = 0;
        BaiDang baiDang = null;
        try {
            baiDang = baiDangService.getSpecifyElementFromBaiDang(maBaiDang, "luotthich");
            luotThich = baiDang.getLuotThich();
            return luotThich;
        } catch (Exception e) {

        }

        return 0;
    }

    @RequestMapping(value = "/luotbinhluan", method = RequestMethod.GET)
    public @ResponseBody
    long getLuotBinhLuan(@RequestParam("mabaidang") ObjectId maBaiDang) {
        long luotBinhLuan = 0;
        BaiDang baiDang = null;
        try {
            baiDang = baiDangService.getSpecifyElementFromBaiDang(maBaiDang, "luotbinhluan");
            luotBinhLuan = baiDang.getLuotBinhLuan();
            return luotBinhLuan;
        } catch (Exception e) {

        }

        return 0;
    }

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public @ResponseBody
    BinhLuan binhLuan(@RequestParam("noidung") String noidung, @RequestParam("mabaidang") ObjectId id) {
//        byte ptext[] = new byte[0];
//        try {
//            ptext = noidung1.getBytes("ISO-8859-1");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        String noidung = new String(ptext, UTF_8);
        BinhLuan binhLuan = null;
        String email = authentication.getAuthentication().getName();
        try {

            binhLuan = binhLuanService.addBinhLuanByNoiDungAndMaBaiDang(email, noidung, id);
            baiDangService.upadteDSComment(id, binhLuan);
            baiDangService.addCommentCount(id, 1);
        } catch (Exception e) {
        }
        return binhLuan;
    }

    @RequestMapping(value = "/getcomment", method = RequestMethod.GET)
    public @ResponseBody
    List<BinhLuan> getAllBinhLuan(@RequestParam("mabaidang") ObjectId mabaidang) {
        List<BinhLuan> binhLuanList = null;
        try {
            binhLuanList = binhLuanService.getAllBinhLuanByMaBaiDang(mabaidang);
            return binhLuanList;

        } catch (Exception e) {

        }
        return binhLuanList;

    }

    @RequestMapping(value = "/deletebaidang", method = RequestMethod.GET)
    public @ResponseBody
    boolean deleteBaiDang(@RequestParam("mabaidang") ObjectId mabaidang) {
        String currentemail = authentication.getAuthentication().getName();
        BaiDang baiDang = baiDangService.getBaiDangById(mabaidang);
        HoSoTaiKhoan hoSoTaiKhoan= hoSoTaiKhoanService.getHoSoTaiKhoan( new Query().addCriteria(Criteria.where("_id").is(baiDang.getHoSoTaiKhoan().getId())));
        try {

            if(hoSoTaiKhoan.getEmail().equals(currentemail))
            {
                if(baiDangService.deleteBaiDangByMaBaiDang(mabaidang))
                    return true;

            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return false;



    }

}
