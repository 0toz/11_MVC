package com.ict.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	// MyBatis에서는 SQLsession을사용한다. 클래스를 이용해서  mapper.xml 파일의 태그들을 사용해서 SQL를 사용한다.
	// 
	
	private static SqlSession ss;
	private synchronized static SqlSession getSession() {
		if(ss==null) {
			ss = DBService.getFactory().openSession(); //select문 커밋을 해도되고안해도된다. DB가 바뀌는 것이 아니기 때문.
			ss = DBService.getFactory().openSession(true);//AutoCommit(); 트랜젝션 처리를 못함.)
			ss = DBService.getFactory().openSession(false);//수동 Commit(); 
		}
		return ss;
	}


	// DB 접속
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@192.168.0.4:1521:xe";
			String user = "c##ictedu";
			String password = "1111";
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// MyBatis select문은 4가지로 구분된다.
	// 결과가 여러개 일때 list<VO>
	//결과가 하나일 때  VO
	// 파라미터 값이 있을 때(파라미터가 두개이상이면 VO아니면 map을 사용해야한다. 
	// 파라미터 값이 없을 때
	public static List<VO> getSelectAll() {
		try {
			List<VO> list = new ArrayList<VO>();
			//getSessionn().sql 명령과 같은 메소드 차직
			//list = getSession().selectList(mapper의 아이디를 스트롱으로 작성); 파라미터가 없는 메소드
			//list = getSession().selectList(null, 파라미터); 파라미터가 있는 메소드
			list = getSession().selectList("list");
			return list;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return null;
	}

	// insert
	public int getInsert(VO vo) {
		try {
			int result = 0;
			conn = getConnection();
			String sql = "insert into guestbook values(guestbook_seq.nextval,?,?,?,?,?,sysdate)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getName());
			pstm.setString(2, vo.getSubject());
			pstm.setString(3, vo.getContent());
			pstm.setString(4, vo.getEmail());
			pstm.setString(5, vo.getPwd());
			result = pstm.executeUpdate();
			return result;
		} catch (Exception e) {
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return 0;
	}

	// 상세보기
	public static VO getSelectOne(String idx) {
		try {
			VO vo = null;
			conn = getConnection();
			String sql = "select * from guestbook where idx=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idx);
			rs = pstm.executeQuery();
			while (rs.next()) {
				vo = new VO();
				vo.setIdx(rs.getString("idx"));
				vo.setName(rs.getString("name"));
				vo.setSubject(rs.getString("subject"));
				vo.setContent(rs.getString("content"));
				vo.setEmail(rs.getString("email"));
				vo.setPwd(rs.getString("pwd"));
				vo.setRegdate(rs.getString("regdate"));
			}
			return vo;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				rs.close();
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return null;
	}

	// update
	public int getUpdate(VO vo) {
		try {
			int result = 0;
			conn = getConnection();
			String sql = "update guestbook set name=?,subject=?,content=?,email=? where idx=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, vo.getName());
			pstm.setString(2, vo.getSubject());
			pstm.setString(3, vo.getContent());
			pstm.setString(4, vo.getEmail());
			pstm.setString(5, vo.getIdx());
			result = pstm.executeUpdate();
			return result;
		} catch (Exception e) {
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return 0;
	}

	// delete
	public int getDelete(String idx) {
		try {
			int result = 0;
			conn = getConnection();
			String sql = "delete from guestbook where idx=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idx);
			result = pstm.executeUpdate();
			return result;
		} catch (Exception e) {
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return 0;
	}
}
