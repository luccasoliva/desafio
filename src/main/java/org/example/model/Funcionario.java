package org.example.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;

public class Funcionario extends Pessoa {


    protected BigDecimal salario;
    protected String funcao;



    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return
                "nome: '" + nome + '\'' +
                " | dataNascimento: " + dataNascimento.format(
                        java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                " | salario: " + NumberFormat.getCurrencyInstance().format(salario) +
                " | funcao: '" + funcao + '\'';
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
