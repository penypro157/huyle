package spring.web.service;

import org.bson.types.ObjectId;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import spring.web.entity.BaiDang;
import spring.web.entity.BinhLuan;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.repo.BinhLuanRepository;

import java.util.Date;
import java.util.List;

@Service
public class BinhLuanServices implements IBinhLuanService {
    @Autowired
    BaiDangService baiDangService;
    @Autowired
    BinhLuanRepository binhLuanRepository;
    @Autowired
    HoSoTaiKhoanService hoSoTaiKhoanService;
    @Autowired
    @Qualifier("mongoTemplate")
    MongoTemplate mongoTemplate;
    @Override
    public BinhLuan addBinhLuan(BinhLuan binhLuan) {
        return null;
    }

    @Override
    public BinhLuan addBinhLuanByNoiDungAndMaBaiDang(String email, String noidung, ObjectId maBaiDang) {
        HoSoTaiKhoan hoSoTaiKhoan=hoSoTaiKhoanService.getHoSoTaiKhoanByEmail(email);
        BaiDang baiDang = baiDangService.getBaiDangById(maBaiDang);
        try {
            BinhLuan binhLuan = new BinhLuan();
            binhLuan.setNoiDung(noidung);
            binhLuan.setBaiDang(baiDang);
            binhLuan.setTaikhoan(hoSoTaiKhoan);
            binhLuan.setThoiGian(new Date());
            return binhLuanRepository.save(binhLuan);
        }catch (Exception e){


        }


        return null;
    }

    @Override
    public List<BinhLuan> getAllBinhLuanByMaBaiDang(ObjectId mabaidang) {
        List<BinhLuan> binhLuanList=null;
        Query query = new Query();
        query.addCriteria(Criteria.where("mabaidang.$id").is(mabaidang));
        try{
        binhLuanList=mongoTemplate.find(query,BinhLuan.class);
        return binhLuanList;
        }catch (Exception e){


        }
        return binhLuanList;
    }
}
