<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>부서 정보 목록</h1>
<hr>

<table>

<thead>
<tr>
	<td>부서번호</td>
	<td>부서이름</td>
	<td>위치</td>
</tr>
</thead>
<tbody>
<c:forEach items="${deptList }" var="dept">
<tr>
	<td><a href="/dept/detail?deptno=${dept.deptno }">${dept.deptno }</a></td>
	<td>${dept.dname }</td>
	<td>${dept.loc }</td>


</tr>
</c:forEach>
</tbody>

</table>
<br>
<a href="/dept/insert"><button>부서등록</button></a>


</body>
</html>
