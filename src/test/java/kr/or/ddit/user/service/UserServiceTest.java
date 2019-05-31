package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {
	
	// 사용자 전체리스트를 조회 하는 메소드
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	private IuserService userservice;
	@Before
	public void setup(){
		userservice = new UserService();

		
		logger.debug("setup");
	}
	
	@Test
	public void userListTest() {
		/***Given***/
		userservice = new UserService();

		/***When***/
		List<UserVo> userList = userservice.userList();
		/***Then***/
		logger.debug("userList : {}",userList );

	}
	
	@Test
	public void getUser(){
		/***Given***/
		userservice = new UserService();
		String userId = "brown";
		/***When***/
		UserVo userVo = userservice.getUser(userId);
		/***Then***/
		assertEquals("브라운", userVo.getName());
		logger.debug("userVo : {}", userVo);
	}
	
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);
		

		/***When***/
		Map<String, Object> resultMap = userservice.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int pagination = (Integer)resultMap.get("paginationSize");
		
		/***Then***/
		// pagingList assert
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		// usersCnt assert
		assertEquals(11, pagination);
		
	}
	@Test
	public void ceilTest(){
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;
		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		logger.debug("paginationSize : {}", paginationSize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);

	}
	
	
	/**
	 * 
	 * Method : insertUserTest
	 * 작성자 : PC03
	 * 변경이력 :
	 * Method 설명 : 사용자 등록, 삭제 테스트
	 */
	@Test
	public void insertUserTest(){
		/***Given***/
		// 사용자정보를 담고 있는 vo객체 준비
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		UserVo userVo = null;
		
		try {
			userVo = new UserVo("대덕인","userTest","중앙로","userTest1234","대전광역시 중구 중앙로76","영민빌딩 2층 204호","34940",sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/***When***/
		// userDao.insertUser()
		int insertCnt = userservice.insertUser(userVo);
		
		/***Then***/
		// insertCnt(1)
		assertEquals(1, insertCnt);
		
		// data 삭제
		// userDao.deleteUser(usreId);
		int deleteCnt = userservice.deleteUser(userVo.getUserId());
		
		assertEquals(1, deleteCnt);
		
		
	}
	
	
	

}














