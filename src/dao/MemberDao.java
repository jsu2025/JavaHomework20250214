package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	//create
	void add(Member member);
	
	//read
	List<Member> selectAll();//select * from member
	List<Member> selectClientIDAndClientPassword(String strClientID,String strClientPassword);//select * from member where clientID=? and clientPassword=?
	List<Member> selectByClientIDPK(int intClientIDPK);
	List<Member> selectByClientID(String strClientID);
	
	//update
	void update(Member member);
	
	//delete
	void delete(int intClientIDPK);

}