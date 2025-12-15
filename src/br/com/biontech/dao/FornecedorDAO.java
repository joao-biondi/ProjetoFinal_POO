package br.com.biontech.dao;

import br.com.biontech.jdbc.ConnectionFactory;
import br.com.biontech.model.Fornecedor;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorDAO {
    private final Connection con;

    public FornecedorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarFornecedor(Fornecedor obj) {
        try {
            String sql = "INSERT INTO fornecedores (razao_social, cnpj, contato) VALUES (?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getRazaoSocial());
                stmt.setString(2, obj.getCnpj());
                stmt.setString(3, obj.getContato());
                
                stmt.execute();
            }
            JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public List<Fornecedor> listarFornecedores() {
        try {
            List<Fornecedor> lista = new ArrayList<>();
            String sql = "SELECT * FROM fornecedores";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Fornecedor obj = new Fornecedor();
                obj.setId(rs.getInt("id"));
                obj.setRazaoSocial(rs.getString("razao_social"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setContato(rs.getString("contato"));
                lista.add(obj);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public void alterarFornecedor(Fornecedor obj) {
        try {
            String sql = "UPDATE fornecedores SET razao_social=?, cnpj=?, contato=? WHERE id=?";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getRazaoSocial());
                stmt.setString(2, obj.getCnpj());
                stmt.setString(3, obj.getContato());
                stmt.setInt(4, obj.getId());
                
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Fornecedor Alterado com Sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e);
        }
    }

    public void excluirFornecedor(Fornecedor obj) {
        try {
            String sql = "DELETE FROM fornecedores WHERE id = ?";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, obj.getId());
                
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Fornecedor Excluído com Sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e);
        }
    }
    
    public br.com.biontech.model.Fornecedor buscarPorId(int id) {
        try {
            String sql = "SELECT * FROM fornecedores WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            br.com.biontech.model.Fornecedor obj = new br.com.biontech.model.Fornecedor();
            
            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setRazaoSocial(rs.getString("razao_social"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setContato(rs.getString("contato"));
            }
            return obj;
        } catch (SQLException e) {
            return null;
        }
    }
}