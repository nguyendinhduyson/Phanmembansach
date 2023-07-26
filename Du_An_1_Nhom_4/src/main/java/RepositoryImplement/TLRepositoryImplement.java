package RepositoryImplement;

import DomainModel.TheLoai;
import RepositoryInterface.TLRepositoryInterface;
import java.util.ArrayList;
import Utilities.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class TLRepositoryImplement implements TLRepositoryInterface {

    @Override
    public ArrayList<TheLoai> listTL() {
        String query = "SELECT [MaTL],[TenTL] FROM [dbo].[THELOAI]";
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ArrayList<TheLoai> listTL = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listTL.add(new TheLoai(rs.getInt(1), rs.getString(2)));
            }
            return listTL;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean themTL(TheLoai x) {
        String query = "INSERT INTO [dbo].[THELOAI]([TenTL]) VALUES (?)";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getTenTheLoai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean suaTL(TheLoai x) {
        String query = "UPDATE [dbo].[THELOAI]SET [TenTL] = ? WHERE [MaTL] = ?";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getTenTheLoai());
            ps.setObject(2, x.getMaTheLoai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean xoaTL(TheLoai x) {
        String query = "DELETE FROM [dbo].[THELOAI] WHERE [MaTL] = ?";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getMaTheLoai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    public static void main(String[] args) {
        new TLRepositoryImplement().listTL().forEach(s->System.out.println(s.toString()));
    }
}
