package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {
	
	//마이바티스 수행 객체 생성
	private static SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
	
	public static void main(String[] args) {
		
		//마이바티스 수행 객체
		SqlSession sqlSession = sqlSessionFactory.openSession(true);//true = auto commit 
		//----------------------------------------------------------------------
		
//		sqlSession.selectOne();
//		sqlSession.selectList();
//		sqlSession.selectMap();
//		
//		sqlSession.insert();
//		sqlSession.update();
//		sqlSession.delete();// sql 쿼리수행 메소드
		
		//트랜잭션 관리 메소드
//		sqlSession.commit();
//		sqlSession.rollback();
		
//		sqlSession.close(); // 안해도 자동적으로 close 해준다
		
		// 마이바티스의 매퍼와 자바프로그램의 DAO 인터페이스 매핑(연결)
		// 해당 클래스의 정보를 저장할 수 있는 클래스가 있다 EmpDao의 클래스 정보를 반환해준다
		EmpDao empDao = sqlSession.getMapper(EmpDao.class);
		
		//---------------------------------------------------------------------
		
		Scanner sc = new Scanner(System.in);
		
		//----------------------------------------------------------------------------------
		
		System.out.println("emp 전체 조회");
		// Emp 전체 정보 조회
		List<Emp> list = empDao.selectAll();
		
		for(Emp emp: list) {
			System.out.println(emp);
		}
		
		
		System.out.println("--정보 삽입---------");
		
		Emp insertEmp = new Emp();
		System.out.print("empno:");
		insertEmp.setEmpno(sc.nextInt());
		
		
		sc.nextLine();// 버퍼 비우기
		System.out.print("ename:");
		insertEmp.setEname(sc.nextLine());
		
		System.out.print("job:");
		insertEmp.setJob(sc.nextLine());
		
		System.out.print("mgr:");
		insertEmp.setMgr(sc.nextInt());
		
		
		System.out.println("hiredate(yyyy-MM-dd) : ");
		sc.nextLine();// 버퍼 비우기
		String input = sc.nextLine();
		//String -> java.util.Date : SimpleDateFormat 이용
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate = null;
		try {
			 hiredate = form.parse(input);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		insertEmp.setHiredate(hiredate);
		
		
		
		System.out.print("sal:");
		insertEmp.setSal(sc.nextInt());
		
		System.out.print("comm:");
		insertEmp.setComm(sc.nextInt());
		
		System.out.print("deptno:");
		insertEmp.setDeptno(sc.nextInt());
		
		empDao.insert(insertEmp);
	
		System.out.println("삽입완료");
		
		
		
		System.out.println("----사원번호를 이용한 조회--------------");
		System.out.print(">>사원번호 입력 : ");
		
		Emp empno = new Emp();
		
		empno.setEmpno(sc.nextInt());		
		
		Emp empRes = empDao.selectByEmpNo(empno);
		
		System.out.println(empRes);
		
		
		
		
		System.out.println("--정보 삭제----");
		
		Emp deleteEmp = new Emp();
		
		deleteEmp.setEmpno(sc.nextInt());
		
		empDao.delete(deleteEmp);
		
		
		
		System.out.println("정보 삭제 완료");
		//트랜잭션 커밋
//		sqlSession.commit();
				
	} 
	
}
