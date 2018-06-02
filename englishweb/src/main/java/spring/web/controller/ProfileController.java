package spring.web.controller;

import org.apache.commons.io.FilenameUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.web.beans.IAuthentication;
import spring.web.beans.ImageHandler;
import spring.web.entity.*;
import spring.web.service.BaiDangService;
import spring.web.service.HoSoTaiKhoanService;
import spring.web.service.TinhThanhService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.System;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    IAuthentication authentication;
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;
    @Autowired
    TinhThanhService tinhThanhService;
    @Autowired
    BaiDangService baiDangService;
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(Model model) {
        HoSoTaiKhoan hoSoTaiKhoan = null;
        List<TinhThanh> tinhThanhs = null;
        String email = authentication.getAuthentication().getName();
        if (email != null)
            try {
                Query query = new Query();
                query.addCriteria(Criteria.where("email").is(email));
                query.fields().exclude("banbe");
                query.fields().exclude("hinhanh");
                hoSoTaiKhoan = hoSoTaiKhoanService.getHoSoTaiKhoan(query);
                System.out.println(hoSoTaiKhoan.getGioiTinh());
                tinhThanhs = tinhThanhService.getAllTinhThanh();
                model.addAttribute("hosotaikhoan", hoSoTaiKhoan);
                model.addAttribute("tinhthanh", tinhThanhs);
                System.out.println(hoSoTaiKhoan.getNgaySinh());
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
            update.set("ngaysinh", hoSoTaiKhoan.getNgaySinh());
            return update;
        } catch (Exception e) {
        }


        return update;
    }

    @RequestMapping(value = "/uploadimage", method = RequestMethod.POST)
    public @ResponseBody
    String setImage(@RequestParam("avatar-file") MultipartFile file, HttpServletRequest request) {
        String email = authentication.getAuthentication().getName();
        String rootPath = request.getServletContext().getRealPath("");
        String uploadFolder = "\\resources\\image\\hinhdaidien\\";
        File imageFile = null;
        try {
            imageFile = convertToFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String formatName = ImageHandler.getFormatName(imageFile);
        if (!file.isEmpty()) {
            try {
                BufferedImage image = ImageIO.read(imageFile);
                String imageName = new ObjectId().toString() + "." + formatName;
                if (ImageIO.write(image, formatName, new File(rootPath + uploadFolder + imageName))) {
                    deleteImage(rootPath, uploadFolder);
                    if (setHinhAnh(email, imageName)) {

                        return imageName;
                    }
                }


            } catch (IOException e) {

            }

        }


        return "";
    }

    public boolean deleteImage(String roothPath, String uploadFolder) {
        String email = authentication.getAuthentication().getName();
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        query.fields().include("anhdaidien.duongDan");
        HoSoTaiKhoan hoSoTaiKhoan = hoSoTaiKhoanService.getHoSoTaiKhoan(query);
        try {
            String tenAnh = hoSoTaiKhoan.getAnhDaiDien().getDuongDan();
            System.out.println(tenAnh);
            if (ImageHandler.deleteImage(roothPath, uploadFolder, tenAnh))
                return true;

        } catch (Exception e) {

        }
        return false;
    }

    public boolean setHinhAnh(String email, String tenhinhanh) {
        HinhAnh hinhAnh = new HinhAnh(tenhinhanh, new Date(), 0);
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        Update update = new Update();
        try {
            update.set("anhdaidien", hinhAnh);
            hoSoTaiKhoanService.updateHoSoTaiKhoan(query, update);
            return true;
        } catch (Exception e) {

        }

        return false;

    }

    public File convertToFile(MultipartFile multipartFile) throws IOException {
        File convFile = new File(multipartFile.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        return convFile;

    }

    @RequestMapping(value = "/tinhthanh", method = RequestMethod.GET)
    public @ResponseBody
    List<QuanHuyen> getQuanHuyen(@RequestParam("tentinhthanh") String tentinhthanh) {
        List<QuanHuyen> quanHuyenList = null;
        try {
            quanHuyenList = tinhThanhService.getQuanHuyenByTenTinhThanh(tentinhthanh);
            return quanHuyenList;

        } catch (Exception e) {

        }
        return quanHuyenList;


    }

    @RequestMapping(value = "/noisong", method = RequestMethod.GET)
    public @ResponseBody boolean saveNoiSong(@RequestParam("tentinhthanh") String tentinhthanh, @RequestParam("tenquanhuyen") String tenquanhuyen) {
        String email = authentication.getAuthentication().getName();
        QuanHuyen quanHuyen = new QuanHuyen();

        NoiSong noiSong = new NoiSong();
        quanHuyen.setTenquanhuyen(tenquanhuyen);
        noiSong.setTentinhthanh(tentinhthanh);
        noiSong.setQuanhuyen(quanHuyen);
        try {

            if (tinhThanhService.updateNoiSong(email, noiSong)) {
                System.out.println("thành công");return true;}

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("thất bại");
        return false;
    }
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String upload(@RequestParam("file") MultipartFile multipartFile){
        File file = new File("E:\\image1.mp4");
        try {
            multipartFile.transferTo(file);
            BaiDang baiDang = new BaiDang();
                baiDang=baiDangService.getBaiDangById(new ObjectId("5b110d95e7bcf9386eb448a8"));
            return baiDang.getHoSoTaiKhoan().getEmail();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }

}
