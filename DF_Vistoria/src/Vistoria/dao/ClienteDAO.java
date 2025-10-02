package dao;

//importando os pacotes e classes necessarios
import db.Conexao;
import model.PagamentoController;
import java.sql.*;
import model.Cliente;

public class ClienteDAO {
	//metodo para cadastrar cliente
	public static void cadastrarCliente(Cliente cliente) {
		//codigo sql que vai ser executado
		String sql = "INSERT INTO Clientes (Nome, Cpf, Telefone, Email) VALUES (?, ?, ?, ?)";
		//tentativa de conectar com o banco e executar o comando sql, com try e catch
		try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){
			
			//inserindo os dados dentro do db
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, cliente.getTelefone());
			stmt.setString(4, cliente.getEmail());
			
			 
			
			//comando para realmente executar o codigo
			stmt.executeUpdate();
			
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
		        if (generatedKeys.next()) {
		            int idGerado = generatedKeys.getInt(1);
		            cliente.setId(idGerado);  // Atualiza o objeto cliente com o ID do banco
		        } else {
		            throw new SQLException("Falha ao obter o ID gerado.");
		        }
		    } 
			
			
		}catch(SQLException e) {
			System.err.println("Erro ao cadastrar cliente "+ e.getMessage());
			
		}
	}
	


}

