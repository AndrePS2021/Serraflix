package telas.menus;

import app.App;
import mensagens.Mensagens;

import java.util.ArrayList;
import java.util.Arrays;

import static mensagens.Mensagens.colorErrorMessage;

public class TelaInicial extends Menu{

    private TelaExibir telaExibir = new TelaExibir(this);
    private TelaAdicionar telaAdicionar = new TelaAdicionar(this);
    private TelaEditar telaEditar = new TelaEditar(this);
    private TelaExcluir telaExcluir = new TelaExcluir(this);

    public TelaInicial(){
        super(
                Mensagens.Cabecalhos.SERRAFLIX,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Mensagens.Opcoes.EXIBIR_PROGRAMAS,
                        Mensagens.Opcoes.ADICIONAR_PROGRAMAS,
                        Mensagens.Opcoes.EDITAR_PROGRAMAS,
                        Mensagens.Opcoes.EXCLUIR_PROGRAMAS,
                        Mensagens.Opcoes.SAIR
                )));
    }

    @Override
    public void run(Boolean exibirCabecalho ,Boolean exibirInstruca, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstruca, exibirOpcoes, lerOpcoes);

        switch (super.opcaoSelecionada){

            // Exibir Programas
            case 1:
                telaExibir.run(true, true, true, true);
                break;

            // Adicionar Programas
            case 2:
                telaAdicionar.run(true, true, true, true);
                break;

            // Editar Programas
            case 3:
                if(App.getBiblioteca().getProgramas().size() > 0){
                    telaEditar.run(true, true, true, true);
                }else{
                    System.out.println(colorErrorMessage(Mensagens.Avisos.BIBLIOTECA_VAZIA));
                    this.run(true,true,true,true);
                }
                break;

            // Excluir Programas
            case 4:
                if(App.getBiblioteca().getProgramas().size() > 0){
                    telaExcluir.run(true, true, true, true);
                }else{
                    System.out.println(colorErrorMessage(Mensagens.Avisos.BIBLIOTECA_VAZIA));
                    this.run(true,true,true,true);
                }
                break;

            // Sair
            case 5:
                App.sair(0);
                break;
        }
    }
}
