package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JScrollPane;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private JTextField textFieldEditId;
	private JTextField textFieldEditLcd;
	private JTextField textFieldEditRam;
	private JTextField textFieldEditMouse;
	private JTextField textFieldDelID;
	private JLabel lblDateTime;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerUI frame = new PorderManagerUI("ClientID","ClientName");
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
	public PorderManagerUI(String strClientID, String strClientName) {
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
		
		JLabel lblBannerCenter = new JLabel("訂單管理");
		lblBannerCenter.setHorizontalAlignment(SwingConstants.CENTER);
		lblBannerCenter.setForeground(Color.WHITE);
		lblBannerCenter.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblBannerCenter.setBounds(334, 0, 115, 28);
		panelBannerTop.add(lblBannerCenter);
		
		JPanel panelContents = new JPanel();
		panelContents.setBackground(new Color(255, 255, 255));
		panelContents.setBounds(2, 28, 782, 507);
		contentPane.add(panelContents);
		panelContents.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(23, 22, 728, 294);
		panelContents.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 708, 251);
		panel.add(scrollPane);
		
		JTextArea textAreaOutput = new JTextArea();
		scrollPane.setViewportView(textAreaOutput);
				
		JButton btnListOrder = new JButton("查詢");
		btnListOrder.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnListOrder.setBounds(10, 0, 85, 23);
		panel.add(btnListOrder);
				
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 326, 728, 82);
		panelContents.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnEdit = new JButton("修改");
		btnEdit.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnEdit.setBounds(633, 43, 85, 23);
		panel_1.add(btnEdit);
		
		JLabel lblEditId = new JLabel("訂單編號:");
		lblEditId.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblEditId.setBounds(11, 9, 68, 24);
		panel_1.add(lblEditId);
		
		textFieldEditId = new JTextField();
		textFieldEditId.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldEditId.setBounds(89, 11, 53, 21);
		panel_1.add(textFieldEditId);
		textFieldEditId.setColumns(10);
		
		JLabel lblEditLcd = new JLabel("LCD:");
		lblEditLcd.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblEditLcd.setBounds(11, 43, 44, 24);
		panel_1.add(lblEditLcd);
		
		textFieldEditLcd = new JTextField();
		textFieldEditLcd.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldEditLcd.setColumns(10);
		textFieldEditLcd.setBounds(54, 45, 53, 21);
		panel_1.add(textFieldEditLcd);
		
		JLabel lblEditRam = new JLabel("RAM:");
		lblEditRam.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblEditRam.setBounds(137, 43, 48, 24);
		panel_1.add(lblEditRam);
		
		textFieldEditRam = new JTextField();
		textFieldEditRam.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldEditRam.setColumns(10);
		textFieldEditRam.setBounds(195, 45, 53, 21);
		panel_1.add(textFieldEditRam);
		
		JLabel lblEditMouse = new JLabel("Mouse:");
		lblEditMouse.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblEditMouse.setBounds(285, 43, 67, 24);
		panel_1.add(lblEditMouse);
		
		textFieldEditMouse = new JTextField();
		textFieldEditMouse.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldEditMouse.setColumns(10);
		textFieldEditMouse.setBounds(362, 45, 53, 21);
		panel_1.add(textFieldEditMouse);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(23, 418, 728, 46);
		panelContents.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnDelete = new JButton("刪除");
		btnDelete.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnDelete.setBounds(633, 10, 85, 23);
		panel_2.add(btnDelete);
		
		JLabel lblDelId = new JLabel("訂單編號:");
		lblDelId.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblDelId.setBounds(10, 10, 68, 24);
		panel_2.add(lblDelId);
		
		textFieldDelID = new JTextField();
		textFieldDelID.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldDelID.setColumns(10);
		textFieldDelID.setBounds(88, 12, 53, 21);
		panel_2.add(textFieldDelID);
		
		JButton btnBackMain = new JButton("回主頁");
		btnBackMain.setBounds(687, 474, 85, 23);
		panelContents.add(btnBackMain);
		btnBackMain.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JPanel panelBannerBottom = new JPanel();
		panelBannerBottom.setLayout(null);
		panelBannerBottom.setBackground(Color.RED);
		panelBannerBottom.setBounds(0, 538, 786, 28);
		contentPane.add(panelBannerBottom);
		
		lblDateTime = new JLabel("日期與時間");
		lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateTime.setForeground(Color.WHITE);
		lblDateTime.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblDateTime.setBounds(662, 0, 120, 28);
		panelBannerBottom.add(lblDateTime);
		
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
		
		btnListOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				textAreaOutput.setText(porderserviceimpl.AllPorder());
			}
		});

		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Id=Integer.parseInt(textFieldDelID.getText());
				porderserviceimpl.deletePorderById(Id);
			}
		});
		
		btnEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Id=Integer.parseInt(textFieldEditId.getText());
				int Lcd=Integer.parseInt(textFieldEditLcd.getText());
				int Ram=Integer.parseInt(textFieldEditRam.getText());
				int Mouse=Integer.parseInt(textFieldEditMouse.getText());
				porderserviceimpl.updatePorder(Lcd, Ram, Mouse, Id);
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
