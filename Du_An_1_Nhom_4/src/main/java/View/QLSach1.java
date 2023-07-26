package View;

import DomainModel.DanhMuc;
import DomainModel.NPH;
import DomainModel.NXB;
import DomainModel.Sach;
import DomainModel.TacGia;
import DomainModel.TheLoai;
import ServiceImplement.DMImplement_XT;
import ServiceInterface.DMInterface_XT;
import ServiceImplement.NPHServiceImplement;
import ServiceImplement.SachserviceImpl;
import ServiceImplement.TGServiceImplement;
import ServiceImplement.TLServiceImplement;
import ServiceImplement.manageNXBService;
import ServiceInterface.ImanageNXBService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ServiceInterface.NPHServiceInterface;
import ServiceInterface.SachService;
import ServiceInterface.TGServiceInterface;
import ServiceInterface.TLServiceInterface;
import ViewModel.SachViewmodel;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Xuan Truong
 */
public class QLSach1 extends javax.swing.JFrame {

    private DefaultTableModel modelDM = new DefaultTableModel();
    private DefaultTableModel modelTG = new DefaultTableModel();
    private DefaultTableModel modelTL = new DefaultTableModel();
    private DefaultTableModel modelNPH = new DefaultTableModel();
    private DefaultTableModel modelDSSach = new DefaultTableModel();
    private DefaultTableModel modelSachLoi = new DefaultTableModel();
    private DefaultTableModel modelSach = new DefaultTableModel();

    private DefaultComboBoxModel boxModelTG = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelTL = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelDM = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelNhomTuoi = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelDanhMucSearch = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelNPH = new DefaultComboBoxModel();
    private DefaultComboBoxModel boxModelNXB = new DefaultComboBoxModel();

    private ArrayList<String> listDanhMucSearch = new ArrayList<>();
    private ArrayList<DanhMuc> listDM = new ArrayList<>();
    private ArrayList<TacGia> listTG = new ArrayList<>();
    private ArrayList<TheLoai> listTL = new ArrayList<>();
    private ArrayList<NPH> listNPH = new ArrayList<>();
    private ArrayList<String> listNhomTuoi = new ArrayList<>();
    private ArrayList<SachViewmodel> listSach = new ArrayList<>();
    private List<NXB> listnxb;

    private DMInterface_XT serviceDM = new DMImplement_XT();
    private TGServiceInterface serviceTG = new TGServiceImplement();
    private TLServiceInterface serviceTL = new TLServiceImplement();
    private NPHServiceInterface serviceNPH = new NPHServiceImplement();
    private final ImanageNXBService imanageNXBService = new manageNXBService();
    private SachService serviceSach = new SachserviceImpl();

    public QLSach1() {
        initComponents();
        tblDanhMuc.setModel(modelDM);
        tblTacGia.setModel(modelTG);
        tblTheLoai.setModel(modelTL);
        tblNPH.setModel(modelNPH);
        tblSach.setModel(modelSach);

        listDM = serviceDM.listDM();
        listTG = serviceTG.listTG();
        listTL = serviceTL.listTL();
        listNPH = serviceNPH.listNPH();
        listSach = serviceSach.getlist();
        listnxb = imanageNXBService.getAll();

        loadTableSach(listSach);
        loadTableTG(listTG);
        loadTableTL(listTL);
        loadTableNPH(listNPH);
        loadTableNXB();

        loadComBoNXB();
        loadComboDanhMuc();
        loadComboNPH();
        loadComBoDanhMucSearch();
        loadComboNhomTuoi();
        loadComboTacGia();
        loadComboTheLoai();

    }

    private void loadComboNhomTuoi() {
        boxModelNhomTuoi.removeAllElements();
        listNhomTuoi.add("1-4");
        listNhomTuoi.add("5-9");
        listNhomTuoi.add("10-15");
        listNhomTuoi.add("15+");
        for (String x : listNhomTuoi) {
            boxModelNhomTuoi.addElement(x);
        }
        cbNhomTuoi.setModel(boxModelNhomTuoi);
    }

    private void loadComboNhomTuoiSearch() {
        boxModelNhomTuoi.removeAllElements();
        listNhomTuoi.add("1-4");
        listNhomTuoi.add("5-9");
        listNhomTuoi.add("10-15");
        listNhomTuoi.add("15+");
        for (String x : listNhomTuoi) {
            boxModelNhomTuoi.addElement(x);
        }
        cbChiTetDanhMuc.setModel(boxModelNhomTuoi);
    }

    private void loadComBoDanhMucSearch() {
        boxModelDanhMucSearch.removeAllElements();
        listDanhMucSearch.add("Thể loại");
        listDanhMucSearch.add("Tác giả");
        listDanhMucSearch.add("Danh mục");
        listDanhMucSearch.add("NXB");
        listDanhMucSearch.add("NPH");
        listDanhMucSearch.add("Nhóm tuổi");
        for (String x : listDanhMucSearch) {
            boxModelDanhMucSearch.addElement(x);
        }
        cbDanhMucSearch.setModel(boxModelDanhMucSearch);
    }

    private void loadComboDanhMuc() {
        boxModelDM.removeAllElements();
        listDM = serviceDM.listDM();
        for (DanhMuc x : listDM) {
            boxModelDM.addElement(x.getTenDM());
        }
        cbChiTetDanhMuc.setModel(boxModelDM);
    }

    private void loadComboNPH() {
        boxModelNPH.removeAllElements();
        listNPH = serviceNPH.listNPH();
        for (NPH x : listNPH) {
            boxModelNPH.addElement(x.getTenNPH());
        }
        cbChiTetDanhMuc.setModel(boxModelNPH);
    }

    private void loadComboTacGia() {
        boxModelTG.removeAllElements();
        listTG = serviceTG.listTG();
        for (TacGia x : listTG) {
            boxModelTG.addElement(x.getTenTacGia());
        }
        cbChiTetDanhMuc.setModel(boxModelTG);
    }

