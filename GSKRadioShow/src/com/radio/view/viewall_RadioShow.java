package com.radio.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import com.radio.model.audio_Info;
import com.radio.model.showInfo;
import com.radio.model.video_Info;

public class viewall_RadioShow extends JInternalFrame implements MouseListener, ActionListener {
	/**
	 * @author Golam Nobi
	 */
	private static final long serialVersionUID = 1L;
	private Date td = new Date();
	Connection conn;
	DBconnection connect = new DBconnection();
	private JButton btn_search = new JButton("Search");
	private JButton btn_delete = new JButton("Delete");
	JButton btn_update = new JButton("Update");

	private JTextField txt_search = new JTextField();
	private JTable table = new JTable();
	private JLabel lbl_titlview = new JLabel("VIEW  AUDIO  CLIP");
	Font font = new Font("Verdana", Font.BOLD, 13);
	Font font_combox = new Font("Verdana", Font.BOLD, 12);
	Border thickBorder = new LineBorder(Color.gray, 3);
	JScrollPane scroll_panel = new JScrollPane();
	// homePanel
	private JPanel pan_side_Home = new JPanel();
	private JButton btn_home = new JButton(new ImageIcon("images/homee.png"));
	private JButton btn_exit = new JButton("Exit");
	Border thickBorder1 = new LineBorder(Color.decode("#394B58"), 13);
	Font font_list = new Font("Verdana", Font.BOLD, 25);
	Border bordar = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	JPanel pan_allcontainer = new JPanel();
	JPanel pan = new JPanel();
	JPanel pan_1 = new JPanel();
	JPanel pan_body = new JPanel();
	JLabel lbl_selectclip = new JLabel("Select Clip");
	JComboBox<String> cmb_select = new JComboBox<String>();
	// textfild
	JTextField txt_audioid = new JTextField();
	JTextField txt_audioName = new JTextField();
	JTextField txt_audioDuration = new JTextField();
	JTextField txt_audioPlayed = new JTextField();
	JTextField txt_audioSelect = new JTextField();
	JTextField txt_audioMax = new JTextField();
	JTextField txt_audioMin = new JTextField();
	JTextField txt_audioGenrey = new JTextField();
	JTextField txt_audioDayName = new JTextField();

	JLabel lbl_audioName = new JLabel("File Name");
	JLabel lbl_audioDuration = new JLabel("Duration");
	JLabel lbl_audioPlayed = new JLabel("Played");
	JLabel lbl_audioSelect = new JLabel("Select");
	JLabel lbl_audioMax = new JLabel("Maximum");
	JLabel lbl_audioMin = new JLabel("Minimum");
	JLabel lbl_audioGenrey = new JLabel("Genrey");
	JLabel lbl_audioDayName = new JLabel("DayName");

	private JButton btn_search_video = new JButton("Search");
	private JButton btn_delete_video = new JButton("Delete");
	private JButton btn_updateVIDEO = new JButton("Update");
	private JTextField txt_search_VIDEO = new JTextField();
	private JTable table_VIDEO = new JTable();
	JScrollPane scroll_panelVIDEO = new JScrollPane();

	// textfield
	// HomePanel
	public viewall_RadioShow(JFrame getParentFrame) {
		super("View All Radio Show", false, true, false, false);
		view_all();
	}

	public void view_all() {
		try {
			this.setSize(1095, 550);
			cmb_select.addItem("Audio Clip");
			cmb_select.addItem("Video Clip");
			cmb_select.setFont(font_combox);

			lbl_selectclip.setBounds(820, 40, 100, 30);
			cmb_select.setBounds(910, 40, 150, 30);
			lbl_selectclip.setFont(font);
			btn_update.setFont(font);
			btn_search.setFont(font);
			btn_delete.setFont(font);
			pan.setLayout(null);
			pan.setBounds(20, 200, 840, 220);
			pan.setBackground(Color.gray);
			pan.setLayout(new GridLayout(0, 1));
			pan.setBorder(thickBorder);

			pan_1.setLayout(null);
			pan_1.setBounds(20, 200, 840, 220);
			pan_1.setBackground(Color.gray);
			pan_1.setLayout(new GridLayout(0, 1));
			pan_1.setBorder(thickBorder);

			txt_search.setBounds(190, 40, 150, 25);
			btn_search.setBounds(360, 40, 80, 25);

			btn_search_video.setBounds(360, 40, 80, 25);
			txt_search_VIDEO.setBounds(190, 40, 150, 25);

			btn_delete.setBounds(750, 15, 100, 30);
			btn_update.setBounds(750, 65, 100, 30);
			txt_audioid.setBounds(750, 155, 100, 30);

			btn_delete_video.setBounds(750, 15, 100, 30);
			btn_updateVIDEO.setBounds(750, 65, 100, 30);

			lbl_titlview.setBounds(480, 5, 350, 30);
			lbl_titlview.setFont(font_list);
			lbl_titlview.setForeground(Color.decode("#E24444"));

			table.addMouseListener(this);
			Action action = new Action();// Handle all the class listener
			table_VIDEO.addMouseListener(action);
			table.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
					new String[] { "Audio_Id", "Show_Name", "FileName", "Duration", "Type", "Played", "Maximum",
							"Minimum", "select", "Genrey", "Date", "DayName" }));

