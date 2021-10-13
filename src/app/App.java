package app;
import java.util.*;

import classes.*;
import classes.exceptions.ClassificacaoForaDoRangeException;
import classes.exceptions.InputException;
import mensagens.Mensagens;
import telas.telas.TelaInicial;
import uteis.*;

import static mensagens.Mensagens.colorGoodMessage;

public class App {

    public final static Scanner input = new Scanner(System.in);
    private final static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        // Apenas para Biblioteca não começar vazia. Pode excluir se quiser!
        importarBibliotecaPadrao();

        TelaInicial telaInicial = new TelaInicial();
    	telaInicial.run(true, true, true, true);
    }

    public static Biblioteca getBiblioteca(){
        return App.biblioteca;
    }

    public static void sair(int status){
        System.out.println(colorGoodMessage(Mensagens.Saudacoes.TCHAU));
        input.close();
        System.exit(status);
    }

    public static void importarBibliotecaPadrao(){
        try{
            Serie serie1 = new Serie("The Office", 7, Categoria.COMEDIA);
            Serie serie2 = new Serie("Breaking Bad", 8, Categoria.FANTASIA);
            Serie serie3 = new Serie("American Horror Story", 6, Categoria.TERROR);

            serie1.adicionarTemporada(6);
            serie1.adicionarTemporada(22);
            serie1.adicionarTemporada(25);
            serie2.adicionarTemporada(7);
            serie2.adicionarTemporada(13);
            serie2.adicionarTemporada(13);
            serie3.adicionarTemporada(12);

            biblioteca.addPrograma(serie1);
            biblioteca.addPrograma(serie2);
            biblioteca.addPrograma(serie3);

            Filme filme1 = new Filme("Lord of The Rings", 5, Categoria.FANTASIA, 178);
            Filme filme2 = new Filme("Hangover", 3, Categoria.COMEDIA, 160);
            Filme filme3 = new Filme("The Shining", 4, Categoria.TERROR, 146);

            biblioteca.addPrograma(filme1);
            biblioteca.addPrograma(filme2);
            biblioteca.addPrograma(filme3);

        }catch (ClassificacaoForaDoRangeException | InputException.BibliotecaException e){
            System.out.println(e.getMessage());
        }
    }
}