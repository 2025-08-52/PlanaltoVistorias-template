
package Vistoria.controller;

import Vistoria.dao.VeiculoDAO;
import Vistoria.model.Veiculo;
import java.util.List;

public class VeiculoController {

    private final VeiculoDAO daoVeiculo = new VeiculoDAO();

    /**
     * Registra um veículo no sistema.
     *
     * @param novoVeiculo objeto com os dados do veículo
     * @return true se o registro for concluído com sucesso, false caso contrário
     */
    public boolean registrar(Veiculo novoVeiculo) {
        if (novoVeiculo == null) {
            return false;
        }
        return daoVeiculo.cadastrar(novoVeiculo);
    }

    /**
     * Retorna todos os veículos cadastrados.
     *
     * @return lista de veículos
     */
    public List<Veiculo> obterTodos() {
        return daoVeiculo.listarVeiculos();
    }

    /**
     * Retorna os veículos pertencentes a um cliente específico.
     *
     * @param clienteId identificador do cliente
     * @return lista de veículos associados ao cliente
     */
    public List<Veiculo> obterPorCliente(int clienteId) {
        if (clienteId <= 0) {
            throw new IllegalArgumentException("ID de cliente inválido.");
        }
        return daoVeiculo.listarVeiculosPorCliente(clienteId);
    }

    /**
     * Conta quantos veículos estão cadastrados para determinado cliente.
     *
     * @param clienteId identificador do cliente
     * @return número de veículos cadastrados
     */
    public int totalPorCliente(int clienteId) {
        return daoVeiculo.contarVeiculosPorCliente(clienteId);
    }
}
