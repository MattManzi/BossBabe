<!doctype html>
<html lang="en">



<head>
<!-- Required meta tags -->
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/Homepage.css" type="text/css">
<link rel="stylesheet" href="css/menuNav.css" type="text/css">
<script type="text/javascript" src="script/abbigliamento.js"></script>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@1,300&display=swap"
	rel="stylesheet">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">

<style>
a {
	font-family: 'Montserrat', sans-serif;
	text-decoration: none;
}
</style>
<title>Hello, world!</title>
</head>
<body class="home">


	<header>
		<!-- Navbar -->
		<nav
			class="navbar navbar-expand-lg fixed-top navbar-dark  navbar-scroll bg-dark"
			style="margin-top: 0px; padding: 0px; padding-bottom: 18px;">
			<div>
				<img class="oggettiNav scritta" src="images/Scritta_BossBabe.png"
					alt="" width="250" height="60">

				<button class="navbar-toggler float-left" type="button"
					style="margin: 25px 900px 6px 20px;" data-bs-toggle="collapse"
					data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse justify-content-center"
				id="navbarSupportedContent">


				<div class="" style="margin-top: 90px;" id="navbarSupportedContent">
					<ul class="navbar-nav ml-5 ml-lg-5 menu">
						<li class="nav-item "><a class="nav-link active"
							aria-current="page" href="HomePage.jsp">HOME</a></li>

						<li class="nav-item dropdown"><a class="nav-link active"
							aria-current="page" href="CatalogoAbbigliamento.jsp">ABBIGLIAMENTO</a>
							<ul class="submenu">
								<li><a class="categoria" href="<%=response.encodeURL("VisualizzaMagliaControl")%>">Maglie Camicie e Top</a></li>
								<li><a class="categoria" href="<%=response.encodeURL("VisualizzaPantaloniControl")%>">Pantaloni</a></li>
								<li><a class="categoria" href="<%=response.encodeURL("VisualizzaDressControl")%>">Dress</a></li>
								<li><a class="categoria" href="<%=response.encodeURL("VisualizzaShortControl")%>">Short</a></li>
								<li><a class="categoria" href="<%=response.encodeURL("VisualizzaGiaccheControl")%>">Giacche</a></li>
							</ul></li>
						<li class="nav-item "><a class="nav-link active"
							aria-current="page" href="CatalogoScarpe.jsp">SCARPE</a></li>
						<li class="nav-item dropdown"><a class="nav-link active"
							aria-current="page" href="CatalogoAccessori.jsp">ACCESSORI</a>
							<ul class="submenu">
								<li><a class="categoria" href="<%=response.encodeURL("VisualizzaBijouxControl")%>">Bijoux</a></li>
								<li><a class="categoria" href="<%=response.encodeURL("VisualizzaCintureControl")%>">Cinture</a></li>
								<li><a class="categoria" href="<%=response.encodeURL("VisualizzaBorseControl")%>">Borse</a></li>
							</ul></li>

						<li class="nav-item"><a class="nav-link disabled" href="#"></a>
						</li>
					</ul>



				</div>
			</div>
		</nav>

	</header>

	<script>
		$(document).ready(function() {
			$("button").click(function() {
				$(".oggettiNav").addClass("intro");
			});
		});
	</script>

	<script>
		$(document).ready(function() {
			var scarpe = $('.card-header').attr('id');

			console.log($(scarpe));
			$(".foto").hover(

			function() {
				console.log($(scarpe));

				$(this).find("#tagliaScritta").show();
				$(this).find("#fotoScritta").show();
				$(this).find("#fotoScrittaFront").hide();
			}, function() {
				$(this).find("#tagliaScritta").hide();
				$(this).find("#fotoScritta").hide();
				$(this).find("#fotoScrittaFront").show();
			});

		});
	</script>

	<script type="text/javascript">
		$(function() {
			var $dropdowns = $('li.dropdown'); // Specifying the element is faster for older browsers

			/**
			 * Mouse events
			 *
			 * @description Mimic hoverIntent plugin by waiting for the mouse to 'settle' within the target before triggering
			 */
			$dropdowns.on(
					'mouseover',
					function() // Mouseenter (used with .hover()) does not trigger when user enters from outside document window
					{
						var $this = $(this);

						if ($this.prop('hoverTimeout')) {
							$this.prop('hoverTimeout', clearTimeout($this
									.prop('hoverTimeout')));
						}

						$this.prop('hoverIntent', setTimeout(function() {
							$this.addClass('hover');
						}, 250));
					}).on(
					'mouseleave',
					function() {
						var $this = $(this);

						if ($this.prop('hoverIntent')) {
							$this.prop('hoverIntent', clearTimeout($this
									.prop('hoverIntent')));
						}

						$this.prop('hoverTimeout', setTimeout(function() {
							$this.removeClass('hover');
						}, 250));
					});

		});
	</script>


	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"></script>
</body>
</html>