function cancellaAccessori(id) {
	var scelta = confirm("Sei sicuro?");
	if (scelta === true) {
		location.href = "EliminaAccessoriControl?id=" + id;
	}
}

function visualizzaDettagliAccessoriControl(id) {
		location.href = "VisualizzaDettagliAccessoriControl?id="+id;
}


function newAccessori(id) {
	var scelta = confirm("Sei sicuro di voler aggiungere queste scarpe \nalla collezione 'Nuovi Arrivi' ?");
	if (scelta === true) {
		location.href = "NewAccessoriControl?id=" + id;
	}
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