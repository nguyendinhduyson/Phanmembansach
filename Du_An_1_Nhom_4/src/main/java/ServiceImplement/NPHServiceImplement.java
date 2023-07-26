package ServiceImplement;

import DomainModel.NPH;
import DomainModel.TacGia;
import RepositoryImplement.NPHRepositoryImplement;
import RepositoryInterface.NPHRepositoryInterface;
import java.util.ArrayList;
import ServiceInterface.NPHServiceInterface;

/**
 *
 * @author Xuan Truong
 */
public class NPHServiceImplement implements NPHServiceInterface {

    private NPHRepositoryInterface repo = new NPHRepositoryImplement();

    @Override
    public ArrayList<NPH> listNPH() {
        return repo.listNPH();
    }

    @Override
    public String themNPH(NPH x) {
        if (x.getTenNPH().isBlank()) {
            return "Ten NPH khong duoc de trong";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenNPH().matches(regex)) {
            return "Ten NPH sai dinh dang";
        }
        ArrayList<NPH> list = repo.listNPH();
        for (NPH z : list) {
            if (z.getTenNPH().equals(x.getTenNPH())) {
                return "Trùng NPH đã có";
            }
        }
        boolean them = repo.themNPH(x);
        if (them) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String suaNPH(NPH x) {
        if (x.getTenNPH().isBlank()) {
            return "Ten NPH khong duoc de trong";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenNPH().matches(regex)) {
            return "Ten NPH sai dinh dang";
        }
        boolean sua = repo.suaNPH(x);
        if (sua) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String xoaNPH(NPH x) {
        boolean xoa = repo.xoaNPH(x);
        if (xoa) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public NPH timNPH(ArrayList<NPH> list, String text) {
        NPH x = new NPH();
        for (NPH z : list) {
            if (z.getTenNPH().equals(text)) {
                x.setTenNPH(z.getTenNPH());
            }
        }
        return x;
    }

}
