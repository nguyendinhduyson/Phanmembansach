package DomainModel;



import java.sql.Date;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Xuan Truong
 */
@Table(name = "NhanVien")
@Entity
public class NhanVien {

    @Id
    @Column(name = "MaNhanVien", nullable = false)
    private Integer maNhanVien;
    @Column(name = "TenNhanVien", nullable = false)
    private String tenNhanVien;
    @ManyToOne
    @JoinColumn(name = "MaChucVu", nullable = false)
    private ChucVu maChucVu;
    @Column(name = "GioiTinh")
    private Integer gioiTinh;
    @Column(name = "NgaySinh")
    private String ngaySinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "SDT")
    private String SDT;
    @Column(name = "TaiKhoan")
    private String taiKhoan;
    @Column(name = "MatKhau")
    private String matKhau;
//    @OneToMany(mappedBy = "NhanVien",fetch = FetchType.EAGER)
//    private ArrayList<HoaDon> listHoaDon;
//    @OneToMany(mappedBy = "NhanVien",fetch = FetchType.EAGER)
//    private ArrayList<TraHang> listTraHang;
//
//    public ArrayList<TraHang> getListTraHang() {
//        return listTraHang;
//    }
//
//    public void setListTraHang(ArrayList<TraHang> listTraHang) {
//        this.listTraHang = listTraHang;
//    }
//    
//    public ArrayList<HoaDon> getListHoaDon() {
//        return listHoaDon;
//    }
//
//    public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
//        this.listHoaDon = listHoaDon;
//    }
    
    public NhanVien() {
    }

    public NhanVien(Integer maNhanVien, String tenNhanVien, ChucVu maChucVu, Integer gioiTinh, String ngaySinh, String diaChi, String SDT, String taiKhoan, String matKhau) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.maChucVu = maChucVu;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public Integer getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(Integer maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public ChucVu getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(ChucVu maChucVu) {
        this.maChucVu = maChucVu;
    }

    public Integer isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
