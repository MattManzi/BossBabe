<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.Scarpe, java.util.*"%>

<%
Collection<?> scarpe = (Collection<?>) request.getAttribute("scarpe");

if (scarpe == null) {
	response.sendRedirect(response.encodeRedirectURL("./VisualizzaCatalogoScarpeControl"));
	return;
}
%>
<!doctype html>
<html lang="en">
<head>
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
<script type="text/javascript" src="script/scarpe.js"></script>


<title>Catalogo Scarpe | BossBabe</title>
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


	<h1 class="text-center">Le Nostre Scarpe</h1>
	<br>
	<div class="container" id="hover13 column">
		<div class="row align-items-center ">

			<%
			if (scarpe.size() > 0) {
				Iterator<?> it = scarpe.iterator();
				while (it.hasNext()) {
					Scarpe s = (Scarpe) it.next();
			%>
			<div class="col align-items-center">
				<div class="card-header foto" 	style="width: 22rem; margin-bottom: 25px; background-color: rgb(228 183 216/ 33%);">
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

						<div class="hilite text-center" id="tagliaScritta"
							style="display: none">
							<%
							String[] taglie = {"36", "36.5", "37", "37.5", "38", "38.5", "39", "39.5", "40", "40.5", "41"};
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

		</div>
	</div>

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














    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

</body>
</html>