package bo;

public class RecetteAliment {
	private int idAliment;
	private int idRecette;
	private int quantite;
	private int priorite;
	private String nomComplet;
	
	public RecetteAliment(){
		super();
	}
	
	public RecetteAliment(int idAliment, int idRecette, int quantite,
			int priorite, String nomComplet) {
		super();
		this.idAliment = idAliment;
		this.idRecette = idRecette;
		this.quantite = quantite;
		this.priorite = priorite;
		this.nomComplet = nomComplet;
	}

	public int getIdAliment() {
		return idAliment;
	}

	public void setIdAliment(int idAliment) {
		this.idAliment = idAliment;
	}

	public int getIdRecette() {
		return idRecette;
	}

	public void setIdRecette(int idRecette) {
		this.idRecette = idRecette;
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
		return "RecetteAliment [idAliment=" + idAliment + ", idRecette=" + idRecette
				+ ", quantite=" + quantite + ", priorite=" + priorite
				+ ", nomComplet=" + nomComplet + "]";
	}
	
	
	
	
}
