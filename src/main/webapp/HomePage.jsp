<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.Abbigliamento , java.util.*"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/Homepage.css" type="text/css">
<link rel="stylesheet" href="css/Catalogo.css" type="text/css">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@1,300&display=swap"
	rel="stylesheet">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/Catalogo.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>


<link href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
<style>
h1 {
	font-family: 'Montserrat', sans-serif;
}

h5 {
	font-family: 'Montserrat', sans-serif;
}

h6 {
	font-family: 'Montserrat', sans-serif;
}
</style>


<title>Homepage | BossBabe</title>
</head>
<body>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<%@include file="nav.jsp"%>


	<br>
	<br>
	<div class="content">
		<section>
			<div id="intro" class="bg-image"
				style="background-image: url('images/home.jpg'); height: 80vh;">
				<div class="mask">
					<div
						class="container d-flex justify-content-center align-items-center h-100">
						<div class="row align-items-center">
							<div class="col-12">
								<img class="text-center  align-middle" alt=""
									src="images/Scritta_BossBabe.png" id="scritta"
									style="margin-top: 250px; width: 100%;">
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>




		<br> <br>


		<div class="container  text-center">
			<h1>Categorie</h1>

			<div class="row align-items-center">
				<div class="col">
					<div class="card" style="width: 25rem;">
						<img src="images/Abiti.jpg" class="card-img-top hoverImg"
							width="400" height="500" alt="...">
					</div>
					<h1 class="text-center">
						<a class="categoria" href="CatalogoAbbigliamento.jsp"> Abiti</a>
					</h1>
				</div>

				<div class="col">
					<div class="card" style="width: 25rem;">
						<img src="images/Scarpe.jpg" class="card-img-top" width="400"
							height="500" alt="...">
					</div>
					<h1 class="text-center">
						<a class="categoria" href="CatalogoScarpe.jsp"> Scarpe</a>
					</h1>

				</div>

				<div class="col">
					<div class="card" style="width: 25rem;">
						<img src="images/Accessori.jpg" class="card-img-top" width="400"
							height="500" alt="...">
					</div>
					<h1 class="text-center">
						<a class="categoria" href="CatalogoAccessori.jsp"> Accessori</a>
					</h1>
				</div>
			</div>


		</div>

		<%
		Collection<?> abbigliamento = (Collection<?>) request.getAttribute("abbigliamento");

		if (abbigliamento == null) {
			response.sendRedirect(response.encodeRedirectURL("./VisualizzaNuoviArriviControl"));
			return;
		}
		%>



		<div class="container-fluid">
			<br> <br>

			<h1 class="text-center">Nuovi Arrivi</h1>
			<br> <br>
		</div>




		<div class="container" id="hover13 column">
			<div class="row align-items-center ">

				<%
				if (abbigliamento.size() > 0) {
					Iterator<?> it = abbigliamento.iterator();
					while (it.hasNext()) {
						Abbigliamento s = (Abbigliamento) it.next();
				%>
				<div class="col align-items-center">
					<div class="card-header foto"
						style="width: 22rem; margin-bottom: 25px; background-color: rgb(228 183 216/ 33%);">
						<figure>
							<img class="img-fluid img-thumbnail " id="fotoScrittaFront"
								width="400" height="500"
								onclick="visualizzaDettagliAbbigliamento(<%=s.getId()%>)"
								src="LoadFotoAbbigliamentoControl?codiceA=<%=s.getId() + "&copertinaA=1"%>"
								onerror="https://via.placeholder.com/250x350/O%20https://placeholder.com/"
								style="border-radius: 8px;">
							<img class="img-fluid img-thumbnail " id="fotoScritta"
								width="400" height="500" style="display: none"
								onclick="visualizzaDettagliAbbigliamento(<%=s.getId()%>)"
								src="LoadFotoAbbigliamentoControl?codiceA=<%=s.getId() + "&copertinaA=2"%>"
								onerror="images/NoCop.jpg" style="border-radius: 8px;">

							<div class="hilite text-center" id="tagliaScritta"
								style="display: none">
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
				var abbigliamento=$('.card-header').attr('id');

				console.log($(abbigliamento));
				$(".foto").hover(
					
				function(){
					console.log($(abbigliamento));
					
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


		<br> <br> <br> <br>



	</div>
</body>
</html>