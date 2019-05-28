package kr.or.ddit.util;

import org.apache.ibatis.logging.LogException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
	public static String cookieString;		//분석할 쿠키 문자열
	
	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtil.class);
	
	/**
	 * 
	 * Method : setCookieString
	 * 작성자 : PC03
	 * 변경이력 :
	 * @param cookieString
	 * Method 설명 : 분석할 쿠키 문자열을 받는다.
	 */
	public static void setCookieString(String cookieString){
		CookieUtil.cookieString = cookieString;
	}

	
	/**
	 * 
	 * Method : getCookie
	 * 작성자 : PC03
	 * 변경이력 :
	 * @param string
	 */
	public static String getCookie(String cookie) {
		
		String[] cookieArray = CookieUtil.cookieString.split("; ");
		String cookieValue ="";
		
		for(String str : cookieArray){
			logger.debug("str : {}", str);
			if(str.startsWith(cookie+"=")){
				String[] cookieStr = str.split("=");
				cookieValue = 	cookieStr[1];
				break;
				// cookieStr[0] = "userId"
				// cookieStr[1] = "brown"

			}
		}
		
		return cookieValue;
	}
	/*
	public static String getCookie(String cookie) {
		// "userId=brown; remeberme=true; test=testValue";
		// cookie = "userId"
		String str = "userId=brown; remeberme=true; test=testValue";
		String[] arr = str.split("; ");
//		String result1 = str.substring(str.lastIndexOf("=")+1);
//		String result2 = (String) str.subSequence(str.indexOf("=")+1, str.indexOf(";"));
		String result = "";
		if(cookie.equals("")){
			return result;
		}
		for(int i=0;i<=arr.length;i++){
			cookie = arr[i].substring(arr[i].indexOf("="));
			result = arr[i].substring(arr[i].lastIndexOf("=")+1);
			
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(CookieUtil.getCookie("userId"));
	}
	*/
	
	
}
