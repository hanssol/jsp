package kr.or.ddit.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.model.DbVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class DbDao implements IDbDao{

	@Override
	public List<DbVo> getUriClassMapping() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<DbVo> dbList = sqlSession.selectList("db.dbList");
		sqlSession.close();
		return dbList;
	}
	
}
