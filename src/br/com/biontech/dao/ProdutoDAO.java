package br.com.biontech.dao;

import br.com.biontech.jdbc.ConnectionFactory;
import br.com.biontech.model.Fornecedor;
import br.com.biontech.model.Produto;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDAO {
    private final Connection con;

    public ProdutoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarProduto(Produto obj) {
        try {
            String sql = "INSERT INTO produtos (nome, preco_venda, estoque, fornecedor_id) VALUES (?,?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setDouble(2, obj.getPreco());
                stmt.setInt(3, obj.getEstoque());
                stmt.setInt(4, obj.getFornecedor().getId());
                
                stmt.execute();
            }
            JOptionPane.showMessageDialog(null, "Produto Salvo!");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    public Produto buscarPorCodigo(int id) {
        try {
            
            String sql = "select p.*, f.razao_social from produtos as p "
                       + "inner join fornecedores as f on (p.fornecedor_id = f.id) "
                       + "where p.id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Produto obj = new Produto();
            Fornecedor f = new Fornecedor();

            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setPreco(rs.getDouble("preco_venda"));
                obj.setEstoque(rs.getInt("estoque"));
                f.setId(rs.getInt("fornecedor_id"));          
                f.setRazaoSocial(rs.getString("razao_social"));

                obj.setFornecedor(f); 
            }
            return obj;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no DAO: " + e);
            return null;
        }
    }

    public void baixarEstoque(int id, int qtd_baixada) {
        try {
            String sql = "UPDATE produtos SET estoque = estoque - ? WHERE id = ?";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, qtd_baixada);
                stmt.setInt(2, id);
                stmt.execute();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na baixa de estoque: " + e);
        }
    }

    public void alterarProduto(Produto obj) {
        try {
            String sql = "UPDATE produtos SET nome=?, preco_venda=?, estoque=?, fornecedor_id=? WHERE id=?";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setDouble(2, obj.getPreco());
                stmt.setInt(3, obj.getEstoque());
                
                stmt.setInt(4, obj.getFornecedor().getId());
                
                stmt.setInt(5, obj.getId());
                
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e);
        }
    }

    public void excluirProduto(Produto obj) {
        try {
            String sql = "DELETE FROM produtos WHERE id = ?";
            
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, obj.getId());
                
                stmt.execute();
            }

            JOptionPane.showMessageDialog(null, "Produto Excluído com Sucesso!");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e);
        }
    }
}