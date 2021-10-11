package telas.menus;

import app.App;
import classes.Programa;
import telas.Print;
import mensagens.Mensagens;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static mensagens.Mensagens.colorErrorMessage;

public class TelaExcluir extends Menu{

    private TelaExcluirPrograma telaExcluirPrograma = new TelaExcluirPrograma(this);
    private Menu menuAnterior;

    public TelaExcluir(Menu menuAnterior){
        super(
                Mensagens.Cabecalhos.EXCLUIR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.EXCLUIR_SERIE,
                        Mensagens.Opcoes.EXCLUIR_FILME,
                        Mensagens.Opcoes.VOLTAR
                )));

        this.menuAnterior = menuAnterior;
    }

    private boolean listaVazia(List<Programa> programas){
        if (programas == null || programas.size() == 0){
            System.out.println(colorErrorMessage("\n" + Mensagens.Avisos.LISTA_VAZIA));
            return true;
        }
        return false;
    }

    @Override
    public void run(Boolean exibirCabecalho ,Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);

        switch (super.opcaoSelecionada){

            // Excluir Série
            case 1:

                if (listaVazia(App.getBiblioteca().getProgramas(TipoPrograma.SERIE))){
                    this.run(true,true, true, true);
                }

                Print.printProgramas(App.getBiblioteca().getProgramas(TipoPrograma.SERIE), TipoPrograma.SERIE);
                telaExcluirPrograma.setCabecalho(Mensagens.Cabecalhos.EXCLUIR_SERIES);
                telaExcluirPrograma.excluirPrograma(App.getBiblioteca(), TipoPrograma.SERIE);
                this.run(true,true, true, true);
                break;

            // Excluir Filme
            case 2:
                if (listaVazia(App.getBiblioteca().getProgramas(TipoPrograma.FILME))){
                    this.run(true,true, true, true);
                }

                Print.printProgramas(App.getBiblioteca().getProgramas(TipoPrograma.FILME), TipoPrograma.FILME);
                telaExcluirPrograma.setCabecalho(Mensagens.Cabecalhos.EXCLUIR_FILMES);
                telaExcluirPrograma.excluirPrograma(App.getBiblioteca(), TipoPrograma.FILME);
                this.run(true,true, true, true);
                break;

            // Voltar
            case 3:
                this.menuAnterior.run(true, true, true, true);
                break;
        }
    }
}
