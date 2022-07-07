<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jspf" %>

<section class="single-product">
	<div class="container">
		


		<%
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";

		Connection con = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String typecode, pname, brand, thumbnail, image;
		int price;
		String sql;
		DecimalFormat df = new DecimalFormat("###,###");

		request.setCharacterEncoding("UTF-8");
		int getpId = Integer.parseInt(request.getParameter("pId"));
		

		try {
		    Class.forName(driver);
		    con = DriverManager.getConnection(url, "MEALKIT", "MEALKIT");

		    sql = "SELECT * FROM product NATURAL JOIN productType WHERE pid=?";
		    pstmt = con.prepareStatement(sql);
		    pstmt.setInt(1, getpId);
		    rs = pstmt.executeQuery();

		    while (rs.next()) {
		%>
		

		<div class="row">
			<div class="col-md-6">
				<ol class="breadcrumb">
					<li><a href="<%=request.getContextPath()%>/index.do">Home</a></li>
					<li><a href="<%=request.getContextPath()%>/shop/all.do">Shop</a></li>
					<li><a href="<%=request.getContextPath()%>/shop/type.do?typeCode=<%=rs.getString("typeCode")%>"><%=rs.getString("tName")%></a></li>
				</ol>
			</div>
		</div>
		<div class="row mt-20">
			<div class="col-md-5">
				<div class="single-product-slider">
					<div id='carousel-custom' class='carousel slide'
						data-ride='carousel'>
						<div class='carousel-outer'>
							<!-- me art lab slider -->
							<div class='carousel-inner '>
								<div class='item active'>
									<img src='<%=request.getContextPath()%><%=rs.getString("thumbnail")%>' alt='' />
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="col-md-7">
				<div class="single-product-details">
				
					<form action="<%=request.getContextPath()%>
						<c:if test="${member != null}">/addCart.do</c:if>
						<c:if test="${member == null}">/login.do</c:if>
					" id="addCartForm">						
						<h2><%=rs.getString("pname")%></h2>
						<p class="product-price"><%=df.format(rs.getInt("price"))%>원</p>
	
						<p class="product-description mt-20">나중에 설명 넣을 자리</p>
						<div class="product-category">
							<span>브랜드</span> <%=rs.getString("brand")%>
						</div>
						<div class="product-category">
							<span>배송구분</span> 택배배송: 3,000원
						</div>
						<div class="product-quantity">
							<span>주문 수량</span>
							<div class="product-quantity-slider">
								<input id="product-quantity" type="text" value="0" name="cQuantity">
							</div>
						</div>
						<input type="hidden" name=mId value="${member.mId}">
						<input type="hidden" name="pId" value="<%=rs.getString("pId")%>">
						<button type="button" class="btn btn-main mt-20" id="cartBtn" onclick="checkQuantity();">Add To Cart</button>
					</form>
				</div>
			</div>
		</div>
		
		<script>			
		
			function checkQuantity(){				
				
				let addCartForm = document.getElementById("addCartForm");
				
				if(addCartForm.cQuantity.value > 0){
					addCartForm.submit();
				}else
					alert("수량을 하나 이상 골라주세요!!!!")
			}				
			
		</script>

		<div class="row">
			<div class="col-xs-12">
				<div class="tabCommon mt-20">
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#details"
							aria-expanded="true">Details</a></li>
						<li class=""><a data-toggle="tab" href="#reviews"
							aria-expanded="false">Reviews</a></li>
					</ul>
					<div class="tab-content patternbg">
						<div id="details" class="tab-pane fade active in">
							<h4>Product Description</h4>
							<img src='<%=request.getContextPath()%><%=rs.getString("image")%>'>
						</div>
						<div id="reviews" class="tab-pane fade">
							<div class="post-comments">
								<ul class="media-list comments-list m-bot-50 clearlist">
									<!-- Comment Item start-->
									<c:if test="${empty reviewList}"><h3 class="comment-author">아직 리뷰가 없네요~~</h3></c:if>
									<c:forEach var="review" items="${reviewList}">
									<li class="media">
										<h4 class="comment-author">${review.mId}</h4>
										<div class="media-body">
											<div class="comment-info">												
												<time datetime="2013-04-06T13:53"> ${review.regDate} </time>
												<a class="comment-button" href="#!"><i
													class="tf-ion-chatbubbles"></i>Reply</a>
											</div>
											<p>${review.content}</p>
										</div>
									</li>
									</c:forEach>
									<!-- End Comment Item -->
									<c:if test="${member != null}">
									<li class="media">
										<div class="media-body">
											<div class="comment-info">
												<form action="<%=request.getContextPath()%>/addReview.do">
													<h4 class="comment-author">${member.mId}</h4>
													<input type="hidden" name="mId" value="${member.mId}">
													<input type="hidden" name="pId" value="<%=rs.getString("pId")%>">
													<textarea name="content" cols="150" rows="5" required></textarea>
													<button>write review</button>
												</form>												
											</div>											
										</div>
									</li>
									</c:if>									
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<section class="products related-products section">
	<div class="container">
		<div class="row">
			<div class="title text-center">
				<h2>Related Products</h2>
			</div>
		</div>
		<div class="row">




		<% 
		    }
		    
		    String sql2 = "SELECT * FROM product WHERE typeCode = (SELECT typeCode FROM product WHERE pId = ?) and pId != ?";
		    pstmt = con.prepareStatement(sql2);
		    pstmt.setInt(1, getpId);
		    pstmt.setInt(2, getpId);
		    rs = pstmt.executeQuery();

		    while (rs.next()) {
		%>


			<div class="col-md-3">
				<div class="product-item">
					<div class="product-thumb">
						<img class="img-responsive"
							src="<%=request.getContextPath()%><%=rs.getString("thumbnail")%>" alt="product-img" />
						<div class="preview-meta">
							<ul>
								<li><a href="<%=request.getContextPath()%>/shop/detail.do?pId=<%=rs.getString("pid")%>"><i class="tf-ion-ios-search"></i></a></li>
								<li><a href="#"><i class="tf-ion-ios-heart"></i></a></li>
								<li><a href="#!"><i class="tf-ion-android-cart"></i></a></li>
							</ul>
						</div>
					</div>
					<div class="product-content">
						<h4>
							<a href="<%=request.getContextPath()%>/shop/detail.do?pId=<%=rs.getString("pid")%>"><%=rs.getString("pname")%></a>
						</h4>
						<p class="price"><%=rs.getInt("price")%></p>
					</div>
				</div>
			</div>




<%
}
} catch (Exception e) {
System.out.println("데이터베이스 연결 실패!");
} finally {
try {
if (rs != null)
    rs.close();
if (pstmt != null)
    pstmt.close();
if (con != null)
    con.close();
} catch (Exception e) {
System.out.println(e.getMessage());
}
}
%>
		</div>
	</div>
</section>

<%@ include file="../include/footer.jspf" %>