package com.any.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Mr.Fan
 *
 */
public class RequestUtil {

	/**
	 * 获取字符串
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getString(HttpServletRequest request,String name){
		if(name == null || "".equals(name.trim())){
			return "";
		}
		String value = request.getParameter(name);
		if(value == null){
			return "";
		}
		return value;
	}
	
	public static String getString(HttpServletRequest request,String name,String defvalue){
		String value = getString(request,name);
		if("".equals(value) && defvalue != null){
			return defvalue;
		}
		return value;
	}
	
	/**
	 * 获取整型
	 * @param request
	 * @param name
	 * @return
	 */
	public static int getInt(HttpServletRequest request,String name){
		String valueStr = getString(request, name);
		if("".equals(valueStr)){
			return 0;
		}
		int value = 0;
		
		try{
			value = Integer.parseInt(valueStr);
		}catch(Exception e){
			value = 0;
			return value;
		}
		
		return value;
	}
	
	public static int getInt(HttpServletRequest request,String name,int defvalue){
		int value = getInt(request, name);

		if(value == 0 && defvalue != 0){
			return defvalue;
		}
		return value;
	}
	
	/**
	 * 获取长整形
	 * @param request
	 * @param name
	 * @return
	 */
	public static long getLong(HttpServletRequest request,String name){
		String valueStr = getString(request, name);
		if("".equals(valueStr)){
			return 0;
		}
		long value = 0;
		
		try{
			value = Long.parseLong(valueStr);
		}catch(Exception e){
			value = 0;
			return value;
		}
		
		return value;
	}
	
	public static long getLong(HttpServletRequest request,String name,long defvalue){
		long value = getLong(request, name);
		if(value == 0 && defvalue != 0){
			return defvalue;
		}
		return value;
	}
	
	/**
	 * 获取浮点数
	 * @param request
	 * @param name
	 * @return
	 */
	public static double getDouble(HttpServletRequest request,String name){
		String valueStr = getString(request, name);
		
		if("".equals(valueStr)){
			return Double.parseDouble("0");
		}
		double value;
		try{
			value = Double.parseDouble(valueStr);
		}catch(Exception e){
			value = Double.parseDouble("0");
			return value;
		}
		
		return value;
	}
	
	public static double getLong(HttpServletRequest request,String name,double defvalue){
		double value = getDouble(request, name);
		if(value == 0 && defvalue != 0){
			return defvalue;
		}
		return value;
	}
	/**
	 * 获取布尔型
	 * @param request
	 * @param name
	 * @return
	 */
	public static boolean getBoolean(HttpServletRequest request,String name){
		String valueStr = getString(request, name);
		
		if(Boolean.parseBoolean(valueStr)){
			return true;
		}else{
			if(getInt(request, name) > 0){
				return true;
			}else{
				return false;
			}
		}
	}
}
