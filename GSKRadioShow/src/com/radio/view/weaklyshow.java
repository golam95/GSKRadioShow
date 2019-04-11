package com.radio.view;

import java.awt.Color;
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
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import com.radio.model.DBconnection;

public class weaklyshow extends JInternalFrame implements ActionListener, MouseListener {
	/**
	 * @author Golam Nobi
	 */
	private static final long serialVersionUID = 1L;
	Connection conn;
	DBconnection connect = new DBconnection();
	private JLabel lbl_titlschedule = new JLabel("W E A K L Y   S C H E D U L E");
	Font font = new Font("Verdana", Font.BOLD, 25);
	Font font1 = new Font("Verdana", Font.BOLD, 13);
	Font font2 = new Font("Verdana", Font.BOLD, 30);
	Font font_list = new Font("Verdana", Font.BOLD, 13);
	private final JPanel pan_Mother = new JPanel();
	private final JScrollPane scroll = new JScrollPane(pan_Mother);
	public static JPanel pan_saterday = new JPanel();
	public static JPanel pan_sunday = new JPanel();
	public static JPanel pan_monday = new JPanel();
	public static JPanel pan_wednesday = new JPanel();
	public static JPanel pan_thuesday = new JPanel();
	public static JPanel pan_thirsday = new JPanel();
	public static JPanel pan_Friday = new JPanel();
	static Border thickBorder = new LineBorder((Color.decode("#337AB7")), 3);
	static Border thickBorder_lbl = new LineBorder((Color.white), 4);
	private static JLabel lbl_plus = new JLabel("+");
	private static JLabel lbl_minus = new JLabel("-");
	private static JLabel lbl_minus1 = new JLabel("-");
	private static JLabel lbl_minus2 = new JLabel("-");
	private static JLabel lbl_minus3 = new JLabel("-");
	private static JLabel lbl_minus4 = new JLabel("-");
	private static JLabel lbl_minus5 = new JLabel("-");
	private static JLabel lbl_minus6 = new JLabel("-");
	private JLabel lbl_date = new JLabel("SATERDAY");

	private static JLabel lbl_plus1 = new JLabel("+");
	private JLabel lbl_date1 = new JLabel("SUNDAY");

	private static JLabel lbl_plus2 = new JLabel("+");
	private JLabel lbl_date2 = new JLabel("MONDAY ");

	private static JLabel lbl_plus3 = new JLabel("+");
	private JLabel lbl_date3 = new JLabel("TUESDAY ");

	private static JLabel lbl_plus4 = new JLabel("+");
	private JLabel lbl_date4 = new JLabel("WEDNESDAY");

	private static JLabel lbl_plus5 = new JLabel("+");
	private JLabel lbl_date5 = new JLabel("THURSDAY");

	private static JLabel lbl_plus6 = new JLabel("+");
	private JLabel lbl_date6 = new JLabel("FRIDAY");
	// pan for show all the data
	private static JPanel pan_showdata1 = new JPanel();
	private static JPanel pan_showdata2 = new JPanel();
	private static JPanel pan_showdata3 = new JPanel();
	private static JPanel pan_showdata4 = new JPanel();
	private static JPanel pan_showdata5 = new JPanel();
	private static JPanel pan_showdata6 = new JPanel();
	private static JPanel pan_showdata7 = new JPanel();

	private JList<String> list_1 = new JList<String>();
	private JList<String> list_2 = new JList<String>();
	private JList<String> list_3 = new JList<String>();
	private JList<String> list_4 = new JList<String>();
	private JList<String> list_5 = new JList<String>();
	private JList<String> list_6 = new JList<String>();
	private JList<String> list_7 = new JList<String>();
	private JScrollPane scroll_panel = new JScrollPane();
	// pan for show all the data

	private JPanel pan_side_Home = new JPanel();
	private JButton btn_home = new JButton(new ImageIcon("images/homee.png"));
	private JButton btn_exit = new JButton("Exit");
	Border thickBorder1 = new LineBorder(Color.decode("#394B58"), 12);
	// allow
	protected JLabel lbl_allow1 = new JLabel("Allow");
	protected JLabel lbl_allow2 = new JLabel("Allow");
	protected JLabel lbl_allow3 = new JLabel("Allow");
	protected JLabel lbl_allow4 = new JLabel("Allow");
	protected JLabel lbl_allow5 = new JLabel("Allow");
	protected JLabel lbl_allow6 = new JLabel("Allow");
	protected JLabel lbl_allow7 = new JLabel("Allow");

	JLabel lbl_allow1_not = new JLabel("Not Allow");
	JLabel lbl_allow2_not = new JLabel("Not Allow");
	JLabel lbl_allow3_not = new JLabel("Not Allow");
	JLabel lbl_allow4_not = new JLabel("Not Allow");
	JLabel lbl_allow5_not = new JLabel("Not Allow");
	JLabel lbl_allow6_not = new JLabel("Not Allow");
	JLabel lbl_allow7_not = new JLabel("Not Allow");
	//

	JFrame frm_list_1 = new JFrame();
	String str_listVALUE = "";

	JTextField txt_VIDEOClip_1 = new JTextField();
	JTextField txt_VIDEOClip_2 = new JTextField();
	JTextField txt_VIDEOClip_3 = new JTextField();
	JTextField txt_VIDEOClip_4 = new JTextField();
	JTextField txt_VIDEOClip_5 = new JTextField();
	JTextField txt_VIDEOClip_6 = new JTextField();
	JTextField txt_VIDEOClip_7 = new JTextField();
	JTextField txt_VIDEOClip_8 = new JTextField();

