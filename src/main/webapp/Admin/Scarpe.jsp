<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.Scarpe, java.util.*"%>

<%
Collection<?> scarpe = (Collection<?>) request.getAttribute("scarpe");

if (scarpe == null) {
	System.out.println(scarpe);
	response.sendRedirect(response.encodeRedirectURL("./VisualizzaScarpeControl"));

	return;
}
%>


<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<script type="text/javascript" src="../script/scarpe.js"></script>
<link rel="stylesheet" href="../css/Catalgo.css" type="text/css">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>


<style>
body{
width: 100%}
fieldset {
	margin: 10px;
	padding: 35px;
	border-block: 1;
	border: solid 1.5px;
}

input {
	margin: 5px;
}
</style>
<title>Magazzino Scarpe</title>


<script>
  $( function() {
    $( "#dialog-form" ).dialog({
      autoOpen: false,
      show: {

        duration: 10
      },
      hide: {
        duration: 10
      }
    });
 
    
    
    
    $( ".modifica" ).on( "click", function() {
    	
      $( "#dialog-form" ).dialog( "open" );
      var id=(this).id;
      console.log($('.modifica').attr('id'));
       $("<h1>id</h1>").appendTo($("#dialog-form"))
    });
  } );
  
  </script>


</head>



<body>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>


	<div class="container">
		<h1 class="text-center">Gestionale Scarpe</h1>
		<div class="row">
			<div class="col-sm">
				<fieldset>
					<legend>Aggiunta Scarpe</legend>
					<form action="<%=response.encodeURL("AggiuntaScarpeControl")%>"
						method="post">
						<table>

							<tr>
								<td><label for="nomeS"></label>Nome</td>
								<td><input id="nomeS" type="text" name="nomeS"></td>
								<td><label for="descrizioneS">Descrizione</label></td>
								<td><input id="descrizioneS" type="text"
									name="descrizioneS"></td>
							</tr>
							<tr>
								<td><label for="coloreS">Colore</label></td>
								<td><select name="coloreS" id="coloreS">
										<option selected value=""></option>
										<option value="black">Nero</option>
										<option value="white">Bianco</option>
										<option value="azure">Azzurro</option>
										<option value="orange">Arancione</option>
										<option value="yellow">Giallo</option>
										<option value="gray">Grigio</option>
										<option value="brown">Marrone</option>
										<option value="goldenrod">Oro</option>
										<option value="red">Rosso</option>
										<option value="lightpink">Rosa chiaro</option>
										<option value="pink">Rosa</option>
										<option value="green">Verde</option>
										<option value="plum">Viola</option>
								</select></td>

								<td colspan="2"><input type="submit"
									class="buttonStandard box" value="Conferma" style="width: auto"></td>
							</tr>
						</table>
					</form>
				</fieldset>
			</div>
			<%
			if (scarpe != null && scarpe.size() > 0) {
				Iterator<?> it = scarpe.iterator();
			%>
			<div class="col-sm">
				<fieldset>
					<legend>Foto</legend>
					<form id="formFile" name="formFile"
						action="<%=response.encodeURL("UploadFotoScarpeControl")%> "
						enctype="multipart/form-data" method="post">
						<table>
							<tr>
								<td colspan="2"><input id="fileCop" class="file normal"
									type="file" name="talkPhoto" value="" maxlength="255"
									accept="image/*" style="width: auto"></td>
							</tr>
							<tr>
								<td><label for=codice>ID:</label></td>
								<td><select name="codice" id="codiceCop">
										<option selected value=""></option>
										<%
										while (it.hasNext()) {
											Scarpe s = (Scarpe) it.next();
											if (!s.isCopertina()) {
										%>

										<option value="<%=s.getId()%>"><%=s.getNome()%> -
											<%=s.getColore()%></option>

										<%
										}
										}
										}
										%>
								</select></td>
								<td><label for="copertina">Foto</label></td>
								<td><select name="copertina" id="copertina">
										<option selected value=""></option>

										<option value="0">Foto 1</option>
										<option value="2">Foto 2</option>
										<option value="3">Foto 3</option>
								</select></td>
							</tr>
							<tr>

								<td colspan="2"><input type="submit"
									class="buttonStandard box" value="Conferma" style="width: auto"></td>

							</tr>
						</table>
					</form>
				</fieldset>
			</div>
		</div>
	</div>


	<div class="container">
		<h1>Magazzino Scarpe</h1>


		<table class="table" style=" margin-left: -86px;">
			<tr>
				<th><a></a>
				<th scope="col"><a>Nome</a></th>
				<th scope="col"><a>Descrizione</a></th>
				<th scope="col"><a>Colore</a></th>
				<th scope="col"><a>Taglia 36</a></th>
				<th scope="col"><a>Taglia 36.5</a></th>
				<th scope="col"><a>Taglia 37</a></th>
				<th scope="col"><a>Taglia 37.5</a></th>
				<th scope="col"><a>Taglia 38</a></th>
				<th scope="col"><a>Taglia 38.5</a></th>
				<th scope="col"><a>Taglia 39</a></th>
				<th scope="col"><a>Taglia 39.5</a></th>
				<th scope="col"><a>Taglia 40</a></th>
				<th scope="col"><a>Taglia 40.5</a></th>
				<th scope="col"><a>Taglia 41</a></th>
				<th scope="col"><a>Prezzo</a></th>
				<th scope="col"><a>Modifica</a></th>
				<th scope="col"><a>Elimina</a></th>
				<th scope="col"><a>New</a></th>
				<th scope="col"><a>Foto 1</a></th>
				<th scope="col"><a>Foto 2</a></th>
				<th scope="col"><a>Foto 3</a></th>

			</tr>

			<%
			if (scarpe != null && scarpe.size() > 0) {
				Iterator<?> it = scarpe.iterator();
				while (it.hasNext()) {
					Scarpe s = (Scarpe) it.next();
			%>

			<tr>
				<td><form id="<%="formModS" + s.getId()%>"
						action="<%=response.encodeURL("ModificaScarpeControl")%>">
						<input type="hidden" name="id" value="<%=s.getId()%>">
					</form></td>

				<td><a><%=s.getNome()%></a></td>
				<td><a><%=s.getDescrizione()%></a></td>
				<td><a><%=s.getColore()%></a></td>
				<%
				String[] splitted = s.getTaglia().split("-");
				for (int i = 0; i < splitted.length; i++) {
				%>

				<td><%=splitted[i]%><input form="<%="formModS" + s.getId()%>"
					maxlength="3" style="width: 35px;" type="text"
					name="<%="Taglia" + i%>" value="<%=splitted[i]%>"></input></td>
				<%
				}
				%>
				<td><a><%=s.getPrezzo()%></a><input
					form="<%="formModS" + s.getId()%>" type="text" name="prezzoS"
					maxlength="3" style="width: 40px;" value=""></input></td>
				<td><input form="<%="formModS" + s.getId()%>" type="submit"
					value="M"></td>
				<td><button onclick="cancellaScarpe(<%=s.getId()%>)">X</button></td>
				<td><button onclick="NewScarpe(<%=s.getId()%>)"><%=s.isNuovo()%></button></td>

				<td><img id="copertina" class="rounded "
					style="height: 110px; width: 100px"
					src="../LoadFotoScarpeControl?copertinaS=1&codiceS=<%=s.getId()%>"
					onerror="this.src='../images/NoCop.jpg'"></td>
				<td><img id="copertina" class="rounded "
					style="height: 110px; width: 100px"
					src="../LoadFotoScarpeControl?copertinaS=2&codiceS=<%=s.getId()%>"
					onerror="this.src='../images/NoCop.jpg'"></td>
				<td><img id="copertina" class="rounded "
					style="height: 110px; width: 100px"
					src="../LoadFotoScarpeControl?copertinaS=3&codiceS=<%=s.getId()%>"
					onerror="this.src='../images/NoCop.jpg'"></td>

			</tr>


			<%
			}
			}
			%>

		</table>
	</div>
</body>
</html>