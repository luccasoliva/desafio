package org.example;

import org.example.services.FuncionarioServiceImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        FuncionarioServiceImpl funcionarioService = new FuncionarioServiceImpl();
        funcionarioService.adicionarFuncionarios();
        funcionarioService.deletarFuncionarioPeloNome("João");
        funcionarioService.mostrarTodosFuncionarios();
        funcionarioService.aumentoNoSalarioPorPorcentagem(new BigDecimal("10"));
         funcionarioService.agruparPorFuncao();
         funcionarioService.funcionariosPorMesDeNascimento(10,12);
         funcionarioService.funcionarioMaisVelho();
         funcionarioService.mostrarFuncionariosEmOrdemAlfabetica();
         funcionarioService.valorTotalDosSalarios();
         funcionarioService.quantosSalariosMinimosCadaUmRecebe();

    }
}