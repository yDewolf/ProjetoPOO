package com.github.ydewolf.classes;

import com.github.ydewolf.enums.Setores;
import com.github.ydewolf.enums.TiposFuncionario;
import com.github.ydewolf.enums.TiposUsuario;

public class Admin extends Intern {
    public Admin(String name, UserHolder holder, String username, String password, String email, String cpf,
            String data_nascimento, String telefone, String endereco, Setores setor, double salario,
            TiposFuncionario tipo) 
        {
        super(name, holder, username, password, email, cpf, data_nascimento, telefone, endereco, setor, salario, tipo);
    }

    public void cadastrarFuncionario(
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
        ((UserHolder) this.user_holder).registrarFuncionario(
            TiposUsuario.NORMAL, name, username,
            password, email, cpf, data_nascimento,
            telefone, endereco, setor, salario, tipo
        );
    }

    public void demitirFuncionario(String username) {
        if (this.user_holder.getUser(username) == null) {
            System.out.println("O funcionario não está registrado | Username não encontrado");
            return;
        }

        ((UserHolder) this.user_holder).removeUser(new UserSession(this), username);
    }

    public void atualizarSalario(String username, double salario) {
        User usuario = this.user_holder.getUser(username);
        if (usuario == null) {
            System.out.println("O funcionario não está registrado | Username não encontrado");
            return;
        }

        if (Intern.class.isInstance(usuario)) {
            ((Intern) usuario).setSalario(salario);
            System.out.println("Salario atualizado com sucesso!");
        }
    }

    public void atualizarSetor(String username, Setores setor) {
        User usuario = this.user_holder.getUser(username);
        if (usuario == null) {
            System.out.println("O funcionario não está registrado | Username não encontrado");
            return;
        }

        if (Intern.class.isInstance(usuario)) {
            ((Intern) usuario).setSetor(setor);
            System.out.println("Setor atualizado com sucesso!");
        }
    }
}
