/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryImplement;

import RepositoryInterface.IDanhMucRepository;
import DomainModel.DanhMuc;
import Utilities.DBConection;
import ViewModel.QLDanhMuc;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL 5515
 */
public class DanhMucRepository implements IDanhMucRepository {

    private List<QLDanhMuc> list;

    public DanhMucRepository() {
       
    }

    @Override
    public List<QLDanhMuc> getAll() {
         list = new ArrayList<>();
        String sql = "select * from DANHMUC ";
        ResultSet rs = DBConection.excutequery(sql);
        try {
            while (rs.next()) {
                list.add(new QLDanhMuc(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Integer add(DanhMuc danhMuc) {
        String sql = "insert into DANHMUC( TenDM) values(?)";
        int row = DBConection.excuteUpdate(sql, danhMuc.getTenDM());
        return row;
    }

    @Override
    public Integer delete(String maDM) {
        String sql = "delete from DANHMUC where MaDM = ?";
        int row = DBConection.excuteUpdate(sql, maDM);
        return row;
    }

    @Override
    public Integer update(String maDM, DanhMuc danhMuc) {
        String sql = "update DANHMUC set TenDM = ? where MaDM = ? ";
        int row = DBConection.excuteUpdate(sql, danhMuc.getTenDM(), maDM);
        return row;
    }

}
