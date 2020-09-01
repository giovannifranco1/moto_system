package principal;
import modelo.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        new Principal().login();
    }
    public void login(){
        List<DadosLogin> dados = new ArrayList<DadosLogin>();
        dados.add(new DadosLogin("giovanni", "abcd123", true));
        dados.add(new DadosLogin("junin", "222", false));
        // 1 = admin, 2 = padrão, 0 = null
        int pessoa = DadosLogin.loginMenu(dados);
        //Menu admistradores
        if(pessoa == 1){
            Moto.menuAdmin();
        }
        //Menu cliente
        if(pessoa == 2){
            Moto.menuCliente();
        }
    }
}
