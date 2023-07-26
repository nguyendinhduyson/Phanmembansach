package DomainModel;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Xuan Truong
 */
@Table(name = "ChucVu")
@Entity
public class ChucVu {

    @Id
    @Column(name = "maChucVu", nullable = false)
    private Integer maChucVu;
    @Column(name = "tenChucVu", nullable = false)
    private String tenChucVu;
    @OneToMany(mappedBy = "ChucVu", fetch = FetchType.EAGER)
    private ArrayList<NhanVien> listNhanVien;

    public ChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public ChucVu() {
    }

    public ChucVu(Integer maChucVu, String tenChucVu) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
    }

    public Integer getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(Integer maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public ArrayList<NhanVien> getListNhanVien() {
        return listNhanVien;
    }

    public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
        this.listNhanVien = listNhanVien;
    }

    @Override
    public String toString() {
        return tenChucVu;
    }

}
