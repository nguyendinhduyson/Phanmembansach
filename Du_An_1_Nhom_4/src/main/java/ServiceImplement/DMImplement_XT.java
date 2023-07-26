/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceImplement;

import DomainModel.DanhMuc;
import java.util.ArrayList;
import ServiceInterface.DMInterface_XT;

/**
 *
 * @author Xuan Truong
 */
public class DMImplement_XT implements DMInterface_XT {

    private RepositoryInterface.DMInterface_XT repo = new RepositoryImplement.DMImplement_XT();

    @Override
    public ArrayList<DanhMuc> listDM() {
        return repo.listDM();
    }

    @Override
    public String themDM(DanhMuc x) {
        if (x.getTenDM().isBlank()) {
            return "Đang trống dữ liệu";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenDM().matches(regex)) {
            return "Tên chưa đúng định dạng";
        }
        boolean them = repo.themDM(x);
        if (them) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String suaDM(DanhMuc x) {
        if (x.getTenDM().isBlank()) {
            return "Đang trống dữ liệu";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenDM().matches(regex)) {
            return "Tên chưa đúng định dạng";
        }
        boolean sua = repo.suaDM(x);
        if (sua) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String xoaDM(DanhMuc x) {
        boolean xoa = repo.xoaDM(x);
        if (xoa) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public DanhMuc timDanhMuc(ArrayList<DanhMuc> list, String text) {
        DanhMuc x = new DanhMuc();
        for (DanhMuc z : list) {
            if (z.getTenDM().equals(text)) {
                x.setTenDM(z.getTenDM());
            }
        }
        return x;
    }

}
