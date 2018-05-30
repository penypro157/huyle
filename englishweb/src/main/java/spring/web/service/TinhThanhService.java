package spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.entity.NoiSong;
import spring.web.entity.QuanHuyen;
import spring.web.entity.TinhThanh;
import spring.web.repo.TinhThanhRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class TinhThanhService  implements ITinhThanhService{
    @Autowired
    TinhThanhRepository tinhThanhRepository;
    @Autowired
    @Qualifier(value = "mongoTemplate")
    MongoTemplate mongoTemplate;
    @Override
    public List<TinhThanh> getAllTinhThanh() {
        List<TinhThanh> tinhThanhs=null;
        Query query = new Query();
        query.fields().include("tentinhthanh");
        try
        {   tinhThanhs=mongoTemplate.find(query,TinhThanh.class);
        return tinhThanhs;

        }
        catch (Exception e){

        }

        return tinhThanhs;
    }

    @Override
    public List<QuanHuyen> getQuanHuyenByTenTinhThanh(String tentinhthanh) {
        List<QuanHuyen> quanHuyenList=null;
        TinhThanh tinhThanh=null;
        Query query = new Query();
        query.addCriteria(Criteria.where("tentinhthanh").is(tentinhthanh));
        query.with(new Sort("tentinhthanh","1"));
        try{
            tinhThanh=mongoTemplate.findOne(query,TinhThanh.class);
            quanHuyenList=tinhThanh.getQuanHuyen();
            return quanHuyenList;
        }
        catch (Exception e){


        }
        return null;
    }

    @Override
    public boolean updateNoiSong(String email, NoiSong noiSong) {
        Query query = new Query();
        Update update = new Update();
        update.set("noisong",noiSong);
        query.addCriteria(Criteria.where("email").is(email));
        try{
            mongoTemplate.updateFirst(query,update,HoSoTaiKhoan.class);
            return  true;

        }
        catch (Exception e){
            System.out.println("có lỗi rồi kìa đmmm");
            System.out.println(e);
        }
        return false;
    }
}
