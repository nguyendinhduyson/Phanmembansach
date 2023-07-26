package RepositoryInterface;

import DomainModel.Sach;
import ViewModel.SachViewmodel;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface SachRepositoryInterface {

    ArrayList<SachViewmodel> listSach();

    Boolean themSach(Sach x);

    Boolean suaSach(Sach x, Integer maSach);

    Boolean xoaSach(Integer maSach);
}
