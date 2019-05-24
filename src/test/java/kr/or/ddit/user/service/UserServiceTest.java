package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	

}
