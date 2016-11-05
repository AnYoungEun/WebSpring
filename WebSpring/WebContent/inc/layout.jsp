<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="">
	
		<title>영은이 게시판</title>
		<link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../dashboard.css" rel="stylesheet">
		<link href="../css/base.css" rel="stylesheet">
	</head>
	
	<body>

	<!-- header 부분 -->
	<tiles:insertAttribute name="header"/>

	<!-- aside 부분 -->
	<div class="container-fluid">
		<tiles:insertAttribute name="aside"/>
	</div>


	<!-- content 부분 -->
	<tiles:insertAttribute name="content"/>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	
	</body>
</html>
