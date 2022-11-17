package org.example.services;

import java.math.BigDecimal;

public interface IFuncionarioService {

    public void adicionarFuncionarios();
    public void mostrarTodosFuncionarios();
    public void deletarFuncionarioPeloNome(String nome);
    public void aumentoNoSalarioPorPorcentagem(BigDecimal porcentagem);
    public void agruparPorFuncao();
    public void funcionariosPorMesDeNascimento(int... meses);
    public void funcionarioMaisVelho();
    public void mostrarFuncionariosEmOrdemAlfabetica();
    public void valorTotalDosSalarios();
    public void quantosSalariosMinimosCadaUmRecebe();

}
