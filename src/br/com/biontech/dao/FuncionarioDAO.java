package br.com.biontech.dao;

import br.com.biontech.jdbc.ConnectionFactory;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    private final Connection con;

    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public boolean efetuarLogin(String login, String senha) {
        try {
            String sql = "SELECT * FROM funcionarios WHERE login = ? AND senha = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos!");
                return false;
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return false;
        }
    }
}