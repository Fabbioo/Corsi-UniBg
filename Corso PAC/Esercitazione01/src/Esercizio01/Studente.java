package Esercizio01;

public class Studente implements Comparable {

	private String nome;
	private String cognome;
	private String dataNascita; // Da assumere nel formato AAAAMMGG.
	private String universita; // Da assumere nel formato "Uni__".
	private int matricola;

	public Studente(String nome, String cognome, String dataNascita, String universita, int matricola) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.universita = universita;
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getUniversita() {
		return universita;
	}

	public void setUniversita(String universita) {
		this.universita = universita;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	// Override metodo equals.
	public boolean equals(Object obj) {

		// Se obj è una istanza di un'altra classe ritorno false.
		if (!(obj instanceof Studente))
			return false;

		// Superato il primo if sono certo che obj sia una istanza della classe Studente.
		// Se l'oggetto obj viene paragonato con sè stesso ritorno true.
		if (this == obj)
			return true;

		// Superati i due if preliminari so che obj è una istanza della classe Studente e non sto
		// paragonando obj con sè stesso, perciò effettuo un cast da Object a Studente.
		Studente altro = (Studente) obj;

		return nome == altro.getNome() && 
			   cognome == altro.getCognome() && 
			   dataNascita == altro.getDataNascita() && 
			   universita == altro.getUniversita() && 
			   matricola == altro.getMatricola();
	}

	// Override metodo compareTo di Comparable.
	public int compareTo(Object another) throws ClassCastException {

		if (!(another instanceof Studente))
			throw new ClassCastException();

		Studente altro = (Studente) another;

		// Se l'università è la stessa, il confronto viene fatto con la matricola.
		if (universita.equals(altro.getUniversita())) {

			int temp = matricola - altro.getMatricola();

			if (temp == 0)
				return 0; // Sto confrontando due studenti con la stessa matricola.

			else if (temp < 0)
				return -1;

			else
				return 1;
			
		} else { // Se l'università è diversa, confronto i cognomi.
			
			if (cognome.compareTo(altro.getCognome()) < 0)
				return -1;
			
			else if (cognome.compareTo(altro.getCognome()) > 0)
				return 1;
		
			else { // Se l'università è diversa e i cognomi sono gli stessi, confronto le date di nascita.
				
				if (dataNascita.compareTo(altro.getDataNascita()) < 0)
					return 1;
				
				else
					return -1;
			}
		}
	}
}
