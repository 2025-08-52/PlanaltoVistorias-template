package Controller;

import java.time.LocalDate;
import model.vistoria;
import java.util.ArrayList;
import java.util.List;

public class VistoriaController {

    // Lista simulando um "banco de dados"
    private List<Vistoria> listaVistorias = new ArrayList<>();

    // Cadastrar nova vistoria
    public void adicionarVistoria(Vistoria vistoria) {
        listaVistorias.add(vistoria);
        System.out.println("Vistoria adicionada com sucesso!");
    }

    // Listar todas as vistorias
    public void listarVistorias() {
        if (listaVistorias.isEmpty()) {
            System.out.println("Nenhuma vistoria cadastrada.");
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

    // Buscar vistoria pelo ID
    public Vistoria buscarVistoria(int id) {
        for (Vistoria v : listaVistorias) {
            if (v.getIdVistoria() == id) {
                return v;
            }
        }
        System.out.println("Vistoria não encontrada.");
        return null;
    }

    // Atualizar vistoria
    public void atualizarVistoria(int id, LocalDate novaData, String novosItens, String novaObs) {
        Vistoria v = buscarVistoria(id);
        if (v != null) {
            v.setDataVistoria(novaData);
            v.setItensVerificados(novosItens);
            v.setObservacao(novaObs);
            System.out.println("Vistoria atualizada com sucesso!");
        }
    }

    // Remover vistoria
    public void removerVistoria(int id) {
        Vistoria v = buscarVistoria(id);
        if (v != null) {
            listaVistorias.remove(v);
        }
    }
}
 
