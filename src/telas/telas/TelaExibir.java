package telas.telas;

import mensagens.Mensagens;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.Arrays;

public class TelaExibir extends Tela {

    private TelaExibirCategoria telaExibirCategoria = new TelaExibirCategoria(this);

    public TelaExibir(Tela telaAnterior){
        super(
                Mensagens.Cabecalhos.EXIBIR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.EXIBIR_SERIE,
                        Mensagens.Opcoes.EXIBIR_FILME
                )));

        this.telaAnterior = telaAnterior;
    }

    @Override
    public void run(Boolean exibirCabecalho ,Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);

        switch (this.menus.get(this.opcaoSelecionada-1)){

            // Exibir Série
            case Mensagens.Opcoes.EXIBIR_SERIE:
                telaExibirCategoria.setCabecalho(Mensagens.Cabecalhos.EXIBIR_SERIES);
                telaExibirCategoria.run(true, true, true, TipoPrograma.SERIE);
                break;

            // Exibir Filmes
            case Mensagens.Opcoes.EXIBIR_FILME:
                telaExibirCategoria.setCabecalho(Mensagens.Cabecalhos.EXIBIR_FILMES);
                telaExibirCategoria.run(true, true, true, TipoPrograma.FILME);
                break;
        }
    }
}
