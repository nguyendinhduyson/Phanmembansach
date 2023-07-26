package ServiceImplement;

import RepositoryImplement.HoaDonCTVMRepositoryInterface;
import ServiceInterface.HoaDonCTVMServiccecInterface;
import ViewModel.HoaDonCTVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonCTVMServiceImplement implements HoaDonCTVMServiccecInterface {

    private final HoaDonCTVMRepositoryInterface repo = new HoaDonCTVMRepositoryInterface();

    @Override
    public String themHDCCT(HoaDonCTVM x) {
        Boolean themHDCT = repo.themHDCT(x);
        if (themHDCT) {
            return "Thanh cong";
        }
        return "That bai";
    }

    @Override
    public ArrayList<HoaDonCTVM> getlist(Integer maHoaDon) {
        return repo.getlist(maHoaDon);
    }

}
