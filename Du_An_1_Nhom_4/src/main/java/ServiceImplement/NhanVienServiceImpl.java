package ServiceImplement;

import DomainModel.NhanVien;
import RepositoryImplement.NhanVienRepository;
import ServiceInterface.NhanVienService;
import ViewModel.NhanVienRespone;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class NhanVienServiceImpl implements NhanVienService {

    private final NhanVienRepository repo = new NhanVienRepository();

    @Override
    public ArrayList<NhanVienRespone> listNhanVien() {
        return repo.listNhanVien();
    }

    @Override
    public String themNhanVien(NhanVien x) {
        if (x.getDiaChi().isBlank() || x.getMatKhau().isBlank() || x.getNgaySinh().isEmpty() || x.getSDT().isBlank() || x.getTaiKhoan().isBlank() || x.getTenNhanVien().isBlank()) {
            return "Đang trống dữ liệu";
        }
        String regex = "^[a-zA-Z]*$";
        String SDT = "^0[0-9]{9}";
        if (!x.getTenNhanVien().matches(regex)) {
            return "Tên nhân viên sai định dạng";
        }
        if (!x.getSDT().matches(SDT)) {
            return "SDT sai định dạng";
        }
        boolean themNhanVien = repo.themNhanVien(x);
        if (themNhanVien) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String xoaNhanVien(Integer maNhanVien) {
        boolean xoaNhanVien = repo.xoaNhanVien(maNhanVien);
        if (xoaNhanVien) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public String suaNhanVien(NhanVien x, Integer maNhanVien) {
        if (x.getDiaChi().isBlank() || x.getMatKhau().isBlank() || x.getNgaySinh().isEmpty() || x.getSDT().isBlank() || x.getTaiKhoan().isBlank() || x.getTenNhanVien().isBlank()) {
            return "Đang trống dữ liệu";
        }
        String regex = "^[a-zA-Z]*$";
        String SDT = "^0[0-9]{9}";
        if (!x.getTenNhanVien().matches(regex)) {
            return "Tên nhân viên sai định dạng";
        }
        if (!x.getSDT().matches(SDT)) {
            return "SDT sai định dạng";
        }
        boolean suaNhanVien = repo.suaNhanVien(x, maNhanVien);
        if (suaNhanVien) {
            return "Thanh cong";
        }
        return "That bai";
    }

}
