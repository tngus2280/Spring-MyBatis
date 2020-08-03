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

@WebServlet("/emp/selectname")
public class EmpSelectNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpDao empDao = new EmpDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("select");
	
		//전달 파라미터를 추출할 DTO
		Emp emp = new Emp();
		
		emp.setEmpno(Integer.parseInt(req.getParameter("empno")));
		
		
		Emp result = empDao.selectEmpno(emp);
	
		req.setAttribute("result", result);
		
		req.getRequestDispatcher("/WEB-INF/views/test/name.jsp").forward(req, resp);
		
		System.out.println(result);
		
	}
	
	
	
	
}
