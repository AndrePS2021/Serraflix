package telas.telas;

import app.App;
import mensagens.Mensagens;

import java.util.ArrayList;
import java.util.Arrays;

public class TelaAdicionar extends Tela {

    private TelaAdicionarPrograma telaAdicionarPrograma = new TelaAdicionarPrograma(this);

    public TelaAdicionar(Tela telaAnterior){
        super(
                Mensagens.Cabecalhos.ADICIONAR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.ADICIONAR_SERIE,
                        Mensagens.Opcoes.ADICIONAR_FILME
                )));

        this.telaAnterior = telaAnterior;
    }

    @Override
    public void run(Boolean exibirCabecalho ,Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);

        switch (this.menus.get(this.opcaoSelecionada-1)){

            // Adicionar Série
            case Mensagens.Opcoes.ADICIONAR_SERIE:
                telaAdicionarPrograma.setCabecalho(Mensagens.Cabecalhos.ADICIONAR_SERIES);
                telaAdicionarPrograma.adicionarSerie(App.getBiblioteca());
//                telaAddEditPrograma.setCabecalho(Mensagens.Cabecalhos.ADICIONAR_SERIES);
//                telaAddEditPrograma.adicionarSerie(App.getBiblioteca());
                this.run(true,true, true, true);
                break;

            // Adicionar Filme
            case Mensagens.Opcoes.ADICIONAR_FILME:
                telaAdicionarPrograma.setCabecalho(Mensagens.Cabecalhos.ADICIONAR_FILMES);
                telaAdicionarPrograma.adicionarFilme(App.getBiblioteca());
//                telaAddEditPrograma.setCabecalho(Mensagens.Cabecalhos.ADICIONAR_FILMES);
//                telaAddEditPrograma.adicionarFilme(App.getBiblioteca());
                this.run(true,true, true, true);
                break;
        }
    }
}
