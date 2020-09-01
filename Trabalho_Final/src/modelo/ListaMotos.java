package modelo;

import java.lang.management.MemoryType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class ListaMotos {
        List <Moto> lista = new ArrayList<Moto>();
        Scanner scan = new Scanner(System.in);

    public List<Moto> getLista() {
        return lista;
    }

    public void inserindoLista(){
        lista.add(new Moto(15, "Yamaha-MT-03 ABS", LocalDate.of(2020,12,12), Cor.VERMELHO, "yamaha", 0));
        lista.add(new Moto(22,"Honda-CG", LocalDate.of(2015, 12, 12), Cor.BRANCO, "flex", 26000.21));
        lista.add(new Moto(25,"Honda-biz", LocalDate.of(2001, 12, 12), Cor.PRETO, "crosse", 25000));
        lista.add(new Moto(32,"Honda-cb", LocalDate.of(2020, 12, 12), Cor.AMARELO, "flex", 0));
        lista.add(new Moto(55,"Yamaha-Xtz", LocalDate.of(2013, 12, 12), Cor.CINZA, "flex", 23541.21));
        Motor motor = new Motor(24, "bicilíndrico", 321, "yamaha");
        Motor motor1 = new Motor(21, "bicilíndrico", 160, "honda");
        Motor motor2 = new Motor(43, "bicilíndrico", 120, "honda");
        Motor motor3 = new Motor(66, "monocilíndrico", 266, "honda");
        Motor motor4 = new Motor(78, "tricilíndrico", 160, "yamaha");
        lista.get(0).setMotor(motor);
        lista.get(2).setMotor(motor2);
        lista.get(1).setMotor(motor1);
        lista.get(4).setMotor(motor4);

    }
    public static void alterandoID(int opcao, List <Moto> lista) {
        int idOpcao = 0;
        int id =0;
        Scanner scan = new Scanner(System.in);
        while (id != 3) {
            id = 0;
            System.out.println("Informe o id da moto: ");
            idOpcao = scan.nextInt();
            for (int i = 0; i < lista.size(); i++) {
                if (Integer.valueOf(lista.get(i).getId()).equals(idOpcao) && i == opcao) {
                    id = 1;
                } else if (Integer.valueOf(lista.get(i).getId()).equals(idOpcao)) {
                    System.out.println("--ID INVALIDO!, JÁ EXISTE");
                    id = 2;
                }
            }
            if (id == 0 || id == 1) {
                lista.get(opcao).setId(idOpcao);
                id = 3;
            }
        }
    }
    public static void listaId(){
        List <Moto> lista = new ArrayList<Moto>();
    }

    public void alteraLista(List <Moto> lista ){
        if(lista.isEmpty()) System.out.println("--NAO HÁ NADA NA LISTA!");
        else {
            int opcao = 0;
            int dia = 0;
            int mes = 0;
            int ano = 0;
            System.out.println("--INFORME ABAIXO QUAL MOTO DESEJA ALTERAR: ");
            System.out.println("");
            Moto.imprimirListandoPorNome(lista);
            System.out.print("Escolha: ");
            opcao = scan.nextInt() - 1;
            while (opcao + 1 > lista.size() || opcao <= -1) {
                System.out.println("--OPÇÃO INVALIDA");
                System.out.println("Escolha: ");
                opcao = scan.nextInt() - 1;
            }
            alterandoID(opcao, lista);
            System.out.println("Informe o nome da moto: ");
            lista.get(opcao).setNome(scan.next());
            int data = 0;
            while (data != 1) {
                System.out.println("Informe o dia de fabricação: ");
                dia = scan.nextInt();
                System.out.println("Informe o mes da fabricação: ");
                mes = scan.nextInt();
                System.out.println("Informe o ano da fabricação: ");
                ano = scan.nextInt();
                if (dia > 31 || mes > 12) {
                    System.out.println("-DATA INCORRETA!");
                } else {
                    lista.get(opcao).setDataFabricacao(LocalDate.of(ano, mes, dia));
                    data = 1;
                }
            }
            System.out.println("Informe a cor na lista abaixo: ");
            Cor.listaCor();
            Cor.valueOf(scan.nextInt());
            System.out.println("Informe o modelo: ");
            lista.get(opcao).setModelo(scan.next());
            System.out.println("Informe quantos quilometros rodados da moto: ");
            lista.get(opcao).setQuilometros(scan.nextDouble());
            lista.get(opcao).setMotor(Motor.lerMotor());
            System.out.println("");
            System.out.println("ALTERADO COM SUCESSO!");
        }
    }
    public void removeMoto(List <Moto> lista){
        if(lista.isEmpty()) System.out.println("--NAO HÁ NADA NA LISTA!");
        else {
            int opcao = 0;
            System.out.println("--INFORME ABAIXO QUAL MOTO DESEJA REMOVER: ");
            System.out.println("");
            Moto.imprimirListandoPorNome(lista);
            System.out.print("Escolha: ");
            opcao = scan.nextInt();
            if(opcao > lista.size() || opcao <= 0) System.out.println("--OPÇÃO INVALIDA!");
            else {
                lista.remove(opcao - 1);
                System.out.println("--REMOVIDO COM SUCESSO!");
            }
        }
    }
}
