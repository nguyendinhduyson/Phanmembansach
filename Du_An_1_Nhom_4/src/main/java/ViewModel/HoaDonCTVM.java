
package ViewModel;

/**
 *
 * @author Xuan Truong
 */
public class HoaDonCTVM {
    private Integer maHoaDonCT;
    private Integer maHoaDon;
    private Integer maSach;
    private Integer soLuong;
    private Float donGia;

    public HoaDonCTVM() {
    }

    public HoaDonCTVM(Integer maHoaDonCT, Integer maHoaDon, Integer maSach, Integer soLuong, Float donGia) {
        this.maHoaDonCT = maHoaDonCT;
        this.maHoaDon = maHoaDon;
        this.maSach = maSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public Integer getMaHoaDonCT() {
        return maHoaDonCT;
    }

    public void setMaHoaDonCT(Integer maHoaDonCT) {
        this.maHoaDonCT = maHoaDonCT;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }
    
}
