package jana60;

public class Oratore {

	private String nome;
	private String cognome;
	private String titoloOr;

	public Oratore(String nome, String cognome, String titoloOr) {
		this.nome = nome;
		this.cognome = cognome;
		this.titoloOr = titoloOr;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getTitoloOr() {
		return titoloOr;
	}

	public String toString() {
		return nome + " " + cognome + " " + titoloOr;
	}
}
