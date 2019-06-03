package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartUtilTest {

	@Test
	public void getFileNametest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"Desert.jpg\"";
		

		/***When***/
		String fileName = PartUtil.getFileName(contentDisposition);
		
		/***Then***/
		assertEquals("Desert.jpg", fileName);

	}
	
	@Test
	public void getExtTest(){
		/***Given***/
		String filename = "sally.png";
		String filename2 = "sally.pictur.png";
		String filename3 = "sally";
		
		/***When***/
		String ext = PartUtil.getExt(filename);
		String ext2 = PartUtil.getExt(filename2);
		String ext3 = PartUtil.getExt(filename3);
		
		/***Then***/
		assertEquals(".png", ext);
		assertEquals(".png", ext2);
		assertEquals("",ext3);
	}
	
	@Test
	public void subStringTest(){
		/***Given***/
		String yyyyMM = "201906";

		/***When***/
		String yyyy = yyyyMM.substring(0,4);
		String mm = yyyyMM.substring(4,6);
		/***Then***/
		assertEquals("2019", yyyy);
		assertEquals("06", mm);
	}
	
	
	
}
