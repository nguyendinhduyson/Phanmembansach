/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServiceImplement;

import DomainModel.Sach;
import RepositoryImplement.SachRepositoryImplement;
import ServiceInterface.SachService;
import ViewModel.SachViewmodel;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public class SachserviceImpl implements SachService {
    
    private SachRepositoryImplement cc = new SachRepositoryImplement();
    
    @Override
    public ArrayList<SachViewmodel> getlist() {
        return cc.getlist();
    }
    
    @Override
    public String add(Sach s) {
        boolean them = cc.add(s);
        if (them) {
            return "Thanh cong";
        }
        return "That bai";
    }
    
    @Override
    public String update(Sach s, int ma) {
        boolean sua = cc.update(s, ma);
        if (sua) {
            return "Thanh cong";
        }
        return "That bai";
    }
    
    @Override
    public String delete(int ma) {
        boolean xoa = cc.delete(ma);
        if (xoa) {
            return "Thanh cong";
        }
        return "That bai";
    }
    
    @Override
    public ArrayList<SachViewmodel> listSearch(ArrayList<SachViewmodel> list, String text) {
        ArrayList<SachViewmodel> listSearch = new ArrayList<>();
        for (SachViewmodel x : list) {
            if (x.getTensach().contains(text)) {
                listSearch.add(x);
            }
        }
        return listSearch;
    }
    
    @Override
    public ArrayList<SachViewmodel> listLoc(ArrayList<SachViewmodel> list, String text) {
        ArrayList<SachViewmodel> listLoc = new ArrayList<>();
        for (SachViewmodel x : list) {
            if (x.getTenTheLoai().equalsIgnoreCase(text) || x.getTenTacGia().equalsIgnoreCase(text) || x.getTenNXB().equalsIgnoreCase(text) || x.getTenNPH().equalsIgnoreCase(text) || x.getTenDanhMuc().equalsIgnoreCase(text) || x.getNhomTuoi().equalsIgnoreCase(text)) {
                listLoc.add(x);
            }
        }
        return listLoc;
    }
    
}
