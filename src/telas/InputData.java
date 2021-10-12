package telas;

import app.App;
import classes.Biblioteca;
import classes.exceptions.ClassificacaoForaDoRangeException;
import classes.exceptions.InputException;
import mensagens.Mensagens;
import uteis.TipoPrograma;

import java.util.NoSuchElementException;

import static mensagens.Mensagens.colorErrorMessage;


public class InputData extends Exception{

    public Integer opcaoSelecionada = null;
    public Integer inputInteger = null;
    public String inputString = null;
    public Double inputDouble = null;

    public Integer lerOpcao(String text, int qtdOpcoes) {
        while (true) {
            try {
                System.out.print(text);
                this.opcaoSelecionada = Integer.parseInt(App.input.nextLine());
                InputException.OpcaoException.validarOpcao(this.opcaoSelecionada, qtdOpcoes);
                break;

            } catch (NumberFormatException | NoSuchElementException e) {
                this.opcaoSelecionada = null;
                System.out.println(colorErrorMessage(Mensagens.Opcoes.OPCAO_INVALIDA));

            } catch (InputException.OpcaoException e) {
                this.opcaoSelecionada = null;
                System.out.println(colorErrorMessage(e.getMessage()));
            }
        }

        return this.opcaoSelecionada;
    }

    public Integer lerOpcao(String text) {
        while (true) {
            try {
                System.out.print(text);
                this.opcaoSelecionada = Integer.parseInt(App.input.nextLine());
                InputException.OpcaoException.validarOpcao(this.opcaoSelecionada, 999999999);
                break;

            } catch (NumberFormatException | NoSuchElementException e) {
                this.opcaoSelecionada = null;
                System.out.println(colorErrorMessage("Por favor, digite um número válido!"));

            } catch (InputException.OpcaoException e) {
                this.opcaoSelecionada = null;
                System.out.println(colorErrorMessage(e.getMessage()));
            }
        }

        return this.opcaoSelecionada;
    }



    public String lerStringInput(Biblioteca biblioteca, String text, TipoPrograma tipoPrograma){
        String input = null;
        while (true) {
            try {
                System.out.print(text);
                input = App.input.nextLine();
                InputException.InputVazioException.inputVazioNulo(input);
                InputException.BibliotecaException.programaJaCadastrado(input, biblioteca, tipoPrograma);
                break;

            } catch (InputException.InputVazioException | InputException.BibliotecaException e) {
                this.inputString = null;
                System.out.println(e.getMessage());
            }
        }
        this.inputString = input;
        return this.inputString;
    }

    public String nomeCadastradoInput(Biblioteca biblioteca, String text, TipoPrograma tipoPrograma){
        String input = null;
        while (true) {
            try {
                System.out.print(text);
                input = App.input.nextLine();
                InputException.InputVazioException.inputVazioNulo(input);
                InputException.BibliotecaException.programaNaoCadastrado(input, biblioteca,tipoPrograma);
                break;

            } catch (InputException.InputVazioException | InputException.BibliotecaException e) {
                this.inputString = null;
                System.out.println(e.getMessage());
            }
        }
        this.inputString = input;
        return this.inputString;
    }

    public Integer lerIntegerInput(Biblioteca biblioteca, String text, TipoPrograma tipoPrograma){
        Integer input = null;
        while (true) {
            try {
                System.out.print(text);
                input = Integer.parseInt(App.input.nextLine());
                ClassificacaoForaDoRangeException.validarClassificacao(input, tipoPrograma);
                break;

            } catch (ClassificacaoForaDoRangeException e) {
                this.inputInteger = null;
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(colorErrorMessage(Mensagens.Erros.INPUT_VAZIO));
            }
        }
        this.inputInteger = input;
        return this.inputInteger;
    }
}