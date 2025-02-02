package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import facade.HopDongFacade;
import facade.KhachHangFacade;
import facade.NhanVienHanhChanhFacade;
import facade.NhanVienKythuatFacade;
import facade.PhieuNhanXetFacade;
import facade.XeFacade;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class FrmMainNhanVienKyThuat extends JFrame {

	private Image img_Logo = new ImageIcon(FrmMainNhanVienKyThuat.class.getResource("../image/car-dealer.png")).getImage()
			.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
	private Image img_Intro = new ImageIcon(FrmMainNhanVienKyThuat.class.getResource("../image/introduction.png")).getImage()
			.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	private Image img_Logout = new ImageIcon(FrmMainNhanVienKyThuat.class.getResource("../image/logout.png")).getImage()
			.getScaledInstance(34, 30, java.awt.Image.SCALE_SMOOTH);
	private Image img_Xe = new ImageIcon(FrmMainNhanVienKyThuat.class.getResource("../image/motorcycle.png")).getImage()
			.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	private Image img_KhachHang = new ImageIcon(FrmMainNhanVienKyThuat.class.getResource("../image/target.png")).getImage()
			.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	private Image img_NhanVien = new ImageIcon(FrmMainNhanVienKyThuat.class.getResource("../image/employee.png")).getImage()
			.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	private Image img_HopDong = new ImageIcon(FrmMainNhanVienKyThuat.class.getResource("../image/agreement.png")).getImage()
			.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	private Image img_PhieuNhanXet = new ImageIcon(FrmMainNhanVienKyThuat.class.getResource("../image/checklist.png")).getImage()
			.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	private Image img_Account = new ImageIcon(FrmMainNhanVienKyThuat.class.getResource("../image/profile.png")).getImage()
			.getScaledInstance(50, 45, java.awt.Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JLabel lblTitleChucNang;

	private PanelGioiThieu panelGioiThieu;
	private PanelQuanLyKhachHang panelQuanLyKhachHang;
	private PanelQuanLyNhanVien panelQuanLyNhanVien;
	private PanelQuanLyHopDong panelQuanLyHopDong;
	private PanelPhieuNhanXet panelPhieuNhanXet;
	/**
	 * Create the frame.
	 */
	public FrmMainNhanVienKyThuat(KhachHangFacade khachHangFacade, XeFacade xeFacade
			, NhanVienHanhChanhFacade nhanVienHanhChanhFacade
			, NhanVienKythuatFacade nhanVienKythuatFacade, HopDongFacade hopDongFacade
			, PhieuNhanXetFacade phieuNhanXetFacade, String maNVDangNhap, String tenNV) {
		
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 728);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(65, 105, 225), 2));
		contentPane.setBackground(new Color(102, 205, 170));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelGioiThieu = new PanelGioiThieu();
		panelPhieuNhanXet = new PanelPhieuNhanXet(phieuNhanXetFacade, hopDongFacade, maNVDangNhap);

		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(new Color(100, 149, 237));
		pnlMenu.setBounds(0, 0, 279, 728);
		contentPane.add(pnlMenu);
		pnlMenu.setLayout(null);

		JLabel lblIconLogo = new JLabel("");
		lblIconLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconLogo.setBounds(10, 11, 259, 120);
		lblIconLogo.setIcon(new ImageIcon(img_Logo));
		pnlMenu.add(lblIconLogo);

		JPanel pnlGioiThieu = new JPanel();
		pnlGioiThieu.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlGioiThieu.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlGioiThieu.setBackground(new Color(100, 149, 237));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlGioiThieu.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlGioiThieu.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblTitleChucNang.setText("");
				menuClicked(panelGioiThieu);
			}
		});

		pnlGioiThieu.setBackground(new Color(100, 149, 237));
		pnlGioiThieu.setBounds(0, 152, 279, 50);
		pnlMenu.add(pnlGioiThieu);
		pnlGioiThieu.setLayout(null);

		JLabel lblGioiThieu = new JLabel("GIỚI THIỆU");
		lblGioiThieu.setForeground(new Color(255, 255, 255));
		lblGioiThieu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGioiThieu.setBounds(74, 11, 127, 25);
		pnlGioiThieu.add(lblGioiThieu);

		JLabel lblInconIntro = new JLabel("");
		lblInconIntro.setBounds(10, 0, 54, 50);
		lblInconIntro.setIcon(new ImageIcon(img_Intro));
		pnlGioiThieu.add(lblInconIntro);

		JPanel pnlLogout = new JPanel();
		pnlLogout.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlLogout.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlLogout.setBackground(new Color(100, 149, 237));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlLogout.setBackground(new Color(0, 191, 255));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlLogout.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất khỏi ứng dụng?") == 0) {
					FrmLogin frmLogin = new FrmLogin(khachHangFacade, xeFacade
							, nhanVienHanhChanhFacade, nhanVienKythuatFacade, hopDongFacade
							, phieuNhanXetFacade);
					frmLogin.setVisible(true);
					FrmMainNhanVienKyThuat.this.dispose();
				}
			}
		});
		pnlLogout.setBackground(new Color(100, 149, 237));
		pnlLogout.setBounds(0, 678, 279, 50);
		pnlMenu.add(pnlLogout);
		pnlLogout.setLayout(null);

		JLabel lblLogOut = new JLabel("ĐĂNG XUẤT");
		lblLogOut.setForeground(new Color(255, 255, 255));
		lblLogOut.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogOut.setBounds(74, 11, 130, 25);
		pnlLogout.add(lblLogOut);

		JLabel lblIconLogout = new JLabel("");
		lblIconLogout.setBounds(10, 0, 54, 50);
		lblIconLogout.setIcon(new ImageIcon(img_Logout));
		pnlLogout.add(lblIconLogout);

		JPanel pnlPhieuNhanXet = new JPanel();
		pnlPhieuNhanXet.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlPhieuNhanXet.setBackground(new Color(70, 130, 180));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				pnlPhieuNhanXet.setBackground(new Color(100, 149, 237));

			}

			@Override
			public void mousePressed(MouseEvent e) {
				pnlPhieuNhanXet.setBackground(new Color(0, 191, 255));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				pnlPhieuNhanXet.setBackground(new Color(70, 130, 180));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelPhieuNhanXet);
			}
		});
		pnlPhieuNhanXet.setLayout(null);
		pnlPhieuNhanXet.setBackground(new Color(100, 149, 237));
		pnlPhieuNhanXet.setBounds(0, 201, 279, 50);
		pnlMenu.add(pnlPhieuNhanXet);

		JLabel lblPhieuNhanXet = new JLabel("PHIẾU NHẬN XÉT");
		lblPhieuNhanXet.setForeground(Color.WHITE);
		lblPhieuNhanXet.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPhieuNhanXet.setBounds(74, 11, 171, 25);
		pnlPhieuNhanXet.add(lblPhieuNhanXet);

		JLabel lblIconPhieuNhanXet = new JLabel("");
		lblIconPhieuNhanXet.setBounds(10, 0, 54, 50);
		lblIconPhieuNhanXet.setIcon(new ImageIcon(img_PhieuNhanXet));
		pnlPhieuNhanXet.add(lblIconPhieuNhanXet);

		JLabel lblIconAccount = new JLabel("");
		lblIconAccount.setBounds(0, 630, 50, 44);
		lblIconAccount.setIcon(new ImageIcon(img_Account));
		pnlMenu.add(lblIconAccount);

		JPanel pnAccount = new JPanel();
		pnAccount.setBackground(new Color(100, 149, 237));
		pnAccount.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnAccount.setBounds(56, 638, 213, 30);
		pnlMenu.add(pnAccount);
		pnAccount.setLayout(null);

		JLabel lblAccountDetail = new JLabel(tenNV);
		lblAccountDetail.setBounds(0, 0, 213, 30);
		pnAccount.add(lblAccountDetail);
		lblAccountDetail.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountDetail.setFont(new Font("Times New Roman", Font.BOLD, 17));

		JPanel pnlMainContent = new JPanel();
		pnlMainContent.setBounds(278, 22, 1088, 706);
		contentPane.add(pnlMainContent);
		pnlMainContent.setLayout(null);

		JPanel pnlMenuTop = new JPanel();
		pnlMenuTop.setBounds(277, 0, 1089, 23);
		contentPane.add(pnlMenuTop);
		pnlMenuTop.setLayout(null);
		pnlMenuTop.setBackground(new Color(100, 149, 237));

		JLabel lblMinimize = new JLabel("—");
		lblMinimize.setBounds(1043, 0, 20, 21);
		pnlMenuTop.add(lblMinimize);
		lblMinimize.setVerticalAlignment(SwingConstants.TOP);
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblMinimize.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblMinimize.setForeground(Color.WHITE);
			}
		});
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(Color.WHITE);
		lblMinimize.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		JLabel lblExit = new JLabel("X");
		lblExit.setBounds(1068, 1, 20, 20);
		pnlMenuTop.add(lblExit);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đóng ứng dụng ?", "Xác nhận",
						JOptionPane.YES_NO_OPTION) == 0) {
					FrmMainNhanVienKyThuat.this.dispose();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.RED);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(Color.WHITE);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 16));

		lblTitleChucNang = new JLabel("");
		lblTitleChucNang.setBackground(new Color(100, 149, 237));
		lblTitleChucNang.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleChucNang.setForeground(new Color(255, 215, 0));
		lblTitleChucNang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitleChucNang.setBounds(1, 0, 1087, 23);
		pnlMenuTop.add(lblTitleChucNang);

		pnlMainContent.add(panelGioiThieu);
		pnlMainContent.add(panelPhieuNhanXet);

	}

	public void menuClicked(JPanel panel) {
		panelGioiThieu.setVisible(false);
		panelPhieuNhanXet.setVisible(false);

		panel.setVisible(true);
	}
}
