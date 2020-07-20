package dept.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import dept.dao.DeptDao;
import dept.dao.DeptDaoImpl;
import dept.dto.Dept;

@WebServlet("/dept/detail")
public class DeptDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("get");
		//전ㄴ달 파라미터 추출- deptno
		String param = req.getParameter("deptno");
		int deptno = 0;
		if(param!=null && !"".equals(param)){
			deptno = Integer.parseInt(param);
		}
		
		//deptno.DTO로 전달값 저장
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		
		//상세정보 조회 결과 얻기
		Dept result = deptDao.selectInfo(dept);
		
		
		
		
		req.setAttribute("result", result);
		
		
		req.getRequestDispatcher("/WEB-INF/views/dept/detail.jsp").forward(req, resp);
		
	}
	
	
	
}
