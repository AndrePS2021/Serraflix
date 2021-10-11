package telas.menus;

import app.App;
import mensagens.Mensagens;
import telas.Print;
import uteis.Categoria;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.Arrays;

public class TelaExibirCategoria extends Menu{
    private Menu menuAnterior;

    public TelaExibirCategoria(Menu menuAnterior){
        super(
                "\n" + Mensagens.Cabecalhos.EXIBIR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Categoria.COMEDIA.toString(),
                        Categoria.FANTASIA.toString(),
                        Categoria.TERROR.toString(),
                        Mensagens.Opcoes.TODOS,
                        Mensagens.Opcoes.VOLTAR
                )));

        this.menuAnterior = menuAnterior;
    }

    @Override
    public void run(Boolean exibirCabecalho, Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);
    }

    public void run(Boolean exibirCabecalho , Boolean exibirInstrucao, Boolean exibirOpcoes, TipoPrograma tipoPrograma) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, true);

        switch (super.opcaoSelecionada){

            // COMÉDIA
            case 1:
                Print.printProgramas(App.getBiblioteca().getProgramas(Categoria.COMEDIA, tipoPrograma), tipoPrograma);
                this.run(true, true, true, tipoPrograma);
                break;

            // FANTASIA
            case 2:
                Print.printProgramas(App.getBiblioteca().getProgramas(Categoria.FANTASIA, tipoPrograma), tipoPrograma);
                this.run(true, true, true, tipoPrograma);
                break;

            // TERROR
            case 3:
                Print.printProgramas(App.getBiblioteca().getProgramas(Categoria.TERROR, tipoPrograma), tipoPrograma);
                this.run(true, true, true, tipoPrograma);
                break;

            // TODOS
            case 4:
                Print.printProgramas(App.getBiblioteca().getProgramas(tipoPrograma), tipoPrograma);
                this.run(true, true, true, tipoPrograma);
                break;

            // Voltar
            case 5:
                this.menuAnterior.run(true, true, true, true);
                break;
        }
    }
}
