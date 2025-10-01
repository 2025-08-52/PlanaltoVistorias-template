package Vistoria.model;

import java.time.LocalDate;

public class Vistoria {
	private int idVistoria;
	private int idFuncionarios;
	private int idAgendamento;
	private LocalDate dataVistoria;
	private String itensVerificados;
	private String observacao;

public Vistoria() {
}
public Vistoria(int idVistoria, int idFuncionarios, int idAgendamento,LocalDate dataVistoria, String itensVerificados, String observacao) {
	super();
	this.idVistoria = idVistoria;
	this.idFuncionarios = idFuncionarios;
	this.idAgendamento = idAgendamento;
	this.dataVistoria = dataVistoria;
	this.itensVerificados  = itensVerificados;
	this.observacao = observacao;
}

//get's
public int getIdVistoria() {
    return idVistoria;
}

public int getIdFuncionarios() {
    return idFuncionarios;
}

public int getIdAgendamento() {
    return idAgendamento;
}

public LocalDate getDataVistoria() {
    return dataVistoria;
}

public String getItensVerificados() {
    return itensVerificados;
}

public String getObservacao() {
    return observacao;
}

//set's

public void setIdVistoria(int idVistoria) {
    this.idVistoria = idVistoria;
}

public void setIdFuncionarios(int idFuncionarios) {
    this.idFuncionarios = idFuncionarios;
}

public void setIdAgendamento(int idAgendamento) {
    this.idAgendamento = idAgendamento;
}

public void setDataVistoria(LocalDate dataVistoria) {
    this.dataVistoria = dataVistoria;
}

public void setItensVerificados(String itensVerificados) {
    this.itensVerificados = itensVerificados;
}

public void setObservacao(String observacao) {
    this.observacao = observacao;
}
}
