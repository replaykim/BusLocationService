
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>지도 Test</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<div id="divBody">
		<h1>버스 실시간 위치 정보 시스템</h1>

		<div id='divLocation'></div>
		<div id="divMap"></div>
	</div>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="//apis.daum.net/maps/maps3.js?apikey=e6f5ebdaa58a495eb00c9a904fb8f425"></script>
	<script src="javascript/data.js"></script>
	<script src="javascript/map.js"></script>
	<script type="text/javascript" id="getData"></script>

</body>
</html>