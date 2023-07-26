package View;

import DomainModel.TraHang;
import ServiceImplement.HoaDonCTVMServiceImplement;
import ServiceImplement.HoaDonVMServiceImplement;
//import ServiceImplement.TraHangServiceImpl;
import ServiceInterface.HoaDonCTVMServiccecInterface;
import ServiceInterface.HoaDonVMServiceInterface;
import Utilities.DBConection;
import ViewModel.HoaDonCTVM;
import ViewModel.HoaDonVM;
//import ViewModel.QLHoaDon;
//import ViewModel.QLTraHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Long
 */
public class FormTraHang extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModelCTHD;
    private DefaultTableModel defauhdct;

    private HoaDonCTVMServiccecInterface hdct = new HoaDonCTVMServiceImplement();
    private HoaDonVMServiceInterface hoadonVMServiceInterface;
    private List<HoaDonVM> list;

    public FormTraHang() {
        initComponents();
        setLocationRelativeTo(null);
        hoadonVMServiceInterface = new HoaDonVMServiceImplement();
        list = hoadonVMServiceInterface.listHD();
        loadtable(list);
    }

    private void loadtable(List<HoaDonVM> list) {
        DefaultTableModel tblmodel = (DefaultTableModel) tblQLHD.getModel();
        tblmodel.setRowCount(0);

        for (HoaDonVM hDVM : list) {
            tblmodel.addRow(new Object[]{hDVM.getMaHoaDon(),
                hDVM.getMaKhachHang(),
                hDVM.getMaNhanVien(),
                hDVM.getNgayTao(),
                hDVM.getTongTien(),
                hDVM.getTrangThai()});
        }
    }

    private void loadhdct(ArrayList<HoaDonCTVM> listhdct) {
        defauhdct = (DefaultTableModel) tblHDCT.getModel();
        defauhdct.setRowCount(0);
        for (HoaDonCTVM hoaDonCTVM : listhdct) {
            defauhdct.addRow(new Object[]{hoaDonCTVM.getMaHoaDonCT(),
                //             hoaDonCTVM.getMaHoaDon(),
                hoaDonCTVM.getMaSach(),
                hoaDonCTVM.getMaSach(),
                hoaDonCTVM.getSoLuong(),
                hoaDonCTVM.getDonGia()});

        }

    }

    private TraHang getTraHang() {
        TraHang x = new TraHang();
        x.setMaPTH(txtmapth.getText());
        x.setMaHD(txtmahd.getText());
        x.setMaKH(txtmakh.getText());
        x.setMaNV(txtmanv.getText());
        x.setNgayTra(txtngaytra.getText());
        x.setTienTraLai(Float.parseFloat(txtsotientralai.getText()));
        x.setLyDo(txtlydo.getText());
        return x;
    }

