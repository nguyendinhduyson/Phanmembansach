/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImplement;

import DomainModel.SanPhamLoi;
import RepositoryInterface.ISanPhamLoiRepository;
import RepositoryImplement.SanPhamLoiRepository;
import ServiceInterface.ImanageSanPhamLoiService;
import ViewModel.QLSanPhamLoi;
import java.util.List;




/**
 *
 * @author DELL 5515
 */
public class SanPhamLoiService implements ImanageSanPhamLoiService{
    private final ISanPhamLoiRepository iSanPhamLoiRepository;

    public SanPhamLoiService() {
        this.iSanPhamLoiRepository = new SanPhamLoiRepository();
    }

    @Override
    public List<QLSanPhamLoi> getAll() {
        return iSanPhamLoiRepository.getAll();
    }

    @Override
    public Integer add(SanPhamLoi sp) {
        return iSanPhamLoiRepository.add(sp);
    }

    @Override
    public Integer delete(String maspl) {
        return iSanPhamLoiRepository.delete(maspl);
    }

    @Override
    public Integer update(String maspl, SanPhamLoi sp) {
       return iSanPhamLoiRepository.update(maspl, sp);
    }
    
    
    
}
