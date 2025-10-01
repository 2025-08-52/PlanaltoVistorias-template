package dao;

//importando as classes necessárias para realizar o dao
import java.sql.*;
import model.PagamentoController;
import DB.Conexao;
import java.math.BigDecimal;


public class PagamentoDAO {
	//Criando o objeto para acessa-lo
	PagamentoController pagamento = new PagamentoController();
	
	//Criando o metodo para cadastrar uma forma de pagamento dentro do banco de dados
	public void cadastrarPagamento() {
		
		//Instanciado o comando sql
		String sql = "INSERT INTO Pagamento (Id_Clientes, Id_Vistoria, Valor, Data_Pagamento, Forma_Pagamento, Status_Pagamento) VALUES "
		+ "(?, ?, ?, ?, ?, ?)";
		
		//adicionando o try catch para inserir os dados dentro do banco
		try(Connection conn = Conexao.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)){
			
			//inserindo os dados de acordo com o tipo dele
			stmt.setInt(1, pagamento.getIdCliente());
			stmt.setInt(2, pagamento.getIdVistoria());
			stmt.setBigDecimal(3, pagamento.getValor());
			stmt.setDate(4, pagamento.getDataPagamento());
			stmt.setString(5, pagamento.getFormaPagamento());
			stmt.setString(6, pagamento.getStatusPagamento());
			
			//executando os dados
			stmt.executeUpdate();
			
			
		}catch(SQLException e) {//Caso acontece algum erro, vai entrar dentro do catch
			System.err.println("Erro ao inserir dados no banco de dados"+ e.getMessage());
			
		}
		
	}
	
	public void main(String[] args) {
		String valorDigitado = "500.00";
		BigDecimal valor = new BigDecimal(valorDigitado);
		
		pagamento.setValor(valor);
		
		String dataDigitada = new String("27/10/1991");
		
		
		
		
	}
	
	

}
