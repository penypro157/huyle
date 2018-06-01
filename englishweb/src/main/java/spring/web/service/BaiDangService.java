package spring.web.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import spring.web.entity.BaiDang;
import spring.web.repo.BaiDangRepository;

import java.util.ArrayList;

@Service
public class BaiDangService implements IBaiDangService {
    @Autowired
    BaiDangRepository baiDangRepository;
    @Autowired
    @Qualifier("mongoTemplate")
    MongoTemplate mongoTemplate;


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
    public boolean updateBaiDang(Query query, Update update) {
        try{


        }catch (Exception e){


        }
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
    public BaiDang getBaiDangById(ObjectId id) {
        return null;
    }

    @Override
    public ArrayList<BaiDang> getBaiDangByNguoiDang(ObjectId id) {
        return null;
    }

    @Override
    public ArrayList<BaiDang> getBaiDangByEmail(String email) {
        return null;
    }
}
