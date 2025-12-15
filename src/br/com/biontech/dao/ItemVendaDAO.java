package br.com.biontech.dao;

import br.com.biontech.jdbc.ConnectionFactory;
import br.com.biontech.model.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ItemVendaDAO {
    private final Connection con;

    public ItemVendaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarItem(ItemVenda obj) {
        try {
            String sql = "INSERT INTO itens_venda (venda_id, produto_id, qtd, subtotal) VALUES (?,?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, obj.getVenda().getId());
                stmt.setInt(2, obj.getProduto().getId());
                stmt.setInt(3, obj.getQtd());
                stmt.setDouble(4, obj.getSubtotal());
                
                stmt.execute();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Item: " + e);
        }
    }
}