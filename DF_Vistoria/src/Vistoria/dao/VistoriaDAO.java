package Vistoria.dao;
import Vistoria.model.Vistoria;
import Vistoria.DB.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.Date;
public class VistoriaDAO {
	
	public boolean inserirVistoria(Vistoria vistoria) {
		 String sql = "INSERT INTO vistoria(Id_Funcionario, Id_Agendamento, Data_Vistoria, Itens_Verificados, Observacao) VALUES (?, ?, ?, ?, ?, ?)";
		 try (Connection conn = Conexao.getConnection();
				 PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			 stmt.setInt(1, vistoria.getFuncionario().getId_Funcionario());
			 stmt.setInt(2, vistoria.getAgendamento().getId());
			 stmt.setDate(3, vistoria.getDataVistoria());
			 stmt.setString(4, vistoria.getItensVerificados());
			 stmt.setString(5, vistoria.getObservacao());
			 int rowsAffected = stmt.executeUpdate();
			 
			 //vistoria.setDataVistoria(Date.valueOf("2025-09-12"));
			 
			 try(ResultSet rs = stmt.getGeneratedKeys()){
				 if(rs.next()) {
					 int idVistoria = rs.getInt(1);
					 
				 }
				 
			 }
			 return rowsAffected > 0;
		 }
	}catch() {
		
		
	}
	
}

