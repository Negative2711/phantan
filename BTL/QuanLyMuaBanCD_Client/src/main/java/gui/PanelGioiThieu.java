package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class PanelGioiThieu extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGioiThieu() {
		setBounds(1, 0, 1087, 706);
		setLayout(null);
		setVisible(true);

		JLabel lblNewLabel = new JLabel("SƠ LƯỢC PHẦN MỀM");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1067, 63);
		add(lblNewLabel);

		JTextArea txtaGioiThieu = new JTextArea();
		txtaGioiThieu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtaGioiThieu.setText("\n" + " Nhóm  - Lập trình phân tán với công nghệ Java "
				+ "\n 1. Đoàn Thế Long ( Trưởng nhóm ) - 19475471 " + "\n 2. Lê Hoàng Minh - 18045831 "
				+ "\n\n Chương trình quản lý cửa hàng bán băng đĩa." + "\n\n Các chức năng chính: "
				+ "\n\n\t + Quản lý nhân viên" + "\n\n\t + Quản lý khách hàng" + "\n\n\t + Quản lý thông tin đĩa"
				+ "\n\n\t + Quản lý hóa đơn"
				+ "\n\n Mọi thắc mắc và yêu cầu hỗ trợ xin hãy gọi điện cho nhà phát triển thông qua Số điện thoại: 0328033349");
		txtaGioiThieu.setEditable(false);
		txtaGioiThieu.setBounds(10, 71, 1068, 624);
		add(txtaGioiThieu);

	}
}