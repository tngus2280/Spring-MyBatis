package emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import emp.dao.EmpDao;
import emp.dao.EmpDaoImpl;
import emp.dto.Emp;
import mybatis.MyBatisConnectionFactory;

@WebServlet("/emp/selectall")
public class EmpSelectAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private EmpDao empDao = new EmpDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("qweqwe");
	
	
		List<Emp> list = empDao.selectAll();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/WEB-INF/views/test/list.jsp").forward(req, resp);
		
	}
	
	
	
	
}
