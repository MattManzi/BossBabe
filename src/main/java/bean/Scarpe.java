package bean;

public class Scarpe {
	
	private int id;
	private String nome;
	private String descrizione;
	private String colore;
	private String taglia;
	private double prezzo;
	private boolean copertina;
	private boolean copertina2;
	private boolean copertina3;
	private boolean nuovo;

	public Scarpe() {}
	
	public Scarpe(String nome) {
		this.nome=nome;
	}
	
	public Scarpe(String nome, String descrizone,String colore,String taglia, double prezzo) {
		this.nome=nome;
		this.descrizione=descrizone;
		this.colore=colore;
		this.taglia=taglia;
		this.prezzo=prezzo;
	}
	
	public Scarpe(String nome, String descrizone,String colore) {
		this.nome=nome;
		this.descrizione=descrizone;
		this.colore=colore;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getTaglia() {
		return taglia;
	}

	public void setTaglia(String taglia) {
		this.taglia = taglia;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public boolean isCopertina() {
		return copertina;
	}

	public void setCopertina(boolean copertina) {
		this.copertina = copertina;
	}

	public boolean isCopertina2() {
		return copertina2;
	}

	public void setCopertina2(boolean copertina2) {
		this.copertina2 = copertina2;
	}

	public boolean isCopertina3() {
		return copertina3;
	}

	public void setCopertina3(boolean copertina3) {
		this.copertina3 = copertina3;
	}

	public Boolean isNuovo() {
		return nuovo;
	}

	public void setNuovo(Boolean nuovo) {
		this.nuovo = nuovo;
	}
}
