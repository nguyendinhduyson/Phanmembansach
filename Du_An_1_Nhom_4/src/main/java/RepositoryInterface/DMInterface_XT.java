package RepositoryInterface;

import DomainModel.DanhMuc;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface DMInterface_XT {

    ArrayList<DanhMuc> listDM();

    Boolean themDM(DanhMuc x);

    Boolean suaDM(DanhMuc x);

    Boolean xoaDM(DanhMuc x);
}
