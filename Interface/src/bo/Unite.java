package bo;

public class Unite {
	private int idUnite;
	private String abreviation;
	private String nom;
	
	public Unite() {
		super();
	}
	
	public Unite(int idUnite, String abreviation, String nom) {
		super();
		this.idUnite = idUnite;
		this.abreviation = abreviation;
		this.nom = nom;
	}

	public int getIdUnite() {
		return idUnite;
	}

	public void setIdUnite(int idUnite) {
		this.idUnite = idUnite;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Unite [idUnite=" + idUnite + ", abreviation=" + abreviation
				+ ", nom=" + nom + "]";
	}
	
}
