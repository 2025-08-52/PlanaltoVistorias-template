
package Vistoria.controller;

import Vistoria.model.
import Vistoria.model.Agendamento;
import Vistoria.model.Cliente;
import Vistoria.model.Veiculo;
import Vistoria.model.Funcionario;
import java.sql.Date;
import java.util.List;

public class Fncionario {
	private AgendamentoDAO dao();

	public AgendamentoController() {
		dao = new AgendamentoDao();

	}

	public void cadastrarAgendamento(Agendamento agendamento) {
		if (agendamento.getCliente() == null || agendamento.getVeiculo() == null
				|| agendamento.getFuncionario() == null | agendamento.getData_Agendamento() == null
				|| agendamento.getTipo_Servico().isEmpty()) {
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

	public void atualizarAgendamento(Agendamento agendamento) {
		if (agendamento.getCliente() == null || agendamento.getVeiculo() == null
				|| agendamento.getFuncionario() == null | agendamento.getData_Agendamento() == null
				|| agendamento.getTipo_Servico().isEmpty()) {
			System.out.println("Todos os campos sao obrigatorios.");
			return;
		}
		if (agendamento.getTipo_Servico().length() < 3) {
			System.out.println("Tipo de serviço deve ter pelo menos 3 caracteres.");
			return;
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
		 
		 if(agendamentoEncontrado !=null) {
			 System.out.println("---- Detalhes do Agendamento ----");
			 System.out.println("Id:" + agendamentoEncontrado.getId());
			 System.out.println("Cliente Id:" + agendamentoEncontrado.getCliente().getId_Cliente());
			 System.out.println("Funcionario Id" + agendamentoEncontrado.getFuncionario().getId_Funcionario());
			 System.out.println("Veiculo Id" + agendamentoEncontrado.getVeiculo().getId_Veiculo());
			 System.out.println("Data:") + agendamentoEncontrado.getData_Agendamento());
			 System.out.println("Tipo_Servico Id" + agendamentoEncontrado.getIdTipo_Servico()); 
		 }else {
			 System.out.println("nao foi possivel encontrar o Id:" + id);
		 }
	}

	public void agendamento(int ClienteId, int FuncionarioId, int veiculoId, Date Data_Agendamento,
			string Tipo_Servico) {

		Cliente cliente = new Cliente();
		cliente.setId(ClienteId);

		Funcionario funcionario = new Funcionario();
		funcionario.setId(funcionario);

		Veiculo veiculo = new Veiculo();
		veiculo.setId(Veiculo);

		Agendamento agendamento = new Agendamento();
		Agendamento.setCliente(Cliente);
		Agendamento.setFuncionario(Funcionario);
		Agendamento.setVeiculo(Veiculo);
		Agendamento.setData_Agendamento(Data_Agendamento);
		Agendamento.setTipo_Servico(Tipo_Servico);

	}

}


