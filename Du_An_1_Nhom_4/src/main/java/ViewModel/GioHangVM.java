package ViewModel;

/**
 *
 * @author Xuan Truong
 */
public class GioHangVM {

    private Integer maSach;
    private String tenSach;
    private Integer soLuong;
    private Float donGia;

    public GioHangVM() {
    }

    public GioHangVM(Integer maSach, String tenSach, Integer soLuong, Float donGia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public GioHangVM(String tenSach, Integer soLuong, Float donGia) {
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public Integer getMaSach() {
        return maSach;
    }

    public void setMaSach(Integer maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
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

    public Float getThanhTien() {
        return this.donGia * this.soLuong;
    }
}
