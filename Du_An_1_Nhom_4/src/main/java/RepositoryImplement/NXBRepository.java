/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryImplement;

import DomainModel.NXB;
import RepositoryInterface.INXBRepository;
import Utilities.DBConection;
import ViewModel.QLNXB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL 5515
 */
public class NXBRepository implements INXBRepository {

    private List<NXB> list;

    @Override
    public List<NXB> getAll() {
        list = new ArrayList<>();
        String sql = "select * from NXB";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                list.add(new NXB(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NXBRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Integer add(NXB nxb) {
        String sql = "insert into NXB(TenNXB) values(?)";
        int row = DBConection.excuteUpdate(sql, nxb.getTenNXB());
        return row;
    }

    @Override
    public Integer delete(String maNXB) {
        String sql = "delete NXB where MaNXB = ?";
        int row = DBConection.excuteUpdate(sql, maNXB);
        return row;
    }

    @Override
    public Integer update(String maNXB, NXB nxb) {
        String sql = "update NXB set TenNXB = ? where MaNXB = ?";
        int row = DBConection.excuteUpdate(sql, nxb.getTenNXB(), maNXB);
        return row;
    }

}
