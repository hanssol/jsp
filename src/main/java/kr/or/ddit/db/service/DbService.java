package kr.or.ddit.db.service;

import java.util.List;

import kr.or.ddit.db.dao.DbDao;
import kr.or.ddit.db.dao.IDbDao;
import kr.or.ddit.db.model.DbVo;

public class DbService implements IDbService{
	IDbDao dao = new DbDao();
	
	
	@Override
	public List<DbVo> getUriClassMapping() {
		return dao.getUriClassMapping();
	}

}
