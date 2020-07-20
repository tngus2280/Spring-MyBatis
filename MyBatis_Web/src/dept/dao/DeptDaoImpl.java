package dept.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dept.dto.Dept;
import mybatis.MyBatisConnectionFactory;

public class DeptDaoImpl implements DeptDao {

	//마이바티스 객체 생성
	private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	private String namespace = "dept.dao.DeptDao.";
	
	
	@Override
	public List<Dept> selectAll() {

		// 마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
		
		//DB조회 결과
		List<Dept> deptList = sqlSession.selectList(namespace+"selectAll");// 매퍼에 있는 namespace를 써주고 태그의 id까지 써준다
		
//		sqlSession.commit();
//		sqlSession.clearCache();
		sqlSession.close();
		
		return deptList;
	}


	@Override
	public Dept selectInfo(Dept dept) {

		// 마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
		
		//DB조회 결과
		Dept result = sqlSession.selectOne(namespace+"selectInfo",dept);
		
		//마이바티스 객체 닫기
		sqlSession.close();
				
		//결과 반환
		return result;
	}


	@Override
	public void insert(Dept dept) {
		// 마이바티스 수행 객체
		SqlSession sqlSession = factory.openSession();
		
		
		//SqlSession.insert 는 테이블의 영향받은 행 수를 반환한다
		// update, delete도 마찬가지
		
		int res=sqlSession.insert(namespace+"insert",dept);
		
		if(res>0) {
			System.out.println("삽입 성공");
		}else {
			System.out.println("삽입 실패");
		}
		
		sqlSession.commit();
		
		
	}


	@Override
	public void delete(Dept dept) {

		SqlSession sqlSession = factory.openSession();
		
		int res=sqlSession.delete(namespace+"delete",dept);
		
		if(res>0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		
		sqlSession.commit();
		
	}

	
}
