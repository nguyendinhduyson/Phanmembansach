package View;

import DomainModel.KhachHang;
import ServiceImplement.HoaDonCTVMServiceImplement;
import ServiceImplement.HoaDonVMServiceImplement;
import ServiceImplement.SachVMServiceImplement;
import ServiceImplement.manageKhachHangService;
import ServiceInterface.HoaDonCTVMServiccecInterface;
import ServiceInterface.HoaDonVMServiceInterface;
import ServiceInterface.ImanageKhachHangService;
import ServiceInterface.SachVMServiceInterface;
import ViewModel.GioHangVM;
import ViewModel.HoaDonCTVM;
import ViewModel.HoaDonVM;
import ViewModel.QLKhachHang;
import ViewModel.SachVM;
import static java.sql.JDBCType.NULL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xuan Truong
 */
public class BanHang1 extends javax.swing.JFrame {

    private DefaultTableModel modelSach = new DefaultTableModel();
    private DefaultTableModel modelHoaDonVM = new DefaultTableModel();
    private DefaultTableModel modelHoaDonCTVM = new DefaultTableModel();
    private DefaultTableModel modelLoadGH = new DefaultTableModel();

    private ArrayList<HoaDonVM> listHDVM = new ArrayList<>();
    private ArrayList<SachVM> listSach = new ArrayList<>();
    private ArrayList<GioHangVM> listGioHang = new ArrayList<>();
    private List<QLKhachHang> listKH = new ArrayList<>();

    private SachVMServiceInterface serviceSach = new SachVMServiceImplement();
    private ImanageKhachHangService serviceKH = new manageKhachHangService();
    private HoaDonVMServiceInterface serviceHoaDonVM = new HoaDonVMServiceImplement();
    private HoaDonCTVMServiccecInterface serviceHDCTVM = new HoaDonCTVMServiceImplement();
    float tongtienGH = 0;
    float tongTienHD = 0;
    float tienKhachDua = 0;
    Integer diemThua = 0;

    public BanHang1() {
        initComponents();
        setLocationRelativeTo(null);

        tblSach.setModel(modelSach);
        tblHoaDon.setModel(modelHoaDonVM);
        tblGioHang.setModel(modelHoaDonCTVM);

        listSach = serviceSach.listSach();
        listHDVM = serviceHoaDonVM.listHDVM();

        loadTableSach(listSach);
        loadTableHoaDonVM(listHDVM);
        anButtonThanhToan();

    }

    private void loadSachFormHD(List<GioHangVM> list) {
        modelHoaDonCTVM.setRowCount(0);
        modelHoaDonCTVM.setColumnIdentifiers(new String[]{"Tên sách", "Số lượng", "Đơn giá", "Thành tiền"});
        for (GioHangVM sach : list) {
            modelHoaDonCTVM.addRow(new Object[]{sach.getTenSach(), sach.getSoLuong(), sach.getDonGia(), sach.getThanhTien()});
        }
    }

