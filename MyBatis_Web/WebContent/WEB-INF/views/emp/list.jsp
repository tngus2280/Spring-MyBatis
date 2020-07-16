<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>사원 전체 목록</h1>
<hr>

<table border="1">
<thead>
<tr>
	<td>사원번호</td>
	<td>이름</td>
	<td>직무</td>
	<td>매니저</td>
	<td>입사일</td>
	<td>급여</td>
	<td>상여금</td>
	<td>부서번호</td>
</tr>
</thead>

<tbody>
<c:forEach items="${list}" var="emp">
<tr>
	<td>${emp.empno }</td>
	<td><a href="/emp/detail?empno=${emp.empno}">${emp.ename }</a></td>
	<td>${emp.job }</td>
	<td>${emp.mgr }</td>
<%-- 	<td>${emp.hiredate }</td> --%>
	<td>
		<fmt:formatDate value="${emp.hiredate }" pattern="yyyyMMdd"/><br>	
		<fmt:formatDate value="${emp.hiredate }" pattern="HHmmss"/>	
	</td>
	<td>${emp.sal }</td>
	<td>${emp.comm }</td>
	<td>${emp.deptno }</td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>
