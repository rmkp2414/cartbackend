
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Checkout</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Little Closet template">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="styles/checkout.css">
<link rel="stylesheet" type="text/css" href="styles/checkout_responsive.css">
<link rel="stylesheet" type="text/css" href="styles/custom.css">

</head>
<body>

<!-- Top Menu -->

<div class="menu">

	<!-- Search -->
	<div class="d-flex flex-row align-items-center justify-content-start">
						<div><img src="images/logo_1.png" alt=""></div>
						<div>Manu's Clothing</div>
						
	</div>
	<!-- Navigation -->
	<div class="menu_nav">
		<ul style="margin-top : 20px;">
			<li><a href="login">Login</a></li>
			<li><a href="signup">SignUp</a></li>
		</ul>
	</div>
	<!-- Contact Info -->
	<div class="menu_contact">
		<div class="menu_phone d-flex flex-row align-items-center justify-content-start">
			<div><div><img src="images/phone.svg" alt="https://www.flaticon.com/authors/freepik"></div></div>
			<div>+94 71 534 7745</div>
		</div>
		<div class="menu_social">
			<ul class="menu_social_list d-flex flex-row align-items-start justify-content-start">
				<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
				<li><a href="#"><i class="fa fa-youtube-play" aria-hidden="true"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
				<li><a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
			</ul>
		</div>
	</div>
</div>

<div class="super_container">

	<!-- Header -->

	<header class="header">
		<div class="header_overlay"></div>
		<div class="header_content d-flex flex-row align-items-center justify-content-start">
			<div class="logo">
				<a href="login">
					<div class="d-flex flex-row align-items-center justify-content-start">
						<div><img src="images/logo_1.png" alt=""></div>
						<div>Manu's Clothing</div>
					</div>
				</a>	
			</div>
			<div class="hamburger"><i class="fa fa-bars" aria-hidden="true"></i></div>
			<nav class="main_nav">
				<ul class="d-flex flex-row align-items-start justify-content-start">
					<li><a href="login">Login</a></li>
					<li><a href="signup">SignUp</a></li>
				</ul>
			</nav>
			<div class="header_right d-flex flex-row align-items-center justify-content-start ml-auto">
				<div class="header_phone d-flex flex-row align-items-center justify-content-start">
					<div><div><img src="images/phone.svg" alt="https://www.flaticon.com/authors/freepik"></div></div>
					<div>+94 71 534 7745</div>
				</div>
			</div>
		</div>
	</header>

	<div class="super_container_inner">
		<div class="super_overlay"></div>

		<!-- Home -->

		<div class="home">
			<div class="home_container d-flex flex-column align-items-center justify-content-end">
				<div class="home_content text-center">
					<div class="home_title">Manu's Clothing Sign up</div>
					<div class="breadcrumbs d-flex flex-column align-items-center justify-content-center">
						<ul class="d-flex flex-row align-items-start justify-content-start text-center">
							<li>Customer Login</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!-- Signup -->

		<div class="Signup">
			<div class="container">
			<form action="signup" th:action="@{/signup}" th:object="${signupDto}" method="post">
					<!-- Billing -->
				<div class="row">
					
					<div class="col-lg-6">
						<div class="billing">
							<div class="checkout_title">Enter Your Information</div>
							<div class="checkout_form_container">
								
									<div class="row">
										<div class="col-lg-6">
											<!-- Name -->
											<input type="text" id="firstName" name="firstName" class="checkout_input" placeholder="First Name" required="required">
										</div>
										<div class="col-lg-6">
											<!-- Last Name -->
											<input type="text" id="lastName" name="lastName" class="checkout_input" placeholder="Last Name" required="required">
										</div>
									</div>
									<!-- <div>
										Company
										<input type="text" id="checkout_company" placeholder="Company" class="checkout_input">
									</div> -->
									<div>
										<!-- Country -->
										<select name="country" id="country" class="dropdown_item_select checkout_input">
											<option value="Sri Lanka">Sri Lanka</option>
											<option value="India">India</option>
											<option value="Australia">Australia</option>
											<option value="New Zealnd">New Zealand</option>
										</select>
									</div>
									<div>
										<!-- Address -->
										<input type="text" id="addressLine1" name="addressLine1" class="checkout_input" placeholder="Address Line 1" required="required">
										<input type="text" id="addressLine2" name="addressLine2" class="checkout_input" placeholder="Address Line 2" required="required">
									</div>
									<div>
										<!-- Zipcode -->
										<input type="number" id="zipCode" name="zipCode" class="checkout_input" placeholder="Zip Code" required="required">
									</div>
									<div>
										<!-- City / Town -->
										<input type="text" id="city" name="city" class="checkout_input" placeholder="City" required="required">
										<!-- <select name="city" id="city"  class="dropdown_item_select checkout_input" require="required">
											<option>City / Town</option>
											<option>City</option>
											<option>City</option>
											<option>City</option>
											<option>City</option>
										</select> -->
									</div>
									<div>
										<!-- Province -->
										<select name="province" id="province" class="dropdown_item_select checkout_input">
											<option value="Western">Western Province</option>
											<option value="Central Province">Central Province</option>
											<option value="Southern Province">Southern Province </option>
										</select>
									</div>
									<div>
										<!-- Phone no -->
										<input type="number" id="phoneNumber" name="phoneNumber" class="checkout_input" placeholder="Phone No" required="required">
									</div>
									<div>
										<!-- Email -->
										<input type="email" id="email" name="email" class="checkout_input" placeholder="Email" required="required">
									</div>
