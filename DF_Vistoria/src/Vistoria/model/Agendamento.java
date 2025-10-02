package Vistoria.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Agendamento {

    private Integer id;
    private LocalDate data;
    private LocalTime hora;
    private Status status;

    private Cliente cliente;
    private Veiculo veiculo;

    public enum Status {
        PENDENTE,
        CONFIRMADO,
        CANCELADO,
        REALIZADO
    }

    // Construtor padrão
    public Agendamento() {
        this.status = Status.PENDENTE;
    }

    // Construtor com relacionamentos
    public Agendamento(Integer id, LocalDate data, LocalTime hora, Status status, Cliente cliente, Veiculo veiculo) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    // Construtor sem ID (útil para inserções novas)
    public Agendamento(LocalDate data, LocalTime hora, Cliente cliente, Veiculo veiculo) {
        this.data = data;
        this.hora = hora;
        this.status = Status.PENDENTE;
        this.cliente = cliente;
        this.veiculo = veiculo;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    // Métodos auxiliares de negócio
    public void confirmar() {
        this.status = Status.CONFIRMADO;
    }

    public void cancelar() {
        this.status = Status.CANCELADO;
    }

    public void realizar() {
        this.status = Status.REALIZADO;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", data=" + data +
                ", hora=" + hora +
                ", status=" + status +
                ", cliente=" + (cliente != null ? cliente.getNome() : "null") +
                ", veiculo=" + (veiculo != null ? veiculo.getPlaca() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Agendamento)) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

