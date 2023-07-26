package RepositoryInterface;

import ViewModel.SachVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface SachVMRepositoryInterface {

    ArrayList<SachVM> listSach();

    Void capNhatSLSach(Integer soLuong, String tenSach);
}
