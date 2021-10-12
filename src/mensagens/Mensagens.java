package mensagens;

public abstract class Mensagens{

    public static class Classificacao {
        public static final String CLASSIFICACAO_FILME_INVALIDA = "Classificação de Filme Inválida! 0 a 5.";
        public static final String CLASSIFICACAO_SERIE_INVALIDA = "Classificação de Série Inválida! 0 a 10.";
    }
     
    public static class Opcoes{
        public static final String OPCAO_INVALIDA = "Opção Inválida!";
        public static final String ESCOLHER_OPCOES = "Escolha uma das opções abaixo:";
        public static final String EXIBIR_PROGRAMAS = "Exibir Programas";
        public static final String EXIBIR_SERIE = "Exibir Série";
        public static final String EXIBIR_FILME = "Exibir Filme";
        public static final String ADICIONAR_PROGRAMAS = "Adicionar Programas";
        public static final String ADICIONAR_SERIE = "Adicionar Série";
        public static final String ADICIONAR_FILME = "Adicionar Filme";
        public static final String EDITAR_PROGRAMAS = "Editar Programas";
        public static final String EDITAR_SERIE = "Editar Série";
        public static final String EDITAR_FILME = "Editar Filme";
        public static final String EXCLUIR_PROGRAMAS = "Excluir Programas";
        public static final String EXCLUIR_SERIE = "Excluir Série";
        public static final String EXCLUIR_FILME = "Excluir Filme";
        public static final String SALVAR = "Salvar";
        public static final String EXCLUIR = "Excluir";
        public static final String SAIR = "Sair";
        public static final String VOLTAR = "Voltar";
        public static final String INICIAL = "Menu Inicial";
        public static final String SIM = "Sim";
        public static final String NAO = "Não";
        public static final String TODOS = "Exibir Todos";
        public static final String ADICIONAR_TEMPORADA = "Adicionar Episódios da Temporada";
        public static final String QTD_EPISODIOS = "Quantidade de Episódios: ";
        public static final String EDITAR_NOME = "Editar Nome";
        public static final String EDITAR_PONTUACAO = "Editar Pontuação";
        public static final String EDITAR_CATEGORIA = "Editar Categoria";
        public static final String EDITAR_TEMPORADAS = "Editar Temporadas";
        public static final String EDITAR_DURACAO = "Editar Duração";
    }
    public static class Cabecalhos{
        public static final String SERRAFLIX = "=== SERRAFLIX ===";
        public static final String EXIBIR_PROGRAMAS = "=== EXIBIR PROGRAMAS ===";
        public static final String EXIBIR_SERIES = "=== EXIBINDO SÉRIES ===";
        public static final String EXIBIR_FILMES = "=== EXIBINDO FILMES ===";
        public static final String ADICIONAR_PROGRAMAS = "=== ADICIONANDO PROGRAMAS ===";
        public static final String ADICIONAR_SERIES = "=== ADICIONANDO SÉRIES ===";
        public static final String ADICIONAR_FILMES = "=== ADICIONANDO FILMES ===";
        public static final String EDITAR_PROGRAMAS = "=== EDITANDO PROGRAMAS ===";
        public static final String EDITAR_SERIES = "=== EDITANDO SÉRIES ===";
        public static final String EDITAR_FILMES = "=== EDITANDO FILMES ===";
        public static final String EXCLUIR_PROGRAMAS = "=== EXCLUIR PROGRAMAS ===";
        public static final String EXCLUIR_SERIES = "=== EXCLUINDO SÉRIES ===";
        public static final String EXCLUIR_FILMES = "=== EXCLUINDO FILMES ===";
    }

    public static class Instrucoes{
        public static final String INFORME_NOME = "Informe o NOME do programa que deseja editar";
        public static final String NOVO_NOME = "Informe o NOVO NOME do programa";
        public static final String NOVA_PONTUACAO = "Informe a NOVA PONTUAÇÃO do programa que deseja editar";
        public static final String NOVA_CATEGORIA = "Informe a NOVA CATEGORIA do programa que deseja editar";
        public static final String NOVA_DURACAO = "Informe a NOVA DURACAO do programa que deseja editar";
        public static final String NOVA_TEMPORADA = "Informe a NOVA DURACAO do programa que deseja editar";
    }

