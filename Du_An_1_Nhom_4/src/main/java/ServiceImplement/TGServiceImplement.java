/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceImplement;

import DomainModel.TacGia;
import RepositoryImplement.TGImplement;
import RepositoryInterface.TGInterface;
import ServiceInterface.TGServiceInterface;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class TGServiceImplement implements TGServiceInterface {

    private TGInterface repo = new TGImplement();

    @Override
    public ArrayList<TacGia> listTG() {
        return repo.listTG();
    }

    @Override
    public String themTG(TacGia x) {
        if (x.getTenTacGia().isBlank()) {
            return "Đang trống dữ liệu";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenTacGia().matches(regex)) {
            return "Tên chưa đúng định dạng";
        }
        boolean them = repo.themTG(x);
        if (them) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String suaTG(TacGia x) {
        if (x.getTenTacGia().isBlank()) {
            return "Đang trống dữ liệu";
        }
        String regex = "^[a-zA-Z]+$";
        if (!x.getTenTacGia().matches(regex)) {
            return "Tên chưa đúng định dạng";
        }
        boolean sua = repo.suaTG(x);
        if (sua) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public String xoaTG(TacGia x) {
        boolean xoa = repo.xoaTG(x);
        if (xoa) {
            return "Thành công";
        }
        return "Thất bại";
    }

    @Override
    public TacGia timTG(ArrayList<TacGia> list, String text) {
        TacGia x = new TacGia();
        for (TacGia z : list) {
            if (z.getTenTacGia().equals(text)) {
                x.setMaTacGia(z.getMaTacGia());
                x.setTenTacGia(z.getTenTacGia());
            }
        }
        return x;
    }

}
