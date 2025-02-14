package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.LoginUI;
import util.Tool;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class PorderMainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDateTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderMainUI frame = new PorderMainUI("ID","Name");
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
	public PorderMainUI(String strClientID, String strClientName) {
		setResizable(false);
		this.setTitle("鉅強企業 - 網購事業");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Point pointUILocation=(Point)Tool.read(Tool.filenameUILocation());
		setLocation(pointUILocation);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBannerTop = new JPanel();
		panelBannerTop.setLayout(null);
		panelBannerTop.setForeground(Color.WHITE);
		panelBannerTop.setBackground(Color.RED);
		panelBannerTop.setBounds(0, 0, 786, 28);
		contentPane.add(panelBannerTop);
		
		JLabel lblLoginNameBanner = new JLabel("<dynamic>");
		lblLoginNameBanner.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoginNameBanner.setForeground(Color.WHITE);
		lblLoginNameBanner.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblLoginNameBanner.setBounds(662, 0, 120, 25);
		panelBannerTop.add(lblLoginNameBanner);
		
		JLabel lblBannerCenter = new JLabel("訂單首頁");
		lblBannerCenter.setHorizontalAlignment(SwingConstants.CENTER);
		lblBannerCenter.setForeground(Color.WHITE);
		lblBannerCenter.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblBannerCenter.setBounds(334, 0, 115, 28);
		panelBannerTop.add(lblBannerCenter);
		
		JPanel panelBannerBottom = new JPanel();
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
		
		JPanel panelContents = new JPanel();
		panelContents.setBounds(2, 28, 782, 507);
		contentPane.add(panelContents);
		panelContents.setLayout(null);
		
		JLabel lblClientName = new JLabel("使用者");
		lblClientName.setBounds(338, 132, 93, 31);
		panelContents.add(lblClientName);
		lblClientName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		lblClientName.setText(strClientName);
		
		JButton btnOrderAdd = new JButton("新增訂單");
		btnOrderAdd.setBounds(326, 179, 127, 23);
		panelContents.add(btnOrderAdd);
		btnOrderAdd.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JButton btnOrderManage = new JButton("訂單管理");
		btnOrderManage.setBounds(326, 223, 127, 23);
		panelContents.add(btnOrderManage);
		btnOrderManage.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JButton btnBack = new JButton("回登入頁");
		btnBack.setBounds(326, 264, 127, 23);
		panelContents.add(btnBack);
		btnBack.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		//共同設定=開始==============================================
		//右上角的使用者姓名-----------------------------------------
		lblLoginNameBanner.setText(strClientName);
				
		//設定對話框------------------------------------------------
		JFrame jFrameDialog = new JFrame();

		//右下角的時鐘----------------------------------------------
		startClock();
				
		//視窗關閉時儲存視窗位置-------------------------------------
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
			}
		});
		//共同設定=結束==============================================
		
		btnOrderAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddPorderUI addporder=new AddPorderUI(strClientID,strClientName);
				addporder.setVisible(true);
				dispose();
			}
		});
		
		btnOrderManage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PorderManagerUI pordermanager=new PorderManagerUI(strClientID,strClientName);
				pordermanager.setVisible(true);
				dispose();
			}
		});

		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI login=new LoginUI(strClientID,strClientName);
				login.setVisible(true);
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
