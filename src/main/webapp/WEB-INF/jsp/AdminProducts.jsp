<%--
  Created by IntelliJ IDEA.
  User: Manuja
  Date: 9/26/2020
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Manu's Clothing Store</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Little Closet template">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="../plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../plugins/OwlCarousel2-2.2.1/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="../plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
<link rel="stylesheet" type="text/css" href="../plugins/OwlCarousel2-2.2.1/animate.css">
<link rel="stylesheet" type="text/css" href="../styles/category.css">
<link rel="stylesheet" type="text/css" href="../styles/category_responsive.css">
<link rel="stylesheet" type="text/css" href="../styles/custom.css">
</head>
<body>

<!-- Menu -->

<div class="super_container">

	<!-- Header -->
	<jsp:include page="/WEB-INF/jsp/AdminHeaderShop.jsp"></jsp:include>

	<div class="super_container_inner">
		<!-- <div class="super_overlay"></div> -->

		<!-- Home -->
		<div class="home">
			<div class="home_container d-flex flex-column align-items-center justify-content-end">
				<div class="home_content text-center">
					<div class="home_title">Manu's Clothing Store Admin Area</div>
					<div class="breadcrumbs d-flex flex-column align-items-center justify-content-center">
						<ul class="d-flex flex-row align-items-start justify-content-start text-center">
							<li>All Products</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		
		
		
		
		<div class="container" style="margin-top: 10em;">
		 <div>
		  <a type="button" class="btn btn-primary btn-md" href="addProduct">Add Product</a>
		 </div>
		 <br>
		 <div class="panel panel-primary">
		  <div class="panel-heading">
		   <h3>List Products</h3>
		  </div>
		  <div class="panel-body">
		   <table class="table table-striped">
		    <thead>
		     <tr>
		      <th width="10%">Product Name</th>
		      <th width="10%">Category</th>
		      <th width="20%">Description</th>
		      <th width="10%">Price</th>
		      <th width="10%">Rating</th>
		      <th width="40%">Target Date</th>
		      <th width="20%"></th>
		     </tr>
		    </thead>
		    <tbody>
		     <c:forEach items="${products}" var="product">
		      <tr>
		       <td>${product.name}</td>
		       <td>${product.category}</td>
		       <td>${product.description}</td>
		       <td>${product.price}</td>
		       <td>${product.rating}</td>
		       <td>
		       <a type="button" class="btn btn-success" href="updateProduct/${product.id}">Update</a>
		       <a type="button" class="btn btn-warning" href="deleteProduct/${product.id}">Delete</a>
		       <a type="button" class="btn btn-success" href="uploadImages/${product.id}">Upload</a>
		        </td>
		      </tr>
		     </c:forEach>
		    </tbody>
		   </table>
		
			<p>${deletedMessage}</p>   
		   
		  </div>
		 </div>
		
		</div>
		

	

		<!-- Footer -->

		<footer class="footer">
			<div class="footer_content">
				<div class="container">
					<div class="row">
						
						<!-- About -->
						<div class="col-lg-4 footer_col">
							<div class="footer_about">
								<div class="footer_logo">
									<a href="#">
										<div class="d-flex flex-row align-items-center justify-content-start">
											<div class="footer_logo_icon"><img src="../images/logo_2.png" alt=""></div>
											<div>Little Closet</div>
										</div>
									</a>		
								</div>
								<div class="footer_about_text">
									<p>Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse potenti. Fusce venenatis vel velit vel euismod.</p>
								</div>
							</div>
						</div>

						<!-- Footer Links -->
						<div class="col-lg-4 footer_col">
							<div class="footer_menu">
								<div class="footer_title">Support</div>
								<ul class="footer_list">
									<li>
										<a href="#"><div>Customer Service<div class="footer_tag_1">online now</div></div></a>
									</li>
									<li>
										<a href="#"><div>Return Policy</div></a>
									</li>
									<li>
										<a href="#"><div>Size Guide<div class="footer_tag_2">recommended</div></div></a>
									</li>
									<li>
										<a href="#"><div>Terms and Conditions</div></a>
									</li>
									<li>
										<a href="#"><div>Contact</div></a>
									</li>
								</ul>
							</div>
						</div>

						<!-- Footer Contact -->
						<div class="col-lg-4 footer_col">
							<div class="footer_contact">
								<div class="footer_title">Stay in Touch</div>
								<div class="newsletter">
									<form action="#" id="newsletter_form" class="newsletter_form">
										<input type="email" class="newsletter_input" placeholder="Subscribe to our Newsletter" required="required">
										<button class="newsletter_button">+</button>
									</form>
								</div>
								<div class="footer_social">
									<div class="footer_title">Social</div>
									<ul class="footer_social_list d-flex flex-row align-items-start justify-content-start">
										<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
										<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer_bar">
				<div class="container">
					<div class="row">
						<div class="col">
							<div class="footer_bar_content d-flex flex-md-row flex-column align-items-center justify-content-start">
								<div class="copyright order-md-1 order-2">
									Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved</div>
								<nav class="footer_nav ml-md-auto order-md-2 order-1">
									<ul class="d-flex flex-row align-items-center justify-content-start">
										<li><a href="category.html">Women</a></li>
										<li><a href="category.html">Men</a></li>
										<li><a href="category.html">Kids</a></li>
										<li><a href="category.html">Home Deco</a></li>
										<li><a href="#">Contact</a></li>
									</ul>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</div>
		
</div>

<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../styles/bootstrap-4.1.2/popper.js"></script>
<script src="../styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="../plugins/greensock/TweenMax.min.js"></script>
<script src="../plugins/greensock/TimelineMax.min.js"></script>
<script src="../plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="../plugins/greensock/animation.gsap.min.js"></script>
<script src="../plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="../plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="../plugins/easing/easing.js"></script>
<script src="../plugins/progressbar/progressbar.min.js"></script>
<script src="../plugins/parallax-js-master/parallax.min.js"></script>
<script src="../plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="../plugins/Isotope/fitcolumns.js"></script>
<script src="../js/category.js"></script>
</body>
</html>
