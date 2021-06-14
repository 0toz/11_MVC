package com.ict.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// config.xml를 읽어서 MYBatis가 DB에 접근하고 실행 할 수 있도록 도와주는 클래스
// 자바가 


public class DBService {

	public private SqlSessionFactory factory;

	static {
		try {
			factory = new SqlSessionFactoryBuilder()
					.build(org.apache.ibatis.io.Resources.getResourceAsReader("com/ict/db/config.xml"));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static SqlSessionFactory getFactory() {
		return factory;
		
	}
	
	
}
