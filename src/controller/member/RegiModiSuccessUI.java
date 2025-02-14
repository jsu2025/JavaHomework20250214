package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.impl.MemberServiceImpl;
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
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextArea;

public class RegiModiSuccessUI extends JFrame {

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
					RegiModiSuccessUI frame = new RegiModiSuccessUI("ID","Name",true);
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
	public RegiModiSuccessUI(String strClientID, String strClientName, Boolean Modi) {
		setResizable(false);
		this.setTitle("鉅強企業 - 註冊成功");
		if(Modi) {this.setTitle("鉅強企業 - 修改成功");};
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
		
		JLabel lblBannerCenter = new JLabel("註冊完成");
		if(Modi) {lblBannerCenter.setText("修改完成");};
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
		panelContents.setBackground(new Color(255, 255, 255));
		panelContents.setBounds(2, 28, 782, 507);
		contentPane.add(panelContents);
		panelContents.setLayout(null);
		
		JLabel lblRegisterSuccess = new JLabel("客戶資料列表");
		lblRegisterSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterSuccess.setBounds(320, 25, 138, 25);
		panelContents.add(lblRegisterSuccess);
		lblRegisterSuccess.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JButton btnBacktoLogin = new JButton("重新登入");
		btnBacktoLogin.setBounds(648, 470, 124, 28);
		panelContents.add(btnBacktoLogin);
		btnBacktoLogin.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		JTextArea textAreaClientDataList = new JTextArea();
		textAreaClientDataList.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textAreaClientDataList.setBounds(249, 77, 339, 318);
		panelContents.add(textAreaClientDataList);
		
		JButton btnPrintClientData = new JButton("列印");
		btnPrintClientData.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		btnPrintClientData.setBounds(339, 415, 124, 28);
		panelContents.add(btnPrintClientData);
		
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
		
		//返回登入頁------------------------------------------------
		btnBacktoLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				LoginUI login=new LoginUI(strClientID,strClientName);
				login.setVisible(true);
				dispose();
			}
		});
		
		//資料列印------------------------------------------------
		btnPrintClientData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					textAreaClientDataList.print();
				} catch (PrinterException ep) {
					// TODO Auto-generated catch block
					ep.printStackTrace();
				}
			}
		});
		
		//個別客戶資料列表---------------------------------------------
		/*String strA = null;
		String strB = null;
		String strC = null;
		List<Member> member=new MemberDaoImpl().selectByClientID("zzz");
		for(Member m:member) {
			strA = m.getClientName();
			strB = m.getClientMobile();
			strC = m.getClientPhone();
		}
		System.out.print("A+B+C: "+strA +" "+ strB+" "+strC);
		*/
		
		Member member=new MemberServiceImpl().findByClientID(strClientID); 
		System.out.println(member.getClientID());
		String strClientDataList="";
		strClientDataList=strClientDataList+"客戶編號: "+member.getClientIDPK()+"\n";
		strClientDataList=strClientDataList+"          \n";
		strClientDataList=strClientDataList+"登入帳號: "+member.getClientID()+"\n";
		strClientDataList=strClientDataList+"登入密碼: "+member.getClientPassword()+"\n";
		strClientDataList=strClientDataList+"          \n";
		strClientDataList=strClientDataList+"客戶姓名: "+member.getClientName()+"\n";
		strClientDataList=strClientDataList+"身分證號: "+member.getClientIDNumber()+"\n";
		strClientDataList=strClientDataList+"行動電話: "+member.getClientMobile()+"\n";
		strClientDataList=strClientDataList+"市內電話: "+member.getClientPhone()+"\n";
		strClientDataList=strClientDataList+"電子郵件: "+member.getClientEmail()+"\n";
		strClientDataList=strClientDataList+"聯絡地址: "+member.getClientPassword()+"\n";
				
		textAreaClientDataList.setText(strClientDataList);
		
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
