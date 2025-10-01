package model;

import java.math.BigDecimal;
import java.sql.Date;

//Criando a entidade de pagamento
public class PagamentoController {

	
	//Construtor vazio para recber parametros
	public PagamentoController() {
		
	}
	
	//colocando os atributos de pagamento
	private int idCliente;
	private  int idVistoria;
	private BigDecimal valor;
	private Date dataPagamento;
	private String formaPagamento;
	private String statusPagamento;
	
	
	//Colocando os getters e setters da entidade
	public int getIdCliente() {
		return this.idCliente;
		
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
		
	}
	
	public int getIdVistoria() {
		return this.idVistoria;
		
	}
	public void setIdVistoria(int idVistoria) {
		this.idVistoria = idVistoria;
		
	}
	
	public BigDecimal getValor() {
		return this.valor;
		
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
		
	}
	
	public Date getDataPagamento() {
		return this.dataPagamento;
		
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
		
	}
	
	public String getFormaPagamento() {
		return this.formaPagamento;
		
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
		
	}
	
	public String getStatusPagamento() {
		return this.statusPagamento;
		
	}
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
		
	}
	
	

}
