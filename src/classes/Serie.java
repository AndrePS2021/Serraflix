package classes;

import classes.exceptions.ClassificacaoForaDoRangeException;
import mensagens.Mensagens;
import uteis.Categoria;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.List;

public class Serie extends Programa{

	private List<Temporada> temporadas;
	protected TipoPrograma tipoPrograma;

	public Serie(String nome, Integer pontuacao, Categoria categoria) throws ClassificacaoForaDoRangeException {
		super(nome, categoria, pontuacao, TipoPrograma.SERIE);
		this.temporadas = new ArrayList<Temporada>();
		this.tipoPrograma = TipoPrograma.FILME;
	}

	public Integer getQuantidadeTemporadas() {
		
		return	this.temporadas.size();
	}

	public void addTemporadas(Temporada temporada) {
		temporadas.add(temporada);
	}

	public void adicionarTemporada(int quantidadeEpisodios) {

		Integer numeroTemporada;
		if (this.temporadas.size() == 0) {
			numeroTemporada = 1;
		}
		else{
			numeroTemporada = this.temporadas.get(this.temporadas.size() - 1).getNumeroTemporada() + 1;
		}

		Temporada temporada = new Temporada(numeroTemporada, quantidadeEpisodios);
		this.temporadas.add(temporada);
	}

	public void adicionarTemporadas(ArrayList<Integer> qtdEpisodios){
		for (Integer qtd: qtdEpisodios) {
			adicionarTemporada(qtd);
		}
	}

	public String listarTemporadas(){
		String str = "";

		if (!this.temporadas.isEmpty()) {
			for (Temporada temporada : this.temporadas) {
				str += temporada.toString() + "\n" ;
			}
			str = str.substring(0, str.length() - 0);
		}
		else{
			str = Mensagens.Avisos.TEMPORADAS_INEXISTENTES;
		}
		return str;
	}

	public void limparTemporadas(){
		this.temporadas.clear();
	}

	public String toString() {
		
		return
				super.toString() + "\n" +
				listarTemporadas();
	}
}
