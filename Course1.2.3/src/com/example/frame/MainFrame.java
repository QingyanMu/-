package com.example.frame;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.example.util.DBConnection;
import com.example.util.DBInit;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenu jMenu_start = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu_backstage  = null;
	private JMenu jMenu_ccourse = null;
	private JMenu jMenu_mark = null;
	private JMenu jMenu_help = null;
	private JMenuItem jMenuItem_relogin = null;
	public JMenuItem jMenuItem_initDB = null;
	private JMenuItem jMenuItem_change_password = null;
	public JMenuItem jMenuItem_user_manage = null;
	private JMenuItem jMenuItem_hang_system = null;
	private JMenuItem jMenuItem_exit = null;
	private JMenuItem jMenuItem_student_manage = null;
	private JMenuItem jMenuItem_teacher_manage = null;
	private JMenuItem jMenuItem_course_manage = null;
	private JMenuItem jMenuItem_grade_class = null;
	private JMenuItem jMenuItem_class = null;
	private JMenuItem jMenuItem_about = null;
	private JMenuItem jMenuItem_online_update = null;
	
	
	private JMenuItem jMenuItem_sys_info = null;
	public JMenuItem jMenuItem_operate_log = null;
	private JMenuItem jMenuItem_ccourse = null;
	private JMenuItem jMenuItem_ccourse_add = null;
	private JMenuItem jMenuItem_mark_add = null;
	private JMenuItem jMenuItem_mark_statistics = null;
	private JLabel jLabel = null;
	private URL imgURL = null;
	private SystemTray sysTray = SystemTray.getSystemTray();
	
	Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/example/images/icon.png"));
	private TrayIcon trayicon = new TrayIcon(image, "????????????", createMenu());

	public MainFrame() {
		super();
		initialize();
		initPrivilege();
	}

	private void initialize() {		
		this.setSize(800, 544);// ??????????
		this.setTitle("???????????????? V1.2");
		imgURL = this.getClass().getResource("/com/example/images/icon.png");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(imgURL));
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		
		this.addWindowListener(new WindowAdapter()// ????????????
		{
			public void windowClosing(WindowEvent e) {
				SystemTrayInitial();//??????????????
			}
		});

		jMenuItem_relogin = new JMenuItem();
		jMenuItem_relogin.setText("????????");
		jMenuItem_operate_log = new JMenuItem();
		jMenuItem_operate_log.setText("????????");
		jMenuItem_change_password = new JMenuItem();
		jMenuItem_change_password.setText("????????");
		jMenuItem_user_manage = new JMenuItem();
		jMenuItem_user_manage.setText("????????");
		jMenuItem_initDB = new JMenuItem();
		jMenuItem_initDB.setText("????????????");
		jMenuItem_hang_system = new JMenuItem();
		jMenuItem_hang_system.setText("????");
		jMenuItem_exit = new JMenuItem();
		jMenuItem_exit.setText("????");
		jMenuItem_student_manage = new JMenuItem();
		jMenuItem_student_manage.setText("????????????");
		jMenuItem_teacher_manage = new JMenuItem();
		jMenuItem_teacher_manage.setText("????????????");
		jMenuItem_course_manage = new JMenuItem();
		jMenuItem_course_manage.setText("????????????");
		jMenuItem_grade_class = new JMenuItem();
		jMenuItem_grade_class.setText("????????????");
		jMenuItem_class = new JMenuItem();
		jMenuItem_class.setText("????????????");
		jMenuItem_ccourse_add = new JMenuItem();
		jMenuItem_ccourse_add.setText("????????");
		jMenuItem_ccourse = new JMenuItem();
		jMenuItem_ccourse.setText("????????");
		
		jMenuItem_mark_add = new JMenuItem();
		jMenuItem_mark_add.setText("????????");
		jMenuItem_mark_statistics = new JMenuItem();
		jMenuItem_mark_statistics.setText("????????");
		
		
		
		jMenuItem_about = new JMenuItem();
		jMenuItem_about.setText("????????");
		jMenuItem_sys_info = new JMenuItem();
		jMenuItem_sys_info.setText("????????");
		
		jMenuItem_online_update = new JMenuItem();
		jMenuItem_online_update.setText("????????");
		
		
		jMenu_start = new JMenu();
		jMenu_start.setText("????????");
		jMenu_start.add(jMenuItem_relogin);
		jMenu_start.add(jMenuItem_change_password);
		jMenu_start.add(jMenuItem_user_manage);
		jMenu_start.add(jMenuItem_operate_log);
		jMenu_start.add(jMenuItem_initDB);
		jMenu_start.addSeparator();// ??????
		//jMenu_start.add(jMenuItem_hang_system);
		jMenu_start.add(jMenuItem_exit);
		jMenu_backstage  = new JMenu();
		jMenu_backstage .setText("????????");
		jMenu_backstage .add(jMenuItem_student_manage);
		jMenu_backstage .add(jMenuItem_teacher_manage);
		jMenu_backstage .add(jMenuItem_course_manage);
		jMenu_backstage .add(jMenuItem_grade_class);
		jMenu_backstage .add(jMenuItem_class);
		jMenu_ccourse = new JMenu();
		jMenu_ccourse.setText("????????");
		jMenu_ccourse.add(jMenuItem_ccourse_add);
		jMenu_ccourse.add(jMenuItem_ccourse);
		
		jMenu_mark = new JMenu();
		jMenu_mark.setText("????????");
		jMenu_mark.add(jMenuItem_mark_add);
		jMenu_mark.add(jMenuItem_mark_statistics);
		
		
		jMenu_help = new JMenu();
		jMenu_help.setText("????");
		jMenu_help.add(jMenuItem_about);
		jMenu_help.add(jMenuItem_sys_info);
		//jMenu_help.add(jMenuItem_online_update);
		jJMenuBar = new JMenuBar();
		jJMenuBar.setPreferredSize(new Dimension(10, 25));
		jJMenuBar.add(jMenu_start);
		jJMenuBar.add(jMenu_backstage );
		jJMenuBar.add(jMenu_ccourse);
		jJMenuBar.add(jMenu_mark);
		
		jJMenuBar.add(jMenu_help);
		
		setJMenuBar(jJMenuBar);

		jLabel = new JLabel();
		jLabel.setText("JLabel");
		jLabel.setBounds(new Rectangle(1, -2, 800, 544));
		imgURL = this.getClass().getResource("/com/example/images/main.jpg");
		jLabel.setIcon(new ImageIcon(imgURL));

		jContentPane = new JPanel();
		jContentPane.setLayout(null);
		jContentPane.add(jLabel, null);
		setContentPane(jContentPane);
		
		btnListener btn = new btnListener();
		jMenuItem_relogin.addActionListener(btn);
		jMenuItem_change_password.addActionListener(btn);
		jMenuItem_user_manage.addActionListener(btn);
		jMenuItem_initDB.addActionListener(btn);
		jMenuItem_operate_log.addActionListener(btn);
		jMenuItem_hang_system.addActionListener(btn);
		jMenuItem_exit.addActionListener(btn);
		jMenuItem_student_manage.addActionListener(btn);
		jMenuItem_teacher_manage.addActionListener(btn);
		jMenuItem_course_manage.addActionListener(btn);
		jMenuItem_grade_class.addActionListener(btn);
		jMenuItem_class.addActionListener(btn);
		jMenuItem_ccourse_add.addActionListener(btn);
		jMenuItem_about.addActionListener(btn);
		jMenuItem_mark_add.addActionListener(btn);
		jMenuItem_mark_statistics.addActionListener(btn);
		jMenuItem_ccourse.addActionListener(btn);
		jMenuItem_sys_info.addActionListener(btn);
		
	}
