function cancellaScarpe(id) {
	var scelta = confirm("Sei sicuro?");
	if (scelta === true) {
		location.href = "EliminaScarpaControl?id=" + id;
	}
}


function visualizzaDettagliScarpa(id) {
		location.href = "VisualizzaDettagliScarpaControl?id="+id;
}



function NewScarpe(id) {
	var scelta = confirm("Sei sicuro di voler aggiungere queste scarpe \nalla collezione 'Nuovi Arrivi' ?");
	if (scelta === true) {
		location.href = "NewScarpeControl?id=" + id;
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



