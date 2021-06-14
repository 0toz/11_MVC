package com.ict.db;

public class Mybatis {
	/*
	  개발자가 지정한 SQL, 저장프로시저 그리고 몇가지 고급 매핑을 지원하는 퍼시스턴스 프레임워크이다.
	  즉, 자바 SQL  프레임 워크이다.(SQL Mapping Framework for Java)
	  MyBatis 다운로드 후 압축해제한 후에 WEB-INF-lib안에 라이브러리 넣어준다.
	  
	  5개 파일이 필요한다.: DAO, VO, DBService, config.xml, mapper.xml
	  - VO : DB 정보를 담는 객체 (해당 변수가 DB컬러명과 같아야 한다.)
	  - DAO : DB에 접근해서 검색, 삽입, 삭제 , 수정 할 수 있도록 지원하는 객체
	  - DBService : config.xml를 읽어서 MyBatis가 DB에 접근 하고 실행할 수 있도록 도와 주는 클래스
	  - config.xml : DB 접근할 수 있는 환경 설정 과 실제  DB 처리해서 결과를 얻어내는 mapper.xml의 
	                 위치를 지정해주는 환경설정 파일
	  - mapper.xml : 실제 DB처리하고 결과를 얻어내는 역할하는 xml 파일
	                 DAO에서 mapper.xml를 호출해서 사용한다.
	                 
	   - mapper.xml의 내용 
	     xml는  태그로 구성 되어 있다.
	     HTML태그를 사용하는 것이라 자기만의 고유 태그를 만들어서 사용한다.
	     자기만의 고유태그에게 의미를 부여하기 위해서는 DTD라는 문서를 만들어야 하는데
	     MyBatis에 만든 DTD문서를 활용해서 고유 태그를 사용한다.
	     고유태그에는 <select>, <update>, <delete>, <insert>태그등이 있다.
	     
	     
	     id : DAO에서 mapper를 호출할때 사용하는 이름
	     parameterType : 파라미터 타입을 작성하면 된다.
	     resultType : select문 에대한 결과 타입인데 90%이상 VO타입 이다.
	     
	     
	     <select id="" resultType="" parmeterType="">
	         실제 sql 구문 작성 (PreparedStatement 에서 사용하는 ? 대신 #{} 사용하면 된다.)
	     </select>
	     
	     insert, update, delete 태그는 id와 parameterType 만 존재, resultType는 없다.(이유: 결과 항상 숫자이다.) 
	     <insert id="" parameterType="">
	     	 실제 sql 구문 작성(? 대신 #{} )
	     </insert>
	     <update id="" parameterType="">
	     	 실제 sql 구문 작성(? 대신 #{} )
	     </update>
	      <delete id="" parameterType="">
	     	 실제 sql 구문 작성(? 대신 #{} )
	     </delete>                                
	 */
	}




}
