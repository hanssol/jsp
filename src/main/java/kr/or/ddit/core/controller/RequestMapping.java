package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.controller.MainController;
import kr.or.ddit.controller.UserListController;
import kr.or.ddit.db.model.DbVo;
import kr.or.ddit.db.service.DbService;
import kr.or.ddit.db.service.IDbService;

public class RequestMapping {
	
	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	
	// /main.do -> MainController
	// /userList.do -> UserListController
	
//	private static Map<String, String>requestMappingClass;
	private static Map<String, Controller>requestMapping;
	
	private static IDbService dbService = new DbService();
	
	static{
		List<DbVo> uriClassmappingList = dbService.getUriClassMapping();
		
		requestMapping = new HashMap<String, Controller>();
		
		for(DbVo dbVo : uriClassmappingList){
			// classInfo :  "kr.or.ddit.controller.MainController"
			String classInfo = dbVo.getClassname();
			try {
				Class clazz = Class.forName(classInfo);
			
				Object obj = clazz.newInstance();
				requestMapping.put(dbVo.getUri(), (Controller)obj);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		
//		requestMapping.put("/main.do", new MainController());
//		requestMapping.put("/userList.do", new UserListController());
		
	}
	
	public static Controller getController(String uri) {
		logger.debug("getController : {}", uri);
		return requestMapping.get(uri);
	}

}
