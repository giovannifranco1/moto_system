package modelo;

public enum Cor {
    BRANCO(1, "Branco"),
    PRETO(2, "Preto"),
    VERMELHO(3,"Vermelho"),
    AMARELO(4,"Amarelo"),
    CINZA(5,"Cinza");

    private int id;
    private String descricao;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }

    private Cor(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }
    public static Cor valueOf(int opcao){
        for (Cor cor: Cor.values()) {
            if(cor.getId() == opcao){
                return cor;
            }
        }
        return null;
    }

    public static void listaCor(){
        for (Cor cor: Cor.values()) {
            System.out.println(cor.getId() + " - " + cor.descricao);
        }
    }
}
