package ServiceInterface;

import DomainModel.TheLoai;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface TLServiceInterface {

    ArrayList<TheLoai> listTL();

    String themTL(TheLoai x);

    String suaTL(TheLoai x);

    String xoaTL(TheLoai x);

    TheLoai timTheLoai(ArrayList<TheLoai> list, String text);
}
