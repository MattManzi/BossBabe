<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.Accessori, java.util.*"%>

<%
Collection<?> accessori = (Collection<?>) request.getAttribute("accessori");

if (accessori == null) {
	response.sendRedirect(response.encodeRedirectURL("./VisualizzaCatalogoAccessoriControl"));
	return;
}
%>

<!DOCTYPE html>
<html>

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/Homepage.css" type="text/css">
<link rel="stylesheet" href="css/Catalogo.css" type="text/css">
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/Catalogo.css" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>

<script type="text/javascript" src="script/accessori.js"></script>
<title>Catalogo Accessori | BossBabe</title>
</head>
<body>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<%@include file="nav.jsp"%>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<h1 class="text-center">I Nostri Accessori</h1>

	<br>


	<div class="container" id="hover13 column">
		<div class="row align-items-center ">

			<%
			if (accessori.size() > 0) {
				Iterator<?> it = accessori.iterator();
				while (it.hasNext()) {
					Accessori s = (Accessori) it.next();
			%>
			<div class="col align-items-center">
				<div class="card-header foto" 	style="width: 22rem; margin-bottom: 25px; background-color: rgb(228 183 216/ 33%);">
					<figure>
						<img class="img-fluid img-thumbnail " id="fotoScrittaFront"
							onclick="visualizzaDettagliAccessoriControl(<%=s.getId()%>)"
							src="LoadFotoAccessoriControl?codiceAc=<%=s.getId() + "&copertinaAc=1"%>"
							onerror="https://via.placeholder.com/250x350/O%20https://placeholder.com/"
							style="border-radius: 8px;">
						<img class="img-fluid img-thumbnail " id="fotoScritta"
							style="display: none"
							onclick="visualizzaDettagliAccessoriControl(<%=s.getId()%>)"
							src="LoadFotoAccessoriControl?codiceAc=<%=s.getId() + "&copertinaAc=2"%>"
							onerror="images/NoCop.jpg" style="border-radius: 8px;">

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

		</div>
	</div>

	<script>
			$(document).ready(function(){
				var accessori=$('.card-header').attr('id');

				console.log($(accessori));
				$(".foto").hover(
					
				function(){
					console.log($(accessori));
					
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

</body>
</html>