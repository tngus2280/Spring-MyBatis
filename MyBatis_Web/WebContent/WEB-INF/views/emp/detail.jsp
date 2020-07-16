<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>사원 상세 정보</h1>
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
<tr>
	<td>${result.empno }</td>
	<td>${result.ename }</td>
	<td>${result.job }</td>
	<td>${result.mgr }</td>
	<td>
		<fmt:formatDate value="${result.hiredate }" pattern="yyyyMMdd"/><br>	
		<fmt:formatDate value="${result.hiredate }" pattern="HHmmss"/>	
	</td>
	<td>${result.sal }</td>
	<td>${result.comm }</td>
	<td>${result.deptno }</td>
</tr>
</tbody>
</table>

</body>
</html>
