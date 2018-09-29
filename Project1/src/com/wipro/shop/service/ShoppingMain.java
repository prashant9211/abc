package com.wipro.shop.service;

import java.util.ArrayList;
import java.util.List;

import com.wipro.shop.bean.ItemBean;
import com.wipro.shop.dao.CouponDAO;
import com.wipro.shop.dao.Item_Dao;
import com.wipro.shop.util.NoSecureCouponException;

public class ShoppingMain {

	private static final Object UserID = null;






	public static void main(String[] args) {
		ShoppingMain shopping = new ShoppingMain();
		
		
		List<ItemBean> listItems = shopping.viewAllItems();
		// Do Shopping String itemCode = "TI1000"; String userID = "AA1000";
		String couponCode = "AB10CD20";
		//String result = shopping.doShopping(itemCode, userID, couponCode);
		//System.out.println(result);

	}	
	public String doShopping(String itemCode,String userID, String couponCode) {
		CouponDAO cd = new CouponDAO();
		Item_Dao id =new Item_Dao();
		
		if(itemCode==null||userID==null||couponCode==null) {
			return "NULL VALUE";
		}
		if(id.findItemByItemCode(itemCode)==null) {
			return "INVALID ITEM CODE";
		}
		if(cd.findCouponByCouponCode(couponCode)==null) {
			
			try {
				throw new NoSecureCouponException();
			}
			catch(NoSecureCouponException e) {
				e.printStackTrace();
			
			return "INVALID ITEM CODE";	
		}
			}
		
		if(cd.findCouponByCouponCode(couponCode).getUserID().equals(userID))
		{
			return "DATA MIsmatch:";
		}
		if(cd.findCouponByCouponCode(couponCode).getStatus()==0) {
			return "used coupon";
		}
	//	float cost =id.findItemByItemCode(itemCode).getCost();
		
		
		if(couponCode.equals("NO") || userID.equals("G")){
		float	discount =0.0f;
		
		float cost=id.findItemByItemCode(itemCode).getCost();
		
		System.out.println("cost"+cost);
		System.out.println("Discount"+discount);
		cost=cost-discount;

		cd.updateCouponByCouponCode(couponCode);
		
		return cost+"";
		
	
		
			
		
		}
		
		if(cd.findCouponByCouponCode(couponCode).getUserID().equals(UserID));{
		float discount = 0.20f;
		}
		return couponCode;
		
		
		
		}
	
		
	
	
	
	
	
	
	public List<ItemBean> viewAllItems(){
		List<ItemBean> list =new ArrayList<ItemBean>();
		Item_Dao it =new Item_Dao();
		list=it.findAll();
		
		return list ;
	}

}
