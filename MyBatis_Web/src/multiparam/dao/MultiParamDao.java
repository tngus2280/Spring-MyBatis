package multiparam.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

import web.dto.Emp;

public interface MultiParamDao {
	
	//DTO를 전달받아 마이바티스 이용
	public void insert(Emp emp);

	//여러개의 인자로 매개변수 전달
	public void insert2(
			@Param("e1") int empno, 
			@Param("e2") String ename, 
			@Param("e3") String job);

	//하나의 DTO로 표현하기 힘든 여러 개의 인자를 HashMap으로 묶어서 전달
	public void insert3(HashMap<String, Object> map);

}
