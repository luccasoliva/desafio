package org.example.services;

import org.example.model.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioServiceImpl implements IFuncionarioService {
    List<Object> funcionarios = new ArrayList<Object>();
    String spc = "---------------------------------------------------------------------------------------------------";

    @Override
    public void adicionarFuncionarios(){
        Funcionario funcionario;
        funcionarios.add(funcionario = new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal("2009.44"),"Operador"));
        funcionarios.add(funcionario = new Funcionario("João", LocalDate.of(1990,5,12), new BigDecimal("2284.38"),"Operador"));
        funcionarios.add(funcionario = new Funcionario("Caio", LocalDate.of(1961,5,2), new BigDecimal("9836.14"),"Coordenador"));
        funcionarios.add(funcionario = new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal("19119.88"),"Diretor"));
        funcionarios.add(funcionario = new Funcionario("Alice", LocalDate.of(1995,1,5), new BigDecimal("2234.68"),"Recepcionista"));
        funcionarios.add(funcionario = new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal("1582.72"),"Operador"));
        funcionarios.add(funcionario = new Funcionario("Arthur", LocalDate.of(1993,3,31), new BigDecimal("4071.84"),"Contador"));
        funcionarios.add(funcionario = new Funcionario("Laura", LocalDate.of(1994,7,8), new BigDecimal("3017.45"),"Gerente"));
        funcionarios.add(funcionario = new Funcionario("Heloísa", LocalDate.of(2003,5,24), new BigDecimal("1606.85"),"Eletricista"));
        funcionarios.add(funcionario = new Funcionario("Helena", LocalDate.of(1996,9,2), new BigDecimal("2799.93"),"Gerente"));
    }

    @Override
    public void mostrarTodosFuncionarios(){
        System.out.println(spc);
        for (Object funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    @Override
    public void deletarFuncionarioPeloNome(String nome){
        System.out.println(spc);
        funcionarios.stream().filter(funcionario -> ((Funcionario) funcionario)
                .getNome()
                .equals(nome))
                .findFirst()
                .ifPresent(funcionario -> funcionarios.remove(funcionario));
    }

    @Override
    public void aumentoNoSalarioPorPorcentagem(BigDecimal porcentagem){
        System.out.println(spc);
        funcionarios.forEach(funcionario -> ((Funcionario) funcionario)
                .setSalario(((Funcionario) funcionario)
                        .getSalario()
                        .multiply(porcentagem)
                        .divide(new BigDecimal("100"))
                        .add(((Funcionario) funcionario).getSalario())
                        .setScale(2, RoundingMode.HALF_UP)));

    }

    @Override
    public void agruparPorFuncao() {
        System.out.println(spc);
        funcionarios
                .stream()
                .map(funcionarios -> ((Funcionario) funcionarios)
                        .getFuncao()).distinct()
                .forEach(funcao -> {
            System.out.println(funcao);
            funcionarios
                    .stream()
                    .filter(funcionario -> ((Funcionario) funcionario)
                            .getFuncao().equals(funcao))
                    .forEach(System.out::println);
        });
    }

    @Override
    public void funcionariosPorMesDeNascimento(int... meses) {
        System.out.println(spc);
        for (int mes : meses) {
            System.out.println("Funcionários que nasceram no mês " + mes);
            funcionarios
                    .stream()
                    .filter(funcionario -> ((Funcionario) funcionario)
                            .getDataNascimento()
                            .getMonthValue() == mes)
                    .forEach(System.out::println);
        }
    }

    @Override
    public void funcionarioMaisVelho() {
        System.out.println(spc);
        System.out.println("Funcionário mais velho:");
        System.out.println(funcionarios
                .stream()
                .min((funcionario1, funcionario2) -> ((Funcionario) funcionario1)
                        .getDataNascimento()
                        .compareTo(((Funcionario) funcionario2)
                                .getDataNascimento())).map(funcionario -> ((Funcionario) funcionario)
                        .getNome() + " - " + ((Funcionario) funcionario)
                        .getDataNascimento()
                        .until(LocalDate.now())
                        .getYears() + " anos").orElse("Não há funcionários cadastrados"));
    }

    @Override
    public void mostrarFuncionariosEmOrdemAlfabetica() {
        System.out.println(spc);
        System.out.println("Funcionários em ordem alfabética");
        funcionarios
                .stream()
                .sorted((funcionario1, funcionario2) -> ((Funcionario) funcionario1)
                        .getNome()
                        .compareTo(((Funcionario) funcionario2)
                                .getNome()))
                .forEach(System.out::println);
    }

    @Override
    public void valorTotalDosSalarios() {
        System.out.println(spc);
        System.out.println("Total dos salários");
        BigDecimal total = funcionarios
                .stream()
                .map(funcionario -> ((Funcionario) funcionario)
                        .getSalario())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(NumberFormat.getCurrencyInstance().format(total));
    }

    @Override
    public void quantosSalariosMinimosCadaUmRecebe() {
        System.out.println(spc);
        System.out.println("Quantos salários mínimos");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios
                .stream()
                .map(funcionario -> ((Funcionario) funcionario)
                        .getNome() + " - " + ((Funcionario) funcionario)
                        .getSalario()
                        .divide(salarioMinimo, 2, RoundingMode.HALF_UP))
                .forEach(System.out::println);

    }

}
