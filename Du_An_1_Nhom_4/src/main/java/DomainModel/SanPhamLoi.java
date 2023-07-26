/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

/**
 *
 * @author DELL 5515
 */
public class SanPhamLoi {
    private int maSPL;
    private int maSach;
    private int soLuong;
    private String lyDoDoi;

    public SanPhamLoi() {
    }

    public SanPhamLoi(int maSPL, int maSach, int soLuong, String lyDoDoi) {
        this.maSPL = maSPL;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.lyDoDoi = lyDoDoi;
    }

    public int getMaSPL() {
        return maSPL;
    }

    public void setMaSPL(int maSPL) {
        this.maSPL = maSPL;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getLyDoDoi() {
        return lyDoDoi;
    }

    public void setLyDoDoi(String lyDoDoi) {
        this.lyDoDoi = lyDoDoi;
    }
    
    
}
