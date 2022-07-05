<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jspf" %>

<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">My account</h1>
					<ol class="breadcrumb">
						<li><a href="<%=request.getContextPath()%>/index.do">Home</a></li>
						<li class="active">my account</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>
<section class="user-dashboard page-wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<ul class="list-inline dashboard-menu text-center">
					<li><a href="dashboard.html">My account</a></li>
					<li><a class="active" href="order.html">Orders</a></li>
					<li><a href="<%=request.getContextPath()%>/aviato/address.html">Address</a></li>
					<li><a href="<%=request.getContextPath()%>/aviato/profile-details.html">Profile</a></li>
				</ul>
				<div class="dashboard-wrapper user-dashboard">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>주문번호</th>
									<th>주문일자</th>
									<th>상품명</th>
									<th>상품수량</th>
									<th>결제금액</th>
									<th>주문현황</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>#451231</td>
									<td>2016-03-25</td>
									<td>비빔밥 밀키트(3EA)</td>
									<td>2</td>
									<td>40,000원</td>
									<td><span class="label label-primary">입금준비중</span></td>
									<td><a href="<%=request.getContextPath()%>/order/detail.do" class="btn btn-default">View</a></td>
								</tr>
								<tr>
									<td>#451231</td>
									<td>2016-03-25</td>
									<td>해물 비빔 쌀국수 밀키트(5EA)</td>
									<td>3</td>
									<td>69,000원</td>
									<td><span class="label label-success">배송준비중</span></td>
									<td><a href="<%=request.getContextPath()%>/order/detail.do" class="btn btn-default">View</a></td>
								</tr>
								<tr>
									<td>#451231</td>
									<td>2016-03-25</td>
									<td>토마토 파스타 밀키트(2EA)</td>
									<td>3</td>
									<td>51,000원</td>
									<td><span class="label label-danger">주문취소</span></td>
									<td><a href="<%=request.getContextPath()%>/order/detail.do" class="btn btn-default">View</a></td>
								</tr>
								<tr>
									<td>#451231</td>
									<td>2016-03-25</td>
									<td>해물 비빔 쌀국수 밀키트(5EA)</td>
									<td>2</td>
									<td>46,000원</td>
									<td><span class="label label-info">배송중</span></td>
									<td><a href="<%=request.getContextPath()%>/order/detail.do" class="btn btn-default">View</a></td>
								</tr>
								<tr>
									<td>#451231</td>
									<td>2016-03-25</td>
									<td>비빔밥 밀키트(3EA)</td>
									<td>3</td>
									<td>60,000원</td>
									<td><span class="label label-warning">거래완료</span></td>
									<td><a href="<%=request.getContextPath()%>/order/detail.do" class="btn btn-default">View</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<%@ include file="../include/footer.jspf" %>  