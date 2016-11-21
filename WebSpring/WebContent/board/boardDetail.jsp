<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header">영은이 게시판</h1>

	<div id="board-article-detail">
		<div class="row">
			<div class="col-md-12">
				<dl class="dl-horizontal ">
					<dt>
						제목
					</dt>
					<dd>
						${board.title}
					</dd>
				</dl>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6">
				<dl class="dl-horizontal">
					<dt>
						작성일
					</dt>
					<dd>
						${board.creaDtm}
					</dd>
				</dl>
			</div>
			<div class="col-md-6">
				<dl class="dl-horizontal">
					<dt>
						작성자
					</dt>
					<dd>
						${board.creaId}
					</dd>
				</dl>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<dl class="dl-horizontal">
					<dt>
						조회수
					</dt>
					<dd>
						${board.hitCnt}
					</dd>
				</dl>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<dl class="dl-horizontal">
					<dt>
						첨부파일
					</dt>
					<dd>
					</dd>
				</dl>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
				${board.contents}
				</div>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
			<p>
				<a class="btn btn-primary" href="board.ye">목록</a>
				<a class="btn btn-primary" href="boardModify.ye?idx=${board.idx}">수정</a>
				<a class="btn btn-danger" href="boardDelete.ye?idx=${board.idx}">삭제</a>
			</p>
		</div>
	</div>
</div>