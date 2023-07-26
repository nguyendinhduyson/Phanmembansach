package DomainModel;

/**
 *
 * @author Xuan Truong
 */
public class NPH {

    private Integer maNPH;
    private String tenNPH;

    public NPH() {
    }

    public NPH(Integer maNPH, String tenNPH) {
        this.maNPH = maNPH;
        this.tenNPH = tenNPH;
    }

    public Integer getMaNPH() {
        return maNPH;
    }

    public void setMaNPH(Integer maNPH) {
        this.maNPH = maNPH;
    }

    public String getTenNPH() {
        return tenNPH;
    }

    public void setTenNPH(String tenNPH) {
        this.tenNPH = tenNPH;
    }

    public NPH(String tenNPH) {
        this.tenNPH = tenNPH;
    }

    @Override
    public String toString() {
        return tenNPH;
    }

}
