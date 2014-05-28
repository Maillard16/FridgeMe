package bo;

/**
 * @author m-saw
 *
 */

public class Aliment {
	private int idAliment;
	private String nom;
	private int quantite;
	private SousCategorie sousCat;
	private Unite unite;
	
	
	
	public Aliment() {
		super();
	}

	public Aliment(int idAliment, String nom, int quantite,
			SousCategorie sousCat, Unite unite) {
		super();
		this.idAliment = idAliment;
		this.nom = nom;
		this.quantite = quantite;
		this.sousCat = sousCat;
		this.unite = unite;
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

	public SousCategorie getSousCat() {
		return sousCat;
	}

	public void setSousCat(SousCategorie sousCat) {
		this.sousCat = sousCat;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	@Override
	public String toString() {
		return "Aliment [idAliment=" + idAliment + ", nom=" + nom
				+ ", quantite=" + quantite + ", sousCat=" + sousCat
				+ ", unite=" + unite + "]";
	}
	
	
	
	
}
