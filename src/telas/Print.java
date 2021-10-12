package telas;

import classes.Programa;
import mensagens.Mensagens;
import uteis.TipoPrograma;

import java.util.List;

import static mensagens.Mensagens.colorTitleMessage;
import static mensagens.Mensagens.colorErrorMessage;

public abstract class Print {

    public static void printProgramas(List<Programa> programas, TipoPrograma tipoPrograma){

        switch (tipoPrograma){
            case SERIE : 
            	System.out.println("\n" + colorTitleMessage(Mensagens.Cabecalhos.EXIBIR_SERIES));
            	break;
            case FILME : 
            	System.out.println("\n" + colorTitleMessage(Mensagens.Cabecalhos.EXIBIR_FILMES));
            	break;
        }

        if (programas == null || programas.size() == 0){
            System.out.println(colorErrorMessage("\n" + Mensagens.Avisos.LISTA_VAZIA));
            return;
        }

        String str = "";
        for (Programa programa: programas) {
            str += programa.toString() + "\n";
        }
        str = str.substring(0, str.length() - 2);
        System.out.println(str);
    }
}
