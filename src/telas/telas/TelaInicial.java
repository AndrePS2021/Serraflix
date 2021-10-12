package telas.telas;

import app.App;
import mensagens.Mensagens;

import java.util.ArrayList;
import java.util.Arrays;

import static mensagens.Mensagens.colorErrorMessage;
import static mensagens.Mensagens.colorTitleMessage;

public class TelaInicial extends Tela {

    private TelaExibir telaExibir = new TelaExibir(this);
    private TelaAdicionar telaAdicionar = new TelaAdicionar(this);
    private TelaEditar telaEditar = new TelaEditar(this);
    private TelaExcluir telaExcluir = new TelaExcluir(this);

    public TelaInicial(){
        this.cabecalho = Mensagens.Cabecalhos.SERRAFLIX;
        this.instrucao = Mensagens.Opcoes.ESCOLHER_OPCOES;
        this.menus = new ArrayList<String>(Arrays.asList(
                Mensagens.Opcoes.EXIBIR_PROGRAMAS,
                Mensagens.Opcoes.ADICIONAR_PROGRAMAS,
                Mensagens.Opcoes.EDITAR_PROGRAMAS,
                Mensagens.Opcoes.EXCLUIR_PROGRAMAS,
                Mensagens.Opcoes.SAIR
        ));
        this.telaInicial = this;
        this.telaAnterior = this;
    }

    @Override
    public void run(Boolean exibirCabecalho ,Boolean exibirInstruca, Boolean exibirOpcoes, Boolean lerOpcoes) {
        //super.run(exibirCabecalho, exibirInstruca, exibirOpcoes, lerOpcoes);
        System.out.println(colorTitleMessage("\n" + this.cabecalho));
        System.out.println(this.instrucao);
        super.printarOpcoes();
        super.lerOpcao("> ", this.menus.size());

        switch (this.menus.get(this.opcaoSelecionada-1)){

            // Exibir Programas
            case Mensagens.Opcoes.EXIBIR_PROGRAMAS:
                telaExibir.run(true, true, true, true);
                break;

            // Adicionar Programas
            case Mensagens.Opcoes.ADICIONAR_PROGRAMAS:
                telaAdicionar.run(true, true, true, true);
                break;

            // Editar Programas
            case Mensagens.Opcoes.EDITAR_PROGRAMAS:
                if(App.getBiblioteca().getProgramas().size() > 0){
                    telaEditar.run(true, true, true, true);
                }else{
                    System.out.println(colorErrorMessage(Mensagens.Avisos.BIBLIOTECA_VAZIA));
                    this.run(true,true,true,true);
                }
                break;

            // Excluir Programas
            case Mensagens.Opcoes.EXCLUIR_PROGRAMAS:
                if(App.getBiblioteca().getProgramas().size() > 0){
                    telaExcluir.run(true, true, true, true);
                }else{
                    System.out.println(colorErrorMessage(Mensagens.Avisos.BIBLIOTECA_VAZIA));
                    this.run(true,true,true,true);
                }
                break;

            // Sair
            case Mensagens.Opcoes.SAIR:
                App.sair(0);
                break;
        }
    }
}
