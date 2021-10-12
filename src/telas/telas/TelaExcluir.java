package telas.telas;

import app.App;
import classes.Programa;
import telas.Print;
import mensagens.Mensagens;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static mensagens.Mensagens.colorErrorMessage;

public class TelaExcluir extends Tela {

    private TelaExcluirPrograma telaExcluirPrograma = new TelaExcluirPrograma(this);

    public TelaExcluir(Tela telaAnterior){
        super(
                Mensagens.Cabecalhos.EXCLUIR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.EXCLUIR_SERIE,
                        Mensagens.Opcoes.EXCLUIR_FILME
                )));

        this.telaAnterior = telaAnterior;
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

        switch (this.menus.get(this.opcaoSelecionada-1)){

            // Excluir Série
            case Mensagens.Opcoes.EXCLUIR_SERIE:

                if (listaVazia(App.getBiblioteca().getProgramas(TipoPrograma.SERIE))){
                    this.run(true,true, true, true);
                }

                Print.printProgramas(App.getBiblioteca().getProgramas(TipoPrograma.SERIE), TipoPrograma.SERIE);
                telaExcluirPrograma.setCabecalho(Mensagens.Cabecalhos.EXCLUIR_SERIES);
                telaExcluirPrograma.excluirPrograma(App.getBiblioteca(), TipoPrograma.SERIE);
                this.run(true,true, true, true);
                break;

            // Excluir Filme
            case Mensagens.Opcoes.EXCLUIR_FILME:
                if (listaVazia(App.getBiblioteca().getProgramas(TipoPrograma.FILME))){
                    this.run(true,true, true, true);
                }

                Print.printProgramas(App.getBiblioteca().getProgramas(TipoPrograma.FILME), TipoPrograma.FILME);
                telaExcluirPrograma.setCabecalho(Mensagens.Cabecalhos.EXCLUIR_FILMES);
                telaExcluirPrograma.excluirPrograma(App.getBiblioteca(), TipoPrograma.FILME);
                this.run(true,true, true, true);
                break;
        }
    }
}
