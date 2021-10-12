package telas.telas;

import app.App;
import classes.Biblioteca;
import classes.Filme;
import classes.Serie;
import classes.exceptions.ClassificacaoForaDoRangeException;
import classes.exceptions.InputException;
import mensagens.Mensagens;
import uteis.Categoria;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.Arrays;

import static mensagens.Mensagens.colorGoodMessage;
import static mensagens.Mensagens.colorQueryMessage;

public class TelaAdicionarPrograma extends Tela {

    private TipoPrograma tipoPrograma;
    private String nome;
    private Integer pontuacao;
    private Categoria categoria;
    private ArrayList<Integer> epTemporadas = new ArrayList<Integer>();
    private Integer duracao;

    public TelaAdicionarPrograma(Tela telaAnterior){
        super(
                Mensagens.Cabecalhos.ADICIONAR_PROGRAMAS,
                "\n" + Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.SALVAR
                )));

        this.telaAnterior = telaAnterior;
    }

    public void adicionarPrograma(TipoPrograma tipoPrograma){
        super.run(true, false, false, false);
        this.nome = super.lerStringInput(App.getBiblioteca(), "Nome: ", tipoPrograma);
        this.pontuacao = super.lerIntegerInput(App.getBiblioteca(), "Pontuação: ", tipoPrograma);
        this.categoria = escolherCategoria();
    }

    public void adicionarFilme(Biblioteca biblioteca){
        this.tipoPrograma = TipoPrograma.FILME;
        this.adicionarPrograma(TipoPrograma.FILME);
        this.duracao = super.lerOpcao("Duração: ", 999999999);
        this.run(false, true, true, true);
    }

    public void adicionarSerie(Biblioteca biblioteca){
        this.tipoPrograma = TipoPrograma.SERIE;
        this.adicionarPrograma(TipoPrograma.SERIE);
        this.adicionarTemporada();
        this.run(false, true, true, true);
    }

    private Categoria escolherCategoria(){
        System.out.println("\n" + Categoria.getCategorias());
        Integer categoria = super.lerOpcao("Categoria: ", Categoria.values().length);

        return Categoria.values()[categoria-1];
    }

    public void adicionarTemporada(){
        int count = 1;
        while (true){
            System.out.println(colorQueryMessage("\n" + Mensagens.Opcoes.ADICIONAR_TEMPORADA + " " + count++ + "?"));
            System.out.println(Mensagens.Opcoes.ESCOLHER_OPCOES);
            System.out.println("1 - " + Mensagens.Opcoes.SIM);
            System.out.println("2 - " + Mensagens.Opcoes.NAO);

            if (super.lerOpcao("> ", 2) == 1) {
                this.epTemporadas.add(super.lerOpcao("\n" + Mensagens.Opcoes.QTD_EPISODIOS, 999999999));
            }
            else{
                break;
            }
        }
    }

    private void salvarDados(Biblioteca biblioteca) throws InputException.BibliotecaException, ClassificacaoForaDoRangeException {
        switch (this.tipoPrograma){
            case SERIE:
                Serie serie = new Serie(this.nome, this.pontuacao, this.categoria);
                serie.adicionarTemporadas(this.epTemporadas);
                System.out.println("\n" + serie.toString());
                biblioteca.addPrograma(serie);
                break;

            case FILME:
                Filme filme = new Filme(this.nome, this.pontuacao, this.categoria, this.duracao);
                System.out.println("\n" + filme.toString());
                biblioteca.addPrograma(filme);
                break;
        }
    }

    @Override
    public void run(Boolean exibirCabecalho, Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);

        switch (this.menus.get(this.opcaoSelecionada-1)){

            // Salvar
            case Mensagens.Opcoes.SALVAR:

                try{
                    salvarDados(App.getBiblioteca());
                    System.out.println(colorGoodMessage(Mensagens.Avisos.SALVO_SUCESSO));
                }
                catch (InputException.BibliotecaException | ClassificacaoForaDoRangeException e){
                    System.out.println(Mensagens.Avisos.SALVO_FAIL);
                    System.out.println(e.getMessage());
                }
                this.telaAnterior.run(true, true, true, true);
                break;
        }
    }
}
