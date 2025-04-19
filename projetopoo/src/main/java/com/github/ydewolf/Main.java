package com.github.ydewolf;

import com.github.ydewolf.classes.Admin;
import com.github.ydewolf.classes.Intern;
import com.github.ydewolf.classes.UserHolder;
import com.github.ydewolf.classes.UserSession;
import com.github.ydewolf.enums.Setores;
import com.github.ydewolf.enums.TiposFuncionario;

public class Main {
    public static void main(String[] args) {
        UserHolder user_holder = new UserHolder();
        // >> O dono Admin foi registrado com sucesso
        
        UserSession admin_session = user_holder.logIn("admin", "admin");
        Admin admin_user = (Admin) admin_session.getUser();

        admin_user.cadastrarFuncionario(
            "Nome do funcionario",
            "nome_de_usuario",
            "senha",
            "emailDoFuncionario@email",
            "123456789-10",
            "01-01-0001",
            "11000000000",
            "Endereco do funcionario",
            Setores.TI,
            9000,
            TiposFuncionario.CLT
        ); // >> O funcionario Nome do funcionario foi registrado com sucesso
        
        UserSession user_session = user_holder.logIn("nome_de_usuario", "senha");
        Intern funcionario = (Intern) user_session.getUser();
        funcionario.baterPonto();
        // >> YYYY-DD-MM-TIMEZONE-HH:MM:SS | nome_de_usuario bateu ponto

        admin_user.atualizarSalario("nome_de_usuario", 10500);

        admin_user.demitirFuncionario("nome_de_usuario");
        // >> O usuário nome_de_usuario foi demitido com sucesso
    }
}