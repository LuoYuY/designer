<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>首 页</title>
<!-- custom-theme -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Upholstery Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!-- //custom-theme -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" property="" />
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<link rel="stylesheet" href="css/font-awesome.min.css" />
<!-- //font-awesome-icons -->
<link
	href="//fonts.googleapis.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	rel="stylesheet">
</head>

<body>
	<!-- banner -->
	<div class="banner jarallax">
		<div class="agile_dot_info one">
			<div class="container">
				<nav class="navbar navbar-default">
				<div class="navbar-header navbar-left">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<h1>
						<a class="navbar-brand" href="index.html" style="font-size: 30px;">初见室内设计交易平台</a>
					</h1>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse navbar-right"
					id="bs-example-navbar-collapse-1">
					<nav class="link-effect-8" id="link-effect-8">
					<ul class="nav navbar-nav">
						<li class="active"><a href="index.html">首页</a></li>
						<li><a href="findAllExample">看案例</a></li>
						<li><a href="findneeds">找需求</a></li>
						<li><a href="contact.jsp">查找设计师 </a>
						
						<s:if test="%{#session.id==null}">
							<li><a href="login.jsp">登陆</a></li>
							<li><a href="contact.html">注册</a></li>
						</s:if>
						
						<s:else>
						
							
						  <s:if test="%{#session.designer!=null}">
						  <li><a href="judge.action" target="_Blank">个人主页</a>
							</li>
							<li><a href="designerIndex.jsp">个人中心</a></li>
						  </s:if>
						  <s:elseif test="%{#session.employer!=null}">
						 
							<li><a href="employerIndex.jsp">个人中心</a></li>
						  </s:elseif>
						</s:else>
						
						
						
							
							
					</ul>
					</nav>
				</div>
				</nav>

				<div class="w3_agile_banner_info">
					<div class="maintitle">
						<p>发布项目，按需雇佣设计师</p>
						<p>1小时内对接设计师</p>
					</div>
					<div class="mainbutton">

						<s:if test="%{#session.designer!=null}">
							<a href="findneeds"><input class="button button_border"
								type="button" value="接受项目" style="margin-top: 4px;"></input></a>
							<a href="uploadCase.jsp"><input class="button button_shadow"
								type="button" value="上传案例"></input></a>
						</s:if>
						<s:else>
							<s:if test="%{#session.employer!=null}">
								<a href="#"><input class="button button_border"
									type="button" value="发布需求"></input></a>
								<a href="findall.action"><input class="button button_border"
									type="button" value="浏览案例"></input></a>
							</s:if>
							<s:else>
								<a href="#"><input class="button button_border"
									type="button" value="发布需求" style="margin-top: 4px;"></input></a>
								<a href="#"><input class="button button_shadow"
									type="button" value="成为设计师"></input></a>
							</s:else>
						</s:else>
					</div>
				</div>


			</div>
		</div>
	</div>
	<!-- //banner -->

	<!-- special -->
	
	
	<!-- team -->
	<div class="team">
		<div class="container">
			<h3 class="w3ls_head">
				<span>优秀设计师</span>
			</h3>
			
			<div class="agileits_team_grids">
				<div class="col-md-4 agileits_team_grid">
					<div class="agileits_team_grid_figure">
						<img src="images/t1.jpg" alt=" " class="img-responsive" />
					</div>
					<h4>Jane Nguyen</h4>
					<p>General Manager</p>
					<p>+21 345 287 4556</p>
					<div class="social-icon">
						<a href="#" class="social-button facebook"><i
							class="fa fa-facebook"></i></a> <a href="#"
							class="social-button twitter"><i class="fa fa-twitter"></i></a> <a
							href="#" class="social-button google"><i
							class="fa fa-google-plus"></i></a> <a href="#"
							class="social-button dribbble"><i class="fa fa-dribbble"></i></a>
					</div>
				</div>
				<div class="col-md-4 agileits_team_grid">
					<div class="agileits_team_grid_figure">
						<img src="images/t2.jpg" alt=" " class="img-responsive" />
					</div>
					<h4>James Doe</h4>
					<p>Finance Executive</p>
					<p>+21 345 287 4556</p>
					<div class="social-icon">
						<a href="#" class="social-button facebook"><i
							class="fa fa-facebook"></i></a> <a href="#"
							class="social-button twitter"><i class="fa fa-twitter"></i></a> <a
							href="#" class="social-button google"><i
							class="fa fa-google-plus"></i></a> <a href="#"
							class="social-button dribbble"><i class="fa fa-dribbble"></i></a>
					</div>
				</div>
				<div class="col-md-4 agileits_team_grid">
					<div class="agileits_team_grid_figure">
						<img src="images/t3.jpg" alt=" " class="img-responsive" />
					</div>
					<h4>Laura Carl</h4>
					<p>Management</p>
					<p>+21 345 287 4556</p>
					<div class="social-icon">
						<a href="#" class="social-button facebook"><i
							class="fa fa-facebook"></i></a> <a href="#"
							class="social-button twitter"><i class="fa fa-twitter"></i></a> <a
							href="#" class="social-button google"><i
							class="fa fa-google-plus"></i></a> <a href="#"
							class="social-button dribbble"><i class="fa fa-dribbble"></i></a>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- //team -->

	<!-- footer -->
	<div class="footer">
		<div class="container">
			<div class="w3_agile_footer_grids">
				<div class="col-md-4 w3_agile_footer_grid">
					<h3>Latest Tweets</h3>
					<ul class="agile_footer_grid_list">
						<li><i class="fa fa-twitter" aria-hidden="true"></i>Nam
							libero tempore, cum soluta nobis est eligendi optio cumque nihil
							impedit. <span>1 day ago</span></li>
						<li><i class="fa fa-twitter" aria-hidden="true"></i>Itaque
							earum rerum hic tenetur a sapiente delectus <a
							href="mailto:info@mail.com">info@mail.com</a> cumque nihil
							impedit. <span>2 days ago</span></li>
					</ul>
				</div>
				<div class="col-md-4 w3_agile_footer_grid">
					<h3>Navigation</h3>
					<ul class="agileits_w3layouts_footer_grid_list">
						<li><i class="fa fa-angle-double-right" aria-hidden="true"></i><a
							href="index.html">Home</a></li>
						<li><i class="fa fa-angle-double-right" aria-hidden="true"></i><a
							href="services.html">Services</a></li>
						<li><i class="fa fa-angle-double-right" aria-hidden="true"></i><a
							href="projects.html">Projects</a></li>
						<li><i class="fa fa-angle-double-right" aria-hidden="true"></i><a
							href="contact.html">Contact</a></li>
					</ul>
				</div>
				<div class="col-md-4 w3_agile_footer_grid">
					<h3>Latest Works</h3>
					<div class="w3_agileits_footer_grid_left">
						<a href="#"><img src="images/s6.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="w3_agileits_footer_grid_left">
						<a href="#"><img src="images/s2.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="w3_agileits_footer_grid_left">
						<a href="#"><img src="images/s1.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="w3_agileits_footer_grid_left">
						<a href="#"><img src="images/s3.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="w3_agileits_footer_grid_left">
						<a href="#"><img src="images/s4.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="w3_agileits_footer_grid_left">
						<a href="#"><img src="images/s5.jpg" alt=" "
							class="img-responsive" /></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="w3_newsletter_footer_grids">
				<div class="w3_newsletter_footer_grid_left">
					<form action="#" method="post">
						<input type="email" name="Email" placeholder="Email" required="">
						<input type="submit" value="Send">
					</form>
				</div>


			</div>

			<div class="agileinfo_copyright">
				<p>
					© 2018 Upholstery. All Rights Reserved | Design by <a
						href="https://w3layouts.com/">W3layouts</a>
				</p>
			</div>
		</div>
	</div>
	<!-- //footer -->
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->

	<!-- for bootstrap working -->
	<script src="js/bootstrap.js"></script>
	<!-- //for bootstrap working -->
	<!-- carousal -->
	<script src="js/slick.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(document).on('ready', function() {
			$(".center").slick({
				dots : true,
				infinite : true,
				centerMode : true,
				slidesToShow : 2,
				slidesToScroll : 2,
				responsive : [ {
					breakpoint : 768,
					settings : {
						arrows : true,
						centerMode : false,
						slidesToShow : 2
					}
				}, {
					breakpoint : 480,
					settings : {
						arrows : true,
						centerMode : false,
						centerPadding : '40px',
						slidesToShow : 1
					}
				} ]
			});
		});
	</script>
	<!-- //carousal -->

	<script src="js/SmoothScroll.min.js"></script>
	<script type="text/javascript">
		/* init Jarallax */
		$('.jarallax').jarallax({
			speed : 0.5,
			imgWidth : 1366,
			imgHeight : 768
		})
	</script>
	<!-- stats -->
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.countup.js"></script>
	<script>
		$('.counter').countUp();
	</script>
	<!-- //stats -->

</body>
</html>