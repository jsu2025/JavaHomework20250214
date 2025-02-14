package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GettingStartedUI;
import controller.porder.ForeignExchangeUI;
import controller.porder.PorderMainUI;
import model.Member;
import util.Tool;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class LoginSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDateTime;
	//private static Member member=(Member)Tool.read("member.txt");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccessUI frame = new LoginSuccessUI("ID","Name");
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
	public LoginSuccessUI(String strClientID, String strClientName) {
		setResizable(false);
		this.setTitle("鉅強企業 - 登入成功");
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
		
		JLabel lblBannerCenter = new JLabel("鉅強企業");
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
		
		JButton btnShoping = new JButton("購物系統");
		btnShoping.setBounds(330, 207, 132, 28);
		panelContents.add(btnShoping);
		btnShoping.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JLabel lblShowMember = new JLabel("New label");
		lblShowMember.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowMember.setBounds(303, 110, 173, 34);
		panelContents.add(lblShowMember);
		lblShowMember.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblShowMember.setText("["+strClientName+"]"+"  歡迎您!");
		
		JButton btnClientDataModify = new JButton("個資修改");
		btnClientDataModify.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnClientDataModify.setBounds(330, 169, 132, 28);
		panelContents.add(btnClientDataModify);
		
		JButton btnBacktoStart = new JButton("回首頁");
		btnBacktoStart.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnBacktoStart.setBounds(687, 474, 85, 23);
		panelContents.add(btnBacktoStart);
		
		JButton btnForeignExchange = new JButton("外匯系統");
		btnForeignExchange.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnForeignExchange.setBounds(330, 245, 132, 28);
		panelContents.add(btnForeignExchange);
		
		JButton btnStocks = new JButton("股票系統");
		btnStocks.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnStocks.setBounds(330, 321, 132, 28);
		panelContents.add(btnStocks);
		
		JButton btnBanking = new JButton("儲匯系統");
		btnBanking.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnBanking.setBounds(330, 283, 132, 28);
		panelContents.add(btnBanking);
		
		JLabel lblShopingMsg = new JLabel("");
		lblShopingMsg.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblShopingMsg.setBounds(482, 214, 70, 15);
		panelContents.add(lblShopingMsg);
		
		JLabel lblForeignExchangeMsg = new JLabel("");
		lblForeignExchangeMsg.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblForeignExchangeMsg.setBounds(482, 252, 70, 15);
		panelContents.add(lblForeignExchangeMsg);
		
		JLabel lblBankingMsg = new JLabel("");
		lblBankingMsg.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblBankingMsg.setBounds(482, 290, 70, 15);
		panelContents.add(lblBankingMsg);
		
		JLabel lblStocksMsg = new JLabel("");
		lblStocksMsg.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblStocksMsg.setBounds(482, 328, 70, 15);
		panelContents.add(lblStocksMsg);
		
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
		
		btnBacktoStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				GettingStartedUI ui=new GettingStartedUI();
				ui.setVisible(true);
				dispose();
			}
		});
		
		btnShoping.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				PorderMainUI pordermain=new PorderMainUI(strClientID,strClientName);
				pordermain.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblShopingMsg.setText("尚未完成");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblShopingMsg.setText("");
			}
		});
		
		btnClientDataModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				RegiModiUI ui=new RegiModiUI(strClientID,strClientName);
				ui.setVisible(true);
				dispose();
			}
		});
		
		btnForeignExchange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				ForeignExchangeUI ui=new ForeignExchangeUI(strClientID,strClientName);
				ui.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblForeignExchangeMsg.setText("尚未完成");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblForeignExchangeMsg.setText("");
			}
		});
		btnBanking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBankingMsg.setText("尚未開工");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBankingMsg.setText("");
			}
		});
		btnStocks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblStocksMsg.setText("尚未開工");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblStocksMsg.setText("");
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
