package telas.menus;

import app.App;
import mensagens.Mensagens;

import java.util.ArrayList;
import java.util.Arrays;

public class TelaEditar extends Menu{

    private TelaEditarPrograma telaEditarPrograma = new TelaEditarPrograma(this);
    private Menu menuAnterior;

    public TelaEditar(Menu menuAnterior){
        super(
                Mensagens.Cabecalhos.EDITAR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.EDITAR_SERIE,
                        Mensagens.Opcoes.EDITAR_FILME,
                        Mensagens.Opcoes.VOLTAR
                )));

        this.menuAnterior = menuAnterior;
    }

    @Override
    public void run(Boolean exibirCabecalho ,Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);

        switch (super.opcaoSelecionada){

            // Editar Série
            case 1:
                telaEditarPrograma.setCabecalho(Mensagens.Cabecalhos.EDITAR_SERIES);
                telaEditarPrograma.editarSerie(App.getBiblioteca());
                this.run(true,true, true, true);
                break;

            // Editar Filme
            case 2:
                telaEditarPrograma.setCabecalho(Mensagens.Cabecalhos.EDITAR_FILMES);
                telaEditarPrograma.editarFilme(App.getBiblioteca());
                this.run(true,true, true, true);
                break;

            // Voltar
            case 3:
                this.menuAnterior.run(true, true, true, true);
                break;
        }
    }
}
