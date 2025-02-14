package controller.porder;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.GettingStartedUI;
import controller.member.LoginSuccessUI;
import util.Tool;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ForeignExchangeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDateTime;
    private JTable table;
    private JButton btnBack;
    private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForeignExchangeUI frame = new ForeignExchangeUI("ID","Name");
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
	public ForeignExchangeUI(String strClientID, String strClientName) {
		setResizable(false);
		this.setTitle("鉅強企業 - 外匯事業");
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
		
		JLabel lblBannerCenter = new JLabel("鉅強實業");
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

		// 設定表格模型
        tableModel = new DefaultTableModel();
        tableModel.addColumn("幣別");
        tableModel.addColumn("現金買入");
        tableModel.addColumn("現金賣出");
        tableModel.addColumn("即期買入");
        tableModel.addColumn("即期賣出");
        
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        JPanel panelContents = new JPanel();
        panelContents.setBounds(10, 38, 766, 484);
        contentPane.add(panelContents);
        panelContents.add(scrollPane);
        
        // 抓取匯率資料
        fetchExchangeRatesFromCSV();
        
		btnBack = new JButton("回前頁");
		btnBack.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		//btnBack.setBounds(287, 244, 85, 23);
		//btnBack.setLocation(500, 400);
		panelContents.add(btnBack);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tool.save(getLocation(), Tool.filenameUILocation());
				LoginSuccessUI ui=new LoginSuccessUI(strClientID,strClientName);
				ui.setVisible(true);
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
	
	private void fetchExchangeRatesFromCSV() {
        try {
            // 台灣銀行 CSV 資料來源
            URL url = new URL("https://rate.bot.com.tw/xrt/flcsv/0/day");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 檢查 HTTP 回應碼
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("連線失敗: HTTP " + conn.getResponseCode());
            }

            // 讀取 CSV 內容（注意編碼為 Big5 會有亂碼 改用UFT-8）
            BufferedReader reader = new BufferedReader(
                //new InputStreamReader(conn.getInputStream(), "Big5")
                new InputStreamReader(conn.getInputStream(), "UTF-8")
            );

            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // 跳過標題列
                }

                // 分割 CSV 欄位
                String[] columns = line.split(",");
                if (columns.length >= 12) {
                    //String currency = columns[0].trim() + " " + columns[1].trim();
                	String currency = columns[0].trim();
                    String cashBuy = columns[2].trim();
                    String cashSell = columns[12].trim(); // 現金賣出在第 13 欄
                    String spotBuy = columns[3].trim();
                    String spotSell = columns[4].trim();

                    // 將資料加入表格
                    tableModel.addRow(new Object[]{
                        currency, cashBuy, cashSell, spotBuy, spotSell
                    });
                }
            }

            reader.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "無法取得匯率資料！錯誤訊息: " + e.getMessage(),
                "錯誤", JOptionPane.ERROR_MESSAGE);
        }
    }
	
}
