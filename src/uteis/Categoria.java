package uteis;

import mensagens.Mensagens;

public enum Categoria {
    COMEDIA(Mensagens.Categorias.COMEDIA),
    FANTASIA(Mensagens.Categorias.FANTASIA),
    TERROR(Mensagens.Categorias.TERROR);

    private final String categoria;

    Categoria(String categoria) {
        this.categoria = categoria;
    }

    public static String getCategorias(){
        String str = "";

        for (int i = 0; i < Categoria.values().length; i++) {
            str += (i+1) + " - " + Categoria.values()[i].toString() + "\n";
        }

        return str;
    }

    @Override
    public String toString() {
        return this.categoria;
    }
}
