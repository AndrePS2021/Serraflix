package telas.telas;

import app.App;
import classes.Biblioteca;
import classes.Filme;
import classes.Programa;
import classes.Serie;
import classes.exceptions.ClassificacaoForaDoRangeException;
import classes.exceptions.InputException;
import telas.Print;
import mensagens.Mensagens;
import uteis.Categoria;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.Arrays;

import static mensagens.Mensagens.colorGoodMessage;
import static mensagens.Mensagens.colorQueryMessage;

public class TelaEditarPrograma extends Tela {

    private TipoPrograma tipoPrograma;
    private String nome;
    private String novoNome;
    private Integer pontuacao;
    private Integer novaPontuacao;
    private Categoria categoria;
    private Categoria novaCategoria;
    private ArrayList<Integer> epTemporadas = new ArrayList<Integer>();
    private ArrayList<Integer> novosEpTemporadas = new ArrayList<Integer>();
    private Integer duracao;
    private Integer novadDuracao;

    public TelaEditarPrograma(Tela telaAnterior){
        super(
                Mensagens.Cabecalhos.EDITAR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.EDITAR_NOME,
                        Mensagens.Opcoes.EDITAR_PONTUACAO,
                        Mensagens.Opcoes.EDITAR_CATEGORIA,
                        Mensagens.Opcoes.EDITAR_TEMPORADAS,
                        Mensagens.Opcoes.EDITAR_DURACAO
                )));

        this.telaAnterior = telaAnterior;
    }

    private void editarPrograma(Biblioteca biblioteca, TipoPrograma tipoPrograma){
        Print.printProgramas(biblioteca.getProgramas(this.tipoPrograma), this.tipoPrograma);
        System.out.println(colorQueryMessage("\n"+Mensagens.Instrucoes.INFORME_NOME));
        this.nome = super.nomeCadastradoInput(App.getBiblioteca(), "Nome: ", tipoPrograma);
        System.out.println("\n" + App.getBiblioteca().getPrograma(this.nome, tipoPrograma).toString());
    }

    public void editarFilme(Biblioteca biblioteca){
        this.setOpcoes(new ArrayList<String>(Arrays.asList(
                Mensagens.Opcoes.EDITAR_NOME,
                Mensagens.Opcoes.EDITAR_PONTUACAO,
                Mensagens.Opcoes.EDITAR_CATEGORIA,
                Mensagens.Opcoes.EDITAR_DURACAO,
                Mensagens.Opcoes.VOLTAR,
                Mensagens.Opcoes.INICIAL
        )));
        this.tipoPrograma = TipoPrograma.FILME;
        this.editarPrograma(biblioteca, TipoPrograma.FILME);
        this.run(true, true, true, true);
    }

    public void editarSerie(Biblioteca biblioteca){
        this.setOpcoes(new ArrayList<String>(Arrays.asList(
                Mensagens.Opcoes.EDITAR_NOME,
                Mensagens.Opcoes.EDITAR_PONTUACAO,
                Mensagens.Opcoes.EDITAR_CATEGORIA,
                Mensagens.Opcoes.EDITAR_TEMPORADAS,
                Mensagens.Opcoes.VOLTAR,
                Mensagens.Opcoes.INICIAL
        )));
        this.tipoPrograma = TipoPrograma.SERIE;
        this.editarPrograma(biblioteca, TipoPrograma.SERIE);
        this.run(true, true, true, true);
    }

    private Categoria escolherCategoria(){
        System.out.println("\n" + Categoria.getCategorias());
        Integer categoria = super.lerOpcao("Categoria: ", Categoria.values().length);

        return Categoria.values()[categoria-1];
    }

    private void adicionarTemporada(){
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
                biblioteca.editarPrograma(serie);
                break;

            case FILME:
                Filme filme = new Filme(this.nome, this.pontuacao, this.categoria, this.duracao);
                System.out.println("\n" + filme.toString());
                biblioteca.editarPrograma(filme);
                break;
        }
    }

    public void editarNome(){
        System.out.println(colorQueryMessage("\n" + Mensagens.Instrucoes.NOVO_NOME));
        this.novoNome = super.lerStringInput(App.getBiblioteca(), "Nome: ", tipoPrograma);
        salvarNome(App.getBiblioteca());
    }

    private void salvarNome(Biblioteca biblioteca){
        Programa programa = biblioteca.getPrograma(this.nome, tipoPrograma);
        programa.setNome(this.novoNome);
        this.nome = this.novoNome;
        System.out.println("\n" + programa.toString());
        System.out.println(colorGoodMessage(Mensagens.Avisos.NOME_SALVO));
    }

    public void editarPontuacao(){
        System.out.println(colorQueryMessage("\n" + Mensagens.Instrucoes.NOVA_PONTUACAO));
        this.novaPontuacao = super.lerIntegerInput(App.getBiblioteca(), "Pontuação: ", tipoPrograma);
        salvarPontuacao(App.getBiblioteca());
    }

    private void salvarPontuacao(Biblioteca biblioteca){
        Programa programa = biblioteca.getPrograma(this.nome, tipoPrograma);
        programa.setPontuacao(this.novaPontuacao);
        System.out.println("\n" + programa.toString());
        System.out.println(colorGoodMessage(Mensagens.Avisos.PONTUACAO_SALVA));
    }

    public void editarCategoria(){
        System.out.println(colorQueryMessage("\n" + Mensagens.Instrucoes.NOVA_CATEGORIA));
        this.novaCategoria = escolherCategoria();
        salvarCategoria(App.getBiblioteca());
    }

    private void salvarCategoria(Biblioteca biblioteca){
        Programa programa = biblioteca.getPrograma(this.nome, tipoPrograma);
        programa.setCategoria(this.novaCategoria);
        System.out.println("\n" + programa.toString());
        System.out.println(colorGoodMessage(Mensagens.Avisos.CATEGORIA_SALVA));
    }

    public void editarDuracao(){
        System.out.println(colorQueryMessage("\n" + Mensagens.Instrucoes.NOVA_DURACAO));
        this.novadDuracao = super.lerOpcao("Duração: ", 999999999);
        salvarDuracao(App.getBiblioteca());
    }

    private void salvarDuracao(Biblioteca biblioteca){
        Filme filme = (Filme) biblioteca.getPrograma(this.nome, tipoPrograma);
        filme.setDuracao(this.novadDuracao);
        System.out.println("\n" + filme.toString());
        System.out.println(colorGoodMessage(Mensagens.Avisos.DURACAO_SALVA));
    }

    public void editarTemporadas(){
        System.out.println(colorQueryMessage("\n" + Mensagens.Instrucoes.NOVA_TEMPORADA));
        adicionarTemporada();
        salvarTemporadas(App.getBiblioteca());
    }

    private void salvarTemporadas(Biblioteca biblioteca){
        Serie serie = (Serie) biblioteca.getPrograma(this.nome, tipoPrograma);
        serie.limparTemporadas();
        serie.adicionarTemporadas(this.epTemporadas);
        System.out.println("\n" + serie.toString());
        System.out.println(colorGoodMessage(Mensagens.Avisos.TEMPORADAS_SALVA));
    }


    @Override
    public void run(Boolean exibirCabecalho, Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);

        switch (this.menus.get(this.opcaoSelecionada-1)){

            // Editar Nome
            case Mensagens.Opcoes.EDITAR_NOME:
                editarNome();
                this.run(true, true, true, true);
                break;

            // Editar Pontuação
            case Mensagens.Opcoes.EDITAR_PONTUACAO:
                editarPontuacao();
                this.run(true, true, true, true);
                break;

            // Editar Categoria
            case Mensagens.Opcoes.EDITAR_CATEGORIA:
                editarCategoria();
                this.run(true, true, true, true);
                break;

            // Editar Duração
            case Mensagens.Opcoes.EDITAR_DURACAO:
                editarDuracao();
                this.run(true, true, true, true);
                break;

            // Editar Temporada
            case Mensagens.Opcoes.EDITAR_TEMPORADAS:
                editarTemporadas();
                this.run(true, true, true, true);
                break;
        }
    }
}
