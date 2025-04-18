package com.github.ydewolf.classes;

import com.github.ydewolf.enums.Setores;
import com.github.ydewolf.enums.TiposFuncionario;

public class Intern extends User {
    protected String name;
    protected String cpf;
    protected String data_nascismento;
    protected String telefone;
    protected String endereco;
    protected Setores setor;
    protected double salario;
    protected TiposFuncionario tipo;

    public boolean valido = true;

    public Intern(
            String name,
            UserHolder holder,
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
        ((UserHolder) this.user_holder).baterPonto(this);
    }

    public void seDemitir() {
        ((UserHolder) this.user_holder).removeUser(new UserSession(this), this.username);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean setCpf(String cpf) {
        // Contando com o traço
        if (cpf.length() != 12) {
            System.out.println("Cpf inválido");
            this.valido = false;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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