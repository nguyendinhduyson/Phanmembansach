package ServiceInterface;

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
public interface HoaDonVMServiceInterface {

    String taoHD(HoaDonVM x);

    ArrayList<HoaDonVM> listHDVM();

    ArrayList<HoaDonVM> listHD();

    String capNhatHD(HoaDonVM x);

    ArrayList<HoaDonVM> listloc(Date ngayBatDau, Date ngayKetThuc);

    List<GioHangVM> getSach(String maHD);

    List<HoaDonVM> loadchuathanhtoan();

    List<HoaDonVM> loaddangcho();
}
