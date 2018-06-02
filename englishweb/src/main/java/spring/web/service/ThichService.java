package spring.web.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import spring.web.entity.BaiDang;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.entity.Thich;


@Service
public class ThichService implements IThichService {
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;
    @Autowired
    BaiDangService baiDangService;
    @Autowired
    @Qualifier("mongoTemplate")
    MongoTemplate mongoTemplate;
    @Override
    public boolean checkLiked(String email, ObjectId maBaiDang) {
        Thich thich=null;
        ObjectId maHoSoTaiKhoan = hoSoTaiKhoanService.getObjectIdByEmail(email);
        Query query = new Query();
        query.addCriteria(Criteria.where("taikhoan.$id").is(maHoSoTaiKhoan).and("baidang.$id").is(maBaiDang));
        try {
            thich=mongoTemplate.findOne(query,Thich.class);
            if(thich!=null) return true;


        } catch (Exception e) {


        }
        return false;
    }

    @Override
    public boolean addLikeByEmailAndMaBaiDang(String email, ObjectId maBaiDang) {
        BaiDang baiDang = baiDangService.getBaiDangById(maBaiDang);
        HoSoTaiKhoan hoSoTaiKhoan = hoSoTaiKhoanService.getHoSoTaiKhoanByEmail(email);
        Thich thich= new Thich();

        try {
            thich.setMaBaiDang(baiDang);
            thich.setTaiKhoan(hoSoTaiKhoan);
            mongoTemplate.save(thich);
            return true;

        }
        catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean deleteLikedByEmailAndMaBaiDang(String email, ObjectId maBaiDang) {
        BaiDang baiDang = baiDangService.getBaiDangById(maBaiDang);
        ObjectId maHoSoTaiKhoan=hoSoTaiKhoanService.getObjectIdByEmail(email);
        Query query = new Query();
        query.addCriteria(Criteria.where("taikhoan.$id").is(maHoSoTaiKhoan).and("baidang.$id").is(maBaiDang));
        try {
            mongoTemplate.remove(query,Thich.class);
            return true;

        }
        catch (Exception e){

        }
        return false;
    }

}
