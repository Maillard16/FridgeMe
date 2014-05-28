package bo;

public class Repas {
	private int idRepas;
	private int jour;
	private int nombrePersonne;
	private Recette recette;
	private HeureRepas heureRepas;
	
	public Repas(){
		super();
	}
	
	public Repas(int idRepas, int jour, int nombrePersonne, Recette recette,
			HeureRepas heureRepas) {
		super();
		this.idRepas = idRepas;
		this.jour = jour;
		this.nombrePersonne = nombrePersonne;
		this.recette = recette;
		this.heureRepas = heureRepas;
	}

	public int getIdRepas() {
		return idRepas;
	}

	public void setIdRepas(int idRepas) {
		this.idRepas = idRepas;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getNombrePersonne() {
		return nombrePersonne;
	}

	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public HeureRepas getHeureRepas() {
		return heureRepas;
	}

	public void setHeureRepas(HeureRepas heureRepas) {
		this.heureRepas = heureRepas;
	}

	@Override
	public String toString() {
		return "Repas [idRepas=" + idRepas + ", jour=" + jour
				+ ", nombrePersonne=" + nombrePersonne + ", recette=" + recette
				+ ", heureRepas=" + heureRepas + "]";
	}
	
	
	
}
