package ViewModel;

/**
 *
 * @author Xuan Truong
 */
public class SachVM {

    private Integer maSach;
    private String tenSach;
    private Integer soLuong;
    private Float giaBan;

    public SachVM() {
    }

    public SachVM(Integer maSach, String tenSach, Integer soLuong, Float giaBan) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public SachVM(String tenSach, Integer soLuong, Float giaBan) {
        this.tenSach = tenSach;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
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

    public Float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }
}
