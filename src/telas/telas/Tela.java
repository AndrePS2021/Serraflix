package telas.telas;

import app.App;
import mensagens.Mensagens;
import telas.InputData;

import java.util.ArrayList;

import static mensagens.Mensagens.colorTitleMessage;

public class Tela extends InputData {

    protected ArrayList<String> menus;
    protected String cabecalho;
    protected String instrucao;
    protected static Tela telaInicial;
    protected Tela telaAnterior;

    public Tela(String cabecalho, String instrucao, ArrayList<String> menus){
        this.cabecalho = cabecalho;
        this.instrucao = instrucao;
        this.menus = menus;
        this.menus.add(Mensagens.Opcoes.VOLTAR);
        this.menus.add(Mensagens.Opcoes.INICIAL);
    }

    public Tela(){

    }

    public void setCabecalho(String cabecalho) {
        this.cabecalho = cabecalho;
    }

    public void setOpcoes(ArrayList<String> menus) {
        this.menus = menus;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public void printarOpcoes(){
        for (int i = 0; i < this.menus.size(); i++) {
            System.out.println((i+1) + " - " + this.menus.get(i));
        }
    }

    public void run(Boolean exibirCabecalho , Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes){

        if (exibirCabecalho){
            System.out.println(colorTitleMessage("\n" + this.cabecalho));
        }

        if (exibirInstrucao) {
            System.out.println(this.instrucao);
        }

        if (exibirOpcoes) {
            printarOpcoes();
        }

        if (lerOpcoes){
            super.lerOpcao("> ", this.menus.size());
        }

        if(this.opcaoSelecionada != null)
        if (this.menus.get(this.opcaoSelecionada-1).contains(Mensagens.Opcoes.VOLTAR)){
            this.opcaoSelecionada = null;
            telaAnterior.run(true, true, true, true);
            return;
        }

        if(this.opcaoSelecionada != null)
        if (this.menus.get(this.opcaoSelecionada-1).contains(Mensagens.Opcoes.INICIAL)){
            this.opcaoSelecionada = null;
            telaInicial.run(true, true, true, true);
            return;
        }
    }
}
