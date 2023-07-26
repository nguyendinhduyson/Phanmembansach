package DomainModel;

/**
 *
 * @author Xuan Truong
 */
public class NXB {

    private Integer maNXB;
    private String tenNXB;

    public NXB() {
    }

    public NXB(Integer maNXB, String tenNXB) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
    }

    public Integer getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(Integer maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    @Override
    public String toString() {
        return tenNXB;
    }

}
