package com.wipro.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wipro.shop.bean.ItemBean;
import com.wipro.shop.util.DBUtil;

public class Item_Dao {
		
	public List<ItemBean> findAll(){
		List<ItemBean> items =new ArrayList<ItemBean>();
		ItemBean ib =null;
		Connection con=DBUtil.getDBConnection();
		
		try {
			PreparedStatement psm=con.prepareStatement("select * from items_tbl");
			 ResultSet res=psm.executeQuery();
			 while(res.next()) {
				ib =new ItemBean();
				ib.setCost(res.getFloat(1));
				ib.setItemCode(res.getString(2));
				ib.setName(res.getString(3));
				ib.setQuantity(res.getInt(4));
				
				items.add(ib);
				
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(items.size()==0)
			return null;
		else
			return items;
		
		
	}
	
	
	public ItemBean findItemByItemCode(String itemCode) {
		ItemBean itb =null;
		Connection con =DBUtil.getDBConnection();
		try {
			PreparedStatement psmt =con.prepareStatement("select * from items_tbl where itemCode=?");
			psmt.setString(1, itemCode);
			ResultSet rs =psmt.executeQuery();
			while(rs.next()) {
				itb =new ItemBean();
				itb.setCost(rs.getInt(1));
				itb.setItemCode(rs.getString(2));
				itb.setName(rs.getString(3));
				itb.setQuantity(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return itb;
		
	}
	
}
