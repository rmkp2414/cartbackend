
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
					<div class="row">
						<div class="col">
							<div class="cart_container">

								<!-- Cart Bar -->
								<div class="cart_bar">
									<ul
										class="cart_bar_list item_list d-flex flex-row align-items-center justify-content-end">
										<li class="mr-auto">Product</li>
										<li>Price</li>
										<!-- <li>Size</li>
										<li>Price</li> -->
										<li>Quantity</li>
										<li>Total</li>
									</ul>
								</div>

								<!-- Cart Items -->
								<div class="cart_items">
									<ul class="cart_items_list">

										<!-- Cart Item -->
										<c:forEach items="${cart.cartItems}" var="myCartItem">
											<%-- <a href="product.html">AAAA ${myCartItem.productName} </a> --%>
										
										<li
											class="cart_item item_list d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-lg-end justify-content-start">
											<div
												class="product d-flex flex-lg-row flex-column align-items-lg-center align-items-start justify-content-start mr-auto">
												<div>
													<div class="product_number">${myCartItem.id}</div>
												</div>
												<div>
													<div class="product_image">
														<img src="images/cart_item_1.jpg" alt="">
													</div>
												</div>
												<div class="product_name_container">
													<div class="product_name">
														<a href="product.html">${myCartItem.productName} </a>
													</div>
													<div class="product_text">${myCartItem.productName}</div>
												</div>
											</div>
											<%-- <div class="product_color product_text">
												<span>Color: </span>beige
											</div>
											<div class="product_size product_text">
												<span>Size: </span>${myCartItem.size}
											</div> --%>
											<div class="product_price product_text">
												<span>Price: </span>${myCartItem.soldPrice}
											</div>
											<div class="product_size product_text">
												<span>Qty: </span>${myCartItem.quantity}
											</div>
											<%-- <div class="product_quantity_container">
											
												<span>Size: </span>${myCartItem.quantity}
												<div
													class="product_quantity ml-lg-auto mr-lg-auto text-center">
													<span class="">${myCartItem.quantity}</span>
													<!-- <div class="qty_sub qty_button trans_200 text-center">
														<span>-</span>
													</div>
													<div class="qty_add qty_button trans_200 text-center">
														<span>+</span>
													</div> -->
												</div>
											</div> --%>
											<div class="product_total product_text">
												<span>Total: </span>${myCartItem.total}
											</div>
										</li>
										</c:forEach>
										
										
									</ul>
								</div>

								<!-- Cart Buttons -->
								<div
									class="cart_buttons d-flex flex-row align-items-start justify-content-start">
									<div
										class="cart_buttons_inner ml-sm-auto d-flex flex-row align-items-start justify-content-start flex-wrap">
										<div class="button button_clear trans_200">
											<a href="clearCart">clear cart</a>
										</div>
										<div class="button button_continue trans_200">
											<a href="home">continue shopping</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
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
											<div class="cart_extra_title">Cart Total</div>
											<form action="checkout" th:action="@{/checkout}" th:object="${categoryDto}" method="post">
											<ul class="cart_extra_total_list">
												<input type="hidden" value=${cart.userId} name="userId" id="userId">
												<div>
													<input type="text" id="deliveryAddress" required="required" name="deliveryAddress" placeholder="Delivery Address" class="form-control" >
												</div>
												<br>
												
												<div>
													<input type="text" id="zipcode" required="required" name="zipcode" placeholder="Zipcode" class="form-control" >
													</div>
												<br>
												
												<div>
													<input type="tel" id="contactNumber" required="required" name="contactNumber" placeholder="Contact Number" class="form-control" >
													</div>
												<br>
												
												<li
													class="d-flex flex-row align-items-center justify-content-start">
													<div class="cart_extra_total_title">Subtotal</div>
													<div class="cart_extra_total_value ml-auto">LKR ${cart.totalAmount}</div>
												</li>
												<!-- <li
													class="d-flex flex-row align-items-center justify-content-start">
													<div class="cart_extra_total_title">Shipping</div>
													<div class="cart_extra_total_value ml-auto">Free</div>
												</li> -->
												<li
													class="d-flex flex-row align-items-center justify-content-start">
													<div class="cart_extra_total_title">Total</div>
													<div class="cart_extra_total_value ml-auto">LKR ${cart.totalAmount}</div>
												</li>
												
													<!-- <br>
													category
													<div>
													<input type="text" id="categoryType" required="required" name="categoryType" placeholder="Category Type" class="form-control" >
													</div>
													<br>
													
													<div>
													Description
													<input type="text" id="description" required="required" name="description" placeholder="Description" class="form-control" >
													</div>
													<br>
																			
													<p><input type="submit" value="Submit" class="form-control" /> 
													<div class="row">
														<div class="col-md-6">
														<input type="reset" value="Reset" class="form-control" /></p>
														</div>
														<div class="col-md-6">
														<input type="button" value="Cancel" onclick="window.location.href='categories'" class="form-control trans_200" /></p>
														</div>
													</div>
													 -->
													
													 
													</div>
													
													<p>${message }</p>
												
											</ul>
											
												
												<div class="checkout_button">
												<c:choose>
												  <c:when test="${showCheckout}">
												   <!-- <a href="home">Continue Shopping</a> -->
												   <input type="submit" value="Proceed to Checkout" class="button button_continue " 
																				style="border : none; color: white; line-height: 44px;
																			    /* padding-left: 18px;
																			    padding-right: 18px; */
																			    font-size: 18px;
																			    font-weight: 700;
																			    color: #FFFFFF;
																			    text-transform: uppercase;" />
												  </c:when>
												  <c:otherwise>
												   <input disabled="disabled"  value="Proceed to Checkout" class="button button_continue " 
																				style="border : none; color: white; line-height: 44px;
																			    /* padding-left: 18px;
																			    padding-right: 18px; */
																			    font-size: 18px;
																			    font-weight: 700;
																			    color: #FFFFFF;
																			    text-transform: uppercase;" />
												  </c:otherwise>
												</c:choose>
												
													<!-- <a href="checkout.html"></a> -->
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!-- Footer -->

					<!--		<footer class="footer">-->
					<!--			<div class="footer_content">-->
					<!--				<div class="container">-->
					<!--					<div class="row">-->
					<!--						-->
					<!--						&lt;!&ndash; About &ndash;&gt;-->
					<!--						<div class="col-lg-4 footer_col">-->
					<!--							<div class="footer_about">-->
					<!--								<div class="footer_logo">-->
					<!--									<a href="#">-->
					<!--										<div class="d-flex flex-row align-items-center justify-content-start">-->
					<!--											<div class="footer_logo_icon"><img src="images/logo_2.png" alt=""></div>-->
					<!--											<div>Little Closet</div>-->
					<!--										</div>-->
					<!--									</a>		-->
					<!--								</div>-->
					<!--								<div class="footer_about_text">-->
					<!--									<p>Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse potenti. Fusce venenatis vel velit vel euismod.</p>-->
					<!--								</div>-->
					<!--							</div>-->
					<!--						</div>-->

					<!--						&lt;!&ndash; Footer Links &ndash;&gt;-->
					<!--						<div class="col-lg-4 footer_col">-->
					<!--							<div class="footer_menu">-->
					<!--								<div class="footer_title">Support</div>-->
					<!--								<ul class="footer_list">-->
					<!--									<li>-->
					<!--										<a href="#"><div>Customer Service<div class="footer_tag_1">online now</div></div></a>-->
					<!--									</li>-->
					<!--									<li>-->
					<!--										<a href="#"><div>Return Policy</div></a>-->
					<!--									</li>-->
					<!--									<li>-->
					<!--										<a href="#"><div>Size Guide<div class="footer_tag_2">recommended</div></div></a>-->
					<!--									</li>-->
					<!--									<li>-->
					<!--										<a href="#"><div>Terms and Conditions</div></a>-->
					<!--									</li>-->
					<!--									<li>-->
					<!--										<a href="#"><div>Contact</div></a>-->
					<!--									</li>-->
					<!--								</ul>-->
					<!--							</div>-->
					<!--						</div>-->

					<!--						&lt;!&ndash; Footer Contact &ndash;&gt;-->
					<!--						<div class="col-lg-4 footer_col">-->
					<!--							<div class="footer_contact">-->
					<!--								<div class="footer_title">Stay in Touch</div>-->
					<!--								<div class="newsletter">-->
					<!--									<form action="#" id="newsletter_form" class="newsletter_form">-->
					<!--										<input type="email" class="newsletter_input" placeholder="Subscribe to our Newsletter" required="required">-->
					<!--										<button class="newsletter_button">+</button>-->
					<!--									</form>-->
					<!--								</div>-->
					<!--								<div class="footer_social">-->
					<!--									<div class="footer_title">Social</div>-->
					<!--									<ul class="footer_social_list d-flex flex-row align-items-start justify-content-start">-->
					<!--										<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>-->
					<!--										<li><a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a></li>-->
					<!--										<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>-->
					<!--										<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>-->
					<!--									</ul>-->
					<!--								</div>-->
					<!--							</div>-->
					<!--						</div>-->
					<!--					</div>-->
					<!--				</div>-->
					<!--			</div>-->
					<!--			<div class="footer_bar">-->
					<!--				<div class="container">-->
					<!--					<div class="row">-->
					<!--						<div class="col">-->
					<!--							<div class="footer_bar_content d-flex flex-md-row flex-column align-items-center justify-content-start">-->
					<!--								<div class="copyright order-md-1 order-2">&lt;!&ndash; Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. &ndash;&gt;-->
					<!--Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>-->
					<!--&lt;!&ndash; Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. &ndash;&gt;</div>-->
					<!--								<nav class="footer_nav ml-md-auto order-md-2 order-1">-->
					<!--									<ul class="d-flex flex-row align-items-center justify-content-start">-->
					<!--										<li><a href="category.html">Women</a></li>-->
					<!--										<li><a href="category.html">Men</a></li>-->
					<!--										<li><a href="category.html">Kids</a></li>-->
					<!--										<li><a href="category.html">Home Deco</a></li>-->
					<!--										<li><a href="#">Contact</a></li>-->
					<!--									</ul>-->
					<!--								</nav>-->
					<!--							</div>-->
					<!--						</div>-->
					<!--					</div>-->
					<!--				</div>-->
					<!--			</div>-->
					<!--		</footer>-->
					<!--	</div>-->
					<!--		-->
					<!--</div>-->

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