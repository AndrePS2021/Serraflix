package classes.exceptions;

import classes.Biblioteca;
import mensagens.Mensagens;
import uteis.TipoPrograma;

import static mensagens.Mensagens.colorErrorMessage;

public abstract class InputException extends Exception {

    public InputException(String mensagem) {
        super(mensagem);
    }

    public static class InputVazioException extends InputException{
        public InputVazioException(String mensagem){
            super(mensagem);
        }

        public static void inputVazioNulo(String input) throws InputVazioException{
            if(input.isEmpty() ||  input.trim().length() <= 0){
                throw new InputVazioException(colorErrorMessage(Mensagens.Erros.INPUT_VAZIO));
            }
        }
    }

    public static class BibliotecaException extends InputException{
        public BibliotecaException(String mensagem){
            super(mensagem);
        }

        public static void programaJaCadastrado(String nome, Biblioteca biblioteca, TipoPrograma tipoPrograma) throws BibliotecaException {
            if (biblioteca.getPrograma(nome) != null) {
                if (biblioteca.getPrograma(nome).getTipoPrograma() == tipoPrograma) {
                    switch (tipoPrograma) {
                        case SERIE : throw new BibliotecaException(colorErrorMessage(Mensagens.Erros.SERIE_JA_CADASTRADO));
                        case FILME : throw new BibliotecaException(colorErrorMessage(Mensagens.Erros.FILME_JA_CADASTRADO));
                    }
                }
            }
        }

        public static void programaNaoCadastrado(String nome, Biblioteca biblioteca, TipoPrograma tipoPrograma) throws BibliotecaException {
            if (biblioteca.getPrograma(nome) == null) {
                switch (tipoPrograma) {
                    case SERIE : throw new BibliotecaException(colorErrorMessage(Mensagens.Erros.SERIE_NAO_CADASTRADO));
                    case FILME : throw new BibliotecaException(colorErrorMessage(Mensagens.Erros.FILME_NAO_CADASTRADO));
                }
            }

            if (biblioteca.getPrograma(nome, tipoPrograma) == null) {
                switch (tipoPrograma) {
                    case SERIE : throw new BibliotecaException(colorErrorMessage(Mensagens.Erros.SERIE_NAO_CADASTRADO));
                    case FILME : throw new BibliotecaException(colorErrorMessage(Mensagens.Erros.FILME_NAO_CADASTRADO));
                }
            }
        }
    }

    public static class OpcaoException extends InputException{
        public OpcaoException(String mensagem) {
            super(mensagem);
        }

        public static void validarOpcao(int opcao, int max) throws OpcaoException{
            if (opcao < 1 || opcao > max) {
                throw new OpcaoException(colorErrorMessage(Mensagens.Opcoes.OPCAO_INVALIDA));
            }
        }
    }
}
