/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RepositoryImplement;

import RepositoryInterface.ISanPhamLoiRepository;
import DomainModel.SanPhamLoi;
import Utilities.DBConection;
import ViewModel.QLSanPhamLoi;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL 5515
 */
public class SanPhamLoiRepository implements ISanPhamLoiRepository{
    
    private List<QLSanPhamLoi> list;

    public SanPhamLoiRepository() {
        list = new ArrayList<>();
    }
    
    

    @Override
    public List<QLSanPhamLoi> getAll() {
        String selectAll = "select * from SANPHAMLOI";
        ResultSet rs = DBConection.excutequery(selectAll);
        try {
            while (rs.next()) {
              list.add(new QLSanPhamLoi(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamLoiRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Integer add(SanPhamLoi sp) {
        String insert = "insert into SANPHAMLOI( MaSach, SoLuong, LyDoDoi) values(?,?,?)";
        int row = DBConection.excuteUpdate(insert, sp.getMaSach(), sp.getSoLuong(), sp.getLyDoDoi());
        return row;
    }

    @Override
    public Integer delete(String maspl) {
        String delete = "delete from SANPHAMLOI where MaSPL = ? ";
        int row = DBConection.excuteUpdate(delete, maspl);
        return row;
    }

    @Override
    public Integer update(String maspl, SanPhamLoi sp) {
          String update = "update SANPHAMLOI set MaSach = ?, SoLuong = ?, LyDoDoi =  ? where MaSPL = ?";
        int row = DBConection.excuteUpdate(update, sp.getMaSach(), sp.getSoLuong(), sp.getLyDoDoi(), maspl);
        return row;
    }
    
}