    public static class Saudacoes{
        public static final String TCHAU = "=== Volte Sempre :) ==="; 
    }

    public static class Erros{
        public static final String INPUT_VAZIO = "Por favor, preencha a informação corretamente.";
        public static final String NUMERO_INVALIDO = "Por favor, digite um número válido!";
        public static final String PROGRAMA_JA_CADASTRADO = "Já existe um programa com esse nome.";
        public static final String PROGRAMA_NAO_CADASTRADO = "Não existe um programa com esse nome.";
        public static final String SERIE_NAO_CADASTRADO = "Não existe uma série com esse nome.";
        public static final String SERIE_JA_CADASTRADO = "Já existe uma série com esse nome.";
        public static final String FILME_NAO_CADASTRADO = "Não existe um filme com esse nome.";
        public static final String FILME_JA_CADASTRADO = "Já existe um filme com esse nome.";
        public static final String DURACAO_INVALIDA = "Duração Inválida! Número maior que 0.";


    }

    public static class Avisos {
        public static final String LISTA_VAZIA = "Não encontrei nada. :(";
        public static final String BIBLIOTECA_VAZIA = "Não encontrei nenhum programa na sua biblioteca. :(";
        public static final String SALVO_SUCESSO = "Salvo com Sucesso! Curta seu novo Programa! :)";
        public static final String EXCLUIDO_SUCESSO = "Seu Programa foi excluído com sucesso! :)";
        public static final String SALVO_FAIL = "Não consegui salvar seu Programa! :(";
        public static final String EXCLUIR_FAIL = "Não consegui excluir seu Programa! :(";
        public static final String TEMPORADAS_INEXISTENTES = "Temporadas: nenhuma temporada cadastrada.";
        public static final String NOME_SALVO = "Nome salvo com sucesso! :)";
        public static final String PONTUACAO_SALVA = "Pontuação salva com sucesso! :)";
        public static final String CATEGORIA_SALVA = "Categoria salva com sucesso! :)";
        public static final String DURACAO_SALVA = "Duração salva com sucesso! :)";
        public static final String TEMPORADAS_SALVA = "Temporadas salvas com sucesso! :)";
    }

    public static class Categorias {
        public static final String COMEDIA = "Comédia";
        public static final String FANTASIA = "Fantasia";
        public static final String TERROR = "Terror";
    }

    public static String colorErrorMessage(String message){
        return TextColors.RED_BRIGHT + message + TextColors.RESET;
    }

    public static String colorGoodMessage(String message){
        return TextColors.CYAN_BOLD_BRIGHT + message + TextColors.RESET;
    }

    public static String colorTitleMessage(String message){
        return TextColors.BLUE_BOLD_BRIGHT + message + TextColors.RESET;
    }

    public static String colorQueryMessage(String message){
        return TextColors.YELLOW_BOLD_BRIGHT + message + TextColors.RESET;
    }

    public static class TextColors{
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String BLACK = "\033[0;30m";   // BLACK
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String YELLOW = "\033[0;33m";  // YELLOW
        public static final String BLUE = "\033[0;34m";    // BLUE
        public static final String PURPLE = "\033[0;35m";  // PURPLE
        public static final String CYAN = "\033[0;36m";    // CYAN
        public static final String WHITE = "\033[0;37m";   // WHITE

        // Bold
        public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
        public static final String RED_BOLD = "\033[1;31m";    // RED
        public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
        public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
        public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
        public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
        public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
        public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

        // Underline
        public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
        public static final String RED_UNDERLINED = "\033[4;31m";    // RED
        public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
        public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
        public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
        public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
        public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
        public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

        // Background
        public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
        public static final String RED_BACKGROUND = "\033[41m";    // RED
        public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
        public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
        public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
        public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
        public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
        public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

        // High Intensity
        public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        public static final String RED_BRIGHT = "\033[0;91m";    // RED
        public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

        // Bold High Intensity
        public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
        public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
        public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
        public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
        public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
        public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

        // High Intensity backgrounds
        public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
        public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
        public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
        public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
        public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
        public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
        public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
        public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    }
}