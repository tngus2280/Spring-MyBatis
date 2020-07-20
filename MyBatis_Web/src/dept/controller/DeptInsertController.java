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

@WebServlet("/dept/insert")
public class DeptInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		//VIEW 지정 -
		req.getRequestDispatcher("/WEB-INF/views/dept/insert.jsp").forward(req, resp);
	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달 파라미터를 저장할 DTO
		Dept dept = new Dept();
		
		//전달파라미터 추출 - deptno
		String param = req.getParameter("deptno");
		int deptno = 0;
		
		if(param!=null && !"".equals(param)){
			deptno = Integer.parseInt(param);
		}
		dept.setDeptno(deptno);
		//전달파라미터 추출 - dname
		dept.setDname(req.getParameter("dname"));
		//전달파라미터 추출 - loc
		dept.setLoc(req.getParameter("loc"));
		
		//데이터 삽입
		deptDao.insert(dept);
		
		//목록페이지로 리다이렉션
		resp.sendRedirect("/dept/list");
	
	}
	
}
