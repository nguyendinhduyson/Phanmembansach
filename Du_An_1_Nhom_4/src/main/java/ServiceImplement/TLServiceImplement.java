package ServiceImplement;

import DomainModel.TheLoai;
import RepositoryImplement.TLRepositoryImplement;
import RepositoryInterface.TLRepositoryInterface;
import ServiceInterface.TLServiceInterface;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class TLServiceImplement implements TLServiceInterface {
    
    private TLRepositoryInterface repo = new TLRepositoryImplement();
    
    @Override
    public ArrayList<TheLoai> listTL() {
        return repo.listTL();
    }
    
    @Override
    public String themTL(TheLoai x) {
        if (x.getTenTheLoai().isBlank()) {
            return "Đang trống dữ liệu";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenTheLoai().matches(regex)) {
            return "Tên chưa đúng định dạng";
        }
        ArrayList<TheLoai> list = repo.listTL();
        for (TheLoai z : list) {
            if (z.getTenTheLoai().equals(x.getTenTheLoai())) {
                return "Trùng tên thể loại";
            }
        }
        boolean them = repo.themTL(x);
        if (them) {
            return "Thành công";
        }
        return "Thất bại";
    }
    
    @Override
    public String suaTL(TheLoai x) {
        if (x.getTenTheLoai().isBlank()) {
            return "Đang trống dữ liệu";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenTheLoai().matches(regex)) {
            return "Tên chưa đúng định dạng";
        }
        boolean sua = repo.suaTL(x);
        if (sua) {
            return "Thành công";
        }
        return "Thất bại";
    }
    
    @Override
    public String xoaTL(TheLoai x) {
        boolean xoa = repo.xoaTL(x);
        if (xoa) {
            return "Thành công";
        }
        return "Thất bại";
    }
    
    @Override
    public TheLoai timTheLoai(ArrayList<TheLoai> list, String text) {
        TheLoai x = new TheLoai();
        for (TheLoai z : list) {
            if (z.getTenTheLoai().equals(text)) {
                x.setTenTheLoai(z.getTenTheLoai());
            }
        }
        return x;
    }
    
}