	Font font_text = new Font("Verdana", Font.BOLD, 13);
	JButton btn_VIDEOClip_close = new JButton("Close");
	JButton btn_VIDEOClip_ok = new JButton("Ok");
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	protected int screenheith = screen.height;
	protected int screedwidth = screen.width;
	// special code
	JTextField txt_AudioName = new JTextField();
	JTextField txt_AudioDuration = new JTextField();
	JTextField txt_AudiodayName = new JTextField();

	JTextField txt_showName = new JTextField();
	JTextField txt_showDuration = new JTextField();
	JTextField txt_showdayName = new JTextField();

	JTextField txt_VIDEOName = new JTextField();
	JTextField txt_VIDEODuration = new JTextField();
	JTextField txt_VIDEOdayName = new JTextField();

	public weaklyshow(JFrame getParentFrame) {
		super("Weakly Schedule", true, true, false, true);
		this.setSize(1100, 620);
		this.add(scroll);
		this.setLayout(new GridLayout(0, 1));
		allow_false();
		pan_saterday.setLayout(null);
		pan_saterday.setBackground(Color.decode("#337AB7"));
		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);
		pan_thirsday.setBounds(260, 335, 710, 40);
		pan_Friday.setBounds(260, 382, 710, 40);

		// default

		pan_sunday.setLayout(null);
		pan_monday.setLayout(null);
		pan_wednesday.setLayout(null);
		pan_thuesday.setLayout(null);
		pan_thirsday.setLayout(null);
		pan_Friday.setLayout(null);
		pan_sunday.setBackground(Color.decode("#337AB7"));
		pan_monday.setBackground(Color.decode("#337AB7"));
		pan_wednesday.setBackground(Color.decode("#337AB7"));
		pan_thuesday.setBackground(Color.decode("#337AB7"));
		pan_thirsday.setBackground(Color.decode("#337AB7"));
		pan_Friday.setBackground(Color.decode("#337AB7"));

		lbl_plus.setBounds(4, 10, 50, 20);
		lbl_minus.setBounds(4, 10, 50, 20);
		lbl_date.setBounds(40, 10, 350, 20);

		//
		lbl_plus1.setBounds(4, 10, 50, 20);
		lbl_date1.setBounds(40, 10, 350, 20);
		lbl_minus1.setBounds(4, 10, 50, 20);
		//
		//
		lbl_plus2.setBounds(4, 10, 50, 20);
		lbl_date2.setBounds(40, 10, 350, 20);
		lbl_minus2.setBounds(4, 10, 50, 20);
		//
		//
		lbl_plus3.setBounds(4, 10, 50, 20);
		lbl_date3.setBounds(40, 10, 350, 20);
		lbl_minus3.setBounds(4, 10, 50, 20);
		//
		//
		lbl_plus4.setBounds(4, 10, 50, 20);
		lbl_date4.setBounds(40, 10, 350, 20);
		lbl_minus4.setBounds(4, 10, 50, 20);
		//
		//
		lbl_plus5.setBounds(4, 10, 50, 20);
		lbl_date5.setBounds(40, 10, 350, 20);
		lbl_minus5.setBounds(4, 10, 50, 20);
		//
		//
		lbl_plus6.setBounds(4, 10, 50, 20);
		lbl_date6.setBounds(40, 10, 350, 20);
		lbl_minus6.setBounds(4, 10, 50, 20);
		//

		lbl_plus.setFont(font);
		lbl_plus1.setFont(font);
		lbl_plus2.setFont(font);
		lbl_plus3.setFont(font);
		lbl_plus4.setFont(font);
		lbl_plus5.setFont(font);
		lbl_plus6.setFont(font);

		lbl_minus.setFont(font2);
		lbl_minus1.setFont(font2);
		lbl_minus2.setFont(font2);
		lbl_minus3.setFont(font2);
		lbl_minus4.setFont(font2);
		lbl_minus5.setFont(font2);
		lbl_minus6.setFont(font2);

		lbl_date.setFont(font1);
		lbl_date1.setFont(font1);
		lbl_date2.setFont(font1);
		lbl_date3.setFont(font1);
		lbl_date4.setFont(font1);
		lbl_date5.setFont(font1);
		lbl_date6.setFont(font1);
		//// new code by golam nobi sheikh uuuuuuuuuuuuuuu
		lbl_allow1.setForeground(Color.GREEN);
		lbl_allow2.setForeground(Color.GREEN);
		lbl_allow3.setForeground(Color.GREEN);
		lbl_allow4.setForeground(Color.GREEN);
		lbl_allow5.setForeground(Color.GREEN);
		lbl_allow6.setForeground(Color.GREEN);
		lbl_allow7.setForeground(Color.GREEN);

		lbl_allow1_not.setForeground(Color.red);
		lbl_allow2_not.setForeground(Color.red);
		lbl_allow3_not.setForeground(Color.red);
		lbl_allow4_not.setForeground(Color.red);
		lbl_allow5_not.setForeground(Color.red);
		lbl_allow6_not.setForeground(Color.red);
		lbl_allow7_not.setForeground(Color.red);
		lbl_allow1.setFont(font1);
		lbl_allow2.setFont(font1);
		lbl_allow3.setFont(font1);
		lbl_allow4.setFont(font1);
		lbl_allow5.setFont(font1);
		lbl_allow6.setFont(font1);
		lbl_allow7.setFont(font1);
		lbl_allow1_not.setFont(font1);
		lbl_allow2_not.setFont(font1);
		lbl_allow3_not.setFont(font1);
		lbl_allow4_not.setFont(font1);
		lbl_allow5_not.setFont(font1);
		lbl_allow6_not.setFont(font1);
		lbl_allow7_not.setFont(font1);

