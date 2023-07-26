/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImplement;

import DomainModel.NXB;

import RepositoryImplement.NXBRepository;
import RepositoryInterface.INXBRepository;
import ServiceInterface.ImanageNXBService;
import ViewModel.QLNXB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL 5515
 */
public class manageNXBService implements ImanageNXBService {

    private final INXBRepository iNXBRepository;

    public manageNXBService() {
        this.iNXBRepository = new NXBRepository();
    }

    @Override
    public List<NXB> getAll() {
        return iNXBRepository.getAll();
    }

    @Override
    public Integer add(NXB nxb) {
        return iNXBRepository.add(nxb);
    }

    @Override
    public Integer delete(String maNXB) {
        return iNXBRepository.delete(maNXB);
    }

    @Override
    public Integer update(String maNXB, NXB nxb) {
        return iNXBRepository.update(maNXB, nxb);
    }

    @Override
    public NXB timNXB(List<NXB> list, String NXB) {
        NXB x = new NXB();
        for (NXB nxb : list) {
            if (nxb.getTenNXB().equals(NXB)) {
                x.setTenNXB(nxb.getTenNXB());
            }
        }
        return x;
    }

}
