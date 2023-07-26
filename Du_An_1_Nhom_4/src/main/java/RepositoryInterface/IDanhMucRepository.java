/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RepositoryInterface;

import DomainModel.DanhMuc;
import ViewModel.QLDanhMuc;
import java.util.List;

/**
 *
 * @author DELL 5515
 */
public interface IDanhMucRepository {
    List<QLDanhMuc> getAll();
    Integer add(DanhMuc danhMuc);
    Integer delete(String maDM);
    Integer update(String maDM, DanhMuc danhMuc);
}
