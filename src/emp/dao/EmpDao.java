package emp.dao;

import java.util.List;

import emp.dto.Emp;


public interface EmpDao {

	public List<Emp> selectAll();

	public Emp selectEmpno(Emp emp);

	public void insert(Emp emp);

}
