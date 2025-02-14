package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tool {
	
	//檔案儲存與讀取--------------------------------------------
	public static void save(Object s,String filename)
	{
		try
		{	
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);	
			oos.writeObject(s);
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Object read(String filename)
	{
		Object o=null;
		try
		{
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
		}
		catch (FileNotFoundException e)
		{
			//e.printStackTrace();
			System.out.println("FileNotFound!!");
		}
		catch (IOException e)
		{
			//e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			//e.printStackTrace();
		}
		return o;
	}
	
	//設定儲存UI位址的檔案名稱------------------------------------
	public static String filenameUILocation()
	{
		return "UILocation.inf";
	}

    //正規表示式-英文字母與數字------------------------------------
	/*public static boolean isAlphanumeric(String strInput) {
	    String strRegex = "^[a-zA-Z0-9]+$";
	    Pattern pattern = Pattern.compile(strRegex);
	    Matcher matcher = pattern.matcher(strInput);
	    return matcher.matches();
	}
	
	//正規表示式-電子郵件----------------------------------------
	public static boolean isEmailFormat(String strInput) {
	    String strRegex =  "^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$";
	    Pattern pattern = Pattern.compile(strRegex);
	    Matcher matcher = pattern.matcher(strInput);
	    return matcher.matches();
	}*/

	//正規表示式-------------------------------------------------
	public static boolean isAcceptedFormat(String strInput, String strFormat) {
		String strRegex="";
		switch(strFormat) {
	    case "Email":	//電子郵件
	    	strRegex =  "^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$";
	    	break;
	    case "EngNum":	//英文字母與數字
	    	strRegex = "^[a-zA-Z0-9]+$";
	    	break;
	    case "Mobile":	//行動電話(台灣)
	    	strRegex = "[0-9]{4}[0-9]{3}[0-9]{3}";
	    	break;
	    default:
	    	strRegex = "";
	    	break;
	    }
		Pattern pattern = Pattern.compile(strRegex);
	    Matcher matcher = pattern.matcher(strInput);
	    return matcher.matches();		
	}
	
	
	//儲存格長度限制---------------------------------------------
	public static int intColumnLength(String strColumnName) throws SQLException {
		Integer intLength=0;
	    try (Connection conn = DbConnection.getDb()) {
	        // 查詢資料庫的元數據來獲取欄位的長度
	        String query = "SELECT CHARACTER_MAXIMUM_LENGTH FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ? AND COLUMN_NAME = ?";
	        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	            preparedStatement.setString(1, "member");
	            preparedStatement.setString(2, strColumnName);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    intLength = resultSet.getInt("CHARACTER_MAXIMUM_LENGTH");
	                }
	            }
	        }
	    }
		return intLength;
	}
	
	//身份證字號驗證---------------------------------------------
	public static boolean isValidID(String strIDNum) {
		int[] LETTER_MAPPING = {
		        10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21,
		        22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 33
		    };
        if (strIDNum == null || strIDNum.length() != 10) {
            return false;
        }
        char firstChar = strIDNum.charAt(0);
        if (!Character.isLetter(firstChar)) {
            return false;
        }
        char secondChar = strIDNum.charAt(1);
        if (secondChar != '1' && secondChar != '2') {
            return false;
        }
        for (int i = 2; i < 10; i++) {
            if (!Character.isDigit(strIDNum.charAt(i))) {
                return false;
            }
        }
        int letterIndex = Character.toUpperCase(firstChar) - 'A';
        if (letterIndex < 0 || letterIndex >= LETTER_MAPPING.length) {
            return false;
        }
        int letterValue = LETTER_MAPPING[letterIndex];
        System.out.println(letterValue);
        int sum = (letterValue / 10) * 1 + (letterValue % 10) * 9;
        for (int i = 1; i < 9; i++) {
        	System.out.println(strIDNum.charAt(i));
            sum += (strIDNum.charAt(i) - '0') * (9 - i);
        }
        sum += (strIDNum.charAt(9) - '0') * 1;
        return sum % 10 == 0;
    }

}