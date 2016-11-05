<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">영은이 게시판</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">로그인</a></li>
						<li><a href="#">회원가입</a></li>
					</ul>
					<form class="navbar-form navbar-right">
						<input type="text" class="form-control" placeholder="Search...">
					</form>
				</div>
			</div>
		</nav>
		
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">첫번째 게시판</a></li>
					<li><a href="#">두번째 게시판</a></li>
					<li><a href="#">세번째 게시판</a></li>
				</ul>
			</div>
			
			
		</div>
		    
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<h1 class="page-header">영은이 게시판</h1>
		
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="seq">번호</th>
							<th class="title">제목</th>
							<th class="writer">글쓴이</th>
							<th class="regdate">날짜</th>
							<th class="hit">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="seq">1</td>
							<td class="title"><a href="#">제목1</a></td>
							<td class="writer">관리자</td>
							<td class="regdate">2016/10/19</td>
							<td class="hit">0</td>
						</tr>
						<tr>
							<td class="seq">2</td>
							<td class="title"><a href="#">제목2</a></td>
							<td class="writer">관리자</td>
							<td class="regdate">2016/10/19</td>
							<td class="hit">0</td>
						</tr>
						<tr>
							<td class="seq">3</td>
							<td class="title"><a href="#">제목3</a></td>
							<td class="writer">관리자</td>
							<td class="regdate">2016/10/19</td>
							<td class="hit">0</td>
						</tr>
						<tr>
							<td class="seq">4</td>
							<td class="title"><a href="#">제목4</a></td>
							<td class="writer">관리자</td>
							<td class="regdate">2016/10/19</td>
							<td class="hit">0</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	</body>
</html>