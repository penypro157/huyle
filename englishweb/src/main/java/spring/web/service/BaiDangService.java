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
import spring.web.entity.BinhLuan;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.entity.Thich;
import spring.web.repo.BaiDangRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaiDangService implements IBaiDangService {
    @Autowired
    BaiDangRepository baiDangRepository;
    @Autowired
    @Qualifier("mongoTemplate")
    MongoTemplate mongoTemplate;
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;

    @Override
    public BaiDang addBaiDang(BaiDang baiDang) {
        BaiDang baiDang1=null;
        try {
            baiDang1=baiDangRepository.save(baiDang);
            return baiDang1;
        }
        catch (Exception e){

        }
        return baiDang1;
    }

    @Override
    public boolean updateBaiDang(BaiDang baiDang) {
        return false;
    }


    @Override
    public boolean deleteBaiDangById(ObjectId id) {
        return false;
    }

    @Override
    public boolean deleteBaiDang(Query query) {
        return false;
    }

    @Override
    public boolean deleteNguoiDangFromDsThich(ObjectId maHoSoTaiKhoan, ObjectId maBaiDang) {

        Query query= new Query();
        query.addCriteria(Criteria.where("_id").is(maBaiDang));
        Update update = new Update();
        update.pull("dsthich",Query.query(Criteria.where("_id").is(maHoSoTaiKhoan)));
        try{
        mongoTemplate.updateFirst(query,update,BaiDang.class);
        return true;
        }catch (Exception e){


        }
        return false;
    }

    @Override
    public BaiDang getBaiDangById(ObjectId id) {
        try{

        return baiDangRepository.findById(id);
        }
        catch (Exception e){

        }
        return null;
    }

    @Override
    public BaiDang getSpecifyElementFromBaiDang(ObjectId maBaiDang, String nameField) {
        BaiDang baiDang = null;
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(maBaiDang));
        query.fields().include(nameField);
        query.fields().include("_id");
        try
        {
        baiDang=mongoTemplate.findOne(query,BaiDang.class);
        return baiDang;
        }catch (Exception e){

        }
        return null;
    }

    @Override
    public ArrayList<BaiDang> getBaiDangByNguoiDang(ObjectId id) {
        return null;
    }

    @Override
    public List<BaiDang> getBaiDangByEmail(String email) {

        List<BaiDang> baiDangs=null;
        Query query = new Query();
        ObjectId maHoSoTaiKhoan= hoSoTaiKhoanService.getObjectIdByEmail(email);
                query.addCriteria(Criteria.where("nguoidang.$id").is(maHoSoTaiKhoan));
        try{
            baiDangs=mongoTemplate.find(query,BaiDang.class);
        return baiDangs;
        }
        catch (Exception e){


        }
        return null;
    }

    @Override
    public void addLikeCount(ObjectId maBaiDang, int quantity) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(maBaiDang));
        Update update= new Update();
        update.inc("luotthich",quantity);
        try{
            mongoTemplate.updateFirst(query,update,BaiDang.class);
        }catch (Exception e){

        }
    }

    @Override
    public void addCommentCount(ObjectId maBaiDang, int quantity) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(maBaiDang));
        Update update = new Update();
        update.inc("luotbinhluan",quantity);
        try{
            mongoTemplate.updateFirst(query,update,BaiDang.class);
        }
        catch (Exception e){


        }
    }

    @Override
    public void updateDSThich(ObjectId maBaiDang, HoSoTaiKhoan hoSoTaiKhoan) {

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(maBaiDang));
        Update update = new Update();
        update.push("dsthich",hoSoTaiKhoan);
        try{
        mongoTemplate.updateFirst(query,update,BaiDang.class);
        }
        catch (Exception e){


        }
    }

    @Override
    public void upadteDSComment(ObjectId maBaiDang, BinhLuan binhLuan) {

        try{
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(maBaiDang));
            Update update =new Update();
            update.push("dsbinhluan",binhLuan);
            mongoTemplate.updateFirst(query,update,BaiDang.class);

        }
        catch (Exception e){

        }
    }

    @Override
    public long getSoLuongBaiDang(String email) {
        long soluongbaidang=0;
        ObjectId maHoSoTaiKhoan=hoSoTaiKhoanService.getObjectIdByEmail(email);
        Query query = new Query();
        query.addCriteria(Criteria.where("nguoidang.$id").is(maHoSoTaiKhoan));
        try{
            soluongbaidang = mongoTemplate.count(query,BaiDang.class);
            return soluongbaidang;

        }catch (Exception e){

        }
        return soluongbaidang;
    }

    @Override
    public boolean deleteBaiDangByMaBaiDang(ObjectId mabaidang) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(mabaidang));
        try{
            mongoTemplate.findAllAndRemove(query,BaiDang.class);
            return true;
        }
        catch (Exception e){


        }
        return false;
    }

}
