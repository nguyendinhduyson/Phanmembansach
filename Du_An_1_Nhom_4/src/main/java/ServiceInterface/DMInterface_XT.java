/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceInterface;

import DomainModel.DanhMuc;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface DMInterface_XT {

    ArrayList<DanhMuc> listDM();

    String themDM(DanhMuc x);

    String suaDM(DanhMuc x);

    String xoaDM(DanhMuc x);

    DanhMuc timDanhMuc(ArrayList<DanhMuc> list, String text);
}
