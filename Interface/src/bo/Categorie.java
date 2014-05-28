package bo;

public class Categorie {
	private int idCategorie;
	private String nom;
	
	public Categorie(){
		super();
	}
	
	public Categorie(int idCategorie, String nom) {
		super();
		this.idCategorie = idCategorie;
		this.nom = nom;
	}
	
	public int getIdCategorie() {
		return idCategorie;
	}
	
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nom=" + nom + "]";
	}	
	
}
