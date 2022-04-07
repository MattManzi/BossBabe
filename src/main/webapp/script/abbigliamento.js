function cancellaAbbigliamento(id) {
	var scelta = confirm("Sei sicuro?");
	if (scelta === true) {
		location.href = "EliminaAbbigliamentoControl?id=" + id;
	}
}



function newAbbigliamento(id) {
	var scelta = confirm("Sei sicuro di voler aggiungere queste scarpe \nalla collezione 'Nuovi Arrivi' ?");
	if (scelta === true) {
		location.href = "NewAbbigliamentoControl?id=" + id;
	}
}

function visualizzaDettagliAbbigliamento(id) {
		location.href = "VisualizzaDettagliAbbigliamentoControl?id="+id;
}

function visualizza(id) {
	if (document.getElementById) {
		if (document.getElementById(id).style.display == 'none') {
			document.getElementById(id).style.display = 'block';
		} else {
			document.getElementById(id).style.display = 'none';
		}
	}
}