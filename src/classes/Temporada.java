package classes;

public class Temporada {

	private Integer quantidadeEpisodios;
	private Integer numeroTemporada;
	
	public Temporada(Integer numeroTemporada, Integer quantidadeEpisodios) {
		this.setQuantidadeEpisodios(quantidadeEpisodios);
		this.setNumeroTemporada(numeroTemporada);
	}
	
	public Integer getQuantidadeEpisodios() {
		
		return quantidadeEpisodios;
	}
	public void setQuantidadeEpisodios(Integer quantidadeEpisodios) {
		
		this.quantidadeEpisodios = quantidadeEpisodios;
	}
	
	public Integer getNumeroTemporada() {
		
		return numeroTemporada;
	}
	
	public void setNumeroTemporada(Integer numeroTemporada) {

		this.numeroTemporada = numeroTemporada;
	}

	@Override
	public String toString() {
		return
				String.format("Temporada: %d | Episódios: %d", this.getNumeroTemporada(), this.getQuantidadeEpisodios());
	}
}
