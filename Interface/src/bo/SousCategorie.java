package bo;

public class SousCategorie {
	private int idSousCategorie;
	private String nom;
	private boolean interdit;
	private int idCategorie;
	
	public SousCategorie(){
		super();
	}
	
	public SousCategorie(int idSousCategorie, String nom, boolean interdit,
			int idCategorie) {
		super();
		this.idSousCategorie = idSousCategorie;
		this.nom = nom;
		this.interdit = interdit;
		this.idCategorie = idCategorie;
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

	public boolean getInterdit() {
		return interdit;
	}

	public void setInterdit(boolean interdit) {
		this.interdit = interdit;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	@Override
	public String toString() {
		return "SousCategorie [idSousCategorie=" + idSousCategorie + ", nom="
				+ nom + ", interdit=" + interdit + ", idCategorie=" + idCategorie
				+ "]";
	}
	
	
}
