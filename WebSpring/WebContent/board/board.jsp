<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<td class="title"><a href="#">${list[0].title}</a></td>
					<td class="writer">관리자</td>
					<td class="regdate">2016/10/19</td>
					<td class="hit">0</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>