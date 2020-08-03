package emp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dao.EmpDao;
import emp.dao.EmpDaoImpl;
import emp.dto.Emp;

@WebServlet("/emp/in")
public class EmpInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpDao empDao = new EmpDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("in");
		
		req.getRequestDispatcher("/WEB-INF/views/test/in.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		//전달 파라미터를 추출할 DTO
		Emp emp = new Emp();
		
		emp.setEmpno(Integer.parseInt(req.getParameter("empno")));
	
		emp.setEname(req.getParameter("ename"));
		emp.setJob(req.getParameter("job"));
		
		empDao.insert(emp);
		resp.sendRedirect("/emp/selectall");
		
	
	}
	
	
	
}
