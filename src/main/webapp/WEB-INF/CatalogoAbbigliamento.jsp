<%@page import="bean.Abbigliamento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.Scarpe, java.util.*"%>

<%
Collection<?> abbigliamento = (Collection<?>) request.getAttribute("abbigliamento");

if (abbigliamento == null) {
	response.sendRedirect(response.encodeRedirectURL("./VisualizzaCatalogoAbbigliementoControl"));
	return;
}
%>
<!doctype html>
<html lang="en">
<head>

<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/Catalogo.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<script type="text/javascript" src="script/scarpe.js"></script>


<title>Catalogo Abbigliamento | BossBabe</title>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>


	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<img src="images/Scritta_BossBabe.jpg" width="150" height="100">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="HomePage.jsp">Home</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Articoli </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="CatalogoAbbigliemento.jsp">Abbigliamento</a></li>
							<li><a class="dropdown-item" href="CatalogoScarpe.jsp">Scarpe</a></li>
							<li><a class="dropdown-item" href="CatalogoAccessori.jsp">Accessori</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Offerte</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<h1 class="text-center">I Nostri Capi</h1>

	<br>


	<div class="container" id="hover13 column">
		<div class="row align-items-center ">

			<%
			if (abbigliamento.size() > 0) {
				Iterator<?> it = abbigliamento.iterator();
				while (it.hasNext()) {
					Abbigliamento s = (Abbigliamento) it.next();
			%>
			<div class="col align-items-center">
				<div class="card-header foto" style="width: 22rem;">
					<figure>
						<img class="img-fluid img-thumbnail " id="fotoScrittaFront"
							onclick="visualizzaDettagliScarpa(<%=s.getId()%>)"
							src="LoadFotoScarpeControl?codiceS=<%=s.getId() + "&copertinaS=1"%>"
							onerror="https://via.placeholder.com/250x350/O%20https://placeholder.com/"
							style="border-radius: 8px;">
						<img class="img-fluid img-thumbnail " id="fotoScritta"
							style="display: none"
							onclick="visualizzaDettagliScarpa(<%=s.getId()%>)"
							src="LoadFotoScarpeControl?codiceS=<%=s.getId() + "&copertinaS=2"%>"
							onerror="images/NoCop.jpg" style="border-radius: 8px;">

						<div class="hilite text-center" id="tagliaScritta" style="display: none">
							<%
							String[] taglie = {"S", "M", "L", "XL", "TU"};
							String[] splitted = s.getTaglia().split("-");
							for (int i = 0; i < splitted.length; i++) {

								if (splitted[i].equals("0")) {
							%>
							<h6 style="display: none"><%=taglie[i]%>
							</h6>

							<%
							} else {
							%>
							<h6 class="text-center" style="color: withe;">
								<%=taglie[i]%></h6>
							<%
							}
							}
							%>

						</div>
					</figure>
					<div class="card-body">
						<h5 class="text-center" href=""><%=s.getNome()%></h5>
						<h6 class="text-center"><%=s.getDescrizione()%></h6>
					</div>
				</div>
			</div>


			<%
			}
			}
			%>

			<script>
			$(document).ready(function(){
				var scarpe=$('.card-header').attr('id');

				console.log($(scarpe));
				$(".foto").hover(
					
				function(){
					console.log($(scarpe));
					
					$(this).find("#tagliaScritta").show();
					$(this).find("#fotoScritta").show();
					$(this).find("#fotoScrittaFront").hide();
				}, function () {
					$(this).find("#tagliaScritta").hide();
					$(this).find("#fotoScritta").hide();
					$(this).find("#fotoScrittaFront").show();
				});
				
			});
			</script>


		</div>
	</div>










	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->
</body>
</html>