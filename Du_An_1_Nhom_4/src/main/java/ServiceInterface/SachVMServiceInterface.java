package ServiceInterface;

import ViewModel.SachVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface SachVMServiceInterface {

    ArrayList<SachVM> listSach();

    ArrayList<SachVM> listSearch(ArrayList<SachVM> list, String text);

    Void capNhatSoSach(Integer soLuong, String tenSach);
}
