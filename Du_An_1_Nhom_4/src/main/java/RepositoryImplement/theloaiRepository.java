/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryImplement;

import DomainModel.TheLoai;
import Utilities.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dqv20
 */
public class theloaiRepository {

    private DBConection conection;

    public ArrayList<TheLoai> getlist() {
        ArrayList<TheLoai> list = new ArrayList<>();
        String sql = " seletct *from THELOAI";
        try ( Connection con = conection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery();) {
            TheLoai tl = new TheLoai();
            tl.setMaTheLoai(rs.getInt(1));
            tl.setTenTheLoai(rs.getString("TenTL"));

            list.add(tl);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Boolean add(TheLoai tl){
        String sql="insert into THELOAI(MATL,TenTL) "
                + " values ?,?";
        try (Connection con=conection.getConnection();
                PreparedStatement ps =con.prepareStatement(sql)){
            ps.setObject(1, tl.getMaTheLoai());            ps.setObject(2, tl.getTenTheLoai());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        e.printStackTrace();
        return false;}
    }
    public Boolean delete(int ma){
        String sql ="delete THELOAI where MaTl=?";
          try (Connection con=conection.getConnection();
                PreparedStatement ps =con.prepareStatement(sql)){
            ps.setObject(1, ma);           

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        e.printStackTrace();
        return false;}
        
        
    }
    public Boolean update(TheLoai tl ,int ma){
        String sql =" update THELOAI set TenTL=? "
                + "where MaTl=?";
          try (Connection con=conection.getConnection();
                PreparedStatement ps =con.prepareStatement(sql)){
            ps.setObject(2, ma);            ps.setObject(1, tl.getTenTheLoai());

            ps.executeUpdate();
            return true;
        } catch (Exception e) {
        e.printStackTrace();
        return false;}
    }

}
