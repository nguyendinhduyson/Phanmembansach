package ServiceInterface;

import java.util.ArrayList;
import DomainModel.NhanVien;
import ViewModel.NhanVienRespone;

/**
 *
 * @author Xuan Truong
 */
public interface NhanVienService {

    ArrayList<NhanVienRespone> listNhanVien();

    String themNhanVien(NhanVien x);

    String xoaNhanVien(Integer maNhanVien);

    String suaNhanVien(NhanVien x,Integer maNhanVien);

}
