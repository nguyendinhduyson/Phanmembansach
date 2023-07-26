/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepositoryImplement;

import DomainModel.DanhMuc;
import Utilities.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import RepositoryInterface.DMInterface_XT;

/**
 *
 * @author Xuan Truong
 */
public class DMImplement_XT implements DMInterface_XT {

    @Override
    public ArrayList<DanhMuc> listDM() {
        String query = "select * from DANHMUC";
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ArrayList<DanhMuc> listDM = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listDM.add(new DanhMuc(rs.getInt(1), rs.getString(2)));
            }
            return listDM;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean themDM(DanhMuc x) {
        String query = "INSERT INTO [dbo].[DANHMUC]([TenDM]) VALUES (?)";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getTenDM());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean suaDM(DanhMuc x) {
        String query = "UPDATE [dbo].[DANHMUC] SET [TenDM] = ? WHERE [MaDM] = ?";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getTenDM());
            ps.setObject(2, x.getMaDM());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean xoaDM(DanhMuc x) {
        String query = "DELETE FROM [dbo].[DANHMUC] WHERE [MaDM] = ?";
        int check = 0;
        try (Connection con = DBConection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getMaDM());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
