/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepositoryInterface;

import DomainModel.TacGia;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface TGInterface {

    ArrayList<TacGia> listTG();

    Boolean themTG(TacGia x);

    Boolean suaTG(TacGia x);

    Boolean xoaTG(TacGia x);
}
