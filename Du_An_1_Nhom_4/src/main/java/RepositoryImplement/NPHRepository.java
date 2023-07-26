package RepositoryImplement;

import DomainModel.NPH;
import Utilities.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class NPHRepository {

    public ArrayList<NPH> getAllNPH() {
        String query = "SELECT [MaNPH],[TenNPH] FROM [dbo].[NPH]";
        ArrayList<NPH> listNPH = new ArrayList<>();
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listNPH.add(new NPH(rs.getInt(1), rs.getString(2)));
            }
            return listNPH;
        } catch (Exception e) {
        }
        return null;
    }

    public boolean themNPH(NPH x) {
        String query = "INSERT INTO [dbo].[NPH] ([TenNPH]) VALUES (?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getTenNPH());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean xoaNPH(NPH x) {
        String query = "DELETE FROM [dbo].[NPH] WHERE [MaNPH] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getMaNPH());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public boolean suaNPH(NPH x) {
        String query = "UPDATE [dbo].[NPH] SET [TenNPH] = ? WHERE [MaNPH] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, x.getTenNPH());
            ps.setObject(2, x.getMaNPH());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
}
