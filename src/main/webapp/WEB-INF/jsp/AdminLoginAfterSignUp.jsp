<%--
  Created by IntelliJ IDEA.
  User: Manuja
  Date: 9/26/2020
  Time: 3:36 PM
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="Little Closet template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="../styles/bootstrap-4.1.2/bootstrap.min.css">
<link href="../plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../styles/checkout.css">
<link rel="stylesheet" type="text/css" href="../styles/checkout_responsive.css">
<link rel="stylesheet" type="text/css" href="../styles/custom.css">
</head>
<body>

<!-- Top Menu -->

<div class="menu">

	<!-- Search -->
	<div class="d-flex flex-row align-items-center justify-content-start">
						<div><img src="images/logo_1.png" alt=""></div>
						<div>Manu's Clothing Admin</div>
						
	</div>
	<!-- Navigation -->
	<div class="menu_nav">
		<ul style="margin-top : 20px;">
			<li><a href="login">Login</a></li>
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

	<!-- Header -->

	<header class="header">
		<div class="header_overlay"></div>
		<div class="header_content d-flex flex-row align-items-center justify-content-start">
			<div class="logo">
				<a href="#">
					<div class="d-flex flex-row align-items-center justify-content-start">
						<div><img src="../../images/logo_1.png" alt=""></div>
						<div>Manu's Clothing Admin</div>
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
				<!-- Search -->
				<!-- <div class="header_search">
					<form action="#" id="header_search_form">
						<input type="text" class="search_input" placeholder="Search Item" required="required">
						<button class="header_search_button"><img src="images/search.png" alt=""></button>
					</form>
				</div>
				User
				<div class="user"><a href="#"><div><img src="images/user.svg" alt="https://www.flaticon.com/authors/freepik"><div>1</div></div></a></div>
				Cart
				<div class="cart"><a href="cart.html"><div><img src="images/cart.svg" alt="https://www.flaticon.com/authors/freepik"></div></a></div> -->
				<!-- Phone -->
				<div class="header_phone d-flex flex-row align-items-center justify-content-start">
					<div><div><img src="../images/phone.svg" alt="https://www.flaticon.com/authors/freepik"></div></div>
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
					<div class="home_title">Admin Portal Login</div>
					<div class="breadcrumbs d-flex flex-column align-items-center justify-content-center">
						<ul class="d-flex flex-row align-items-start justify-content-start text-center">
							<li><a href="#">Admin</a></li>
							<li>Login</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!-- Signup -->
		<div class="Signup" align="center">
			<div class="container" >
				<div class="row">
					

					<div class="col-12">
						<div class="col-lg-6 cart_col" >
							<div class="cart_total" >
								<div class="cart_extra_content cart_extra_total">
									<form action="login" th:action="@{/login}" th:object="${loginDto}" method="post">
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
									
									<p><input type="submit" value="Submit" class="checkout_button trans_200 login_btn" /> 
									<input type="reset" value="Reset" class="checkout_button trans_200 login_btn" /></p>
									
									<p style="color : crimson; font-weight: 400;">${loginstatus}</p>
									</form>
									<!-- <div class="checkout_button trans_200"><a href="loginSubmit">Sign me in</a></div> -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
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
<script src="../plugins/easing/easing.js"></script>
<script src="../plugins/parallax-js-master/parallax.min.js"></script>
<script src="../js/checkout.js"></script>
</body>
</html>