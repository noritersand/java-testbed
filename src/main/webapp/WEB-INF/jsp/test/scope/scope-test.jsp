<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/resources/js/jquery-1.12.4.js"></script>
<title>scope test</title>
</head>
<body>
<h2>servlet scope test</h2>
<p>아래 버튼을 누르고 페이지 새로고침 해보면...</p>
<button type="button" onclick="setAttributes()">setAttributes</button><br>
a: ${pageScope.page}<br>
b: ${b}<br>
c: ${sessionScope.c}<br>
d: ${applicationScope.d}<br>
<h4>설명:</h4>
<ul>
	<li>a는 설정하지 않았으므로 나오지 않음</li>
	<li>b는 매 요청마다 초기화되므로 나오지 않음</li>
	<li>c는 버튼 누른 후 브라우저를 닫을때까지 계속 나옴</li>
	<li>d는 버튼 누른 후 서버 내려갈때까지 다른 브라우저에서도 계속 나옴</li> 	
</ul>
<script>
	function setAttributes() {
		$.post('/test/scope/setAttributes.data', function(response) {
			console.log(JSON.stringify(response));
		});
	}
</script>
</body>
</html>