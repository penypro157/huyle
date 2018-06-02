package spring.web.controller;

import org.apache.commons.io.FilenameUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.web.beans.IAuthentication;
import spring.web.entity.BaiDang;
import spring.web.entity.HinhAnh;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.service.BaiDangService;
import spring.web.service.HoSoTaiKhoanService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Controller
public class DangBaiController {
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;
    @Autowired
    BaiDangService baiDangService;
    @Autowired
    IAuthentication authentication;
    @RequestMapping(value = "/dangbai", method = RequestMethod.POST)
    public @ResponseBody
    BaiDang uploadBaiDang(@RequestParam("noidung") String noidung1, @RequestParam("fileanh") List<MultipartFile> files, HttpServletRequest request) {
        byte ptext[] = new byte[0];
        try {
            ptext = noidung1.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String noidung = new String(ptext, UTF_8);
        String email = authentication.getAuthentication().getName();
        String rootPath = request.getServletContext().getRealPath("");
        String uploadFolder = "\\resources\\image\\baidang\\";
        BaiDang baiDang = null;
        ArrayList<String> tenhinhanh=null;
        try{
            tenhinhanh=uploadHinhAnh(files,rootPath,uploadFolder);
                baiDang=setNoiDungBaiDang(tenhinhanh,noidung);
                baiDang.setThoiGian(new Date());
                baiDang.setHoSoTaiKhoan(getNguoiDang(email));
                if(setHinhAnhHoSoTaiKhoan(email,tenhinhanh)) {

                    return baiDangService.addBaiDang(baiDang);

                }



        }catch (Exception e){
            System.out.println(e);
        }

        return null;
    }
    public ArrayList<String> uploadHinhAnh(List<MultipartFile> multipartFiles,String rootPath, String folderUpload){
        ArrayList<String> dstenhinhanh= new ArrayList<>();
        for (MultipartFile multipartFile: multipartFiles
             ) {
            if(multipartFile.getSize()==0) break;
            String format= FilenameUtils.getExtension(multipartFile.getOriginalFilename());
            String tenhinhanh= new ObjectId().toString()+"."+format;
            File file= new File(rootPath+folderUpload+tenhinhanh);
            try {
                multipartFile.transferTo(file);
                dstenhinhanh.add(tenhinhanh);
            } catch (IOException e) {
                return null;
            }

        }
        return dstenhinhanh;
    }

    public BaiDang setNoiDungBaiDang( List<String> tenhinhanh, String noidung) {
        BaiDang baiDang = new BaiDang();
        ArrayList<HinhAnh> hinhAnhList = new ArrayList<>();
        if(tenhinhanh!=null)
        for (String ten : tenhinhanh
                ) {
            HinhAnh hinhAnh = new HinhAnh();
            hinhAnh.setNgayUpload(new Date());
            hinhAnh.setDuongDan(ten);
            hinhAnhList.add(hinhAnh);
        }
        baiDang.setDsHinhAnh(hinhAnhList);
        baiDang.setNoiDung(noidung);
        return baiDang;




    }
    public HoSoTaiKhoan getNguoiDang(String email){
        HoSoTaiKhoan hoSoTaiKhoan= null;
        try{
            Query query = new Query();
            query.addCriteria(Criteria.where("email").is(email));
            hoSoTaiKhoan= hoSoTaiKhoanService.getHoSoTaiKhoan(query);
            return  hoSoTaiKhoan;
        }catch (Exception e){


        }
            return  hoSoTaiKhoan;
    }

    public boolean setHinhAnhHoSoTaiKhoan(String email, List<String> tenhinhanh) {


        for (String ten : tenhinhanh
                ) {
            HinhAnh hinhAnh = new HinhAnh();
            hinhAnh.setDuongDan(ten);
            hinhAnh.setNgayUpload(new Date());
            Update update = new Update();
            Query query = new Query();
            update.push("hinhanh", hinhAnh);
            query.addCriteria(Criteria.where("email").is(email));
            try {

                hoSoTaiKhoanService.updateHoSoTaiKhoan(query, update);

            } catch (Exception e) {

                return false;
            }

        }


        return true;

    }
    @RequestMapping(value = "/xembaidang")
    public @ResponseBody
    List<BaiDang> getBaiDang(){
    List<BaiDang> baiDangList = null;
    return baiDangList;

    }
}