			scroll_panel.setViewportView(table);
			table_VIDEO.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
					new String[] { "Audio_Id", "Show_Name", "FileName", "Duration", "Type", "Played", "Maximum",
							"Minimum", "select", "Genrey", "Date", "DayName" }));

			scroll_panelVIDEO.setViewportView(table_VIDEO);
			pan_1.add(scroll_panelVIDEO);
			pan.add(scroll_panel);
			pan_1.setVisible(false);
			btn_delete_video.setVisible(false);
			btn_updateVIDEO.setVisible(false);
			btn_search_video.setVisible(false);
			txt_search_VIDEO.setVisible(false);

			btn_delete_video.setFont(font);
			btn_updateVIDEO.setFont(font);
			btn_search_video.setFont(font);

			btn_updateVIDEO.addActionListener(this);
			btn_search_video.addActionListener(this);
			btn_delete_video.addActionListener(this);
			btn_update.addActionListener(this);
			btn_search.addActionListener(this);

			btn_home.setBounds(20, 60, 105, 90);
			btn_home.setBorder(thickBorder1);
			btn_home.setBackground(Color.decode("#250800"));
			btn_exit.setBounds(20, 180, 105, 90);
			btn_exit.setBorder(thickBorder1);
			btn_exit.setBackground(Color.decode("#250800"));
			pan_side_Home.add(btn_exit);
			pan_side_Home.add(btn_home);
			pan_side_Home.setBounds(0, 0, 150, 700);
			pan_side_Home.setLayout(null);
			pan_side_Home.setBackground(Color.decode("#D2DDF1"));

			pan_allcontainer.setLayout(null);
			pan_allcontainer.setBounds(180, 80, 880, 430);
			pan_body.setLayout(null);
			pan_body.setBorder(bordar);
			pan_body.setBounds(20, 15, 710, 170);

			lbl_audioName.setBounds(20, 20, 180, 25);
			txt_audioName.setBounds(130, 20, 200, 25);
			lbl_audioDuration.setBounds(20, 60, 180, 25);
			txt_audioDuration.setBounds(130, 60, 200, 25);

			lbl_audioPlayed.setBounds(20, 100, 180, 25);
			txt_audioPlayed.setBounds(130, 100, 200, 25);

			lbl_audioSelect.setBounds(20, 140, 180, 25);
			txt_audioSelect.setBounds(130, 140, 200, 25);

			lbl_audioMax.setBounds(370, 20, 180, 25);
			txt_audioMax.setBounds(470, 20, 200, 25);

			lbl_audioMin.setBounds(370, 60, 180, 25);
			txt_audioMin.setBounds(470, 60, 200, 25);

			lbl_audioGenrey.setBounds(370, 100, 180, 25);
			txt_audioGenrey.setBounds(470, 100, 200, 25);

			lbl_audioDayName.setBounds(370, 140, 180, 25);
			txt_audioDayName.setBounds(470, 140, 200, 25);

			pan_body.add(lbl_audioName);
			pan_body.add(txt_audioName);
			pan_body.add(lbl_audioDuration);
			pan_body.add(txt_audioDuration);
			pan_body.add(lbl_audioPlayed);
			pan_body.add(txt_audioPlayed);
			pan_body.add(lbl_audioSelect);
			pan_body.add(txt_audioSelect);
			pan_body.add(lbl_audioMax);
			pan_body.add(txt_audioMax);
			pan_body.add(lbl_audioMin);
			pan_body.add(txt_audioMin);
			pan_body.add(lbl_audioGenrey);
			pan_body.add(txt_audioGenrey);
			pan_body.add(lbl_audioDayName);
			pan_body.add(txt_audioDayName);

			pan_allcontainer.setBorder(bordar);
			pan_allcontainer.add(btn_delete);
			pan_allcontainer.add(txt_audioid);
			pan_allcontainer.add(btn_update);

			pan_allcontainer.add(btn_delete_video);
			pan_allcontainer.add(btn_updateVIDEO);

			pan_allcontainer.add(pan);
			pan_allcontainer.add(pan_1);
			pan_allcontainer.add(pan_body);

			cmb_select.addActionListener(this);
			btn_search.addActionListener(this);
			btn_delete.addActionListener(this);
			btn_exit.addActionListener(this);
			btn_home.addActionListener(this);

			this.add(pan_side_Home);
			this.add(lbl_titlview);
			this.add(txt_search);
			this.add(btn_search);
			this.add(btn_search_video);
			this.add(txt_search_VIDEO);
			this.setLayout(null);
			this.add(lbl_selectclip);
			this.add(cmb_select);
			this.add(pan_allcontainer);
			Show_Details();
			videoclip_Details();
			audio_visibleTRUE();
			this.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error viewall gui" + ex.toString());

		}
	}

	public void viewallvisiblefalse() {
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

	public void executeSQlQuery_queryclip(String query, String message) {
		Connection con = getConnection();
		Statement st;
		try {
			st = con.createStatement();
			if ((st.executeUpdate(query)) == 1) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				DefaultTableModel model_1 = (DefaultTableModel) table_VIDEO.getModel();
				model.setRowCount(0);
				model_1.setRowCount(0);
				Show_Details();
				videoclip_Details();
				setTextaudiovideo();
				txt_audioid.setText("");
				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
			} else {
				JOptionPane.showMessageDialog(null, "Data Not " + message);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<audio_Info> receivedcustomerinfo() {
		ArrayList<audio_Info> usersList = new ArrayList<audio_Info>();
		Connection connection = getConnection();
		String query = "SELECT * FROM `audio_clip` ";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			audio_Info user;
			while (rs.next()) {
				user = new audio_Info(rs.getInt("audio_id"), rs.getString("audio_showname"), rs.getString("audio_name"),
						rs.getString("audio_duration"), rs.getString("audio_select"), rs.getString("audio_played"),
						rs.getString("audio_max"), rs.getString("audio_min"), rs.getString("audio_anselect"),
						rs.getString("audio_genre"), rs.getString("audio_date"), rs.getString("audio_dayname"));
				usersList.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public void Show_Details() {
		ArrayList<audio_Info> list = receivedcustomerinfo();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[12];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getAudio_id();
			row[1] = list.get(i).getAudioshow_name();
			row[2] = list.get(i).getAudio_name();
			row[3] = list.get(i).getAudio_duration();
			row[4] = list.get(i).getAudio_select();
			row[5] = list.get(i).getAudio_played();
			row[6] = list.get(i).getAudio_max();
			row[7] = list.get(i).getAudio_min();
			row[8] = list.get(i).getAudio_selectanother();
			row[9] = list.get(i).getAudio_genre();
			row[10] = list.get(i).getAudio_date();
			row[11] = list.get(i).getAudio_dayname();
			model.addRow(row);
		}
	}

	public void find_show() {

		ArrayList<audio_Info> list = show_Search(txt_search.getText());//
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "Audio_Id", "Show_Name", "FileName", "Duration", "Type", "Played",
				"Maximum", "Minimum", "\"select\"", "Genrey", "Date", "DayName" });

		Object[] row = new Object[12];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getAudio_id();
			row[1] = list.get(i).getAudioshow_name();
			row[2] = list.get(i).getAudio_name();
			row[3] = list.get(i).getAudio_duration();
			row[4] = list.get(i).getAudio_select();
			row[5] = list.get(i).getAudio_played();
			row[6] = list.get(i).getAudio_max();
			row[7] = list.get(i).getAudio_min();
			row[8] = list.get(i).getAudio_selectanother();
			row[9] = list.get(i).getAudio_genre();
			row[10] = list.get(i).getAudio_date();
			row[11] = list.get(i).getAudio_dayname();
			model.addRow(row);
		}
		table.setModel(model);

	}

	public ArrayList<audio_Info> show_Search(String searchshowname) {
		ArrayList<audio_Info> show_list = new ArrayList<audio_Info>();
		Statement st;
		ResultSet rs;
		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `audio_clip` WHERE CONCAT(`audio_id`, `audio_showname`,`audio_name`, `audio_duration`,`audio_select`,`audio_played`,`audio_max`,`audio_min`,`audio_anselect`,`audio_genre`,`audio_date`,`audio_dayname`) LIKE '%"
					+ searchshowname + "%'";
			rs = st.executeQuery(searchQuery);
			audio_Info user;
			while (rs.next()) {
				user = new audio_Info(rs.getInt("audio_id"), rs.getString("audio_showname"), rs.getString("audio_name"),
						rs.getString("audio_duration"), rs.getString("audio_select"), rs.getString("audio_played"),
						rs.getString("audio_max"), rs.getString("audio_min"), rs.getString("audio_anselect"),
						rs.getString("audio_genre"), rs.getString("audio_date"), rs.getString("audio_dayname"));
				show_list.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return show_list;
	}

	// video table
	public ArrayList<video_Info> received_VIDEOCLIP() {
		ArrayList<video_Info> usersList = new ArrayList<video_Info>();
		Connection connection = getConnection();
		String query = "SELECT * FROM `video_clip` ";
		Statement st;
		ResultSet rs;
		//
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			video_Info user;
			while (rs.next()) {
				user = new video_Info(rs.getInt("video_id"), rs.getString("video_showname"), rs.getString("video_name"),
						rs.getString("video_duration"), rs.getString("video_select"), rs.getString("video_played"),
						rs.getString("video_max"), rs.getString("video_min"), rs.getString("video_anselect"),
						rs.getString("video_genre"), rs.getString("video_date"), rs.getString("video_dayname"));
				usersList.add(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public void videoclip_Details() {
		ArrayList<video_Info> list = received_VIDEOCLIP();
		DefaultTableModel model = (DefaultTableModel) table_VIDEO.getModel();
		Object[] row = new Object[12];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getVideo_id();
			row[1] = list.get(i).getVideoshow_name();
			row[2] = list.get(i).getVideo_name();
			row[3] = list.get(i).getVideo_duration();
			row[4] = list.get(i).getVideo_select();
			row[5] = list.get(i).getVideo_played();
			row[6] = list.get(i).getVideo_max();
			row[7] = list.get(i).getVideo_min();
			row[8] = list.get(i).getVideo_selectanother();
			row[9] = list.get(i).getVideo_genre();
			row[10] = list.get(i).getVideo_date();
			row[11] = list.get(i).getVideo_dayname();
			model.addRow(row);
		}
	}

	public void find_VIDEOCLIP() {

		ArrayList<video_Info> list = SEARCH_VIDEOCLIP(txt_search_VIDEO.getText());//
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] { "Video_Id", "Show_Name", "FileName", "Duration", "Type", "Played",
				"Maximum", "Minimum", "\"select\"", "Genrey", "Date", "DayName" });

		Object[] row = new Object[12];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getVideo_id();
			row[1] = list.get(i).getVideoshow_name();
			row[2] = list.get(i).getVideo_name();
			row[3] = list.get(i).getVideo_duration();
			row[4] = list.get(i).getVideo_select();
			row[5] = list.get(i).getVideo_played();
			row[6] = list.get(i).getVideo_max();
			row[7] = list.get(i).getVideo_min();
			row[8] = list.get(i).getVideo_selectanother();
			row[9] = list.get(i).getVideo_genre();
			row[10] = list.get(i).getVideo_date();
			row[11] = list.get(i).getVideo_dayname();
			model.addRow(row);
		}
		table_VIDEO.setModel(model);

	}

	public ArrayList<video_Info> SEARCH_VIDEOCLIP(String searchshowname) {
		ArrayList<video_Info> show_list = new ArrayList<video_Info>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `video_clip` WHERE CONCAT(`video_id`, `video_showname`, `video_name`, `video_duration`,`video_select`,`video_played`,`video_max`,`video_min`,`video_anselect`,`video_genre`,`video_date`,`video_dayname`) LIKE '%"
					+ searchshowname + "%'";
			rs = st.executeQuery(searchQuery);
			video_Info user;

			while (rs.next()) {
				user = new video_Info(rs.getInt("video_id"), rs.getString("video_showname"), rs.getString("video_name"),
						rs.getString("video_duration"), rs.getString("video_select"), rs.getString("video_played"),
						rs.getString("video_max"), rs.getString("video_min"), rs.getString("video_anselect"),
						rs.getString("video_genre"), rs.getString("video_date"), rs.getString("video_dayname"));

				show_list.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return show_list;
	}

	// video table

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int i = table.getSelectedRow();
		TableModel model = table.getModel();
		txt_audioid.setText(model.getValueAt(i, 0).toString());
		txt_audioName.setText(model.getValueAt(i, 2).toString());
		txt_audioDuration.setText(model.getValueAt(i, 3).toString());
		txt_audioPlayed.setText(model.getValueAt(i, 4).toString());
		txt_audioSelect.setText(model.getValueAt(i, 5).toString());
		txt_audioMax.setText(model.getValueAt(i, 6).toString());
		txt_audioMin.setText(model.getValueAt(i, 7).toString());
		txt_audioGenrey.setText(model.getValueAt(i, 9).toString());
		txt_audioDayName.setText(model.getValueAt(i, 11).toString());

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source.equals(btn_delete)) {
			String getid = txt_audioid.getText().trim();
			if (txt_audioid.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please Select Table Row!!!", "Error Delete Button",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String query = "DELETE FROM `audio_clip` WHERE audio_id = " + getid;
				executeSQlQuery_queryclip(query, "Deleted Record!!");
			}

		} else if (source.equals(btn_delete_video)) {
			String getid = txt_audioid.getText().trim();
			if (txt_audioid.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Please Select Table Row!!!", "Error Delete Button",
						JOptionPane.ERROR_MESSAGE);
			} else {
				String query = "DELETE FROM `video_clip` WHERE video_id = " + getid;
				executeSQlQuery_queryclip(query, "Deleted Record!!");
			}

		} else if (source.equals(btn_search)) {
			find_show();
		} else if (source.equals(cmb_select)) {
			String str = cmb_select.getSelectedItem().toString();
			if (str.contentEquals("Audio Clip") == true) {
				audio_visibleTRUE();
				video_visiblefalse();
				setTextaudiovideo();
			} else {
				audio_visiblefalse();
				video_visibleTRUE();
				setTextaudiovideo();
			}
		} else if (source.equals(btn_exit)) {
			this.dispose();
			this.setVisible(false);
		} else if (source.equals(btn_home)) {
			this.setVisible(false);
			Home_Radio.viewallhomepage();
		} else if (source.equals(btn_update)) {
			update_audio();
		} else if (source.equals(btn_updateVIDEO)) {
			update_video();
		} else if (source.equals(btn_search_video)) {
			find_VIDEOCLIP();
		}

	}

	public void audio_visiblefalse() {
		btn_search.setVisible(false);
		btn_delete.setVisible(false);
		btn_update.setVisible(false);
		txt_search.setVisible(false);
		pan.setVisible(false);
	}

	public void audio_visibleTRUE() {
		btn_search.setVisible(true);
		btn_delete.setVisible(true);
		btn_update.setVisible(true);
		txt_search.setVisible(true);
		pan.setVisible(true);
	}

	public void video_visiblefalse() {
		btn_delete_video.setVisible(false);
		btn_updateVIDEO.setVisible(false);
		btn_search_video.setVisible(false);
		txt_search_VIDEO.setVisible(false);
		pan_1.setVisible(false);
	}

	public void video_visibleTRUE() {
		btn_delete_video.setVisible(true);
		btn_updateVIDEO.setVisible(true);
		btn_search_video.setVisible(true);
		txt_search_VIDEO.setVisible(true);
		pan_1.setVisible(true);
	}

	public void update_audio() {

		String AudioName = "";
		String AudioDuration = "";
		String AudioPlayed = "";
		String AudioSelect = "";
		String AudioMax = "";
		String AudioMin = "";
		String AudioGenrey = "";
		String AudioDayName = "";
		String date_time = DateFormat.getDateTimeInstance().format(td);
		int get_id = Integer.parseInt(txt_audioid.getText());
		AudioName = txt_audioName.getText().toString();
		AudioDuration = txt_audioDuration.getText().toString();
		AudioPlayed = txt_audioPlayed.getText().toString();
		AudioSelect = txt_audioSelect.getText().toString();
		AudioMax = txt_audioMax.getText().toString();
		AudioMin = txt_audioMin.getText().toString();
		AudioGenrey = txt_audioGenrey.getText().toString();
		AudioDayName = txt_audioDayName.getText().toString();

		if (AudioName.equals("") || AudioDuration.equals("") || AudioPlayed.equals("") || AudioSelect.equals("")
				|| AudioMax.equals("") || AudioMin.equals("") || AudioGenrey.equals("") || AudioDayName.equals("")) {
			JOptionPane.showMessageDialog(null, "Field Must Not Empty!!");
		} else {
			String temp = "UPDATE audio_clip SET " + "audio_id  = '" + get_id + "',audio_name = '" + AudioName
					+ "',audio_duration = '" + AudioDuration + "',audio_select = '" + AudioSelect + "',audio_played = '"
					+ AudioPlayed + "',audio_max = '" + AudioMax + "',audio_min = '" + AudioMin + "',audio_genre = '"
					+ AudioGenrey + "',audio_date = '" + date_time + "',audio_dayname = '" + AudioDayName + "'"
					+ "WHERE audio_id = '" + get_id + "'";
			executeSQlQuery_queryclip(temp, "Update");
		}
	}

	public void update_video() {
		String videoName = "";
		String videoDuration = "";
		String videoPlayed = "";
		String videoSelect = "";
		String videoMax = "";
		String videoMin = "";
		String videoGenrey = "";
		String videoDayName = "";
		String date_time = DateFormat.getDateTimeInstance().format(td);
		int get_id = Integer.parseInt(txt_audioid.getText());
		videoName = txt_audioName.getText().toString();
		videoDuration = txt_audioDuration.getText().toString();
		videoPlayed = txt_audioPlayed.getText().toString();
		videoSelect = txt_audioSelect.getText().toString();
		videoMax = txt_audioMax.getText().toString();
		videoMin = txt_audioMin.getText().toString();
		videoGenrey = txt_audioGenrey.getText().toString();
		videoDayName = txt_audioDayName.getText().toString();

		if (videoName.equals("") || videoDuration.equals("") || videoPlayed.equals("") || videoSelect.equals("")
				|| videoMax.equals("") || videoMin.equals("") || videoGenrey.equals("") || videoDayName.equals("")) {
			JOptionPane.showMessageDialog(null, "Field Must Not Empty!!");
		} else {
			String temp = "UPDATE video_clip SET " + "video_id  = '" + get_id + "',video_name = '" + videoName
					+ "',video_duration = '" + videoDuration + "',video_select = '" + videoSelect + "',video_played = '"
					+ videoPlayed + "',video_max = '" + videoMax + "',video_min = '" + videoMin + "',video_genre = '"
					+ videoGenrey + "',video_date = '" + date_time + "',video_dayname = '" + videoDayName + "'"
					+ "WHERE video_id = '" + get_id + "'";
			executeSQlQuery_queryclip(temp, "Update");
		}
	}

	public void setTextaudiovideo() {
		txt_audioid.setText("");
		txt_audioName.setText("");
		txt_audioDuration.setText("");
		txt_audioPlayed.setText("");
		txt_audioSelect.setText("");
		txt_audioMax.setText("");
		txt_audioMin.setText("");
		txt_audioGenrey.setText("");
		txt_audioDayName.setText("");

	}

	class Action implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent event) {
			int j = table_VIDEO.getSelectedRow();
			TableModel model_video = table_VIDEO.getModel();
			txt_audioid.setText(model_video.getValueAt(j, 0).toString());
			txt_audioName.setText(model_video.getValueAt(j, 2).toString());
			txt_audioDuration.setText(model_video.getValueAt(j, 3).toString());
			txt_audioPlayed.setText(model_video.getValueAt(j, 4).toString());
			txt_audioSelect.setText(model_video.getValueAt(j, 5).toString());
			txt_audioMax.setText(model_video.getValueAt(j, 6).toString());
			txt_audioMin.setText(model_video.getValueAt(j, 7).toString());
			txt_audioGenrey.setText(model_video.getValueAt(j, 9).toString());
			txt_audioDayName.setText(model_video.getValueAt(j, 11).toString());

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}
