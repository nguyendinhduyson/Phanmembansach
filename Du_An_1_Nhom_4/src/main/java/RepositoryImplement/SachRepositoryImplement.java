/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryImplement;

import DomainModel.Sach;
import Utilities.DBConection;
import ViewModel.SachViewmodel;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public class SachRepositoryImplement {

    public ArrayList<SachViewmodel> getlist() {
        ArrayList<SachViewmodel> list = new ArrayList<>();
        String sql = "SELECT SACH.MaSach, SACH.TenSach, DANHMUC.TenDM, THELOAI.TenTL, NPH.TenNPH, TACGIA.TenTG, NXB.TenNXB, SACH.NamXuatBan, SACH.NgonNgu, SACH.NhomTuoi, SACH.TaiBan, SACH.SoTrang, SACH.GiaBan, \n"
                + "SACH.SoLuong, SACH.TrangThai\n"
                + "FROM DANHMUC INNER JOIN SACH ON DANHMUC.MaDM = SACH.MaDM INNER JOIN NPH ON SACH.MaNPH = NPH.MaNPH INNER JOIN NXB ON SACH.MaNXB = NXB.MaNXB INNER JOIN TACGIA ON SACH.MaTG = TACGIA.MaTG INNER JOIN THELOAI ON SACH.MaTL = THELOAI.MaTL";
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new SachViewmodel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getFloat(13), rs.getInt(14), rs.getInt(15)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean add(Sach s) {
        String sql = "INSERT INTO [dbo].[SACH]([TenSach],[MaDM],[MaTL],[MaNPH],[MaTG],[MaNXB],[NamXuatBan],[NgonNgu],[NhomTuoi],[TaiBan],[SoTrang],[GiaBan],[SoLuong],[TrangThai])\n"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, s.getTensach());
            ps.setObject(2, s.getMaDanhMuc());
            ps.setObject(3, s.getMaTheLoai());
            ps.setObject(4, s.getMaNPH());
            ps.setObject(5, s.getMaTacGia());
            ps.setObject(6, s.getMaNXB());
            ps.setObject(7, s.getNamxuatban());
            ps.setObject(8, s.getNgonNgu());
            ps.setObject(9, s.getNhomTuoi());
            ps.setObject(10, s.getTaiBan());
            ps.setObject(11, s.getSotrang());
            ps.setObject(12, s.getGiaban());
            ps.setObject(13, s.getSoluong());
            ps.setObject(14, s.getTrangthai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;

    }

    public Boolean update(Sach s, int ma) {
        String sql = "UPDATE [dbo].[SACH]\n"
                + "SET [TenSach] = ?,[MaDM] = ?,[MaTL] = ?,[MaNPH] = ?,[MaTG] = ?,[MaNXB] = ?,[NamXuatBan] = ?,[NgonNgu] = ?,[NhomTuoi] = ?,[TaiBan] = ?,[SoTrang] =?,[GiaBan] = ?,[SoLuong] = ?,[TrangThai] = ?\n"
                + " WHERE [MaSach] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, s.getTensach());
            ps.setObject(2, s.getMaDanhMuc());
            ps.setObject(3, s.getMaTheLoai());
            ps.setObject(4, s.getMaNPH());
            ps.setObject(5, s.getMaTacGia());
            ps.setObject(6, s.getMaNXB());
            ps.setObject(7, s.getNamxuatban());
            ps.setObject(8, s.getNgonNgu());
            ps.setObject(9, s.getNhomTuoi());
            ps.setObject(10, s.getTaiBan());
            ps.setObject(11, s.getSotrang());
            ps.setObject(12, s.getGiaban());
            ps.setObject(13, s.getSoluong());
            ps.setObject(14, s.getTrangthai());
            ps.setObject(15, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public Boolean delete(int ma) {
        String sql = "DELETE FROM [dbo].[SACH] WHERE [MaSach] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
