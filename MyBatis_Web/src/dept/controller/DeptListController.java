package dept.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.dao.DeptDaoImpl;
import dept.dto.Dept;

@WebServlet("/dept/list")
public class DeptListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptDao deptDao = new DeptDaoImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("/dept/list [GET]");
	
		//부서 정보 전체 조회
		List<Dept> deptList = deptDao.selectAll();
		
		//Model 값 전달
		req.setAttribute("deptList", deptList);
		
		//VIEW 지정 -
		req.getRequestDispatcher("/WEB-INF/views/dept/list.jsp").forward(req, resp);
		
	}
	
	
	
	
	
	
}
