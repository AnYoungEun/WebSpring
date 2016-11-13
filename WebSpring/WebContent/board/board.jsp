<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">영은이 게시판</h1>

	<div class="table-responsive">
		<form class="navbar-form navbar-left" action="board.ye" method="get">
			<fieldset>
				<legend class="hidden">
					목록 검색 폼
				</legend>
				<input type="hidden" name="pg" value="" />
				<label for="f" class="hidden">검색필드</label>
				<select name="f" class="form-control">
					<option value="TITLE">제목</option>
					<option value="CONTENTS">내용</option>
				</select>
				<label for="q">검색어</label>
				<input type="text" class="form-control" name="q"/>
				<input type="submit" class="btn btn-primary" value="검색" />
			</fieldset>
		</form>
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
				<c:forEach var="b" items="${list}">
				<tr>
					<td class="seq">${b.idx}</td>
					<td class="title"><a href="#">${b.title}</a></td>
					<td class="writer">${b.creaId}</td>
					<td class="regdate">${b.creaDtm}</td>
					<td class="hit">${b.hitCnt}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<!-- 페이징 임시 -->
		<ul class="pagination">
			<li><a href="board.ye?pg=1&f=${param.f}&q=${param.q}">1</a></li>
			<li><a href="board.ye?pg=2&f=${param.f}&q=${param.q}">2</a></li>
			<li><a href="board.ye?pg=3&f=${param.f}&q=${param.q}">3</a></li>
			<li><a href="board.ye?pg=4&f=${param.f}&q=${param.q}">4</a></li>
			<li><a href="board.ye?pg=5&f=${param.f}&q=${param.q}">5</a></li>
		</ul>
	</div>
</div>