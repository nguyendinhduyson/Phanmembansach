package RepositoryImplement;

import java.util.ArrayList;
import DomainModel.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import DomainModel.ChucVu;
import Utilities.DBConection;
import ViewModel.NhanVienRespone;

/**
 *
 * @author Xuan Truong
 */
public class NhanVienRepository {

    public ArrayList<NhanVienRespone> listNhanVien() {
        String query = "SELECT NHANVIEN.MaNV, NHANVIEN.TenNV, CHUCVU.TenCV, NHANVIEN.GioiTinh, NHANVIEN.NgaySinh, NHANVIEN.DiaChi, NHANVIEN.SDT, NHANVIEN.TaiKhoan, NHANVIEN.MatKhau\n"
                + "FROM CHUCVU INNER JOIN NHANVIEN ON CHUCVU.MaCV = NHANVIEN.MaCV";
        ArrayList<NhanVienRespone> listNhanVien = new ArrayList<>();
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listNhanVien.add(new NhanVienRespone(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            return listNhanVien;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean themNhanVien(NhanVien x) {
        String query = "INSERT INTO [dbo].[NHANVIEN]([TenNV],[MaCV],[GioiTinh],[NgaySinh],[DiaChi],[SDT],[TaiKhoan],[MatKhau])\n"
                + "VALUES (?,?,?,?,?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getTenNhanVien());
            ps.setObject(2, x.getMaChucVu().getMaChucVu());
            ps.setObject(3, x.isGioiTinh());
            ps.setObject(4, x.getNgaySinh());
            ps.setObject(5, x.getDiaChi());
            ps.setObject(6, x.getSDT());
            ps.setObject(7, x.getTaiKhoan());
            ps.setObject(8, x.getMatKhau());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean suaNhanVien(NhanVien x, Integer maNhanVien) {
        String query = "UPDATE [dbo].[NHANVIEN] SET [TenNV] = ?,[MaCV] = ?,[GioiTinh] = ?,[NgaySinh] = ?,[DiaChi] = ?,[SDT] = ?,[TaiKhoan] = ?,[MatKhau] = ?\n"
                + " WHERE [MaNV] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getTenNhanVien());
            ps.setObject(2, x.getMaChucVu().getMaChucVu());
            ps.setObject(3, x.isGioiTinh());
            ps.setObject(4, x.getNgaySinh());
            ps.setObject(5, x.getDiaChi());
            ps.setObject(6, x.getSDT());
            ps.setObject(7, x.getTaiKhoan());
            ps.setObject(8, x.getMatKhau());
            ps.setObject(9, maNhanVien);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoaNhanVien(Integer maNhanVien) {
        String query = "DELETE FROM [dbo].[NHANVIEN] WHERE [MaNV] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1,maNhanVien);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
