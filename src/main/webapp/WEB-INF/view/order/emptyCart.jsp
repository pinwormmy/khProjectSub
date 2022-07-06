<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jspf"%>

<section class="empty-cart page-wrapper">
  <div class="container">
    <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="block text-center">
        	<i class="tf-ion-ios-cart-outline"></i>
          	<h2 class="text-center">장바구니가 비었습니다~~</h2>
          	<p>인생은 치킨을 알기 전과 알고 난 후로 나뉜다.</p>
          	<a href="<%=request.getContextPath()%>/index.do" class="btn btn-main mt-20">처음으로</a>
      </div>
    </div>
  </div>
  </div>
</section>

<%@ include file="../include/footer.jspf"%>