package telas.menus;

import app.App;
import classes.Biblioteca;
import classes.Programa;
import classes.exceptions.InputException;
import mensagens.Mensagens;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.Arrays;

import static mensagens.Mensagens.colorGoodMessage;

public class TelaExcluirPrograma extends Menu{

    private Menu menuAnterior;
    private Programa programa;
    private String nome;

    public TelaExcluirPrograma(Menu menuAnterior){
        super(
                Mensagens.Cabecalhos.ADICIONAR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.SALVAR,
                        Mensagens.Opcoes.VOLTAR
                )));

        this.menuAnterior = menuAnterior;
    }

    public void excluirPrograma(Biblioteca biblioteca, TipoPrograma tipoPrograma){
        super.run(true, false, false, false);
        this.nome = super.nomeCadastradoInput(App.getBiblioteca(), "Nome: ", tipoPrograma);
        this.programa = biblioteca.getPrograma(this.nome, tipoPrograma);
        System.out.println(this.programa.toString());
        this.run(true, true, true, true);
    }

    @Override
    public void run(Boolean exibirCabecalho, Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);

        switch (super.opcaoSelecionada){

            // Salvar
            case 1:

                try{
                    App.getBiblioteca().excuirPrograma(this.programa);
                    System.out.println(colorGoodMessage("\n" + Mensagens.Avisos.EXCLUIDO_SUCESSO));
                }
                catch (InputException.BibliotecaException e){
                    System.out.println(e.getMessage());
                    System.out.println(Mensagens.Avisos.EXCLUIR_FAIL);
                }
                this.menuAnterior.run(true, true, true, true);
                break;

            // Voltar
            case 2:
                this.menuAnterior.run(true, true, true, true);
                break;
        }
    }
}