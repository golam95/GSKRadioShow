package com.radio.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import com.radio.model.DBconnection;
import com.radio.model.SettingMenu;
import com.radio.model.showInfo;

public class addShow extends JInternalFrame implements ActionListener, MouseListener {
	/**
	 * @author Golam Nobi
	 */
	private static final long serialVersionUID = 1L;

	Connection conn;
	DBconnection connect = new DBconnection();
	SettingMenu setttings = new SettingMenu();
	private Date td = new Date();
	// using field \
	private JCheckBox chek_box_audio = new JCheckBox();
	private JCheckBox chek_box_video = new JCheckBox();
	// using field
	static String str = "";
	private JPanel pan_firstbordar = new JPanel();
	private JPanel pan_leftbordar = new JPanel();
	private JPanel pan_rightbordar = new JPanel();
	Border bordar = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);

	//
	private JLabel lbl_date = new JLabel("DayName");
	private JComboBox<String> txt_date = new JComboBox<String>();
	private JTextField txt_id = new JTextField();
	//

	private JTextField txt_1 = new JTextField();
	private JComboBox<String> txt_2 = new JComboBox<String>();
	private JTextField txt_4 = new JTextField();
	private JTextField txt_5 = new JTextField();
	private JComboBox<String> txt_6 = new JComboBox<String>();
	private JTextField txt_7 = new JTextField();
	private JComboBox<String> txt_8 = new JComboBox<String>();

	private JLabel lbl_1 = new JLabel("show Name");
	private JLabel lbl_2 = new JLabel("Duration");
	private JLabel lbl_3 = new JLabel("Contents");

	private JLabel lbl_4 = new JLabel("Advertisment");
	private JLabel lbl_5 = new JLabel("VoiceOver");
	private JLabel lbl_6 = new JLabel("Select");
	private JLabel lbl_7 = new JLabel("Run Perday");
	private JLabel lbl_8 = new JLabel("Genre");

	private JButton btn_add = new JButton("Add");
	private JButton btn_update = new JButton("Update");
	private JButton btn_delete = new JButton("Delete");
	private JButton btn_clear = new JButton("Clear");

	Font font = new Font("Verdana", Font.BOLD, 20);
	@SuppressWarnings("unused")
	private final String str_array[] = { "07AM-09AM", "09AM-11AM", "11AM-01PM", "01PM-03PM", "03PM-05PM", "05PM-07PM",
			"07PM-09PM", "09PM-11PM", "11PM-01AM", "01AM-3AM", "03AM-05AM", "05AM-7AM" };
	private final String str_day[] = { "Saterday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };

	private final String str_Showselect[] = { "Multimedia", "Audio" };
	private final String str_Showgenrey[] = { "POP", "Band", "Lalon" };
	// home panel
	private JPanel pan_side_Home = new JPanel();
	private JButton btn_home = new JButton(new ImageIcon("images/homee.png"));
	private JButton btn_exit = new JButton("Exit");
	Border thickBorder1 = new LineBorder(Color.decode("#394B58"), 12);
	Font font_list = new Font("Verdana", Font.BOLD, 25);

	Font font_text = new Font("Verdana", Font.BOLD, 13);
	Font font_text1 = new Font("Verdana", Font.BOLD, 19);
	// new component
	private JButton btn_search = new JButton("Search");
	private JTextField txt_search = new JTextField();
	private JPanel pan_table = new JPanel();
	private JFrame frm_audio = new JFrame();
	private JFrame frm_video = new JFrame();
	JCheckBox check_box_audio = new JCheckBox("Audio");
	JCheckBox check_box_video = new JCheckBox("Video");
	// new component
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;

	// home panel

	// for audio clip

	JButton btn_audioClip_close = new JButton("Close");
	JButton btn_audioClip_ok = new JButton("Ok");

	JTextField txt_audioClip_1 = new JTextField();
	JTextField txt_audioClip_2 = new JTextField();
	JComboBox<String> txt_audioClip_3 = new JComboBox<String>();
	JTextField txt_audioClip_4 = new JTextField();
	JTextField txt_audioClip_5 = new JTextField();
	JTextField txt_audioClip_6 = new JTextField();
	JComboBox<String> txt_audioClip_7 = new JComboBox<String>();
	JComboBox<String> txt_audioClip_8 = new JComboBox<String>();

	// for audio clip
	// for video clip
	JButton btn_VIDEOClip_close = new JButton("Close");
	JButton btn_VIDEOClip_ok = new JButton("Ok");

	JTextField txt_VIDEOClip_1 = new JTextField();
	JTextField txt_VIDEOClip_2 = new JTextField();
	JComboBox<String> txt_VIDEOClip_3 = new JComboBox<String>();
	JTextField txt_VIDEOClip_4 = new JTextField();
	JTextField txt_VIDEOClip_5 = new JTextField();
	JTextField txt_VIDEOClip_6 = new JTextField();
	JComboBox<String> txt_VIDEOClip_7 = new JComboBox<String>();
	JComboBox<String> txt_VIDEOClip_8 = new JComboBox<String>();
	// DECLEAR STRING VARIABLE

	protected String audio_clip_Name = "";
	protected String audio_clip_Duration = "";
	protected String audio_clip_Select = "";
	protected String audio_clip_TimesPlay = "";
	protected String audio_clip_MaxNum = "";
	protected String audio_clip_MinNum = "";
	protected String audio_clip_Min = "";
	protected String audio_clip_Genre = "";
	// again

	protected String VIDEO_clip_Name = "";
	protected String VIDEO_clip_Duration = "";
	protected String VIDEO_clip_Select = "";
	protected String VIDEO_clip_TimesPlay = "";
	protected String VIDEO_clip_MaxNum = "";
	protected String VIDEO_clip_MinNum = "";
	protected String VIDEO_clip_Min = "";
	protected String VIDEO_clip_Genre = "";
	// again
	// DECLEAR STRING VARIABLE
	private JTable table = new JTable();
	private JScrollPane scroll_panel = new JScrollPane();

	// for video clip
	public addShow(JFrame getParentFrame) {
		super("Add Show", true, true, false, true);
		view_all();
	}

	public void view_all() {
		try {
			this.setSize(1095, 550);
			this.setLayout(null);
			pan_firstbordar.setBounds(190, 50, 850, 450);
			pan_table.setLayout(new GridLayout(0, 1));
			pan_table.setBounds(210, 285, 810, 200);
			pan_table.add(scroll_panel);
			table.addMouseListener(this);
			this.add(pan_table);

			txt_search.setBounds(795, 15, 150, 25);
			btn_search.setBounds(960, 15, 80, 25);

			lbl_date.setBounds(190, 15, 100, 25);
			txt_date.setBounds(280, 15, 150, 25);

			txt_id.setBounds(700, 8, 50, 30);

			lbl_date.setFont(font_text);

			this.add(txt_search);
			this.add(btn_search);
			this.add(lbl_date);
			this.add(txt_date);
			this.add(txt_id);

			pan_firstbordar.setLayout(null);
			pan_leftbordar.setLayout(null);
			pan_rightbordar.setLayout(null);

			pan_firstbordar.setBorder(bordar);
			pan_leftbordar.setBorder(bordar);
			pan_leftbordar.setBounds(20, 30, 690, 185);
			pan_rightbordar.setBorder(bordar);
			pan_rightbordar.setBounds(460, 20, 470, 350);

			btn_add.setBounds(920, 80, 100, 30);
			btn_update.setBounds(920, 130, 100, 30);
			btn_delete.setBounds(920, 180, 100, 30);
			btn_clear.setBounds(920, 230, 100, 30);

			btn_add.setBackground(Color.gray);
			btn_update.setBackground(Color.gray);
			btn_delete.setBackground(Color.gray);
			btn_clear.setBackground(Color.gray);

			btn_add.setFont(font_text);
			btn_update.setFont(font_text);
			btn_delete.setFont(font_text);
			btn_clear.setFont(font_text);

			// here is the code for now action class

			btn_add.addActionListener(this);
			btn_clear.addActionListener(this);
			btn_update.addActionListener(this);
			btn_delete.addActionListener(this);
			check_box_audio.addActionListener(this);
			check_box_video.addActionListener(this);
			btn_search.addActionListener(this);

			// here is the code for now action class

			this.add(btn_add);
			this.add(btn_clear);
			this.add(btn_update);
			this.add(btn_delete);

			lbl_1.setBounds(20, 20, 180, 25);
			txt_1.setBounds(130, 20, 200, 25);

			lbl_2.setBounds(20, 60, 180, 25);
			txt_2.setBounds(130, 60, 200, 25);

			lbl_3.setBounds(20, 100, 180, 25);

			check_box_audio.setBounds(130, 100, 80, 25);
			check_box_video.setBounds(220, 100, 80, 25);
			pan_leftbordar.add(check_box_audio);
			pan_leftbordar.add(check_box_video);

			lbl_4.setBounds(20, 140, 180, 25);
			txt_4.setBounds(130, 140, 200, 25);

			lbl_5.setBounds(370, 20, 180, 25);
			txt_5.setBounds(470, 20, 200, 25);

			lbl_6.setBounds(370, 60, 180, 25);
			txt_6.setBounds(470, 60, 200, 25);

			lbl_7.setBounds(370, 100, 180, 25);
			txt_7.setBounds(470, 100, 200, 25);
			txt_7.setText("1");
			txt_7.setEnabled(false);

			lbl_8.setBounds(370, 140, 180, 25);
			txt_8.setBounds(470, 140, 200, 25);

			for (int i = 0; i < str_array.length; i++) {
				txt_2.addItem(str_array[i]);

			}

			for (int k = 0; k < str_day.length; k++) {
				txt_date.addItem(str_day[k]);

			}

			for (int l = 0; l < str_Showselect.length; l++) {
				txt_6.addItem(str_Showselect[l]);
			}
			for (int m = 0; m < str_Showselect.length; m++) {
				txt_8.addItem(str_Showselect[m]);
			}

			pan_leftbordar.add(lbl_1);
			pan_leftbordar.add(txt_1);
			pan_leftbordar.add(lbl_2);
			pan_leftbordar.add(txt_2);
			pan_leftbordar.add(lbl_3);

			pan_leftbordar.add(lbl_4);
			pan_leftbordar.add(txt_4);
			pan_leftbordar.add(lbl_5);
			pan_leftbordar.add(txt_5);
			pan_leftbordar.add(lbl_6);
			pan_leftbordar.add(txt_6);
			pan_leftbordar.add(lbl_7);
			pan_leftbordar.add(txt_7);
			pan_leftbordar.add(lbl_8);
			pan_leftbordar.add(txt_8);

			lbl_1.setFont(font_text);
			lbl_2.setFont(font_text);
			lbl_3.setFont(font_text);
			lbl_4.setFont(font_text);
			lbl_5.setFont(font_text);
			lbl_6.setFont(font_text);
			lbl_7.setFont(font_text);
			lbl_8.setFont(font_text);

			// .add();

			pan_firstbordar.add(pan_leftbordar);
			// pan_firstbordar.add(pan_rightbordar);
			table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] { "ShowID", "Name",
					"Duration", "Advertising", "Voiceover", "Select", "RunperDay", "Genrey", "Date", "DayName" }));

			scroll_panel.setViewportView(table);
			// new code

			btn_home.setBounds(20, 60, 105, 90);
			btn_home.setBorder(thickBorder1);
			btn_home.setBackground(Color.decode("#250800"));
			btn_exit.setBounds(20, 180, 105, 90);
			btn_exit.setForeground(Color.white);
			btn_exit.setBorder(thickBorder1);
			btn_exit.setBackground(Color.decode("#250800"));
			btn_exit.addActionListener(this);
			btn_home.addActionListener(this);
			pan_side_Home.add(btn_exit);
			pan_side_Home.add(btn_home);
			pan_side_Home.setBounds(0, 0, 150, 700);
			pan_side_Home.setLayout(null);
			pan_side_Home.setBackground(Color.decode("#D2DDF1"));

			setttings.Numvalidator(txt_4);
			setttings.Numvalidator(txt_5);
			setttings.Numvalidator(txt_7);
			setttings.Numvalidator1(txt_1);

			Show_Details();
			this.add(pan_side_Home);
			this.add(pan_firstbordar);
			this.show();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error viewall gui" + ex.toString());

		}
	}

	public void show_audioFrame() {
		try {

			frm_audio.setSize(400, 450);
			frm_audio.setTitle("Audio Clip");

			JLabel lbl_audioClip_TITLE = new JLabel("D E T A I L S   A D I O    C L I P S");

			JLabel lbl_audioClip_1 = new JLabel("Clip Name");
			JLabel lbl_audioClip_2 = new JLabel("Duration");
			JLabel lbl_audioClip_3 = new JLabel("Select");
			JLabel lbl_audioClip_4 = new JLabel("Times played");
			JLabel lbl_audioClip_5 = new JLabel("Maximum Number");
			JLabel lbl_audioClip_6 = new JLabel("Minimun Number");
			JLabel lbl_audioClip_7 = new JLabel("Select");
			JLabel lbl_audioClip_8 = new JLabel("Genre");

			lbl_audioClip_1.setFont(font_text);
			lbl_audioClip_2.setFont(font_text);
			lbl_audioClip_3.setFont(font_text);
			lbl_audioClip_4.setFont(font_text);
			lbl_audioClip_5.setFont(font_text);
			lbl_audioClip_6.setFont(font_text);
			lbl_audioClip_7.setFont(font_text);
			lbl_audioClip_8.setFont(font_text);

			lbl_audioClip_TITLE.setBounds(20, 8, 410, 25);
			lbl_audioClip_TITLE.setFont(font_text1);

			txt_audioClip_7.addItem("Audio");
			txt_audioClip_7.addItem("Video");

			txt_audioClip_3.addItem("sager");
			txt_audioClip_8.addItem("sager");

			lbl_audioClip_1.setBounds(20, 60, 180, 25);
			txt_audioClip_1.setBounds(157, 60, 210, 25);

			// txt_audioClip_id.setBounds(157, 30, 80, 25);

			lbl_audioClip_2.setBounds(20, 100, 180, 25);
			txt_audioClip_2.setBounds(157, 100, 210, 25);

			lbl_audioClip_3.setBounds(20, 140, 180, 25);
			txt_audioClip_3.setBounds(157, 140, 210, 25);

			lbl_audioClip_4.setBounds(20, 180, 180, 25);
			txt_audioClip_4.setBounds(157, 180, 210, 25);

			lbl_audioClip_5.setBounds(20, 220, 180, 25);
			txt_audioClip_5.setBounds(157, 220, 210, 25);

			lbl_audioClip_6.setBounds(20, 260, 180, 25);
			txt_audioClip_6.setBounds(157, 260, 210, 25);

			lbl_audioClip_7.setBounds(20, 300, 180, 25);
			txt_audioClip_7.setBounds(157, 300, 210, 25);

			lbl_audioClip_8.setBounds(20, 340, 180, 25);
			txt_audioClip_8.setBounds(157, 340, 210, 25);

			btn_audioClip_close.setBounds(195, 390, 80, 25);
			btn_audioClip_ok.setBounds(285, 390, 80, 25);
			btn_audioClip_close.addActionListener(this);
			btn_audioClip_ok.addActionListener(this);

			frm_audio.setLocation(screenheith / 2, screedwidth / 8);
			frm_audio.setLayout(null);
			frm_audio.setResizable(false);

			frm_audio.add(btn_audioClip_close);
			frm_audio.add(btn_audioClip_ok);
			frm_audio.add(lbl_audioClip_TITLE);

			frm_audio.add(lbl_audioClip_1);
			frm_audio.add(lbl_audioClip_2);
			frm_audio.add(lbl_audioClip_3);
			frm_audio.add(lbl_audioClip_4);
			frm_audio.add(lbl_audioClip_5);
			frm_audio.add(lbl_audioClip_6);
			frm_audio.add(lbl_audioClip_7);
			frm_audio.add(lbl_audioClip_8);

			setttings.Numvalidator1(txt_audioClip_1);
			setttings.Numvalidator(txt_audioClip_2);
			setttings.Numvalidator(txt_audioClip_4);
			setttings.Numvalidator(txt_audioClip_5);
			setttings.Numvalidator(txt_audioClip_6);

			// frm_audio.add(txt_audioClip_id);
			frm_audio.add(txt_audioClip_1);
			frm_audio.add(txt_audioClip_2);
			frm_audio.add(txt_audioClip_3);
			frm_audio.add(txt_audioClip_4);
			frm_audio.add(txt_audioClip_5);
			frm_audio.add(txt_audioClip_6);
			frm_audio.add(txt_audioClip_7);
			frm_audio.add(txt_audioClip_8);

			frm_audio.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}

	public void show_videoFrame() {
		try {
			//
			frm_video.setSize(400, 450);
			frm_video.setTitle("Video Clip");

			JLabel lbl_VIDEOClip_TITLE = new JLabel("D E T A I L S   V I E O    C L I P S");

			JLabel lbl_VIDEOClip_1 = new JLabel("Clip Name");
			JLabel lbl_VIDEOClip_2 = new JLabel("Duration");
			JLabel lbl_VIDEOClip_3 = new JLabel("Select");
			JLabel lbl_VIDEOClip_4 = new JLabel("Times played");
			JLabel lbl_VIDEOClip_5 = new JLabel("Maximum Number");
			JLabel lbl_VIDEOClip_6 = new JLabel("Minimun Number");
			JLabel lbl_VIDEOClip_7 = new JLabel("Select");
			JLabel lbl_VIDEOClip_8 = new JLabel("Genre");

			lbl_VIDEOClip_1.setFont(font_text);
			lbl_VIDEOClip_2.setFont(font_text);
			lbl_VIDEOClip_3.setFont(font_text);
			lbl_VIDEOClip_4.setFont(font_text);
			lbl_VIDEOClip_5.setFont(font_text);
			lbl_VIDEOClip_6.setFont(font_text);
			lbl_VIDEOClip_7.setFont(font_text);
			lbl_VIDEOClip_8.setFont(font_text);

			lbl_VIDEOClip_TITLE.setBounds(20, 8, 410, 25);
			lbl_VIDEOClip_TITLE.setFont(font_text1);

			txt_VIDEOClip_7.addItem("Audio");
			txt_VIDEOClip_7.addItem("Video");

			txt_VIDEOClip_3.addItem("sager");
			txt_VIDEOClip_8.addItem("sager");

			lbl_VIDEOClip_1.setBounds(20, 60, 180, 25);
			txt_VIDEOClip_1.setBounds(157, 60, 210, 25);
			// txt_VIDEOClip_id.setBounds(157, 35, 80, 25);

			lbl_VIDEOClip_2.setBounds(20, 100, 180, 25);
			txt_VIDEOClip_2.setBounds(157, 100, 210, 25);

			lbl_VIDEOClip_3.setBounds(20, 140, 180, 25);
			txt_VIDEOClip_3.setBounds(157, 140, 210, 25);

			lbl_VIDEOClip_4.setBounds(20, 180, 180, 25);
			txt_VIDEOClip_4.setBounds(157, 180, 210, 25);

			lbl_VIDEOClip_5.setBounds(20, 220, 180, 25);
			txt_VIDEOClip_5.setBounds(157, 220, 210, 25);

			lbl_VIDEOClip_6.setBounds(20, 260, 180, 25);
			txt_VIDEOClip_6.setBounds(157, 260, 210, 25);

			lbl_VIDEOClip_7.setBounds(20, 300, 180, 25);
			txt_VIDEOClip_7.setBounds(157, 300, 210, 25);

			lbl_VIDEOClip_8.setBounds(20, 340, 180, 25);
			txt_VIDEOClip_8.setBounds(157, 340, 210, 25);

			btn_VIDEOClip_close.setBounds(195, 390, 80, 25);
			btn_VIDEOClip_ok.setBounds(285, 390, 80, 25);
			btn_VIDEOClip_close.addActionListener(this);
			btn_VIDEOClip_ok.addActionListener(this);
			frm_video.setLocation(screenheith / 2, screedwidth / 8);
			frm_video.setLayout(null);
			frm_video.setResizable(false);

			frm_video.add(btn_VIDEOClip_close);
			frm_video.add(btn_VIDEOClip_ok);
			frm_video.add(lbl_VIDEOClip_TITLE);

			setttings.Numvalidator1(txt_VIDEOClip_1);
			setttings.Numvalidator(txt_VIDEOClip_2);
			setttings.Numvalidator(txt_VIDEOClip_4);
			setttings.Numvalidator(txt_VIDEOClip_5);
			setttings.Numvalidator(txt_VIDEOClip_6);

			frm_video.add(lbl_VIDEOClip_1);
			frm_video.add(lbl_VIDEOClip_2);
			frm_video.add(lbl_VIDEOClip_3);
			frm_video.add(lbl_VIDEOClip_4);
			frm_video.add(lbl_VIDEOClip_5);
			frm_video.add(lbl_VIDEOClip_6);
			frm_video.add(lbl_VIDEOClip_7);
			frm_video.add(lbl_VIDEOClip_8);

			// frm_video.add(txt_VIDEOClip_id);
			frm_video.add(txt_VIDEOClip_1);
			frm_video.add(txt_VIDEOClip_2);
			frm_video.add(txt_VIDEOClip_3);
			frm_video.add(txt_VIDEOClip_4);
			frm_video.add(txt_VIDEOClip_5);
			frm_video.add(txt_VIDEOClip_6);
			frm_video.add(txt_VIDEOClip_7);
			frm_video.add(txt_VIDEOClip_8);

			frm_video.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
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

	public void executeSQlQuery_addShow(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				Show_Details();
				chek_box_audio.setSelected(false);
				chek_box_video.setSelected(false);
				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");

			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void executeSQlQuery_audioclip(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				audio_clip_Clear();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void executeSQlQuery_videoclip(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				video_clip_Clear();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// retrive all the data from table into database

	public ArrayList<showInfo> receivedcustomerinfo() {
		ArrayList<showInfo> usersList = new ArrayList<showInfo>();
		Connection connection = getConnection();
		String query = "SELECT * FROM `show_1` ";
		Statement st;
		ResultSet rs;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			showInfo user;
			while (rs.next()) {
				user = new showInfo(rs.getInt("show_id"), rs.getString("show_name"), rs.getString("duration"),
						rs.getString("advertising"), rs.getString("voiceover"), rs.getString("is_select"),
						rs.getString("runperdayrunperday"), rs.getString("show_genre"), rs.getString("show_date"),
						rs.getString("showdayname"));
				usersList.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public void Show_Details() {
		ArrayList<showInfo> list = receivedcustomerinfo();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[10];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getShow_id();
			row[1] = list.get(i).getShow_name();
			row[2] = list.get(i).getShow_Duration();
			row[3] = list.get(i).getMinuts_advertising();
			row[4] = list.get(i).getVoiceover();
			row[5] = list.get(i).getIs_select();
			row[6] = list.get(i).getRun_perday();
			row[7] = list.get(i).getGenre();
			row[8] = list.get(i).getAddshow_Date();
			row[9] = list.get(i).getShow_dayname();
			model.addRow(row);
		}
	}

	public void find_show() {

		ArrayList<showInfo> list = show_Search(txt_search.getText());//
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "Audio_Id", "Show_Name", "FileName", "Duration", "Type", "Played",
				"Maximum", "Minimum", "\"select\"", "Genrey", "Date", "DayName" });
		Object[] row = new Object[10];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getShow_id();
			row[1] = list.get(i).getShow_name();
			row[2] = list.get(i).getShow_Duration();
			row[3] = list.get(i).getMinuts_advertising();
			row[4] = list.get(i).getVoiceover();
			row[5] = list.get(i).getIs_select();
			row[6] = list.get(i).getRun_perday();
			row[7] = list.get(i).getGenre();
			row[8] = list.get(i).getAddshow_Date();
			row[9] = list.get(i).getShow_dayname();

			model.addRow(row);
		}
		table.setModel(model);

	}

	public ArrayList<showInfo> show_Search(String searchshowname) {
		ArrayList<showInfo> show_list = new ArrayList<showInfo>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `show_1` WHERE CONCAT(`show_id`, `show_name`,`duration`, `advertising`,`voiceover`,`is_select`,`runperdayrunperday`,`show_genre`,`show_date`,`showdayname`) LIKE '%"
					+ searchshowname + "%'";
			rs = st.executeQuery(searchQuery);
			showInfo user;
			while (rs.next()) {
				user = new showInfo(rs.getInt("show_id"), rs.getString("show_name"), rs.getString("duration"),
						rs.getString("advertising"), rs.getString("voiceover"), rs.getString("is_select"),
						rs.getString("runperdayrunperday"), rs.getString("show_genre"), rs.getString("show_date"),
						rs.getString("showdayname"));
				show_list.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return show_list;
	}

	// retrive all the data from table into database

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source.equals(btn_clear)) {
			clearall();
		} else if (source.equals(btn_add)) {
			add_show();
			video_clip_Clear();
			audio_clip_Clear();
			clearall();
		} else if (source.equals(check_box_audio)) {
			show_audioFrame();
		} else if (source.equals(check_box_video)) {
			show_videoFrame();
		} else if (source.equals(btn_VIDEOClip_close)) {
			video_dispose();
		} else if (source.equals(btn_VIDEOClip_ok)) {
			video_getText();
		} else if (source.equals(btn_audioClip_close)) {
			audieo_dispose();
		} else if (source.equals(btn_audioClip_ok)) {
			audieo_getText();

		} else if (source.equals(btn_update)) {
			updateaddshow();
		} else if (source.equals(btn_delete)) {
			show_DELETE();
		} else if (source.equals(btn_search)) {
			find_show();

		} else if (source.equals(btn_exit)) {
			Home_Radio.removeall();
			this.dispose();
			this.setVisible(false);
		} else if (source.equals(btn_home)) {
			Home_Radio.removeall();
			this.setVisible(false);
			Home_Radio.viewallhomepage();

		}
	}

	public void audieo_getText() {
		try {
			if (txt_audioClip_1.getText().equals("") || txt_audioClip_2.getText().equals("")
					|| txt_audioClip_4.getText().equals("") || txt_audioClip_5.getText().equals("")
					|| txt_audioClip_6.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Sorry Field Must Not Empty!!!");
			} else {

				audio_clip_Name = txt_audioClip_1.getText().trim();
				audio_clip_Duration = txt_audioClip_2.getText().trim();
				audio_clip_Select = txt_audioClip_3.getSelectedItem().toString();
				audio_clip_TimesPlay = txt_audioClip_4.getText().trim();
				audio_clip_MaxNum = txt_audioClip_5.getText().trim();
				audio_clip_MinNum = txt_audioClip_6.getText().trim();
				audio_clip_Min = txt_audioClip_7.getSelectedItem().toString();
				audio_clip_Genre = txt_audioClip_8.getSelectedItem().toString();
				audieo_dispose();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Information Missing" + ex.toString());
		}

	}

	public void video_getText() {
		try {
			if (txt_VIDEOClip_1.getText().equals("") || txt_VIDEOClip_2.getText().equals("")
					|| txt_VIDEOClip_4.getText().equals("") || txt_VIDEOClip_5.getText().equals("")
					|| txt_VIDEOClip_6.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Sorry Field Must Not Empty!!!");
			} else {

				VIDEO_clip_Name = txt_VIDEOClip_1.getText().trim();
				VIDEO_clip_Duration = txt_VIDEOClip_2.getText().trim();
				VIDEO_clip_Select = txt_VIDEOClip_3.getSelectedItem().toString();
				VIDEO_clip_TimesPlay = txt_VIDEOClip_4.getText().trim();
				VIDEO_clip_MaxNum = txt_VIDEOClip_5.getText().trim();
				VIDEO_clip_MinNum = txt_VIDEOClip_6.getText().trim();
				VIDEO_clip_Min = txt_VIDEOClip_7.getSelectedItem().toString();
				VIDEO_clip_Genre = txt_VIDEOClip_8.getSelectedItem().toString();
				video_dispose();
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Information Missing" + ex.toString());
		}
	}

	public void add_show() {

		String show_Name = "";
		String show_Duration = "";
		String show_advertisment = "";
		String show_voiceover = "";
		String show_selected = "";
		String show_runperday = "";
		String show_genre = "";
		String show_dayName = "";
		String date_time = DateFormat.getDateTimeInstance().format(td);
		// clip code

		// clip code

		int get_id = Integer.parseInt(txt_id.getText());
		show_Name = txt_1.getText().toString();
		show_Duration = txt_2.getSelectedItem().toString();
		show_advertisment = txt_4.getText().toString();
		show_voiceover = txt_5.getText().toString();
		show_selected = txt_6.getSelectedItem().toString();
		show_runperday = txt_7.getText().toString();
		show_genre = txt_8.getSelectedItem().toString();
		show_dayName = txt_date.getSelectedItem().toString();

		// Clip data

		String fetch_dataAudieo_1 = audio_clip_Name;
		String fetch_dataAudieo_2 = audio_clip_Duration;
		String fetch_dataAudieo_3 = audio_clip_Select;
		String fetch_dataAudieo_4 = audio_clip_TimesPlay;
		String fetch_dataAudieo_5 = audio_clip_MaxNum;
		String fetch_dataAudieo_6 = audio_clip_MinNum;
		String fetch_dataAudieo_7 = audio_clip_Min;
		String fetch_dataAudieo_8 = audio_clip_Genre;

		String fetch_dataVIDEO_1 = VIDEO_clip_Name;
		String fetch_dataVIDEO_2 = VIDEO_clip_Duration;
		String fetch_dataVIDEO_3 = VIDEO_clip_Select;
		String fetch_dataVIDEO_4 = VIDEO_clip_TimesPlay;
		String fetch_dataVIDEO_5 = VIDEO_clip_MaxNum;
		String fetch_dataVIDEO_6 = VIDEO_clip_MinNum;
		String fetch_dataVIDEO_7 = VIDEO_clip_Min;
		String fetch_dataVIDEO_8 = VIDEO_clip_Genre;

		// Clip data

		if (show_Name.equals("") || show_advertisment.equals("") || show_voiceover.equals("")
				|| show_runperday.equals("")) {

			JOptionPane.showMessageDialog(null, "Field Must Not Empty!!");

		} else {
			Statement stmt;
			try {
				stmt = conn.createStatement();
				String query = "SELECT * FROM show_1 WHERE duration='" + show_Duration + "'" + "AND showdayname ='"
						+ show_dayName + "'";
				;
				ResultSet rs = stmt.executeQuery(query);
				int found = 0;
				while (rs.next()) {
					String dialogmessage = "Record Already Exists in DataBase!!!";
					int dialogtype = JOptionPane.WARNING_MESSAGE;
					JOptionPane.showMessageDialog((Component) null, dialogmessage, "", dialogtype);
					found = 1;
				}
				if (found == 0) {
					String querey = "INSERT INTO show_1 VALUES ('" + get_id + "','" + show_Name + "','" + show_Duration
							+ "','" + show_advertisment + "','" + show_voiceover + "','" + show_selected + "','"
							+ show_runperday + "','" + show_genre + "','" + date_time + "','" + show_dayName + "','"
							+ fetch_dataAudieo_2 + "','" + fetch_dataVIDEO_2 + "')";

					executeSQlQuery_addShow(querey, "Add");

					String querey_audioclip = "INSERT INTO audio_clip VALUES ('" + get_id + "','" + show_Name + "','"
							+ fetch_dataAudieo_1 + "','" + fetch_dataAudieo_2 + "','" + fetch_dataAudieo_3 + "','"
							+ fetch_dataAudieo_4 + "','" + fetch_dataAudieo_5 + "','" + fetch_dataAudieo_6 + "','"
							+ fetch_dataAudieo_7 + "','" + fetch_dataAudieo_8 + "','" + date_time + "','" + show_dayName
							+ "')";

					executeSQlQuery_audioclip(querey_audioclip, "Add");

					String querey_videoclip = "INSERT INTO video_clip VALUES ('" + get_id + "','" + show_Name + "','"
							+ fetch_dataVIDEO_1 + "','" + fetch_dataVIDEO_2 + "','" + fetch_dataVIDEO_3 + "','"
							+ fetch_dataVIDEO_4 + "','" + fetch_dataVIDEO_5 + "','" + fetch_dataVIDEO_6 + "','"
							+ fetch_dataVIDEO_7 + "','" + fetch_dataVIDEO_8 + "','" + date_time + "','" + show_dayName
							+ "')";

					executeSQlQuery_videoclip(querey_videoclip, "Add");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void updateaddshow() {
		String show_Name = "";
		String show_Duration = "";
		String show_advertisment = "";
		String show_voiceover = "";
		String show_selected = "";
		String show_runperday = "";
		String show_genre = "";
		String show_dayName = "";
		String date_time = DateFormat.getDateTimeInstance().format(td);

		int get_id = Integer.parseInt(txt_id.getText());
		show_Name = txt_1.getText().toString();
		show_Duration = txt_2.getSelectedItem().toString();
		show_advertisment = txt_4.getText().toString();
		show_voiceover = txt_5.getText().toString();
		show_selected = txt_6.getSelectedItem().toString();
		show_runperday = txt_7.getText().toString();
		show_genre = txt_8.getSelectedItem().toString();
		show_dayName = txt_date.getSelectedItem().toString();

		if (show_Name.equals("") || show_advertisment.equals("") || show_voiceover.equals("")
				|| show_runperday.equals("")) {
			JOptionPane.showMessageDialog(null, "Field Must Not Empty!!");
		} else {
			String temp = "UPDATE show_1 SET " + "show_id  = '" + get_id + "',show_name = '" + show_Name
					+ "',duration = '" + show_Duration + "',advertising = '" + show_advertisment + "',voiceover = '"
					+ show_voiceover + "',is_select = '" + show_selected + "',runperdayrunperday = '" + show_runperday
					+ "',show_genre = '" + show_genre + "',show_date = '" + date_time + "',showdayname = '"
					+ show_dayName + "'" + "WHERE show_id = '" + get_id + "'";
			executeSQlQuery_addShow(temp, "Update");
		}
	}

	public void show_DELETE() {
		String getid = txt_id.getText().trim();
		if (txt_id.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please Select Table Row!!!", "Error Delete Button",
					JOptionPane.ERROR_MESSAGE);
		} else {
			String query_show = "DELETE FROM `show_1` WHERE show_id = " + getid;
			executeSQlQuery_addShow(query_show, "Deleted Record!!");
			String query_audio = "DELETE FROM `audio_clip` WHERE audio_id = " + getid;
			executeSQlQuery_audioclip(query_audio, "Deleted Record!!");
			String query_video = "DELETE FROM `video_clip` WHERE video_id = " + getid;
			executeSQlQuery_videoclip(query_video, "Deleted Record!!");
		}
	}

	public void audieo_dispose() {
		frm_audio.dispose();
		frm_audio.setVisible(false);
	}

	public void video_dispose() {
		frm_video.dispose();
		frm_video.setVisible(false);
	}

	public void clearall() {
		txt_1.setText("");
		txt_4.setText("");
		txt_5.setText("");
		chek_box_audio.setSelected(false);
		chek_box_video.setSelected(false);

	}

	public void audio_clip_Clear() {
		txt_audioClip_1.setText("");
		txt_audioClip_2.setText("");
		txt_audioClip_4.setText("");
		txt_audioClip_5.setText("");
		txt_audioClip_6.setText("");

	}

	public void video_clip_Clear() {
		txt_VIDEOClip_1.setText("");
		txt_VIDEOClip_2.setText("");
		txt_VIDEOClip_4.setText("");
		txt_VIDEOClip_5.setText("");
		txt_VIDEOClip_6.setText("");

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		int i = table.getSelectedRow();
		TableModel model = table.getModel();
		txt_id.setText(model.getValueAt(i, 0).toString());
		txt_1.setText(model.getValueAt(i, 1).toString());
		txt_4.setText(model.getValueAt(i, 3).toString());
		txt_5.setText(model.getValueAt(i, 4).toString());
		txt_7.setText(model.getValueAt(i, 6).toString());

	}

	@Override
	public void mouseEntered(MouseEvent action) {

	}

	@Override
	public void mouseExited(MouseEvent action) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent ev) {

	}

}
