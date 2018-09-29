package com.wipro.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wipro.shop.bean.CouponBean;
import com.wipro.shop.bean.ItemBean;
import com.wipro.shop.util.DBUtil;

public class CouponDAO {
	public CouponBean findCouponByCouponCode(String couponCode) {
		CouponBean coupon=null;
		Connection con =DBUtil.getDBConnection();
		try {
			PreparedStatement pst =con.prepareStatement("select * from Coupons_tbl  where couponCode =?");
			pst.setString(1, couponCode);
			ResultSet res=pst.executeQuery();
			while(res.next()) {
				coupon=new CouponBean();
				coupon.setCouponCode(res.getString(1));
				coupon.setCouponCode(res.getString(2));
				coupon.setCouponCode(res.getString(3));
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return coupon;
		
	}
	public boolean updateCouponByCouponCode(String code) {
		int value=0;
		Connection con=DBUtil.getDBConnection();
		
		try {
			PreparedStatement psmt =con.prepareStatement("update coupons_tbl where couponCode =?");
			psmt.setString(1, code);
			value=psmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(value>0) {
			return true;
		}
		else
		
		
		return false;
		
	}
	public CouponBean findCouponByUserID(String userID) {
		
		CouponBean cob =null;
		
		Connection con= DBUtil.getDBConnection();
		try {
			PreparedStatement psmt =con.prepareStatement("select * from Coupons_tbl where userID =?");
			psmt.setString(1, userID);
			ResultSet res =psmt.executeQuery();
			while(res.next()) {
				cob =new CouponBean();
				cob.setCouponCode(res.getString(1));
				cob.setUserID(res.getString(2));
				cob.setStatus(res.getInt(3));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cob;
	}
}
