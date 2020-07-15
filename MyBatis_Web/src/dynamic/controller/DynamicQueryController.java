package dynamic.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dynamic.dao.DynamicQueryDao;
import mybatis.MyBatisConnectionFactory;
import web.dto.Emp;

@WebServlet("/dynamic/query")
public class DynamicQueryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//마이바티스 연결 객체
	private SqlSessionFactory factory
	= MyBatisConnectionFactory.getSqlSessionFactory();

	//마이바티스 수행 객체
	private SqlSession sqlSession;
	
	//DAO 객체
	private DynamicQueryDao dynamicQueryDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		sqlSession = factory.openSession(true);
		dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);

		// ------------------------------------------------------------
		
//		List<HashMap<String,Object>> list = dynamicQueryDao.select();
		
//		for (Object object : list) {
//			System.out.println(object);
//		}
		
//		req.setAttribute("list", list);
//		req.getRequestDispatcher("/WEB-INF/views/dynamic/query.jsp")
//		.forward(req, resp);
		
		// ------------------------------------------------------------
		
//		List res2 = dynamicQueryDao.select2( "S" );
//		System.out.println(res2);
		
		// ------------------------------------------------------------
		
//		Emp emp = new Emp();
//		emp.setEmpno(7369);
//		emp.setEname("KING");
//		
//		List res3 = dynamicQueryDao.select3( emp );
//		System.out.println(res3);
		
		// ------------------------------------------------------------
		
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("category", "ename");
//		map.put("keyword", "FORD");
//		
//		List<Emp> res4 = dynamicQueryDao.select4(map);
//		
//		System.out.println(res4);
//
//		System.out.println("----------");
//		
//		map.put("category", "job");
//		map.put("keyword", "SALESMAN");
//		
//		List<Emp> res5 = dynamicQueryDao.select4(map);
//		
//		System.out.println(res5);

		// ------------------------------------------------------------
		
		req.getRequestDispatcher("/WEB-INF/views/dynamic/queryCheckbox.jsp")
		.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		sqlSession = factory.openSession(true);
		dynamicQueryDao = sqlSession.getMapper(DynamicQueryDao.class);

		// ------------------------------------------------------------

		//전달 파라미터가 하나의 값일 때만 getParameter를 써야함 
//		String data = req.getParameter("deptno");
//		System.out.println( data ); //전달된 데이터 중 한 개만 꺼내옴
		
		//------------------------------------------------------------
		
		String[] dataArr = req.getParameterValues("deptno");
		System.out.println( Arrays.toString(dataArr) );
	
		HashMap<String, Object> map = new HashMap<>();
		map.put("deptnoArr", dataArr);
		
		List<Emp> list = dynamicQueryDao.selectCheckbox( map );
	
		for (Emp emp : list) {
			System.out.println(emp);
		}
		
		sqlSession.clearCache();
		
		req.setAttribute("list", list);
		req.getRequestDispatcher("/WEB-INF/views/dynamic/resultCheckbox.jsp").forward(req, resp);
		
	}
}
