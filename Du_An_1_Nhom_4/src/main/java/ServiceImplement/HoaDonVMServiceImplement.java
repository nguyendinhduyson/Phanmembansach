package ServiceImplement;

import RepositoryImplement.HoaDonVMRepositoryImplement;
import RepositoryInterface.HoaDomVMRepositoryInterface;
import ServiceInterface.HoaDonVMServiceInterface;
import ViewModel.GioHangVM;
import ViewModel.HoaDonVM;
import ViewModel.SachVM;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonVMServiceImplement implements HoaDonVMServiceInterface {

    private HoaDomVMRepositoryInterface repo = new HoaDonVMRepositoryImplement();

    @Override
    public String taoHD(HoaDonVM x) {
        boolean taoHD = repo.taoHoaDon(x);
        if (taoHD) {
            return "Tao hoa don thanh cong";
        }
        return "Tao HD that bai";
    }

    @Override
    public ArrayList<HoaDonVM> listHDVM() {
        return repo.listHDVM();
    }

    @Override
    public String capNhatHD(HoaDonVM x) {
        boolean capNhatHD = repo.capNhatHoaDon(x);
        if (capNhatHD) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public List<GioHangVM> getSach(String maHD) {
        return repo.getSach(maHD);
    }

    @Override
    public List<HoaDonVM> loadchuathanhtoan() {
        return repo.loadchuathanhtoan();
    }

    @Override
    public List<HoaDonVM> loaddangcho() {
        return repo.loaddangcho();
    }

    @Override
    public ArrayList<HoaDonVM> listloc(Date ngayBatDau, Date ngayKetThuc) {
        return repo.listloc(ngayBatDau, ngayKetThuc);
    }

    @Override
    public ArrayList<HoaDonVM> listHD() {
        return repo.listHD();
    }

}
