package com.radio.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import com.radio.model.DBconnection;

public class statices extends JInternalFrame implements ActionListener {
	/**
	 * @author Golam Nobi
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txt_delete = new JTextField();
	Connection conn;
	DBconnection connect = new DBconnection();
	JPanel pan_1 = new JPanel();
	JPanel pan_2 = new JPanel();
	JPanel pan_4 = new JPanel();
	JPanel pan_5 = new JPanel();
	JPanel pan_1_another = new JPanel();
	JPanel pan_2_another = new JPanel();
	JPanel pan_3_another = new JPanel();
	JPanel pan_4_another = new JPanel();
	JPanel pan_5_another = new JPanel();
	JPanel pan_6_another = new JPanel();
	Border bordar = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	private JPanel pan_underline = new JPanel();
	private JLabel lbl_titlschedule = new JLabel("S T A T I C E S");
	Font font = new Font("Verdana", Font.BOLD, 20);
	Font font1 = new Font("Verdana", Font.BOLD, 13);

	private JLabel lbl_totalshow = new JLabel("Total Show");
	private JLabel lbl_totalshownum = new JLabel();
	private JLabel lbl_TodayShow = new JLabel("Today TelecasT Show");
	private JLabel lbl_todayshownum = new JLabel();
	//
	// FOR HOME DETAILS
	private JPanel pan_side_Home = new JPanel();
	private JButton btn_home = new JButton(new ImageIcon("images/homee.png"));
	private JButton btn_exit = new JButton("Exit");
	Border thickBorder1 = new LineBorder(Color.decode("#394B58"), 12);
	Font font_list = new Font("Verdana", Font.BOLD, 25);
	private JPanel pan_body = new JPanel();

	//
	public statices(JFrame getParentFrame) {
		super("Statices", true, true, false, true);
		this.setSize(1095, 550);
		lbl_titlschedule.setBounds(500, 15, 350, 30);
		lbl_titlschedule.setFont(font_list);
		lbl_titlschedule.setForeground(Color.decode("#E24444"));

		lbl_totalshow.setBounds(50, 10, 240, 30);
		lbl_totalshownum.setBounds(100, 50, 100, 30);
		lbl_totalshow.setFont(font);
		lbl_totalshownum.setFont(font);
		lbl_totalshow.setForeground(Color.WHITE);
		lbl_totalshownum.setForeground(Color.WHITE);
		lbl_TodayShow.setBounds(10, 10, 240, 30);
		lbl_todayshownum.setBounds(100, 50, 100, 30);
		lbl_TodayShow.setFont(font);
		lbl_todayshownum.setFont(font);
		lbl_TodayShow.setForeground(Color.WHITE);
		lbl_todayshownum.setForeground(Color.WHITE);

		pan_1.add(lbl_totalshow);
		pan_1.add(lbl_totalshownum);
		pan_2.add(lbl_TodayShow);
		pan_2.add(lbl_todayshownum);

		pan_1.setBackground(Color.decode("#00A65A"));
		pan_2.setBackground(Color.decode("#DD4B39"));
		pan_1.setBounds(130, 130, 260, 120);
		pan_2.setBounds(480, 130, 260, 120);

		// btn_graph.

		pan_1.setLayout(null);
		pan_2.setLayout(null);

		pan_4.setBounds(0, 100, 260, 20);
		pan_5.setBounds(0, 100, 260, 20);

		// anoter code

		pan_1_another.setBounds(50, 280, 260, 120);
		pan_1_another.setBackground(Color.decode("#00C0EF"));
		pan_2_another.setBounds(360, 280, 260, 120);
		pan_2_another.setBackground(Color.green);
		pan_3_another.setBounds(670, 280, 260, 120);
		pan_3_another.setBackground(Color.green);
		pan_1_another.setLayout(null);
		pan_2_another.setLayout(null);
		pan_3_another.setLayout(null);

		pan_4_another.setBounds(0, 100, 260, 20);
		pan_5_another.setBounds(0, 100, 260, 20);
		pan_6_another.setBounds(0, 100, 260, 20);
		// another code

		pan_underline.setBounds(400, 40, 195, 3);
		pan_underline.setBackground(Color.gray);
		pan_4.setBackground(Color.decode("#008D4D"));
		pan_5.setBackground(Color.decode("#BC4031"));

		pan_4_another.setBackground(Color.decode("#00A4CC"));
		pan_5_another.setBackground(Color.white);
		pan_6_another.setBackground(Color.white);

		pan_1.add(pan_4);
		pan_2.add(pan_5);

		pan_1_another.add(pan_4_another);
		pan_2_another.add(pan_5_another);
		pan_3_another.add(pan_6_another);

		btn_home.setBounds(20, 60, 105, 90);
		btn_home.setBorder(thickBorder1);
		btn_home.setBackground(Color.decode("#250800"));
		btn_exit.setBounds(20, 180, 105, 90);
		btn_exit.setBorder(thickBorder1);
		btn_exit.setBackground(Color.decode("#250800"));
		btn_exit.addActionListener(this);
		btn_home.addActionListener(this);
		pan_side_Home.add(btn_exit);
		pan_side_Home.add(btn_home);
		pan_side_Home.setBounds(0, 0, 150, 700);
		pan_side_Home.setLayout(null);
		pan_side_Home.setBackground(Color.decode("#D2DDF1"));

		pan_body.setBounds(180, 60, 885, 425);
		pan_body.setLayout(null);
		pan_body.setBorder(bordar);
		pan_body.add(pan_1);
		pan_body.add(pan_2);
		retrive_totalshow(lbl_totalshownum);
		retrive_todaytelecaseshow(lbl_todayshownum);
		this.add(pan_body);
		this.add(pan_side_Home);
		this.add(lbl_titlschedule);
		this.add(txt_delete);
		this.setLayout(null);
		this.setVisible(true);

	}

	// public void view_all_statices() {
	// try {
	//
	// } catch (Exception ex) {
	// JOptionPane.showMessageDialog(null, "Error viewall gui" + ex.toString());
	//
	// }
	// }

	public void view_statices() {
		this.setVisible(false);
		dispose();
	}

	public Connection getConnection() {
		try {
			conn = connect.setConnection(conn);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void retrive_totalshow(JLabel lbl) {

		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();
			String query = "Select COUNT(show_id)  from show_1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String count = rs.getString("COUNT(show_id)");
				lbl.setText(count);
			}

			conn.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Toatal show" + ex.toString());
		}
	}

	public void retrive_todaytelecaseshow(JLabel lbl) {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E");
		int count = 0;
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM show_1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String getdate = ft.format(date);
				String fromdatabase = rs.getString(10).trim();
				String check_lenght = fromdatabase.substring(0, 3);
				if (check_lenght.contentEquals(getdate) == true) {
					count++;

				}
				lbl.setText(Integer.toString(count));
			}

			conn.close();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error Toatal Today Show" + ex.toString());
		}
	}

	@Override
	public void actionPerformed(ActionEvent object) {
		Object source = object.getSource();
		if (source.equals(btn_exit)) {
			Home_Radio.removeall();
			this.dispose();
			this.setVisible(false);
		} else if (source.equals(btn_home)) {
			Home_Radio.removeall();
			this.setVisible(false);
			Home_Radio.viewallhomepage();

		}

	}

}
