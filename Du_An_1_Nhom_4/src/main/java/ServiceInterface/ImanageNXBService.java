/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceInterface;

import DomainModel.NXB;
import ViewModel.QLNXB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL 5515
 */
public interface ImanageNXBService {

    List<NXB> getAll();

    Integer add(NXB nxb);

    Integer delete(String maNXB);

    Integer update(String maNXB, NXB nxb);

    NXB timNXB(List<NXB> list, String NXB);
}
