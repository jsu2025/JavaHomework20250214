package model;

import java.io.Serializable;

public class Member implements Serializable{
	private Integer intClientIDPK;
	private String strClientID;
	private String strClientPassword;
	private String strClientName;
	private String strClientIDNumber;
	private String strClientMobile;
	private String strClientPhone;
	private String strClientEmail;
	private String strClientAddress;
	
	
	public Member(String strClientID, String strClientPassword, String strClientName,
				String strClientIDNumber, String strClientMobile, String strClientPhone,  
				String strClientEmail, String strClientAddress) {
		super();
		this.strClientID = strClientID;
		this.strClientPassword = strClientPassword;
		this.strClientName = strClientName;
		this.strClientIDNumber = strClientIDNumber;
		this.strClientMobile = strClientMobile;
		this.strClientPhone = strClientPhone;
		this.strClientEmail = strClientEmail;
		this.strClientAddress = strClientAddress;		
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getClientIDPK() {
		return intClientIDPK;
	}
	public void setClientIDPK(Integer intClientIDPK) {
		this.intClientIDPK = intClientIDPK;
	}
	public String getClientName() {
		return strClientName;
	}
	public void setClientName(String strClientName) {
		this.strClientName = strClientName;
	}
	public String getClientID() {
		return strClientID;
	}
	public void setClientID(String strClientID) {
		this.strClientID = strClientID;
	}
	public String getClientPassword() {
		return strClientPassword;
	}
	public void setClientPassword(String strClientPassword) {
		this.strClientPassword = strClientPassword;
	}
	public String getClientAddress() {
		return strClientAddress;
	}
	public void setClientAddress(String strClientAddress) {
		this.strClientAddress = strClientAddress;
	}
	public String getClientPhone() {
		return strClientPhone;
	}
	public void setClientPhone(String strClientPhone) {
		this.strClientPhone = strClientPhone;
	}
	public String getClientMobile() {
		return strClientMobile;
	}
	public void setClientMobile(String strClientMobile) {
		this.strClientMobile = strClientMobile;
	}
	public String getClientIDNumber() {
		return strClientIDNumber;
	}
	public void setClientIDNumber(String strClientIDNumber) {
		this.strClientIDNumber = strClientIDNumber;
	}
	public String getClientEmail() {
		return strClientEmail;
	}
	public void setClientEmail(String strClientEmail) {
		this.strClientEmail = strClientEmail;
	}
}