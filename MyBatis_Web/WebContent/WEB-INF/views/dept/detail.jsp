<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서 상세 </h1>
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
<tr>
	<td>${result.deptno }</td>
	<td>${result.dname }</td>
	<td>${result.loc }</td>
</tr>
</tbody>
</table>
<a href="javascript:history.go(-1)">뒤로가기</a>
<a href="/dept/delete?deptno=${result.deptno }">삭제</a>

</body>
</html>
