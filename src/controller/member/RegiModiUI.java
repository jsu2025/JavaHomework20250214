package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GettingStartedUI;
import dao.MemberDao;
import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;
import service.impl.MemberServiceImpl;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class RegiModiUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldClientID;
	private JTextField textFieldPassword;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JTextField textFieldMobile;
	private JButton btnRegister;
	private JButton btnBack;
	private JPanel panelBannerTop;
	private JLabel lblBannerCenter;
	private JPanel panelBannerBottom;
	private JLabel lblDateTime;
	private JPanel panelContents;
	private JTextField textFieldEmail;
	private JTextField textFieldPasswordChk;
	private JTextField textFieldIDNumber;
	private JLabel lblLoginNameBanner;
	private JLabel lblMobilFormat;
	private JLabel lblIDNumFormat;
	private Boolean Modi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegiModiUI frame = new RegiModiUI("ID","Name");
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
	public RegiModiUI(String strClientID, String strClientName) {
		setResizable(false);
		this.setTitle("鉅強企業 - 註冊");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Point pointUILocation=(Point)Tool.read(Tool.filenameUILocation());
		setLocation(pointUILocation);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelBannerTop = new JPanel();
		panelBannerTop.setLayout(null);
		panelBannerTop.setForeground(Color.WHITE);
		panelBannerTop.setBackground(Color.RED);
		panelBannerTop.setBounds(0, 0, 786, 28);
		contentPane.add(panelBannerTop);
		
		lblLoginNameBanner = new JLabel("使用者姓名");
		lblLoginNameBanner.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoginNameBanner.setForeground(Color.WHITE);
		lblLoginNameBanner.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblLoginNameBanner.setBounds(662, 0, 120, 25);
		panelBannerTop.add(lblLoginNameBanner);
		
		lblBannerCenter = new JLabel("帳號註冊");
		lblBannerCenter.setHorizontalAlignment(SwingConstants.CENTER);
		lblBannerCenter.setForeground(Color.WHITE);
		lblBannerCenter.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblBannerCenter.setBounds(334, 0, 115, 28);
		panelBannerTop.add(lblBannerCenter);
		
		panelBannerBottom = new JPanel();
		panelBannerBottom.setLayout(null);
		panelBannerBottom.setBackground(Color.RED);
		panelBannerBottom.setBounds(0, 535, 786, 28);
		contentPane.add(panelBannerBottom);
		
		lblDateTime = new JLabel("日期與時間");	//不可加 "JLabel"
		lblDateTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateTime.setForeground(Color.WHITE);
		lblDateTime.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblDateTime.setBounds(662, 0, 120, 28);
		panelBannerBottom.add(lblDateTime);
		
		panelContents = new JPanel();
		panelContents.setBounds(2, 28, 782, 507);
		contentPane.add(panelContents);
		panelContents.setLayout(null);
		
		JLabel lblLoginID = new JLabel("* 登入帳號");
		lblLoginID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoginID.setBounds(231, 70, 100, 28);
		panelContents.add(lblLoginID);
		lblLoginID.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		textFieldClientID = new JTextField();
		textFieldClientID.setBounds(353, 70, 138, 28);
		panelContents.add(textFieldClientID);
		textFieldClientID.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldClientID.setColumns(10);
		textFieldClientID.setText(strClientID);
				
		JLabel lblPassword = new JLabel("* 設定密碼");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(231, 110, 100, 28);
		panelContents.add(lblPassword);
		lblPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
				
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(353, 110, 138, 28);
		panelContents.add(textFieldPassword);
		textFieldPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldPassword.setColumns(10);
				
		JLabel lblName = new JLabel("* 客戶姓名");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(231, 190, 100, 28);
		panelContents.add(lblName);
		lblName.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
				
		textFieldName = new JTextField();
		textFieldName.setBounds(353, 190, 138, 28);
		panelContents.add(textFieldName);
		textFieldName.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldName.setColumns(10);
				
		JLabel lblAddress = new JLabel("聯絡地址");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(231, 390, 100, 28);
		panelContents.add(lblAddress);
		lblAddress.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
				
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(353, 390, 228, 28);
		panelContents.add(textFieldAddress);
		textFieldAddress.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldAddress.setColumns(10);
				
		JLabel lblPhone = new JLabel("市內電話");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(231, 310, 100, 28);
		panelContents.add(lblPhone);
		lblPhone.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
				
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(353, 310, 138, 28);
		panelContents.add(textFieldPhone);
		textFieldPhone.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldPhone.setColumns(10);
				
		JLabel lblMobile = new JLabel("* 行動電話");
		lblMobile.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobile.setBounds(231, 270, 100, 28);
		panelContents.add(lblMobile);
		lblMobile.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
				
		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(353, 270, 138, 28);
		panelContents.add(textFieldMobile);
		textFieldMobile.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldMobile.setColumns(10);
				
		btnRegister = new JButton("註冊");
		btnRegister.setBounds(353, 442, 85, 28);
		panelContents.add(btnRegister);
		btnRegister.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		
		btnBack = new JButton("回首頁");
		btnBack.setBounds(687, 474, 85, 23);
		panelContents.add(btnBack);
		btnBack.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		
		JLabel lblEMail = new JLabel("電子信箱");
		lblEMail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEMail.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblEMail.setBounds(231, 350, 100, 28);
		panelContents.add(lblEMail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(353, 350, 228, 28);
		panelContents.add(textFieldEmail);
		
		JLabel lblPasswordChk = new JLabel("* 確認密碼");
		lblPasswordChk.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPasswordChk.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblPasswordChk.setBounds(231, 150, 100, 28);
		panelContents.add(lblPasswordChk);
		
		textFieldPasswordChk = new JTextField();
		textFieldPasswordChk.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldPasswordChk.setColumns(10);
		textFieldPasswordChk.setBounds(353, 150, 138, 28);
		panelContents.add(textFieldPasswordChk);
		
		JButton btnClientIDCheck = new JButton("帳號檢核");
		btnClientIDCheck.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		btnClientIDCheck.setBounds(501, 74, 100, 23);
		panelContents.add(btnClientIDCheck);
		
		JLabel lblIDNo = new JLabel("身分證號");
		lblIDNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIDNo.setFont(new Font("微軟正黑體", Font.PLAIN, 18));
		lblIDNo.setBounds(231, 230, 100, 28);
		panelContents.add(lblIDNo);
		
		textFieldIDNumber = new JTextField();
		textFieldIDNumber.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		textFieldIDNumber.setColumns(10);
		textFieldIDNumber.setBounds(353, 230, 138, 28);
		panelContents.add(textFieldIDNumber);
		
		lblMobilFormat = new JLabel("範例: 0912345678");
		lblMobilFormat.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblMobilFormat.setBounds(501, 282, 116, 15);
		panelContents.add(lblMobilFormat);
		
		lblIDNumFormat = new JLabel("範例: A123456789");
		lblIDNumFormat.setFont(new Font("微軟正黑體", Font.PLAIN, 12));
		lblIDNumFormat.setBounds(501, 242, 116, 15);
		panelContents.add(lblIDNumFormat);
		
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

		//資料修改用頁面-----------------------------------------------
		Modi=false;
		if(!strClientID.isEmpty()) {
			Modi=true;
			Member member=new MemberServiceImpl().findByClientID(strClientID); 
			textFieldPassword.setText(member.getClientPassword());
			textFieldName.setText(member.getClientName());
			textFieldIDNumber.setText(member.getClientIDNumber());
			textFieldMobile.setText(member.getClientMobile());
			textFieldPhone.setText(member.getClientPhone());
			textFieldEmail.setText(member.getClientEmail());
			textFieldPassword.setText(member.getClientPassword());
			btnRegister.setText("修改");
			btnClientIDCheck.setEnabled(false);
			btnBack.setText("回前頁");
			textFieldClientID.setEnabled(false);
			lblBannerCenter.setText("資料修改");
			this.setTitle("鉅強實業 - 修改");
		}
		
		//返回前頁或首頁-------------------------------------------------
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				if(Modi)
				{
					LoginSuccessUI ui=new LoginSuccessUI(strClientID,strClientName);
					ui.setVisible(true);
				}
				else
				{
					GettingStartedUI ui=new GettingStartedUI();
					ui.setVisible(true);
				}
				
				dispose();
			}
		});
		
		//註冊----------------------------------------------------
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				String strClientID=textFieldClientID.getText();
				String strClientPassword=textFieldPassword.getText();
				String strPasswordChk=textFieldPasswordChk.getText();
				String strClientName=textFieldName.getText();
				String strClientIDNumber=textFieldIDNumber.getText();
				String strClientMobile=textFieldMobile.getText();
				String strClientPhone=textFieldPhone.getText();
				String strClientEmail=textFieldEmail.getText();
				String strClientAddress=textFieldAddress.getText();
				if(strClientID.isEmpty()|strClientPassword.isEmpty()|strPasswordChk.isEmpty()
					|strClientName.isEmpty()|strClientMobile.isEmpty())
				{
					JOptionPane.showMessageDialog(jFrameDialog, "星號欄位請勿空白");
				}				
				else if(!Modi&new MemberServiceImpl().isClientIDBeenUse(strClientID))
				{
					RegiModiErrorUI addmembererror=new RegiModiErrorUI(strClientID,strClientName,Modi);
					addmembererror.setVisible(true);
					dispose();
				}
				else if (!Modi) //新增
				{	
					Member member=new Member(strClientID,strClientPassword,strClientName,
											strClientIDNumber,strClientMobile,strClientPhone,
											strClientEmail,strClientAddress);
					
					new MemberServiceImpl().newRegister(member);
					
					RegiModiSuccessUI regsuccess=new RegiModiSuccessUI(strClientID,strClientName,Modi);
					regsuccess.setVisible(true);
					dispose();
				}
				else //修改
				{
					//Member member=new MemberServiceImpl().findByClientID(strClientID); 
					MemberServiceImpl memberserviceimpl=new MemberServiceImpl();
					memberserviceimpl.updateMember(strClientPassword, strClientName, strClientIDNumber,
							strClientMobile, strClientPhone, strClientEmail, strClientAddress,
							strClientID);
					RegiModiSuccessUI regsuccess=new RegiModiSuccessUI(strClientID,strClientName,Modi);
					regsuccess.setVisible(true);
					dispose();
				}
			}
		});	

		//帳號重複檢查-----------------------------------------------
		btnClientIDCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//String Username=textFieldClientID.getText();
				if(!Modi) {
				String strClientID=textFieldClientID.getText();
				if(new MemberServiceImpl().isClientIDBeenUse(strClientID))
				{
					JOptionPane.showMessageDialog(jFrameDialog, "客戶帳號: "+strClientID+" 已註冊, 請更換帳號");
					textFieldClientID.requestFocus();
				}
				else
				{
					JOptionPane.showMessageDialog(jFrameDialog, "客戶帳號: "+strClientID+" 尚未註冊, 可以使用");
				}};
				/*try {
					System.out.println(Tool.intColumnLength("password"));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		
		//欄位輸入檢查-----------------------------------------------
		
		textFieldClientID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String strColumnName="clientID";
				String strTextInput=textFieldClientID.getText();
				int intColumnLength=0;
				try {
					intColumnLength=Tool.intColumnLength(strColumnName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!strTextInput.isEmpty()) {
				if(!Tool.isAcceptedFormat(strTextInput,"EngNum")) {
					System.out.println(strTextInput);
					JOptionPane.showMessageDialog(jFrameDialog, "僅可輸入英文字母或數字");
					textFieldClientID.requestFocus();
				}
				else if(strTextInput.length()>intColumnLength) {
					JOptionPane.showMessageDialog(jFrameDialog, "不可超過 "+intColumnLength+" 個字元");
					textFieldClientID.requestFocus();
				}};
			}
		});
		
		textFieldPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String strColumnName="clientPassword";
				String strTextInput=textFieldPassword.getText();
				
				int intColumnLength=0;
				try {
					intColumnLength=Tool.intColumnLength(strColumnName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!strTextInput.isEmpty()) {
				if(!Tool.isAcceptedFormat(strTextInput,"EngNum")) {
					JOptionPane.showMessageDialog(jFrameDialog, "僅可輸入英文字母或數字");
					textFieldPassword.requestFocus();
				}
				else if(strTextInput.length()>intColumnLength) {
					JOptionPane.showMessageDialog(jFrameDialog, "不可超過 "+intColumnLength+" 個字元");
					textFieldPassword.requestFocus();
				}};
			}
		});
		
		textFieldPasswordChk.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String strTextInput=textFieldPasswordChk.getText();
				if(!strTextInput.isEmpty()) {
				if(!strTextInput.equals(textFieldPassword.getText())) {
					JOptionPane.showMessageDialog(jFrameDialog, "密碼輸入不一致");
					textFieldPasswordChk.setText("");
					textFieldPasswordChk.requestFocus();
				}};
			}
		});
		
		textFieldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String strColumnName="clientName";
				String strTextInput=textFieldName.getText();
				
				int intColumnLength=0;
				try {
					intColumnLength=Tool.intColumnLength(strColumnName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!strTextInput.isEmpty()) {
				if(strTextInput.length()>intColumnLength) {
					JOptionPane.showMessageDialog(jFrameDialog, "不可超過 "+intColumnLength+" 個字元");
					textFieldName.requestFocus();
				}};
			}
		});
		
		textFieldAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String strColumnName="clientAddress";
				String strTextInput=textFieldAddress.getText();
				
				int intColumnLength=0;
				try {
					intColumnLength=Tool.intColumnLength(strColumnName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!strTextInput.isEmpty()) {
				if(strTextInput.length()>intColumnLength) {
					JOptionPane.showMessageDialog(jFrameDialog, "不可超過 "+intColumnLength+" 個字元");
					textFieldAddress.requestFocus();
				}};
			}
		});
		
		textFieldPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String strColumnName="clientPhone";
				String strTextInput=textFieldPhone.getText();
				
				int intColumnLength=0;
				try {
					intColumnLength=Tool.intColumnLength(strColumnName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!strTextInput.isEmpty()) {
				if(strTextInput.length()>intColumnLength) {
					JOptionPane.showMessageDialog(jFrameDialog, "不可超過 "+intColumnLength+" 個字元");
					textFieldPhone.requestFocus();
				}};
			}
		});
		
		textFieldMobile.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String strColumnName="clientMobile";
				String strTextInput=textFieldMobile.getText();
				
				int intColumnLength=0;
				try {
					intColumnLength=Tool.intColumnLength(strColumnName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!strTextInput.isEmpty()) {
				if(strTextInput.length()>intColumnLength) {
					JOptionPane.showMessageDialog(jFrameDialog, "不可超過 "+intColumnLength+" 個字元");
					textFieldMobile.requestFocus();
				}
				else if(!Tool.isAcceptedFormat(strTextInput, "Mobile")) {
					JOptionPane.showMessageDialog(jFrameDialog, "行動電話號碼有誤");
					textFieldMobile.requestFocus();
				}};
			}
		});
		
		textFieldEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String strColumnName="clientEmail";
				String strTextInput=textFieldEmail.getText();
				
				int intColumnLength=0;
				try {
					intColumnLength=Tool.intColumnLength(strColumnName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!strTextInput.isEmpty()) {
				if(strTextInput.length()>intColumnLength) {
					JOptionPane.showMessageDialog(jFrameDialog, "不可超過 "+intColumnLength+" 個字元");
					textFieldEmail.requestFocus();
				}
				else if(!Tool.isAcceptedFormat(strTextInput, "Email")){
					JOptionPane.showMessageDialog(jFrameDialog, "電子信箱地址有誤");
					textFieldEmail.requestFocus();
				}};
			}
		});
		
		textFieldIDNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String strColumnName="clientIDNumber";
				String strTextInput=textFieldIDNumber.getText();
				
				int intColumnLength=0;
				try {
					intColumnLength=Tool.intColumnLength(strColumnName);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!strTextInput.isEmpty()) {
				if(!Tool.isAcceptedFormat(strTextInput, "EngNum")) {
					JOptionPane.showMessageDialog(jFrameDialog, "僅可輸入英文字母或數字");
					textFieldIDNumber.requestFocus();
				}
				else if(strTextInput.length()>intColumnLength) {
					JOptionPane.showMessageDialog(jFrameDialog, "不可超過 "+intColumnLength+" 個字元");
					textFieldIDNumber.requestFocus();
				}
				else if(!Tool.isValidID(strTextInput)) {
					JOptionPane.showMessageDialog(jFrameDialog, "身份證字號有誤");
					textFieldIDNumber.requestFocus();
				}};
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
