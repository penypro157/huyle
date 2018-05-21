package spring.web.service;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.entity.TaiKhoan;
import spring.web.repo.TaiKhoanRepo;

@Service
public class TaiKhoanService implements ITaiKhoanService {
    @Autowired
    TaiKhoanRepo taiKhoanRepo;

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


}

