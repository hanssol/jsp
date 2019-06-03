package kr.or.ddit.util;

import java.security.acl.LastOwnerException;
import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(PartUtil.class);
	/**
	 * 
	 * Method : getFileName
	 * 작성자 : PC03
	 * 변경이력 :
	 * @param contentDisposition
	 * @return
	 * Method 설명 : contentDisposition에서 파일명을 반환한다.
	 */
	public static String getFileName(String contentDisposition) {
		// form-data; name="profile"; filename="Desert.jpg"
		String[] slice = contentDisposition.split("; ");
		
		
		for(String str : slice){
			if(str.startsWith("filename=")){
				int start = str.indexOf("\"")+1;
				int end = str.lastIndexOf("\"");
				return str.substring(start, end);
			}
		}
		
		return "";
	}
	
	// uuid test
	@Test
	public void uuidTest(){
		
		/***Given***/
		
		/***When***/
		logger.debug("UUID.randomUUID().toString() : {}", UUID.randomUUID().toString());
		
		/***Then***/

	}
	/**
	 * 
	 * Method : getExt
	 * 작성자 : PC03
	 * 변경이력 :
	 * @param fileName
	 * @return
	 * Method 설명 : 파일명으로부터 파일 확장자를 반환
	 */
	public static String getExt(String fileName) {
		String[] splited = fileName.split("[.]");
		if(splited.length == 1){
			return "";
		}else{
			return splited[splited.length-1];
			
		}
		
	}

}
