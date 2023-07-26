
package RepositoryInterface;

import DomainModel.TheLoai;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface TLRepositoryInterface {

    ArrayList<TheLoai> listTL();

    Boolean themTL(TheLoai x);

    Boolean suaTL(TheLoai x);

    Boolean xoaTL(TheLoai x);
}
