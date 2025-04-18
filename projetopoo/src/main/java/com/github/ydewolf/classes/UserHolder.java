package com.github.ydewolf.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.github.ydewolf.abstracts.BaseLoginSystem;
import com.github.ydewolf.enums.PontoFormat;
import com.github.ydewolf.enums.Setores;
import com.github.ydewolf.enums.TiposFuncionario;
import com.github.ydewolf.enums.TiposUsuario;

public class UserHolder extends BaseLoginSystem {
    private ArrayList<String[]> pontos;
    
    public UserHolder() {
        this.users = new ArrayList<>();
        this.pontos = new ArrayList<>();

        this.registerUser("admin", "admin", "default@email.com");
    }

    public UserSession logIn(String username, String password) {
        UserSession session = new UserSession(this.getUser(username));
        if (!session.isLogged()) {
            return new UserSession(null);
        }

        return session;
    }

    public void registrarFuncionario(
            TiposUsuario tipo_usuario,
            String name,
            String username,
            String password,
            String email,
            String cpf,
            String data_nascismento,
            String telefone,
            String endereco,
            Setores setor,
            double salario,
            TiposFuncionario tipo
        ) {
            if (tipo_usuario == TiposUsuario.DONO) {
                Admin funcionario = new Admin(name, this, username, password, email, cpf, data_nascismento, telefone, endereco, setor, salario, tipo);
                if (!funcionario.valido) {
                    System.out.println("O funcionário não pôde ser registrado");
                    return;
                }
    
                users.add(funcionario);
                System.out.println("O dono " + funcionario.name + " foi registrado com sucesso");
            } else {
                Intern funcionario = new Intern(name, this, username, password, email, cpf, data_nascismento, telefone, endereco, setor, salario, tipo);
                if (!funcionario.valido) {
                    System.out.println("O funcionário não pôde ser registrado");
                    return;
                }
    
                users.add(funcionario);
                System.out.println("O funcionario " + funcionario.name + " foi registrado com sucesso");
            }

    }

    public void removeUser(UserSession session, String username) {
        if (!session.isLogged()) {
            System.err.println("ERROR: You can't remove a user if you aren't logged");
            return;
        }

        int user_idx = this.users.indexOf(getUser(username));
        // Usuário se demitindo
        if (session.getUser().username.equals(username)) {
            this.users.remove(user_idx);
            System.out.println("O usuário " + username + " se demitiu com sucesso");
            return;
        }

        // Usuário é demitido
        this.users.remove(user_idx);
        System.out.println("O usuário " + username + " foi demitido com sucesso");
    }

    public void baterPonto(User user) {
        String[] ponto_data = {LocalDateTime.now().toString(), user.username};
        this.pontos.add(ponto_data);

        System.out.println(ponto_data[PontoFormat.TIME.ordinal()] + " | " + ponto_data[PontoFormat.USERNAME.ordinal()] + " bateu ponto");
    }
}
