package Vistoria.main;
import Vistoria.model.Cliente;
import Vistoria.model.Funcionario;
import Vistoria.model.Veiculo;
import Vistoria.dao.VeiculoDAO;
import Vistoria.dao.ClienteDAO;
import Vistoria.dao.FuncionarioDAO;
import java.util.*;

public class Cadastro {
	
	private static VeiculoDAO veiculoDAO = new VeiculoDAO();
    private static ClienteDAO clienteDAO = new ClienteDAO();
    private static FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 System.out.println(" === Planalto Vistorias ===");
		 while(true) {
			 System.out.println("=== Menu Principal ===");
			 System.out.println("1 - Cadastrar Cliente");
			 System.out.println("2 -  Cadastrar Veiculo");
			 System.out.println("3 - Cadastrar Funcionarios");
			 System.out.println("4 - Listar Clientes e Veiculos");
			 System.out.println("5 - Listar Funcionarios");
			 System.out.println("6 - Sair");
			 
			 int opcao = scanner.nextInt();
	            scanner.nextLine();
	            
	      switch (opcao) {
	      
	      case 1: cadastrarCliente(scanner); 
	      break;
	      
	      case 2: cadastrarVeiculo (scanner);
	      break;
	      
	      case 3: cadastrarFuncionario (scanner);
	      break;
	      
	      case 4: ListarClienteEVeiculo();
	      break;
	      
	      case 5: ListarFuncionario();
	      break;
	      
	      case 6: System.out.println("Encerrando.. ");
	      scanner.close();
	      return;
	      default: System.out.println("Opcao invalida... tente novamente");
	    	  
	      
	      
	      }
		 }
	}
	 private static void cadastrarCliente(Scanner scanner) {
		 System.out.println("=== Cadastro de Clientes ==");
		 
		System.out.println("Nome:");
		String nome = scanner.nextLine();
		
		System.out.println("Cpf");
		String Cpf = scanner.nextLine();
		
		System.out.println("Telefone");
		String Telefone = scanner.nextLine();
		
		System.out.println("Email");
		String Email = scanner.nextLine();
		
		Cliente cliente = new Cliente(nome, cpf, telefone, email, endereco);
		
		System.out.println(" Cliente cadastrado! ID: " + Cliente.getId_Cliente
());
		 
	 }
	 
	 private static void cadastrarVeiculo (Scanner scanner) {
		 System.out.println("=== Cadastrar Veiculo ===");
		 
		 System.out.println("Placa:");
		 String Placa = scanner.nextLine();
		 
		 System.out.println("Marca:");
		 String Marca = scanner.nextLine();
		 
		 System.out.println("Modelo:");
		 String Modelo = scanner.nextLine();
		 
		 System.out.println("Ano");
		 String Ano = scanner.nextLine();
		 
		 System.out.println("Numero_chassi:");
		 String Numero_chassi = scanner.nextLine();
		 
		 
		    Veiculo veiculo = new Veiculo(placa, marca, modelo, ano, chassi);
		    VeiculoDAO.cadastrarVeiculo(veiculo);
		}
	 
	 private static void cadastrarFuncionario (Scanner scanner) {
		 System.out.println(" === Cadastrar funcionario ===");
		 
		 System.out.println("Nome:");
		 String nome = scanner.nextLine();
		 
		 System.out.println("Cpf:");
		 String Cpf = scanner.nextLine();
		 
		 System.out.println("Cargo:");
		 String Cargo = scanner.nextLine();
		 
		 System.out.println("Telefone:");
		 String Telefone = scanner.nextLine();
		 
		 Funcionario funcionario = new Funcionario(nome, cpf, cargo, telefone);
		 FuncionarioDAO = cadastrarFuncionario(funcionario); 
		 
	 }
	 
	 private static void ListarClienteEVeiculo() {
		 System.out.println(" === Clientes e Veiculos ===");
		 
		 List<Cliente> ListaCliente = ClienteDAO.pegarCliente();
		 System.out.println("== Cliente ==(" + ListaCliente.size() + ") -");
		 
		 if(ListaCliente.isEmpty()) {
			 System.out.println("Nenhum Cliente Cadastrado");
			 
		 }else {
			 for(Cliente c: ListaCliente) {
				 System.out.println(" ID:" + C.getId_Cliente() + "-" + c.getNome() + "Cpf" + c.getCpf());
				 
			 }
		 }
		 
		 List<Veiculo> ListaVeiculo = VeiculoDAO.listaVeiculo();
		 System.out.println("== Veiculos (" + ListaVeiculo.size() + "-");
		 
		 if (ListaVeiculo.isEmpty()) {
			 System.out.println("Nenhum Veiculo Cadastrado.");
			 
		 }else {
			 for(Veiculo v: ListaVeiculo) {
				 System.out.println("ID:" + V.getId_Veiculo() + "-" + v.getPlaca() + "-" + v.getMarca() + "-"  v.getModelo());
				 
				 
			 }
		 }
		 
		 
		 
	 }
	

}

