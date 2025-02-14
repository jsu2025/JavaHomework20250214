package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
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

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLcd;
	private JTextField textFieldRam;
	private JTextField textFieldMouse;
	private JLabel lblDateTime;

	//private static Member member=(Member)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI("ClientID","ClientName");
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
	public AddPorderUI(String strClientID, String strClientName) {
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
		
		JLabel lblBannerCenter = new JLabel("商品訂購");
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
		
		JButton btnBackMain = new JButton("回主頁");
		btnBackMain.setBounds(368, 259, 96, 23);
		panelContents.add(btnBackMain);
		btnBackMain.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JButton btnConfirm = new JButton("確認");
		btnConfirm.setBounds(284, 259, 81, 23);
		panelContents.add(btnConfirm);
		btnConfirm.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JLabel lblMouse = new JLabel("Mouse");
		lblMouse.setBounds(284, 227, 58, 15);
		panelContents.add(lblMouse);
		lblMouse.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		textFieldMouse = new JTextField();
		textFieldMouse.setBounds(368, 228, 96, 21);
		panelContents.add(textFieldMouse);
		textFieldMouse.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldMouse.setColumns(10);
		
		textFieldRam = new JTextField();
		textFieldRam.setBounds(368, 199, 96, 21);
		panelContents.add(textFieldRam);
		textFieldRam.setFont(new Font("新細明體", Font.BOLD | Font.ITALIC, 16));
		textFieldRam.setColumns(10);
		
		JLabel lblRam = new JLabel("RAM");
		lblRam.setBounds(284, 202, 46, 15);
		panelContents.add(lblRam);
		lblRam.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JLabel lblLcd = new JLabel("LCD");
		lblLcd.setBounds(284, 177, 46, 15);
		panelContents.add(lblLcd);
		lblLcd.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		textFieldLcd = new JTextField();
		textFieldLcd.setBounds(368, 174, 96, 21);
		panelContents.add(textFieldLcd);
		textFieldLcd.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldLcd.setColumns(10);
		
		JLabel lblLoginName = new JLabel("Login Name");
		lblLoginName.setBounds(368, 141, 96, 15);
		panelContents.add(lblLoginName);
		lblLoginName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblLoginName.setText(strClientName.toString());
		
		JLabel lblName = new JLabel("姓名:");
		lblName.setBounds(284, 141, 46, 15);
		panelContents.add(lblName);
		lblName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JLabel lblAddOrder = new JLabel("新增訂單");
		lblAddOrder.setBounds(284, 101, 190, 30);
		panelContents.add(lblAddOrder);
		lblAddOrder.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
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
		
		
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//String Name=member.getName();
				String Name=strClientName;
				int Lcd=Integer.parseInt(textFieldLcd.getText());
				int Ram=Integer.parseInt(textFieldRam.getText());
				int Mouse=Integer.parseInt(textFieldMouse.getText());
				
				Porder p=new Porder(Name,Lcd,Ram,Mouse);
				
				porderserviceimpl.addPorder(p);
				
			}
		});
		
		btnBackMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				PorderMainUI pordermain=new PorderMainUI(strClientID, strClientName);
				pordermain.setVisible(true);
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
