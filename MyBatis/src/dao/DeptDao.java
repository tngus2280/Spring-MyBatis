package dao;

import java.util.List;

import dto.Dept;

public interface DeptDao {

	//부서번호를 이용한 부서정보 조회
	public Dept selectByDeptno(int deptno);

	//부서정보 전체 조회
	public List<Dept> selectAll();

	//부서명을 이용한 조회 - String 타입
	public Dept selectByDname(String str);
	
	// 부서명을 이용한 조회 - Dept 타입
	public Dept selectByDept(Dept data);

	// 부서정보 삽입
	public void insert(Dept insertDept);
}