    private void loadComboTheLoai() {
        boxModelTL.removeAllElements();
        listTL = serviceTL.listTL();
        for (TheLoai x : listTL) {
            boxModelTL.addElement(x.getTenTheLoai());
        }
        cbChiTetDanhMuc.setModel(boxModelTL);
    }

    private void loadTableDM(ArrayList<DanhMuc> list) {
        modelDM.setRowCount(0);
        modelDM.setColumnIdentifiers(new String[]{"Mã danh mục", "Tên danh mục"});
        for (DanhMuc x : list) {
            modelDM.addRow(new Object[]{x.getMaDM(), x.getTenDM()});
        }
    }

    private DanhMuc getDanhMuc() {
        DanhMuc x = new DanhMuc();
        x.setMaDM(Integer.valueOf(txtMaDanhMuc.getText()));
        x.setTenDM(txtTenDanhMuc.getText());
        return x;
    }

    private void loadTextFielDM(int i) {
        DanhMuc x = listDM.get(i);
        txtMaDanhMuc.setText(String.valueOf(x.getMaDM()));
        txtTenDanhMuc.setText(String.valueOf(x.getTenDM()));
    }

    private void clearDM() {
        txtMaDanhMuc.setText("");
        txtTenDanhMuc.setText("");
    }

    private void loadTableTG(ArrayList<TacGia> list) {
        modelTG.setRowCount(0);
        modelTG.setColumnIdentifiers(new String[]{"Mã tác giả", "Tên tác giả"});
        for (TacGia x : list) {
            modelTG.addRow(new Object[]{x.getMaTacGia(), x.getTenTacGia()});
        }
    }

    private TacGia getTacGia() {
        TacGia x = new TacGia();
        x.setMaTacGia(Integer.valueOf(txtMaTG.getText()));
        x.setTenTacGia(txtTenTG.getText());
        return x;
    }

    private void loatTextFieldTG(int i) {
        TacGia x = listTG.get(i);
        txtMaTG.setText(String.valueOf(x.getMaTacGia()));
        txtTenTG.setText(String.valueOf(x.getTenTacGia()));
    }

    private void clearTG() {
        txtMaTG.setText("");
        txtTenTG.setText("");
    }

    private void loadTableTL(ArrayList<TheLoai> list) {
        modelTL.setRowCount(0);
        modelTL.setColumnIdentifiers(new String[]{"Mã thể loại", "Tên thể loại"});
        for (TheLoai x : list) {
            modelTL.addRow(new Object[]{x.getMaTheLoai(), x.getTenTheLoai()});
        }
    }

    private TheLoai getTheLoai() {
        TheLoai x = new TheLoai();
        x.setMaTheLoai(Integer.valueOf(txtMaTheLoai.getText()));
        x.setTenTheLoai(txtTenTheLoai.getText());
        return x;
    }

    private void loadTextFieldTL(int i) {
        TheLoai x = listTL.get(i);
        txtMaTheLoai.setText(String.valueOf(x.getMaTheLoai()));
        txtTenTheLoai.setText(String.valueOf(x.getTenTheLoai()));
    }

    private void clearTL() {
        txtTenTheLoai.setText("");
        txtMaTheLoai.setText("");
    }

    private void loadTableNPH(ArrayList<NPH> list) {
        modelNPH.setRowCount(0);
        modelNPH.setColumnIdentifiers(new String[]{"Mã NPH", "Tên NPH"});
        for (NPH x : list) {
            modelNPH.addRow(new Object[]{x.getMaNPH(), x.getTenNPH()});
        }
    }

    private NPH getNPH() {
        NPH x = new NPH();
        x.setMaNPH(Integer.valueOf(txtMaNPH.getText()));
        x.setTenNPH(txtTenNPH.getText());
        return x;
    }

    private void loadTextFieldNPH(int i) {
        NPH x = listNPH.get(i);
        txtMaNPH.setText(String.valueOf(x.getMaNPH()));
        txtTenNPH.setText(String.valueOf(x.getTenNPH()));
    }

    private void clearNPH() {
        txtMaNPH.setText("");
        txtTenNPH.setText("");
    }