    private void loadhdcho() {
        DefaultTableModel tblhdchuathanhtoan = (DefaultTableModel) tblHoaDon.getModel();
        tblhdchuathanhtoan.setRowCount(0);
        List<HoaDonVM> listhdcho = serviceHoaDonVM.loaddangcho();

        for (HoaDonVM hd : listhdcho) {
            tblhdchuathanhtoan.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKhachHang(), hd.getMaNhanVien(), hd.getNgayTao(), hd.getTrangThai() == 1 ? "Chưa thanh toán" : "Đang chờ "});
        }
    }

    private void loadHDChuathanhtoan() {
        DefaultTableModel tblhdchuathanhtoan = (DefaultTableModel) tblHoaDon.getModel();
        tblhdchuathanhtoan.setRowCount(0);
        List<HoaDonVM> listhdcho = serviceHoaDonVM.loadchuathanhtoan();

        for (HoaDonVM hd : listhdcho) {
            tblhdchuathanhtoan.addRow(new Object[]{hd.getMaHoaDon(), hd.getMaKhachHang(), hd.getMaNhanVien(), hd.getNgayTao(), hd.getTrangThai() == 1 ? "Chưa thanh toán" : "Đang chờ "});
        }
    }

    private void anButtonThanhToan() {
        if (txtTienSauKhiGiam.getText().isBlank() || txtTienKhachDua.getText().isBlank()) {
            return;
        }
        float tienCuoi = Float.valueOf(txtTienSauKhiGiam.getText());
        float tienKhachDua = Float.valueOf(txtTienKhachDua.getText());
        float tienThua = tienKhachDua - tienCuoi;
        if (tienThua > 0) {
            txtTienThua.setText(String.valueOf(tienThua));
            btnThanhToan.setVisible(true);
        }
    }

    private void loadTienSauKhiGiam() {
        float tongTien = 0;
        if (txtTongTien.getText().isBlank()) {
            tongTien = 0;
        } else {
            tongTien = Float.parseFloat(txtTongTien.getText());
        }
        Integer tienGiam = 0;
        if (txtTienGiam.getText().isBlank()) {
            tienGiam = 0;
        } else {
            tienGiam = Integer.valueOf(txtTienGiam.getText());
        }
        float tienSauKhiGiam = tongTien - tienGiam;
        txtTienSauKhiGiam.setText(String.valueOf(tienSauKhiGiam));
    }

    private void loadTableSach(ArrayList<SachVM> list) {
        modelSach.setRowCount(0);
        modelSach.setColumnIdentifiers(new String[]{"Mã sách", "Tên sách", "Số lượng", "Giá bán"});
        for (SachVM x : list) {
            modelSach.addRow(new Object[]{x.getMaSach(), x.getTenSach(), x.getSoLuong(), x.getGiaBan()});
        }
    }

    private void loadTableHoaDonVM(ArrayList<HoaDonVM> list) {
        modelHoaDonVM.setRowCount(0);
        modelHoaDonVM.setColumnIdentifiers(new String[]{"Mã hoá đơn", "Khách hàng", "Mã nhân viên", "Ngày tạo", "Trạng thái"});
        for (HoaDonVM x : list) {
            modelHoaDonVM.addRow(x.toDataRow());
        }
    }

    private void loadTableGioHang(ArrayList<GioHangVM> list) {
        modelHoaDonCTVM.setRowCount(0);
        modelHoaDonCTVM.setColumnIdentifiers(new String[]{"Tên sách", "Số lượng", "Đơn giá", "Thành tiền"});
        for (GioHangVM x : list) {
            modelHoaDonCTVM.addRow(new Object[]{x.getTenSach(), x.getSoLuong(), x.getDonGia(), x.getThanhTien()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SidePanel = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnQLSach = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnQLHoaDon = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        btnQLNhanVien = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        btnQLKhachHang = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        btnThongKe = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rdCho = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnClearGioHang = new javax.swing.JButton();
        btnXoaGioHang = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnTaoHD = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTienSauKhiGiam = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        btnChonKH = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtDiemTichLuy = new javax.swing.JTextField();
        rdDiem = new javax.swing.JRadioButton();
        btnThemKH = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTienGiam = new javax.swing.JTextField();
        btnHoaDonCho = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SidePanel.setBackground(new java.awt.Color(51, 204, 255));

        btnTrangChu.setBackground(new java.awt.Color(255, 102, 51));
        btnTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTrangChu.setText("TRANG CHỦ");
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("BÁN HÀNG");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnQLSach.setBackground(new java.awt.Color(255, 102, 51));
        btnQLSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQLSach.setText("QUẢN LÝ SÁCH");
        btnQLSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLSachActionPerformed(evt);
            }
        });

        btnQLHoaDon.setBackground(new java.awt.Color(255, 102, 51));
        btnQLHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQLHoaDon.setText("QUẢN LÝ HOÁ ĐƠN");
        btnQLHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLHoaDonActionPerformed(evt);
            }
        });

        btnQLNhanVien.setBackground(new java.awt.Color(255, 102, 51));
        btnQLNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQLNhanVien.setText("QUẢN LÝ NHÂN VIÊN");
        btnQLNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNhanVienActionPerformed(evt);
            }
        });

        btnQLKhachHang.setBackground(new java.awt.Color(255, 102, 51));
        btnQLKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnQLKhachHang.setText("QUẢN LÝ KHÁCH HÀNG");
        btnQLKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLKhachHangActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(255, 102, 51));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 102, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setText("THOÁT");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(btnQLSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addComponent(btnQLHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addComponent(btnQLNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator6)
            .addComponent(btnQLKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator7)
            .addComponent(jSeparator8)
            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLSach, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("DANH SÁCH HOÁ ĐƠN CHỜ");

        rdCho.setText("Đang chờ");
        rdCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdChoActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Chưa thanh toán");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(rdCho)
                .addGap(56, 56, 56)
                .addComponent(jRadioButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdCho)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("GIỎ HÀNG");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        btnClearGioHang.setText("Clear");
        btnClearGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearGioHangActionPerformed(evt);
            }
        });

        btnXoaGioHang.setText("Xoa");
        btnXoaGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGioHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClearGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btnXoaGioHang)
                        .addGap(18, 18, 18)
                        .addComponent(btnClearGioHang))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("SÁCH");

        jButton11.setText("Tìm kiếm");

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSach);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton11)
                .addGap(23, 23, 23))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane5)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Mã hoá đơn");

        txtMaHoaDon.setEditable(false);
        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("HOÁ ĐƠN");

        btnTaoHD.setText("Tạo HĐ");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        jLabel6.setText("Ngày tạo");

        jLabel7.setText("Mã nhân viên");

        jLabel9.setText("Tổng tiền");

        txtTongTien.setEditable(false);

        jLabel10.setText("Tiền khách đưa");

        jLabel11.setText("Tiền thừa");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setText("Mã khách hàng");

        jLabel13.setText("Tên khách hàng");

        btnChonKH.setText("Chọn");
        btnChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonKHActionPerformed(evt);
            }
        });

        jLabel8.setText("Điểm tích luỹ");

        rdDiem.setText("Dùng điểm");
        rdDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdDiemActionPerformed(evt);
            }
        });

        btnThemKH.setText("Thêm KH");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenKhachHang)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(txtDiemTichLuy))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdDiem)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemKH)
                            .addComponent(btnChonKH))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(btnThemKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDiemTichLuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdDiem))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel14.setText("Tiền sau khi giảm");

        jLabel16.setText("Tiền giảm");

        btnHoaDonCho.setText("Chờ");
        btnHoaDonCho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonChoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnTaoHD))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                            .addComponent(txtTienSauKhiGiam, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                            .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                            .addComponent(txtTienThua)
                                            .addComponent(txtTienGiam))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHoaDonCho)
                .addGap(37, 37, 37))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTaoHD)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTienSauKhiGiam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThanhToan)
                    .addComponent(btnHoaDonCho))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        this.dispose();
        new MainApp().setVisible(true);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnQLSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSachActionPerformed
        this.dispose();
        new QLSach1().setVisible(true);
    }//GEN-LAST:event_btnQLSachActionPerformed

    private void btnQLHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLHoaDonActionPerformed
        this.dispose();
        new FormQLhoadon1().setVisible(true);
    }//GEN-LAST:event_btnQLHoaDonActionPerformed

    private void btnQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNhanVienActionPerformed
        this.dispose();
        new QLNhanVien_().setVisible(true);
    }//GEN-LAST:event_btnQLNhanVienActionPerformed

    private void btnQLKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLKhachHangActionPerformed
        this.dispose();
        new QLKhachHang_().setVisible(true);
    }//GEN-LAST:event_btnQLKhachHangActionPerformed

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        int row = tblSach.getSelectedRow();
        String soLuong = JOptionPane.showInputDialog(this, "Nhập số lượng");
        if (Integer.valueOf(soLuong) == JOptionPane.CANCEL_OPTION) {
            return;
        } else {
            Integer slSachCon;
            slSachCon = (Integer) tblSach.getValueAt(row, 2) - Integer.valueOf(soLuong);
            String tenSach = tblSach.getValueAt(row, 1).toString();
            serviceSach.capNhatSoSach(slSachCon, tenSach);
            listSach = serviceSach.listSach();
            loadTableSach(listSach);
            GioHangVM x = new GioHangVM();
            x.setTenSach(tblSach.getValueAt(row, 1).toString());
            x.setSoLuong(Integer.valueOf(soLuong));
            x.setDonGia((Float) tblSach.getValueAt(row, 3));
            x.setMaSach(Integer.valueOf(tblSach.getValueAt(row, 0).toString()));
            listGioHang.add(x);
            loadTableGioHang(listGioHang);
            for (GioHangVM z : listGioHang) {
                tongtienGH = tongtienGH + z.getThanhTien();
            }
            txtTongTien.setText(String.valueOf(tongtienGH));
        }

    }//GEN-LAST:event_tblSachMouseClicked

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        for (int i = 0; i < listHDVM.size(); i++) {
            if (listHDVM.size() > 10) {
                JOptionPane.showMessageDialog(this, "Đat gioi hoa don cho, vui long thanh toan cac hoa don truoc do");
                return;
            }
        }
        HoaDonVM x = new HoaDonVM();
        x.setNgayTao(new Date());
        x.setMaNhanVien(4);
        x.setTrangThai(0);
        x.setMaKhachHang(1);
