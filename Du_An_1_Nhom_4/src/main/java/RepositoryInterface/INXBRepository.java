/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryInterface;

import DomainModel.NXB;
import java.util.List;

/**
 *
 * @author DELL 5515
 */
public interface INXBRepository {

    List<NXB> getAll();

    Integer add(NXB nxb);

    Integer delete(String maNXB);

    Integer update(String maNXB, NXB nxb);
}
