package telas.telas;

import app.App;
import mensagens.Mensagens;
import telas.Print;
import uteis.Categoria;
import uteis.TipoPrograma;

import java.util.ArrayList;
import java.util.Arrays;

public class TelaExibirCategoria extends Tela {

    public TelaExibirCategoria(Tela telaAnterior){
        super(
                "\n" + Mensagens.Cabecalhos.EXIBIR_PROGRAMAS,
                Mensagens.Opcoes.ESCOLHER_OPCOES,
                new ArrayList<String>(Arrays.asList(
                        Categoria.COMEDIA.toString(),
                        Categoria.FANTASIA.toString(),
                        Categoria.TERROR.toString(),
                        Mensagens.Opcoes.TODOS
                )));

        this.telaAnterior = telaAnterior;
    }

    @Override
    public void run(Boolean exibirCabecalho, Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, lerOpcoes);
    }

    public void run(Boolean exibirCabecalho , Boolean exibirInstrucao, Boolean exibirOpcoes, TipoPrograma tipoPrograma) {
        super.run(exibirCabecalho, exibirInstrucao, exibirOpcoes, true);

        switch (this.menus.get(this.opcaoSelecionada-1)){

            // COMÉDIA
            case Mensagens.Categorias.COMEDIA:
                Print.printProgramas(App.getBiblioteca().getProgramas(Categoria.COMEDIA, tipoPrograma), tipoPrograma);
                this.run(true, true, true, tipoPrograma);
                break;

            // FANTASIA
            case Mensagens.Categorias.FANTASIA:
                Print.printProgramas(App.getBiblioteca().getProgramas(Categoria.FANTASIA, tipoPrograma), tipoPrograma);
                this.run(true, true, true, tipoPrograma);
                break;

            // TERROR
            case Mensagens.Categorias.TERROR:
                Print.printProgramas(App.getBiblioteca().getProgramas(Categoria.TERROR, tipoPrograma), tipoPrograma);
                this.run(true, true, true, tipoPrograma);
                break;

            // TODOS
            case Mensagens.Opcoes.TODOS:
                Print.printProgramas(App.getBiblioteca().getProgramas(tipoPrograma), tipoPrograma);
                this.run(true, true, true, tipoPrograma);
                break;
        }
    }
}
