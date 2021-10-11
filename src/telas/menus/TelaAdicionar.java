package telas.menus;

import app.App;
import mensagens.Mensagens;

import java.util.ArrayList;
import java.util.Arrays;

public class TelaAdicionar extends Menu{

    private TelaAdicionarPrograma telaAdicionarPrograma = new TelaAdicionarPrograma(this);
    private Menu menuAnterior;

    public TelaAdicionar(Menu menuAnterior){
        super(
                Mensagens.Cabecalhos.ADICIONAR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.ADICIONAR_SERIE,
                        Mensagens.Opcoes.ADICIONAR_FILME,
                        Mensagens.Opcoes.VOLTAR
                )));

        this.menuAnterior = menuAnterior;
    }

    @Override
    public void run(Boolean exibirCabecalho ,Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);

        switch (super.opcaoSelecionada){

            // Adicionar Série
            case 1:
                telaAdicionarPrograma.setCabecalho(Mensagens.Cabecalhos.ADICIONAR_SERIES);
                telaAdicionarPrograma.adicionarSerie(App.getBiblioteca());
                this.run(true,true, true, true);
                break;

            // Adicionar Filme
            case 2:
                telaAdicionarPrograma.setCabecalho(Mensagens.Cabecalhos.ADICIONAR_FILMES);
                telaAdicionarPrograma.adicionarFilme(App.getBiblioteca());
                this.run(true,true, true, true);
                break;

            // Voltar
            case 3:
                this.menuAnterior.run(true, true, true, true);
                break;
        }
    }
}
