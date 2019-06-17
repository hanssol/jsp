package kr.or.ddit.db.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.dao.DbDao;
import kr.or.ddit.db.dao.IDbDao;
import kr.or.ddit.db.model.DbVo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(DbDaoTest.class);
	IDbDao dao;
	
	@Test
	public void dbListTest() {
		/***Given***/
		dao = new DbDao();

		/***When***/
		List<DbVo> dbList = dao.getUriClassMapping();
		
		/***Then***/
		logger.debug("dbList : {}",dbList );
		assertEquals(2, dbList.size());
	}

}
