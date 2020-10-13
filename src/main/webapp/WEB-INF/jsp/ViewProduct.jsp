<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Product</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Little Closet template">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="../../styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="../../plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../../plugins/flexslider/flexslider.css">
<link rel="stylesheet" type="text/css" href="../../styles/product.css">
<link rel="stylesheet" type="text/css" href="../../styles/product_responsive.css">
</head>
<body>

<!-- Menu -->

<jsp:include page="/WEB-INF/jsp/headerSideNav.jsp"></jsp:include>

<div class="super_container">

	<!-- Header -->
	<jsp:include page="/WEB-INF/jsp/headerShopProduct.jsp"></jsp:include>
	

	<div class="super_container_inner">
		<div class="super_overlay"></div>

		<!-- Home -->

		<div class="home">
			<div class="home_container d-flex flex-column align-items-center justify-content-end">
				<div class="home_content text-center">
					<div class="home_title">Product Page</div>
					<div class="breadcrumbs d-flex flex-column align-items-center justify-content-center">
						<ul class="d-flex flex-row align-items-start justify-content-start text-center">
							<li>${productDetails.name}</li> 
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!-- Product -->

		<div class="product">
			<div class="container">
				<div class="row">
					
					<!-- Product Image -->
					<div class="col-lg-6">
						<div class="product_image_slider_container">
							<div id="slider" class="flexslider">
								<ul class="slides">
								
								<c:choose>
										<c:when test="${productDetails.images.size() gt 0}">
											<c:forEach items="${productDetails.images}" var="image">
												<li>
													<div><img src="http://localhost/shoplingAppImages/${image}" /></div>
												</li>
											</c:forEach>
											<%-- <div class="product_image"><img src="http://localhost/shoplingAppImages/${myProduct.images[0]}" alt=""></div> --%>
										</c:when>
										<c:otherwise>
											<div class="product_image"><img src="../../images/product_1.jpg" alt=""></div>
										</c:otherwise>
								</c:choose>
								
								<%-- 
									<c:forEach items="${productDetails.images}" var="image">
										<li>
											<div><img src="../../${image}" /></div>
										</li>
									</c:forEach>
									<li>
										<img src="../../images/product_1.jpg" />
									</li>
									<li>
										<img src="../../images/product_1.jpg" />
									</li> --%>
								</ul>
							</div>
							<div class="carousel_container">
								<div id="carousel" class="flexslider">
									<ul class="slides">
									
									<c:choose>
										<c:when test="${not empty productDetails.images}">
											<c:forEach items="${productDetails.images}" var="image">
												<li>
													<div><img src="http://localhost/shoplingAppImages/${image}" /></div>
												</li>
											</c:forEach>
											<%-- <div class="product_image"><img src="http://localhost/shoplingAppImages/${myProduct.images[0]}" alt=""></div> --%>
										</c:when>
										<c:otherwise>
											<div class="product_image"><img src="../../images/product_1.jpg" alt=""></div>
										</c:otherwise>
									</c:choose>
									
									<%-- <c:forEach items="${productDetails.images}" var="image">
										<li>
											<div><img src="../../${image}" /></div>
										</li>
									</c:forEach> --%>
										<!-- <li>
											<div><img src="../../images/product_1.jpg" /></div>
										</li>
										<li>
											<div><img src="../../images/product_2.jpg" /></div>
										</li>
										<li>
											<div><img src="../../images/product_3.jpg" /></div>
										</li>
										<li>
											<div><img src="../../images/product_4.jpg" /></div>
										</li>
										<li>
											<div><img src="../../images/product_5.jpg" /></div>
										</li>
										<li>
											<div><img src="../../images/product_6.jpg" /></div>
										</li>
										<li>
											<div><img src="../../images/product_7.jpg" /></div>
										</li>
										<li>
											<div><img src="../../images/product_8.jpg" /></div>
										</li> -->
									</ul>
								</div>
								<div class="fs_prev fs_nav disabled"><i class="fa fa-chevron-up" aria-hidden="true"></i></div>
								<div class="fs_next fs_nav"><i class="fa fa-chevron-down" aria-hidden="true"></i></div>
							</div>
						</div>
					</div>

					<!-- Product Info -->
					<div class="col-lg-6 product_col">
						<div class="product_info">
							<div class="product_name">${productDetails.name}</div>
							<div class="product_category">In ${productDetails.category}</div>
							<div class="product_rating_container d-flex flex-row align-items-center justify-content-start">
								<div class="rating_r rating_r_${productDetails.rating} product_rating"><i></i><i></i><i></i><i></i><i></i></div>
								<div class="product_reviews">${productDetails.rating} out of 5</div>
								<!-- <div class="product_reviews_link"><a href="#">Reviews</a></div> -->
							</div>
							<div class="product_price">LKR ${productDetails.priceWithoutFraction}<span>.${productDetails.priceFraction}</span></div>
							<div class="product_size">
								<div class="product_size_title">Select Size</div>
								<ul class="d-flex flex-row align-items-start justify-content-start">
								
									<c:forEach items="${productDetails.sizes}" var="size">
										<li>
										<c:if test="${size.value}">
									        <input type="radio" id="radio_${size.key}" name="product_radio" class="regular_radio radio_1">
										<label for="radio_${size.key}">${size.key}</label>
									    </c:if>
										<c:if test="${not size.value}">
									        <input type="radio" id="radio_${size.key}" disabled name="product_radio" class="regular_radio radio_1">
										<label for="radio_${size.key}">${size.key}</label>
									    </c:if>
										</li>
									</c:forEach>
									<!-- <li>
										<input type="radio" id="radio_1" disabled name="product_radio" class="regular_radio radio_1">
										<label for="radio_1">XS</label>
									</li>
									<li>
										<input type="radio" id="radio_2" name="product_radio" class="regular_radio radio_2" checked>
										<label for="radio_2">S</label>
									</li>
									<li>
										<input type="radio" id="radio_3" name="product_radio" class="regular_radio radio_3">
										<label for="radio_3">M</label>
									</li>
									<li>
										<input type="radio" id="radio_4" name="product_radio" class="regular_radio radio_4">
										<label for="radio_4">L</label>
									</li>
									<li>
										<input type="radio" id="radio_5" name="product_radio" class="regular_radio radio_5">
										<label for="radio_5">XL</label>
									</li>
									<li>
										<input type="radio" id="radio_6" disabled name="product_radio" class="regular_radio radio_6">
										<label for="radio_6">XXL</label>
									</li> -->
								</ul>
							</div>
							<div class="product_text">
								<p>Description : ${productDetails.description }</p>
								<!--<p>Description : ${userId}</p>
								<p>Description : ${productDetails.id}</p> -->
							</div>
							<div class="product_buttons">
								<div class="text-right d-flex flex-row align-items-start justify-content-start">
									<!-- <div class="product_button product_fav text-center d-flex flex-column align-items-center justify-content-center">
										<div><div><img src="images/heart_2.svg" class="svg" alt=""><div>+</div></div></div>
									</div> -->
									<div onclick="window.location.href='../../cart/${userId}/${productDetails.id}'"
										class="product_button product_cart text-center d-flex flex-column align-items-center justify-content-center">
										<div><div><img src="../../images/cart.svg" class="svg" alt=""><div>+</div></div></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Boxes -->

		<!-- <div class="boxes">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<div class="box d-flex flex-row align-items-center justify-content-start">
							<div class="mt-auto"><div class="box_image"><img src="../../images/boxes_1.png" alt=""></div></div>
							<div class="box_content">
								<div class="box_title">Size Guide</div>
								<div class="box_text">Phasellus sit amet nunc eros sed nec tellus.</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6 box_col">
						<div class="box d-flex flex-row align-items-center justify-content-start">
							<div class="mt-auto"><div class="box_image"><img src="../../images/boxes_2.png" alt=""></div></div>
							<div class="box_content">
								<div class="box_title">Shipping</div>
								<div class="box_text">Phasellus sit amet nunc eros sed nec tellus.</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
 -->
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
											<div class="footer_logo_icon"><img src="images/logo_2.png" alt=""></div>
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
								<div class="copyright order-md-1 order-2"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></div>
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

<script src="../../js/jquery-3.2.1.min.js"></script>
<script src="../../styles/bootstrap-4.1.2/popper.js"></script>
<script src="../../styles/bootstrap-4.1.2/bootstrap.min.js"></script>
<script src="../../plugins/greensock/TweenMax.min.js"></script>
<script src="../../plugins/greensock/TimelineMax.min.js"></script>
<script src="../../plugins/scrollmagic/ScrollMagic.min.js"></script>
<script src="../../plugins/greensock/animation.gsap.min.js"></script>
<script src="../../plugins/greensock/ScrollToPlugin.min.js"></script>
<script src="../../plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="../../plugins/easing/easing.js"></script>
<script src="../../plugins/progressbar/progressbar.min.js"></script>
<script src="../../plugins/parallax-js-master/parallax.min.js"></script>
<script src="../../plugins/flexslider/jquery.flexslider-min.js"></script>
<script src="../../js/product.js"></script>
</body>
</html>