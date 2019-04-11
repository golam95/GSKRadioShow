package com.radio.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import com.radio.model.SettingMenu;

@SuppressWarnings("unused")
public class Home_Radio extends JFrame implements MouseListener, ActionListener {

	/**
	 * @author Golam Nobi
	 */
	private static final long serialVersionUID = 1L;

	static Date td = new Date();

	JDesktopPane desktop = new JDesktopPane();
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screen = kit.getScreenSize();
	private int screenheith = screen.height;
	private int screedwidth = screen.width;
	JMenuBar menubar = new JMenuBar();
	JMenu menuFile = new JMenu("File");
	JMenu menuHelp = new JMenu("Help");
	private JMenuItem item_addhelp = new JMenuItem();
	private JMenuItem item_addInsruction = new JMenuItem();
	private JMenuItem item_home = new JMenuItem();
	private JMenuItem item_exit = new JMenuItem();
	SettingMenu settings = new SettingMenu();
	String sMSGBOX_TITLE = "GSR Radio Show Application";
	private static final int SCREEN_WIDTH = 1100;
	private static final int SCREEN_HEIGHT = 620;
	private JPanel pan_top = new JPanel();
	private JPanel pan_bottom = new JPanel();
	// prpperties
	private static JLabel lbl_title = new JLabel("G S R   R A D I O   S H O W");
	private JButton btn_exit = new JButton("Exit");
	private JButton btn_viewallshow = new JButton(new ImageIcon("images/view.png"));
	private JButton btn_viewschedult = new JButton(new ImageIcon("images/routine.png"));
	private JButton btn_addshow = new JButton(new ImageIcon("images/add.png"));
	private JButton btn_statices = new JButton(new ImageIcon("images/barchart.png"));
	private JButton btn_weaklyroutine = new JButton(new ImageIcon("images/r.png"));
	private static JPanel pan_bottomcontainer = new JPanel();
	// panel
	// public static JPanel pan_mainbody = new JPanel();
	Border thickBorder = new LineBorder(Color.decode("#44619D"), 20);
	Border thickBorder1 = new LineBorder(Color.decode("#394B58"), 12);
	Border thickBorderwhite = new LineBorder(Color.decode("#EC971F"), 18);
	Border thickBorderanother = new LineBorder(Color.decode("#C9302C"), 6);

	Border thickBorder_under = new LineBorder(Color.decode("#356B9A"), 17);

	Font font = new Font("Verdana", Font.BOLD, 30);
	Font font1 = new Font("Verdana", Font.BOLD, 16);
	Font font2 = new Font("Verdana", Font.BOLD, 20);
	Font font3 = new Font("Verdana", Font.BOLD, 100);

	private static JPanel pan_calender = new JPanel();
	private static JPanel pan_leftdesktop = new JPanel();
	private static JPanel pan_addtitle = new JPanel(new FlowLayout());

	private viewall_RadioShow viewall_show;
	private viewScheduleList view_schedule;
	private statices stat_show;
	private weaklyshow weakly_show;
	private addShow add_show;

	// prpperties
	public Home_Radio() {
		super("GSK Radio Show");
		create_Gui();

	}

