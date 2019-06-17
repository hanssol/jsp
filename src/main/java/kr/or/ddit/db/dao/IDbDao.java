package kr.or.ddit.db.dao;

import java.util.List;

import kr.or.ddit.db.model.DbVo;

public interface IDbDao {
	List<DbVo> getUriClassMapping();
}
