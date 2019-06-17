package kr.or.ddit.db.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.model.DbVo;
import kr.or.ddit.db.service.DbService;
import kr.or.ddit.db.service.IDbService;

import org.junit.Test;

public class DbServiceTest {

	@Test
	public void dbListTest() {
		/***Given***/
		IDbService dbService = new DbService();

		/***When***/
		List<DbVo> dbList = dbService.getUriClassMapping();
		/***Then***/
		assertEquals(2, dbList.size());

	}

}
