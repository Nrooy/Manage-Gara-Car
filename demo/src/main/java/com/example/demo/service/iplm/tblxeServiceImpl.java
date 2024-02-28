package com.example.demo.service.iplm;
import com.example.demo.service.tblXeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.responsitory.tblxeResponsitory;
import com.example.demo.entities.tblxe;
import com.example.demo.entities.tblnguoidung;


import java.util.List;
import java.util.Optional;

@Service
public class tblxeServiceImpl implements tblXeService{
    @Autowired
    private tblxeResponsitory tblxeResponsitory;

    @Override
    public tblxe retrieve(Integer Id){return tblxeResponsitory.findById(Id).orElse(null);}
    @Override
    public List<tblxe> getAll(){return tblxeResponsitory.findAll();}

    @Override
    public void creat(tblxe xe) {

        xe.setTen(xe.getTen());
        xe.setMauxe(xe.getMauxe());
        xe.setBienso(xe.getBienso());
        xe.setMota(xe.getMota());

        tblxeResponsitory.save(xe);
    }

    @Override
    public Page<tblxe> getAll1(Pageable pageable){return tblxeResponsitory.findAll(pageable);}

    @Override
    public tblxe findById(Integer Id){
        Optional <tblxe> optional =tblxeResponsitory.findById(Id);
        tblxe xe = null;
        if(optional.isPresent()){
            xe= optional.get();
        }else{
            throw new RuntimeException("Không tìm thấy xe" + Id);
        }
        return xe;
    }

    @Override
    public tblxe findByBienSo(String bienso) {
        return tblxeResponsitory.findByBienso(bienso);
    }

    @Override
    public void delete(Integer id){
        tblxe xe =new tblxe();
        xe = tblxeResponsitory.findById(id).orElse(null);
        if(xe != null){
            xe.getTblxedasuas().clear();
            tblxeResponsitory.delete(xe);
        }
    }
    @Override
    public void saveTblXe(tblxe xe){
        tblxe existingXe = tblxeResponsitory.findById(xe.getId()).orElse(null);

        if (existingXe != null) {
            existingXe.setTen(xe.getTen());
            existingXe.setMauxe(xe.getMauxe());
            existingXe.setBienso(xe.getBienso());
            existingXe.setMota(xe.getMota());
            tblxeResponsitory.save(existingXe);
        } else {
            throw new EntityNotFoundException("Không tìm thấy đối tượng tblxe với id " + xe.getId());
        }
    }

    @Override
    public List<tblxe> getAllXeCuaNguoiDung(Integer Id) {
        return tblxeResponsitory.getAllXeCuaNguoiDung(Id);
    }

    @Override
    public Page<tblxe> dosearch(String keyword, Pageable pageable){return tblxeResponsitory.dosearch(keyword,pageable);}


}
