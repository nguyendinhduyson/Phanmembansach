package ServiceImplement;

import RepositoryImplement.SachVMRepositoryImplement;
import RepositoryInterface.SachVMRepositoryInterface;
import ServiceInterface.SachVMServiceInterface;
import ViewModel.SachVM;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class SachVMServiceImplement implements SachVMServiceInterface {

    private final SachVMRepositoryInterface repo = new SachVMRepositoryImplement();

    @Override
    public ArrayList<SachVM> listSach() {
        return repo.listSach();
    }

    @Override
    public ArrayList<SachVM> listSearch(ArrayList<SachVM> list, String text) {
        ArrayList<SachVM> listSach = repo.listSach();
        ArrayList<SachVM> listSearch = new ArrayList<>();
        for (SachVM x : listSearch) {
            if (text.contains(x.getTenSach())) {
                listSearch.add(x);
            }
        }
        return listSearch;
    }

    @Override
    public Void capNhatSoSach(Integer soLuong, String tenSach) {
        return repo.capNhatSLSach(soLuong, tenSach);
    }

}
