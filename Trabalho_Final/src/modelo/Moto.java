package modelo;

/**
 * avaliação a2
 * nome: Giovanni franco Rezende
 * Diciplina: algoritmos e programação 2
 *
 */

import interfaces.Impressao;
import java.time.LocalDate;
import java.util.*;

public class Moto extends Veiculo implements Impressao {
    // Atributos da classe Moto.
    private Motor motor;
    private String modelo;
    private Double quilometros;
    // Scan
    static Scanner scan = new Scanner(System.in);

    //Construtor padrão
    public Moto() {
    }

    public Moto(int id, String nome, LocalDate dataFabricacao, Cor cor, String modelo, double quilometros) {
        super(id, nome, dataFabricacao, cor);
        this.modelo = modelo;
        this.quilometros = quilometros;
    }
    // encapsulamento dos atributos


    public void setQuilometros(Double quilometros) {
        this.quilometros = quilometros;
    }

    public Double getQuilometros() {
        return quilometros;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }


    @Override
    public String toString() {
        return "Moto - {" + super.toString() +
                ", modelo='" + modelo + '\'' +
                ", motor=" + motor +
                '}';
    }
    public static void menuCliente(){
        int opcao = 0;
        System.out.println("--VOCÊ ESTA LOGADO COMO CLIENTE");
        ListaMotos lista = new ListaMotos();
        lista.inserindoLista();
        while (opcao != 2) {
            System.out.println("");
            System.out.println("(1) - listar motos");
            System.out.println("(2) - sair");
            System.out.print("Escolha: ");
            opcao = scan.nextInt();
            if (opcao == 1) {
                menuLista(lista.getLista());
            }
        }
    }
    public static void menuAdmin() {
        int opcao = 0;
        System.out.println("--VOCÊ ESTA LOGADO COMO ADMINISTRADOR");
        ListaMotos lista = new ListaMotos();
        lista.inserindoLista();

        while (opcao != 5) {
            System.out.println("");
            System.out.println("(1) - Inserir uma moto");
            System.out.println("(2) - alterar");
            System.out.println("(3) - remover");
            System.out.println("(4) - listar");
            System.out.println("(5) - sair");
            System.out.print("Escolha: ");
            opcao = scan.nextInt();

            if (opcao == 1) {
                lista.getLista().add(Moto.lerMoto(lista.getLista()));
            }
            else if (opcao == 2) {
                lista.alteraLista(lista.getLista());
            }
            else if (opcao == 3) {
                lista.removeMoto(lista.getLista());
            }
            else if (opcao == 4) {
                menuLista(lista.getLista());
            } else if (opcao > 5 || opcao < 0) {
                System.out.println("--OPÇÃO INVALIDA");
            }
        }
    }

    // metodo responsavel para solicitar as informações
    public static Moto lerMoto(List<Moto> lista) {
        Moto moto = new Moto();
        int dia;
        int mes;
        int ano;
        int idOpcao = 0;
        int id = 0;
        while (id != 3) {
            id = 0;
            System.out.println("Informe o id da moto: ");
            idOpcao = scan.nextInt();
            for (Moto m : lista) {
                if (Integer.valueOf(m.getId()).equals(idOpcao)) {
                    System.out.println("--ID INVALIDO!,JA EXISTE");
                    id = 1;
                }
            }
            if (id == 0) {
                moto.setId(idOpcao);
                id = 3;
            }
        }
        System.out.println("Informe o nome da moto: ");
        moto.setNome(scan.next());
        int data = 0;
        while(data != 1) {
            System.out.println("Informe o dia de fabricação");
            dia = scan.nextInt();
            System.out.println("Informe o mes de fabricação");
            mes = scan.nextInt();
            System.out.println("Informe o ano de fabricação");
            ano = scan.nextInt();
            if(dia > 31 || mes > 12){
                System.out.println("-DATA INCORRETA!");
            }
            else {
                moto.setDataFabricacao(LocalDate.of(ano, mes, dia));
                data = 1;
            }
        }

        System.out.println("Informe a cor na lista abaixo -");
        Cor.listaCor();
        int opcao = 0;
        opcao = scan.nextInt();
        moto.setCor(Cor.valueOf(opcao));
        System.out.println("Informe a quilometragem: ");
        moto.setQuilometros(scan.nextDouble());
        System.out.println("Informe o modelo: ");
        moto.setModelo(scan.next());
        moto.setMotor(Motor.lerMotor());
        System.out.println("");
        System.out.println(" --INSERIDO COM SUCESSO!");
        return moto;
    }

