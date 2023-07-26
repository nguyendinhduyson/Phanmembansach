package DomainModel;

/**
 *
 * @author dqv20
 */
public class TheLoai {

    private Integer maTheLoai;
    private String tenTheLoai;

    public TheLoai() {
    }

    public TheLoai(Integer maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    public TheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public Integer getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(Integer maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    @Override
    public String toString() {
        return tenTheLoai;
    }

}