	@SuppressWarnings("deprecation")
	protected void create_Gui() {
		try {
			this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
			this.setLocation(screenheith / 4, screedwidth / 16);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					UnloadWindow();
				}
			});
			this.setResizable(false);
			this.setJMenuBar(CreateJMenuBar());
			// this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			this.setJMenuBar(CreateJMenuBar());
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			pan_addtitle.setBounds(220, 10, 690, 60);
			pan_addtitle.add(lbl_title);
			lbl_title.setFont(font);
			lbl_title.setForeground(Color.decode("#AC1616"));
			desktop.add(pan_addtitle);

			btn_addshow.setBounds(20, 40, 105, 90);
			btn_viewallshow.setBounds(20, 160, 105, 90);
			btn_viewschedult.setBounds(20, 280, 105, 90);

			btn_exit.setBounds(20, 440, 105, 90);

			pan_bottomcontainer.add(btn_weaklyroutine);
			pan_bottomcontainer.add(btn_statices);
			pan_bottomcontainer.setBounds(367, 420, 450, 110);
			pan_bottomcontainer.setLayout(new GridLayout(0, 2));

			Date dNow = new Date();
			SimpleDateFormat ft = new SimpleDateFormat("E");
			SimpleDateFormat g = new SimpleDateFormat("dd");
			SimpleDateFormat st = new SimpleDateFormat("MM");
			SimpleDateFormat year = new SimpleDateFormat("yyyy");

			JLabel lbl_dayname = new JLabel(ft.format(dNow));
			JLabel lbl_day = new JLabel(g.format(dNow));
			JLabel lbl_monthname_year = new JLabel(st.format(dNow) + " , " + year.format(dNow));

			lbl_dayname.setBounds(180, 20, 300, 30);
			lbl_day.setBounds(140, 60, 300, 110);
			lbl_monthname_year.setBounds(170, 180, 300, 30);

			lbl_dayname.setForeground(Color.WHITE);
			lbl_day.setForeground(Color.WHITE);
			lbl_monthname_year.setForeground(Color.WHITE);

			lbl_dayname.setFont(font2);
			lbl_day.setFont(font3);
			lbl_monthname_year.setFont(font2);

			pan_calender.setBounds(390, 130, 400, 250);
			pan_calender.add(lbl_dayname);
			pan_calender.add(lbl_day);
			pan_calender.add(lbl_monthname_year);

			btn_addshow.setBackground(Color.decode("#250800"));
			btn_viewallshow.setBackground(Color.decode("#250800"));
			btn_viewschedult.setBackground(Color.decode("#250800"));
			// desktop.setBackground(Color.decode("#D4DBEE"));
			btn_statices.setBackground(Color.decode("#250800"));
			btn_weaklyroutine.setBackground(Color.decode("#250800"));
			btn_exit.setBackground(Color.decode("#250800"));

			btn_addshow.setBorder(thickBorder1);
			btn_viewallshow.setBorder(thickBorder1);
			btn_viewschedult.setBorder(thickBorder1);

			btn_statices.setBorder(thickBorder_under);
			btn_weaklyroutine.setBorder(thickBorder_under);

			btn_exit.setBorder(thickBorder1);

			btn_statices.setFont(font1);
			btn_addshow.setFont(font1);
			btn_exit.setFont(font1);
			btn_viewallshow.setFont(font1);
			btn_viewschedult.setFont(font1);
			btn_weaklyroutine.setFont(font1);

			btn_addshow.setForeground(Color.white);
			btn_viewallshow.setForeground(Color.white);
			btn_viewschedult.setForeground(Color.white);
			btn_statices.setForeground(Color.white);
			btn_weaklyroutine.setForeground(Color.white);

			btn_exit.setForeground(Color.white);

			pan_calender.setBorder(thickBorderwhite);
			pan_calender.setBackground(Color.decode("#D14A00"));
			pan_calender.setLayout(null);

			pan_leftdesktop.setBounds(0, 0, 150, 553);
			pan_leftdesktop.setLayout(null);
			// pan_leftdesktop.setBackground(Color.gray);
			pan_leftdesktop.setBackground(Color.decode("#D2DDF1"));

			desktop.add(pan_calender);

			pan_leftdesktop.add(btn_addshow);
			pan_leftdesktop.add(btn_viewallshow);
			pan_leftdesktop.add(btn_viewschedult);
			pan_leftdesktop.add(btn_exit);

			desktop.add(pan_bottomcontainer);

			desktop.add(pan_leftdesktop);
			//

			btn_addshow.addActionListener(this);
			btn_statices.addActionListener(this);
			btn_viewallshow.addActionListener(this);
			btn_viewschedult.addActionListener(this);
			btn_weaklyroutine.addActionListener(this);
			btn_exit.addActionListener(this);
			// anotherpan_mainbody

			item_home.addActionListener(this);
			item_exit.addActionListener(this);
			item_addhelp.addActionListener(this);
			item_addInsruction.addActionListener(this);

			// another

			// this.add(pan_mainbody);

			desktop.setBorder(BorderFactory.createLoweredBevelBorder());
			desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

			btn_addshow.addMouseListener(this);
			btn_viewallshow.addMouseListener(this);
			btn_viewschedult.addMouseListener(this);
			btn_statices.addMouseListener(this);
			btn_weaklyroutine.addMouseListener(this);

			this.getContentPane().add(pan_top, BorderLayout.PAGE_START);
			this.getContentPane().add(desktop, BorderLayout.CENTER);
			this.getContentPane().add(pan_bottom, BorderLayout.PAGE_END);
			this.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error create Gui static class" + ex.toString());

		}
	}

	protected void UnloadWindow() {
		try {
			int reply = JOptionPane.showConfirmDialog(this, "Are you sure to exit?", sMSGBOX_TITLE,
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (reply == JOptionPane.YES_OPTION) {
				setVisible(false);
				System.exit(0);
			}
		} catch (Exception e) {
		}

	}// Close the Windows

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			Home_Radio radio = new Home_Radio();
		} catch (Exception ex1) {
			JOptionPane.showMessageDialog(null, "Error the main gui" + ex1.toString());

		}

	}

	protected JMenuBar CreateJMenuBar() {
		try {
			menuFile.addSeparator();
			menuFile.add(settings.setJMenuItem(item_home, "Mainmenu", "images/saddd.png"));
			item_home.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));
			menuFile.addSeparator();
			menuFile.add(settings.setJMenuItem(item_exit, "Exit", "images/Exit.png"));
			item_exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
			item_exit.setMnemonic((int) 'F');
			menuHelp.add(settings.setJMenuItem(item_addhelp, "About", "images/about.png"));
			item_addhelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
			menuHelp.addSeparator();
			menuHelp.add(settings.setJMenuItem(item_addInsruction, "Instruction", "images/help.png"));
			item_addInsruction.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, Event.CTRL_MASK));
			menuHelp.setMnemonic((int) 'H');
			menubar.add(settings.setJMenu(menuFile));
			menubar.add(settings.setJMenu(menuHelp));
		} catch (Exception ex2) {
			JOptionPane.showMessageDialog(null, "Error the Manubar" + ex2.toString());

		}
		return menubar;

	}

	protected void loadForm(String Title, JInternalFrame clsForm) {

		boolean xForm = isLoaded(Title);
		if (xForm == false) {
			desktop.add(clsForm);
			clsForm.setVisible(true);
			clsForm.show();
		} else {
			try {
				clsForm.setIcon(false);
				clsForm.setSelected(true);

			} catch (PropertyVetoException e) {
				JOptionPane.showMessageDialog(null, "Error load Method" + e.toString());
			}
		}
	} // Complete Load Form methoded

	protected boolean isLoaded(String FormTitle) {
		JInternalFrame Form[] = desktop.getAllFrames();
		for (int i = 0; i < Form.length; i++) {
			if (Form[i].getTitle().equalsIgnoreCase(FormTitle)) {
				Form[i].show();
				try {
					Form[i].setIcon(false);
					Form[i].setSelected(true);

				} catch (PropertyVetoException e) {

				}
				return true;
			}
		}
		return false;
	}

	public static void removeall() {
		pan_calender.setVisible(false);
		lbl_title.setVisible(false);
		pan_leftdesktop.setVisible(false);
		pan_addtitle.setVisible(false);
		pan_bottomcontainer.setVisible(false);
	}

	public static void viewallhomepage() {
		pan_calender.setVisible(true);
		lbl_title.setVisible(true);
		pan_leftdesktop.setVisible(true);
		pan_addtitle.setVisible(true);
		pan_bottomcontainer.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() == btn_addshow) {
			btn_addshow.setBackground(Color.decode("#FCF8E3"));
			btn_addshow.setForeground(Color.decode("#915A48"));
		}
		if (e.getSource() == btn_viewallshow) {

			btn_viewallshow.setBackground(Color.decode("#FCF8E3"));
			btn_viewallshow.setForeground(Color.decode("#915A48"));
		}
		if (e.getSource() == btn_viewschedult) {

			btn_viewschedult.setBackground(Color.decode("#FCF8E3"));
			btn_viewschedult.setForeground(Color.decode("#915A48"));
		}
		if (e.getSource() == btn_statices) {

			btn_statices.setBackground(Color.decode("#FCF8E3"));
			btn_statices.setForeground(Color.decode("#915A48"));

		}
		if (e.getSource() == btn_weaklyroutine) {

			btn_weaklyroutine.setBackground(Color.decode("#FCF8E3"));
			btn_weaklyroutine.setForeground(Color.decode("#915A48"));

		}

	}

	@Override
	public void mouseExited(MouseEvent e) {

		if (e.getSource() == btn_addshow) {
			btn_addshow.setBackground(Color.decode("#250800"));
			btn_addshow.setForeground(Color.white);
		} else if (e.getSource() == btn_viewallshow) {

			btn_viewallshow.setBackground(Color.decode("#250800"));
			btn_viewallshow.setForeground(Color.white);

		} else if (e.getSource() == btn_viewschedult) {

			btn_viewschedult.setBackground(Color.decode("#250800"));
			btn_viewschedult.setForeground(Color.white);

		} else if (e.getSource() == btn_statices) {

			btn_statices.setBackground(Color.decode("#250800"));
			btn_statices.setForeground(Color.white);

		} else if (e.getSource() == btn_weaklyroutine) {
			btn_weaklyroutine.setBackground(Color.decode("#250800"));
			btn_weaklyroutine.setForeground(Color.white);
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent object) {
		Object source = object.getSource();
		if (source.equals(btn_exit)) {
			int i = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
			if (i == 0) {
				this.dispose();
				this.setVisible(false);
			}

		} else if (source.equals(btn_addshow)) {
			loadJInternalFrame(7);
		} else if (source.equals(btn_statices)) {
			loadJInternalFrame(3);
		} else if (source.equals(btn_viewallshow)) {
			loadJInternalFrame(1);
		} else if (source.equals(btn_viewschedult)) {
			loadJInternalFrame(2);
		} else if (source.equals(btn_weaklyroutine)) {
			loadJInternalFrame(6);

		} else if (source.equals(item_home)) {
			loadJInternalFrame(4);
		} else if (source.equals(item_exit)) {
			this.dispose();
			this.setVisible(false);
		} else if (source.equals(item_addhelp)) {
			loadJInternalFrame(5);
		} else if (source.equals(item_addInsruction)) {
			loadJInternalFrame(9);
		}
	}

	protected void loadJInternalFrame(int postion) {
		switch (postion) {
		case 1:
			try {
				removeall();
				viewall_show = new viewall_RadioShow(this);
				loadForm("View All Radio Show", viewall_show);
			} catch (Exception e) {
				System.out.println("\nError");
			}
			break;
		case 2:
			try {
				removeall();
				view_schedule = new viewScheduleList(this);
				loadForm("View Schedule", view_schedule);
			} catch (Exception e) {
				System.out.println("\nError");
			}
			break;
		case 3:
			try {
				removeall();
				stat_show = new statices(this);
				loadForm("Statices", stat_show);
			} catch (Exception e) {
				System.out.println("\nError");
			}
			break;
		case 4:
			try {
				Home_Radio.removeall();
				Home_Radio.viewallhomepage();
			} catch (Exception e) {
				System.out.println("\nError");
			}
			break;
		case 5:
			try {
				String str = "Md.Golam Nobi Sheikh";
				JOptionPane.showMessageDialog(null,
						str + "\n" + "Daffodil International University" + "\n" + "Batch:68th");
			} catch (Exception e) {
				System.out.println("\nError");
			}
			break;

		case 6:
			try {
				removeall();
				weakly_show = new weaklyshow(this);
				loadForm("weakly_show", weakly_show);
			} catch (Exception e) {

			}
			break;
		case 7:
			try {
				removeall();
				add_show = new addShow(this);
				loadForm("Add Show", add_show);
			} catch (Exception e) {

			}
			break;
		case 8:
			try {

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error Load 8" + ex.toString());
			}
			break;
		case 9:
			try {
				String str = "Instruction";
				JOptionPane.showMessageDialog(null,
						str + "\n" + "This is simple Instruction page" + "\n" + "Batch:68th");
			} catch (Exception e) {
				System.out.println("\nError");
			}
			break;

		}
	}

}
