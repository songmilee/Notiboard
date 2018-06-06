<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" %>
<%@ page session="false" %>
<html>
	<%@ include file="./partial/header.html" %>
<body>
	<div ng-app="noti" ng-controller="blistController" class="row">
		<div class="container">			
			
			<div id="writeData" class="row" style="padding-top:20px; padding-bottom:10px;">
				<button ng-click="writePage()" class="btn btn-primary">글 쓰기</button>
			</div>
			
			<div class="row table-responsive">
				<table class="table" id="board">
					<thead class="thead-dark">
						<tr>
							<th scope="col">no</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
							<th scope="col">작성일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>a</td>
							<td>a</td>
							<td>a</td>
							<td>a</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<%@ include file="./partial/js.html" %>
</body>
</html>