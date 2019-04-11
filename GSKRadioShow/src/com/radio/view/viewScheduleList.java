package com.radio.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import com.radio.model.DBconnection;

public class viewScheduleList extends JInternalFrame implements ActionListener {
	/**
	 * @author Golam Nobi sheikh
	 */
	private static final long serialVersionUID = 1L;

	Connection conn;
	DBconnection connect = new DBconnection();
	private JTextField txt_delete = new JTextField();
	private JLabel lbl_titlschedule = new JLabel("S C H E D U L E   L I S T");
	Font font = new Font("Verdana", Font.BOLD, 15);
	Font font1 = new Font("Verdana", Font.BOLD, 25);
	Font font2 = new Font("Verdana", Font.BOLD, 17);
	Font font_status = new Font("Verdana", Font.BOLD, 20);
	Border thickBorder = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	JPanel pan_leftborder = new JPanel();
	private JLabel lbl_1 = new JLabel("show Name :");
	private JLabel lbl_2 = new JLabel("Duration :");
	private JLabel lbl_3 = new JLabel("Audio Duration :");
	private JLabel lbl_4 = new JLabel("Video Duration :");
	private JLabel lbl_5 = new JLabel("Voice_Over :");
	private JLabel lbl_6 = new JLabel("Advertising/Not :");
	private JLabel lbl_7 = new JLabel("Run Perday :");
	private JLabel lbl_8 = new JLabel("Genre :");
	private JLabel lbl_9 = new JLabel("Advertisment :");
	private JLabel txt_1 = new JLabel();
	private JLabel txt_2 = new JLabel();
	private JLabel txt_3 = new JLabel();
	private JLabel txt_9 = new JLabel();
	private JLabel txt_4 = new JLabel();
	private JLabel txt_5 = new JLabel();
	private JLabel txt_6 = new JLabel();
	private JLabel txt_7 = new JLabel();
	private JLabel txt_8 = new JLabel();
	static int record = 0;
	static double total = 0;
	static double multiply_1 = 0.0;
	static double multiply_2 = 0.0;
	static double multiply_3 = 0.0;
	static double multiply_4 = 0.0;
	static double storevalue = 0.0;
	JLabel lbl_status = new JLabel("SHOW ARE NOT AVAILABLE");
	JLabel lbl_header = new JLabel("THIS TIME");

	// check the value
	// ADD HOME BUTTON
	private JPanel pan_side_Home = new JPanel();
	private JButton btn_home = new JButton(new ImageIcon("images/homee.png"));
	private JButton btn_exit = new JButton("Exit");
	Border thickBorder1 = new LineBorder(Color.decode("#394B58"), 12);
	Font font_list = new Font("Verdana", Font.BOLD, 25);

	public viewScheduleList(JFrame getParentFrame) {
		super("View Schedule", true, true, false, true);
		this.setSize(1095, 550);
		this.setLayout(null);
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBorder(thickBorder);
		pan.setBounds(190, 60, 850, 440);
		lbl_titlschedule.setBounds(400, 10, 370, 30);
		lbl_titlschedule.setFont(font1);
		lbl_titlschedule.setForeground(Color.decode("#E24444"));
		pan_leftborder.setBounds(140, 30, 570, 370);
		pan_leftborder.setBorder(thickBorder);
		pan_leftborder.setLayout(null);
		lbl_1.setBounds(20, 20, 180, 25);
		txt_1.setBounds(350, 20, 180, 25);
		lbl_2.setBounds(20, 60, 180, 25);
		txt_2.setBounds(350, 60, 180, 25);
		lbl_3.setBounds(20, 100, 180, 25);
		txt_3.setBounds(350, 100, 180, 25);
		lbl_4.setBounds(20, 140, 180, 25);
		txt_4.setBounds(350, 140, 180, 25);
		lbl_9.setBounds(20, 180, 180, 25);
		txt_9.setBounds(350, 180, 180, 25);
		lbl_5.setBounds(20, 220, 180, 25);
		txt_5.setBounds(350, 220, 180, 25);
		lbl_6.setBounds(20, 260, 180, 25);
		txt_6.setBounds(350, 260, 180, 25);
		lbl_7.setBounds(20, 300, 180, 25);
		txt_7.setBounds(350, 300, 180, 25);
		lbl_8.setBounds(20, 340, 180, 25);
		txt_8.setBounds(350, 340, 180, 25);
		lbl_1.setFont(font);
		lbl_2.setFont(font);
		lbl_3.setFont(font);
		lbl_4.setFont(font);
		lbl_5.setFont(font);
		lbl_6.setFont(font);
		lbl_7.setFont(font);
		lbl_8.setFont(font);
		txt_1.setFont(font);
		txt_2.setFont(font);
		txt_3.setFont(font);
		txt_4.setFont(font);
		txt_5.setFont(font);
		txt_6.setFont(font);
		txt_7.setFont(font);
		txt_8.setFont(font);
		txt_9.setFont(font);
		lbl_9.setFont(font);
		pan_leftborder.add(lbl_9);
		pan_leftborder.add(txt_9);
		pan_leftborder.add(lbl_1);
		pan_leftborder.add(txt_1);
		pan_leftborder.add(lbl_2);
		pan_leftborder.add(txt_2);
		pan_leftborder.add(lbl_3);
		pan_leftborder.add(txt_3);
		pan_leftborder.add(lbl_4);
		pan_leftborder.add(txt_4);
		pan_leftborder.add(lbl_5);
		pan_leftborder.add(txt_5);
		pan_leftborder.add(lbl_6);
		pan_leftborder.add(txt_6);
		pan_leftborder.add(lbl_7);
		pan_leftborder.add(txt_7);
		pan_leftborder.add(lbl_8);
		pan_leftborder.add(txt_8);
		pan.add(pan_leftborder);
		pan_side_Home.setBounds(0, 0, 150, 700);
		pan_side_Home.setLayout(null);
		pan_side_Home.setBackground(Color.decode("#D2DDF1"));
		btn_home.setBounds(20, 60, 105, 90);
		btn_exit.setBounds(20, 180, 105, 90);
		btn_home.setBorder(thickBorder1);
		btn_home.setBackground(Color.decode("#250800"));
		btn_exit.setBorder(thickBorder1);
		btn_exit.setBackground(Color.decode("#250800"));
		btn_exit.addActionListener(this);
		btn_home.addActionListener(this);
		pan_side_Home.add(btn_exit);
		pan_side_Home.add(btn_home);
		retrive_show(txt_1, txt_2, txt_3, txt_4, txt_9, txt_5, txt_6, txt_7, txt_8);
		this.add(pan_side_Home);
		this.add(lbl_titlschedule);
		this.add(txt_delete);
		this.add(pan);
		this.setVisible(true);
	}

