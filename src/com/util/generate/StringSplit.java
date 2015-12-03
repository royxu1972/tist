package com.util.generate;


public class StringSplit {
	public static void main(String[] args) {
		try{
			String fieldName="user_idName";
			String setMethodName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			String getMethodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
			System.out.println(setMethodName);
			System.out.println(getMethodName);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
