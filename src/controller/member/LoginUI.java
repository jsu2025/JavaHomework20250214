package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GettingStartedUI;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowFocusListener;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;



public class LoginUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLoginID;
	private JTextField textFieldPassword;
	private JPanel panelBannerTop;
	private JLabel lblLoginNameBanner;
	private JLabel lblBannerCenter;
	private JPanel panelBannerBottom;
	private JLabel lblDateTime;
	private JPanel panelContents;
	private JButton btnBacktoStart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI("ID","Name");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUI(String strClientID, String strClientName) {
		setResizable(false);
		this.setTitle("鉅強企業 - 登入");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		if (Tool.read(Tool.filenameUILocation())!=null)
		{
			Point pointUILocation=(Point)Tool.read(Tool.filenameUILocation());
			setLocation(pointUILocation);
		}		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelBannerTop = new JPanel();
		panelBannerTop.setForeground(new Color(255, 255, 255));
		panelBannerTop.setBackground(new Color(255, 0, 0));
		panelBannerTop.setLayout(null);
		panelBannerTop.setBounds(0, 0, 786, 28);
		contentPane.add(panelBannerTop);
		
		lblLoginNameBanner = new JLabel("使用者姓名");
		lblLoginNameBanner.setForeground(new Color(255, 255, 255));
		lblLoginNameBanner.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoginNameBanner.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblLoginNameBanner.setBounds(662, 0, 120, 25);
		panelBannerTop.add(lblLoginNameBanner);
		
		lblBannerCenter = new JLabel("鉅強企業");
		lblBannerCenter.setForeground(new Color(255, 255, 255));
		lblBannerCenter.setHorizontalAlignment(SwingConstants.CENTER);
		lblBannerCenter.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblBannerCenter.setBounds(334, 0, 115, 28);
		panelBannerTop.add(lblBannerCenter);
		
		panelBannerBottom = new JPanel();
		panelBannerBottom.setLayout(null);
		panelBannerBottom.setBackground(Color.RED);
		panelBannerBottom.setBounds(0, 535, 786, 28);
		contentPane.add(panelBannerBottom);
		
		lblDateTime = new JLabel("日期與時間");
		lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateTime.setForeground(Color.WHITE);
		lblDateTime.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblDateTime.setBounds(662, 0, 120, 28);
		panelBannerBottom.add(lblDateTime);
		
		panelContents = new JPanel();
		panelContents.setBounds(2, 28, 782, 507);
		contentPane.add(panelContents);
		panelContents.setLayout(null);
		
		JLabel lblLoginID = new JLabel("帳號:");
		lblLoginID.setBounds(296, 148, 54, 25);
		panelContents.add(lblLoginID);
		lblLoginID.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		textFieldLoginID = new JTextField();
		textFieldLoginID.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldLoginID.setBounds(353, 147, 105, 28);
		panelContents.add(textFieldLoginID);
		textFieldLoginID.setColumns(10);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldPassword.setBounds(353, 202, 105, 28);
		panelContents.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblPassword = new JLabel("密碼:");
		lblPassword.setBounds(296, 202, 54, 27);
		panelContents.add(lblPassword);
		lblPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JButton btnLogin = new JButton("登入");
		btnLogin.setBounds(353, 271, 85, 28);
		panelContents.add(btnLogin);
		btnLogin.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		btnBacktoStart = new JButton("回首頁");
		btnBacktoStart.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnBacktoStart.setBounds(687, 474, 85, 23);
		panelContents.add(btnBacktoStart);
		
		JButton btnForgetPwd = new JButton("忘記密碼");
		btnForgetPwd.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnForgetPwd.setBounds(572, 474, 105, 23);
		panelContents.add(btnForgetPwd);

		//設定對話框------------------------------------------------
		JFrame jFrameDialog = new JFrame();
		
		//==========================================================

		startClock();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
			}
		});
	
		//---------------------------------------------------------
		
		//返回首頁-------------------------------------------------
		btnBacktoStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				GettingStartedUI ui=new GettingStartedUI();
				ui.setVisible(true);
				dispose();
			}
		});
		
		btnForgetPwd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    JOptionPane.showMessageDialog(jFrameDialog, "請聯繫您的專員");
			}
		});
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				String strClientID=textFieldLoginID.getText();
				String strClientPassword=textFieldPassword.getText();
				Member member=new MemberServiceImpl().Login(strClientID, strClientPassword);
				if(member!=null)
				{
					//Tool.save(member, "member.txt");
					String strClientName=member.getClientName();
					System.out.println("strClientName: "+strClientName);
					LoginSuccessUI loginsuccess=new LoginSuccessUI(strClientID,strClientName);
					loginsuccess.setVisible(true);
				}
				else
				{
					LoginErrorUI loginerror=new LoginErrorUI(strClientID,strClientName);
					loginerror.setVisible(true);
				}

				dispose();
			}
		});
	}
	
	/**
	 * 副程式
	 */
	
	private void startClock() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 更新時鐘顯示
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD HH:mm:ss");
                String currentTime = sdf.format(new Date());
                lblDateTime.setText(currentTime);
            }
        });
        timer.start(); // 啟動時鐘計時器
    }
}