<!--									<div class="checkout_extra">-->
<!--										<ul>-->
<!--											<li class="billing_info d-flex flex-row align-items-center justify-content-start">-->
<!--												<label class="checkbox_container">-->
<!--													<input type="checkbox" id="cb_1" name="billing_checkbox" class="billing_checkbox">-->
<!--													<span class="checkbox_mark"></span>-->
<!--													<span class="checkbox_text">Terms and conditions</span>-->
<!--												</label>-->
<!--											</li>-->
<!--											<li class="billing_info d-flex flex-row align-items-center justify-content-start">-->
<!--												<label class="checkbox_container">-->
<!--													<input type="checkbox" id="cb_2" name="billing_checkbox" class="billing_checkbox">-->
<!--													<span class="checkbox_mark"></span>-->
<!--													<span class="checkbox_text">Create an account</span>-->
<!--												</label>-->
<!--											</li>-->
<!--											<li class="billing_info d-flex flex-row align-items-center justify-content-start">-->
<!--												<label class="checkbox_container">-->
<!--													<input type="checkbox" id="cb_3" name="billing_checkbox" class="billing_checkbox">-->
<!--													<span class="checkbox_mark"></span>-->
<!--													<span class="checkbox_text">Subscribe to our newsletter</span>-->
<!--												</label>-->
<!--											</li>-->
<!--										</ul>-->
<!--									</div>-->
								
							</div>
						</div>
					</div>

					<!-- Cart Total -->
					<div class="col-lg-6 cart_col">
						<div class="cart_total">
							<div class="cart_extra_content cart_extra_total">

								<div class="checkout_title">Enter Your login credentials</div>
								<br>
								<div>
									<!-- Company -->
									<input type="text" id="username" name="username" placeholder="Username" class="checkout_input">
								</div>
								<br>
								<div>
									<!-- Company -->
									<input type="password" id="password" name="password" placeholder="Password" class="checkout_input">
								</div>
								<br>
								<div>
									<!-- Company -->
									<input type="password" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" class="checkout_input">
								</div>

<!--								<div class="payment_options">-->
<!--									<div class="checkout_title">Payment</div>-->
<!--									<ul>-->
<!--										<li class="shipping_option d-flex flex-row align-items-center justify-content-start">-->
<!--											<label class="radio_container">-->
<!--												<input type="radio" id="radio_1" name="payment_radio" class="payment_radio">-->
<!--												<span class="radio_mark"></span>-->
<!--												<span class="radio_text">Paypal</span>-->
<!--											</label>-->
<!--										</li>-->
<!--										<li class="shipping_option d-flex flex-row align-items-center justify-content-start">-->
<!--											<label class="radio_container">-->
<!--												<input type="radio" id="radio_2" name="payment_radio" class="payment_radio">-->
<!--												<span class="radio_mark"></span>-->
<!--												<span class="radio_text">Cash on Delivery</span>-->
<!--											</label>-->
<!--										</li>-->
<!--										<li class="shipping_option d-flex flex-row align-items-center justify-content-start">-->
<!--											<label class="radio_container">-->
<!--												<input type="radio" id="radio_3" name="payment_radio" class="payment_radio" checked>-->
<!--												<span class="radio_mark"></span>-->
<!--												<span class="radio_text">Credit Card</span>-->
<!--											</label>-->
<!--										</li>-->
<!--									</ul>-->
<!--								</div>-->
									<p><input type="submit" value="Submit" class="checkout_button trans_200 login_btn" /> 
									<input type="reset" value="Reset" class="checkout_button trans_200 login_btn" /></p>
									<p class="error_block">${statusMessage}</p>
								<div class=" "></div>
							</div>
						</div>
					</div>
					
				</div>
			</form>
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
<script src="js/checkout.js"></script>
</body>
</html>