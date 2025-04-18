package com.github.ydewolf.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        // Registrar o usuário admin padrão
        this.registrarFuncionario(
            TiposUsuario.ADMIN, "Admin", "admin", 
            "admin", "default@admin.account", "123456789-10", 
            null, null, 
            null, null, 0, null);
    }

    public void registrarFuncionario(
            TiposUsuario tipo_usuario,
            String name,
            String username,
            String password,
            String email,
            String cpf,
            String data_nascimento,
            String telefone,
            String endereco,
            Setores setor,
            double salario,
            TiposFuncionario tipo
        ) {
            if (tipo_usuario == TiposUsuario.ADMIN) {
                Admin funcionario = new Admin(
                        name, this, username,
                        password, email, cpf,
                        data_nascimento, telefone, endereco,
                        setor, salario, tipo
                );
                if (!funcionario.valido) {
                    System.out.println("O funcionário não pôde ser registrado");
                    return;
                }
    
                users.add(funcionario);
                System.out.println("O dono " + funcionario.name + " foi registrado com sucesso");
            } else {
                Intern funcionario = new Intern(
                    name, this, username,
                    password, email, cpf,
                    data_nascimento, telefone, endereco,
                    setor, salario, tipo
                );
                if (!funcionario.valido) {
                    System.out.println("O funcionário não pôde ser registrado");
                    return;
                }
    
                users.add(funcionario);
                System.out.println("O funcionario " + funcionario.name + " foi registrado com sucesso");
            }

    }

    @Override
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

    // Polimorfismo
    
    public void baterPonto(User user) {
        String[] ponto_data = {LocalDateTime.now().toString(), user.username};
        this.pontos.add(ponto_data);

        System.out.println(ponto_data[PontoFormat.TIME.ordinal()] + " | " + ponto_data[PontoFormat.USERNAME.ordinal()] + " bateu ponto");
    }
    
    public void baterPonto(UserSession session) {
        String[] ponto_data = {LocalDateTime.now().toString(), session.getUser().getUsername()};
        this.pontos.add(ponto_data);

        System.out.println(ponto_data[PontoFormat.TIME.ordinal()] + " | " + ponto_data[PontoFormat.USERNAME.ordinal()] + " bateu ponto");
    }
}
