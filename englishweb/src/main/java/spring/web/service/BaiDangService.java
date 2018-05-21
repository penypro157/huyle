package spring.web.service;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.entity.BaiDang;
import spring.web.repo.BaiDangRepository;

import java.util.ArrayList;

@Service
public class BaiDangService implements IBaiDangService {
    @Autowired
    BaiDangRepository baiDangRepository;
    @Override
    public boolean addBaiDang(BaiDang baiDang) {
        try{
                baiDangRepository.save(baiDang);
                return true;
        } catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean deleteBaiDang(BaiDang baiDang) {
        try{
            baiDangRepository.delete(baiDang);
            return true;
        } catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean updateBaiDang(BaiDang baiDang) {
        try{
            baiDangRepository.save(baiDang);
            return true;
        } catch (Exception e){

        }
        return false;
    }

    @Override
    public boolean deleteBaiDangById(ObjectId id) {
        try{
            baiDangRepository.deleteById(id);
            return true;
        } catch (Exception e){

        }
        return false;
    }

    @Override
    public BaiDang getBaiDangById(ObjectId id) {
        BaiDang baiDang=null;
        try{

           baiDang=baiDangRepository.findById(id);
           return baiDang;
        } catch (Exception e){

        }
        return baiDang;
    }

    @Override
    public ArrayList<BaiDang> getBaiDangByNguoiDang(ObjectId id) {

        ArrayList<BaiDang> listBaiDang=null;
        try{

            listBaiDang=baiDangRepository.findByNguoiDang(id);
            return listBaiDang;
        } catch (Exception e){

        }
        return listBaiDang;
    }

    @Override
    public ArrayList<BaiDang> getBaiDangByEmail(String email) {
        return null;
    }
}