//    private void loadTraHang(int i) {
//        QLTraHang x = listTraHang.get(i);
//        txtmapth.setText(x.getMaPTH());
//        txtmahd.setText(x.getMaHD() + "");
//        txtmakh.setText(x.getMaKH());
//        txtmanv.setText(x.getMaNV());
//        txtngaytra.setText(x.getNgayTra() + "");
//        txtsotientralai.setText(x.getTienTraLai() + "");
//        txtlydo.setText(x.getLyDo());
//
//    }
//
//    private QLHoaDon getHoaDon() {
//        QLHoaDon x = new QLHoaDon();
//
//        x.setMaHoaDon(txtmahd.getText());
//        x.setMaKhachHang(txtmakh.getText());
//        x.setMaNhanVien(txtmanv.getText());
//        txtngaytao.setText(String.valueOf(x.getNgayTao()));
//        return x;
//    }
//
//    private void loadHoaDon(int i) {
//        QLHoaDon x = listHoaDon.get(i);
//        txtmahd.setText(x.getMaHoaDon() + "");
//        txtmakh.setText(x.getMaKhachHang());
//        txtmanv.setText(x.getMaNhanVien());
//        txtngaytao.setText(x.getNgayTao() + "");
//
//    }
    private void clearForm() {
        txtlydo.setText("");
        txtmahd.setText("");
        txtmakh.setText("");
        txtmanv.setText("");
        txtmapth.setText("");
        txtngaytra.setText("");
        txtngaytao.setText("");
        txtsotientralai.setText("");
        txttongtien.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SidePanel = new javax.swing.JPanel();
        btnTrangChu = new javax.swing.JButton();
        btnBanHang = new javax.swing.JButton();
        btnQLSach = new javax.swing.JButton();
        btnQLHoaDon = new javax.swing.JButton();
        btnQLNhanVien = new javax.swing.JButton();
        btnQLKhachHang = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtmakh = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtmahd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtngaytra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltrahang = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtmapth = new javax.swing.JTextField();
        txtmanv = new javax.swing.JTextField();
        txtlydo = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQLHD = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtngaytao = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txttongtien = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtsotientralai = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();

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
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Quản Lý Trả Hàng");

        jLabel1.setText("Mã PTH");

        jLabel2.setText("Mã KH");

        jLabel3.setText("Mã NV");

        jLabel4.setText("Lý do Trả");

        jLabel5.setText("Mã HĐ");

        jLabel6.setText("Ngày Trả");

        tbltrahang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã PTH", "Mã HĐ", "Mã KH", "Mã NV", "Tổng tiền", "Ngày tạo", "Ngày trả", "Số tiền trả lại", "Lý do trả"
            }
        ));
        tbltrahang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltrahangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbltrahang);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Thông tin trả hàng");

        btnthem.setText("thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Danh Sách");

        btntimkiem.setText("tìm kiếm");

        btnsua.setText("sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("xoá");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnlammoi.setText("làm mới");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        tblQLHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã KH", "Mã NV", "Ngày tạo", "Tổng tiền", "Trạng thái"
            }
        ));
        tblQLHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblQLHD);

        jLabel10.setText("Ngày tạo");

        jLabel12.setText("Tổng tiền");

        jLabel11.setText("số tiền trả lại");

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐCT", "Mã HD", "Mã Sách", "Số Lượng", "Đơn giá"
            }
        ));
        jScrollPane4.setViewportView(tblHDCT);

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator8)
                    .addComponent(jSeparator7)
                    .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQLSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQLHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator6)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator4)
                    .addComponent(btnQLNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator5)
                    .addComponent(btnQLKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SidePanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(SidePanelLayout.createSequentialGroup()
                                        .addGap(363, 363, 363)
                                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(SidePanelLayout.createSequentialGroup()
                                                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(34, 34, 34)
                                                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtngaytra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                                    .addComponent(txtngaytao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtmahd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                                    .addComponent(txtmakh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(SidePanelLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtsotientralai))))))
                            .addGroup(SidePanelLayout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SidePanelLayout.createSequentialGroup()
                                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(28, 28, 28)
                                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmapth, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(SidePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(SidePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(SidePanelLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnthem)
                                                .addGap(78, 78, 78)
                                                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(SidePanelLayout.createSequentialGroup()
                                                .addComponent(txtlydo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(63, 63, 63)
                                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidePanelLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)))))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1)))))
        );

        SidePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnThongKe, jButton1});

        SidePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtlydo, txtmahd, txtmakh, txtmanv, txtmapth, txtngaytao, txtngaytra, txtsotientralai, txttongtien});

        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQLSach, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQLHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQLNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SidePanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQLKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtmapth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtmakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtmanv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtlydo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtngaytra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtsotientralai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnthem)
                            .addComponent(btnsua)
                            .addComponent(btnxoa)
                            .addComponent(btnlammoi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btntimkiem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        SidePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnThongKe, jButton1});

        SidePanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtlydo, txtmahd, txtmakh, txtmanv, txtmapth, txtngaytao, txtngaytra, txtsotientralai, txttongtien});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblQLHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLHDMouseClicked
        // TODO add your handling code here:
        //        int temp = tblhoadon.getSelectedRow();
        //        loadHoaDon(temp);

        int row = tblQLHD.getSelectedRow();
        String ma = tblQLHD.getValueAt(row, 0).toString();
        Integer maHoaDon = Integer.valueOf(ma);
        defauhdct = (DefaultTableModel) tblHDCT.getModel();
        defauhdct.setRowCount(0);
        ArrayList<HoaDonCTVM> list = hdct.getlist(maHoaDon);
        loadhdct(list);
        int a = tblQLHD.getSelectedRow();
        txtmahd.setText(tblQLHD.getValueAt(a, 0).toString());
        txtmakh.setText(tblQLHD.getValueAt(a, 1).toString());
        txtmanv.setText(tblQLHD.getValueAt(a, 2).toString());
        txtngaytao.setText(tblQLHD.getValueAt(a, 3).toString());
        txttongtien.setText(tblQLHD.getValueAt(a, 4).toString());

    }//GEN-LAST:event_tblQLHDMouseClicked

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
//        // TODO add your handling code here:
//        int temp = tbltrahang.getSelectedRow();
//        if (temp == -1) {
//            JOptionPane.showMessageDialog(this, "chưa chọn dòng để xoá");
//        } else {
//            int hoi = JOptionPane.showConfirmDialog(this, "bạn có muốn xoá không");
//            if (hoi == JOptionPane.YES_OPTION) {
//                String maPTH = txtmapth.getText();
//                JOptionPane.showMessageDialog(this, serviceTH.xoaPTH(maPTH));
//                listTraHang = serviceTH.listTraHang();
//                loadTableTH(listTraHang);
//                clearForm();
//            }
//        }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
//
//        int temp = tbltrahang.getSelectedRow();
//        if (temp == -1) {
//            JOptionPane.showMessageDialog(this, "chưa chọn dòng để sửa");
//        } else {
//            TraHang x = getTraHang();
//            String maHD = txtmahd.getText();
//            JOptionPane.showMessageDialog(this, serviceTH.suaPTH(x, maHD));
//            listTraHang = serviceTH.listTraHang();
//            loadTableTH(listTraHang);
//
//        }
        clearForm();
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
//        // TODO add your handling code here:
//        if (txtmapth.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống");
//            txtmapth.requestFocus();
//            return;
//        } else if (txtmahd.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống");
//            txtmahd.requestFocus();
//            return;
//        } else if (txtmakh.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống");
//            txtmakh.requestFocus();
//            return;
//        } else if (txtmanv.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống");
//            txtmanv.requestFocus();
//            return;
//        } else if (txtngaytra.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống");
//            txtngaytra.requestFocus();
//            return;
//        } else if (txtlydo.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Không để trống");
//            txtlydo.requestFocus();
//            return;
//        }
//        TraHang x = getTraHang();
//        JOptionPane.showMessageDialog(this, serviceTH.themPTH(x));
//        listTraHang = serviceTH.listTraHang();
//        loadTableTH(listTraHang);
        clearForm();
    }//GEN-LAST:event_btnthemActionPerformed

    private void tbltrahangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltrahangMouseClicked
