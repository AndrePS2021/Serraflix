package telas.menus;

import telas.InputData;

import java.util.ArrayList;

import static mensagens.Mensagens.colorTitleMessage;

public class Menu extends InputData {
    
    protected ArrayList<String> menus;
    protected String cabecalho;
    protected String instrucao;

    public Menu(String cabecalho, String instrucao, ArrayList<String> menus){
        this.cabecalho = cabecalho;
        this.instrucao = instrucao;
        this.menus = menus;
    }

    public Menu(){

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

    public void run(Boolean exibirCabecalho , Boolean exibirInstrucao, Boolean exibirOpcoes, Boolean lerOpcoes){

        if (exibirCabecalho){
            System.out.println(colorTitleMessage("\n" + this.cabecalho));
        }

        if (exibirInstrucao) {
            System.out.println(this.instrucao);
        }

        if (exibirOpcoes) {
            for (int i = 0; i < this.menus.size(); i++) {
                System.out.println((i+1) + " - " + this.menus.get(i));
            }
        }

        if (lerOpcoes){
            super.lerOpcao("> ", this.menus.size());
        }
    }
}
