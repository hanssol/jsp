package kr.or.ddit.db.service;

import java.util.List;

import kr.or.ddit.db.model.DbVo;

public interface IDbService {
	List<DbVo> getUriClassMapping();
}
