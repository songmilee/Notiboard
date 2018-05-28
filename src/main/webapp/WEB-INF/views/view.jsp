<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page pageEncoding="utf-8" %>
<%@ page session="false" %>
<html>
	<%@ include file="./partial/header.html" %>
<body>
	<div class="container">
	
		<!-- buttom list -->
		<div class="bottom-space">
			<button class="btn btn-default btn-primary">목록</button>
			<div class="float-right">
				<button class="btn btn-default">다음글</button>
				<button class="btn btn-default">이전글</button>
			</div>			
		</div>
		
		<!-- board detail -->
		<div class="bottom-space">
			<div class="card">
				<div class="card-header">제목</div>
			</div>
				
			
			<div class="card-body bottom-space">
				<p class="text-right bottom-space">날짜 : 2018-08-01 조회수 : 0</p>			
				<p class="card-text">내용</p>
			</div>
			
			<div class="card-footer bottom-space">
				<div class="text-right">작성자 : 이름</div>
			</div>
			<div style="padding-left:15px; padding-right:15px;">
			<form>
				<div class="form-group">					
					<div class="row bottom-space">
						<label for="comment">comment</label>
		  				<textarea class="form-control" rows="3" id="comment"></textarea>
					</div>
					
					<div class="row float-right bottom-space">
						<button type="submit" class="btn btn-default btn-primary">작성</button>
					</div>
				</div>
			</form>
			</div>
		</div>	
		
		<!-- comment list -->
		<div class="table-responsive">
			<table class="table table-hover" id="comment">
				<tr>
					<td>
						<div class="row" style="margin-left:15px; margin-right:15px">
							<p class="float-left">no. 이름</p>
							<p class="float-right">날짜</p>
						</div>
						
						<div class="row" style="margin-left:15px; margin-right:15px">
							<p>comment</p>
						</div>		
									
					</td>
				</tr>			
			</table>
		</div>
		
		<!-- comment form -->
		<div class="bottom-space">
			
		</div>		
		
		<!-- button list -->
		<div class="bottom-space">
			<button class="btn btn-default btn-primary">목록</button>
			<div class="float-right">
				<button class="btn btn-default">다음글</button>
				<button class="btn btn-default">이전글</button>
			</div>			
		</div>
					
	</div>

	<%@ include file="./partial/js.html" %>
</body>
</html>