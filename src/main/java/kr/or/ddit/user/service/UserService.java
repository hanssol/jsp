package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IuserService{
	IuserDao dao;
	
	public UserService(){
		dao = new UserDao();
	}
	/**
	 * 
	 * Method : userList
	 * 작성자 : PC03
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVo> userList() {
//		
//		// db에서 데이터를 조회했다고 가정
//		List<UserVo> userList = new ArrayList<UserVo>();
//		// 브라운, 샐리 , 제임스
//		userList.add(new UserVo("브라운","brown","곰"));
//		userList.add(new UserVo("샐리","sally","병아리"));
//		userList.add(new UserVo("코니","cony","토끼"));
//		userList.add(new UserVo("제임스","james","사람"));
//		userList.add(new UserVo("문","moon","달"));
//		
		return dao.userList();
	}

	@Override
	public UserVo getUser(String userId) {
		return dao.getUser(userId);
	}

	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		
		// 1. List<UserVo>, userCnt를 필드로 하는 vo
		// 2. List<Object> resultList = new ArrayList<Object>();
		//		resultList.add(userList);
		//		resultList.add(usersCnt);
		// 3. Map<String, Object> resultMap = new Hashmap<String, Object>();
		//		resultMap.put("userList","userList);
		//		resultMap.put(usersCnt,usersCnt);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", dao.userPagingList(pageVo));
		
		// usersCnt --> paginationSize 변경
		// resultMap.put("usersCnt", dao.usersCnt());
		int usersCnt = dao.usersCnt();
		// pageSize --> pageVo.getPageSize();
		
		int paginationSize = (int) Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}
	@Override
	public int insertUser(UserVo userVo) {
		return dao.insertUser(userVo);
	}
	
	@Override
	public int deleteUser(String userId) {
		return dao.deleteUser(userId);
	}
	@Override
	public int modifyUser(UserVo userVo) {
		
		return dao.modifyUser(userVo);
	}
	
}









