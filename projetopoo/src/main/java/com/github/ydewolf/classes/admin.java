package com.github.ydewolf.classes;

import com.github.ydewolf.enums.Setores;
import com.github.ydewolf.enums.TiposFuncionario;
import com.github.ydewolf.enums.TiposUsuario;

public class Admin extends Intern {
    public Admin(String name, UserHolder holder, String username, String password, String email, String cpf,
            String data_nascismento, String telefone, String endereco, Setores setor, double salario,
            TiposFuncionario tipo) 
        {
        super(name, holder, username, password, email, cpf, data_nascismento, telefone, endereco, setor, salario, tipo);
    }

    public void cadastrarFuncionario(
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
        this.user_holder.registrarFuncionario(TiposUsuario.NORMAL, name, username, password, email, cpf, data_nascismento, telefone, endereco, setor, salario, tipo);
    }

    public void demitirFuncionario() {
        this.user_holder.removeUser(new UserSession(this), this.username);
    }

    public void atualizarSalario(String username, double salario) {
        User usuario = this.user_holder.getUser(username);
        if (Intern.class.isInstance(usuario)) {
            ((Intern) usuario).setSalario(salario);
            System.out.println("Salario atualizado com sucesso!");
        }
    }

    public void atualizarSetor(String username, Setores setor) {
        User usuario = this.user_holder.getUser(username);
        if (Intern.class.isInstance(usuario)) {
            ((Intern) usuario).setSetor(setor);
            System.out.println("Setor atualizado com sucesso!");
        }
    }
}
