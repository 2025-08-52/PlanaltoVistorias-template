package Vistoria.controller;

import Vistoria.dao.VistoriaDAO;
import Vistoria.dao.AgendamentoDAO;
import Vistoria.model.Vistoria;
import Vistoria.model.Agendamento;
import Vistoria.model.Funcionario;
import Vistoria.model.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VistoriaController {

    // DAO responsável pela persistência no banco de dados
    private VistoriaDAO vistoriaDAO = new VistoriaDAO();

    // Lista auxiliar simulando um "banco de dados" local (pode ser usada para testes)
    private List<Vistoria> listaVistorias = new ArrayList<>();

    // ==============================
    // MÉTODOS USANDO O BANCO DE DADOS
    // ==============================

    // Adicionar vistoria no banco de dados
    public void adicionarVistoriaBD(Vistoria vistoria) {
        try {
            vistoriaDAO.adicionarVistoria(vistoria);
            System.out.println("Vistoria adicionada com sucesso no banco de dados!");
        } catch (Exception e) {
            System.err.println("Erro ao adicionar vistoria: " + e.getMessage());
        }
    }

    // Listar vistorias do banco de dados
    public List<Vistoria> listarVistoriasBD() {
        try {
            List<Vistoria> vistorias = vistoriaDAO.listarVistorias();
            if (vistorias.isEmpty()) {
                System.out.println("Nenhuma vistoria encontrada no banco de dados.");
            }
            return vistorias;
        } catch (Exception e) {
            System.err.println("Erro ao listar vistorias: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Buscar vistoria por ID no banco
    public Vistoria buscarVistoriaBD(int id) {
        try {
            Vistoria vistoria = vistoriaDAO.buscarVistoriaPorId(id);
            if (vistoria == null) {
                System.out.println("Vistoria não encontrada no banco.");
            }
            return vistoria;
        } catch (Exception e) {
            System.err.println("Erro ao buscar vistoria: " + e.getMessage());
            return null;
        }
    }

    // Atualizar vistoria no banco
    public void atualizarVistoriaBD(Vistoria vistoria) {
        try {
            vistoriaDAO.atualizarVistoria(vistoria);
            System.out.println("Vistoria atualizada com sucesso no banco!");
        } catch (Exception e) {
            System.err.println("Erro ao atualizar vistoria: " + e.getMessage());
        }
    }

    // Remover vistoria no banco
    public void removerVistoriaBD(int id) {
        try {
            vistoriaDAO.removerVistoria(id);
            System.out.println("Vistoria removida com sucesso do banco!");
        } catch (Exception e) {
            System.err.println("Erro ao remover vistoria: " + e.getMessage());
        }
    }

    // ==============================
    // MÉTODOS USANDO LISTA LOCAL (TESTE)
    // ==============================

    public void adicionarVistoria(Vistoria vistoria) {
        listaVistorias.add(vistoria);
        System.out.println("Vistoria adicionada localmente com sucesso!");
    }

    public void listarVistorias() {
        if (listaVistorias.isEmpty()) {
            System.out.println("Nenhuma vistoria cadastrada localmente.");
        } else {
            for (Vistoria v : listaVistorias) {
                System.out.println("ID: " + v.getIdVistoria() +
                        " | Funcionário: " + v.getIdFuncionarios() +
                        " | Agendamento: " + v.getIdAgendamento() +
                        " | Data: " + v.getDataVistoria() +
                        " | Itens: " + v.getItensVerificados() +
                        " | Observação: " + v.getObservacao());
            }
        }
    }

    public Vistoria buscarVistoria(int id) {
        for (Vistoria v : listaVistorias) {
            if (v.getIdVistoria() == id) {
                return v;
            }
        }
        System.out.println("Vistoria não encontrada localmente.");
        return null;
    }

    public void atualizarVistoria(int id, LocalDate novaData, String novosItens, String novaObs) {
        Vistoria v = buscarVistoria(id);
        if (v != null) {
            v.setDataVistoria(novaData);
            v.setItensVerificados(novosItens);
            v.setObservacao(novaObs);
            System.out.println("Vistoria atualizada localmente com sucesso!");
        } else {
            System.out.println("Vistoria não encontrada para atualização.");
        }
    }

    public void removerVistoria(int id) {
        Vistoria v = buscarVistoria(id);
        if (v != null) {
            listaVistorias.remove(v);
            System.out.println("Vistoria removida localmente com sucesso!");
        } else {
            System.out.println("Vistoria não encontrada para remoção.");
        }
    }
}
 
