<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.Accessori, java.util.*"%>


<%
Accessori accessori = (Accessori) request.getAttribute("accessori");
Collection<?> accessoril = (Collection<?>) request.getAttribute("accessoril");
%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/Homepage.css" type="text/css">
<link rel="stylesheet" href="css/carosello.css" type="text/css">
<link rel="stylesheet" href="css/Catalogo.css" type="text/css">

<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<link rel="stylesheet" href="css/DettaglioArticoli.css" type="text/css">
<script type="module"
	src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script type="text/javascript" src="script/scarpe.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<style>

p {
	font-family: 'Montserrat', sans-serif;
}
h3 {
	font-family: 'Montserrat', sans-serif;
}

h1 {
	font-family: 'Montserrat', sans-serif;
}

abbr {
	font-family: 'Montserrat', sans-serif;
	font-size: 20px;
}

h2 {
	font-family: 'Montserrat', sans-serif;
}

</style>
<title>Dettagli Accessori| BossBabe</title>
</head>
<body>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>



	<%@include file="navDettagli.jsp"%>



	<%
	if (accessori != null) {
		Accessori s = (Accessori) accessori;
	%>
	<div class="container" style="margin-top: 200px;">
		<div class="row">
			<div class="col-6">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<img id=""
								src="LoadFotoAccessoriControl?copertinaAc=1&codiceAc=<%=s.getId()%>"
								onerror="this.src='../images/NoCop.jpg'">
						</div>

						<div class="item">
							<img id=""
								src="LoadFotoAccessoriControl?copertinaAc=2&codiceAc=<%=s.getId()%>"
								onerror="this.src='../images/NoCop.jpg'">
						</div>

						<div class="item">
							<img id=""
								src="LoadFotoAccessoriControl?copertinaAc=3&codiceAc=<%=s.getId()%>"
								onerror="this.src='../images/NoCop.jpg'">
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

			</div>




			<div class="col align-self-center">

				<h1 class="text-center"><%=s.getNome()%></h1>
				<h2 class="text-center"><%=s.getDescrizione()%></h2>
				<div class="text-center">
					<button class="rounded-circle text-center"
						style="background-color:<%=s.getColore()%>; border-color:<%=s.getColore()%> ;height: 16px;"></button>
				</div>

				<h1 class="text-center">
					&euro;<%=s.getPrezzo()%></h1>

				<%
				}
				%>



				<div class="text-center">
					<button class="bottone"
						style="background-color: #db44b694; color: white;">
						<ion-icon name="logo-instagram"></ion-icon>
					</button>

					<button class="bottone"
						style="background-color: #00e676; color: white; margin-left: 10px;">
						<ion-icon name="logo-whatsapp"></ion-icon>
					</button>

				</div>
			</div>
		</div>
	</div>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<div class="container">
		<h1>Articoli simili:</h1>



		<div class="row">
			<div class="col-md-12">
				<div class="carousel slide multi-item-carousel" id="theCarousel">
					<div class="carousel-inner">
						<div class="item active">
							<div class="col-xs-4">
								<a href="#1"><img id=""
									src="LoadFotoAccessoriControl?copertinaAc=1&codiceAc=1"
									onclick="visualizzaDettagliAccessori(1)"
									onerror="this.src='../images/NoCop.jpg'" class="img-responsive"></a>
								<h1>Logo BossBabe</h1>
							</div>
						</div>
						<%
						if (accessoril.size() > 0) {
							Iterator<?> it = accessoril.iterator();
							while (it.hasNext()) {
								Accessori s = (Accessori) it.next();
						%>
						<div class="item">
							<div class="col-xs-4">
								<a href="#1"><img id=""
									src="LoadFotoAccessoriControl?copertinaAc=1&codiceAc=<%=s.getId()%>"
									onclick="visualizzaDettagliAccessoriControl(<%=s.getId()%>)"
									onerror="this.src='../images/NoCop.jpg'" class="img-responsive"></a>
								<h1><%=s.getNome()%></h1>
							</div>
						</div>

						<%
						}
						}
						%>
						<a class="left carousel-control" href="#theCarousel"
							data-slide="prev"><i class="glyphicon glyphicon-chevron-left"></i></a>
						<a class="right carousel-control" href="#theCarousel"
							data-slide="next"><i
							class="glyphicon glyphicon-chevron-right"></i></a>
					</div>
				</div>
			</div>

		</div>

		<br> <br> <br>
		<script type="text/javascript">
		//Instantiate the Bootstrap carousel
		$('.multi-item-carousel').carousel({
			interval : false
		});

		// for every slide in carousel, copy the next slide's item in the slide.
		// Do the same for the next, next item.
		$('.multi-item-carousel .item').each(
				function() {
					var next = $(this).next();
					if (!next.length) {
						next = $(this).siblings(':first');
					}
					next.children(':first-child').clone().appendTo($(this));

					if (next.next().length > 0) {
						next.next().children(':first-child').clone().appendTo(
								$(this));
					} else {
						$(this).siblings(':first').children(':first-child')
								.clone().appendTo($(this));
					}
				});
	</script>
</body>
</html>