//        // TODO add your handling code here:
//        int temp = tbltrahang.getSelectedRow();
//        loadTraHang(temp);
    }//GEN-LAST:event_tbltrahangMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnQLKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLKhachHangActionPerformed

    }//GEN-LAST:event_btnQLKhachHangActionPerformed

    private void btnQLNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNhanVienActionPerformed

    }//GEN-LAST:event_btnQLNhanVienActionPerformed

    private void btnQLSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLSachActionPerformed

    }//GEN-LAST:event_btnQLSachActionPerformed

    private void btnBanHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanHangActionPerformed

    }//GEN-LAST:event_btnBanHangActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed

    }//GEN-LAST:event_btnTrangChuActionPerformed

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
            java.util.logging.Logger.getLogger(FormTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTraHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new FormTraHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnQLHoaDon;
    private javax.swing.JButton btnQLKhachHang;
    private javax.swing.JButton btnQLNhanVien;
    private javax.swing.JButton btnQLSach;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblQLHD;
    private javax.swing.JTable tbltrahang;
    private javax.swing.JTextField txtlydo;
    private javax.swing.JTextField txtmahd;
    private javax.swing.JTextField txtmakh;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtmapth;
    private javax.swing.JTextField txtngaytao;
    private javax.swing.JTextField txtngaytra;
    private javax.swing.JTextField txtsotientralai;
    private javax.swing.JTextField txttongtien;
    // End of variables declaration//GEN-END:variables
}
