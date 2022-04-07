<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="bean.Abbigliamento, java.util.*"%>

<%
Collection<?> abbigliamento = (Collection<?>) request.getAttribute("abbigliamento");

if (abbigliamento == null) {
	System.out.println(abbigliamento);
	response.sendRedirect(response.encodeRedirectURL("./VisualizzaAbbigliamentoControl"));

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
<script type="text/javascript" src="../script/abbigliamento.js"></script>
<link rel="stylesheet" href="../css/Catalgo.css" type="text/css">

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

<title>Magazzino Abbigliamento</title>





</head>



<body>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
<br>
	<br>

	<div class="container">
		<h1 class="text-center">Gestionale Abbigliamento</h1>
		<div class="row">
			<div class="col-sm">
				<fieldset>
					<legend>Aggiunta Abbigliamento</legend>
					<form
						action="<%=response.encodeURL("AggiuntaAbbigliamentoControl")%>"
						method="post">
						<table>

							<tr>
								<td><label for="nomeA"></label>Nome</td>
								<td><input id="nomeA" type="text" name="nomeA"></td>
								<td><label for="descrizioneA">Descrizione</label></td>
								<td><input id="descrizioneA" type="text"
									name="descrizioneA"></td>
							</tr>
							<tr>
								<td><label for="tipoA">Tipo</label></td>
								<td><select name="tipoA" id="tipoA">
										<option selected value=""></option>
										<option value="Maglia">Maglia Camice e
											Top</option>
										<option value="Pantaloni">Pantaloni</option>
										<option value="Shorts">Shorts</option>
										<option value="Dress">Dress</option>
										<option value="Giacche">Giacche</option>
								</select></td>
								
								<td><label for="coloreA">Colore</label></td>
								<td><select name="coloreA" id="coloreA">
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
			if (abbigliamento != null && abbigliamento.size() > 0) {
				Iterator<?> it = abbigliamento.iterator();
			%>
			<div class="col-sm">
				<fieldset>
					<legend>Foto</legend>
					<form id="formFile" name="formFile"
						action="<%=response.encodeURL("UploadFotoAbbigliamentoControl")%> "
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
											Abbigliamento a = (Abbigliamento) it.next();
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

<br>
<br>

	<div class="container ">
	<h1 class="text-center">Magazzino Abbigliamento</h1>

		<table class="table ">

		<tr>
			<th scope="col"><a></a>
			<th scope="col"><a>Nome</a></th>
			<th scope="col"><a>Descrizione</a></th>
			<th scope="col"><a>Colore</a></th>
			<th scope="col"><a>Taglia S</a></th>
			<th scope="col"><a>Taglia M</a></th>
			<th scope="col"><a>Taglia L</a></th>
			<th scope="col"><a>Taglia XL</a></th>
			<th scope="col"><a>Taglia TU</a></th>
			<th scope="col"><a>Prezzo</a></th>
			<th scope="col"><a>Modifica</a></th>
			<th scope="col"><a>Elimina</a></th>
			<th scope="col"><a>New</a></th>
			<th scope="col"><a>Foto 1</a></th>
			<th scope="col"><a>Foto 2</a></th>
			<th scope="col"><a>Foto 3</a></th>

		</tr>

		<%
		if (abbigliamento != null && abbigliamento.size() > 0) {
			Iterator<?> it = abbigliamento.iterator();
			while (it.hasNext()) {
				Abbigliamento a = (Abbigliamento) it.next();
		%>

		<tr>
			<td><form id="<%="formModA" + a.getId()%>"
					action="<%=response.encodeURL("ModificaAbbigliamentoControl")%>">
					<input type="hidden" name="id" value="<%=a.getId()%>">
				</form></td>

			<td><a><%=a.getNome()%></a></td>
			<td><a><%=a.getDescrizione()%></a></td>
			<td><a><%=a.getColore()%></a></td>
			<%
			String[] splitted = a.getTaglia().split("-");
			for (int i = 0; i < splitted.length; i++) {
			%>

			<td><%=splitted[i]%><input form="<%="formModA" + a.getId()%>" maxlength="3" style="width: 40px;" value="<%=splitted[i]%>"
				type="text" name="<%="Taglia" + i%>" value="<%=splitted[i]%>"></input></td>
			<%
			}
			%>
			<td><a><%=a.getPrezzo()%></a><input
				form="<%="formModA" + a.getId()%>" type="text" name="prezzoA" maxlength="3" style="width: 40px;" value=""
				value=""></input></td>
			<td><input form="<%="formModA" + a.getId()%>" type="submit" maxlength="3" style="width: 40px;"
				value="M"></td>
	
			<td><button onclick="cancellaAbbigliamento(<%=a.getId()%>)">X</button></td>
			<td><button onclick="newAbbigliamento(<%=a.getId()%>)"><%=a.isNuovo()%></button></td>

			<td><img id="copertina" class="rounded "
				style="height: 110px; width: 100px"
				src="../LoadFotoAbbigliamentoControl?copertinaA=1&codiceA=<%=a.getId()%>"
				onerror="this.src='../images/NoCop.jpg'"></td>
			<td><img id="copertina" class="rounded "
				style="height: 110px; width: 100px"
				src="../LoadFotoAbbigliamentoControl?copertinaA=2&codiceA=<%=a.getId()%>"
				onerror="this.src='../images/NoCop.jpg'"></td>
			<td><img id="copertina" class="rounded "
				style="height: 110px; width: 100px"
				src="../LoadFotoAbbigliamentoControl?copertinaA=3&codiceA=<%=a.getId()%>"
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