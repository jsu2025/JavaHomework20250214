package controller;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import controller.member.LoginErrorUI;
import controller.member.LoginSuccessUI;
import controller.member.LoginUI;
import controller.member.RegiModiUI;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GettingStartedUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int intCountdownTime = 10; // 倒計時時間（秒）
	private JLabel lblDateTime;
	private JLabel lblCountDown;
	private boolean isCounting = true;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GettingStartedUI frame = new GettingStartedUI();
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
	public GettingStartedUI() {
		setResizable(false);
		setTitle("鉅強企業 - 首頁");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//getContentPane().setLayout(null);
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
		
		JPanel panelBannerTop = new JPanel();
		panelBannerTop.setBackground(new Color(255, 0, 0));
		panelBannerTop.setBounds(0, 0, 786, 28);
		contentPane.add(panelBannerTop);
		panelBannerTop.setLayout(null);
		
		JLabel lblBannerCenter = new JLabel("鉅強企業");
		lblBannerCenter.setForeground(new Color(255, 255, 255));
		lblBannerCenter.setBounds(334, 0, 115, 28);
		panelBannerTop.add(lblBannerCenter);
		lblBannerCenter.setHorizontalAlignment(SwingConstants.CENTER);
		lblBannerCenter.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JPanel panelBannerBottom = new JPanel();
		panelBannerBottom.setBackground(new Color(255, 0, 0));
		panelBannerBottom.setBounds(0, 535, 786, 28);
		contentPane.add(panelBannerBottom);
		panelBannerBottom.setLayout(null);
		
		lblDateTime = new JLabel("日期與時間");
		lblDateTime.setForeground(new Color(255, 255, 255));
		lblDateTime.setBounds(662, 0, 120, 28);
		panelBannerBottom.add(lblDateTime);
		lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateTime.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		
		JPanel panelContents = new JPanel();
		panelContents.setBounds(2, 28, 782, 507);
		contentPane.add(panelContents);
		panelContents.setLayout(null);
		
		JButton btnLogin = new JButton("客戶登入");
		btnLogin.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnLogin.setBounds(330, 180, 118, 28);
		panelContents.add(btnLogin);
		
		JButton btnRegister = new JButton("新戶註冊");
		btnRegister.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnRegister.setBounds(330, 230, 118, 28);
		panelContents.add(btnRegister);
		
		JButton btnBacktoStart = new JButton("離開");
		btnBacktoStart.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnBacktoStart.setBounds(687, 474, 85, 23);
		panelContents.add(btnBacktoStart);
		
		//==========================================================

		startClock();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
			}
		});
		
		//---------------------------------------------------------
		
		//離開-------------------------------------------------
		btnBacktoStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				System.exit(ABORT);
				//dispose();
			}
		});
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				LoginUI ui=new LoginUI("","");
				ui.setVisible(true);
				dispose();
			}
		});
		
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				RegiModiUI ui=new RegiModiUI("","");
				ui.setVisible(true);
				dispose();
			}
		});
		
	    // 啟動倒計時線程
	    //startCountdown();
	    // 啟動時鐘更新
	    

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
	
    private void startCountdown() {
        Thread countdownThread = new Thread(() -> {
            while (intCountdownTime > 0 && isCounting) {
                try {
                    Thread.sleep(1000); // 暫停 1 秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                intCountdownTime--;
                SwingUtilities.invokeLater(() -> {
                    lblCountDown.setText("倒計時: " + intCountdownTime);
                });
            }
            if (intCountdownTime == 0) {
                SwingUtilities.invokeLater(() -> {
                    lblCountDown.setText("時間到！");
                });
            }
        });
        countdownThread.start();
    }
}
