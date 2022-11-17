package org.example;

import org.example.services.FuncionarioService;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) throws IOException {
        FuncionarioService funcionarioService = new FuncionarioService();
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