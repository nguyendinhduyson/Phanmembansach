/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModel;

import java.util.Date;

/**
 *
 * @author Long
 */
public class TraHang {

    private String maPTH;
    private String maHD;
    private String maKH;
    private String maNV;
    private String ngayTra;
    private Float tienTraLai;
    private String lyDo;

    public TraHang() {
    }

    public TraHang(String maPTH, String maHD, String maKH, String maNV, String ngayTra, Float tienTraLai, String lyDo) {
        this.maPTH = maPTH;
        this.maHD = maHD;
        this.maKH = maKH;
        this.maNV = maNV;
        this.ngayTra = ngayTra;
        this.tienTraLai = tienTraLai;
        this.lyDo = lyDo;
    }

    public String getMaPTH() {
        return maPTH;
    }

    public void setMaPTH(String maPTH) {
        this.maPTH = maPTH;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Float getTienTraLai() {
        return tienTraLai;
    }

    public void setTienTraLai(Float tienTraLai) {
        this.tienTraLai = tienTraLai;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }


}