	public void view_ScheduleDispose() {
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

	public void retrive_show(JLabel txt_1, JLabel txt_2, JLabel txt_3, JLabel txt_4, JLabel txt_9, JLabel txt_5,
			JLabel txt_6, JLabel txt_7, JLabel txt_8) {
		String add_finalconvert = null;
		String ego = null;
		String ego1 = null;
		String add_time_PM = null;
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

				String show_duration = rs.getString(3).trim();
				// retrive the dayname
				String fromdatabase = rs.getString(10).trim();
				// retrive the dayname
				String str = show_duration.substring(0, 4);
				// add 1 for increment
				String increment = str.substring(0, 2);
				String show_Duration_AM = str.substring(2, 4);
				int convert_Integer = Integer.parseInt(increment);
				record = convert_Integer + 1;
				String convertIntegertostring = Integer.toString(record);
				add_finalconvert = "0" + convertIntegertostring + show_Duration_AM;
				// close the programe
				if (add_finalconvert.length() > 4) {
					if (show_Duration_AM.equals("PM")) {
						ego = convertIntegertostring + "AM";
					} else {
						ego = convertIntegertostring + "PM";
					}

				} else {
					ego = convertIntegertostring + show_Duration_AM;
				}

				// close the program
				Date date = new Date();
				SimpleDateFormat date_formate = new SimpleDateFormat("hh:mm:ss a");
				String convert_dateformate = date_formate.format(date);
				// check dayName
				SimpleDateFormat ft = new SimpleDateFormat("E");
				String getdate = ft.format(date);
				String find_dayName = fromdatabase.substring(0, 3);
				// check dayName

				String check_time = convert_dateformate.substring(0, 2);
				String check_PM = convert_dateformate.substring(9, 11);
				add_time_PM = check_time.concat(check_PM);

				if (find_dayName.contentEquals(getdate) == true) {

					if (add_time_PM.contentEquals(str) == true || add_time_PM.contentEquals(add_finalconvert) == true
							|| add_time_PM.contentEquals(ego) == true) {

						String show_Name = rs.getString(2).trim();
						String show_Duration = rs.getString(3).trim();
						String show_advertising = rs.getString(4).trim();
						String show_voicover = rs.getString(5).trim();
						String show_selected = rs.getString(6).trim();
						String show_runperday = rs.getString(7).trim();
						String show_genrey = rs.getString(8).trim();
						String audio_duration = rs.getString(11).trim();
						String video_duration = rs.getString(12).trim();
						double num_1 = Double.parseDouble(audio_duration);
						double num_2 = Double.parseDouble(video_duration);
						double num_3 = Double.parseDouble(show_advertising);
						double num_4 = Double.parseDouble(show_voicover);
						total = num_1 + num_2 + num_3 + num_4;
						storevalue = 3600 / total;
						multiply_1 = storevalue * num_1;
						multiply_2 = storevalue * num_2;
						multiply_3 = storevalue * num_3;
						multiply_4 = storevalue * num_4;
						String s1 = String.format("%.4f", multiply_1);
						String s2 = String.format("%.4f", multiply_2);
						String s3 = String.format("%.4f", multiply_3);
						String s4 = String.format("%.4f", multiply_4);
						txt_1.setText(show_Name);
						txt_2.setText(show_Duration);
						txt_3.setText((s1));
						txt_4.setText((s2));
						txt_9.setText((s3));
						txt_5.setText((s4));
						txt_6.setText(show_selected);
						txt_7.setText(show_runperday);
						txt_8.setText(show_genrey);
						count++;

					}
				}

			}

			conn.close();

		}

		catch (Exception ex) {

		}

		if (count == 0) {
			all_visablefalse();
		}
	}

	public void all_visablefalse() {
		lbl_status.setBounds(120, 155, 400, 40);
		lbl_status.setFont(font_status);
		lbl_status.setForeground(Color.RED);
		lbl_header.setBounds(210, 105, 300, 40);
		lbl_header.setFont(font_status);
		lbl_header.setForeground(Color.RED);
		pan_leftborder.add(lbl_header);
		pan_leftborder.add(lbl_status);
		txt_1.setVisible(false);
		txt_2.setVisible(false);
		txt_3.setVisible(false);
		txt_4.setVisible(false);
		txt_5.setVisible(false);
		txt_6.setVisible(false);
		txt_7.setVisible(false);
		txt_8.setVisible(false);
		lbl_1.setVisible(false);
		lbl_2.setVisible(false);
		lbl_3.setVisible(false);
		lbl_4.setVisible(false);
		lbl_5.setVisible(false);
		lbl_6.setVisible(false);
		lbl_7.setVisible(false);
		lbl_8.setVisible(false);
		lbl_9.setVisible(false);
		txt_9.setVisible(false);

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
