package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao{

	public static void main(String[] args) {
		/*Porder p=new Porder("abc",1,2,3);
		new PorderDaoImpl().add(p);*/
	}

	private static Connection conn=DbConnection.getDb();
	
	@Override
	public void add(Porder porder) {
		String Sql="insert into porder(name,lcd,ram,mouse) value(?,?,?,?)";
		try {
			PreparedStatement preparedstatement =conn.prepareStatement(Sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getLcd());
			preparedstatement.setInt(3, porder.getRam());
			preparedstatement.setInt(4, porder.getMouse());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Porder> selectAll() {
		String sql="select * from porder";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			ResultSet resultset=preparedstatement.executeQuery();
			while(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setLcd(resultset.getInt("lcd"));
				porder.setRam(resultset.getInt("ram"));
				porder.setMouse(resultset.getInt("mouse"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		return l;
	}

	@Override
	public List<Porder> selectById(int id) {
		String Sql="select * from porder where id=?";
		List<Porder> l=new ArrayList();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(Sql);
			preparedstatement.setInt(1, id);			
			ResultSet resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				Porder porder=new Porder();
				porder.setId(resultset.getInt("id"));
				porder.setName(resultset.getString("name"));
				porder.setLcd(resultset.getInt("lcd"));
				porder.setRam(resultset.getInt("ram"));
				porder.setMouse(resultset.getInt("mouse"));
				l.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public void update(Porder porder) {
		String sql="update porder set name=?,lcd=?,ram=?,mouse=? where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, porder.getName());
			preparedstatement.setInt(2, porder.getLcd());
			preparedstatement.setInt(3, porder.getRam());
			preparedstatement.setInt(4, porder.getMouse());
			preparedstatement.setInt(5, porder.getId());
			
			preparedstatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
