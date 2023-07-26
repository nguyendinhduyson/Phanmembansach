/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImplement;

import DomainModel.DanhMuc;
import RepositoryImplement.DanhMucRepository;
import RepositoryInterface.IDanhMucRepository;
import ServiceInterface.ImanageDanhMucService;
import ViewModel.QLDanhMuc;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL 5515
 */
public class manageDanhMucService implements ImanageDanhMucService{
    
    private final IDanhMucRepository iDanhMucRepository;

    public manageDanhMucService() {
        this.iDanhMucRepository = new DanhMucRepository();
    }
    
    

    @Override
    public List<QLDanhMuc> getAll() {
        return iDanhMucRepository.getAll();
    }

    @Override
    public Integer add(DanhMuc danhMuc) {
      return iDanhMucRepository.add(danhMuc);
    }

    @Override
    public Integer delete(String maDM) {
     return iDanhMucRepository.delete(maDM);
    }

    @Override
    public Integer update(String maDM, DanhMuc danhMuc) {
     return iDanhMucRepository.update(maDM, danhMuc);
    }
    
}
