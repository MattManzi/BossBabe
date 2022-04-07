<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.Accessori, java.util.*"%>

<%
Collection<?> accessori = (Collection<?>) request.getAttribute("accessori");

if (accessori == null) {
	System.out.println(accessori);
	response.sendRedirect(response.encodeRedirectURL("./VisualizzaAccessoriControl"));

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
<script type="text/javascript" src="../script/accessori.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>

<style>

fieldset {
    margin: 10px;
    padding: 35px;
    border-block: 1;
    border: solid 1.5px;
}

input{
    margin: 5px;
    }


</style>


<title>Magazzino Accessori</title>


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

	<br>
	<br>
	
		<div class="container">
		<h1 class="text-center">Gestionale Accessori</h1>
		<div class="row">
			<div class="col-sm">
				<fieldset>
					<legend>Aggiunta Accessori</legend>
					<form action="<%=response.encodeURL("AggiuntaAccessoriControl")%>"
						method="post">
						<table>

							<tr>
								<td><label for="nomeAc"></label>Nome</td>
								<td><input id="nomeAc" type="text" name="nomeAc"></td>

								<td><label for="descrizioneAc">Descrizione</label></td>
								<td><input id="descrizioneAc" type="text"
									name="descrizioneAc"></td>
							</tr>
							<tr>
								<td><label for="tipoAc">Tipo</label></td>
								<td><select name="tipoAc" id="tipoAc">
										<option selected value=""></option>
										<option value="Bijoux">Bijoux</option>
										<option value="Cinture">Cinture</option>
										<option value="Borsa">Borsa</option>
								</select></td>

								<td><label for="coloreAc">Colore</label></td>
								<td><select name="coloreAc" id="coloreAc">
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
							</tr>

							<tr>
								<td colspan="2"><input type="submit"
									class="buttonStandard box" value="Conferma" style="width: auto"></td>
							</tr>
						</table>
					</form>
				</fieldset>
			</div>

			<%
			if (accessori != null && accessori.size() > 0) {
				Iterator<?> it = accessori.iterator();
			%>
			<div class="col-sm">

				<fieldset>
					<legend>Foto</legend>
					<form id="formFile" name="formFile"
						action="<%=response.encodeURL("UploadFotoAccessoriControl")%> "
						enctype="multipart/form-data" method="post">
						<table>
							<tr>
								<td colspan="2"><input id="fileCop" class="file normal"
									type="file" name="talkPhoto" value="" maxlength="255"
									accept="image/*" style="width: auto"></td>
							</tr>
							<tr>
								<td><label for=codiceAc>ID:</label></td>
								<td><select name="codiceAc" id="codiceCop">
										<option selected value=""></option>
										<%
										while (it.hasNext()) {
											Accessori a = (Accessori) it.next();
											if (!a.isCopertina()) {
										%>

										<option value="<%=a.getId()%>"><%=a.getNome()%> -
											<%=a.getColore()%></option>

										<%
										}
										}
										}
										%>
								</select></td>
								<td><label for="copertinaAc">Foto</label></td>
								<td><select name="copertinaAc" id="copertinaAc">
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

	<br>
	<br>
	<br>
	<br>

	<div class="container rounded">
		<h1 class="text-center">Magazzino Accessori</h1>
		<table class="table rounded">
			<tr>
				<th scope="col"><a></a>
				<th scope="col"><a>Nome</a></th>
				<th scope="col"><a>Descrizione</a></th>
				<th scope="col"><a>Colore</a></th>
				<th scope="col"><a>Quantità</a></th>
				<th scope="col"><a>Prezzo</a></th>
				<th scope="col"><a>Modifica</a></th>
				<th scope="col"><a>Elimina</a></th>
				<th scope="col"><a>New</a></th>
				<th scope="col"><a>Foto 1</a></th>
				<th scope="col"><a>Foto 2</a></th>
				<th scope="col"><a>Foto 3</a></th>

			</tr>

			<%
			if (accessori != null && accessori.size() > 0) {
				Iterator<?> it = accessori.iterator();
				while (it.hasNext()) {
					Accessori a = (Accessori) it.next();
			%>

			<tr>
				<td><form id="<%="formModAc" + a.getId()%>"
						action="<%=response.encodeURL("ModificaAccessoriControl")%>">
						<input type="hidden" name="id" value="<%=a.getId()%>">
					</form></td>

				<td><a><%=a.getNome()%></a></td>
				<td><a><%=a.getDescrizione()%></a></td>
				<td><a><%=a.getColore()%></a></td>
				<td><a><%=a.getQuantita()%></a><input
					form="<%="formModAc" + a.getId()%>" type="text" name="quantitaAc"
					maxlength="3" style="width: 70px;" value=""></input></td>

				<td><a><%=a.getPrezzo()%></a><input
					form="<%="formModAc" + a.getId()%>" type="text" name="prezzoAc"
					maxlength="3" style="width: 70px;" value=""></input></td>

				<td><input form="<%="formModAc" + a.getId()%>" type="submit"
					value="M"></td>
				<td><button onclick="cancellaAccessori(<%=a.getId()%>)">X</button></td>
				<td><button onclick="newAccessori(<%=a.getId()%>)"><%=a.isNuovo()%>



					</button></td>

				<td><img id="copertina" class="rounded "
					style="height: 110px; width: 100px"
					src="../LoadFotoAccessoriControl?copertinaAc=1&codiceAc=<%=a.getId()%>"
					onerror="this.src='../images/NoCop.jpg'"></td>
				<td><img id="copertina" class="rounded "
					style="height: 110px; width: 100px"
					src="../LoadFotoAccessoriControl?copertinaAc=2&codiceAc=<%=a.getId()%>"
					onerror="this.src='../images/NoCop.jpg'"></td>
				<td><img id="copertina" class="rounded "
					style="height: 110px; width: 100px"
					src="../LoadFotoAccessoriControl?copertinaAc=3&codiceAc=<%=a.getId()%>"
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