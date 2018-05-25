package spring.web.service;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import spring.web.entity.TaiKhoan;
import spring.web.repo.TaiKhoanRepo;

@Service
public class TaiKhoanService implements ITaiKhoanService {
    @Autowired
    TaiKhoanRepo taiKhoanRepo;
    @Autowired
    @Qualifier(value = "mongoTemplate")
    MongoTemplate mongoTemplate;

    @Override
    public TaiKhoan getTaiKhoanById(ObjectId id) {
        TaiKhoan taiKhoan = null;
        try {
            taiKhoan = taiKhoanRepo.findById(id);
            return taiKhoan;
        } catch (Exception e) {

        }
        return taiKhoan;
    }

    @Override
    public TaiKhoan getTaiKhoanByEmail(String email) {
        TaiKhoan taiKhoan = null;
        try {
            taiKhoan=taiKhoanRepo.findByEmail(email);
            return taiKhoan;
        } catch (Exception e){


        }
        return taiKhoan;
    }

    @Override
    public boolean updateTaiKhoan(TaiKhoan taiKhoan) {
        try{
        taiKhoanRepo.save(taiKhoan);
        return true;

        }
        catch (Exception e){
            return  false;
        }
    }

    @Override
    public boolean addTaiKhoan(TaiKhoan taiKhoan) {
        try{
            taiKhoanRepo.save(taiKhoan);
            return true;

        }
        catch (Exception e){
            return  false;
        }
    }

    @Override
    public boolean deleteTaiKhoan(TaiKhoan taiKhoan) {
        try{
            taiKhoanRepo.delete(taiKhoan);
            return true;

        }
        catch (Exception e){
            return  false;
        }
    }


    @Override
    public boolean updateTaiKhoan(Query query, Update update) {
        try{
            mongoTemplate.findAndModify(query,update,TaiKhoan.class);
            return true;
        }
        catch (Exception e){


        }
        return false;

    }

    @Override
    public boolean exist(Query query) {
        try{
    mongoTemplate.exists(query,TaiKhoan.class);
    return true;

        }
        catch (Exception e){

        }
        return false;
    }


}


