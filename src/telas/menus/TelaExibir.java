package telas.menus;

import mensagens.Mensagens;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.Arrays;

public class TelaExibir extends Menu{

    private TelaExibirCategoria telaExibirCategoria = new TelaExibirCategoria(this);
    private Menu menuAnterior;

    public TelaExibir(Menu menuAnterior){
        super(
                Mensagens.Cabecalhos.EXIBIR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.EXIBIR_SERIE,
                        Mensagens.Opcoes.EXIBIR_FILME,
                        Mensagens.Opcoes.VOLTAR
                )));

        this.menuAnterior = menuAnterior;
    }

    @Override
    public void run(Boolean exibirCabecalho ,Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);

        switch (super.opcaoSelecionada){

            // Exibir Série
            case 1:
                telaExibirCategoria.setCabecalho(Mensagens.Cabecalhos.EXIBIR_SERIES);
                telaExibirCategoria.run(true, true, true, TipoPrograma.SERIE);
                break;

            // Exibir Filmes
            case 2:
                telaExibirCategoria.setCabecalho(Mensagens.Cabecalhos.EXIBIR_FILMES);
                telaExibirCategoria.run(true, true, true, TipoPrograma.FILME);
                break;

            // Voltar
            case 3:
                this.menuAnterior.run(true, true, true, true);
                break;
        }
    }
}
