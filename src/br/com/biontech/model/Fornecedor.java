package br.com.biontech.model;

public class Fornecedor {
    private int id;
    private String razaoSocial;
    private String cnpj;
    private String contato;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    @Override
    public String toString(){
        return this.getRazaoSocial();
    }
}