		lbl_allow1.setBounds(610, 10, 350, 20);
		lbl_allow2.setBounds(650, 10, 350, 20);
		lbl_allow3.setBounds(650, 10, 350, 20);
		lbl_allow4.setBounds(650, 10, 350, 20);
		lbl_allow5.setBounds(650, 10, 350, 20);
		lbl_allow6.setBounds(650, 10, 350, 20);
		lbl_allow7.setBounds(650, 10, 350, 20);

		lbl_allow1_not.setBounds(620, 10, 350, 20);
		lbl_allow2_not.setBounds(620, 10, 350, 20);
		lbl_allow3_not.setBounds(620, 10, 350, 20);
		lbl_allow4_not.setBounds(620, 10, 350, 20);
		lbl_allow5_not.setBounds(620, 10, 350, 20);
		lbl_allow6_not.setBounds(620, 10, 350, 20);
		lbl_allow7_not.setBounds(620, 10, 350, 20);

		pan_saterday.add(lbl_allow1);
		pan_sunday.add(lbl_allow2);
		pan_monday.add(lbl_allow3);
		pan_wednesday.add(lbl_allow4);
		pan_thuesday.add(lbl_allow5);
		pan_thirsday.add(lbl_allow6);
		pan_Friday.add(lbl_allow7);

		pan_saterday.add(lbl_allow1_not);
		pan_sunday.add(lbl_allow2_not);
		pan_monday.add(lbl_allow3_not);
		pan_wednesday.add(lbl_allow4_not);
		pan_thuesday.add(lbl_allow5_not);
		pan_thirsday.add(lbl_allow6_not);
		pan_Friday.add(lbl_allow7_not);

		// new code by golam nobi sheikh ooooooooooooooooo

		lbl_plus.setForeground(Color.white);
		lbl_date.setForeground(Color.white);
		lbl_minus.setForeground(Color.white);
		lbl_minus1.setForeground(Color.white);
		lbl_plus1.setForeground(Color.white);
		lbl_date1.setForeground(Color.white);

		lbl_minus2.setForeground(Color.white);
		lbl_plus2.setForeground(Color.white);
		lbl_date2.setForeground(Color.white);

		lbl_minus3.setForeground(Color.white);
		lbl_plus3.setForeground(Color.white);
		lbl_date3.setForeground(Color.white);

		lbl_minus4.setForeground(Color.white);
		lbl_plus4.setForeground(Color.white);
		lbl_date4.setForeground(Color.white);

		lbl_minus5.setForeground(Color.white);
		lbl_plus5.setForeground(Color.white);
		lbl_date5.setForeground(Color.white);

		lbl_minus6.setForeground(Color.white);
		lbl_plus6.setForeground(Color.white);
		lbl_date6.setForeground(Color.white);

		pan_saterday.add(lbl_plus);
		pan_saterday.add(lbl_minus);
		pan_saterday.add(lbl_date);

		pan_sunday.add(lbl_plus1);
		pan_sunday.add(lbl_date1);
		pan_sunday.add(lbl_minus1);

		pan_monday.add(lbl_plus2);
		pan_monday.add(lbl_date2);
		pan_monday.add(lbl_minus2);

		pan_wednesday.add(lbl_plus3);
		pan_wednesday.add(lbl_date3);
		pan_wednesday.add(lbl_minus3);

		pan_thuesday.add(lbl_plus4);
		pan_thuesday.add(lbl_date4);
		pan_thuesday.add(lbl_minus4);

		pan_thirsday.add(lbl_plus5);
		pan_thirsday.add(lbl_date5);
		pan_thirsday.add(lbl_minus5);

		pan_Friday.add(lbl_plus6);
		pan_Friday.add(lbl_date6);
		pan_Friday.add(lbl_minus6);

		lbl_plus.setBounds(4, 10, 50, 20);
		lbl_date.setBounds(40, 10, 350, 20);
		lbl_plus.setFont(font);
		lbl_date.setFont(font1);
		lbl_plus.setForeground(Color.white);
		lbl_date.setForeground(Color.white);
		pan_saterday.add(lbl_plus);
		pan_saterday.add(lbl_date);

		// individual code
		pan_showdata1.setLayout(null);
		// list_1.setBorder(thickBorder_lbl);
		list_1.setBackground(Color.white);
		list_1.setFont(font_list);
		list_2.setFont(font_list);
		list_3.setFont(font_list);
		list_4.setFont(font_list);
		list_5.setFont(font_list);
		list_6.setFont(font_list);
		list_7.setFont(font_list);

		list_1.add(scroll_panel);

		list_1.setForeground(Color.gray);
		list_2.setForeground(Color.gray);
		list_3.setForeground(Color.gray);
		list_4.setForeground(Color.gray);
		list_5.setForeground(Color.gray);
		list_6.setForeground(Color.gray);
		list_7.setForeground(Color.gray);

		list_1.setBounds(10, 10, 690, 150);
		pan_showdata1.add(list_1);

		pan_showdata2.setLayout(null);
		list_2.setBorder(thickBorder_lbl);
		list_2.setBackground(Color.WHITE);
		list_2.setBounds(10, 10, 690, 150);
		pan_showdata2.add(list_2);

		pan_showdata3.setLayout(null);
		list_3.setBorder(thickBorder_lbl);
		list_3.setBackground(Color.WHITE);
		list_3.setBounds(10, 10, 690, 150);
		pan_showdata3.add(list_3);

		pan_showdata4.setLayout(null);
		list_4.setBorder(thickBorder_lbl);
		list_4.setBackground(Color.WHITE);
		list_4.setBounds(10, 10, 690, 150);
		pan_showdata4.add(list_4);

