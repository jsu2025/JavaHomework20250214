package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao{

	public static void main(String[] args) {
		//new MemberDaoImpl().delete(3);
		List<Member> member=new MemberDaoImpl().selectByClientID("ttt");
		for(Member m:member) {
			System.out.print(m.getClientName()+" "+m.getClientIDPK());
		}
	}
	
	private static Connection conn=DbConnection.getDb();

	@Override
	public void add(Member member) {
		String SQ="insert into member(clientID,clientPassword,clientName,clientIDNumber,clientMobile,clientPhone,clientEmail,clientAddress) "
				+ "values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(SQ);
			preparedstatement.setString(1, member.getClientID());
			preparedstatement.setString(2, member.getClientPassword());
			preparedstatement.setString(3, member.getClientName());
			preparedstatement.setString(4, member.getClientIDNumber());
			preparedstatement.setString(5, member.getClientMobile());
			preparedstatement.setString(6, member.getClientPhone());
			preparedstatement.setString(7, member.getClientEmail());
			preparedstatement.setString(8, member.getClientAddress());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Member> selectAll() {
		String sql="select * from member";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Member m=new Member();
				m.setClientIDPK(resultset.getInt("clientIDPK"));
				m.setClientID(resultset.getString("clientID"));
				m.setClientPassword(resultset.getString("clientPassword"));
				m.setClientName(resultset.getString("clientName"));
				m.setClientIDNumber(resultset.getString("clientIDNumber"));
				m.setClientMobile(resultset.getString("clientMobile"));
				m.setClientPhone(resultset.getString("clientPhone"));
				m.setClientEmail(resultset.getString("clientEmail"));
				m.setClientAddress(resultset.getString("clientAddress"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectClientIDAndClientPassword(String strClientID, String strClientPassword) {
		String sql="select * from member where clientID=? and clientPassword=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, strClientID);
			preparedstatement.setString(2, strClientPassword);
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				/*Member m=new Member();
				m.setClientIDPK(resultset.getInt("id"));
				m.setClientName(resultset.getString("name"));
				m.setClientID(resultset.getString("username"));
				m.setClientPassword(resultset.getString("password"));
				m.setClientAddress(resultset.getString("address"));
				m.setClientPhone(resultset.getString("phone"));
				m.setClientMobile(resultset.getString("mobile"));
				l.add(m);*/
				
				Member m=new Member();
				m.setClientIDPK(resultset.getInt("clientIDPK"));
				m.setClientID(resultset.getString("clientID"));
				m.setClientPassword(resultset.getString("clientPassword"));
				m.setClientName(resultset.getString("clientName"));
				m.setClientIDNumber(resultset.getString("clientIDNumber"));
				m.setClientMobile(resultset.getString("clientMobile"));
				m.setClientPhone(resultset.getString("clientPhone"));
				m.setClientEmail(resultset.getString("clientEmail"));
				m.setClientAddress(resultset.getString("clientAddress"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectByClientIDPK(int intClientIDPK) {
		String sql="select * from member where clientIDPK=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, intClientIDPK);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				/*Member m=new Member();
				m.setClientIDPK(resultset.getInt("id"));
				m.setClientName(resultset.getString("name"));
				m.setClientID(resultset.getString("username"));
				m.setClientPassword(resultset.getString("password"));
				m.setClientAddress(resultset.getString("address"));
				m.setClientPhone(resultset.getString("phone"));
				m.setClientMobile(resultset.getString("mobile"));
				l.add(m);*/
				
				Member m=new Member();
				m.setClientIDPK(resultset.getInt("clientIDPK"));
				m.setClientID(resultset.getString("clientID"));
				m.setClientPassword(resultset.getString("clientPassword"));
				m.setClientName(resultset.getString("clientName"));
				m.setClientIDNumber(resultset.getString("clientIDNumber"));
				m.setClientMobile(resultset.getString("clientMobile"));
				m.setClientPhone(resultset.getString("clientPhone"));
				m.setClientEmail(resultset.getString("clientEmail"));
				m.setClientAddress(resultset.getString("clientAddress"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Member> selectByClientID(String strClientID) {
		String sql="select * from member where clientID=?";
		List<Member> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, strClientID);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				/*Member m=new Member();
				m.setClientIDPK(resultset.getInt("id"));
				m.setClientName(resultset.getString("name"));
				m.setClientID(resultset.getString("username"));
				m.setClientPassword(resultset.getString("password"));
				m.setClientAddress(resultset.getString("address"));
				m.setClientPhone(resultset.getString("phone"));
				m.setClientMobile(resultset.getString("mobile"));
				l.add(m);*/
				
				Member m=new Member();
				m.setClientIDPK(resultset.getInt("clientIDPK"));
				m.setClientID(resultset.getString("clientID"));
				m.setClientPassword(resultset.getString("clientPassword"));
				m.setClientName(resultset.getString("clientName"));
				m.setClientIDNumber(resultset.getString("clientIDNumber"));
				m.setClientMobile(resultset.getString("clientMobile"));
				m.setClientPhone(resultset.getString("clientPhone"));
				m.setClientEmail(resultset.getString("clientEmail"));
				m.setClientAddress(resultset.getString("clientAddress"));
				l.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Member member) { //clientID不更改
		String sql="update member set clientPassword=?,clientName=?,clientIDNumber=?,clientMobile=?,clientPhone=?,clientEmail=?,clientAddress=? where clientID=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,member.getClientPassword());
			preparedstatement.setString(2,member.getClientName());
			preparedstatement.setString(3,member.getClientIDNumber());
			preparedstatement.setString(4,member.getClientMobile());
			preparedstatement.setString(5,member.getClientPhone());
			preparedstatement.setString(6,member.getClientEmail());
			preparedstatement.setString(7,member.getClientAddress());
			preparedstatement.setString(8,member.getClientID());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int intClientIDPK) {
		String sql="delete from member where clientIDPK=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, intClientIDPK);
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}