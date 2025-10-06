
package Vistoria.controller;

import Vistoria.dao.AgendamentoDAO;
import Vistoria.model.Agendamento;
import Vistoria.model.Cliente;
import Vistoria.model.Veiculo;
import Vistoria.model.Funcionario;
import java.sql.Date;
import java.util.List;

public class AgendamentoController {
	private AgendamentoDAO dao();

	public AgendamentoController() {
		dao = new AgendamentoDao();

	}

	public void cadastrarAgendamento(Agendamento agendamento) {
		if (agendamento.getCliente() == null | agendamento.getVeiculo() == null | agendamento.getFuncionario() == null
				| agendamento.getData_Agendamento() == null | agendamento.getTipo_Servico().isEmpty()) {
			System.out.println("Todos os campos são obrigatórios.");
			return;
		}
		if (agendamento.Tipo_Servico().lenght() < 3) {
			System.out.println("Tipos de serviço deve ter pelo menos 3 caracteres.");
			return;

		}

		Date agora = new Date();
		int comparacao = agendamento.getData_Agendamento().compareTo(agora);

		if (comparacao < 0) {
			System.out.println("Data do agendamento não pode ser no passado.");
			return;
		}

		dao.inserir(agendamento);

	}

	public void listarAgendamento() {
		List<Agendamento> agendamento = dao.listar();
		if (agendamento.isEmpty()) {
			System.out.println("Nenhum agendamento cadastrado.");
			return;

		}
		for (Agendamento a : agendamento) {
			System.out.println("Id:" + a.getId() + "| Cliente ID:" + a.getCliente().getId_Cliente() + "| Veiculo ID:"
					+ a.getVeiculo().getId_Veiculo() + "| Funcionario ID:" + a.getFuncionario().getId_Funcionario()
					+ "|Data:" + a.getData_Agendamento() + "| Serviço: " + a.getTipo_Servico());
		}
	}

	public void atualizarAgendamento(Agendameno agendamento) {
		 if (agendamento.getCliente() == null  | agendamento.getVeiculo() == null |
				 agendamento .get Funcionario() == null |agendamento.getData_Agendamento() == null |
				 agendamento.getTipo_Servico().isEmpty()) {
			 System.out.println("Todos os campos sao obrigatorios.");
			 return;
		 }
		 if (agendamento.getTipo_Servico().length() <3) {
			 System.out.println("Tipo de serviço deve ter pelo menos 3 caracteres.");
			 return:
		 }
		 dao.atualizar(agendamento);
		 
	 }

	public void excluirAgendamento(int id) {
		dao.excluir(id);
	}

	public void exibirAgendamento(int id) {
		 List<Agendamento> agendamento = dao.listar();
		 agendamento agendamentoEncontrado = null;
		 
		 for (agendamento a: agendamento) {
			 if (a.getId() == id) {
				 agendamentoEncontrado = a;
				 break;
				 
			 }
		 }
		 
		 if(agendamentoEncontrado !- null) {
			 System.out.println("---- Detalhes do Agendamento ----");
			 System.out.println("Id:" + agendamentoEncontrado.getId());
			 S
		 }
		
	}
}
