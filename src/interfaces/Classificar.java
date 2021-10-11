package interfaces;

import classes.exceptions.ClassificacaoForaDoRangeException;

public interface Classificar {
    
    void classificar(Integer classificacao) throws ClassificacaoForaDoRangeException;
}
