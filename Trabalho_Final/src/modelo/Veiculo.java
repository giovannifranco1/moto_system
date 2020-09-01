package modelo;

import interfaces.Impressao;

import java.time.LocalDate;

public abstract class Veiculo {
    private int id;
    private String nome;
    private LocalDate dataFabricacao;
    private Cor cor;

    public Veiculo(){
    }
    public Veiculo (int id,String nome, LocalDate dataFabricacao, Cor cor){
        this.id = id;
        this.nome = nome;
        this.dataFabricacao = dataFabricacao;
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public void setDataFabricacao(LocalDate dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public String getNome() {
        return nome;
    }

    public Cor getCor() {
        return cor;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataFabricacao=" + dataFabricacao +
                ", cor=" + cor +
                '}';
    }
}
