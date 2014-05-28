package bo;

public class RecetteAliment {
	private Aliment aliment;
	private Recette recette;
	private int quantite;
	private int priorite;
	private String nomComplet;
	
	public RecetteAliment(){
		super();
	}
	
	public RecetteAliment(Aliment aliment, Recette recette, int quantite,
			int priorite, String nomComplet) {
		super();
		this.aliment = aliment;
		this.recette = recette;
		this.quantite = quantite;
		this.priorite = priorite;
		this.nomComplet = nomComplet;
	}

	public Aliment getAliment() {
		return aliment;
	}

	public void setAliment(Aliment aliment) {
		this.aliment = aliment;
	}

	public Recette getRecette() {
		return recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	@Override
	public String toString() {
		return "RecetteAliment [aliment=" + aliment + ", recette=" + recette
				+ ", quantite=" + quantite + ", priorite=" + priorite
				+ ", nomComplet=" + nomComplet + "]";
	}
	
	
	
	
}
