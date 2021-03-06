<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jspf"%>

<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">Cart</h1>
					<ol class="breadcrumb">
						<li><a href="<%=request.getContextPath()%>/index.do">Home</a></li>
						<li class="active">cart</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>


<div class="page-wrapper">
	<div class="cart shopping">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<div class="block">
						<div class="product-list">
							<form method="post">							
								<table class="table">
									<thead>
										<tr>
											<th class="">상품명</th>
											<th class="">상품가격</th>
											<th class="">상품수량</th>
											<th class="">선택</th>
										</tr>
									</thead>
									<tbody>																		
									<c:forEach var="cart" items="${cartList}">
										<tr class="">
											<td class="">
												<div class="product-info">
													<img width="80"
														src="<%=request.getContextPath()%>${cart.thumbnail}" alt="" /> 
														<a href="<%=request.getContextPath()%>/shop/detail.do?pId=${cart.pId}"> ${cart.pName}</a>
												</div>
											</td>
											<td class="">${cart.price * cart.cQuantity}</td>
											<!-- <td class=""><input type=number id="stuff" value="1" min="1" max="100"></td> -->
											<td class=""> ${cart.cQuantity} </td>
											<td class="">												
												<a class="product-remove"
												href="<%=request.getContextPath()%>/deleteCart.do?mId=${member.mId}&ucId=${cart.ucId}">삭제</a> 												
											</td>
										</tr>
									</c:forEach>			
									</tbody>
									
								</table>
					
								<a href="<%=request.getContextPath()%>/checkout.do?mId=${member.mId}" class="btn btn-main pull-right">주문하기</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<%@ include file="../include/footer.jspf"%>