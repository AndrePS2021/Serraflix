package telas.telas;

import app.App;
import mensagens.Mensagens;

import java.util.ArrayList;
import java.util.Arrays;

public class TelaEditar extends Tela {

    private TelaEditarPrograma telaEditarPrograma = new TelaEditarPrograma(this);

    public TelaEditar(Tela telaAnterior){
        super(
                Mensagens.Cabecalhos.EDITAR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.EDITAR_SERIE,
                        Mensagens.Opcoes.EDITAR_FILME
                )));

        this.telaAnterior = telaAnterior;
    }

    @Override
    public void run(Boolean exibirCabecalho ,Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);

        switch (this.menus.get(this.opcaoSelecionada-1)){

            // Editar Série
            case Mensagens.Opcoes.EDITAR_SERIE:
                telaEditarPrograma.setCabecalho(Mensagens.Cabecalhos.EDITAR_SERIES);
                telaEditarPrograma.editarSerie(App.getBiblioteca());
                this.run(true,true, true, true);
                break;

            // Editar Filme
            case Mensagens.Opcoes.EDITAR_FILME:
                telaEditarPrograma.setCabecalho(Mensagens.Cabecalhos.EDITAR_FILMES);
                telaEditarPrograma.editarFilme(App.getBiblioteca());
                this.run(true,true, true, true);
                break;
        }
    }
}
