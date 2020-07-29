package selectKey.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.MyBatisConnectionFactory;
import selectKey.dao.SelectKeyDao;
import selectKey.dto.TestMember;

@WebServlet("/mybatis/selectKey")
public class SelectKeyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//마이바티스 연결 객체
	private SqlSessionFactory factory
	= MyBatisConnectionFactory.getSqlSessionFactory();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/mybatis/selectKey.jsp")
		.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TestMember tm = new TestMember();
		tm.setId( req.getParameter("id") );
		tm.setPw( req.getParameter("pw") );
		
		System.out.println("SelectKeyController [POST] - " + tm);
		
		SqlSession sqlSession = factory.openSession(true); //Auto commit
		
		SelectKeyDao selectKeyDao = sqlSession.getMapper(SelectKeyDao.class);
		
		selectKeyDao.insert(tm);

		req.setAttribute("tm", tm);
		req.getRequestDispatcher("/WEB-INF/views/mybatis/selectKeyResult.jsp")
		.forward(req, resp);
		
	}
	
}


