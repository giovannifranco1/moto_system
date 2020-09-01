package modelo;
import interfaces.Impressao;
import java.util.Scanner;

public class Motor implements Impressao {
    private int codMotor;
    private String tipo;
    private int cilindros;
    private String marca;

    static Scanner scan = new Scanner(System.in);
    public Motor(){
    }
    public Motor(int codMotor, String tipo, int cilindros, String marca){
        this.codMotor = codMotor;
        this.tipo = tipo;
        this.cilindros = cilindros;
        this.marca = marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setCodMotor(int codMotor) {
        this.codMotor = codMotor;
    }

    public int getCodMotor() {
        return codMotor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setCilindros(int cilindros) {
        this.cilindros = cilindros;
    }

    public int getCilindros() {
        return cilindros;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "codMotor=" + codMotor +
                ", tipo='" + tipo + '\'' +
                ", cilindros=" + cilindros +
                ", marca=" + marca +
                '}';
    }

    public static Motor lerMotor(){
        int comp = 0;
        while (comp != 1){
            System.out.println("Existe um motor? \n (1)Sim (2)Nao");
            comp = scan.nextInt();
            if (comp == 2){
                return null;
            }
            else if (comp != 1) System.out.println("--OPÇÃO INVALIDA");
        }
        System.out.println("Informe o código do motor: ");
        Motor motor = new Motor();
        motor.setCodMotor(scan.nextInt());
        System.out.println("Informe o tipo do motor: ");
        motor.setTipo(scan.next());
        System.out.println("Informe a quantidade de cilindros do motor: ");
        motor.setCilindros(scan.nextInt());
        System.out.println("Informe a marca do motor: ");
        comp = 0;
        while (comp != 1 && comp != 2){
            System.out.println("(1)- Honda");
            System.out.println("(2)- Yamaha");
            System.out.print("Escolha: ");
            comp = scan.nextInt();
            if(comp == 1) motor.setMarca("honda");
            else if(comp == 2) motor.setMarca("yamaha");
        }
        return motor;
    }

    @Override
    public void imprimir() {
        System.out.println(this);
    }
}

