
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Cart</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Little Closet template">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/cart.css">
<link rel="stylesheet" type="text/css" href="styles/cart_responsive.css">
</head>
<body>


	<div class="super_container">

		<!-- Header -->
		<jsp:include page="/WEB-INF/jsp/headerShop.jsp"></jsp:include>

		<div class="super_container_inner">
			<div class="super_overlay"></div>

			<!-- Home -->

			<div class="home">
				<div
					class="home_container d-flex flex-column align-items-center justify-content-end">
					<div class="home_content text-center">
						<div class="home_title">Shopping Cart</div>
						<div
							class="breadcrumbs d-flex flex-column align-items-center justify-content-center">
							<ul
								class="d-flex flex-row align-items-start justify-content-start text-center">
								<li>You are few staps away from best clothing</li>
								<!-- <li>Your Cart</li> -->
							</ul>
						</div>
					</div>
				</div>
			</div>

			<!-- Cart -->

			<div class="cart_section">
				<div class="container">
					<!-- <div class="row">
						<div class="col">
							<div class="cart_container">

								Cart Items
								<div class="cart_items">
									<ul class="cart_items_list">

										Cart Item
										
									</ul>
								</div>

								Cart Buttons
								<div
									class="cart_buttons d-flex flex-row align-items-start justify-content-start">
									<div
										class="cart_buttons_inner ml-sm-auto d-flex flex-row align-items-start justify-content-start flex-wrap">
										<div class="button button_clear trans_200">
											<a href="categories.html">clear cart</a>
										</div>
										<div class="button button_continue trans_200">
											<a href="categories.html">continue shopping</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div> -->
					<div class="row cart_extra_row">
						<div class="col-lg-12" align="center">
							<div class="cart_extra cart_extra_1">
								<!--							<div class="cart_extra_content cart_extra_coupon">-->
								<!--								<div class="cart_extra_title">Coupon code</div>-->
								<!--								<div class="coupon_form_container">-->
								<!--									<form action="#" id="coupon_form" class="coupon_form">-->
								<!--										<input type="text" class="coupon_input" required="required">-->
								<!--										<button class="coupon_button">apply</button>-->
								<!--									</form>-->
								<!--								</div>-->
								<!--								<div class="coupon_text">Phasellus sit amet nunc eros. Sed nec congue tellus. Aenean nulla nisl, volutpat blandit lorem ut.</div>-->
								<!--								<div class="shipping">-->
								<!--									<div class="cart_extra_title">Shipping Method</div>-->
								<!--									<ul>-->
								<!--										<li class="shipping_option d-flex flex-row align-items-center justify-content-start">-->
								<!--											<label class="radio_container">-->
								<!--												<input type="radio" id="radio_1" name="shipping_radio" class="shipping_radio">-->
								<!--												<span class="radio_mark"></span>-->
								<!--												<span class="radio_text">Next day delivery</span>-->
								<!--											</label>-->
								<!--											<div class="shipping_price ml-auto">$4.99</div>-->
								<!--										</li>-->
								<!--										<li class="shipping_option d-flex flex-row align-items-center justify-content-start">-->
								<!--											<label class="radio_container">-->
								<!--												<input type="radio" id="radio_2" name="shipping_radio" class="shipping_radio">-->
								<!--												<span class="radio_mark"></span>-->
								<!--												<span class="radio_text">Standard delivery</span>-->
								<!--											</label>-->
								<!--											<div class="shipping_price ml-auto">$1.99</div>-->
								<!--										</li>-->
								<!--										<li class="shipping_option d-flex flex-row align-items-center justify-content-start">-->
								<!--											<label class="radio_container">-->
								<!--												<input type="radio" id="radio_3" name="shipping_radio" class="shipping_radio" checked>-->
								<!--												<span class="radio_mark"></span>-->
								<!--												<span class="radio_text">Personal Pickup</span>-->
								<!--											</label>-->
								<!--											<div class="shipping_price ml-auto">Free</div>-->
								<!--										</li>-->
								<!--									</ul>-->
								<!--								</div>-->
								<!--							</div>-->
								<!--						</div>-->
								<!--					</div>-->
								<div class="col-lg-6 cart_extra_col">
									<div class="cart_extra cart_extra_2">
										<div class="cart_extra_content cart_extra_total">
											<div class="cart_extra_title">Sale Summary</div>
											<ul class="cart_extra_total_list">
	
												<li
													class="d-flex flex-row align-items-center justify-content-start">
													<div class="cart_extra_total_title">Subtotal</div>
													<div class="cart_extra_total_value ml-auto">LKR ${checkout.totalAmount}</div>
												</li>
												
												<li
													class="d-flex flex-row align-items-center justify-content-start">
													<div class="cart_extra_total_title">Total</div>
													<div class="cart_extra_total_value ml-auto">LKR ${checkout.totalAmount}</div>
												</li>
												
												<li
													class="d-flex flex-row align-items-center justify-content-start">
													<div class="cart_extra_total_title">Delivery Address</div>
													<div class="cart_extra_total_value ml-auto">${checkout.deliveryAddress}</div>
												</li>
												
												<li
													class="d-flex flex-row align-items-center justify-content-start">
													<div class="cart_extra_total_title">Zip Code</div>
													<div class="cart_extra_total_value ml-auto">${checkout.zipcode}</div>
												</li>
												
												<li
													class="d-flex flex-row align-items-center justify-content-start">
													<div class="cart_extra_total_title">Mobile Number</div>
													<div class="cart_extra_total_value ml-auto">${checkout.contactNumber}</div>
												</li>
												
													
													 
													</div>
													
													<p>${message }</p>
												
											</ul>
												<div class="checkout_button trans_200">
													<a href="home">Continue Shopping</a>
												</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


					<script src="js/jquery-3.2.1.min.js"></script>
					<script src="styles/bootstrap-4.1.2/popper.js"></script>
					<script src="styles/bootstrap-4.1.2/bootstrap.min.js"></script>
					<script src="plugins/greensock/TweenMax.min.js"></script>
					<script src="plugins/greensock/TimelineMax.min.js"></script>
					<script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
					<script src="plugins/greensock/animation.gsap.min.js"></script>
					<script src="plugins/greensock/ScrollToPlugin.min.js"></script>
					<script src="plugins/easing/easing.js"></script>
					<script src="plugins/parallax-js-master/parallax.min.js"></script>
					<script src="js/cart.js"></script>
</body>
</html>