		pan_showdata5.setLayout(null);
		list_5.setBorder(thickBorder_lbl);
		list_5.setBackground(Color.WHITE);
		list_5.setBounds(10, 10, 690, 150);
		pan_showdata5.add(list_5);

		pan_showdata6.setLayout(null);
		list_6.setBorder(thickBorder_lbl);
		list_6.setBackground(Color.WHITE);
		list_6.setBounds(10, 10, 690, 150);
		pan_showdata6.add(list_6);

		pan_showdata7.setLayout(null);
		list_7.setBorder(thickBorder_lbl);
		list_7.setBackground(Color.WHITE);
		list_7.setBounds(10, 10, 690, 150);
		pan_showdata7.add(list_7);

		// individual code

		// Implements actionListener

		lbl_plus.addMouseListener(this);
		lbl_plus1.addMouseListener(this);
		lbl_plus2.addMouseListener(this);
		lbl_plus3.addMouseListener(this);
		lbl_plus4.addMouseListener(this);
		lbl_plus5.addMouseListener(this);
		lbl_plus6.addMouseListener(this);
		// minus a actionlistener add kora hoisa
		lbl_minus.addMouseListener(this);
		lbl_minus1.addMouseListener(this);
		lbl_minus2.addMouseListener(this);
		lbl_minus3.addMouseListener(this);
		lbl_minus4.addMouseListener(this);
		lbl_minus5.addMouseListener(this);
		lbl_minus6.addMouseListener(this);

		lbl_minus.setVisible(false);
		lbl_minus1.setVisible(false);
		lbl_minus2.setVisible(false);
		lbl_minus3.setVisible(false);
		lbl_minus4.setVisible(false);
		lbl_minus5.setVisible(false);
		lbl_minus6.setVisible(false);
		// Implements actionListener

		pan_showdata1.setVisible(false);
		pan_showdata2.setVisible(false);
		pan_showdata3.setVisible(false);
		pan_showdata4.setVisible(false);
		pan_showdata5.setVisible(false);
		pan_showdata6.setVisible(false);
		pan_showdata7.setVisible(false);

		// scrollBarVertical.setPreferredSize(new Dimension(20, 200));

		// private JPanel pan_mainbody=new JPanel();
		// 8888888888888888888888888888888888888888888888888888888888888
		btn_home.setBounds(20, 100, 105, 90);
		btn_home.setBorder(thickBorder1);
		btn_home.setBackground(Color.decode("#250800"));

		btn_home.addActionListener(this);
		btn_exit.addActionListener(this);

		btn_exit.setBounds(20, 220, 105, 90);
		btn_exit.setBorder(thickBorder1);
		btn_exit.setBackground(Color.decode("#250800"));
		btn_home.setFont(font_list);
		btn_exit.setFont(font_list);
		pan_side_Home.add(btn_exit);
		pan_side_Home.add(btn_home);
		pan_side_Home.setBounds(0, 0, 150, 700);
		pan_side_Home.setLayout(null);
		pan_side_Home.setBackground(Color.decode("#D2DDF1"));

		lbl_titlschedule.setBounds(400, 15, 450, 30);
		lbl_titlschedule.setFont(font);
		lbl_titlschedule.setForeground(Color.decode("#E24444"));

