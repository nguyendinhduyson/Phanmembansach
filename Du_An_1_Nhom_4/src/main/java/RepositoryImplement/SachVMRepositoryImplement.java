package RepositoryImplement;

import RepositoryInterface.SachVMRepositoryInterface;
import Utilities.DBConection;
import ViewModel.SachVM;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class SachVMRepositoryImplement implements SachVMRepositoryInterface {

    @Override
    public ArrayList<SachVM> listSach() {
        ArrayList<SachVM> listSach = new ArrayList<>();
        String query = "SELECT MaSach,TenSach,SoLuong,GiaBan FROM SACH";
        ResultSet rs = DBConection.excutequery(query);
        try {
            while (rs.next()) {
                listSach.add(new SachVM(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSach;
    }

    @Override
    public Void capNhatSLSach(Integer soLuong, String tenSach) {
        String query = "UPDATE [dbo].[SACH] SET [SoLuong] = ? WHERE TenSach = ?";
        int check = 0;
        try(Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, soLuong);
            ps.setObject(2, tenSach);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
