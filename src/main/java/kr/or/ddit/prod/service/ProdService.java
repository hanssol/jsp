package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.model.ProdVo;

public class ProdService implements IProdService{

	IProdDao dao = new ProdDao();
	
	@Override
	public List<ProdVo> prodList(String prod_lgu) {
		return dao.prodList(prod_lgu);
	}

}