		pan_Mother.add(lbl_titlschedule);
		pan_Mother.add(pan_side_Home);
		// 99999999999999999999999999999999999999999999999999999
		// shwo data add
		pan_Mother.add(pan_showdata1);
		pan_Mother.add(pan_showdata2);
		pan_Mother.add(pan_showdata3);
		pan_Mother.add(pan_showdata4);
		pan_Mother.add(pan_showdata5);
		pan_Mother.add(pan_showdata6);
		pan_Mother.add(pan_showdata7);
		// show data add
		// this.add(scrollBarVertical);
		pan_Mother.add(pan_saterday);
		pan_Mother.add(pan_sunday);
		pan_Mother.add(pan_monday);
		pan_Mother.add(pan_wednesday);
		pan_Mother.add(pan_thuesday);
		pan_Mother.add(pan_thirsday);
		pan_Mother.add(pan_Friday);
		pan_Mother.setLayout(null);
		pan_Mother.setPreferredSize(new Dimension(80, 700));
		retrive_showName_1(list_1);
		retrive_showName_2(list_2);
		retrive_showName_3(list_3);
		retrive_showName_4(list_4);
		retrive_showName_5(list_5);
		retrive_showName_6(list_6);
		retrive_showName_7(list_7);
		check_AllowInsert_1();
		check_AllowInsert_2();
		check_AllowInsert_3();
		check_AllowInsert_4();
		check_AllowInsert_5();
		check_AllowInsert_6();
		check_AllowInsert_7();
		this.setVisible(true);

	}

	@SuppressWarnings("unlikely-arg-type")
	public static void first_click_plus() {

		pan_showdata1.setVisible(true);
		pan_showdata2.setVisible(false);
		pan_showdata3.setVisible(false);
		pan_showdata4.setVisible(false);
		pan_showdata5.setVisible(false);
		pan_showdata6.setVisible(false);
		pan_showdata7.setVisible(false);

		lbl_minus.setVisible(true);
		lbl_minus1.setVisible(false);
		lbl_minus2.setVisible(false);
		lbl_minus3.setVisible(false);
		lbl_minus4.setVisible(false);
		lbl_minus5.setVisible(false);
		lbl_minus6.setVisible(false);

		lbl_plus.setVisible(false);
		lbl_plus1.setVisible(true);
		lbl_plus2.setVisible(true);
		lbl_plus3.setVisible(true);
		lbl_plus4.setVisible(true);
		lbl_plus5.setVisible(true);
		lbl_plus6.setVisible(true);

		// raf code for my life

		pan_showdata1.setBounds(260, 140, 710, 180);
		pan_showdata1.setBackground(Color.white);
		pan_showdata1.setBorder(thickBorder);
		// pan_saterday.setBounds(160, 100, 650, 40);
		pan_saterday.setBounds(260, 100, 710, 40);

		pan_sunday.setBounds(260, 322, 710, 40);
		pan_monday.setBounds(260, 369, 710, 40);
		pan_wednesday.setBounds(260, 416, 710, 40);
		pan_thuesday.setBounds(260, 463, 710, 40);
		pan_thirsday.setBounds(260, 510, 710, 40);
		pan_Friday.setBounds(260, 557, 710, 40);

	}

	public static void second_click_plus() {

		pan_showdata1.setVisible(false);
		pan_showdata2.setVisible(true);
		pan_showdata3.setVisible(false);
		pan_showdata4.setVisible(false);
		pan_showdata5.setVisible(false);
		pan_showdata6.setVisible(false);
		pan_showdata7.setVisible(false);

		lbl_minus.setVisible(false);
		lbl_minus1.setVisible(true);
		lbl_minus2.setVisible(false);
		lbl_minus3.setVisible(false);
		lbl_minus4.setVisible(false);
		lbl_minus5.setVisible(false);
		lbl_minus6.setVisible(false);

		lbl_plus.setVisible(true);
		lbl_plus1.setVisible(false);
		lbl_plus2.setVisible(true);
		lbl_plus3.setVisible(true);
		lbl_plus4.setVisible(true);
		lbl_plus5.setVisible(true);
		lbl_plus6.setVisible(true);

		pan_showdata2.setBounds(260, 187, 710, 180);
		pan_showdata2.setBackground(Color.white);
		pan_showdata2.setBorder(thickBorder);

		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);

		pan_monday.setBounds(260, 369, 710, 40);
		pan_wednesday.setBounds(260, 416, 710, 40);
		pan_thuesday.setBounds(260, 463, 710, 40);
		pan_thirsday.setBounds(260, 510, 710, 40);
		pan_Friday.setBounds(260, 557, 710, 40);

	}

	public static void third_click_plus() {

		pan_showdata1.setVisible(false);
		pan_showdata2.setVisible(false);
		pan_showdata3.setVisible(true);
		pan_showdata4.setVisible(false);
		pan_showdata5.setVisible(false);
		pan_showdata6.setVisible(false);
		pan_showdata7.setVisible(false);

		lbl_minus.setVisible(false);
		lbl_minus1.setVisible(false);
		lbl_minus2.setVisible(true);
		lbl_minus3.setVisible(false);
		lbl_minus4.setVisible(false);
		lbl_minus5.setVisible(false);
		lbl_minus6.setVisible(false);

		lbl_plus.setVisible(true);
		lbl_plus1.setVisible(true);
		lbl_plus2.setVisible(false);
		lbl_plus3.setVisible(true);
		lbl_plus4.setVisible(true);
		lbl_plus5.setVisible(true);
		lbl_plus6.setVisible(true);

		pan_showdata3.setBounds(260, 234, 710, 180);
		pan_showdata3.setBackground(Color.white);
		pan_showdata3.setBorder(thickBorder);

		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);

		pan_wednesday.setBounds(260, 416, 710, 40);
		pan_thuesday.setBounds(260, 463, 710, 40);
		pan_thirsday.setBounds(260, 510, 710, 40);
		pan_Friday.setBounds(260, 557, 710, 40);
	}

	public static void fourth_click_plus() {

		pan_showdata1.setVisible(false);
		pan_showdata2.setVisible(false);
		pan_showdata3.setVisible(false);
		pan_showdata4.setVisible(true);
		pan_showdata5.setVisible(false);
		pan_showdata6.setVisible(false);
		pan_showdata7.setVisible(false);

		lbl_minus.setVisible(false);
		lbl_minus1.setVisible(false);
		lbl_minus2.setVisible(false);
		lbl_minus3.setVisible(true);
		lbl_minus4.setVisible(false);
		lbl_minus5.setVisible(false);
		lbl_minus6.setVisible(false);

		lbl_plus.setVisible(true);
		lbl_plus1.setVisible(true);
		lbl_plus2.setVisible(true);
		lbl_plus3.setVisible(false);
		lbl_plus4.setVisible(true);
		lbl_plus5.setVisible(true);
		lbl_plus6.setVisible(true);

		// ===========================

		pan_showdata4.setBackground(Color.white);
		pan_showdata4.setBounds(260, 281, 710, 180);
		pan_showdata4.setBorder(thickBorder);

		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);

		pan_thuesday.setBounds(260, 463, 710, 40);
		pan_thirsday.setBounds(260, 510, 710, 40);
		pan_Friday.setBounds(260, 557, 710, 40);
	}

	public static void fifth_click_plus() {

		pan_showdata1.setVisible(false);
		pan_showdata2.setVisible(false);
		pan_showdata3.setVisible(false);
		pan_showdata4.setVisible(false);
		pan_showdata5.setVisible(true);
		pan_showdata6.setVisible(false);
		pan_showdata7.setVisible(false);

		lbl_minus.setVisible(false);
		lbl_minus1.setVisible(false);
		lbl_minus2.setVisible(false);
		lbl_minus3.setVisible(false);
		lbl_minus4.setVisible(true);
		lbl_minus5.setVisible(false);
		lbl_minus6.setVisible(false);

		lbl_plus.setVisible(true);
		lbl_plus1.setVisible(true);
		lbl_plus2.setVisible(true);
		lbl_plus3.setVisible(true);
		lbl_plus4.setVisible(false);
		lbl_plus5.setVisible(true);
		lbl_plus6.setVisible(true);

		pan_showdata5.setBounds(260, 328, 710, 180);
		pan_showdata5.setBackground(Color.white);
		pan_showdata5.setBorder(thickBorder);

		//

		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);

		pan_thirsday.setBounds(260, 510, 710, 40);
		pan_Friday.setBounds(260, 557, 710, 40);
	}

	public static void six_click_plus() {
		pan_showdata1.setVisible(false);
		pan_showdata2.setVisible(false);
		pan_showdata3.setVisible(false);
		pan_showdata4.setVisible(false);
		pan_showdata5.setVisible(false);
		pan_showdata6.setVisible(true);
		pan_showdata7.setVisible(false);

		lbl_minus.setVisible(false);
		lbl_minus1.setVisible(false);
		lbl_minus2.setVisible(false);
		lbl_minus3.setVisible(false);
		lbl_minus4.setVisible(false);
		lbl_minus5.setVisible(true);
		lbl_minus6.setVisible(false);

		lbl_plus.setVisible(true);
		lbl_plus1.setVisible(true);
		lbl_plus2.setVisible(true);
		lbl_plus3.setVisible(true);
		lbl_plus4.setVisible(true);
		lbl_plus5.setVisible(false);
		lbl_plus6.setVisible(true);

		// ===========================

		pan_showdata6.setBounds(260, 375, 710, 180);
		pan_showdata6.setBackground(Color.white);
		pan_showdata6.setBorder(thickBorder);

		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);
		pan_thirsday.setBounds(260, 335, 710, 40);

		pan_Friday.setBounds(260, 557, 710, 40);
	}

	public static void seven_click_plus() {

		pan_showdata1.setVisible(false);
		pan_showdata2.setVisible(false);
		pan_showdata3.setVisible(false);
		pan_showdata4.setVisible(false);
		pan_showdata5.setVisible(false);
		pan_showdata6.setVisible(false);
		pan_showdata7.setVisible(true);

		lbl_minus.setVisible(false);
		lbl_minus1.setVisible(false);
		lbl_minus2.setVisible(false);
		lbl_minus3.setVisible(false);
		lbl_minus4.setVisible(false);
		lbl_minus5.setVisible(false);
		lbl_minus6.setVisible(true);

		lbl_plus.setVisible(true);
		lbl_plus1.setVisible(true);
		lbl_plus2.setVisible(true);
		lbl_plus3.setVisible(true);
		lbl_plus4.setVisible(true);
		lbl_plus5.setVisible(true);
		lbl_plus6.setVisible(false);

		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);
		pan_thirsday.setBounds(260, 335, 710, 40);
		pan_Friday.setBounds(260, 382, 710, 40);

		pan_showdata7.setBounds(260, 422, 710, 180);
		pan_showdata7.setBackground(Color.white);
		pan_showdata7.setBorder(thickBorder);
	}

	public static void first_click_minus() {
		pan_showdata1.setVisible(false);
		lbl_minus.setVisible(false);
		lbl_plus.setVisible(true);
		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);
		pan_thirsday.setBounds(260, 335, 710, 40);
		pan_Friday.setBounds(260, 382, 710, 40);
	}

	public static void second_click_minus() {
		pan_showdata2.setVisible(false);
		lbl_minus1.setVisible(false);
		lbl_plus1.setVisible(true);
		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);
		pan_thirsday.setBounds(260, 335, 710, 40);
		pan_Friday.setBounds(260, 382, 710, 40);
	}

	public static void third_click_minus() {
		pan_showdata3.setVisible(false);
		lbl_minus2.setVisible(false);
		lbl_plus2.setVisible(true);
		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);
		pan_thirsday.setBounds(260, 335, 710, 40);
		pan_Friday.setBounds(260, 382, 710, 40);
	}

	public static void forth_click_minus() {
		pan_showdata4.setVisible(false);
		lbl_minus3.setVisible(false);
		lbl_plus3.setVisible(true);
		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);
		pan_thirsday.setBounds(260, 335, 710, 40);
		pan_Friday.setBounds(260, 382, 710, 40);
	}

	public static void five_click_minus() {
		pan_showdata5.setVisible(false);
		lbl_minus4.setVisible(false);
		lbl_plus4.setVisible(true);
		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);
		pan_thirsday.setBounds(260, 335, 710, 40);
		pan_Friday.setBounds(260, 382, 710, 40);
	}

	public static void six_click_minus() {
		pan_showdata6.setVisible(false);
		lbl_minus5.setVisible(false);
		lbl_plus5.setVisible(true);
		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);
		pan_thirsday.setBounds(260, 335, 710, 40);
		pan_Friday.setBounds(260, 382, 710, 40);
	}

	public static void seven_click_minus() {
		pan_showdata7.setVisible(false);
		lbl_minus6.setVisible(false);
		lbl_plus6.setVisible(true);
		pan_saterday.setBounds(260, 100, 710, 40);
		pan_sunday.setBounds(260, 147, 710, 40);
		pan_monday.setBounds(260, 194, 710, 40);
		pan_wednesday.setBounds(260, 241, 710, 40);
		pan_thuesday.setBounds(260, 288, 710, 40);
		pan_thirsday.setBounds(260, 335, 710, 40);
		pan_Friday.setBounds(260, 382, 710, 40);
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

	public static Object display_firsclick() {
		return lbl_plus;

	}

	public static Object display_secondclick() {
		return lbl_plus1;

	}

	public static Object display_thirdclick() {
		return lbl_plus2;

	}

	public static Object display_forthclick() {
		return lbl_plus3;

	}

	public static Object display_fiveclick() {
		return lbl_plus4;

	}

	public static Object display_sixclick() {
		return lbl_plus5;

	}

	public static Object display_sevenclick() {
		return lbl_plus6;

	}

	public static Object display_minusfirstClick() {
		return lbl_minus;
	}

	public static Object display_minussecondClick() {
		return lbl_minus1;
	}

	public static Object display_minusthirdClick() {
		return lbl_minus2;
	}

	public static Object display_minusforthClick() {
		return lbl_minus3;
	}

	public static Object display_minusfiveClick() {
		return lbl_minus4;
	}

	public static Object display_minussixClick() {
		return lbl_minus5;
	}

	public static Object display_minusevenClick() {
		return lbl_minus6;
	}

	public void retrive_showName_1(JList<String> txt_1) {
		DefaultListModel<String> m_1 = new DefaultListModel<String>();
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM show_1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String check_dayName = rs.getString(10).trim();
				if (check_dayName.contentEquals("Saterday") == true) {
					String show_Name = rs.getString(2).trim();
					String show_Duration = rs.getString(3).trim();
					String concate = "*" + show_Name + "     " + show_Duration;
					m_1.addElement(concate);

				}

				txt_1.setModel(m_1);

			}

			conn.close();

		} catch (Exception ex) {

		}
	}

	public void retrive_showName_2(JList<String> txt_2) {
		DefaultListModel<String> m_2 = new DefaultListModel<String>();
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM show_1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String check_dayName = rs.getString(10).trim();
				if (check_dayName.contentEquals("Sunday") == true) {
					String show_Name = rs.getString(2).trim();
					String show_Duration = rs.getString(3).trim();
					String concate = "*" + show_Name + "     " + show_Duration;
					m_2.addElement(concate);

				}

				txt_2.setModel(m_2);

			}

			conn.close();

		} catch (Exception ex) {

		}
	}

	public void retrive_showName_3(JList<String> txt_3) {
		DefaultListModel<String> m_3 = new DefaultListModel<String>();
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM show_1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String check_dayName = rs.getString(10).trim();
				if (check_dayName.contentEquals("Monday") == true) {
					String show_Name = rs.getString(2).trim();
					String show_Duration = rs.getString(3).trim();
					String concate = "*" + show_Name + "     " + show_Duration;
					m_3.addElement(concate);

				}

				txt_3.setModel(m_3);

			}

			conn.close();

		} catch (Exception ex) {

		}
	}

	public void retrive_showName_4(JList<String> txt_4) {
		DefaultListModel<String> m_4 = new DefaultListModel<String>();
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM show_1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String check_dayName = rs.getString(10).trim();
				if (check_dayName.contentEquals("Tuesday") == true) {
					String show_Name = rs.getString(2).trim();
					String show_Duration = rs.getString(3).trim();
					String concate = "*" + show_Name + "     " + show_Duration;
					m_4.addElement(concate);
				}

				txt_4.setModel(m_4);

			}

			conn.close();

		} catch (Exception ex) {

		}
	}

	public void retrive_showName_5(JList<String> txt_5) {
		DefaultListModel<String> m_5 = new DefaultListModel<String>();
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM show_1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String check_dayName = rs.getString(10).trim();
				if (check_dayName.contentEquals("Wednesday") == true) {

					String show_Name = rs.getString(2).trim();
					String show_Duration = rs.getString(3).trim();
					String concate = "*" + show_Name + "     " + show_Duration;
					m_5.addElement(concate);
				}

				txt_5.setModel(m_5);

			}

			conn.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}

	public void retrive_showName_6(JList<String> txt_6) {
		DefaultListModel<String> m_6 = new DefaultListModel<String>();
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM show_1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String check_dayName = rs.getString(10).trim();
				if (check_dayName.contentEquals("Thursday") == true) {
					String show_Name = rs.getString(2).trim();
					String show_Duration = rs.getString(3).trim();
					String concate = "*" + show_Name + "     " + show_Duration;
					m_6.addElement(concate);
				}

				txt_6.setModel(m_6);

			}

			conn.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());

		}
	}

	public void retrive_showName_7(JList<String> txt_7) {
		DefaultListModel<String> m_7 = new DefaultListModel<String>();
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {

			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM show_1";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String check_dayName = rs.getString(10).trim();
				if (check_dayName.contentEquals("Friday") == true) {
					String show_Name = rs.getString(2).trim();
					String show_Duration = rs.getString(3).trim();
					String concate = "*" + show_Name + "     " + show_Duration;
					m_7.addElement(concate);
				}

				txt_7.setModel(m_7);

			}

			conn.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}

	public void allow_false() {
		lbl_allow1_not.setVisible(false);
		lbl_allow2_not.setVisible(false);
		lbl_allow3_not.setVisible(false);
		lbl_allow4_not.setVisible(false);
		lbl_allow5_not.setVisible(false);
		lbl_allow6_not.setVisible(false);
		lbl_allow7_not.setVisible(false);

	}

	public void check_AllowInsert_1() {
		String count = "";
		int countInt = 0;
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();

			String query = "SELECT COUNT(show_id) FROM show_1 WHERE showdayname='" + "Saterday" + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				count = rs.getString("COUNT(show_id)");
				countInt = Integer.parseInt(count);

			}

			conn.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		if (countInt >= 12) {
			lbl_allow1.setVisible(false);
			lbl_allow1_not.setVisible(true);
		} else {
			lbl_allow1.setVisible(true);
			lbl_allow1_not.setVisible(false);
		}

	}

	public void check_AllowInsert_2() {
		String count_1 = "";
		int countInt_1 = 0;
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT COUNT(show_id) FROM show_1 WHERE showdayname='" + "Sunday" + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				count_1 = rs.getString("COUNT(show_id)");
				countInt_1 = Integer.parseInt(count_1);

			}

			conn.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		if (countInt_1 >= 12) {
			lbl_allow2.setVisible(false);
			lbl_allow2_not.setVisible(true);
		} else {
			lbl_allow2.setVisible(true);
			lbl_allow2_not.setVisible(false);
		}

	}

	public void check_AllowInsert_3() {
		String count_2 = "";
		int countInt_2 = 0;
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT COUNT(show_id) FROM show_1 WHERE showdayname='" + "Monday" + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				count_2 = rs.getString("COUNT(show_id)");
				countInt_2 = Integer.parseInt(count_2);

			}

			conn.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		if (countInt_2 >= 12) {
			lbl_allow3.setVisible(false);
			lbl_allow3_not.setVisible(true);
		} else {
			lbl_allow3.setVisible(true);
			lbl_allow3_not.setVisible(false);
		}

	}

	public void check_AllowInsert_4() {
		String count_3 = "";
		int countInt_3 = 0;
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT COUNT(show_id) FROM show_1 WHERE showdayname='" + "Tuesday" + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				count_3 = rs.getString("COUNT(show_id)");
				countInt_3 = Integer.parseInt(count_3);

			}

			conn.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		if (countInt_3 >= 2) {
			lbl_allow4.setVisible(false);
			lbl_allow4_not.setVisible(true);
		} else {
			lbl_allow4.setVisible(true);
			lbl_allow4_not.setVisible(false);
		}

	}

	public void check_AllowInsert_5() {
		String count_4 = "";
		int countInt_4 = 0;
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT COUNT(show_id) FROM show_1 WHERE showdayname='" + "Wednesday" + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				count_4 = rs.getString("COUNT(show_id)");
				countInt_4 = Integer.parseInt(count_4);

			}

			conn.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		if (countInt_4 >= 12) {
			lbl_allow5.setVisible(false);
			lbl_allow5_not.setVisible(true);
		} else {
			lbl_allow5.setVisible(true);
			lbl_allow5_not.setVisible(false);
		}

	}

	public void check_AllowInsert_6() {
		String count_5 = "";
		int countInt_5 = 0;
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT COUNT(show_id) FROM show_1 WHERE showdayname='" + "Thursday" + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				count_5 = rs.getString("COUNT(show_id)");
				countInt_5 = Integer.parseInt(count_5);

			}

			conn.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		if (countInt_5 >= 12) {
			lbl_allow6.setVisible(false);
			lbl_allow6_not.setVisible(true);
		} else {
			lbl_allow6.setVisible(true);
			lbl_allow6_not.setVisible(false);
		}

	}

	public void check_AllowInsert_7() {
		String count_6 = "";
		int countInt_6 = 0;
		try {
			conn = connect.setConnection(conn);
		} catch (Exception e) {
		}
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT COUNT(show_id) FROM show_1 WHERE showdayname='" + "Friday" + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				count_6 = rs.getString("COUNT(show_id)");
				countInt_6 = Integer.parseInt(count_6);

			}
			conn.close();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		if (countInt_6 >= 12) {
			lbl_allow7.setVisible(false);
			lbl_allow7_not.setVisible(true);
		} else {
			lbl_allow7.setVisible(true);
			lbl_allow7_not.setVisible(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent object) {
		Object source = object.getSource();
		if (source.equals(btn_exit)) {
			this.dispose();
			this.setVisible(false);
		} else if (source.equals(btn_home)) {
			this.setVisible(false);
			Home_Radio.viewallhomepage();

		}

	}

	@Override
	public void mouseClicked(MouseEvent action) {
		Object object = action.getSource();
		if (object.equals(weaklyshow.display_firsclick())) {
			weaklyshow.first_click_plus();
		} else if (object.equals(weaklyshow.display_secondclick())) {
			weaklyshow.second_click_plus();
		} else if (object.equals(weaklyshow.display_thirdclick())) {
			weaklyshow.third_click_plus();
		} else if (object.equals(weaklyshow.display_forthclick())) {
			weaklyshow.fourth_click_plus();
		} else if (object.equals(weaklyshow.display_fiveclick())) {
			weaklyshow.fifth_click_plus();
		} else if (object.equals(weaklyshow.display_sixclick())) {
			weaklyshow.six_click_plus();
		} else if (object.equals(weaklyshow.display_sevenclick())) {
			weaklyshow.seven_click_plus();
		} else if (object.equals(weaklyshow.display_minusfirstClick())) {
			weaklyshow.first_click_minus();
		} else if (object.equals(weaklyshow.display_minussecondClick())) {
			weaklyshow.second_click_minus();
		} else if (object.equals(weaklyshow.display_minusthirdClick())) {
			weaklyshow.third_click_minus();
		} else if (object.equals(weaklyshow.display_minusforthClick())) {
			weaklyshow.forth_click_minus();
		} else if (object.equals(weaklyshow.display_minusfiveClick())) {
			weaklyshow.five_click_minus();
		} else if (object.equals(weaklyshow.display_minussixClick())) {
			weaklyshow.six_click_minus();
		} else if (object.equals(weaklyshow.display_minusevenClick())) {
			weaklyshow.seven_click_minus();
		}

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
