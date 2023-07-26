/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepositoryInterface;

import DomainModel.NPH;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public interface NPHRepositoryInterface {

    ArrayList<NPH> listNPH();

    Boolean themNPH(NPH x);

    Boolean suaNPH(NPH x);

    Boolean xoaNPH(NPH x);
}
