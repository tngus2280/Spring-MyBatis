<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서 정보 입력</h1>
<hr>

<form action="/dept/insert" method="post" >

<label>부서번호<input type="text" name="deptno"></label><br>
<label>부서이름<input type="text" name="dname"></label><br>
<label>지역<input type="text" name="loc"></label><br>
<a href="/dept/list"><button>전송</button></a>
</form>
</body>
</html>
