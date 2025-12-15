package br.com.biontech.dao;

import br.com.biontech.jdbc.ConnectionFactory;
import br.com.biontech.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class VendaDAO {
    private final Connection con;

    public VendaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarVenda(Venda obj) {
        try {
            String sql = "INSERT INTO vendas (cliente_id, data_venda, valor_total) VALUES (?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, obj.getCliente().getId());
                stmt.setString(2, obj.getData_venda());
                stmt.setDouble(3, obj.getTotal_venda());
                
                stmt.execute();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro Venda: " + e);
        }
    }

    public int retornaUltimaVenda() {
        try {
            int idvenda = 0;
            String sql = "SELECT MAX(id) id FROM vendas";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                idvenda = rs.getInt("id");
            }
            return idvenda;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}