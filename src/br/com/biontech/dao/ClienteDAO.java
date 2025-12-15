package br.com.biontech.dao;

import br.com.biontech.jdbc.ConnectionFactory;
import br.com.biontech.model.Cliente;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {
    private final Connection con;

    public ClienteDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarCliente(Cliente obj) {
        try {
            String sql = "INSERT INTO clientes (nome, cpf, telefone, endereco) VALUES (?,?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getCpf());
                stmt.setString(3, obj.getTelefone());
                stmt.setString(4, obj.getEndereco());
                
                stmt.execute();
            }
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public List<Cliente> listarClientes() {
        try {
            List<Cliente> lista = new ArrayList<>();
            String sql = "SELECT * FROM clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente obj = new Cliente();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setEndereco(rs.getString("endereco"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public void alterarCliente(Cliente obj) {
        try {
            String sql = "UPDATE clientes SET nome=?, cpf=?, telefone=?, endereco=? WHERE id=?";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getCpf());
                stmt.setString(3, obj.getTelefone());
                stmt.setString(4, obj.getEndereco());
                stmt.setInt(5, obj.getId()); 
                
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e);
        }
    }

    public void excluirCliente(Cliente obj) {
        try {
            String sql = "DELETE FROM clientes WHERE id = ?";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, obj.getId());
                
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Cliente Excluído com Sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e);
        }
    }

    public br.com.biontech.model.Cliente buscarPorId(int id) {
        try {
            String sql = "SELECT * FROM clientes WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            br.com.biontech.model.Cliente obj = new br.com.biontech.model.Cliente();
            
            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setEndereco(rs.getString("endereco"));
            }
            return obj;
            
        } catch (SQLException e) {
            return null;
        }
    }
    
     public br.com.biontech.model.Cliente buscarPorCpf(String cpf) {
        try {
            // Comando SQL
            String sql = "SELECT * FROM clientes WHERE cpf = ?";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            java.sql.ResultSet rs = stmt.executeQuery();
            br.com.biontech.model.Cliente obj = new br.com.biontech.model.Cliente();
            
            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setEndereco(rs.getString("endereco"));
            }
            return obj;
            
        } catch (SQLException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
}