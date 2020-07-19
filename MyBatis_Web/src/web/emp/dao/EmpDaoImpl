package emp.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import emp.dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpDaoImpl implements EmpDao{

	//마이바티스 객체 생성
		private SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		
		private String namespace = "emp.dao.EmpDao.";
	
	@Override
	public List<Emp> selectAll() {

		SqlSession sqlSession = factory.openSession(true);
		
		List<Emp> empList = sqlSession.selectList(namespace+"selectAll"); 
		
		
		
		
		
		return empList;
	}

	@Override
	public Emp selectEmpno(Emp emp) {

		
		SqlSession sqlSession = factory.openSession(true);
		
		Emp result = sqlSession.selectOne(namespace+"selectEmpno",emp);
		
		
		
		return result;
	}

	@Override
	public void insert(Emp emp) {
		
		SqlSession sqlSession = factory.openSession(true);
		
		sqlSession.insert(namespace+"insert",emp);
	}

}
