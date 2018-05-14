<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" %>
<%@ page session="false" %>
<html>
	<%@ include file="./partial/header.html" %>
<body>
	<div class="row">
		<div class="container">
		
			<table class="table table-borderless">
				<tr>
					<td>
						<label for="title">제목</label>
						<input name="title">
					</td>
				</tr>
				<tr>
					<td>
						<label for="detail">내용</label>
						<textarea rows="10" name="detail"></textarea>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<%@ include file="./partial/js.html" %>
</body>
</html>