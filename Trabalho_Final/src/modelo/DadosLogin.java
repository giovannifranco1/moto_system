package modelo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class DadosLogin {
    private String login;
    private String senha;
    private boolean admin = false;
    static Scanner scan = new Scanner(System.in);


    public DadosLogin(String login, String senha, boolean admin) {
        this.login = login;
        this.senha = senha;
        this.admin = admin;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getAdmin() {
        return admin;
    }

    public static int loginMenu(List<DadosLogin> listaDados) {
        JPasswordField passwordField = new JPasswordField();
        // prenchendo dados
        for (int i = 3; i > 0; i--) {
            String login = "";
            String senha = "";
            System.out.print("login: ");
            login = scan.next();
            System.out.print("senha: ");
            senha = scan.next();
            for (DadosLogin dado : listaDados) {
                if (dado.getLogin().equals(login) && dado.getSenha().equals(senha) && dado.getAdmin()) {
                    i = 3;
                    return 1;
                } else if (dado.getLogin().equals(login) && dado.getSenha().equals(senha)) {
                    i = 3;
                    return 2;
                }
            }
            System.out.println("Login ou senha incorreto!");
            System.out.println("voçê tem mais " + (i - 1) + " - tentativas ");
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DadosLogin that = (DadosLogin) o;
        return Objects.equals(login, that.login) &&
                Objects.equals(senha, that.senha);
    }
    @Override
    public int hashCode() {
        return Objects.hash(login, senha);
    }
}
