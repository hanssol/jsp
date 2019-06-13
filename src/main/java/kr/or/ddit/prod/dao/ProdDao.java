package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.prod.model.ProdVo;

public class ProdDao implements IProdDao {

	@Override
	public List<ProdVo> prodList(String prod_lgu) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<ProdVo> prodList = sqlSession.selectList("prod.prodInfo",prod_lgu);
		sqlSession.close();
		return prodList;
	}

}
