package classes.exceptions;

import mensagens.Mensagens.Classificacao;
import uteis.TipoPrograma;

import static mensagens.Mensagens.colorErrorMessage;

public class ClassificacaoForaDoRangeException extends Exception{

    public ClassificacaoForaDoRangeException(String mensagem) {
        super(mensagem);
    }

    public static void validarClassificacao(int classificacao, TipoPrograma tipoPrograma) throws ClassificacaoForaDoRangeException{
        switch (tipoPrograma) {
            case FILME:
                if (classificacao < 0 || classificacao > 5) {
                    throw new ClassificacaoForaDoRangeException(colorErrorMessage(Classificacao.CLASSIFICACAO_FILME_INVALIDA));
                }
                break;
            
            case SERIE:
                if (classificacao < 0 || classificacao > 10) {
                    throw new ClassificacaoForaDoRangeException(colorErrorMessage(Classificacao.CLASSIFICACAO_SERIE_INVALIDA));
                }
                break;
        }
    }
}