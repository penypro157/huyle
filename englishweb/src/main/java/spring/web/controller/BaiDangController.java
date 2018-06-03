package spring.web.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.web.beans.IAuthentication;
import spring.web.entity.BaiDang;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.service.BaiDangService;
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
    @RequestMapping(value = "/thich",method = RequestMethod.GET)
    public @ResponseBody boolean thichBaiDang(@RequestParam("mabaidang") ObjectId mabaidang){
    String email= authentication.getAuthentication().getName();
    if(thichService.checkLiked(email,mabaidang)) {boThich(email,mabaidang); return false;}
    else thich(email,mabaidang);

return true;
    }
    public synchronized void thich(String email, ObjectId maBaiDang){
    thichService.addLikeByEmailAndMaBaiDang(email, maBaiDang);
    baiDangService.addLikeCount(maBaiDang,1);
        HoSoTaiKhoan hoSoTaiKhoan= hoSoTaiKhoanService.getHoSoTaiKhoanByEmail(email);
    baiDangService.updateDSThich(maBaiDang,hoSoTaiKhoan);
    }
    public synchronized void boThich(String email, ObjectId maBaiDang){
        thichService.deleteLikedByEmailAndMaBaiDang(email, maBaiDang);
        baiDangService.deleteNguoiDangFromDsThich(hoSoTaiKhoanService.getObjectIdByEmail(email),maBaiDang);
        baiDangService.addLikeCount(maBaiDang,-1);
    }

    @RequestMapping(value = "/getbaidang",method = RequestMethod.GET)
    public @ResponseBody
    List<BaiDang> getBaiDang(@RequestParam("email") String email){
        List<BaiDang> baiDangList =null;
        if(email.equals("")) {
            email=authentication.getAuthentication().getName();
        }
        try{
            baiDangList=baiDangService.getBaiDangByEmail(email);
            return  baiDangList;
        } catch (Exception e){


        }
        return baiDangList;
    }
    @RequestMapping(value = "/luotthich",method = RequestMethod.GET)
    public @ResponseBody long getLuotThich(@RequestParam("mabaidang") ObjectId maBaiDang){
        long luotThich=0;
        BaiDang baiDang=null;
        try{
          baiDang=  baiDangService.getSpecifyElementFromBaiDang(maBaiDang,"luotthich");
          luotThich=baiDang.getLuotThich();
          return luotThich;
        }catch (Exception e){

        }

    return 0;
    }


}
