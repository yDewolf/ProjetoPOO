package com.github.ydewolf.classes;

import com.github.ydewolf.enums.Setores;
import com.github.ydewolf.enums.TiposFuncionario;

public class Intern extends User {
    protected String name;
    protected int cpf;
    protected String data_nascismento;
    protected int telefone;
    protected String endereco;
    protected Setores setor;
    protected double salario;
    protected TiposFuncionario tipo;

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
            Setores setor,
            double salario,
            TiposFuncionario tipo
        ) {
        
        super(holder, username, password, email);
        this.setName(name);
        this.setCpf(cpf);
        this.setData_nascismento(data_nascismento);
        this.setTelefone(telefone);
        this.setEndereco(endereco);
        this.setSetor(setor);
        this.setSalario(salario);
        this.setTipo(tipo);
    }

    public void baterPonto() {
        this.user_holder.baterPonto(this);
    }

    public void seDemitir() {
        this.user_holder.removeUser(new UserSession(this), this.username);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCpf() {
        return cpf;
    }

    public boolean setCpf(int cpf) {
        if (cpf % Math.pow(10, 12) != 0) {
            System.out.println("O funcionário não pôde ser registrado | cpf inválido");
            return false;
        }

        this.cpf = cpf;
        return true;
    }

    public String getData_nascismento() {
        return data_nascismento;
    }

    public void setData_nascismento(String data_nascismento) {
        this.data_nascismento = data_nascismento;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Setores getSetor() {
        return setor;
    }

    public void setSetor(Setores setor) {
        this.setor = setor;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public TiposFuncionario getTipo() {
        return tipo;
    }

    public void setTipo(TiposFuncionario tipo) {
        this.tipo = tipo;
    }
}