<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/addbook" method="post">
<label>Title</label>
<input type="text" name="title">
<label>Author</label>
<input type="text" name="author">
<label>Publisher</label>
<input type="text" name="publisher">

<input type="submit" value="Submit" >
</form>
</body>
</html>