    private Sach getSach() {
        Sach x = new Sach();

        listDM = serviceDM.listDM();
        listTG = serviceTG.listTG();
        listTL = serviceTL.listTL();
        listNPH = serviceNPH.listNPH();
        listSach = serviceSach.getlist();
        listnxb = imanageNXBService.getAll();

        Integer maTacGia = 0;
        for (TacGia z : listTG) {
            if (txtTacGia.getText().equals(z.getTenTacGia())) {
                maTacGia = z.getMaTacGia();
            }
        }
        x.setMaTacGia(maTacGia);

        Integer maNPH = 0;
        for (NPH c : listNPH) {
            if (c.getTenNPH().equals(txtTacGia.getText())) {
                maNPH = c.getMaNPH();
            }
        }
        x.setMaNPH(maNPH);

        Integer maTheLoai = 0;
        for (TheLoai v : listTL) {
            if (v.getTenTheLoai().equals(txtTheLoai)) {
                maTheLoai = v.getMaTheLoai();
            }
        }
        x.setMaTheLoai(maTheLoai);

        Integer maNXB = 0;
        for (NXB b : listnxb) {
            if (b.getTenNXB().equals(txtNXB)) {
                maNXB = b.getMaNXB();
            }
        }
        x.setMaNXB(maNXB);
        Integer maDM = 0;
        for (DanhMuc n : listDM) {
            if (n.getTenDM().equals(txtDanhMuc)) {
                maDM = n.getMaDM();
            }
        }
        x.setMaDanhMuc(maDM);
        x.setNamxuatban(txtNamXuatBan.getText());
        x.setNgonNgu(txtNgonNgu.getText());
        x.setNhomTuoi((String) cbNhomTuoi.getSelectedItem());
        x.setSoluong(Integer.parseInt(txtSoLuong1.getText()));
        x.setSotrang(Integer.parseInt(txtSoTrang.getText()));
        x.setTaiBan(Integer.parseInt(txtTaiBan.getText()));
        x.setTensach(txtTenSach1.getText());
        x.setGiaban(Float.parseFloat(txtGiaBan.getText()));
        x.setNhomTuoi((String) cbNhomTuoi.getSelectedItem());
        Integer trangThai = 0;
        if (rdDangBan.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        return x;
    }

    private void loadTableSach(ArrayList<SachViewmodel> list) {
        modelSach.setRowCount(0);
        modelSach.setColumnIdentifiers(new String[]{"Mã sách", "Tên sách", "Danh mục", "Thể loại", "Nhà phát hành", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Ngôn ngữ", "Nhóm tuổi", "Tái bản", "Số trang", "Giá bán", "Số lượng", "Trạng thái"});
        for (SachViewmodel x : list) {
            modelSach.addRow(x.todDataRow());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        BackGround = new javax.swing.JPanel();
        SidePanel = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
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
        jButton9 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtMaSach1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtTenSach1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtSoTrang = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        txtSoLuong1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        rdDangBan = new javax.swing.JRadioButton();
        rdKhongBan1 = new javax.swing.JRadioButton();
        btnSua = new javax.swing.JButton();
        btnXoaSach = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        cbDanhMucSearch = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbChiTetDanhMuc = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTaiBan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        txtNgonNgu = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNamXuatBan = new javax.swing.JTextField();
        btnThemSach = new javax.swing.JButton();
        cbNhomTuoi = new javax.swing.JComboBox<>();
        btnSearchTacGia = new javax.swing.JButton();
        btnTimNPH = new javax.swing.JButton();
        btnTimTheLoai = new javax.swing.JButton();
        btnTimNXB = new javax.swing.JButton();
        btnDanhMuc = new javax.swing.JButton();
        txtTacGia = new javax.swing.JTextField();
        txtNPH = new javax.swing.JTextField();
        txtTheLoai = new javax.swing.JTextField();
        txtNXB = new javax.swing.JTextField();
        txtDanhMuc = new javax.swing.JTextField();
        btnReloadTacGia = new javax.swing.JButton();
        btnReloadNPH = new javax.swing.JButton();
        btnReloadTheLoai = new javax.swing.JButton();
        btnReloadNXB = new javax.swing.JButton();
        btnReloadDanhMuc = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        txtMaSoSachLoi = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cbNPH = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtLyDoDoi = new javax.swing.JTextField();
        btnDoiSach = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblDSSach = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblSachLoi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtMaDanhMuc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTenDanhMuc = new javax.swing.JTextField();
        btnThemDanhMuc = new javax.swing.JButton();
        btnSuaDanhMuc = new javax.swing.JButton();
        btnXoaDanhMuc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhMuc = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtMaTG = new javax.swing.JTextField();
        txtTenTG = new javax.swing.JTextField();
        btnThemTG = new javax.swing.JButton();
        btnSuaTG = new javax.swing.JButton();
        btnXoaTG = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTacGia = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtMaNPH = new javax.swing.JTextField();
        txtTenNPH = new javax.swing.JTextField();
        btnThemNPH = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblNPH = new javax.swing.JTable();
        btnSuaNPH = new javax.swing.JButton();
        btnXoaNPH = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtMaTheLoai = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTenTheLoai = new javax.swing.JTextField();
        btnThemTL = new javax.swing.JButton();
        btnSuaTL = new javax.swing.JButton();
        btnXoaTL = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTheLoai = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtmaNXB = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txttenNXB = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblNXB = new javax.swing.JTable();
        btnTL = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackGround.setBackground(new java.awt.Color(153, 255, 153));

        SidePanel.setBackground(new java.awt.Color(51, 204, 255));

        btnTrangChu.setBackground(new java.awt.Color(255, 102, 51));
        btnTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTrangChu.setText("TRANG CHỦ");
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnBanHang.setBackground(new java.awt.Color(255, 102, 51));
        btnBanHang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBanHang.setText("BÁN HÀNG");
        btnBanHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanHangActionPerformed(evt);
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

        jButton9.setBackground(new java.awt.Color(255, 102, 51));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setText("THOÁT");

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLSach, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnQLKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Mã sách");

        txtMaSach1.setEditable(false);
        txtMaSach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSach1ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Tác giả");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("NPH");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Tên sách");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("NXB");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Danh mục");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Ngôn ngữ");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Số trang");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Thể loại");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Nhóm tuổi");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Số lượng");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setText("Trạng thái");

        buttonGroup1.add(rdDangBan);
        rdDangBan.setSelected(true);
        rdDangBan.setText("Đang bán");

        buttonGroup1.add(rdKhongBan1);
        rdKhongBan1.setText("Không còn bán");

        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoaSach.setText("XOÁ");
        btnXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSachActionPerformed(evt);
            }
        });

        btnClear.setText("LÀM MỚI");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

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
        jScrollPane1.setViewportView(tblSach);

        jLabel44.setText("Lọc");

        cbDanhMucSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbDanhMucSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDanhMucSearchItemStateChanged(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("SÁCH");

        cbChiTetDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnLoc.setText("Tìm");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel44)
                .addGap(18, 18, 18)
                .addComponent(cbDanhMucSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbChiTetDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addGap(89, 89, 89))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDanhMucSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(cbChiTetDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoc))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setText("Tai ban");

        jLabel10.setText("Gia ban");

        jLabel11.setText("Nam xuat ban");

        btnThemSach.setText("Thêm");
        btnThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSachActionPerformed(evt);
            }
        });

        cbNhomTuoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSearchTacGia.setText("*");
        btnSearchTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTacGiaActionPerformed(evt);
            }
        });

        btnTimNPH.setText("*");
        btnTimNPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimNPHActionPerformed(evt);
            }
        });

        btnTimTheLoai.setText("*");
        btnTimTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimTheLoaiActionPerformed(evt);
            }
        });

        btnTimNXB.setText("*");
        btnTimNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimNXBActionPerformed(evt);
            }
        });

        btnDanhMuc.setText("*");
        btnDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhMucActionPerformed(evt);
            }
        });

        txtTacGia.setEditable(false);

        txtNPH.setEditable(false);

        txtTheLoai.setEditable(false);

        btnReloadTacGia.setText("+");
        btnReloadTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadTacGiaActionPerformed(evt);
            }
        });

        btnReloadNPH.setText("+");
        btnReloadNPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadNPHActionPerformed(evt);
            }
        });

        btnReloadTheLoai.setText("+");
        btnReloadTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadTheLoaiActionPerformed(evt);
            }
        });

        btnReloadNXB.setText("+");
        btnReloadNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadNXBActionPerformed(evt);
            }
        });

        btnReloadDanhMuc.setText("+");
        btnReloadDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReloadDanhMucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbNhomTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel41)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel11))
                                            .addGap(38, 38, 38))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                            .addComponent(btnClear)
                                            .addGap(18, 18, 18)))
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addComponent(btnThemSach)
                                            .addGap(21, 21, 21)
                                            .addComponent(btnXoaSach)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnSua))
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtTaiBan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                            .addComponent(txtSoLuong1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNamXuatBan))))
                                .addGroup(jPanel14Layout.createSequentialGroup()
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel31)
                                                    .addComponent(jLabel32))
                                                .addGap(61, 61, 61))
                                            .addGroup(jPanel14Layout.createSequentialGroup()
                                                .addComponent(jLabel33)
                                                .addGap(84, 84, 84)))
                                        .addGroup(jPanel14Layout.createSequentialGroup()
                                            .addComponent(jLabel39)
                                            .addGap(65, 65, 65)))
                                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMaSach1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                        .addComponent(txtTacGia)
                                        .addComponent(txtNPH)
                                        .addComponent(txtTheLoai)))))
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(btnTimNPH)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnReloadNPH))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(btnTimTheLoai)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnReloadTheLoai))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(btnSearchTacGia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnReloadTacGia)))
                                .addGap(96, 96, 96)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGap(152, 152, 152)
                                .addComponent(jLabel34)))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                                        .addGap(0, 1, Short.MAX_VALUE)
                                        .addComponent(txtNgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(rdDangBan)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdKhongBan1))
                                    .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDanhMuc))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDanhMuc))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNXB)
                                    .addComponent(txtTenSach1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTimNXB)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnReloadNXB)
                            .addComponent(btnReloadDanhMuc))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtMaSach1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(txtTenSach1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel35)
                    .addComponent(btnSearchTacGia)
                    .addComponent(btnTimNXB)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReloadTacGia)
                    .addComponent(btnReloadNXB))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel36)
                    .addComponent(btnTimNPH)
                    .addComponent(btnDanhMuc)
                    .addComponent(txtNPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReloadNPH)
                    .addComponent(btnReloadDanhMuc))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel39)
                    .addComponent(txtNgonNgu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimTheLoai)
                    .addComponent(txtTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReloadTheLoai))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(cbNhomTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(txtSoLuong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42)
                    .addComponent(rdDangBan)
                    .addComponent(rdKhongBan1))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thông tin sách", jPanel14);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Mã số sách lỗi");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Mã sách");

        jLabel28.setText("NPH");

        cbNPH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Số lượng");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Lý do ");

        btnDoiSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDoiSach.setText("Đổi sách");

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLamMoi.setText("Làm mới");

        btnHuy.setText("Huỷ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("DANH SÁCH SÁCH");

        tblDSSach.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(tblDSSach);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 1033, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("DANH SÁCH SÁCH LỖI");

        tblSachLoi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tblSachLoi);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane8)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jLabel28)
                    .addComponent(jLabel30))
                .addGap(40, 40, 40)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSoSachLoi)
                    .addComponent(cbNPH, 0, 213, Short.MAX_VALUE)
                    .addComponent(txtLyDoDoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29))
                .addGap(55, 55, 55)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaSach)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(312, Short.MAX_VALUE)
                .addComponent(btnDoiSach)
                .addGap(141, 141, 141)
                .addComponent(btnLamMoi)
                .addGap(168, 168, 168)
                .addComponent(btnHuy)
                .addGap(193, 193, 193))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtMaSoSachLoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbNPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtLyDoDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDoiSach)
                    .addComponent(btnLamMoi)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sách lỗi", jPanel11);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setText("Mã danh mục");

        txtMaDanhMuc.setEditable(false);

        jLabel15.setText("Tên danh mục");

        btnThemDanhMuc.setText("Thêm");
        btnThemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDanhMucActionPerformed(evt);
            }
        });

        btnSuaDanhMuc.setText("Sửa");
        btnSuaDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDanhMucActionPerformed(evt);
            }
        });

        btnXoaDanhMuc.setText("Xoá");
        btnXoaDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDanhMucActionPerformed(evt);
            }
        });

        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhMuc);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("DANH MỤC");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(btnThemDanhMuc)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addComponent(btnSuaDanhMuc)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoaDanhMuc)))))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemDanhMuc)
                    .addComponent(btnSuaDanhMuc)
                    .addComponent(btnXoaDanhMuc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setText("Tên tác giả");

        jLabel18.setText("Mã tác giả");

        txtMaTG.setEditable(false);

        btnThemTG.setText("Thêm");
        btnThemTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTGActionPerformed(evt);
            }
        });

        btnSuaTG.setText("Sửa");
        btnSuaTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTGActionPerformed(evt);
            }
        });

        btnXoaTG.setText("Xoá");
        btnXoaTG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTGActionPerformed(evt);
            }
        });

        tblTacGia.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTacGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTacGiaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTacGia);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("TÁC GIẢ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThemTG)
                        .addGap(24, 24, 24)
                        .addComponent(btnSuaTG)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaTG)
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaTG))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(txtTenTG)))
                        .addGap(18, 18, 18))))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMaTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtTenTG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTG)
                    .addComponent(btnSuaTG)
                    .addComponent(btnXoaTG))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel20.setText("Mã NPH");

        jLabel21.setText("Tên NPH");

        txtMaNPH.setEditable(false);

        btnThemNPH.setText("Thêm");
        btnThemNPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNPHActionPerformed(evt);
            }
        });

        tblNPH.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNPH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNPHMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblNPH);

        btnSuaNPH.setText("Sửa");
        btnSuaNPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNPHActionPerformed(evt);
            }
        });

        btnXoaNPH.setText("Xoá");
        btnXoaNPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNPHActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("NHÀ PHÁT HÀNH");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnThemNPH)
                        .addGap(34, 34, 34)
                        .addComponent(btnXoaNPH)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaNPH)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaNPH, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txtTenNPH))
                        .addGap(43, 43, 43))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtMaNPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTenNPH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemNPH)
                    .addComponent(btnXoaNPH)
                    .addComponent(btnSuaNPH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setText("Mã thể loại");

        txtMaTheLoai.setEditable(false);

        jLabel17.setText("Tên thể loại");

        btnThemTL.setText("Thêm");
        btnThemTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTLActionPerformed(evt);
            }
        });

        btnSuaTL.setText("Sửa");
        btnSuaTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTLActionPerformed(evt);
            }
        });

        btnXoaTL.setText("Xoá");
        btnXoaTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTLActionPerformed(evt);
            }
        });

        tblTheLoai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTheLoaiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTheLoai);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("THỂ LOẠI");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtMaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnThemTL)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaTL)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaTL))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtMaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTL)
                    .addComponent(btnSuaTL)
                    .addComponent(btnXoaTL))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setText("Mã NXB");

        jLabel23.setText("Tên NXB");

        tblNXB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NXB", "Tên NXB"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNXBMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblNXB);

        btnTL.setText("Thêm");
        btnTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTLActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xoá");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("NHÀ XUẤT BẢN");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(36, 36, 36)
                        .addComponent(txtmaNXB))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttenNXB)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnsua)
                                .addGap(18, 18, 18)
                                .addComponent(btnxoa)
                                .addGap(0, 22, Short.MAX_VALUE)))))
                .addGap(31, 31, 31))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTL)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtmaNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txttenNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTL)
                    .addComponent(btnsua)
                    .addComponent(btnxoa))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(33, 33, 33)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(132, 132, 132)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thuộc tính sách", jPanel2);

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQLKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLKhachHangActionPerformed

    }//GEN-LAST:event_btnQLKhachHangActionPerformed

    private void btnQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNhanVienActionPerformed
        this.dispose();
        new QLNhanVien_().setVisible(true);
    }//GEN-LAST:event_btnQLNhanVienActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed
        this.dispose();
        new BanHang1().setVisible(true);
    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        this.dispose();
        new MainApp().setVisible(true);
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnQLSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSachActionPerformed
        this.dispose();
        new QLSach1().setVisible(true);
    }//GEN-LAST:event_btnQLSachActionPerformed

    private void txtMaSach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSach1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSach1ActionPerformed

    private void btnThemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDanhMucActionPerformed
        DanhMuc x = new DanhMuc(txtTenDanhMuc.getText());
        JOptionPane.showMessageDialog(this, serviceDM.themDM(x));
        listDM = serviceDM.listDM();
        loadTableDM(listDM);
        clearDM();
    }//GEN-LAST:event_btnThemDanhMucActionPerformed

    private void btnSuaDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDanhMucActionPerformed
        int temp = tblDanhMuc.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            DanhMuc x = getDanhMuc();
            JOptionPane.showMessageDialog(this, serviceDM.suaDM(x));
            listDM = serviceDM.listDM();
            loadTableDM(listDM);
        }
    }//GEN-LAST:event_btnSuaDanhMucActionPerformed

    private void btnXoaDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDanhMucActionPerformed
        int temp = tblDanhMuc.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?");
            if (choice == JOptionPane.OK_OPTION) {
                DanhMuc x = getDanhMuc();
                JOptionPane.showMessageDialog(this, serviceDM.xoaDM(x));
                listDM = serviceDM.listDM();
                loadTableDM(listDM);
                clearDM();
            }
        }
    }//GEN-LAST:event_btnXoaDanhMucActionPerformed

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked
        int temp = tblDanhMuc.getSelectedRow();
        loadTextFielDM(temp);
    }//GEN-LAST:event_tblDanhMucMouseClicked

    private void btnThemTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTGActionPerformed
        TacGia x = new TacGia(txtTenTG.getText());
        JOptionPane.showMessageDialog(this, serviceTG.themTG(x));
        listTG = serviceTG.listTG();
        loadTableTG(listTG);
        clearTG();
    }//GEN-LAST:event_btnThemTGActionPerformed

    private void btnSuaTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTGActionPerformed
        int temp = tblTacGia.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            TacGia x = getTacGia();
            JOptionPane.showMessageDialog(this, serviceTG.suaTG(x));
            listTG = serviceTG.listTG();
            loadTableTG(listTG);
        }
    }//GEN-LAST:event_btnSuaTGActionPerformed

    private void btnXoaTGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTGActionPerformed
        int temp = tblTacGia.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?");
            if (choice == JOptionPane.OK_OPTION) {
                TacGia x = getTacGia();
                JOptionPane.showMessageDialog(this, serviceTG.xoaTG(x));
                listTG = serviceTG.listTG();
                loadTableTG(listTG);
                clearTG();
            }
        }
    }//GEN-LAST:event_btnXoaTGActionPerformed

    private void tblTacGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTacGiaMouseClicked
        int temp = tblTacGia.getSelectedRow();
        loatTextFieldTG(temp);
    }//GEN-LAST:event_tblTacGiaMouseClicked

    private void btnThemNPHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNPHActionPerformed
        NPH x = new NPH(txtTenNPH.getText());
        JOptionPane.showMessageDialog(this, serviceNPH.themNPH(x));
        listNPH = serviceNPH.listNPH();
        loadTableNPH(listNPH);
        clearNPH();
    }//GEN-LAST:event_btnThemNPHActionPerformed

    private void tblNPHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNPHMouseClicked
        int temp = tblNPH.getSelectedRow();
        loadTextFieldNPH(temp);
    }//GEN-LAST:event_tblNPHMouseClicked

    private void btnSuaNPHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNPHActionPerformed
        int temp = tblNPH.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            NPH x = getNPH();
            JOptionPane.showMessageDialog(this, serviceNPH.suaNPH(x));
            listNPH = serviceNPH.listNPH();
            loadTableNPH(listNPH);
        }
    }//GEN-LAST:event_btnSuaNPHActionPerformed

    private void btnXoaNPHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNPHActionPerformed
        int temp = tblNPH.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?");
            if (choice == JOptionPane.OK_OPTION) {
                NPH x = getNPH();
                JOptionPane.showMessageDialog(this, serviceNPH.suaNPH(x));
                listNPH = serviceNPH.listNPH();
                loadTableNPH(listNPH);
                clearNPH();
            }
        }
    }//GEN-LAST:event_btnXoaNPHActionPerformed

    private void btnThemTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTLActionPerformed
        TheLoai x = new TheLoai(txtTenTheLoai.getText());
        JOptionPane.showMessageDialog(this, serviceTL.themTL(x));
        listTL = serviceTL.listTL();
        loadTableTL(listTL);
        clearTL();
    }//GEN-LAST:event_btnThemTLActionPerformed

    private void btnSuaTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTLActionPerformed
        int temp = tblTheLoai.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            TheLoai x = getTheLoai();
            JOptionPane.showMessageDialog(this, serviceTL.suaTL(x));
            listTL = serviceTL.listTL();
            loadTableTL(listTL);
        }
    }//GEN-LAST:event_btnSuaTLActionPerformed

    private void btnXoaTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTLActionPerformed
        int temp = tblTheLoai.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá không ?");
            if (choice == JOptionPane.OK_OPTION) {
                TheLoai x = getTheLoai();
                JOptionPane.showMessageDialog(this, serviceTL.xoaTL(x));
                listTL = serviceTL.listTL();
                loadTableTL(listTL);
                clearTL();
            }
        }
    }//GEN-LAST:event_btnXoaTLActionPerformed

    private void tblTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTheLoaiMouseClicked
        int temo = tblTheLoai.getSelectedRow();
        loadTextFieldTL(temo);
    }//GEN-LAST:event_tblTheLoaiMouseClicked

    private void btnTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTLActionPerformed
        if (txttenNXB.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên NXB");
            return;
        }
        NXB nxb = getNXBFromInput();
        if (imanageNXBService.add(nxb) != null) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
        loadTableNXB();
        clearformNXB();
    }//GEN-LAST:event_btnTLActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        int row = tblNXB.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên table để sửa");
            return;
        }

        if (txttenNXB.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên NXB");
            return;
        }
        String maNXB = tblNXB.getValueAt(row, 0).toString();
        NXB nxb = getNXBFromInput();
        if (imanageNXBService.update(maNXB, nxb) != null) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
        loadTableNXB();
        clearformNXB();
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        int row = tblNXB.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trên table để Xóa");
            return;
        }
        String maNXB = tblNXB.getValueAt(row, 0).toString();
        if (imanageNXBService.delete(maNXB) != null) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
        loadTableNXB();
        clearformNXB();
    }//GEN-LAST:event_btnxoaActionPerformed

    private void tblNXBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNXBMouseClicked
        int row = tblNXB.getSelectedRow();
        txtmaNXB.setText(tblNXB.getValueAt(row, 0).toString());
        txttenNXB.setText(tblNXB.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tblNXBMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String text = txtTimKiem.getText();
        ArrayList<SachViewmodel> listSearch = serviceSach.listSearch(listSach, text);
        loadTableSach(listSach);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int temp = tblSach.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            Integer maSach = Integer.valueOf(txtMaSach1.getText());
            Boolean check = themSach();
            if (check) {
                Sach x = getSach();
                JOptionPane.showMessageDialog(this, serviceSach.update(x, maSach));
                listSach = serviceSach.getlist();
                loadTableSach(listSach);
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSachActionPerformed
        int temp = tblSach.getSelectedRow();
        if (temp < 0) {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
        } else {
            int choice = JOptionPane.showConfirmDialog(this, "Ban co muon xoa khong?");
            if (choice == JOptionPane.OK_OPTION) {
                Integer maSach = Integer.valueOf(txtMaSach1.getText());
                JOptionPane.showMessageDialog(this, serviceSach.delete(maSach));
                listSach = serviceSach.getlist();
                loadTableSach(listSach);
            }
        }
    }//GEN-LAST:event_btnXoaSachActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtGiaBan.setText("");
        txtNgonNgu.setText("");
        txtNamXuatBan.setText("");
        txtTaiBan.setText("");
        txtSoLuong1.setText("");
        txtTenSach1.setText("");
        txtMaSach1.setText("");
        txtGiaBan.setText("");
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        int temp = tblSach.getSelectedRow();
        SachViewmodel x = listSach.get(temp);
        txtMaSach1.setText(String.valueOf(x.getMasach()));
        txtTenSach1.setText(String.valueOf(x.getTensach()));
        txtTacGia.setText(String.valueOf(x.getTenTacGia()));
        txtDanhMuc.setText(String.valueOf(x.getTenDanhMuc()));
        txtNXB.setText(String.valueOf(x.getTenNXB()));
        txtNPH.setText(String.valueOf(x.getTenNPH()));
        txtTheLoai.setText(String.valueOf(x.getTenTheLoai()));
        txtNgonNgu.setText(String.valueOf(x.getNgonNgu()));
        txtSoTrang.setText(String.valueOf(x.getSotrang()));
        txtSoLuong1.setText(String.valueOf(x.getSoluong()));
        txtTaiBan.setText(String.valueOf(x.getTaiBan()));
        txtNamXuatBan.setText(String.valueOf(x.getNamxuatban()));
        txtGiaBan.setText(String.valueOf(x.getGiaban()));
        cbNhomTuoi.setSelectedItem(x.getNhomTuoi());
        if (x.getTrangthai() == 1) {
            rdDangBan.setSelected(true);
        } else {
            rdKhongBan1.setSelected(true);
        }
    }//GEN-LAST:event_tblSachMouseClicked

    private void btnThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSachActionPerformed
//        Boolean check = themSach();
////        if (check) {
        Sach x = getSach();
        JOptionPane.showMessageDialog(this, serviceSach.add(x));
        listSach = serviceSach.getlist();
        loadTableSach(listSach);
//        } else {
//            JOptionPane.showMessageDialog(this, "Vui long xem lai du lieu");
//        }
    }//GEN-LAST:event_btnThemSachActionPerformed

    private void btnSearchTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTacGiaActionPerformed
        String text = JOptionPane.showInputDialog(this, "Nhập tên tác giả cần tìm");
        TacGia x = serviceTG.timTG(listTG, text);
        if (x.getTenTacGia() == null) {
            JOptionPane.showMessageDialog(this, "Khong co tac gia, vui long thu lai hoac tao moi");
            int choice = JOptionPane.showConfirmDialog(this, "Ban co muon tao moi tac gia khong?");
            if (choice == JOptionPane.OK_OPTION) {
                new FomTacGia_Mini().setVisible(true);
            }
        } else {
            txtTacGia.setText(x.getTenTacGia());
        }
    }//GEN-LAST:event_btnSearchTacGiaActionPerformed

    private void btnTimNPHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimNPHActionPerformed
        String text = JOptionPane.showInputDialog(this, "Nhập tên NPH cần tìm");
        NPH x = serviceNPH.timNPH(listNPH, text);
        if (x.getTenNPH() == null) {
            JOptionPane.showMessageDialog(this, "Khong co NPH, vui long thu lai hoac tao moi");
            int choice = JOptionPane.showConfirmDialog(this, "Ban co muon tao moi NPH khong?");
            if (choice == JOptionPane.OK_OPTION) {
                new FormNPH_Mini().setVisible(true);
            }
        } else {
            txtNPH.setText(x.getTenNPH());
        }
    }//GEN-LAST:event_btnTimNPHActionPerformed

    private void btnTimTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimTheLoaiActionPerformed
        String text = JOptionPane.showInputDialog(this, "Nhập tên thể loại cần tìm");
        TheLoai x = serviceTL.timTheLoai(listTL, text);
        if (x.getTenTheLoai() == null) {
            JOptionPane.showMessageDialog(this, "Khong co the loai, vui long thu lai hoac tao moi");
            int choice = JOptionPane.showConfirmDialog(this, "Ban co muon tao moi the loai khong?");
            if (choice == JOptionPane.OK_OPTION) {
                new FormTheLoai_Mini().setVisible(true);
            }
        } else {
            txtTheLoai.setText(x.getTenTheLoai());
        }
    }//GEN-LAST:event_btnTimTheLoaiActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        String text = (String) cbChiTetDanhMuc.getSelectedItem();
        ArrayList<SachViewmodel> listLoc = serviceSach.listLoc(listSach, text);
        loadTableSach(listLoc);
    }//GEN-LAST:event_btnLocActionPerformed

    private void cbDanhMucSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDanhMucSearchItemStateChanged
        String text = (String) cbDanhMucSearch.getSelectedItem();
        if (text.equalsIgnoreCase("Tác giả")) {
            loadComboTacGia();
        }
        if (text.equalsIgnoreCase("Thể loại")) {
            loadComboTheLoai();
        }
        if (text.equalsIgnoreCase("NXB")) {
            loadComBoNXB();
        }
        if (text.equalsIgnoreCase("Danh mục")) {
            loadComboDanhMuc();
        }
        if (text.equalsIgnoreCase("NPH")) {
            loadComboNPH();
        }
        if (text.equalsIgnoreCase("Nhóm tuổi")) {
            loadComboNhomTuoiSearch();
        }
    }//GEN-LAST:event_cbDanhMucSearchItemStateChanged

    private void btnReloadTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadTacGiaActionPerformed
        listTG = serviceTG.listTG();
    }//GEN-LAST:event_btnReloadTacGiaActionPerformed

    private void btnReloadNPHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadNPHActionPerformed
        listNPH = serviceNPH.listNPH();
    }//GEN-LAST:event_btnReloadNPHActionPerformed

    private void btnReloadTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadTheLoaiActionPerformed
        listTL = serviceTL.listTL();
    }//GEN-LAST:event_btnReloadTheLoaiActionPerformed

    private void btnReloadNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadNXBActionPerformed

    }//GEN-LAST:event_btnReloadNXBActionPerformed

    private void btnReloadDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReloadDanhMucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReloadDanhMucActionPerformed

    private void btnTimNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimNXBActionPerformed
        String text = JOptionPane.showInputDialog(this, "Nhập tên nxb cần tìm");
        NXB x = imanageNXBService.timNXB(listnxb, text);
        if (x.getTenNXB() == null) {
            JOptionPane.showMessageDialog(this, "Khong co nxb, vui long thu lai hoac tao moi");
            int choice = JOptionPane.showConfirmDialog(this, "Ban co muon tao moi nxb khong?");
            if (choice == JOptionPane.OK_OPTION) {
                new FormNXB_Mini().setVisible(true);
            }
        } else {
            txtDanhMuc.setText(x.getTenNXB());
        }
    }//GEN-LAST:event_btnTimNXBActionPerformed

    private void btnDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhMucActionPerformed
        String text = JOptionPane.showInputDialog(this, "Nhập tên danh mục cần tìm");
        DanhMuc x = serviceDM.timDanhMuc(listDM, text);
        if (x.getTenDM() == null) {
            JOptionPane.showMessageDialog(this, "Khong co danh muc, vui long thu lai hoac tao moi");
            int choice = JOptionPane.showConfirmDialog(this, "Ban co muon tao moi danh muc khong?");
            if (choice == JOptionPane.OK_OPTION) {
                new FormDanhMuc_Mini().setVisible(true);
            }
        } else {
            txtDanhMuc.setText(x.getTenDM());
        }
    }//GEN-LAST:event_btnDanhMucActionPerformed

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
            java.util.logging.Logger.getLogger(QLSach1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSach1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSach1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSach1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new QLSach1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDanhMuc;
    private javax.swing.JButton btnDoiSach;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnQLHoaDon;
    private javax.swing.JButton btnQLKhachHang;
    private javax.swing.JButton btnQLNhanVien;
    private javax.swing.JButton btnQLSach;
    private javax.swing.JButton btnReloadDanhMuc;
    private javax.swing.JButton btnReloadNPH;
    private javax.swing.JButton btnReloadNXB;
    private javax.swing.JButton btnReloadTacGia;
    private javax.swing.JButton btnReloadTheLoai;
    private javax.swing.JButton btnSearchTacGia;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaDanhMuc;
    private javax.swing.JButton btnSuaNPH;
    private javax.swing.JButton btnSuaTG;
    private javax.swing.JButton btnSuaTL;
    private javax.swing.JButton btnTL;
    private javax.swing.JButton btnThemDanhMuc;
    private javax.swing.JButton btnThemNPH;
    private javax.swing.JButton btnThemSach;
    private javax.swing.JButton btnThemTG;
    private javax.swing.JButton btnThemTL;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimNPH;
    private javax.swing.JButton btnTimNXB;
    private javax.swing.JButton btnTimTheLoai;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnXoaDanhMuc;
    private javax.swing.JButton btnXoaNPH;
    private javax.swing.JButton btnXoaSach;
    private javax.swing.JButton btnXoaTG;
    private javax.swing.JButton btnXoaTL;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnxoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbChiTetDanhMuc;
    private javax.swing.JComboBox<String> cbDanhMucSearch;
    private javax.swing.JComboBox<String> cbNPH;
    private javax.swing.JComboBox<String> cbNhomTuoi;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdDangBan;
    private javax.swing.JRadioButton rdKhongBan1;
    private javax.swing.JTable tblDSSach;
    private javax.swing.JTable tblDanhMuc;
    private javax.swing.JTable tblNPH;
    private javax.swing.JTable tblNXB;
    private javax.swing.JTable tblSach;
    private javax.swing.JTable tblSachLoi;
    private javax.swing.JTable tblTacGia;
    private javax.swing.JTable tblTheLoai;
    private javax.swing.JTextField txtDanhMuc;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtLyDoDoi;
    private javax.swing.JTextField txtMaDanhMuc;
    private javax.swing.JTextField txtMaNPH;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMaSach1;
    private javax.swing.JTextField txtMaSoSachLoi;
    private javax.swing.JTextField txtMaTG;
    private javax.swing.JTextField txtMaTheLoai;
    private javax.swing.JTextField txtNPH;
    private javax.swing.JTextField txtNXB;
    private javax.swing.JTextField txtNamXuatBan;
    private javax.swing.JTextField txtNgonNgu;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoLuong1;
    private javax.swing.JTextField txtSoTrang;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTaiBan;
    private javax.swing.JTextField txtTenDanhMuc;
    private javax.swing.JTextField txtTenNPH;
    private javax.swing.JTextField txtTenSach1;
    private javax.swing.JTextField txtTenTG;
    private javax.swing.JTextField txtTenTheLoai;
    private javax.swing.JTextField txtTheLoai;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtmaNXB;
    private javax.swing.JTextField txttenNXB;
    // End of variables declaration//GEN-END:variables

    private void loadTableNXB() {
        DefaultTableModel tblmodelNXB = (DefaultTableModel) tblNXB.getModel();
        tblmodelNXB.setRowCount(0);
        listnxb = imanageNXBService.getAll();

        for (NXB nxb : listnxb) {
            tblmodelNXB.addRow(new Object[]{nxb.getMaNXB(), nxb.getTenNXB()});
        }
    }

    private NXB getNXBFromInput() {
        NXB nxb = new NXB();
        nxb.setTenNXB(txttenNXB.getText());
        return nxb;
    }

    private void clearformNXB() {
        txtmaNXB.setText("");
        txttenNXB.setText("");
    }

    private void loadComBoNXB() {
        boxModelNXB.removeAllElements();
        listnxb = imanageNXBService.getAll();
        for (NXB x : listnxb) {
            boxModelNXB.addElement(x.getTenNXB());
        }
        cbChiTetDanhMuc.setModel(boxModelNXB);
    }

    private boolean themSach() {
        Boolean check = true;
        if (txtGiaBan.getText().isBlank() || txtNamXuatBan.getText().isBlank() || txtNgonNgu.getText().isBlank() || txtSoLuong1.getText().isBlank() || txtSoTrang.getText().isBlank() || txtTaiBan.getText().isBlank() || txtTenSach1.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Con trong du lieu");
            return false;
        }
        String regex = "^[a-zA-Z]*$";
        if (!txtTenSach1.getText().matches(regex)) {
            JOptionPane.showMessageDialog(this, "Ten sach chi duoc la chu");
            return false;
        }
        try {
            Integer soLuong = Integer.parseInt(txtSoLuong1.getText());
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(this, "So luong phai lon hon 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "So luong phai là so");
            return false;
        }
        try {
            Integer soTrang = Integer.parseInt(txtSoTrang.getText());
            if (soTrang <= 0) {
                JOptionPane.showMessageDialog(this, "So trang phai lon hon 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "So trang phai la so");
            return false;
        }
        try {
            Integer soTaiBan = Integer.parseInt(txtTaiBan.getText());
            if (soTaiBan <= 0) {
                JOptionPane.showMessageDialog(this, "So tai ban phai lon hon 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "So tai ban phai la so");
            return false;
        }
        try {
            Integer namXuatBan = Integer.parseInt(txtNamXuatBan.getText());
            if (namXuatBan <= 0) {
                JOptionPane.showMessageDialog(this, "Nam xuat ban phai lon hon 0");
                return false;
            }
            if (namXuatBan > 2022) {
                JOptionPane.showMessageDialog(this, "Nam xuat ban phai nho hon 2022");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nam xuat ban phai la so");
            return false;
        }
        try {
            Float giaBan = Float.parseFloat(txtGiaBan.getText());
            if (0 > giaBan) {
                JOptionPane.showMessageDialog(this, "Gia ban phai lon hon 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gia ban phai la so");
            return false;
        }
        return check;
    }
}
