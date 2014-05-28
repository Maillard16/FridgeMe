package bo;

/**
 * @author m-saw
 *
 */

public class Aliment {
	private int idAliment;
	private String nom;
	private int quantite;
	private int idSousCat;
	private int idUnite;
	
	
	
	public Aliment() {
		super();
	}

	public Aliment(int idAliment, String nom, int quantite,
			int idSousCat, int idUnite) {
		super();
		this.idAliment = idAliment;
		this.nom = nom;
		this.quantite = quantite;
		this.idSousCat = idSousCat;
		this.idUnite = idUnite;
	}

	public int getIdAliment() {
		return idAliment;
	}

	public void setIdAliment(int idAliment) {
		this.idAliment = idAliment;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	
	public int getIdSousCat() {
		return idSousCat;
	}

	public void setIdSousCat(int idSousCat) {
		this.idSousCat = idSousCat;
	}

	public int getIdUnite() {
		return idUnite;
	}

	public void setIdUnite(int idUnite) {
		this.idUnite = idUnite;
	}

	@Override
	public String toString() {
		return "Aliment [idAliment=" + idAliment + ", nom=" + nom
				+ ", quantite=" + quantite + ", idSousCat=" + idSousCat
				+ ", idUnite=" + idUnite + "]";
	}

	
	
	
}
