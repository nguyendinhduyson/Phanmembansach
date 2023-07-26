package ServiceInterface;

import DomainModel.NPH;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface NPHServiceInterface {

    ArrayList<NPH> listNPH();

    String themNPH(NPH x);

    String suaNPH(NPH x);

    String xoaNPH(NPH x);

    NPH timNPH(ArrayList<NPH> list, String text);
}
