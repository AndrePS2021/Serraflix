package uteis;

public enum Categoria {
    COMEDIA("Comédia"),
    FANTASIA("Fantasia"),
    TERROR("Terror");

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
