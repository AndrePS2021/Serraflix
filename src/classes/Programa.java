package classes;

import classes.exceptions.ClassificacaoForaDoRangeException;
import interfaces.Classificar;
import uteis.Categoria;
import uteis.TipoPrograma;

import static mensagens.Mensagens.colorGoodMessage;
import static mensagens.Mensagens.colorQueryMessage;

public abstract class Programa implements Classificar {

	protected String nome;
	protected Integer pontuacao;
	protected Categoria categoria;
	protected TipoPrograma tipoPrograma;

	public Programa( String nome, Categoria categoria, Integer pontuacao, TipoPrograma tipoPrograma) throws ClassificacaoForaDoRangeException {
		this.tipoPrograma = tipoPrograma;
		this.nome = nome;
		this.classificar(pontuacao);
		this.categoria = categoria;
	}

	public Integer getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public TipoPrograma getTipoPrograma() {
		return tipoPrograma;
	}

	@Override
	public void classificar(Integer classificacao) throws ClassificacaoForaDoRangeException {
		ClassificacaoForaDoRangeException.validarClassificacao(classificacao, this.tipoPrograma);
		this.pontuacao = classificacao;
	}

	@Override
	public String toString() {

		return
				colorQueryMessage("Nome: " + this.nome) +
				"\nPontuação: " + this.pontuacao +
				"\nCategoria: " + this.categoria.toString();
	}
}