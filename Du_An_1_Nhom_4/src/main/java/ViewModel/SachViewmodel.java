package ViewModel;

/**
 *
 * @author dqv20
 */
public class SachViewmodel {

    private Integer maSach; 
    private String tenSach;
    private String tenDanhMuc;  
    private String tenTheLoai;
    private String tenNPH;
    private String tenTacGia;
    private String tenNXB;
    private String namxuatban;
    private String ngonNgu;
    private String nhomTuoi;
    private Integer taiBan;
    private Integer sotrang;
    private Float giaban;
    private Integer soluong;
    private Integer trangthai;

    public SachViewmodel() {
    }

    public SachViewmodel(Integer maSach, String tenSach, String tenDanhMuc, String tenTheLoai, String tenNPH, String tenTacGia, String tenNXB, String namxuatban, String ngonNgu, String nhomTuoi, Integer taiBan, Integer sotrang, Float giaban, Integer soluong, Integer trangthai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tenDanhMuc = tenDanhMuc;
        this.tenTheLoai = tenTheLoai;
        this.tenNPH = tenNPH;
        this.tenTacGia = tenTacGia;
        this.tenNXB = tenNXB;
        this.namxuatban = namxuatban;
        this.ngonNgu = ngonNgu;
        this.nhomTuoi = nhomTuoi;
        this.taiBan = taiBan;
        this.sotrang = sotrang;
        this.giaban = giaban;
        this.soluong = soluong;
        this.trangthai = trangthai;
    }

    public Integer getMasach() {
        return maSach;
    }

    public void setMasach(Integer maSach) {
        this.maSach = maSach;
    }

    public String getTensach() {
        return tenSach;
    }

    public void setTensach(String tensach) {
        this.tenSach = tensach;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getTenNPH() {
        return tenNPH;
    }

    public void setTenNPH(String tenNPH) {
        this.tenNPH = tenNPH;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(String namxuatban) {
        this.namxuatban = namxuatban;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getNhomTuoi() {
        return nhomTuoi;
    }

    public void setNhomTuoi(String nhomTuoi) {
        this.nhomTuoi = nhomTuoi;
    }

    public Integer getTaiBan() {
        return taiBan;
    }

    public void setTaiBan(Integer taiBan) {
        this.taiBan = taiBan;
    }

    public Integer getSotrang() {
        return sotrang;
    }

    public void setSotrang(Integer sotrang) {
        this.sotrang = sotrang;
    }

    public Float getGiaban() {
        return giaban;
    }

    public void setGiaban(Float giaban) {
        this.giaban = giaban;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Integer getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }

    public Object[] todDataRow() {
        return new Object[]{maSach, tenSach, tenDanhMuc, tenTheLoai, tenNPH, tenTacGia, tenNXB, namxuatban, ngonNgu, nhomTuoi, taiBan, sotrang, giaban, soluong, trangthai==1?"Đang bán":"Chờ bán"};
    }
}