//        ArrayList<HoaDonCTVM> listHDCT = new ArrayList<>();
//        for (GioHangVM h : listGioHang) {
//            HoaDonCTVM z = new HoaDonCTVM();
//            z.setDonGia(h.getDonGia());
//            z.setMaHoaDon(Integer.valueOf(txtMaHoaDon.getText()));
//            z.setSoLuong(h.getSoLuong());
//            z.setMaSach(h.getMaSach());
//            listHDCT.add(z);
//        }
//        for (HoaDonCTVM h : listHDCT) {
//            serviceHDCTVM.themHDCCT(h);
//        }
        JOptionPane.showMessageDialog(this, serviceHoaDonVM.taoHD(x));
        listHDVM = serviceHoaDonVM.listHDVM();
        loadTableHoaDonVM(listHDVM);
        listGioHang.removeAll(listGioHang);
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
//        int row = tblGioHang.getSelectedRow();
//        SachVM x = new SachVM();
//        x.setSoLuong((Integer) tblGioHang.getValueAt(row, 1));
//        x.setTenSach(tblGioHang.getValueAt(row, 0).toString());
//        x.setGiaBan((Float) tblGioHang.getValueAt(row, 2));
//        JOptionPane.showInputDialog(this, "Nhap so sach muon xoa");
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int tem = tblHoaDon.getSelectedRow();
        if (tem < 0) {
            return;
        } else {
            if (tblHoaDon.getValueAt(tem, 4).toString().equals("Đang chờ")) {
                return;
            } else {
                String maHoaDon = tblHoaDon.getValueAt(tem, 0).toString();
                List<GioHangVM> list = serviceHoaDonVM.getSach(maHoaDon);
                loadSachFormHD(list);
                txtMaHoaDon.setText(maHoaDon);
                txtMaKhachHang.setText(tblHoaDon.getValueAt(tem, 1).toString());
                txtNgayTao.setText(tblHoaDon.getValueAt(tem, 3).toString());
                txtMaNhanVien.setText(tblHoaDon.getValueAt(tem, 2).toString());
                listKH = serviceKH.getAll();
                for (QLKhachHang n : listKH) {
                    if (n.getMaKH() == (Integer.valueOf(txtMaKhachHang.getText()))) {
                        txtTenKhachHang.setText(n.getTenKH());
                        txtDiemTichLuy.setText(String.valueOf(n.getDiemTichLuy()));
                    }
                }
                float tienHang = 0;
                for (GioHangVM x : list) {
                    tienHang = tienHang + x.getThanhTien();
                }
                txtTongTien.setText(String.valueOf(tienHang));
                JOptionPane.showMessageDialog(this, tienHang);
            }
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnXoaGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGioHangActionPerformed
        int temp = tblGioHang.getSelectedRow();
        if (temp < 0) {
            return;
        } else {
            GioHangVM x = listGioHang.get(temp);
            String tenSach = x.getTenSach();
            Integer soSachBanDau = 0;
            Integer soLuongSachGHBanDau = x.getSoLuong();
            String sachTru = JOptionPane.showInputDialog(this, "Nhap so sach muon xoa");
            Integer soSachTru = Integer.parseInt(sachTru);
            Integer soSachCon = soLuongSachGHBanDau - soSachTru;
            for (SachVM z : listSach) {
                if (z.getTenSach().equals(x.getTenSach())) {
                    soSachBanDau = z.getSoLuong();
                }
            }
            x.setSoLuong(soSachCon);
            loadTableGioHang(listGioHang);
            Integer soSachSauKhiXoa = soSachBanDau + soSachTru;
            serviceSach.capNhatSoSach(soSachSauKhiXoa, tenSach);
            listSach = serviceSach.listSach();
            loadTableSach(listSach);
        }

    }//GEN-LAST:event_btnXoaGioHangActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

        float tongTienHD = Float.parseFloat(txtTienSauKhiGiam.getText());
        float tienKhachDua = Float.parseFloat(txtTienKhachDua.getText());
        if (tienKhachDua < tongTienHD) {
            JOptionPane.showMessageDialog(this, "Chưa du tien");
            btnThanhToan.setVisible(false);
        } else {
            float tienThua = tienKhachDua - tongTienHD;
            txtTienThua.setText(String.valueOf(tienThua));
            btnThanhToan.setVisible(true);
            ArrayList<HoaDonCTVM> listHDCT = new ArrayList<>();
            for (GioHangVM x : listGioHang) {
                HoaDonCTVM z = new HoaDonCTVM();
                z.setDonGia(x.getDonGia());
                z.setMaHoaDon(Integer.valueOf(txtMaHoaDon.getText()));
                z.setSoLuong(x.getSoLuong());
                z.setMaSach(x.getMaSach());
                listHDCT.add(z);
            }
            for (HoaDonCTVM x : listHDCT) {
                serviceHDCTVM.themHDCCT(x);
            }
            HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 2);
            JOptionPane.showMessageDialog(this, serviceHoaDonVM.capNhatHD(x));
            listHDVM = serviceHoaDonVM.listHDVM();
            loadTableHoaDonVM(listHDVM);
            listGioHang.removeAll(listGioHang);
            loadTableGioHang(listGioHang);
            Integer maKhachHang = Integer.parseInt(txtMaKhachHang.getText());
            KhachHang c = new KhachHang(maKhachHang, diemThua);
            serviceKH.update(String.valueOf(maKhachHang), c);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnClearGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearGioHangActionPerformed
