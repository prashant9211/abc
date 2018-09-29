package com.wipro.shop.util;

import java.sql.Connection;

public class NoSecureCouponException extends Exception{
	
	public String toString() {
		return "INVALID COUPON CODE";
		
	}
}
