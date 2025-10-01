package model;

//Criando a entidade de pagamento
public class PagamentoController {
	
	//colocando os atributos de pagamento
	private int idCliente;
	private  int idVistoria;
	private double valor;
	private String dataPagamento;
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
	
	public double getValor() {
		return this.valor;
		
	}
	public void setValor(double valor) {
		this.valor = valor;
		
	}
	
	public String getDataPagamento() {
		return this.dataPagamento;
		
	}
	public void setDataPagamento() {
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
	public void setStatusPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
		
	}
	
	

}
