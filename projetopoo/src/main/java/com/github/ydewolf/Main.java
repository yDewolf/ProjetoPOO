package com.github.ydewolf;

import com.github.ydewolf.classes.UserHolder;
import com.github.ydewolf.enums.Setores;
import com.github.ydewolf.enums.TiposFuncionario;
import com.github.ydewolf.enums.TiposUsuario;

public class Main {
    public static void main(String[] args) {
        UserHolder user_holder = new UserHolder();
        user_holder.registrarFuncionario(
            TiposUsuario.DONO,
            "funcionario1",
            "funcionario1senha",
            "senhadofuncionario",
            "funcionario@email.com",
            "123456789-10",
            "01-01-2000",
            "14990000000",
            "Rua maria josé, 01",
            Setores.TI,
            10000.0,
            TiposFuncionario.CLT
        );
    }
}