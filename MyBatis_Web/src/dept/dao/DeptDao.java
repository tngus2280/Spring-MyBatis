package dept.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dept.dto.Dept;

public interface DeptDao {

	//전체 조회
	public List<Dept> selectAll();

	//지정된 부서정보 조회
	public Dept selectInfo(Dept dept);

	//부서 정보 삽입
	public void insert(Dept dept);

	//부서 정보 삭제
	public void delete(Dept dept);


	
}
