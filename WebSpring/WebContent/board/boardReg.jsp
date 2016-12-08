<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">영은이 게시판</h1>

	<div id="board-article-detail">
		<div class="col-md-7">
			<form action="boardReg.ye" method="post">
				<div class="form-group">
					<label for="title">제목</label>
					<input type="text" name="title" class="form-control" id="title">
				</div>
				<div class="form-group">
					<label for="contents">내용</label>
					<textarea name="contents" class="form-control" rows="5"></textarea>
				</div>
				
				
				<p>
					<input class="btn btn-primary" type="submit" value="저장" />
					<a href="board.ye" class="btn btn-default">취소</a>
				</p>
			</form>	
		</div>
	</div>
</div>