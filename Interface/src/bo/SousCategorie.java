package bo;

public class SousCategorie {
	private int idSousCategorie;
	private String nom;
	private boolean interdit;
	private Categorie categorie;
	
	public SousCategorie(){
		super();
	}
	
	public SousCategorie(int idSousCategorie, String nom, boolean interdit,
			Categorie categorie) {
		super();
		this.idSousCategorie = idSousCategorie;
		this.nom = nom;
		this.interdit = interdit;
		this.categorie = categorie;
	}

	public int getIdSousCategorie() {
		return idSousCategorie;
	}

	public void setIdSousCategorie(int idSousCategorie) {
		this.idSousCategorie = idSousCategorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isInterdit() {
		return interdit;
	}

	public void setInterdit(boolean interdit) {
		this.interdit = interdit;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "SousCategorie [idSousCategorie=" + idSousCategorie + ", nom="
				+ nom + ", interdit=" + interdit + ", categorie=" + categorie
				+ "]";
	}
	
	
}
