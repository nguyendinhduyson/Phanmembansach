package RepositoryImplement;

import Utilities.DBConection;
import ViewModel.HoaDonCTVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonCTVMRepositoryInterface implements RepositoryInterface.HoaDonCTVMRepositoryInterface {

    @Override
    public Boolean themHDCT(HoaDonCTVM x) {
        String query = "INSERT INTO [dbo].[HOADONCT]([MaHD],[MaSACH],[SoLuong],[DonGia])VALUES(?,?,?,?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getMaHoaDon());
            ps.setObject(2, x.getMaSach());
            ps.setObject(3, x.getSoLuong());
            ps.setObject(4, x.getDonGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
        return check > 0;
    }

    @Override
    public ArrayList<HoaDonCTVM> getlist(Integer maHoaDon) {
        ArrayList<HoaDonCTVM> list = new ArrayList<>();
        String sql = "SELECT [MaHDCT]\n"
                + "      ,[MaHD]\n"
                + "      ,[MaSACH]\n"
                + "      ,[SoLuong]\n"
                + "      ,[DonGia]\n"
                + "  FROM [dbo].[HOADONCT]\n"
                + "  WHERE [MaHD] = ?";
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, maHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonCTVM h = new HoaDonCTVM();
                h.setMaHoaDonCT(rs.getInt(1));
                h.setMaHoaDon(rs.getInt(2));
                h.setMaSach(rs.getInt(3));
                h.setSoLuong(rs.getInt(4));
                h.setDonGia(rs.getFloat(5));
                list.add(h);
            }

        } catch (Exception e) {
        }
        return list;
    }

}
