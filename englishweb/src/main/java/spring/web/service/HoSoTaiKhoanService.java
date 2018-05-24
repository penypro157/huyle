package spring.web.service;

import com.mongodb.Mongo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import spring.web.entity.HinhAnh;
import spring.web.entity.HoSoTaiKhoan;
import spring.web.entity.TaiKhoan;
import spring.web.repo.HoSoTaiKhoanRepository;

@Service
public class HoSoTaiKhoanService implements IHoSoTaiKhoanService {
    @Autowired
    HoSoTaiKhoanRepository hoSoTaiKhoanRepository;
    @Autowired
    @Qualifier(value = "mongoTemplate")
    MongoTemplate mongoTemplate;

    @Override
    public HoSoTaiKhoan getHoSoTaiKhoanById(ObjectId id) {
        HoSoTaiKhoan hoSoTaiKhoan = null;
        try {
            hoSoTaiKhoan = hoSoTaiKhoanRepository.findById(id);
            return hoSoTaiKhoan;
        } catch (Exception e) {

        }
        return hoSoTaiKhoan;
    }

    @Override
    public HoSoTaiKhoan getHoSoTaiKhoanByEmail(String email) {

        HoSoTaiKhoan hoSoTaiKhoan = null;
        try {
            hoSoTaiKhoan = hoSoTaiKhoanRepository.findByEmail(email);
            return hoSoTaiKhoan;
        } catch (Exception e) {

        }
        return hoSoTaiKhoan;
    }

    @Override
    public HoSoTaiKhoan getHoSoTaiKhoan(Query query) {
        HoSoTaiKhoan hoSoTaiKhoan= null;
        try{
            hoSoTaiKhoan=mongoTemplate.findOne(query,HoSoTaiKhoan.class);
            return hoSoTaiKhoan;

        }
        catch (Exception e){


        }
        return hoSoTaiKhoan;

    }

    @Override
    public boolean updateHoSoTaiKhoan(Query query, Update update) {
        try {
            mongoTemplate.findAndModify(query,update,HoSoTaiKhoan.class);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean updateHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan) {
        try {
            hoSoTaiKhoanRepository.save(hoSoTaiKhoan);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean deleteHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan) {
        try {
            hoSoTaiKhoanRepository.delete(hoSoTaiKhoan);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean setAnhDaiDien(HinhAnh hinhAnh) {
        return false;
    }

    @Override
    public boolean setAnhBia(HinhAnh hinhAnh) {
        return false;
    }

    @Override
    public boolean deleteHoSoTaiKhoanByEmail(String email) {
        try {

            hoSoTaiKhoanRepository.deleteByEmail(email);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean deleteHoSoTaiKhoanById(ObjectId id) {
        try {

            hoSoTaiKhoanRepository.deleteById(id);
            return true;
        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean addHoSoTaiKhoan(HoSoTaiKhoan hoSoTaiKhoan) {
        try {

            hoSoTaiKhoanRepository.save(hoSoTaiKhoan);
            return true;
        } catch (Exception e) {

        }
        return false;
    }


}
