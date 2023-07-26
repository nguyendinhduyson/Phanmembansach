package RepositoryImplement;

import DomainModel.NPH;
import RepositoryInterface.NPHRepositoryInterface;
import Utilities.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class NPHRepositoryImplement implements NPHRepositoryInterface {

    @Override
    public ArrayList<NPH> listNPH() {
        String query = "SELECT [MaNPH],[TenNPH] FROM [dbo].[NPH]";
        ArrayList<NPH> listNPH = new ArrayList<>();
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listNPH.add(new NPH(rs.getInt(1), rs.getString(2)));
            }
            return listNPH;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Boolean themNPH(NPH x) {
        String query = "INSERT INTO [dbo].[NPH] ([TenNPH]) VALUES (?)";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getTenNPH());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean suaNPH(NPH x) {
        String query = "UPDATE [dbo].[NPH] SET [TenNPH] = ? WHERE [MaNPH] = ?";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getTenNPH());
            ps.setObject(2, x.getMaNPH());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean xoaNPH(NPH x) {
        String query = "DELETE FROM [dbo].[NPH] WHERE [MaNPH] = ?";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getMaNPH());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
