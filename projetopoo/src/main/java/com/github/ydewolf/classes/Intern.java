package com.github.ydewolf.classes;

public class Intern extends User {
    protected String name;
    protected int cpf;
    protected String data_nascismento;
    protected int telefone;
    protected String endereco;
    protected String setor;
    protected double salario;
    protected String tipo;

    public Intern(
            String name,
            UserHolder holder,
            String username,
            String password,
            String email,
            int cpf,
            String data_nascismento,
            int telefone,
            String endereco,
            String setor,
            double salario,
            String tipo
        ) {
        
        super(holder, username, password, email);
        this.name = name;
        this.cpf = cpf;
        this.data_nascismento = data_nascismento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.setor = setor;
        this.salario = salario;
        this.tipo = tipo;
    }

    public void baterPonto() {
        this.user_holder.baterPonto(this);
    }

    public void seDemitir() {
        this.user_holder.removeUser(new UserSession(this), this.username);
}
}