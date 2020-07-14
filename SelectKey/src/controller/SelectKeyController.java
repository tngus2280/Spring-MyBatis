package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dao.SelectKeyDao;
import dto.TestMember;
import mybatis.MyBatisConnectionFactory;

@WebServlet("/mybatis/selectKey")
public class SelectKeyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//마이바티스 수행 객체 생성
	private static SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
			
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET 성공");
		
		//view 지정
		req.getRequestDispatcher("/WEB-INF/views/selectkey.jsp").forward(req, resp);
	}
		

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			TestMember tm = new TestMember();
			tm.setId(req.getParameter("id"));
			tm.setPw(req.getParameter("pw"));
	
			System.out.println(tm);
			
			
			SqlSession sqlSession = factory.openSession(true);
			
			SelectKeyDao selectKeyDao = sqlSession.getMapper(SelectKeyDao.class);
			
			selectKeyDao.insert(tm);
			
			req.setAttribute("tm", tm);
			req.getRequestDispatcher("/WEB-INF/views/selectKeyResult.jsp").forward(req, resp);
//			selectKeyDao.insertFile();
			
			
	}
	
	
	

}
