<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./include/header.jspf"%>

<div class="hero-slider">

  <div class="slider-item th-fullpage hero-area" style="background-image: url(<%=request.getContextPath()%>/aviato/images/slider/bibimbap.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 text-center">
          <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">한식 KOREAN FOOD</p>
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">The beauty of nature <br> is hidden in details.</h1>
          <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="<%=request.getContextPath()%>/shop/type.do?typeCode=1">Shop Now</a>
        </div>
      </div>
    </div>
  </div>
  <div class="slider-item th-fullpage hero-area" style="background-image: url(<%=request.getContextPath()%>/aviato/images/slider/western.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 text-left">
          <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">양식 WESTERN FOOD</p>
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">The beauty of nature <br> is hidden in details.</h1>
          <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="<%=request.getContextPath()%>/shop/type.do?typeCode=2">Shop Now</a>
        </div>
      </div>
    </div>
  </div>
  <div class="slider-item th-fullpage hero-area" style="background-image: url(<%=request.getContextPath()%>/aviato/images/slider/asian.jpg);">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 text-right">
          <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">동남아 SOUTHEAST ASIAN FOOD</p>
          <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">The beauty of nature <br> is hidden in details.</h1>
          <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="<%=request.getContextPath()%>/shop/type.do?typeCode=5">Shop Now</a>
        </div>
      </div>
    </div>
  </div>
</div>

<section class="products section bg-gray">
	<div class="container">
		<div class="row">
			<div class="title text-center">
				<h2>New Arrivals</h2>
			</div>
		</div>
		<div class="row">

		<%@ include file="./include/list.jspf" %>			

		</div>
	</div>
</section>


<%@ include file="./include/footer.jspf"%>