/**
 * @??????????
 */
	private void SystemTrayInitial() { // ????
		if (!SystemTray.isSupported()) // ??????????????????????????
			return;
				try {
					sysTray.add(trayicon);
				} catch (AWTException e1) {
					e1.printStackTrace();
				}
				setVisible(false);
				trayicon.displayMessage("????????????", "????????????\n", MessageType.INFO);// ??????????????????????????
			trayicon.addActionListener(new ActionListener()// ????????????????
					{
						public void actionPerformed(ActionEvent e) {
							sysTray.remove(trayicon);
							setVisible(true);
						}
					});
	}
/**
 * @??????????????
 * @return
 */
	private PopupMenu createMenu() { // ????????????????????
		PopupMenu menu = new PopupMenu();
		MenuItem exitItem = new MenuItem("??????????");
		exitItem.addActionListener(new ActionListener() { // ??????????????
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
		MenuItem openItem = new MenuItem("??????????");
		openItem.addActionListener(new ActionListener() {// ????????????????????
					public void actionPerformed(ActionEvent e) {
						if (!isVisible()) {
							setVisible(true);
							sysTray.remove(trayicon);
						}
					}
				});
		
		MenuItem viewItem = new MenuItem("");
		viewItem.addActionListener(new ActionListener() {// ????????????????????
					public void actionPerformed(ActionEvent e) {
						try {
							Runtime.getRuntime().exec("");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				});
		
		
		menu.add(openItem);
		menu.add(viewItem);
		menu.addSeparator();
		menu.add(exitItem);
		return menu;
	}

	public void initPrivilege(){
		if(Login.login_user_type==1){
			jMenuItem_change_password.setEnabled(false);
			jMenuItem_operate_log.setEnabled(false);
			jMenuItem_initDB.setEnabled(false);
			jMenuItem_user_manage.setEnabled(false);
			jMenu_backstage.setEnabled(false);
			
		}else if(Login.login_user_type==0){			
		}else if(Login.login_user_type==2){
			
			jMenuItem_change_password.setEnabled(false);
			jMenuItem_operate_log.setEnabled(false);
			jMenuItem_initDB.setEnabled(false);
			jMenuItem_user_manage.setEnabled(false);
			jMenuItem_sys_info.setEnabled(false);
					
			jMenu_mark.setEnabled(false);
			jMenu_backstage .setEnabled(false);
			
		}else{
			jMenuItem_change_password.setEnabled(false);
			jMenuItem_operate_log.setEnabled(false);
			jMenuItem_initDB.setEnabled(false);
			jMenuItem_user_manage.setEnabled(false);
			jMenuItem_sys_info.setEnabled(false);
					
			jMenu_mark.setEnabled(false);
			jMenu_backstage .setEnabled(false);
			
		}
		
	}

	public class btnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == jMenuItem_relogin) {
				dispose();
				Login login = new Login();// ????????????????????????????????????
				login.setVisible(true);
			} else if (e.getSource() == jMenuItem_change_password) {
				if(Login.login_user_type!=0)
					{JOptionPane.showMessageDialog(null, "????????????????????????????????????????");
					return;
					}
			
				UserChangePassword cp = new UserChangePassword();
				cp.setVisible(true);
			} else if (e.getSource() == jMenuItem_user_manage) {
			
				UserManage um = new UserManage();
				um.setVisible(true);
			} else if (e.getSource() == jMenuItem_operate_log) {
				LogManage lm = new LogManage();
				lm.setVisible(true);
			} else if (e.getSource() == jMenuItem_hang_system) {
				DBConnection.update(Login.storeUserName + "   ??????????????");
				JOptionPane.showMessageDialog(null, "??????????????????????");
			} else if (e.getSource() == jMenuItem_initDB) {

		
				DBInit di = new DBInit();
				di.setVisible(true);
			} else if (e.getSource() == jMenuItem_exit) {

				System.exit(0);
			} else if (e.getSource() == jMenuItem_student_manage) {
				StudentManage sm = new StudentManage();
				sm.setVisible(true);
			} else if (e.getSource() == jMenuItem_teacher_manage) {
		
				TeacherManage tm = new TeacherManage();
				tm.setVisible(true);
			}else if (e.getSource() == jMenuItem_grade_class) {
				//JOptionPane.showMessageDialog(null, "??????????...??????????");
				GradeManage gm = new GradeManage();
				gm.setVisible(true);
			} else if(e.getSource() == jMenuItem_class){
				ClassManage cm= new ClassManage();
				cm.setVisible(true);
				//JOptionPane.showMessageDialog(null, "??????????...??????????");
			}else if (e.getSource() == jMenuItem_course_manage) {
			
				CourseManage cm = new CourseManage();
				cm.setVisible(true);
			} else if (e.getSource() == jMenuItem_ccourse_add) {
			
				CCourseAdd cm = new CCourseAdd();
				cm.setVisible(true);
			} else if (e.getSource() == jMenuItem_ccourse) {
				CCourseManage cci = new CCourseManage();
				cci.setVisible(true);
			}else if (e.getSource() == jMenuItem_mark_add) {
				
				CCourseMarkAdd ccma = new CCourseMarkAdd();
				ccma.setVisible(true);

				
				
			}else if (e.getSource() == jMenuItem_mark_statistics) {
				CCourseMarkStatistic ccs = new CCourseMarkStatistic();
				ccs.setVisible(true);
			} 
			else if (e.getSource() == jMenuItem_about) {
				About ab = new About();
				ab.setVisible(true);
			} else if (e.getSource() == jMenuItem_sys_info) {
				try {
					String fp = System.getProperty("user.dir") + "\\readme.txt";
					File f = new File(fp);
					if (f.exists()) {
						Runtime.getRuntime().exec(" notepad.exe " + fp);
					} else {
						JOptionPane.showMessageDialog(null,null);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		}

	}
	
	
	public static void main(String[] args) {
		MainFrame login = new MainFrame();
		login.setVisible(true);
	}

}
