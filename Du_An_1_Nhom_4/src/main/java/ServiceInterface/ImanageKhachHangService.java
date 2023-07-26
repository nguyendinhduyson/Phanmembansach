/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ServiceInterface;

import DomainModel.KhachHang;
import ViewModel.QLKhachHang;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL 5515
 */
public interface ImanageKhachHangService {

    List<QLKhachHang> getAll();

    Integer add(KhachHang kh);

    Integer delete(String maKH);

    Integer update(String maKH, KhachHang kh);

    List<QLKhachHang> listSearch(List<QLKhachHang> list, String text);

    KhachHang timKH(String SDT);
}
