package dept.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.dao.DeptDaoImpl;
import dept.dto.Dept;

@WebServlet("/dept/delete")
public class DeptDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptDao deptDao = new DeptDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터를 추출할 DTO
		Dept dept = new Dept();
		
		dept.setDeptno(Integer.parseInt(req.getParameter("deptno")));
		
		
		deptDao.delete(dept);
		
		resp.sendRedirect("/dept/list");
	
	}
	
	
}
