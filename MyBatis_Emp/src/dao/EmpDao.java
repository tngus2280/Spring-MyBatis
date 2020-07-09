package dao;

import java.util.List;

import dto.Emp;

public interface EmpDao {
	
	//Emp 테이블 전체 조회
	public List<Emp> selectAll();
	
	//사원번호를 이용한 조회 ( String)
	public Emp selectByEmpNo(Emp selectEmp);

	//정보 입력
	public void insert(Emp insertEmp);
	
	// 정보 삭제
	public void delete(Emp deleteEmp);
	
//	public void deleteByEmpno(int empno);
	
}
