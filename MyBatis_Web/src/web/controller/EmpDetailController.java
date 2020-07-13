package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Emp;
import web.service.EmpService;
import web.service.EmpServiceImpl;

@WebServlet("/emp/detail")
public class EmpDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService empService = new EmpServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/emp/detail [GET]");
	
		//전달 파라미터 얻기 empno
		Emp param = empService.getEmpnoParam(req);
		System.out.println("EmpDetailController - " + param);
		
		//상세보기 결과 조회 - EmpService
		Emp res = empService.getEmpDetail(param);
		
		//조회결과 MODEL값 전달
		req.setAttribute("res", res);
		
		//View 지정
		req.getRequestDispatcher("/WEB-INF/views/emp/detail.jsp").forward(req, resp);
		
	}
	

}
