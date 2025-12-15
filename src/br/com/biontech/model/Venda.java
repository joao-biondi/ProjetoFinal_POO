package br.com.biontech.model;

public class Venda {
    private int id;
    private Cliente cliente; 
    private String data_venda;
    private double total_venda;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public String getData_venda() { return data_venda; }
    public void setData_venda(String data_venda) { this.data_venda = data_venda; }
    public double getTotal_venda() { return total_venda; }
    public void setTotal_venda(double total_venda) { this.total_venda = total_venda; }
}