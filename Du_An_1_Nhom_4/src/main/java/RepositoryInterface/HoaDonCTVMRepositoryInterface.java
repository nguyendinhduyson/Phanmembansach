package RepositoryInterface;

import ViewModel.HoaDonCTVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface HoaDonCTVMRepositoryInterface {

    Boolean themHDCT(HoaDonCTVM x);

    public ArrayList<HoaDonCTVM> getlist(Integer maHoaDon);
}
