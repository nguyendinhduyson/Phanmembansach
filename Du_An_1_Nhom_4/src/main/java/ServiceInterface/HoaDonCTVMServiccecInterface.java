package ServiceInterface;

import ViewModel.HoaDonCTVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface HoaDonCTVMServiccecInterface {

    String themHDCCT(HoaDonCTVM x);

    public ArrayList<HoaDonCTVM> getlist(Integer maHoaDon);
}
