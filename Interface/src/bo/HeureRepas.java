package bo;

public class HeureRepas {
	private int idRepas;
	private String nom;
	
	public HeureRepas(){
		super();
	}
	
	public HeureRepas(int idRepas, String nom) {
		super();
		this.idRepas = idRepas;
		this.nom = nom;
	}

	public int getIdRepas() {
		return idRepas;
	}

	public void setIdRepas(int idRepas) {
		this.idRepas = idRepas;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "HeureRepas [idRepas=" + idRepas + ", nom=" + nom + "]";
	}
	
	
	
}
