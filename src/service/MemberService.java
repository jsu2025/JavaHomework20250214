package service;

import model.Member;

public interface MemberService {
	//create
	void newRegister(Member member);
	
	
	//read
	Member Login(String strClientID,String strClientPassword);
	boolean isClientIDBeenUse(String strClientID);


	Member findByClientIDPK(int intClientIDPK);


	Member findByClientID(String strClientID);


	//update
	void updateMember(String strClientPassword, String strClientName, String strClientIDNumber, String strClientMobile,
			String strClientPhone, String strClientEmail, String strClientAddress, String intClientID);
	
	
	//delete
	

}