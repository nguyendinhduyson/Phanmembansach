/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RepositoryImplement;

import DomainModel.TacGia;
import RepositoryInterface.TGInterface;
import Utilities.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xuan Truong
 */
public class TGImplement implements TGInterface {

    @Override
    public ArrayList<TacGia> listTG() {
        String query = "SELECT [MaTG],[TenTG] FROM [dbo].[TACGIA]";
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ArrayList<TacGia> listTG = new ArrayList<>();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listTG.add(new TacGia(rs.getInt(1), rs.getString(2)));
            }
            return listTG;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean themTG(TacGia x) {
        String query = "INSERT INTO [dbo].[TACGIA]([TenTG]) VALUES (?)";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getTenTacGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean suaTG(TacGia x) {
        String query = "UPDATE [dbo].[TACGIA]SET [TenTG] = ? WHERE [MaTG] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getTenTacGia());
            ps.setObject(2, x.getMaTacGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    @Override
    public Boolean xoaTG(TacGia x) {
        String query = "DELETE FROM [dbo].[TACGIA] WHERE [MaTG] = ?";
        int check = 0;
        try ( Connection con = DBConection.getConnection();  PreparedStatement ps = con.prepareStatement(query)) {
            ps.setObject(1, x.getMaTacGia());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

}
