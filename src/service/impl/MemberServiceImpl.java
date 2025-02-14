package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import dao.impl.PorderDaoImpl;
import model.Member;
import model.Porder;
import service.MemberService;

public class MemberServiceImpl implements MemberService{

	public static void main(String[] args) {
		//System.out.println(new MemberServiceImpl().isUsernameBeenUse("test")); //Dummy Statement
	}
	
	private static MemberDaoImpl memberdaoimpl=new MemberDaoImpl();

	@Override
	public void newRegister(Member member) {
		memberdaoimpl.add(member);
		
	}

	@Override
	public Member Login(String strClientID, String strClientPassword) {
		/*
		 * 1.判斷member
		 * true-->Member物件
		 * false-->null
		 */
		Member member=null;
		List<Member> l=memberdaoimpl.selectClientIDAndClientPassword(strClientID, strClientPassword);
		if(l.size()!=0)
		{
			member=l.get(0);
		}		
		return member;
	}

	@Override
	public boolean isClientIDBeenUse(String strClientID) {
		//List<Member> l=memberdaoimpl.selectByClientID(strClientID);
		
		//return l.isEmpty();
		
		return !memberdaoimpl.selectByClientID(strClientID).isEmpty();
	}

	@Override
	public Member findByClientIDPK(int intClientIDPK) {
		/*
		 * 1.clientIDPK>=0
		 * 2.Member無--->null
		 */
		Member member=null;
		if(intClientIDPK>0)
		{
			List<Member> l=memberdaoimpl.selectByClientIDPK(intClientIDPK);
			if(l.size()>0)
			{
				member=l.get(0);
			}

		}
		return member;
	}
	@Override
	public Member findByClientID(String strClientID) {
		/*
		 * 1.clientIDPK>=0
		 * 2.Member無--->null
		 */
		Member member=null;
		if(!strClientID.isEmpty())
		{
			List<Member> l=memberdaoimpl.selectByClientID(strClientID);
			if(l.size()>0)
			{
				member=l.get(0);
			}

		}
		return member;
	}
	
	@Override
	public void updateMember(String strClientPassword, String strClientName,
			String strClientIDNumber, String strClientMobile, String strClientPhone,
			String strClientEmail, String strClientAddress, String intClientID) {
		Member m=findByClientID(intClientID);
		m.setClientPassword(strClientPassword);
		m.setClientName(strClientName);
		m.setClientIDNumber(strClientIDNumber);
		m.setClientMobile(strClientMobile);
		m.setClientPhone(strClientPhone);
		m.setClientEmail(strClientEmail);
		m.setClientAddress(strClientAddress);
		
		
		
		memberdaoimpl.update(m);
		
	}
	
}