    @Override
    public void imprimir() {
        System.out.println(!(motor == null) ? "ID: [ " + getId() + " ] Nome - '" + getNome() + "' Marca - '"+ motor.getMarca() +"' Cilindradas = ("+ motor.getCilindros() + " cc)" +" Tipo = '"+ motor.getTipo() +"' Cor - '" + getCor().getDescricao() + "' ano - "  + getDataFabricacao().getYear() : "ID: [ " + getId() + " ] Nome - '" + getNome() + "' Cor - '" + getCor().getDescricao() + "' (sem motor) " +" ano - " + getDataFabricacao().getYear() );
    }
    public  void imprimir(String nome){
        if (nome.equals(super.getNome())) {
            System.out.println(!(motor == null) ? "ID: [ " + getId() + " ] Nome - '" + getNome() + "' Marca - '"+ motor.getMarca() +"' Cilindradas = ("+ motor.getCilindros() + " cc)" +" Tipo = '"+ motor.getTipo() +"' Cor - '" + getCor().getDescricao() + "' ano - "  + getDataFabricacao().getYear() : "ID: [ " + getId() + " ] Nome - '" + getNome() + "' Cor - '" + getCor().getDescricao() + "' (sem motor) " +" ano - " + getDataFabricacao().getYear() );
        }
    }

    // menu da impressao da lista
    public static void menuLista(List<Moto> lista) {
        int opcao;
        System.out.println("(1) - Fltrar por ano");
        System.out.println("(2) - Filtra por marca");
        System.out.println("(3) - Ordenar por ano");
        System.out.println("(4) - Filtrar por nome");
        System.out.println("(5) - Listar todas as motos");
        System.out.print("Escolha: ");
        opcao = scan.nextInt();
        if (opcao == 1) {
            int ano;
            System.out.println("Informe o ano: ");
            ano = scan.nextInt();
            imprimirFiltrandoPorAno(lista, ano);
        }
        else if (opcao == 2) {
            String marca;
            int p;
            System.out.println("(1) - Honda");
            System.out.println("(2) - Yamaha");
            System.out.print("Informe a marca: ");
            p = scan.nextInt();
            if (p == 1) {
                marca = "honda";
                imprimirFiltrandoPorMarca(lista, marca);
            }
            else if(p == 2){
                marca = "yamaha";
                imprimirFiltrandoPorMarca(lista, marca);
            }
            else{
                System.out.println("--OPÇÃO INVALIDA!");
            }

        }
        else if (opcao == 3) {
            imprimirOrdenandoPorAno(lista);
        }
        else if (opcao == 4){
            String nome;
            System.out.print("Informe o nome: ");
            nome = scan.next();
            imprimirFiltrandoPorNome(lista,nome);
        }
        else if(opcao == 5){
            imprimirLista(lista);
        }
        else System.out.println("--OPÇÃO INVALIDA!");
    }
    public static void imprimirListandoPorNome(List <Moto> lista){
        for (int i = 0, j = 1; i < lista.size(); i++,j++) {
            System.out.println((lista.get(i).getMotor() == null) ? j + " -  ID: [ " +lista.get(i).getId() +" ] "+
                    lista.get(i).getNome() + " (sem motor) " : j + " -  ID: [ " + lista.get(i).getId() + " ] " + lista.get(i).getNome() +
                     " " + lista.get(i).getMotor().getCilindros() +
                    " cc "+ " ANO: " + lista.get(i).getDataFabricacao().getYear());
        }
    }
    public static void imprimirFiltrandoPorMarca(List <Moto> lista, String marca) {
        // lista.forEach((moto) -> {if (moto.motor.getMarca().toUpperCase().equals(marca.toUpperCase()) && !(moto.motor == null)){moto.imprimir();} });
        // lista.stream().filter(moto -> moto.motor.getMarca().toUpperCase().equals(marca.toUpperCase())).forEach(moto -> moto.imprimir());
        for (Moto moto : lista) {
            if (!(moto.motor == null) && (moto.motor.getMarca().equals(marca))){
                moto.imprimir();
            }
        }
    }
    public  static  void imprimirOrdenandoPorAno(List <Moto> lista){
        lista.sort((m1,m2)-> Integer.compare(m1.getDataFabricacao().getYear(), m2.getDataFabricacao().getYear()));
        lista.forEach(Moto::imprimir);
    }

    public static void imprimirFiltrandoPorAno(List <Moto> lista, int ano){
        for (Moto moto :lista) {
            if(moto.getDataFabricacao().getYear() == ano) moto.imprimir();
        }
    }
    public  static void  imprimirLista (List <Moto> lista){
        for (Moto moto:lista) {
            moto.imprimir();
        }
    }
    public static void imprimirFiltrandoPorNome(List <Moto> lista,String nome){
        for (Moto moto:lista) {
            moto.imprimir(nome);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moto moto = (Moto) o;
        return Objects.equals(motor, moto.motor) &&
                Objects.equals(modelo, moto.modelo) &&
                Objects.equals(quilometros, moto.quilometros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motor, modelo, quilometros);
    }
}
