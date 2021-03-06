package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements IuserDao{
	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	public static void main(String[] args) {
		
		/***Given***/
		IuserDao userDao = new UserDao();

		/***When***/
		List<UserVo> userList = userDao.userList();
		UserVo uservo = userDao.getUser("brown");
		
		/***Then***/
		logger.debug("UserList : {}",userList);
		logger.debug("UserInfo : {}",uservo );
	}
	
	/**
	 * 
	 * Method : userList
	 * 작성자 : PC03
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 조회
	 */

	@Override
	public List<UserVo> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("user.userList");
		sqlSession.close();
		return userList;
	}

	@Override
	public UserVo getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserVo uservo = sqlSession.selectOne("user.userInfo",userId);
		sqlSession.close();
		return uservo;
	}
	
	/**
	 * 
	 * Method : userPagingList
	 * 작성자 : PC03
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public List<UserVo> userPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("user.userPagingList",pageVo);
		sqlSession.close();
		return userList;
	}

	/**
	 * 
	 * Method : usersCnt
	 * 작성자 : PC03
	 * 변경이력 : 
	 * @return
	 * Method 설명 : 사용자 전체수 조회
	 */
	@Override
	public int usersCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int usersCnt = (Integer)sqlSession.selectOne("user.usersCnt");
		sqlSession.close();
		return usersCnt;
	}

	
	/**
	 * 
	 * Method : insertUser
	 * 작성자 : PC03
	 * 변경이력 :
	 * @param iserVo
	 * @return
	 * Method 설명 : 사용자 등록
	 */
	@Override
	public int insertUser(UserVo userVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("user.insertUser",userVo);
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}

	/**
	 * 
	 * Method : deleteUser
	 * 작성자 : PC03
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 : 사용자 삭제
	 */
	@Override
	public int deleteUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int deleteCnt = sqlSession.delete("user.deleteUser",userId);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	/**
	 * 
	 * Method : modifyUser
	 * 작성자 : PC03
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자정보 수정
	 */
	@Override
	public int modifyUser(UserVo userVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int modifyCnt = sqlSession.update("user.modifyUser",userVo);
		sqlSession.commit();
		sqlSession.close();
		return modifyCnt;
	}

	/**
	 * 
	 * Method : userListForPassEncrypt
	 * 작성자 : PC03
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 비밀번호 암호화 적용대상 사용자 전체 조회
	 */
	@Override
	public List<UserVo> userListForPassEncrypt(SqlSession sqlSession) {
		
		return sqlSession.selectList("user.userListForPassEncrypt");
	}

	/**
	 * 
	 * Method : modifyUserEncryptPass
	 * 작성자 : PC03
	 * 변경이력 :
	 * @param sqlSession
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 비밀번호 암호화 적용
	 */
	@Override
	public int modifyUserEncryptPass(SqlSession sqlSession, UserVo userVo) {
		
		return sqlSession.update("user.updateUserEncryptPass", userVo);
	}
	
	
}
