package spring.web.controller;

import com.sun.net.httpserver.HttpServer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.web.beans.IAuthentication;
import spring.web.beans.ImageHandler;
import spring.web.entity.HinhAnh;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.service.HoSoTaiKhoanService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

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
    String setImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
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
                    deleteImage(rootPath,uploadFolder);
                        if (setHinhAnh(email, imageName)) {

                            return imageName;
                        }
                    }


            } catch (IOException e) {

            }

        }


        return "";
    }

    public boolean deleteImage(String roothPath,String uploadFolder) {
        String email = authentication.getAuthentication().getName();
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        query.fields().include("anhdaidien.duongDan");
        HoSoTaiKhoan hoSoTaiKhoan = hoSoTaiKhoanService.getHoSoTaiKhoan(query);
        try {
            String tenAnh = hoSoTaiKhoan.getAnhDaiDien().getDuongDan();
            System.out.println(tenAnh);
            if (ImageHandler.deleteImage(roothPath,uploadFolder, tenAnh))
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

}