//        listGioHang.removeAll(listGioHang);
//        loadTableGioHang(listGioHang);
//        Integer soLuong = 0;
//        for (SachVM x : listSach) {
//
//        }
//
//        int temp = tblGioHang.getSelectedRow();
//        GioHangVM x = listGioHang.get(temp);
//        listGioHang.remove(x);
//        Integer soLuongBF = 0;
//        Integer soLuongSach = 0;
//        for (SachVM z : listSach) {
//            if (z.getTenSach().equals(x.getTenSach())) {
//                soLuongBF = z.getSoLuong();
//            }
//        }
//        soLuongSach = soLuongBF + x.getSoLuong();
//        serviceSach.capNhatSoSach(soLuongSach, x.getTenSach());
//        loadTableGioHang(listGioHang);
//        listSach = serviceSach.listSach();
//        loadTableSach(listSach);
    }//GEN-LAST:event_btnClearGioHangActionPerformed

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed

    private void btnChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonKHActionPerformed
        String text = JOptionPane.showInputDialog(this, "Nhập số điện thoại khách hàng");
        KhachHang x = serviceKH.timKH(text);
        if (x.getSdt() == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy. Vui lòng thử lại hoặc tạo mới");
            int choice = JOptionPane.showConfirmDialog(this, "Ban co muon tao moi khong ?");
            if (choice == JOptionPane.OK_OPTION) {
                new FormKhachHang_Mini().setVisible(true);
            }
        } else {
            txtTenKhachHang.setText(x.getTenKH());
            txtMaKhachHang.setText(String.valueOf(x.getMaKH()));
            txtDiemTichLuy.setText(String.valueOf(x.getDiemTichLuy()));
        }

    }//GEN-LAST:event_btnChonKHActionPerformed

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        new FormKhachHang_Mini().setVisible(true);
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void rdDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdDiemActionPerformed
        if (rdDiem.isSelected()) {
            if (txtMaKhachHang.getText().isBlank() || txtTenKhachHang.getText().isBlank() || txtDiemTichLuy.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng");
            } else {
                String diem = JOptionPane.showInputDialog("Nhap so diem can quy doi");
                Integer tienGiam = Integer.parseInt(diem) * 1000;
                txtTienGiam.setText(String.valueOf(tienGiam));
                loadTienSauKhiGiam();
                diemThua = Integer.parseInt(txtDiemTichLuy.getText()) - Integer.parseInt(diem);
            }
        }
    }//GEN-LAST:event_rdDiemActionPerformed

    private void btnHoaDonChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonChoActionPerformed
        ArrayList<HoaDonCTVM> listHDCT = new ArrayList<>();
        HoaDonCTVM z = new HoaDonCTVM();
        for (GioHangVM x : listGioHang) {
            z.setDonGia(x.getDonGia());
            z.setMaHoaDon(Integer.valueOf(txtMaHoaDon.getText()));
            z.setSoLuong(x.getSoLuong());
            z.setMaSach(x.getMaSach());
            listHDCT.add(z);
        }
        for (HoaDonCTVM x : listHDCT) {
            serviceHDCTVM.themHDCCT(x);
        }
        HoaDonVM x = new HoaDonVM(Integer.valueOf(txtMaHoaDon.getText()), Integer.valueOf(txtMaKhachHang.getText()), tongTienHD, 1);
        serviceHoaDonVM.capNhatHD(x);
        listHDVM = serviceHoaDonVM.listHDVM();
        loadTableHoaDonVM(listHDVM);
        listGioHang.removeAll(listGioHang);
        loadTableGioHang(listGioHang);
    }//GEN-LAST:event_btnHoaDonChoActionPerformed

    private void rdChoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdChoActionPerformed
        loadhdcho();
    }//GEN-LAST:event_rdChoActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        loadHDChuathanhtoan();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muon thoat chuong trinh khong ?");
        if(choice==JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BanHang1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BanHang1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BanHang1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BanHang1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BanHang1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton btnChonKH;
    private javax.swing.JButton btnClearGioHang;
    private javax.swing.JButton btnHoaDonCho;
    private javax.swing.JButton btnQLHoaDon;
    private javax.swing.JButton btnQLKhachHang;
    private javax.swing.JButton btnQLNhanVien;
    private javax.swing.JButton btnQLSach;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnXoaGioHang;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rdCho;
    private javax.swing.JRadioButton rdDiem;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSach;
    private javax.swing.JTextField txtDiemTichLuy;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienGiam;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienSauKhiGiam;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
