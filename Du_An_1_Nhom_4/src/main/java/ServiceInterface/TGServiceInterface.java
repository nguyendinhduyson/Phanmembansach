/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceInterface;

import DomainModel.TacGia;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface TGServiceInterface {

    ArrayList<TacGia> listTG();

    String themTG(TacGia x);

    String suaTG(TacGia x);

    String xoaTG(TacGia x);

    TacGia timTG(ArrayList<TacGia> list, String text);
}
